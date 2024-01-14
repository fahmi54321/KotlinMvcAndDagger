package com.android.a2mvcdandagger.screens.viewmodel

import androidx.lifecycle.*
import com.android.a2mvcdandagger.questions.Question
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
):ViewModel() {


    private val _questions = MutableLiveData<List<Question>>()
    val question: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch{
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success){
                _questions.value = result.questions
            }else{
                throw RuntimeException("fetch failed")
            }
        }

    }

    //todo 1 (finish)
    class MyViewModelFactory @Inject constructor(
        private val myViewModelProvider: Provider<MyViewModel>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return myViewModelProvider.get() as T
        }
    }

}