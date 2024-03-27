package es.rudo.components.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import es.rudo.components.dimens.Dimens

data class ButtonStyles(
    val text: String? = null,
    //TODO documentation
    val textColor: Color = Color.White,
    //TODO documentation
    val textSize: TextUnit = Dimens.text_medium,
    //TODO documentation
    val height: ButtonHeight = ButtonHeight.Medium,
    //TODO documentation
    val customHeight: Dp = Dimens.size_none,
    //TODO documentation
    val backgroundColor: Color = Color.Transparent,
    //TODO documentation
    val borderColor: Color = Color.Transparent,
    //TODO documentation
    val fontFamily: FontFamily = FontFamily.Default,
    //TODO documentation
    //TODO implementation
    val icon: Painter? = null,
    //TODO documentation
    val iconType: IconType? = null,
    //TODO documentation
    val paddingBetweenIconAndText: Dp = Dimens.paddingSmall,
    //TODO documentation
    val iconColor: Color = Color.Transparent,
    //TODO documentation
    val circularProgressIndicatorSize: Dp = Dimens.paddingLarge,
    //TODO documentation
    val borderWidth: Dp = Dimens.size_none,
    //TODO documentation
    val circularProgressIndicatorColor: Color = borderColor,
    //TODO documentation
    val onClickBorderWidth: Dp = Dimens.size_none,
    //TODO documentation
    val onClickBorderColor: Color = Color.Transparent,
    //TODO documentation
    val roundedCornerShape: Dp = Dimens.rounded_corner,
    //TODO documentation
    val paddingStart: Dp = Dimens.size_none,
    //TODO documentation
    val paddingTop: Dp = Dimens.paddingMini,
    //TODO documentation
    val paddingEnd: Dp = Dimens.size_none,
    //TODO documentation
    val paddingBottom: Dp = Dimens.paddingMini,
    //TODO documentation
)

enum class ButtonHeight {
    Small,
    Medium,
    Large,
    Custom,
}

enum class IconType {
    Left,
    Right,
    TwoSides,
}

@Composable
        /**
         * TODO documentation
         * @param onClick
         * @param buttonStyles
         */
fun CustomButton(
    onClick: () -> Unit,
    buttonStyles: ButtonStyles = ButtonStyles(),
    buttonState: MutableState<ButtonState>
) {
    ButtonRenderByState(onClick, buttonStyles, buttonState)
}