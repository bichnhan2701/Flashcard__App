package com.example.flashlearn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.ui.component.BottomNavItem
import com.example.flashlearn.ui.screen.*

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

        composable(Screen.Add.route) {
            AddNewFolderScreen(navController = navController)
        }
        composable(BottomNavItem.Progress.route) {
            ProgressScreen(
                onCategoryClick = { categoryId ->
                    navController.navigate(Screen.ProgressDetail.createRoute(categoryId))
                },
                onQuizClick = { categoryId ->
                    navController.navigate(Screen.QuizHistory.createRoute(categoryId))
                }
            )
        }

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
        composable(
            route = Screen.StartMiniQuiz.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
            StartMiniQuizScreen(navController = navController, categoryId = categoryId)
        }
        composable(Screen.MiniQuiz.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: return@composable

            MiniQuizScreen(
                categoryId = categoryId,
                onFinish = { total, correct ->
                    navController.navigate(Screen.MiniQuizResult.createRoute(total, correct))
                }
            )
        }
        composable(
            route = Screen.MiniQuizResult.route,
            arguments = listOf(
                navArgument("total") { type = NavType.IntType },
                navArgument("correct") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val total = backStackEntry.arguments?.getInt("total") ?: 0
            val correct = backStackEntry.arguments?.getInt("correct") ?: 0
            MiniQuizResultScreen(navController = navController, total = total, correct = correct)
        }

        // About
        composable("about") {
            AboutScreen(navController = navController)
        }
        composable("help") {
            HelpScreen(navController = navController)
        }

        // Progress
        composable(
            route = Screen.ProgressDetail.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: return@composable
            ProgressDetailScreen(categoryId)
        }

        composable(
            route = Screen.QuizHistory.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: return@composable
            QuizHistoryScreen(categoryId)
        }

        // Notification
        composable(Screen.Notification.route) {
            NotificationScreen(navController = navController)
        }
    }
}
