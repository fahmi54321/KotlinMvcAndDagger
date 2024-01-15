package com.android.a2mvcdandagger.common.viewmodel

import androidx.activity.result.ActivityResultRegistryOwner
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

// todo 8 (finish)
class ViewModelFactory @Inject constructor(
    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    saveStatedRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(saveStatedRegistryOwner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {

        val provider = providersMap[modelClass]
        val viewModel = provider?.get() ?: throw RuntimeException("unsupported viewmodel type: $modelClass")

        if (viewModel is SavedStateViewModel) {
            viewModel.init(handle)
        }

        return viewModel as T
    }
}