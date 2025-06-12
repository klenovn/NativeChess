package com.klenovn.navigation

interface NavigationDestination {
    val route: String

    object Menu : NavigationDestination {
        override val route = "nativechess://menu"
    }

    object Game : NavigationDestination {
        override val route = "nativechess://game"
    }

    object Settings : NavigationDestination {
        override val route = "nativechess://settings"
    }

    companion object {
        fun fromRoute(route: String): NavigationDestination? = when (route) {
            Menu.route -> Menu
            Game.route -> Game
            Settings.route -> Settings
            else -> null
        }
    }
}