package com.mhansda.demonavigationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val route:String,
    val title:String,
    val icon:ImageVector
){
    object Home:BottomBarItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile:BottomBarItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Settings:BottomBarItem(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}
