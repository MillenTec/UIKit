package com.millentec.compose.uikit.i18n.strings

interface Strings {
    val navigation: Navigation get() = object : Navigation {}
    interface Navigation {
        val home: String
            get() = "Home"
        val controls: String
            get() = "Controls"
        val designs: String
            get() = "Designs"
        val license: String
            get() = "Open Source License"
        val thirdPartyLicenses: String
            get() = "Third-Party Licenses"
        val settings: String
            get() = "Settings"
        val more: String
            get() = "More"
    }

    val home: Home get() = object : Home {}
    interface Home {
        val title: String
            get() = "Home"
        val description: String
            get() = "UIKit is a modern, minimalist Compose Multiplatform component library built on Fluent Design while incorporating Apple design principles."
        val viewOnGitHub: String
            get() = "View on GitHub"
        val viewOnGitHubDescription: String
            get() = "Open the GitHub repository of this project."
    }

    val controls: Controls get() = object : Controls {}
    interface Controls {
        val title: String
            get() = "Controls"
        val inputsEntrance: String
            get() = "Input Controls"
        val statusAndInfosEntrance: String
            get() = "Status & Info"
        val flyoutsEntrance: String
            get() = "Flyouts"
        val layoutsEntrance: String
            get() = "Layouts"

        val inputs: Inputs get() = object : Inputs {}
        interface Inputs {
            val title: String
                get() = "Input Controls"
            val buttonEntrance: String
                get() = "Button"
            val toggleButtonEntrance: String
                get() = "Toggle Button"
            val toggleSwitchEntrance: String
                get() = "Toggle Switch"

            val unknown: String
                get() = "Unknown"

            val common: Common get() = object : Common {}
            interface Common {
                val sourceCode: String
                    get() = "Source Code"
                val enabled: String
                    get() = "Enabled"
                val color: String
                    get() = "Color"
                val rectangle: String
                    get() = "Rectangle"
                val rounded: String
                    get() = "Rounded"
            }

            val button: Button get() = object : Button {}
            interface Button {
                val title: String
                    get() = "Button"
                val description: String
                    get() = "A button is a basic clickable control that triggers its onClick callback when clicked."
                val button0Description: String
                    get() = "A simple button with text content."
                val button0Content: String
                    get() = "Button"
                val button1Description: String
                    get() = "A button with text and icon content."
                val button1Content: String
                    get() = "Add"
                fun buttonHint(count: Int): String =
                    "You clicked the button $count times."
            }

            val toggleButton: ToggleButton get() = object : ToggleButton {}
            interface ToggleButton {
                val title: String
                    get() = "Toggle Button"
                val description: String
                    get() = "A toggle button is a two-state clickable control whose onCheckedChange callback is triggered when a state update is requested."
                val button0Description: String
                    get() = "A simple toggle button with text content."
                val button0Content: String
                    get() = "Toggle"
                val button1Description: String
                    get() = "A toggle button with text and icon content."
                val button1Content: String
                    get() = "OK"
                val buttonHintChecked: String
                    get() = "On"
                val buttonHintUnchecked: String
                    get() = "Off"
            }

            val toggleSwitch: ToggleSwitch get() = object : ToggleSwitch {}
            interface ToggleSwitch {
                val title: String
                    get() = "Toggle Switch"
                val description: String
                    get() = "A toggle switch is a two-state clickable control whose onCheckedChange callback is triggered when a state update is requested."
                val switchDescription: String
                    get() = "A simple toggle switch"
                val switchHintChecked: String
                    get() = "On"
                val switchHintUnchecked: String
                    get() = "Off"
            }
        }

        val flyouts: Flyouts get() = object : Flyouts {}
        interface Flyouts {
            val title: String
                get() = "Flyouts"
        }

        val statusAndInfos: StatusAndInfos get() = object : StatusAndInfos {}
        interface StatusAndInfos {
            val title: String
                get() = "Status & Info"
        }

        val layouts: Layouts get() = object : Layouts {}
        interface Layouts {
            val title: String
                get() = "Layouts"
        }
    }

    val designs: Designs get() = object : Designs {}
    interface Designs {
        val title: String
            get() = "Designs"
        val fluentIconsEntrance: String
            get() = "Fluent Icons"
        val uikitSymbolsEntrance: String
            get() = "UIKit Symbols"

