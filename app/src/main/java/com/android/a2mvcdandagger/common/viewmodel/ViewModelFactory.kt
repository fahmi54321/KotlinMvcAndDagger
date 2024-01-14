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

class ViewModelFactory @Inject constructor(
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    saveStatedRegistryOwner: SavedStateRegistryOwner //todo 3
) : AbstractSavedStateViewModelFactory(saveStatedRegistryOwner, null) { //todo 4


    //todo 5 (next PresentationComponent)
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(
                fetchQuestionsUseCaseProvider.get(),
                handle
            ) as T

            MyViewModel2::class.java -> MyViewModel2(
                fetchQuestionsUseCaseProvider.get()
            ) as T

            else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
        }
    }
}