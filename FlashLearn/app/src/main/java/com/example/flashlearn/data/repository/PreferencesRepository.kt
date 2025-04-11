package com.example.flashlearn.data.repository

import android.content.Context

// Lưu trữ theme, font chữ, cài đặt người dùng
// Thêm xử lý để lưu và kiểm tra trạng thái đã xem Onboarding
class PreferencesRepository(context: Context) {
    private val sharedPrefs = context.getSharedPreferences("flashcard_prefs", Context.MODE_PRIVATE)

    fun setSeenOnboarding() {
        sharedPrefs.edit().putBoolean("seen_onboarding", true).apply()
    }

    fun hasSeenOnboarding(): Boolean {
        return sharedPrefs.getBoolean("seen_onboarding", false)
    }
}
