package com.example.moviehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.R

@Composable
fun NavigationBar(title: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(colorResource(R.color.grey))
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = "back_button",
            tint = colorResource(R.color.gold),
            modifier = Modifier.clickable(
                onClick = {
                    navController.popBackStack()
                }
            )
        )
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.gold),
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewNavigationBar() {
    val navController = rememberNavController()
    NavigationBar("Movie Preview", navController)
}