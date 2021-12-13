package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.dependencyinjection.ActivityCompositionRoot
import com.android.a2mvcdandagger.common.dependencyinjection.Injector
import com.android.a2mvcdandagger.common.dependencyinjection.PresentationCompositionRoot

open class BaseActivity:AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    private val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }

    //todo 8 (next QuestionsDetailsActivity)
    protected val injector get() = Injector(compositionRoot)
}