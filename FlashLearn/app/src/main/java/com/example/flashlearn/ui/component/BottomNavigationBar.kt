package com.example.flashlearn.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flashlearn.navigation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Progress,
        BottomNavItem.Profile
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        color = Color.Transparent,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        modifier = Modifier
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                clip = false
            )
            .background(Color.White),
    ) {
        NavigationBar(
            containerColor = Color.White,
            tonalElevation = 5.dp
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(Screen.Home.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            item.icon,
                            contentDescription = item.label,
                            modifier = Modifier.size(24.dp),
                            tint = Color(0xFF182E53)
                        )
                    },
                    label = if (item.label.isNotEmpty()) { { Text(item.label, color = Color(0xFF182E53)) } } else null,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFFDAEAF7) // màu nền khi selected
                    )

                )
            }
        }
    }
}
