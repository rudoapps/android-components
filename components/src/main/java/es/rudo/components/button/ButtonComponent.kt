package es.rudo.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * Composable function to render a button with customizable styles and behavior.
 *
 * @param text The text to display on the button. Default is `null`.
 * @param onClick The callback to be invoked when the button is clicked.
 * @param buttonStyles The styles to apply to the button, such as colors, sizes, and padding.
 * @param state The mutable state representing the current state of the button.
 */
@Composable
fun ButtonComponent(
    text: String? = "Lorem",
    onClick: () -> Unit,
    buttonStyles: ButtonStyles = ButtonStyles(),
    state: ButtonState
) {
    Card(
        shape = RoundedCornerShape(buttonStyles.roundedCornerShape),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .height(
                when (buttonStyles.height) {
                    ButtonHeight.Small -> 50.dp
                    ButtonHeight.Medium -> 60.dp
                    ButtonHeight.Large -> 70.dp
                    ButtonHeight.Custom -> buttonStyles.customHeight
                }
            ),
        border = BorderStroke(
            width = buttonStyles.onPressBorderWidth,
            color = buttonStyles.onPressBorderColor
        )
    ) {
        Button(
            onClick = {
                onClick()
            },
            shape = RoundedCornerShape(buttonStyles.roundedCornerShape),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonStyles.backgroundColor,
                contentColor = buttonStyles.textColor,
                disabledContainerColor = buttonStyles.backgroundColor.copy(0.5F),
                disabledContentColor = buttonStyles.textColor
            ),
            enabled = state != ButtonState.Disabled,
            border = BorderStroke(
                width = buttonStyles.borderWidth,
                color = buttonStyles.borderColor
            ),
            contentPadding = PaddingValues(
                start = buttonStyles.paddingStart,
                top = buttonStyles.paddingTop,
                end = buttonStyles.paddingEnd,
                bottom = buttonStyles.paddingBottom,
            ),
            modifier = if (buttonStyles.borderColor != Color.Transparent) {
                Modifier.padding(buttonStyles.onPressBorderWidth)
            } else {
                Modifier.padding()
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                if (state == ButtonState.Loading) {
                    CircularProgressIndicator(
                        color = buttonStyles.circularProgressIndicatorColor,
                        modifier = Modifier.size(buttonStyles.circularProgressIndicatorSize)
                    )
                } else {
                    if (buttonStyles.icon != null &&
                        (buttonStyles.iconType == IconType.Left ||
                                buttonStyles.iconType == null ||
                                buttonStyles.iconType == IconType.TwoSides)
                    ) {
                        if (text?.isNotEmpty() == true) {
                            Icon(
                                buttonStyles.icon,
                                contentDescription = "icon",
                                modifier = Modifier.padding(end = buttonStyles.paddingBetweenIconAndText),
                                tint = buttonStyles.iconColor
                            )
                        } else {
                            Icon(
                                buttonStyles.icon,
                                contentDescription = "icon",
                                modifier = Modifier,
                                tint = buttonStyles.iconColor
                            )
                        }
                    }

                        if (text?.isNotEmpty() == true) {
                            Text(
                                text = text,
                                style = TextStyle(fontSize = buttonStyles.textSize),
                                modifier = Modifier.padding(buttonStyles.paddingBetweenIconAndText),
                                fontFamily = buttonStyles.fontFamily
                            )
                        }

                    if (buttonStyles.icon != null && (buttonStyles.iconType == IconType.Right || buttonStyles.iconType == IconType.TwoSides)) {
                        if (text?.isNotEmpty() == true) {
                            Icon(
                                buttonStyles.icon,
                                contentDescription = "icon",
                                modifier = Modifier.padding(start = buttonStyles.paddingBetweenIconAndText),
                                tint = buttonStyles.iconColor
                            )
                        } else {
                            Icon(
                                buttonStyles.icon,
                                contentDescription = "icon",
                                modifier = Modifier,
                                tint = buttonStyles.iconColor
                            )
                        }
                    }
                }
            }
        }
    }
}