package com.example.flashlearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.ui.component.BottomNavItem
import com.example.flashlearn.ui.screen.AddNewFolderScreen
import com.example.flashlearn.ui.screen.HomeScreen
import com.example.flashlearn.ui.screen.OnboardingScreen
import com.example.flashlearn.ui.screen.SplashScreen

//Quản lý điều hướng màn hình
@Composable
fun NavGraph(navController: NavHostController, preferences: PreferencesRepository) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController, preferences)
        }
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onSkip = {
                    preferences.setSeenOnboarding()
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                },
                onDone = {
                    preferences.setSeenOnboarding()
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(BottomNavItem.Category.route) { /* CategoryScreen */ }
        composable(Screen.Add.route) {
            AddNewFolderScreen(
                onCancel = {
                    navController.popBackStack() // hoặc điều hướng về màn hình chính
                }
            )
        }

        composable(BottomNavItem.Stats.route) { /* StatsScreen */ }
        composable(BottomNavItem.Profile.route) { /* ProfileScreen */ }
    }
}
