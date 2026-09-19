package com.millentec.compose.uikit.i18n.strings

class Japanese: Strings {
    override val navigation: Strings.Navigation get() = object : Strings.Navigation {
        override val home: String
            get() = "ホーム"
        override val controls: String
            get() = "コンポーネント"
        override val designs: String
            get() = "デザイン"
        override val license: String
            get() = "オープンソースライセンス"
        override val thirdPartyLicenses: String
            get() = "サードパーティライセンス"
        override val settings: String
            get() = "設定"
        override val more: String
            get() = "その他"
    }

    override val home: Strings.Home get() = object : Strings.Home {
        override val title: String
            get() = "ホーム"
        override val description: String
            get() = "UIKit は Fluent Design を基盤に Apple のデザイン理念を取り入れた、モダンでミニマルな Compose Multiplatform コンポーネントライブラリです。"
        override val viewOnGitHub: String
            get() = "GitHub で表示"
        override val viewOnGitHubDescription: String
            get() = "このプロジェクトの GitHub リポジトリを開きます。"
    }

    override val controls: Strings.Controls get() = object : Strings.Controls {
        override val title: String
            get() = "コンポーネント"
        override val inputsEntrance: String
            get() = "入力コントロール"
        override val statusAndInfosEntrance: String
            get() = "ステータスと情報"
        override val flyoutsEntrance: String
            get() = "フライアウト"
        override val layoutsEntrance: String
            get() = "レイアウト"

        override val inputs: Strings.Controls.Inputs get() = object : Strings.Controls.Inputs {
            override val title: String
                get() = "入力コントロール"
            override val buttonEntrance: String
                get() = "ボタン"
            override val toggleButtonEntrance: String
                get() = "トグルボタン"
            override val toggleSwitchEntrance: String
                get() = "トグルスイッチ"

            override val unknown: String
                get() = "不明"

            override val common: Strings.Controls.Inputs.Common
                get() = object : Strings.Controls.Inputs.Common {
                    override val sourceCode: String
                        get() = "ソースコード"
                    override val enabled: String
                        get() = "有効"
                    override val color: String
                        get() = "色"
                    override val rectangle: String
                        get() = "矩形"
                    override val rounded: String
                        get() = "角丸"
                }

            override val button: Strings.Controls.Inputs.Button
                get() = object : Strings.Controls.Inputs.Button {
                    override val title: String
                        get() = "ボタン"
                    override val description: String
                        get() = "ボタンは基本的なクリック可能なコントロールで、クリック時に呼び出される onClick コールバックを提供します。"
                    override val button0Description: String
                        get() = "テキストのみを含むシンプルなボタン。"
                    override val button0Content: String
                        get() = "ボタン"
                    override val button1Description: String
                        get() = "テキストとアイコンを含むボタン。"
                    override val button1Content: String
                        get() = "追加"
                    override fun buttonHint(count: Int): String =
                        "ボタンを $count 回クリックしました。"
                }

            override val toggleButton: Strings.Controls.Inputs.ToggleButton
                get() = object : Strings.Controls.Inputs.ToggleButton {
                    override val title: String
                        get() = "トグルボタン"
                    override val description: String
                        get() = "トグルボタンは 2 つの状態を持つクリック可能なコントロールで、状態の更新が要求されたときに onCheckedChange コールバックが呼び出されます。"
                    override val button0Description: String
                        get() = "テキストのみを含むシンプルなトグルボタン。"
                    override val button0Content: String
                        get() = "切り替え"
                    override val button1Description: String
                        get() = "テキストとアイコンを含むトグルボタン。"
                    override val button1Content: String
                        get() = "OK"
                    override val buttonHintChecked: String
                        get() = "オン"
                    override val buttonHintUnchecked: String
                        get() = "オフ"
                }

            override val toggleSwitch: Strings.Controls.Inputs.ToggleSwitch
                get() = object : Strings.Controls.Inputs.ToggleSwitch {
                    override val title: String
                        get() = "トグルスイッチ"
                    override val description: String
                        get() = "トグルスイッチは 2 つの状態を持つクリック可能なコントロールで、状態の更新が要求されたときに onCheckedChange コールバックが呼び出されます。"
                    override val switchDescription: String
                        get() = "シンプルなトグルスイッチ。"
                    override val switchHintChecked: String
                        get() = "オン"
                    override val switchHintUnchecked: String
                        get() = "オフ"
                }
        }

        override val flyouts: Strings.Controls.Flyouts
            get() = object : Strings.Controls.Flyouts {
                override val title: String
                    get() = "フライアウト"
            }

        override val statusAndInfos: Strings.Controls.StatusAndInfos
            get() = object : Strings.Controls.StatusAndInfos {
                override val title: String
                    get() = "ステータスと情報"
            }

        override val layouts: Strings.Controls.Layouts
            get() = object : Strings.Controls.Layouts {
                override val title: String
                    get() = "レイアウト"
            }
    }

