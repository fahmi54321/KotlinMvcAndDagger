package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppComponent
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {

    @Provides
    fun application() = appComponent.application()

    @Provides
    fun stackoverflowApi() = appComponent.stackoverflowApi()

    @Provides
    fun activity() = activity

    @Provides
    @ActivityScope
    fun screenNavigator (activity: AppCompatActivity) = ScreenNavigator(activity)

    @Provides
    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}