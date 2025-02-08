package com.example.moviehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviehub.R

@Composable
fun ProfileCard(name: String, type: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.grey))
            .padding(24.dp)
    ) {
        Column {
            Text(
                text = name,
                color = colorResource(R.color.white_two),
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = type, color = colorResource(R.color.grey_two), fontSize = 16.sp)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileCardPreview() {
    ProfileCard("Rakesh", "Adult")
}

