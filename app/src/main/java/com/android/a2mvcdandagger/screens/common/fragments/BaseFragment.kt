package com.android.a2mvcdandagger.screens.common.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.a2mvcdandagger.common.composition.PresentationCompositionRoot
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity

open class BaseFragment:Fragment() {
    val compositionRoot by lazy {
        PresentationCompositionRoot((requireActivity() as BaseActivity).activityCompositionRoot)
    }
}