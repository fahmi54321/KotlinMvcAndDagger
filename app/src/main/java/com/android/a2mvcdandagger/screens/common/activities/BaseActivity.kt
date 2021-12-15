package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.ActivityModule
import com.android.a2mvcdandagger.common.dependencyinjection.DaggerPresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.Injector
import com.android.a2mvcdandagger.common.dependencyinjection.PresentationModule

open class BaseActivity:AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appModule
    val activityCompositionRoot by lazy {
        ActivityModule(this, appCompositionRoot)
    }

    //todo 4
    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityCompositionRoot))
            .build()
    }

    //todo 5 (next BaseFragment)
    protected val injector get() = Injector(presentationComponent)
}