package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule

open class BaseActivity:AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appModule
    val activityCompositionRoot by lazy {
        ActivityModule(this, appCompositionRoot)
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityCompositionRoot))
            .build()
    }

    protected val injector get() = presentationComponent //todo 7 (next PresentationComponent)
}