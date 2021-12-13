package com.android.a2mvcdandagger.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.MyApplication
import com.android.a2mvcdandagger.common.composition.ActivityCompositionRoot
import com.android.a2mvcdandagger.common.composition.PresentationCompositionRoot

open class BaseActivity:AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val activityCompositionRoot by lazy {
        ActivityCompositionRoot(this, appCompositionRoot)
    }

    protected val compositionRoot by lazy {
        PresentationCompositionRoot(activityCompositionRoot)
    }
}