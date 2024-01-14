package com.android.a2mvcdandagger.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val provider = providers[modelClass]
        if(provider != null){
            return provider.get() as T
        }else{
            throw RuntimeException("unsupported viewmodel type: $modelClass")
        }

    }
}