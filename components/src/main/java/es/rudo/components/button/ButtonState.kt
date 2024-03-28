package es.rudo.components.button

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

enum class ButtonState {
    Default,
    Pressed,
    Loading,
    Disabled,
}

@Composable
fun ButtonRenderByState(
    text: String? = null,
    onClick: () -> Unit,
    buttonConfiguration: ButtonConfiguration
) {
    when (buttonConfiguration.state.value) {
        ButtonState.Default -> {
            ButtonComponent(
                text = text,
                onClick = {
                    onClick
                    buttonConfiguration.state.value = ButtonState.Pressed
                },
                buttonStyles = buttonConfiguration.configuration[0],
                state = buttonConfiguration.state
            )
        }

        ButtonState.Pressed -> {
            Button(
                onClick = {
                    buttonConfiguration.state.value = ButtonState.Default
                    onClick()
                },
                modifier = Modifier.background(Color.Yellow)
            ) {
                Text("Pressed")
            }
        }

        ButtonState.Loading -> {
            ButtonComponent(
                text = text,
                onClick = {},
                buttonStyles =
                if (buttonConfiguration.configuration.getOrNull(2) != null) {
                    buttonConfiguration.configuration[2]
                } else {
                    buttonConfiguration.configuration[0]
                },
                state = buttonConfiguration.state
            )
        }

        ButtonState.Disabled -> {
            Button(
                onClick = {
                    buttonConfiguration.state.value = ButtonState.Default
                    onClick()
                },
                modifier = Modifier.background(Color.Yellow)
            ) {
                Text("Disabled")
            }
        }

        else -> {}
    }


}



