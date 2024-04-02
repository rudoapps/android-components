package es.rudo.components.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import es.rudo.components.button.ButtonState.Default
import es.rudo.components.button.ButtonState.Disabled
import es.rudo.components.button.ButtonState.Loading
import es.rudo.components.button.ButtonState.Pressed

/**
 * Enumeration representing different states of a button.
 * - [Default]: Represents the default state of the button.
 * - [Pressed]: Represents the pressed state of the button.
 * - [Loading]: Represents the loading state of the button.
 * - [Disabled]: Represents the disabled state of the button.
 */
enum class ButtonState {
    Default,
    Pressed,
    Loading,
    Disabled,
}

/**
 * Composable function to render a button based on its current state.
 *
 * @param text The text to display on the button. Default is `null`.
 * @param onClick The callback to be invoked when the button is clicked.
 */
@Composable
fun ButtonRenderByState(
    text: String? = "Lorem",
    onClick: () -> Unit,
    buttonStyles: ButtonStyles = ButtonStyles(
        backgroundColor = Color.Blue,
        textColor = Color.White
    ),
    isLoading: Boolean = false,
    isDisabled: Boolean = false,
) {
    //TODO: manejar state con MutableState local
    //TODO: la configuración que le pasas al botón tiene que ser del tipo del STATE en el que se encuentra. Si no encuentras el tipo se asigna el default

    val state: MutableState<ButtonState> = remember { mutableStateOf(Default) }


    if (isLoading) {
        state.value = Loading
    }

    if (isDisabled) {
        state.value = Disabled
    }

    when (state.value) {
        Default -> {
            ButtonComponent(
                text = text,
                onClick = {
                    onClick
                },
                buttonStyles = buttonStyles,
                state = state
            )
        }
        Loading -> {
            ButtonComponent(
                text = text,
                onClick = {
                    onClick
                },
                buttonStyles = buttonStyles,
                state = state
            )
        }


        else -> {}
    }


}



