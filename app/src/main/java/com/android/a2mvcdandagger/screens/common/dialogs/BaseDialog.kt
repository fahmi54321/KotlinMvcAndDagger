package com.android.a2mvcdandagger.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseDialog:DialogFragment() {

    private val presentationModule by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(this) //todo 11 (next Questions)
        )
    }

    protected val injector get() = presentationModule

}