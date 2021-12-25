package com.android.a2mvcdandagger.screens.viewmodel

import androidx.lifecycle.*
import com.android.a2mvcdandagger.common.viewmodel.SavedStateViewModel
import com.android.a2mvcdandagger.questions.Question
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : SavedStateViewModel() { //todo 2

    //todo 3
    private lateinit var _questions: MutableLiveData<List<Question>>
    val question: LiveData<List<Question>> get() = _questions

    //todo 4 (next ViewModelKey)
    override fun init(savedStateHandle: SavedStateHandle) {
        _questions = savedStateHandle.getLiveData("questions")

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