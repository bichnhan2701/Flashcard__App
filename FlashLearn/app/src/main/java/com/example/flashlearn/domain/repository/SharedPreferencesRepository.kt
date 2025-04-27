package com.example.flashlearn.domain.repository

interface SharedPreferencesRepository {
    fun getLastSyncedAt(): Long
    fun setLastSyncedAt(timestamp: Long)
    fun resetLastSyncedAt()
}