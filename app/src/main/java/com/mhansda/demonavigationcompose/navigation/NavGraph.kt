package com.mhansda.demonavigationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mhansda.demonavigationcompose.screens.HomeScreen
import com.mhansda.demonavigationcompose.screens.ProfileScreen
import com.mhansda.demonavigationcompose.screens.SettingScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBarItem.Home.route){
        composable(BottomBarItem.Home.route){
            HomeScreen()
        }
        composable(BottomBarItem.Profile.route){
            ProfileScreen()
        }
        composable(BottomBarItem.Settings.route){
            SettingScreen()
        }
    }
}