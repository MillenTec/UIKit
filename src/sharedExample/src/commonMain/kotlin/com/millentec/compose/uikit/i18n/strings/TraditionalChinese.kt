package com.millentec.compose.uikit.i18n.strings

class TraditionalChinese: Strings {
    override val navigation: Strings.Navigation get() = object : Strings.Navigation {
        override val home: String
            get() = "首頁"
        override val controls: String
            get() = "元件"
        override val designs: String
            get() = "設計"
        override val license: String
            get() = "開源授權"
        override val thirdPartyLicenses: String
            get() = "第三方授權"
        override val settings: String
            get() = "設定"
    }

    override val home: Strings.Home get() = object : Strings.Home {
        override val title: String
            get() = "首頁"
    }

    override val controls: Strings.Controls get() = object : Strings.Controls {
        override val title: String
            get() = "元件"
        override val inputsEntrance: String
            get() = "輸入控制項"
        override val statusAndInfosEntrance: String
            get() = "狀態與資訊"
        override val flyoutsEntrance: String
            get() = "浮層控制項"
        override val layoutsEntrance: String
            get() = "版面配置控制項"

        override val inputs: Strings.Controls.Inputs get() = object : Strings.Controls.Inputs {
            override val title: String
                get() = "輸入控制項"
            override val buttonEntrance: String
                get() = "按鈕"
            override val toggleButtonEntrance: String
                get() = "切換按鈕"
            override val toggleSwitchEntrance: String
                get() = "切換開關"

            override val common: Strings.Controls.Inputs.Common
                get() = object : Strings.Controls.Inputs.Common {
                    override val sourceCode: String
                        get() = "原始碼"
                    override val enabled: String
                        get() = "是否啟用"
                    override val color: String
                        get() = "色彩"
                }

            override val button: Strings.Controls.Inputs.Button
                get() = object : Strings.Controls.Inputs.Button {
                    override val title: String
                        get() = "按鈕"
                    override val description: String
                        get() = "按鈕是基本的可點擊控制項，提供 onClick 回呼，在點擊時觸發"
                    override val button0Description: String
                        get() = "一個包含文字內容的簡單按鈕"
                    override val button0Content: String
                        get() = "按鈕"
                    override val button1Description: String
                        get() = "一個包含文字與圖示內容的按鈕"
                    override val button1Content: String
                        get() = "新增"
                    override fun buttonHint(count: Int): String =
                        "你點擊了 $count 次按鈕"
                }

            override val toggleButton: Strings.Controls.Inputs.ToggleButton
                get() = object : Strings.Controls.Inputs.ToggleButton {
                    override val title: String
                        get() = "切換按鈕"
                    override val description: String
                        get() = "切換按鈕是雙態的可點擊控制項，提供的 onCheckedChange 回呼會在狀態請求更新時觸發"
                    override val button0Description: String
                        get() = "一個包含文字內容的簡單切換按鈕"
                    override val button0Content: String
                        get() = "切換"
                    override val button1Description: String
                        get() = "一個包含文字與圖示內容的切換按鈕"
                    override val button1Content: String
                        get() = "確定"
                    override val buttonHintChecked: String
                        get() = "已開啟"
                    override val buttonHintUnchecked: String
                        get() = "未開啟"
                }

            override val toggleSwitch: Strings.Controls.Inputs.ToggleSwitch
                get() = object : Strings.Controls.Inputs.ToggleSwitch {
                    override val title: String
                        get() = "切換開關"
                    override val description: String
                        get() = "切換開關是雙態的可點擊控制項，提供的 onCheckedChange 回呼會在狀態請求更新時觸發"
                    override val switchDescription: String
                        get() = "一個簡單的切換開關"
                    override val switchHintChecked: String
                        get() = "已開啟"
                    override val switchHintUnchecked: String
                        get() = "未開啟"
                }
        }

        override val flyouts: Strings.Controls.Flyouts
            get() = object : Strings.Controls.Flyouts {
                override val title: String
                    get() = "浮層控制項"
            }

        override val statusAndInfos: Strings.Controls.StatusAndInfos
            get() = object : Strings.Controls.StatusAndInfos {
                override val title: String
                    get() = "狀態與資訊"
            }

        override val layouts: Strings.Controls.Layouts
            get() = object : Strings.Controls.Layouts {
                override val title: String
                    get() = "版面配置控制項"
            }
    }

    override val designs: Strings.Designs get() = object : Strings.Designs {
        override val title: String
            get() = "設計"
        override val fluentIconsEntrance: String
            get() = "Fluent 圖示集"
        override val fluentIcons: Strings.Designs.FluentIcons
            get() = object : Strings.Designs.FluentIcons {
                override val title: String
                    get() = "Fluent 圖示集"
                override val regularIcons: String
                    get() = "未填滿"
                override val filledIcons: String
                    get() = "填滿"
                override val animatableIcons: String
                    get() = "動畫圖示"

                override val options: Strings.Designs.FluentIcons.Options
                    get() = object : Strings.Designs.FluentIcons.Options {
                        override val title: String
                            get() = "選項"
                        override val info: String
                            get() = "圖示資訊"
                        override val name: String
                            get() = "名稱"
                        override val size: String
                            get() = "尺寸"
                        override val general: String
                            get() = "一般選項"
                        override val layeredIcon: String
                            get() = "分層圖示"
                        override val tintColor: String
                            get() = "色調"
                        override val backgroundColor: String
                            get() = "背景色彩"
                        override val extension: String
                            get() = "擴充選項"
                        override val autoTint: String
                            get() = "自動著色"
                        override val resetProgressOnError: String
                            get() = "在 Error 時重設進度"
                    }
            }
    }

    override val license: Strings.License get() = object : Strings.License {
        override val title: String
            get() = "開源授權"
        override val description: String
            get() = "UIKit 使用 MIT 協定發佈，這表示你可以在不受限制的情況下處理本軟體，包括但不限於使用、複製、修改、合併、發佈、散佈、再授權及/或銷售本軟體之副本"
    }

    override val thirdPartyLicenses: Strings.ThirdPartyLicenses get() = object : Strings.ThirdPartyLicenses {
        override val title: String
            get() = "第三方授權"
        override val description: String
            get() = "UIKit 同樣離不開開源社群的支持，下面列出了 UIKit 所使用的開源專案"
    }

    override val settings: Strings.Settings get() = object : Strings.Settings {
        override val title: String
            get() = "設定"
        override val themeSettingTitle: String
            get() = "主題"
        override val themeSystem: String
            get() = "跟隨系統"
        override val themeLight: String
            get() = "亮色主題"
        override val themeDark: String
            get() = "暗色主題"
        override val acrylicEnabledSettingTitle: String
            get() = "亞克力效果"
        override val languageSettingTitle: String
            get() = "語言"

        override val language: Strings.Settings.Language
            get() = object : Strings.Settings.Language {
                override val title: String
                    get() = "語言"
                override val description: String
                    get() = "選擇你的首選語言，並使用英語（美國）作為回退；部分語言使用機器翻譯或 AI 翻譯"

                override val enUS: String
                    get() = "英語（美國）"
                override val zhCN: String
                    get() = "簡體中文"
                override val zhTW: String
                    get() = "繁體中文（台灣）"
                override val jaJP: String
                    get() = "日語"
            }
    }
}
