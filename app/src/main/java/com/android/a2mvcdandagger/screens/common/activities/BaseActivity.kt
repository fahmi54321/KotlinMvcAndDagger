package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.*

open class BaseActivity:AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appComponent
    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this,appCompositionRoot))
            .build()
    }

    //todo 4
    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    //todo 5 (next BaseFragment)
    protected val injector get() = Injector(presentationComponent)
}