        val uikitSymbols: UiKitSymbols get() = object : UiKitSymbols {}
        interface UiKitSymbols {
            val title: String
                get() = "UIKit Symbols"
            val all: String
                get() = "All"
            val allTitle: String
                get() = "All Symbols"
            val systemUi: String
                get() = "System UI"
            val systemUiTitle: String
                get() = "System UI"
            val preview: String
                get() = "Preview"
            val goBack: String
                get() = "Go Back"
            val commonOptions: String
                get() = "Common Options"
            val example: String
                get() = "Example"
            val tint: String
                get() = "Tint"

            val styles: Styles get() = object : Styles {}
            interface Styles {
                val monochrome: String
                    get() = "Monochrome"
                val hierarchical: String
                    get() = "Hierarchical"
                val multiColor: String
                    get() = "Multi Color"
            }

            val effect: Effect get() = object : Effect {}
            interface Effect {
                val visible: String
                    get() = "Visible"
                val bounce: String
                    get() = "Bounce"
                val variableColor: String
                    get() = "Variable Color"
                val pulse: String
                    get() = "Pulse"
            }
        }

        val fluentIcons: FluentIcons get() = object : FluentIcons {}
        interface FluentIcons {
            val title: String
                get() = "Fluent Icons"
            val regularIcons: String
                get() = "Regular"
            val filledIcons: String
                get() = "Filled"
            val animatableIcons: String
                get() = "Animatable"

            val thin: String
                get() = "Thin"
            val angle: String
                get() = "Angle"

            val states: States get() = object : States {}
            interface States {
                val running: String
                    get() = "Running"
                val stopped: String
                    get() = "Stopped"
                val error: String
                    get() = "Error"
                val success: String
                    get() = "Success"
                val add: String
                    get() = "Add"
            }

            val options: Options get() = object : Options {}
            interface Options {
                val title: String
                    get() = "Options"
                val info: String
                    get() = "Icon Info"
                val name: String
                    get() = "Name"
                val size: String
                    get() = "Size"
                val general: String
                    get() = "General"
                val layeredIcon: String
                    get() = "Layered Icon"
                val tintColor: String
                    get() = "Tint Color"
                val backgroundColor: String
                    get() = "Background Color"
                val extension: String
                    get() = "Extension"
                val autoTint: String
                    get() = "Auto Tint"
                val resetProgressOnError: String
                    get() = "Reset Progress on Error"
                val unknown: String
                    get() = "Unknown"

                val colors: Colors get() = object : Colors {}
                interface Colors {
                    val primary: String
                        get() = "Primary"
                    val secondary: String
                        get() = "Secondary"
                    val reversed: String
                        get() = "Reversed"
                    val highlight: String
                        get() = "Highlight"
                    val success: String
                        get() = "Success"
                    val warning: String
                        get() = "Warning"
                    val error: String
                        get() = "Error"
                }
            }
        }
    }

    val license: License get() = object : License {}
    interface License {
        val title: String
            get() = "Open Source License"
        val loading: String
            get() = "Loading..."
        fun loadingFailed(detail: String): String =
            "Loading failed: $detail"
        val description: String
            get() = "UIKit is distributed under the MIT license, which grants you the freedom to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software."
    }

    val thirdPartyLicenses: ThirdPartyLicenses get() = object : ThirdPartyLicenses {}
    interface ThirdPartyLicenses {
        val title: String
            get() = "Third-Party Licenses"
        val loading: String
            get() = "Loading..."
        fun loadingFailed(detail: String): String =
            "Loading failed: $detail"
        val description: String
            get() = "UIKit also relies on the support of the open source community. Listed below are the open source projects used by UIKit."
    }

    val settings: Settings get() = object : Settings {}
    interface Settings {
        val title: String
            get() = "Settings"
        val themeSettingTitle: String
            get() = "Theme"
        val themeSystem: String
            get() = "System"
        val themeLight: String
            get() = "Light"
        val themeDark: String
            get() = "Dark"
        val acrylicEnabledSettingTitle: String
            get() = "Acrylic Effect"
        val languageSettingTitle: String
            get() = "Language"

        val language: Language get() = object: Language {}
        interface Language {
            val title: String
                get() = "Language"
            val description: String
                get() = "Select your preferred language, and use English (US) as a fallback; some languages use machine or AI translation."
            val enUS: String
                get() = "English (US)"
            val zhCN: String
                get() = "Simplified Chinese"
            val zhTW: String
                get() = "Traditional Chinese (TW)"
            val jaJP: String
                get() = "Japanese"
        }
    }
}
