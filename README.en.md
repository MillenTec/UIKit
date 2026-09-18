<div align="center">
<div>
    <h1>UIKit</h1>
</div>
<div>
    <p><a href="README.md">简体中文</a> | English</p>
</div>

<span>
    <a href="LICENSE.txt"><img src="https://img.shields.io/github/license/MillenTec/UIKit" alt="License" /></a>
    <a href="https://github.com/MillenTec/UIKit/releases/latest"><img src="https://img.shields.io/github/release/MillenTec/UIKit" alt="Release" /></a>
</span>
</div>

---

> [!TIP]
> The English version was translated by AI.

UIKit is a modern, minimalist Compose Multiplatform component library built on Fluent Design while incorporating Apple design principles. It is dedicated to delivering an Apple iOS-level visual and interactive experience across the two primary platforms: Windows and Android. Most components are completely self-drawn, providing a consistent visual and interactive experience across multiple platforms. At the same time, certain controls exhibit differences between desktop and mobile to improve the cross-platform user experience.

If you're looking to quickly explore a design language beyond Material Design in Compose Multiplatform, UIKit will certainly meet your needs.

## 1. Project Overview
UIKit is currently under development, and not all controls are complete.

### 1.1. Features
- **Cross-Platform Consistency:** All core component code is implemented purely with Compose in commonMain, with fallbacks provided on other platforms for platform-specific features.
- **Ease of Use and High Customizability:** Most controls offer multi-layered APIs, allowing you to create a beautiful control with default configuration in just a few lines of code, or use lower-level APIs for more extensive customization.
- **Complete Theming System:** `UIKitTheme` provides six customizable, mutable theme attributes: colors, typography, shapes, layout, animations, and materials. Light and dark configurations are built-in. Simply wrap your application root with `UIKitThemeHost` and provide your theme configuration, and you can access the theme anywhere in your app using `getUIKitTheme`.
- **Smooth Animation System:** UIKit advocates that everything should have transitions. Animations and transition effects permeate every aspect of UIKit's design.
- **Powerful Symbol System:** UIKit Symbols offers powerful animation capabilities and extensibility, and ships with a built-in symbol set based on [FluentUI System Icons](https://github.com/microsoft/fluentui-system-icons), further refined on top of it, providing symbols with **programmable animations**, **layered rendering**, and more.

### 1.2. Supported Platforms
| Platform | Support Status |
| -------- | -------------- |
| Android (minSdk 24) | 🟢 |
| iOS | 🟡 (Mostly supported) |
| Windows (JVM) | 🟢 |
| macOS (JVM) | 🟡 (Theoretically fully supported) |
| Linux (JVM) | 🟡 (Theoretically fully supported) |

UIKit currently focuses on **Android** and **Windows (JVM)** platforms, with priority given to Android (mobile).

Since I do not own a Mac or iPhone device, I am unable to test or develop for the iOS platform. Although the vast majority of the project is self-drawn with Compose Multiplatform, compatibility and user experience on iOS remain uncertain without real-device testing.

If you own a Mac device, are familiar with iOS development, and are interested in this project, contributions are welcome.

macOS and Linux have not been tested on actual hardware either, but since they are also JVM-based, most functionality should work without issues.

## 2. Getting Started
You can open this project using JetBrains IntelliJ IDEA, ensuring that `JDK`, `Gradle`, and the `Kotlin Multiplatform` plugin are installed and configured. The JDK and Gradle versions used during development are as follows (recommended):
- **JDK 21**
- **Gradle 9.5**

After Gradle finishes loading, you can run the `*Example` module directly or use UIKit in your own project.

UIKit is not yet published to `Maven Central`. You can publish it locally and reference it:
```sh
git clone https://github.com/MillenTec/UIKit.git
cd UIKit/src
./gradlew :uikitMain:publishToMavenLocal
```
Then, in the project where you want to reference UIKit:
```kt
// settings.gradle.kts - repository configuration
repositories {
    mavenLocal()
    // ... other repositories
}

// build.gradle.kts - dependency configuration (commonMain)
dependencies {
    implementation("com.millentec.uikit:uikit:0.0.1-dev")
}
```

Then re-sync your Gradle project to verify that UIKit works correctly.

## 3. Design
### 3.1. Theming System
In `UIKitTheme`, you can use `getLight()` or `getDark()` to retrieve the default light or dark theme and pass it to `UIKitThemeHost`. Creating a `UIKitTheme` instance directly defaults to the light theme.
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
`UIKitThemeHost` is essentially a `CompositionLocalProvider`. Accessing theme values with `getUIKitColors()` is equivalent to `UIKitTheme.LocalTheme.current.colors`. If no `UIKitThemeHost` wrapper is present in the upper layers of your app, `getUIKitTheme` defaults to the light theme.

You can create an observable property in your application and pass it to `UIKitThemeHost`, updating it to change the theme:
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

### 3.2. Icons
UIKit provides a symbol system called `UIKit Symbols`, inspired by the design of `SF Symbols`, along with a built-in set of symbols based on [FluentUI System Icons](https://github.com/microsoft/fluentui-system-icons), allowing you to draw symbols with complex animation logic in your UI through a simple API.

> [!TIP]
> UIKit previously also offered an `ImageVector`-based icon set, **FluentIcons**, which is now being gradually deprecated and migrated to UIKit Symbols. You can use the compatibility layer to convert an `ImageVector` into a usable UIKit Symbol:
> ```kt
> UIKitImageVectorSymbol(imageVector)
> ```

#### 3.2.1. Overview
The built-in UIKit Symbols can be accessed through the `UIKitSymbols` entry point:
```kt
UIKitSymbols.systemUI.AddCircle
```

Each symbol is a subclass object of the `UIKitSymbol` abstract class, responsible for **storing a description of the drawing behavior**; the actual drawing is performed by the `UIKitIcon` composable:
```kt
UIKitIcon(
    modifier = Modifier
        .size(32.dp),
    symbol = UIKitSymbols.systemUI.AddCircle,
    contentDescription = "Add",
    symbolStyle = UIKitSymbolStyle.MultiColor,
    symbolEffect = UIKitSymbolEffect()
        .visibleEffect(true)
)
```

#### 3.2.2. Coloring Modes
The `symbolStyle` parameter is an important parameter of `UIKitIcon`. It determines the **coloring mode** of the symbol. UIKit Symbols provides the following four coloring modes plus one auxiliary coloring mode:
- **Monochrome:** Monochrome coloring. Accepts a brush that is applied to the symbol as a whole.
- **Hierarchical:** Hierarchical coloring. Accepts a brush that is applied to the symbol as a whole, while internally applying different opacity levels to each layer. This can **add visual hierarchy** to a symbol or **distinguish visual priority**.
- **MultiColor:** Multi-color. Uses the symbol's built-in color scheme, giving icons better **semantic coloring** or reflecting the colors of the icon's real-world counterpart.
- **Palette:** Palette. You can pass a different color for each layer to achieve the **highest level of customization**.
- **PaletteWithId:** An auxiliary option to the palette, allowing you to color each layer of a symbol more precisely by ID.

#### 3.2.3. Animation Effects
UIKit Symbols provides the `UIKitSymbolEffect` system for adding animations. You can chain animation effects and pass in triggers. `UIKitSymbolEffect` mainly comes in two different types:
- **Discrete:** Triggered by a `trigger`; each time the trigger changes, the animation plays once or more.
  ```kt
  val trigger = remember { mutableStateOf(0) }
  UIKitIcon(
      symbol = UIKitSymbols.shapes.Layer,
      contentDescription = "Layer",
      symbolStyle = UIKitSymbolStyle.MultiColor,
      symbolEffect = UIKitSymbolEffect()
          .bounceEffect(trigger, repeat = 1)
  )
  ```
- **Infinite:** Controlled by an `isActive` boolean property; while it is true, a periodic animation keeps playing. Some infinite animations also offer discrete versions, which play one or more cycles each time the trigger changes.
  ```kt
  UIKitIcon(
      symbol = UIKitSymbols.media.Volume,
      contentDescription = "Volume",
      symbolStyle = UIKitSymbolStyle.MultiColor,
      symbolEffect = UIKitSymbolEffect()
          .variableColorEffect(isActive = true)
  )
  ```

Internally, animations are orchestrated through `UIKitSymbolAnimTree`, where you can add **sequential and parallel** nodes and chain calls together.

If the built-in animations don't meet your needs, you can pass a custom `UIKitSymbolAnimTree` via `customEffect`.

#### 3.2.4. Custom Symbols
UIKit Symbols supports customization: simply inherit from the `UIKitSymbol` abstract base class to create a custom symbol. We recommend using an **object** rather than a class as the symbol carrier.

You can create a `UIKitSymbol` subclass object, implement the `layers` property and describe the symbol's vector paths with the DSL inside it, implement the `colorSet` method to define coloring, and declare capabilities via the `abilityStatement` property:
```kt
object MySymbol: UIKitSymbol(
    name = "MySymbol",
    defaultSize = DpSize(20.dp, 20.dp),
    viewportSize = Size(20f, 20f),
) {
  override val layers: List<UIKitSymbolLayer> = listOf(
      UIKitSymbolLayer("layer0").apply { 
          group(
              id = "group0", 
              drawType = UIKitPathDrawType.Fill
          ) {
              moveTo(10f, 2f)
              curveTo(5.6f, 2f, 2f, 5.6f, 2f, 10f)
              // ...
          }
      }
  )

  override val abilityStatement: List<UIKitSymbolAbility> = listOf(
      UIKitSymbolAbility.Appear
      // ...
  )

  @Composable
  override fun colorSet(
      style: UIKitSymbolStyle,
      states: List<Pair<String, UIKitSymbolGroupState>>
  ): List<UIKitSymbolColor> {
      // ...
  }
}
```

If you want to add animations to your symbol, you can override the `*Effect` family of methods to return a `UIKitSymbolAnimTree`, or return `null` to indicate that this animation is not supported (in which case calls simply do nothing).

### 3.3. Materials
UIKit provides `AcrylicMaterial`, which includes background blur and edge highlights. Default properties can be configured in `UIKitAcrylicMaterial`.

Background blur is powered by the open-source library [Cloudy](https://github.com/skydoves/Cloudy).

![Acrylic effect](img/readme_materials_acrylic_dark_light.webp)
> [!TIP]
> The background image used in the acrylic effect demo is from [Pixabay](https://pixabay.com/zh/photos/beach-cliff-bay-sea-ocean-418742/) ([License Summary](https://pixabay.com/service/license-summary/)).

To use acrylic material, first create a state with `rememberAcrylicMaterialState`, set a source, and apply the material to a container:
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
> Do not use an `AcrylicMaterial` with the same state as its source inside the child hierarchy of `AcrylicMaterialSource`. In other words, an `AcrylicMaterial` cannot have itself as its source, as this will cause a crash:
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
>               .acrylicMaterial(state = state)  // ❌ This will cause a crash
>        ) {
>            // ... 
>        }
>    }
> }
> ```

## 4. License
This project is open-sourced under the **[MIT License](LICENSE.txt)**, which grants you the right to:
- Deal in the Software without restriction, including without limitation the rights to **use, copy, modify, merge, publish, distribute, sublicense, and/or sell** copies of the Software.

However, you must:
- **Retain the copyright notice:** The copyright notice and permission notice shall be included in all copies or substantial portions of the Software.

UIKit also relies on the support of the open-source community. All third-party open-source software used by UIKit and their licenses are listed in [THIRD_PARTY.txt](THIRD_PARTY.txt).

## 5. About Me
I am a high school student from China, a tech enthusiast, programming hobbyist, self-taught developer, and anime fan. In May of this year (2026), I was introduced to the Kotlin language and the Compose Multiplatform framework, fell in love with this declarative UI framework, and began diving deeper into learning and using it. I started developing UIKit after my junior high school academic proficiency exam in early July of the same year.

### 5.1. Contact Me
- MillenTec@outlook.com
- [GitHub](https://github.com/MillenTec)
- [Gitee](https://gitee.com/MillenTec)
- [bilibili](https://space.bilibili.com/3546591566760474)

If you like UIKit, please give it a Star!