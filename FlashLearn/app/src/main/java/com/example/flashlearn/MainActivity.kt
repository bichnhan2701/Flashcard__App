package com.example.flashlearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.flashlearn.data.repository.PreferencesRepository
import com.example.flashlearn.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences = PreferencesRepository(applicationContext)

        setContent {
            val navController = rememberNavController()
            NavGraph(navController = navController, preferences = preferences)
        }
    }
}
