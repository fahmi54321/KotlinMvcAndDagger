package com.android.a2mvcdandagger.common.dependencyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Component
import dagger.Provides

@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity(): AppCompatActivity

    fun screenNavigator(): ScreenNavigator

    fun layoutInflater(): LayoutInflater

    fun fragmentManager(): FragmentManager

    fun stackoverflowApi():StackoverflowApi

}