    override val designs: Strings.Designs get() = object : Strings.Designs {
        override val title: String
            get() = "デザイン"
        override val fluentIconsEntrance: String
            get() = "Fluent アイコン"
        override val uikitSymbolsEntrance: String
            get() = "UIKit Symbols"

        override val uikitSymbols: Strings.Designs.UiKitSymbols
            get() = object : Strings.Designs.UiKitSymbols {
                override val title: String
                    get() = "UIKit Symbols"
                override val all: String
                    get() = "すべて"
                override val allTitle: String
                    get() = "すべてのシンボル"
                override val systemUi: String
                    get() = "システム UI"
                override val systemUiTitle: String
                    get() = "システム UI シンボル"
                override val preview: String
                    get() = "プレビュー"
                override val goBack: String
                    get() = "戻る"
                override val commonOptions: String
                    get() = "共通オプション"
                override val example: String
                    get() = "サンプル"
                override val tint: String
                    get() = "ティントカラー"

                override val styles: Strings.Designs.UiKitSymbols.Styles
                    get() = object : Strings.Designs.UiKitSymbols.Styles {
                        override val monochrome: String
                            get() = "モノクロ"
                        override val hierarchical: String
                            get() = "階層"
                        override val multiColor: String
                            get() = "マルチカラー"
                    }

                override val effect: Strings.Designs.UiKitSymbols.Effect
                    get() = object : Strings.Designs.UiKitSymbols.Effect {
                        override val visible: String
                            get() = "表示"
                        override val bounce: String
                            get() = "バウンス"
                        override val variableColor: String
                            get() = "可変カラー"
                        override val pulse: String
                            get() = "パルス"
                    }
            }

        override val fluentIcons: Strings.Designs.FluentIcons
            get() = object : Strings.Designs.FluentIcons {
                override val title: String
                    get() = "Fluent アイコン"
                override val regularIcons: String
                    get() = "アウトライン"
                override val filledIcons: String
                    get() = "塗りつぶし"
                override val animatableIcons: String
                    get() = "アニメーションアイコン"

                override val thin: String
                    get() = "細"
                override val angle: String
                    get() = "角度"

                override val states: Strings.Designs.FluentIcons.States
                    get() = object : Strings.Designs.FluentIcons.States {
                        override val running: String
                            get() = "実行中"
                        override val stopped: String
                            get() = "停止"
                        override val error: String
                            get() = "エラー"
                        override val success: String
                            get() = "成功"
                        override val add: String
                            get() = "追加"
                    }

                override val options: Strings.Designs.FluentIcons.Options
                    get() = object : Strings.Designs.FluentIcons.Options {
                        override val title: String
                            get() = "オプション"
                        override val info: String
                            get() = "アイコン情報"
                        override val name: String
                            get() = "名前"
                        override val size: String
                            get() = "サイズ"
                        override val general: String
                            get() = "一般"
                        override val layeredIcon: String
                            get() = "レイヤードアイコン"
                        override val tintColor: String
                            get() = "ティントカラー"
                        override val backgroundColor: String
                            get() = "背景色"
                        override val extension: String
                            get() = "拡張"
                        override val autoTint: String
                            get() = "自動ティント"
                        override val resetProgressOnError: String
                            get() = "エラー時に進行状況をリセット"
                        override val unknown: String
                            get() = "不明"

                        override val colors: Strings.Designs.FluentIcons.Options.Colors
                            get() = object : Strings.Designs.FluentIcons.Options.Colors {
                                override val primary: String
                                    get() = "プライマリ"
                                override val secondary: String
                                    get() = "セカンダリ"
                                override val reversed: String
                                    get() = "反転"
                                override val highlight: String
                                    get() = "ハイライト"
                                override val success: String
                                    get() = "成功"
                                override val warning: String
                                    get() = "警告"
                                override val error: String
                                    get() = "エラー"
                            }
                    }
            }
    }

    override val license: Strings.License get() = object : Strings.License {
        override val title: String
            get() = "オープンソースライセンス"
        override val loading: String
            get() = "読み込み中..."
        override fun loadingFailed(detail: String): String =
            "読み込みに失敗しました: $detail"
        override val description: String
            get() = "UIKit は MIT ライセンスで配布されています。つまり、使用、複製、変更、結合、公開、配布、サブライセンス、および/またはソフトウェアのコピーの販売を含むがこれらに限定されない、無制限の取り扱いが許可されています。"
    }

    override val thirdPartyLicenses: Strings.ThirdPartyLicenses get() = object : Strings.ThirdPartyLicenses {
        override val title: String
            get() = "サードパーティライセンス"
        override val loading: String
            get() = "読み込み中..."
        override fun loadingFailed(detail: String): String =
            "読み込みに失敗しました: $detail"
        override val description: String
            get() = "UIKit はオープンソースコミュニティのサポートにも支えられています。以下は UIKit が使用しているオープンソースプロジェクトの一覧です。"
    }

    override val settings: Strings.Settings get() = object : Strings.Settings {
        override val title: String
            get() = "設定"
        override val themeSettingTitle: String
            get() = "テーマ"
        override val themeSystem: String
            get() = "システムに従う"
        override val themeLight: String
            get() = "ライト"
        override val themeDark: String
            get() = "ダーク"
        override val acrylicEnabledSettingTitle: String
            get() = "アクリル効果"
        override val languageSettingTitle: String
            get() = "语言"

        override val language: Strings.Settings.Language
            get() = object : Strings.Settings.Language {
                override val title: String
                    get() = "言語"
                override val description: String
                    get() = "希望の言語を選択し、英語（アメリカ）をフォールバックとして使用してください。一部の言語は機械翻訳やAI翻訳を使用します。"

                override val enUS: String
                    get() = "英語（アメリカ）"
                override val zhCN: String
                    get() = "簡体字中国語"
                override val zhTW: String
                    get() = "繁体字中国語（台湾）"
                override val jaJP: String
                    get() = "日本語"
            }
    }
}
