package com.example.moviehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviehub.R

@Composable
fun IconButton(
    label: String = "",
    icon: ImageVector,
    onPress: () -> Unit,
    isEnabled: Boolean = true
) {
    Button(
        onClick = onPress,
        enabled = isEnabled,
        modifier = Modifier
            .background(color = colorResource(R.color.gold), shape = RoundedCornerShape(5.dp))
            .height(30.dp)
            .width(100.dp),
        colors = ButtonColors(
            contentColor = colorResource(R.color.black_two),
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colorResource(R.color.black_two),
        ),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
    ) {
        Icon(
            imageVector = icon,
            modifier = Modifier.size(24.dp),
            contentDescription = "{$label}_icon",
            tint = colorResource(R.color.black_two)
        )
        if (label.isNotEmpty()) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    IconButton(label = "Play", icon = Icons.Rounded.PlayArrow, onPress = {})
}