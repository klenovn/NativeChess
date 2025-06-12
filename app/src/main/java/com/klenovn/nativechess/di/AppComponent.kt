package com.klenovn.nativechess.di

import com.klenovn.navigation.NavigationManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {
    fun navigationManager(): NavigationManager

    @Component.Factory
    interface Factory {
        fun create(module: NavigationModule): AppComponent
    }
}