package com.example.moviehub.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviehub.R

@Composable
fun CustomButton(
    buttonType: String,
    label: String,
    onPress: () -> Unit,
    isEnabled: Boolean = true
) {
    if (buttonType == "Primary") {
        Button(
            modifier = Modifier.width(280.dp),
            onClick = onPress,
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 15.dp),
            colors = ButtonColors(
                contentColor = colorResource(R.color.button_primary_text),
                containerColor = colorResource(R.color.button_primary),
                disabledContainerColor = colorResource(R.color.grey_two),
                disabledContentColor = colorResource(R.color.black_two),
            ),
            enabled = isEnabled
        ) {
            Text(text = label, letterSpacing = 2.sp)
        }
    } else if (buttonType == "Secondary") {
        Button(
            onClick = onPress,
            colors = ButtonColors(
                contentColor = colorResource(R.color.button_primary_text),
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = colorResource(R.color.black_two),
            ),
            enabled = isEnabled
        ) {
            Text(text = label, letterSpacing = 2.sp)
        }
    } else {
        Button(onClick = onPress, enabled = isEnabled) {
            Text(text = label)
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    CustomButton(
        buttonType = "Primary",
        label = "Primary Button",
        onPress = {},
        isEnabled = true
    )
}

@Preview
@Composable
fun PrimaryButtonDisabledPreview() {
    CustomButton(
        buttonType = "Primary",
        label = "Primary Button",
        onPress = {},
        isEnabled = false
    )
}

@Preview
@Composable
fun SecondaryButtonPreview() {
    CustomButton(
        buttonType = "Secondary",
        label = "Secondary Button",
        onPress = {},
        isEnabled = true
    )
}

@Preview
@Composable
fun SecondaryButtonDisabledPreview() {
    CustomButton(
        buttonType = "Secondary",
        label = "Primary Button",
        onPress = {},
        isEnabled = false
    )
}

@Preview
@Composable
fun NormalButtonPreview() {
    CustomButton(
        buttonType = "Normal",
        label = "Normal Button",
        onPress = {},
        isEnabled = true
    )
}

@Preview
@Composable
fun NormalButtonDisabledPreview() {
    CustomButton(
        buttonType = "Normal",
        label = "Normal Button",
        onPress = {},
        isEnabled = false
    )
}