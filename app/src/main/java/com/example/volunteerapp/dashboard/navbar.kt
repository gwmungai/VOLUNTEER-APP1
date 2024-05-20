package com.example.volunteerapp.dashboard

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.volunteerapp.R
import com.example.volunteerapp.navigation.ROUTE_HOME
import com.example.volunteerapp.navigation.ROUTE_LIST
import com.example.volunteerapp.navigation.ROUTE_PROFILE

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomAppBar(
        containerColor = Color.White,
        ) {
        IconButton(onClick = { navController.navigate(ROUTE_HOME) }) {
            Image(
                painter = painterResource(id = R.drawable.design_ic_home),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { navController.navigate(ROUTE_LIST) }) {
            Image(
                painter = painterResource(id = R.drawable.design_ic_list),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { navController.navigate(ROUTE_PROFILE) }) {
            Image(
                painter = painterResource(id = R.drawable.design_ic_profile),
                contentDescription = null
            )
        }
    }
}




