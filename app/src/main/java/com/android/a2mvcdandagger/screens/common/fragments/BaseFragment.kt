package com.android.a2mvcdandagger.screens.common.fragments

import androidx.fragment.app.Fragment
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    //todo 4 (finish)
    private val presentationModule by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule()
        )
    }

    protected val injector get() = presentationModule
}