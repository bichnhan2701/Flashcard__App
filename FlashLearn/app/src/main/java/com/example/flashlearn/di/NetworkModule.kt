package com.example.flashlearn.di

import android.content.Context
import com.example.flashlearn.ui.network.NetworkObserver
import com.example.flashlearn.ui.network.NetworkObserverImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkObserver(
        @ApplicationContext context: Context
    ): NetworkObserver {
        return NetworkObserverImpl(context)
    }
}
