package com.android.a2mvcdandagger.screens.viewmodel

import androidx.lifecycle.*
import com.android.a2mvcdandagger.questions.Question
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private var _questions: MutableLiveData<List<Question>> = savedStateHandle.getLiveData("questions")
    val question: LiveData<List<Question>> get() = _questions

     init {

        viewModelScope.launch {
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success) {
                _questions.value = result.questions
            } else {
                throw RuntimeException("fetch failed")
            }
        }
    }
}