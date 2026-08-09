package com.millentec.compose.uikit.i18n.strings

interface Strings {
    val navigation: Navigation
    interface Navigation {
        val home: String
        val controls: String
        val designs: String
        val license: String
        val thirdPartyLicenses: String
        val settings: String
    }

    val home: Home
    interface Home {
        val title: String
    }

    val controls: Controls
    interface Controls {
        val title: String
        val inputsEntrance: String
        val statusAndInfosEntrance: String
        val flyoutsEntrance: String
        val layoutsEntrance: String

        val inputs: Inputs
        interface Inputs {
            val title: String
            val buttonEntrance: String
            val toggleButtonEntrance: String
            val toggleSwitchEntrance: String

            val common: Common
            interface Common {
                val sourceCode: String
                val enabled: String
                val color: String
            }

            val button: Button
            interface Button {
                val title: String
                val description: String
                val button0Description: String
                val button0Content: String
                val button1Description: String
                val button1Content: String
                fun buttonHint(count: Int): String
            }

            val toggleButton: ToggleButton
            interface ToggleButton {
                val title: String
                val description: String
                val button0Description: String
                val button0Content: String
                val button1Description: String
                val button1Content: String
                val buttonHintChecked: String
                val buttonHintUnchecked: String
            }

            val toggleSwitch: ToggleSwitch
            interface ToggleSwitch {
                val title: String
                val description: String
                val switchDescription: String
                val switchHintChecked: String
                val switchHintUnchecked: String
            }
        }

        val flyouts: Flyouts
        interface Flyouts {
            val title: String
        }

        val statusAndInfos: StatusAndInfos
        interface StatusAndInfos {
            val title: String
        }

        val layouts: Layouts
        interface Layouts {
            val title: String
        }
    }

    val designs: Designs
    interface Designs {
        val title: String
        val fluentIconsEntrance: String

        val fluentIcons: FluentIcons
        interface FluentIcons {
            val title: String
            val regularIcons: String
            val filledIcons: String
            val animatableIcons: String

            val options: Options
            interface Options {
                val title: String
                val info: String
                val name: String
                val size: String
                val general: String
                val layeredIcon: String
                val tintColor: String
                val backgroundColor: String
                val extension: String
                val autoTint: String
                val resetProgressOnError: String
            }
        }
    }

    val license: License
    interface License {
        val title: String
        val description: String
    }

    val thirdPartyLicenses: ThirdPartyLicenses
    interface ThirdPartyLicenses {
        val title: String
        val description: String
    }

    val settings: Settings
    interface Settings {
        val title: String
        val themeSettingTitle: String
        val themeSystem: String
        val themeLight: String
        val themeDark: String
        val acrylicEnabledSettingTitle: String
    }
}