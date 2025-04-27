package com.example.flashlearn.di

import com.example.flashlearn.data.remote.FirebaseRemoteDataSource
import com.example.flashlearn.data.remote.FirebaseRemoteDataSourceImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseRemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseRemoteDataSource(
        impl: FirebaseRemoteDataSourceImpl
    ): FirebaseRemoteDataSource

    companion object {
        @Provides
        @Singleton
        fun provideDatabaseReference(): DatabaseReference {
            return com.google.firebase.database.FirebaseDatabase.getInstance().reference
        }
    }
}