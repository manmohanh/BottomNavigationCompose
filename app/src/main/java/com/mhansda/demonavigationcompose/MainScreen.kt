package com.mhansda.demonavigationcompose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mhansda.demonavigationcompose.navigation.BottomBarItem
import com.mhansda.demonavigationcompose.navigation.NavGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}) {
        NavGraph(navController = navController)
    }
}
@Composable
fun BottomBar(navController:NavHostController){
    val screens = listOf(
        BottomBarItem.Home,
        BottomBarItem.Profile,
        BottomBarItem.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach { screen ->
            AddItem(screens = screen,
                currentDestination = currentDestination,
                navController = navController)
        }
    }
}
@Composable
fun RowScope.AddItem(
    screens:BottomBarItem,
    currentDestination:NavDestination?,
    navController: NavController
){
    BottomNavigationItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(
                imageVector = screens.icon,
                contentDescription = "BottomNavigation items"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screens.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
        onClick = {
            navController.navigate(screens.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    )
}