package com.example.flashlearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.ui.component.BottomNavItem
import com.example.flashlearn.ui.screen.AboutScreen
import com.example.flashlearn.ui.screen.AddNewFolderScreen
import com.example.flashlearn.ui.screen.EditFolderDetailScreen
import com.example.flashlearn.ui.screen.FlashcardReviewScreen
import com.example.flashlearn.ui.screen.FolderDetailScreen
import com.example.flashlearn.ui.screen.HelpScreen
import com.example.flashlearn.ui.screen.HomeScreen
import com.example.flashlearn.ui.screen.MiniQuizResultScreen
import com.example.flashlearn.ui.screen.MiniQuizScreen
import com.example.flashlearn.ui.screen.OnboardingScreen
import com.example.flashlearn.ui.screen.SplashScreen
import com.example.flashlearn.ui.screen.StartMiniQuizScreen
import com.example.flashlearn.ui.screen.UserProfileScreen

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
        composable(BottomNavItem.Add.route) {
            AddNewFolderScreen(navController = navController)
        }
        composable(Screen.Add.route) {
            AddNewFolderScreen(navController = navController)
        }
        composable(BottomNavItem.Stats.route) { /* StatsScreen */ }
        composable(BottomNavItem.Profile.route) {
            UserProfileScreen(navController = navController, preferences = preferences)
        }

        composable(
            route = Screen.FolderDetail.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            FolderDetailScreen(categoryId = categoryId, navController = navController)
        }

        composable(
            route = Screen.EditFolderDetail.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            EditFolderDetailScreen(navController = navController, categoryId = categoryId)
        }

        composable(
            route = Screen.FlashcardReview.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            FlashcardReviewScreen (navController = navController, categoryId = categoryId)
        }

        // Quiz
        composable(Screen.MiniQuiz.route) {
            MiniQuizScreen(navController = navController)
        }
        composable(Screen.StartMiniQuiz.route) {
            StartMiniQuizScreen(navController = navController)
        }
        composable(Screen.MiniQuizResult.route) {
            MiniQuizResultScreen(navController = navController)
        }

        // About
        composable("about") {
            AboutScreen(navController = navController)
        }
        composable("help") {
            HelpScreen(navController = navController)
        }

    }
}
