<div align="center">
<div>
    <h1>UIKit</h1>
</div>
<div>
    <p>简体中文 | <a href="README.en.md">English</a>
</div>

<span>
    <a href="LICENSE.txt"><img src="https://img.shields.io/github/license/MillenTec/UIKit" alt="License" /></a>
    <a href="https://github.com/MillenTec/UIKit/releases/latest"><img src="https://img.shields.io/github/release/MillenTec/UIKit" alt="Release" /></a>
</span>
</div>

---

UIKit 是一个以 Fluent Design 为基础，融合了 Apple 设计精神的一个现代、简约的 Compose Multiplatform 组件库，致力于在 Windows 与 Android 两主要平台上打造出 Apple iOS 级别的视觉与交互体验；绝大多数组件完全自绘，在多端呈现一致的视觉与交互体验，同时对于部分控件做出桌面端与移动端差异性，以提高跨平台应用的交互体验

如果你希望在 Compose Multiplatform 中快速尝试 Material Design 之外的设计风格，UIKit 一定能满足你的需求

## 1.项目概述
当前 UIKit 仍处于开发阶段，控件尚不齐全

### 1.1.特性
- **跨平台一致性：** 所有组件核心代码均在 commonMain 中使用纯 Compose 实现，需要的平台特性均在其余平台提供了 Fallback
- **快捷调用与高自定义性：** 大部分控件提供了多层 API，既可以使用简单几行代码创建一个漂亮的默认配置控件，也可以使用更底层的 API 实现更多属性的自定义
- **完整的主题体系：** `UIKitTheme` 提供了颜色、排版、形状、布局、动画、材质六项可自定义的可变主题，默认内置了亮色与暗色配置，你只需使用 `UIKitThemeHost` 包裹你的应用根并传入主题配置，你就可以在应用的任何地方使用 `getUIKitTheme` 获取并使用主题
- **流畅的动画系统：** UIKit 主张一切都拥有过渡，动画与过渡动画渗透了 UIKit 的每一处设计
- **丰富的图标集：** UIKit 内置图标集基于 [FluentUI System Icons](https://github.com/microsoft/fluentui-system-icons)，并在其基础上深入设计，提供了**分层图标**、**动画图标**等更多元化的图标体系

### 1.2.支持的平台
| 平台 | 支持情况 |
| ---- | -------- |
| Android (minSdk 24) | 🟢 |
| iOS | 🟡 (大部分支持) |
| Windows (JVM) | 🟢 |
| macOS (JVM) | 🟡 (理论完全支持) |
| Linux (JVM) | 🟡 (理论完全支持) |

当前 UIKit 专注于 **Android** 及 **Windows (JVM)** 平台，Android 平台（移动端）优先

由于我并没有 Mac 或 iPhone 设备，无法测试及开发 iOS 平台，虽项目绝大多数为 Compose 跨平台自绘，但缺少实机测试的 iOS 平台中兼容性及使用体验存疑

如果你拥有一台 Mac 设备且了解 iOS 开发，并且对此项目感兴趣的话，欢迎对此项目做出一份贡献

macOS 及 Linux 端同样没有经过实机测试，不过由于同属 JVM，故绝大多数内容不会有问题

## 2.快速开始
你可以使用 JetBrains IntelliJ IDEA 打开此项目，并确保你已经安装并配置 `JDK`、`Gradle` 以及 `Kotlin Multiplatform` 扩展，该项目开发时的 JDK 及 Gradle 版本如下（推荐）：
- **JDK 21**
- **Gradle 9.5**

等待 Gradle 完成加载后，你可以直接启动 `*Example` 或在你的项目中使用

当前 UIKit 还未发布到 `Maven`，你可以将其发布到本地并引用：
```sh
git clone https://github.com/MillenTec/UIKit.git
cd UIKit/src
./gradlew :uikitMain:publishToMavenLocal
```
然后在你需要引用 UIKit 的项目中：
```kt
// settings.gradle.kts - 仓库配置
repositories {
    mavenLocal()
    // ... 其他仓库
}

// build.gradle.kts - 依赖配置（commonMain）
dependencies {
    implementation("com.millentec.uikit:uikit:0.0.1-dev")
}
```

然后重新同步 Gradle 项目，测试 UIKit 能否正常使用

## 3.设计
### 3.1.主题系统
在 UIKitTheme 中，你可以通过 `getLight()` 或 `getDark()` 来获取默认的亮色或暗色主题并传入 UIKitThemeHost 中，直接创建 UIKitTheme 实例即默认为亮色主题
```kt
@Composable
fun App() {
    UIKitThemeHost(UIKitTheme.getLight()) {
        Box(
            Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush)
            )
    }
}
```
UIKitThemeHost 本质是一个 `CompositionLocalProvider`，访问主题的 `getUIKitColors()` 写法等价于 `UIKitTheme.LocalTheme.current.colors`；若在应用上层没有使用 UIKitThemeHost 包裹，那么 `getUIKitTheme` 默认为亮色

你可以在你的应用程序中创建一个可观察属性并将其传入 UIKitThemeHost，通过改变它以改变主题
```kt
@Composable
fun App() {
    val checked = remember { mutableStateOf(false) }

    UIKitThemeHost(
        if (checked.value) UIKitTheme.getDark() else UIKitTheme.getLight()
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(getUIKitColors().contentFillColorPrimaryBrush)
        ) {
            UIKitToggleSwitch(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = it
                }
            )
        }
    }
}
```

### 3.2.图标
UIKit 提供了大量基于 [FluentUI System Icons](https://github.com/microsoft/fluentui-system-icons) 的图标，绝大多数以 `ImageVector` 的形式提供调用

#### 3.2.1.静态图标

我对这些图标一个个进行了人工分层，原本的 FluentUI System Icons 为单色单层的填充图标，现在你可以选择将其分层并给每层填充不同的颜色

![分层与单层图标](img/readme_icons_layered_compare.svg "分层与非分层图标")

现在你可以在 `FluentIcons` 下访问所有 Regular (非填充) 静态图标, 或在 `FluentIcons.Filled` 下访问所有 Filled (填充) 静态图标；静态图标分为**可分层静态图标**与**不可分层静态图标**，对于不可分层静态图标你可以直接调用：
```kt
FluentIcons.Accessibility
```
对于可分层静态图标提供了三层 API：
```kt
// 这是最简单的 API 会返回一个单色未分层的图标, 默认颜色为 0xFF1D1D1F
FluentIcons.addCircle()

// 传入的 color 参数为基础颜色, layered 参数如果为 true 则表示开启分层，会返回一个的给不同层施加不同透明度的图标, 如果为 false 则等效于第一个 API 只不过可以自定义颜色
// 若要使用分层图标, 一般建议使用此 API
FluentIcons.addCircle(
    color = getUIKitColors().highlightColorPrimaryBrush,
    layered = true
)

// 此 API 最底层, 允许传入每一层的画刷, 根据实际图标的情况可能有多个参数
FluentIcons.addCircle(
    primary = SolidColor(getUIKitColors().highlightColorPrimaryBrush),
    secondary = SolidColor(getUIKitColors().highlightColorPrimaryBrush.copy(alpha = 0.6f))
)
```

#### 3.2.2.动画图标
在 `FluentIcons.AnimatableIcons` 下包含一些动画图标，它们不是 ImageVector 类型，是一个可组合项，由 Canvas 驱动，你可以使用 `Modifier.size` 设置它的尺寸，整体会等比例缩放

#### 3.2.3.可变图标
在 `FluentIcons.ResizableIcons` 下包含一些可改变线宽的图标，它们是 ImageVector 类型

### 3.3.材质
在 UIKit 中提供了 `AcrylicMaterial`, 它包含一个背景模糊和边缘高光，可以在 `UIKitAcrylicMaterial` 中配置默认属性

背景模糊效果由开源库 [Cloudy](https://github.com/skydoves/Cloudy) 支持

![亚克力效果](img/readme_materials_acrylic_dark_light.webp)
> [!TIP]
> 亚克力效果展示图片中的背景图片来自 [Pixabay](https://pixabay.com/zh/photos/beach-cliff-bay-sea-ocean-418742/)（[使用许可](https://pixabay.com/service/license-summary/)）

要使用亚克力材质，应该先使用 `rememberAcrylicMaterialState` 创建一个 State，然后设置 Source 并为容器添加材质
```kt
Box {
    val state = rememberAcrylicMaterialState()

    Box(
        modifier = Modifier
            .acrylicMaterialSource(state)
    ) { 
        // ...
    }

    Box(
        modifier = Modifier
            .acrylicMaterial(state = state)
    ) {
        // ... 
    }
}
```

> [!IMPORTANT]
> 绝对不能在 AcrylicMaterialSource 的子级使用同一个 State 的 AcrylicMaterial，即一个 AcrylicMaterial 的 Source 不能是自己，否则会导致程序崩溃：
> ```kt
> Box {
>    val state = rememberAcrylicMaterialState()
>
>    Box(
>        modifier = Modifier
>            .acrylicMaterialSource(state)
>    ) { 
>        Box(
>           modifier = Modifier
>               .acrylicMaterial(state = state)  // ❌ 这么做会导致程序崩溃
>        ) {
>            // ... 
>        }
>    }
> }
> ```

## 4.许可证
本项目基于 **[MIT License](LICENSE.txt)** 开源，这意味着你获得了：
- 在不受限制的情况下处理本软件的权利，包括但不限于**使用、复制、修改、合并、发布、分发、再许可和/或销售**软件副本

但是你应当:
- **保留版权声明：** 版权声明和许可声明应包含在软件的所有副本或主要部分中

同时 UIKit 离不开开源社区的支持，UIKit 使用的所有第三方开源软件及其许可证在 [THIRD_PARTY.txt](THIRD_PARTY.txt) 列出

## 5.关于我
我是来自中国的一名高中生，一名科技爱好者，编程爱好者，独立学习并开发软件，爱好二次元、动漫；我在今年（2026年）5月份时初识了 Kotlin 这门语言和 Compose Multiplatform 框架，并喜欢上了这种声明式 UI 框架，从此开始深入学习和使用此语言和框架，并于同年7月初中学业水平考试结束后开始投入到 UIKit 的开发

### 5.1.联系我
- MillenTec@outlook.com
- [GitHub](https://github.com/MillenTec)
- [Gitee](https://gitee.com/MillenTec)
- [bilibili](https://space.bilibili.com/3546591566760474)

如果你喜欢 UIKit 的话，请给我一个 Star 吧