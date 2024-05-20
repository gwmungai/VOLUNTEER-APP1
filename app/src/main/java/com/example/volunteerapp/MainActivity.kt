package com.example.volunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.navigation.AppNavHost
import com.example.volunteerapp.ui.theme.VOLUNTEERAPPTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VOLUNTEERAPPTheme {
                val context = this
                AppNavHost(
                    navController = rememberNavController(),
                    context = context ,
                    onSignUpSuccess = {  })
                FirebaseApp.initializeApp(this)
            }
        }
    }
}
