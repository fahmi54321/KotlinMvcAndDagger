package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigatorImpl
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @Binds
    abstract fun screenNavigator(screenNavigatorImpl: ScreenNavigatorImpl): ScreenNavigator

    @Binds
    abstract fun dialogNavigator(dialogNavigator: DialogsNavigatorImpl): DialogsNavigator

    companion object{
        @Provides
        fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }
}