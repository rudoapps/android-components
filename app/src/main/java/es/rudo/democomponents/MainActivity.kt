package es.rudo.democomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rudo.components.button.ButtonHeight
import es.rudo.components.button.ButtonState
import es.rudo.components.button.ButtonStyles
import es.rudo.components.button.CustomButton
import es.rudo.components.button.IconType
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

    val standardStyleNoBorderSmall =
        ButtonStyles(
            text = "Lorem",
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Small,
        )
    val standardStyleNoBorderMedium =
        ButtonStyles(
            text = "Lorem",
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Medium
        )
    val standardStyleNoBorderLarge =
        ButtonStyles(
            text = "Lorem",
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Large
        )

    val standardStyleWithBorderLeftIcon =
        ButtonStyles(
            text = "Lorem",
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp
        )
    val standardStyleWithBorderRightIcon =
        ButtonStyles(
            text = "Lorem",
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp,
            iconType = IconType.Right
        )
    val standardStyleWithBorderTwoIcons =
        ButtonStyles(
            text = "Lorem",
            textColor = DarkBlue,
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = DarkBlue,
            borderColor = DarkBlue,
            borderWidth = 2.dp,
            iconType = IconType.TwoSides
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
            backgroundColor = DarkBlue,
            height = ButtonHeight.Custom,
            customHeight = 50.dp
        )

    Column {

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorderSmall,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))
        
        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorderMedium,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleNoBorderLarge,
            buttonState = mutableStateFlowTestButton1
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleWithBorderLeftIcon,
            buttonState = mutableStateFlowTestButton1
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleWithBorderRightIcon,
            buttonState = mutableStateFlowTestButton1
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonStyles = standardStyleWithBorderTwoIcons,
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
            modifier = Modifier.width(50.dp)
        ){
            CustomButton(
                onClick = {},
                buttonStyles = standardStyleOnlyIcon,
                buttonState = mutableStateFlowTestButton1,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

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
