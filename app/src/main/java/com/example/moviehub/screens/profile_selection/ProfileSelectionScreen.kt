package com.example.moviehub.screens.profile_selection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.R
import com.example.moviehub.components.CustomButton
import com.example.moviehub.components.ProfileCard
import com.example.moviehub.navigation.Route

@Composable
fun ProfileSelectionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 25.dp, horizontal = 20.dp)
    ) {
        ProfileScreenHeader()
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(listOf("Rakesh", "Abinash", "Shubha")) { item ->
                ProfileCard(item, "Adult", onPressCard = {
                    navController.navigate(route = Route.Dashboard.name)
                })
            }
        }
        ProfileScreenFooter(navController)
    }
}

@Composable
fun ProfileScreenHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Movie Hub",
            color = colorResource(R.color.gold),
            fontSize = 32.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Welcome!",
            color = colorResource(R.color.white_two),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Choose a profile to begin", color = colorResource(R.color.grey_two))
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun ProfileScreenFooter(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CustomButton(
            buttonType = "Primary",
            label = "New Profile",
            onPress = { navController.navigate(route = Route.Dashboard.name) },
            isEnabled = false
        )
        CustomButton(
            buttonType = "Secondary",
            label = "Edit Profiles",
            onPress = { navController.navigate(route = Route.Dashboard.name) },
            isEnabled = false
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileSelectionScreenPreview() {
    val navController = rememberNavController()
    ProfileSelectionScreen(navController)
}
