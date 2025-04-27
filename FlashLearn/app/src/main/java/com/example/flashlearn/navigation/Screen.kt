package com.example.flashlearn.navigation

//Định nghĩa các màn hình trong navigation
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")

    // Các màn hình trong Bottom Navigation
    object Home : Screen("home")
    object Category : Screen("category")
    object Add : Screen("add")
    object Progress : Screen("progress")
    object Profile : Screen("profile")

    object FolderDetail : Screen("folder_detail/{categoryId}") {
        fun passCategoryId(categoryId: Int) = "folder_detail/$categoryId"
    }
    object EditFolderDetail : Screen("edit_folder_detail/{categoryId}") {
        fun passCategoryId(id: Int): String = "edit_folder_detail/$id"
    }
    object FlashcardReview : Screen("review/{categoryId}") {
        fun passCategoryId(categoryId: Int) = "review/$categoryId"
    }

    // Quiz
    object StartMiniQuiz : Screen("start_mini_quiz/{categoryId}") {
        fun createRoute(categoryId: Int) = "start_mini_quiz/$categoryId"
    }
    object MiniQuiz : Screen("mini_quiz/{categoryId}") {
        fun createRoute(categoryId: Int) = "mini_quiz/$categoryId"
    }
    object MiniQuizResult : Screen("mini_quiz_result/{total}/{correct}") {
        fun createRoute(total: Int, correct: Int) = "mini_quiz_result/$total/$correct"
    }
}
