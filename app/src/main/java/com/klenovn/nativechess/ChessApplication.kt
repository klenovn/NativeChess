package com.klenovn.nativechess

import android.app.Application
import androidx.navigation.NavController
import com.klenovn.nativechess.di.AppComponent
import com.klenovn.nativechess.di.DaggerAppComponent
import com.klenovn.nativechess.di.NavigationModule

class ChessApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    fun initAppComponent(navController: NavController) {
        appComponent = DaggerAppComponent.factory().create(NavigationModule(navController))
    }
}