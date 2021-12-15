package com.android.a2mvcdandagger.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appModule: AppModule
) {

    val screenNavigator by lazy {
        ScreenNavigator(activity)
    }

    @Provides
    fun application() = appModule.application

    @Provides
    fun stackoverflowApi() = appModule.stackoverflowApi

    @Provides
    fun activity() = activity

    @Provides
    fun screenNavigator (activity: AppCompatActivity) = screenNavigator

    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}