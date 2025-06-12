package com.klenovn.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class AppNavigationManager @Inject constructor(
    private val navController: NavController
) : NavigationManager {
    override fun navigate(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.Deeplink -> {
                navController.navigate(command.uri) {
                    launchSingleTop = true
                    restoreState = true
                }
            }

            is NavigationCommand.Back -> {
                if (command.destinationId != null) navController.popBackStack(command.destinationId, false)
                else navController.popBackStack()
            }
        }
    }
}