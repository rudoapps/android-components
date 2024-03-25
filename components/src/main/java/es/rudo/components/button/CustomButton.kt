package es.rudo.components.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ButtonStyles(
    val text: String? = null,
    //TODO documentation
    val textColor: Color = Color.White,
    //TODO documentation
    val textSize: TextUnit = 16.sp,
    //TODO documentation
    val backgroundColor: Color = Color.Transparent,
    //TODO documentation
    val borderColor: Color = Color.Transparent,
    //TODO documentation
    val fontFamily: FontFamily? = null,
    //TODO documentation
    //TODO implementation
    val icon: Painter? = null,
    //TODO documentation
    val iconColor: Color = Color.Transparent,
    //TODO documentation
    val circularProgressIndicatorSize: Dp = 24.dp,
    //TODO documentation
    val borderWidth: Dp = 2.dp,
    //TODO documentation
    val circularProgressIndicatorColor: Color = borderColor,
    //TODO documentation
    val onClickBorderWidth: Dp = 5.dp,
    //TODO documentation
    val onClickBorderColor: Color = Color.Transparent
    //TODO documentation
)


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