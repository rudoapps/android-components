package es.rudo.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

enum class ButtonState {
    Default,
    Pressed,
    Released,
    Loading,
    Disabled,
}

@Composable
fun ButtonRenderByState(
    onClick: () -> Unit,
    buttonStyles: ButtonStyles = ButtonStyles(),
    state: MutableState<ButtonState>
    //pasar el estado que seria un mutable stateflow que recibimos desde customButtomItem
) {
    //var buttonState by remember { mutableStateOf(ButtonState.Default) }

    when (state.value) {
        /*ButtonState.Default -> {
            Button(
                onClick = {
                    state.value = ButtonState.Pressed
                    onClick()
                },
                modifier = Modifier.background(Color.Red)
            ) {
                Text("default")
            }
        }*/
        ButtonState.Default -> {
            Card(
                shape = RoundedCornerShape(100.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth().border(width = 2.dp,color= Color.Red)
                    .height(50.dp), //TODO add enum type for height button (small , medium , large , custom )
                border = BorderStroke(
                    width = 5.dp,
                    color = buttonStyles.onClickBorderColor
                )
            ){
                Button(
                    onClick = {
                        state.value = ButtonState.Pressed
                        onClick()
                    },
                    shape = RoundedCornerShape(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonStyles.backgroundColor,
                        contentColor = buttonStyles.textColor,
                        disabledContainerColor = buttonStyles.backgroundColor.copy(0.5F),
                        disabledContentColor = buttonStyles.textColor
                    ),
                    enabled = true,
                    border = BorderStroke(
                        width = buttonStyles.borderWidth,
                        color = buttonStyles.borderColor
                    ),

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (buttonStyles.icon != null) {
                            if (buttonStyles.text?.isNotEmpty() == true){
                                Icon(
                                    buttonStyles.icon, "icon",
                                    modifier = Modifier.padding(end = 6.dp),
                                    tint = buttonStyles.iconColor
                                    //TODO add icon size parameter
                                )
                            }else{
                                Icon(
                                    buttonStyles.icon, "icon",
                                    modifier = Modifier,
                                    tint = buttonStyles.iconColor
                                    //TODO add icon size parameter

                                )
                            }
                        }
                        if (buttonStyles.text?.isNotEmpty() == true) {
                            Text(
                                text = buttonStyles.text,
                                style = TextStyle(fontSize = buttonStyles.textSize),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

        }

        ButtonState.Pressed -> {
            Button(
                onClick = {
                    state.value = ButtonState.Default
                    onClick()
                },
                modifier = Modifier.background(Color.Yellow)
            ) {
                Text("Pressed")
            }
        }


        else -> {}

    }


}



