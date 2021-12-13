package com.android.a2mvcdandagger.screens.common.dialogs

import androidx.fragment.app.FragmentManager

class DialogsNavigator(
    private val fragmentManager: FragmentManager
) {

    fun showServerErrorDialogFragment(){
        fragmentManager.beginTransaction()
            .add(ServerErrorDialogFragment.newInstance(), null)
            .commitAllowingStateLoss()
    }
}