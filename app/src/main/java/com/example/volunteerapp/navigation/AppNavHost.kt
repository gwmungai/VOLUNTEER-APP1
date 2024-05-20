package com.example.volunteerapp.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.dashboard.BottomNavigationBar
import com.example.volunteerapp.ui.theme.screens.accounts.LoginScreen
import com.example.volunteerapp.ui.theme.screens.accounts.SignUpScreen
import com.example.volunteerapp.ui.theme.screens.home.HomeScreen
import com.example.volunteerapp.ui.theme.screens.list.ListScreen
import com.example.volunteerapp.ui.theme.screens.profile.AboutUsScreen
import com.example.volunteerapp.ui.theme.screens.profile.ProfileScreen
import com.example.volunteerapp.ui.theme.screens.profile.SettingsScreen
import com.example.volunteerapp.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               context: Context,
               onSignUpSuccess: () ->Unit,
               startDestination: String= ROUTE_LOGIN
) {
    val currentRoute = currentRoute(navController)
    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(ROUTE_HOME, ROUTE_LIST, ROUTE_PROFILE)) {
            BottomNavigationBar(navController)
        }
}
    ) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = modifier.padding(innerPadding),
            startDestination = startDestination
        ) {
            composable(ROUTE_HOME){
                HomeScreen(navController)
            }
            composable(ROUTE_LIST) {
                ListScreen(navController)
            }
            composable(ROUTE_PROFILE) {
                ProfileScreen(navController)
            }
            composable(ROUTE_SIGNUP) {
                SignUpScreen(navController, onSignUpSuccess)
            }
            composable(ROUTE_LOGIN) {
                LoginScreen(navController,context)
            }
            composable(ROUTE_SETTINGS) {
                SettingsScreen(navController)
            }
            composable(ROUTE_ABOUTUS) {
                AboutUsScreen(navController)
            }
            composable(ROUTE_SPLASH) {
                SplashScreen(navController)
            }
        }
    }
}
@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry = navController.currentBackStackEntry
    return navBackStackEntry?.destination?.route
}