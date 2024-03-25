package es.rudo.democomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rudo.components.button.ButtonState
import es.rudo.components.button.ButtonStyles
import es.rudo.components.button.CustomButton
import es.rudo.democomponents.ui.theme.DarkBlue
import es.rudo.democomponents.ui.theme.Pink
import es.rudo.democomponents.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            testingButtons()
        }
    }
}

@Composable
fun testingButtons() {

    val mutableStateFlowTestButton1 =
        remember { mutableStateOf(ButtonState.Default) }
    val mutableStateFlowTestButton2 =
        remember { mutableStateOf(ButtonState.Default) }

    val standardStyleNoBorder =
        ButtonStyles(
            text = "Lorem",
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
        )

    val standardStyleWithBorder =
        ButtonStyles(
            text = "Lorem",
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp
        )

    val standardStyleNoBorderNoBackground =
        ButtonStyles(
            text = "Lorem",
            textColor = Pink,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = Pink,
        )
    val standardStyleOnlyIcon =
        ButtonStyles(
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue
        )

    Column {

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorder,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleWithBorder,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorderNoBackground,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box (
            modifier = Modifier.width(50.dp).border(width = 2.dp, color = Color.Yellow)
        ){
            CustomButton(
                onClick = {},
                buttonStyles = standardStyleOnlyIcon,
                buttonState = mutableStateFlowTestButton1
            )
        }
        CustomButton(
            onClick = {},
            buttonStyles = standardStyleOnlyIcon,
            buttonState = mutableStateFlowTestButton1
        )


    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    testingButtons()
}
