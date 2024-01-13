package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule

open class BaseActivity:AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    //todo 4 (next MyApplication)
    val activityComponent by lazy {
        appComponent.newActivityCompononent()
            .activityModule(ActivityModule(this))
            .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}