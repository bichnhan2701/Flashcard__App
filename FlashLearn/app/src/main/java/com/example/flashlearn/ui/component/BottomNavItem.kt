package com.example.flashlearn.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem("home", Icons.Outlined.Home, "Home")
    object Category : BottomNavItem("category", Icons.Outlined.Email, "Category")
    object Add : BottomNavItem("add", Icons.Outlined.AddCircle, "")
    object Stats : BottomNavItem("stats", Icons.Outlined.Menu, "Stats")
    object Profile : BottomNavItem("profile", Icons.Outlined.Person, "Profile")
}