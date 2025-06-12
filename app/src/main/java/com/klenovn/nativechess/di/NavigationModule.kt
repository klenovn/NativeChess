package com.klenovn.nativechess.di

import androidx.navigation.NavController
import com.klenovn.navigation.AppNavigationManager
import com.klenovn.navigation.NavigationManager
import dagger.Module
import dagger.Provides

@Module
class NavigationModule(private val navController: NavController) {

    @Provides
    fun provideNavigationManager(): NavigationManager = AppNavigationManager(navController)
}