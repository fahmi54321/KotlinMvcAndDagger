package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity(): AppCompatActivity

    fun screenNavigator(): ScreenNavigator

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

}