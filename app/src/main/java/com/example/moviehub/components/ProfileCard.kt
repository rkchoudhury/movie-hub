package com.example.moviehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ProfileCard(name: String, type: String, onPressCard: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 10.dp)
            .border(
                width = 2.dp,
                color = colorResource(R.color.black_two),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(24.dp)
            .clickable { onPressCard() },
    ) {
        Text(
            text = name[0].toString(),
            color = colorResource(R.color.white),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .background(
                    color = colorResource(R.color.gold),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(15.dp, 8.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 6.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                color = colorResource(R.color.white_two),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = type,
                color = colorResource(R.color.grey_two),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun ProfileCardPreview() {
    ProfileCard("Rakesh", "Adult", {})
}

