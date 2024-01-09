package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityComponent
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
import com.android.a2mvcdandagger.common.dependencyinjection.activity.DaggerActivityComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity:AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(this))
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent(activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }

    protected val injector: PresentationComponent get() = presentationComponent
}