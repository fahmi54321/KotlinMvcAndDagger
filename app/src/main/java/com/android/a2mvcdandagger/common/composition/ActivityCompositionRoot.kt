package com.android.a2mvcdandagger.common.composition

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screenNavigator by lazy {
        ScreenNavigator(activity)
    }

    val application get() = appCompositionRoot.application

    val layoutInflater get() = LayoutInflater.from(activity)
    val fragmentManager get() = activity.supportFragmentManager
    val stackoverflowApi get() = appCompositionRoot.stackoverflowApi
}