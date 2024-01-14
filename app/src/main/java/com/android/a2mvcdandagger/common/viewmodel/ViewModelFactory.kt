package com.android.a2mvcdandagger.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val myViewModelProvider: Provider<MyViewModel>,
    private val myViewModelProvider2: Provider<MyViewModel2>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            MyViewModel::class.java -> myViewModelProvider.get() as T
            MyViewModel2::class.java -> myViewModelProvider2.get() as T
            else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
        }
    }
}