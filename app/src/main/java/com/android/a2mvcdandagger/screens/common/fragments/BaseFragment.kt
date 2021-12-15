package com.android.a2mvcdandagger.screens.common.fragments

import androidx.fragment.app.Fragment
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseFragment:Fragment() {

    private val presentationModule by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot))
            .build()
    }

    //todo 3 (next PresentationComponent)
    protected val injector get() = presentationModule
}