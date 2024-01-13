package com.android.a2mvcdandagger.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseDialog:DialogFragment() {

    private val presentationModule by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationModule

}