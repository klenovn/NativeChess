package com.klenovn.navigation

sealed interface NavigationCommand {
    class Deeplink(val uri: String) : NavigationCommand
    class Back(val destinationId: Int? = null) : NavigationCommand
}