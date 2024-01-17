package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides

//todo 1 hapus sevice actvity (next ActivityComponent)
@Module
object ActivityModule {

    @Provides
    @ActivityScope
    fun screenNavigator(activity: AppCompatActivity) = ScreenNavigator(activity)

    @Provides
    fun layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}