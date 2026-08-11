package com.millentec.compose.uikit.i18n.strings

class SimplifiedChinese: Strings {
    override val navigation: Strings.Navigation get() = object : Strings.Navigation {
        override val home: String
            get() = "主页"
        override val controls: String
            get() = "组件"
        override val designs: String
            get() = "设计"
        override val license: String
            get() = "开源许可证"
        override val thirdPartyLicenses: String
            get() = "第三方许可证"
        override val settings: String
            get() = "设置"
    }

    override val home: Strings.Home get() = object : Strings.Home {
        override val title: String
            get() = "主页"
    }

    override val controls: Strings.Controls get() = object : Strings.Controls {
        override val title: String
            get() = "组件"
        override val inputsEntrance: String
            get() = "输入控件"
        override val statusAndInfosEntrance: String
            get() = "状态和信息"
        override val flyoutsEntrance: String
            get() = "浮层控件"
        override val layoutsEntrance: String
            get() = "布局控件"

        override val inputs: Strings.Controls.Inputs get() = object : Strings.Controls.Inputs {
            override val title: String
                get() = "输入控件"
            override val buttonEntrance: String
                get() = "按钮"
            override val toggleButtonEntrance: String
                get() = "按钮开关"
            override val toggleSwitchEntrance: String
                get() = "开关"

            override val common: Strings.Controls.Inputs.Common
                get() = object : Strings.Controls.Inputs.Common {
                    override val sourceCode: String
                        get() = "源代码"
                    override val enabled: String
                        get() = "是否启用"
                    override val color: String
                        get() = "颜色"
                }

            override val button: Strings.Controls.Inputs.Button
                get() = object : Strings.Controls.Inputs.Button {
                    override val title: String
                        get() = "按钮"
                    override val description: String
                        get() = "按钮是一个基础的可点击控件，提供了 onClick 回调，在被点击时触发"
                    override val button0Description: String
                        get() = "一个包含文字内容的简单按钮"
                    override val button0Content: String
                        get() = "按钮"
                    override val button1Description: String
                        get() = "一个包含文字和图标内容的按钮"
                    override val button1Content: String
                        get() = "添加"
                    override fun buttonHint(count: Int): String =
                        "你点击了 $count 次按钮"
                }

            override val toggleButton: Strings.Controls.Inputs.ToggleButton
                get() = object : Strings.Controls.Inputs.ToggleButton {
                    override val title: String
                        get() = "按钮开关"
                    override val description: String
                        get() = "按钮开关是一个双态的可点击控件，提供的 onCheckedChange 回调会在状态请求更新时触发"
                    override val button0Description: String
                        get() = "一个包含文字内容的简单按钮开关"
                    override val button0Content: String
                        get() = "开关"
                    override val button1Description: String
                        get() = "一个包含文字和图标内容的按钮开关"
                    override val button1Content: String
                        get() = "确定"
                    override val buttonHintChecked: String
                        get() = "已开启"
                    override val buttonHintUnchecked: String
                        get() = "未开启"
                }

            override val toggleSwitch: Strings.Controls.Inputs.ToggleSwitch
                get() = object : Strings.Controls.Inputs.ToggleSwitch {
                    override val title: String
                        get() = "开关"
                    override val description: String
                        get() = "开关是一个双态的可点击控件，提供的 onCheckedChange 回调会在状态请求更新时触发"
                    override val switchDescription: String
                        get() = "一个简单的开关"
                    override val switchHintChecked: String
                        get() = "已开启"
                    override val switchHintUnchecked: String
                        get() = "未开启"
                }
        }

        override val flyouts: Strings.Controls.Flyouts
            get() = object : Strings.Controls.Flyouts {
                override val title: String
                    get() = "浮层控件"
            }

        override val statusAndInfos: Strings.Controls.StatusAndInfos
            get() = object : Strings.Controls.StatusAndInfos {
                override val title: String
                    get() = "状态与信息"
            }

        override val layouts: Strings.Controls.Layouts
            get() = object : Strings.Controls.Layouts {
                override val title: String
                    get() = "布局控件"
            }
    }

    override val designs: Strings.Designs get() = object : Strings.Designs {
        override val title: String
            get() = "设计"
        override val fluentIconsEntrance: String
            get() = "Fluent 图标集"
        override val fluentIcons: Strings.Designs.FluentIcons
            get() = object : Strings.Designs.FluentIcons {
                override val title: String
                    get() = "Fluent 图标集"
                override val regularIcons: String
                    get() = "未填充"
                override val filledIcons: String
                    get() = "填充"
                override val animatableIcons: String
                    get() = "动画图标"

                override val options: Strings.Designs.FluentIcons.Options
                    get() = object : Strings.Designs.FluentIcons.Options {
                        override val title: String
                            get() = "选项"
                        override val info: String
                            get() = "图标信息"
                        override val name: String
                            get() = "名称"
                        override val size: String
                            get() = "尺寸"
                        override val general: String
                            get() = "通用选项"
                        override val layeredIcon: String
                            get() = "分层图标"
                        override val tintColor: String
                            get() = "色调"
                        override val backgroundColor: String
                            get() = "背景颜色"
                        override val extension: String
                            get() = "扩展选项"
                        override val autoTint: String
                            get() = "自动着色"
                        override val resetProgressOnError: String
                            get() = "在 Error 时重置进度"
                    }
            }
    }

    override val license: Strings.License get() = object : Strings.License {
        override val title: String
            get() = "开源许可证"
        override val description: String
            get() = "UIKit 使用 MIT 协议分发，这意味着你可以无限制地处理本软件，包括但不限于使用、复制、修改、合并、发布、分发、再授权和/或销售本软件的副本"
    }

    override val thirdPartyLicenses: Strings.ThirdPartyLicenses get() = object : Strings.ThirdPartyLicenses {
        override val title: String
            get() = "第三方许可证"
        override val description: String
            get() = "UIKit 同样离不开开源社区的支持，下面列出了 UIKit 所使用的开源项目"
    }

    override val settings: Strings.Settings get() = object : Strings.Settings {
        override val title: String
            get() = "设置"
        override val themeSettingTitle: String
            get() = "主题"
        override val themeSystem: String
            get() = "跟随系统"
        override val themeLight: String
            get() = "亮色主题"
        override val themeDark: String
            get() = "暗色主题"
        override val acrylicEnabledSettingTitle: String
            get() = "亚克力效果"
        override val languageSettingTitle: String
            get() = "语言"

        override val language: Strings.Settings.Language
            get() = object : Strings.Settings.Language {
                override val title: String
                    get() = "语言"
                override val description: String
                    get() = "选择你的首选语言，并使用英语（美国）作为回退；部分语言使用机器翻译或人工智能翻译"

                override val enUS: String
                    get() = "英语（美国）"
                override val zhCN: String
                    get() = "简体中文"
                override val zhTW: String
                    get() = "繁体中文（台湾）"
                override val jaJP: String
                    get() = "日语"
            }
    }
}