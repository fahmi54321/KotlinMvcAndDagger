package com.android.a2mvcdandagger.screens.common.fragments

import androidx.fragment.app.Fragment
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.DaggerPresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseFragment:Fragment() {

    private val presentationModule by lazy {
        DaggerPresentationComponent.builder()
            .activityComponent((requireActivity() as BaseActivity).activityComponent)
            .presentationModule(PresentationModule())
            .build()
    }

    protected val injector: PresentationComponent get() = presentationModule
}