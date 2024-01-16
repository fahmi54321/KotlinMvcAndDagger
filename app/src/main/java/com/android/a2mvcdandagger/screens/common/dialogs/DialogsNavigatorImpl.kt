package com.android.a2mvcdandagger.screens.common.dialogs

import androidx.fragment.app.FragmentManager
import javax.inject.Inject

class DialogsNavigatorImpl @Inject constructor(
    private val fragmentManager: FragmentManager
) : DialogsNavigator {

    override fun showServerErrorDialogFragment(){
        fragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }
}