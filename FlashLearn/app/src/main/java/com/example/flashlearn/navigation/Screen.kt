package com.example.flashlearn.navigation

//Định nghĩa các màn hình trong navigation
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")

    // Các màn hình trong Bottom Navigation
    object Home : Screen("home")
    object Category : Screen("category")
    object Add : Screen("add")
    object Stats : Screen("stats")
    object UserProfile : Screen("user_profile")

    object FolderDetail : Screen("folder_detail/{categoryId}") {
        fun passCategoryId(categoryId: Int): String = "folder_detail/$categoryId"
    }
    object EditFolderDetail : Screen("edit_folder_detail/{categoryId}") {
        fun passCategoryId(id: Int): String = "edit_folder_detail/$id"
    }
    object FlashcardReview : Screen("review/{categoryId}") {
        fun passCategoryId(categoryId: Int) = "review/$categoryId"
    }

    // Quiz
    object MiniQuiz : Screen("mini_quiz")
    object StartMiniQuiz : Screen("start_mini_quiz")
    object MiniQuizResult : Screen("mini_quiz_result")


}
