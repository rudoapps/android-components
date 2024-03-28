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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.rudo.components.button.ButtonConfiguration
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
            icon = painterResource(id = es.rudo.components.R.drawable.ic_test_image),
            iconColor = White,
            backgroundColor = DarkBlue,
            height = ButtonHeight.Small,
        )
    val standardStyleNoBorderSmallIsLoading =
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

    val standardStyleNoBorderLargeTest =
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

    Column {
        Button(
            onClick = { mutableStateFlowTestButton2.value = ButtonState.Loading },
        ) {
            Text(text = "setLoading")
        }
        Button(
            onClick = { mutableStateFlowTestButton2.value = ButtonState.Default },
        ) {
            Text(text = "setDefault")
        }
        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton2,
                mutableListOf(standardStyleNoBorderSmall,standardStyleNoBorderSmallIsLoading,standardStyleNoBorderSmallIsLoading)
            ),
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleNoBorderMedium)
            ),
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleNoBorderLarge)
            ),
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleWithBorderLeftIcon)
            ),
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleWithBorderRightIcon)
            ),
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleWithBorderTwoIcons)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Lorem",
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleNoBorderNoBackground)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier.width(50.dp)
        ) {
            CustomButton(
                onClick = {},
                buttonConfiguration = ButtonConfiguration(
                    mutableStateFlowTestButton1,
                    mutableListOf(standardStyleOnlyIcon)
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            onClick = {},
            buttonConfiguration = ButtonConfiguration(
                mutableStateFlowTestButton1,
                mutableListOf(standardStyleOnlyIcon)
            )
        )


    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    testingButtons()
}
