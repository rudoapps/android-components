package es.rudo.components.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import es.rudo.components.dimens.Dimens

/**
 * A customizable button component.
 *
 * @param textColor The color of the text displayed on the button. Default is [Color.White].
 * @param textSize The size of the text displayed on the button. Default is [Dimens.text_medium].
 * @param height The height of the button.It can be of different types Small, Medium, Large and Custom, Default is [ButtonHeight.Medium].
 * @param customHeight In case of a custom height, it is required to pass on the size. Default is [Dimens.size_none].
 * @param backgroundColor The background color of the button. Default is [Color.Transparent].
 * @param borderColor The color of the border around the button. Default is [Color.Transparent].
 * @param borderWidth The width of the border around the button. Default is [Dimens.size_none].
 * @param fontFamily The font family used for the text on the button. Default is [FontFamily.Default].
 * @param icon The icon displayed on the button. Default is `null`.
 * @param iconType The type of the icon. It can be of different types Left, Right and Two Sides, Default Default is `null`.
 * @param paddingBetweenIconAndText The padding between the icon and the text on the button. Default is [Dimens.paddingSmall].
 * @param iconColor The color of the icon on the button. Default is [Color.Transparent].
 * @param circularProgressIndicatorSize The size of the circular progress indicator. Default is [Dimens.paddingLarge].
 * @param circularProgressIndicatorColor The color of the circular progress indicator. Default is [Color.White].
 * @param onPressBorderWidth The width of the border around the button when pressed. Default is [Dimens.size_none].
 * @param onPressBorderColor The color of the border around the button when pressed. Default is [Color.Transparent].
 * @param roundedCornerShape The size of the rounded corners of the button. Default is [Dimens.rounded_corner].
 * @param paddingStart The start padding of the button. Default is [Dimens.size_none].
 * @param paddingTop The top padding of the button. Default is [Dimens.paddingMini].
 * @param paddingEnd The end padding of the button. Default is [Dimens.size_none].
 * @param paddingBottom The bottom padding of the button. Default is [Dimens.paddingMini].
 */
data class ButtonStyles(
    val textColor: Color = Color.White,
    val textSize: TextUnit = Dimens.text_medium,
    val height: ButtonHeight = ButtonHeight.Medium,
    val customHeight: Dp = Dimens.size_none,
    val backgroundColor: Color = Color.Transparent,
    val borderColor: Color = Color.Transparent,
    val borderWidth: Dp = Dimens.size_none,
    val fontFamily: FontFamily = FontFamily.Default,
    val icon: Painter? = null,
    val iconType: IconType? = null,
    val paddingBetweenIconAndText: Dp = Dimens.paddingSmall,
    val iconColor: Color = Color.Transparent,
    val circularProgressIndicatorSize: Dp = Dimens.paddingLarge,
    val circularProgressIndicatorColor: Color = Color.White,
    val onPressBorderWidth: Dp = Dimens.size_none,
    val onPressBorderColor: Color = Color.Transparent,
    val roundedCornerShape: Dp = Dimens.rounded_corner,
    val paddingStart: Dp = Dimens.size_none,
    val paddingTop: Dp = Dimens.paddingMini,
    val paddingEnd: Dp = Dimens.size_none,
    val paddingBottom: Dp = Dimens.paddingMini,

    )
/**
 * Enumeration representing different heights for a button.
 * - [Small]: Represents a small-sized button.
 * - [Medium]: Represents a medium-sized button.
 * - [Large]: Represents a large-sized button.
 * - [Custom]: Represents a button with a custom height.
 */
enum class ButtonHeight {
    Small,
    Medium,
    Large,
    Custom,
}

/**
 * Enumeration representing different types of icons on a button.
 * - [Left]: Represents an icon positioned to the left of the button text.
 * - [Right]: Represents an icon positioned to the right of the button text.
 * - [TwoSides]: Represents icons positioned on both sides of the button text.
 */
enum class IconType {
    Left,
    Right,
    TwoSides,
}


@Composable
        /**
         * A composable function to render a custom button with specified configurations.
         *
         * @param text The text to display on the button. Default is `null`.
         * @param onClick The callback to be invoked when the button is clicked.
         */
fun CustomButton(
    text: String? = "Lorem",
    onClick: () -> Unit,
    buttonStyles: ButtonStyles = ButtonStyles(backgroundColor = Color.Blue, textColor = Color.White ),
    isLoading: Boolean = false,
    isDisabled: Boolean = false,
) {
    ButtonRenderByState(text, onClick,buttonStyles,isLoading,isDisabled)
}