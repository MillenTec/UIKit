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
    }

    val home: Home get() = object : Home {}
    interface Home {
        val title: String
            get() = "Home"
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

            val common: Common get() = object : Common {}
            interface Common {
                val sourceCode: String
                    get() = "Source Code"
                val enabled: String
                    get() = "Enabled"
                val color: String
                    get() = "Color"
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
            }
        }
    }

    val license: License get() = object : License {}
    interface License {
        val title: String
            get() = "Open Source License"
        val description: String
            get() = "UIKit is distributed under the MIT license, which grants you the freedom to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software."
    }

    val thirdPartyLicenses: ThirdPartyLicenses get() = object : ThirdPartyLicenses {}
    interface ThirdPartyLicenses {
        val title: String
            get() = "Third-Party Licenses"
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
