package com.android.a2mvcdandagger.screens.common.fragments

import androidx.fragment.app.Fragment
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    //todo 6 hapus UseCasesModule (next Lakukan hal yang sama pada PresentationModule) (finish)
    private val presentationModule by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationModule
}