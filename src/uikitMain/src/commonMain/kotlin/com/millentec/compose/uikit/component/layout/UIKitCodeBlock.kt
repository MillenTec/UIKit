package com.millentec.compose.uikit.component.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.millentec.compose.uikit.foundation.UIKitCodeBlockColors
import com.millentec.compose.uikit.foundation.UIKitCodeBlockConfig
import com.millentec.compose.uikit.theme.getUIKitLayout
import com.millentec.compose.uikit.theme.getUIKitTypography

@Composable
@Preview
private fun Preview() {
    UIKitCodeBlock(
        config = UIKitCodeBlockConfig.kotlin(UIKitCodeBlockColors.IntelliJ)
    ) {
        """
        val num = 123f
        println("Hello World!")
        println(num)
        
        @Composable
        fun App() {
            // Some Notes
            /* Some Notes */
            /**
             Some Docs
             */
        }
        """.trimIndent()
    }
}

@Composable
fun UIKitCodeBlock(
    modifier: Modifier = Modifier,
    config: UIKitCodeBlockConfig = UIKitCodeBlockConfig.text(),
    style: TextStyle = getUIKitTypography().body,
    fontFamily: FontFamily = FontFamily.Monospace,
    contentPadding: PaddingValues = PaddingValues(getUIKitLayout().basicSpacing),
    content: @Composable () -> String
) {
    val content = content()

    val annotatedString = buildAnnotatedString {
        append(content)

        config.rules?.let {
            it.forEach { rule ->
                rule.first.findAll(content).forEach { item ->
                    addStyle(
                        style = rule.second,
                        start = item.range.first,
                        end = item.range.last + 1,
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .background(config.colors.primaryBackground)
            .padding(contentPadding)
    ) {
        Text(
            modifier = modifier,
            text = annotatedString,
            style = style,
            fontFamily = fontFamily,
            color = config.colors.primaryText
        )
    }
}