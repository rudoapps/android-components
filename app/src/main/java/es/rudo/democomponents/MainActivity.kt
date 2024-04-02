package es.rudo.democomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rudo.components.button.ButtonHeight
import es.rudo.components.button.ButtonStyles
import es.rudo.components.button.CustomButton
import es.rudo.components.button.IconType
import es.rudo.democomponents.ui.theme.DarkBlue
import es.rudo.democomponents.ui.theme.Pink
import es.rudo.democomponents.ui.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.TimerTask

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingButtons()
        }
    }
}

@Composable
fun TestingButtons() {

    val standardStyleNoBorderSmall =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Small,
        )
    val onPressStyle =
        ButtonStyles(
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp,
            onPressBorderColor = Color.Red,
            onPressBorderWidth = 3.dp
        )
    val disabledStyle =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue.copy(0.5F),
            height = ButtonHeight.Small,
            onPressBorderColor = Color.Red
        )
    val isLoadingStyle =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = Color.Red,
            height = ButtonHeight.Small,
            circularProgressIndicatorColor = Color.Blue
        )

    val standardStyleNoBorderMedium =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Medium
        )
    val standardStyleNoBorderLarge =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Large
        )

    val standardStyleWithBorderLeftIcon =
        ButtonStyles(
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp
        )
    val standardStyleWithBorderRightIcon =
        ButtonStyles(
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp,
            iconType = IconType.Right
        )
    val standardStyleWithBorderTwoIcons =
        ButtonStyles(
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp,
            iconType = IconType.TwoSides
        )

    val standardStyleNoBorderNoBackground =
        ButtonStyles(
            textColor = Pink,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = Pink,
        )
    val standardStyleOnlyIcon =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Custom,
            customHeight = 50.dp
        )

    data class ButtonTestUiStates(
        val isLoading: Boolean = false,
    )

    val uiState: MutableStateFlow<ButtonTestUiStates> =
        MutableStateFlow(ButtonTestUiStates())
    val testUiState: StateFlow<ButtonTestUiStates> = uiState.asStateFlow()

    fun setIsLoading(isLoading: Boolean) {
        uiState.update { it.copy(isLoading = isLoading) }
    }

    val testUiStateCollect by testUiState.collectAsState()
    val isLoading = testUiStateCollect.isLoading

    Column {
        Button(
            onClick = { setIsLoading(true) },
        ) {
            Text(text = "setLoading")
        }
        Button(
            onClick = { setIsLoading(false)  },
        ) {
            Text(text = "setDefault")
        }

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorderSmall,
            isLoading = isLoading
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier.width(50.dp)
        ) {
            CustomButton(
                onClick = {},
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    TestingButtons()
}
