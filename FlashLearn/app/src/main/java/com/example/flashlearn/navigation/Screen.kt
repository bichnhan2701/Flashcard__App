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
    object Profile : Screen("profile")
    object  FolderDetail : Screen( "folder_detail/{folderName}")
    object EditFolderDetail : Screen("edit_folder_detail/{folderName}")
}
