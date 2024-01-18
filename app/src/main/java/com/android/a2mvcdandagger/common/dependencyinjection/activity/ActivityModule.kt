package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigatorImpl
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @ActivityScoped
    @Binds
    abstract  fun screenNavigator(screenNavigatorImpl: ScreenNavigatorImpl) : ScreenNavigator

    @Binds
    abstract  fun dialogNavigator(dialogsNavigatorImpl: DialogsNavigatorImpl) : DialogsNavigator

   companion object{

       @Provides
       fun appCompatActivity(activity: Activity): AppCompatActivity = activity as AppCompatActivity

       @Provides
       fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

       @Provides
       fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
   }
}