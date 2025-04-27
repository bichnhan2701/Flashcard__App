package com.example.flashlearn.data.repository

import android.content.SharedPreferences
import com.example.flashlearn.domain.repository.SharedPreferencesRepository
import javax.inject.Inject

class SharedPreferencesRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SharedPreferencesRepository {

    companion object {
        private const val KEY_LAST_SYNCED_AT = "key_last_synced_at"
    }

    override fun getLastSyncedAt(): Long {
        return sharedPreferences.getLong(KEY_LAST_SYNCED_AT, 0L)
    }

    override fun setLastSyncedAt(timestamp: Long) {
        sharedPreferences.edit().putLong(KEY_LAST_SYNCED_AT, timestamp).apply()
    }

    override fun resetLastSyncedAt() {
        setLastSyncedAt(0L)
    }
}