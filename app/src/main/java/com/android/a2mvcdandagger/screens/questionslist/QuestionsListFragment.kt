package com.android.a2mvcdandagger.screens.questionslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.a2mvcdandagger.questions.Question
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.fragments.BaseFragment
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import kotlinx.coroutines.*

class QuestionsListFragment : BaseFragment(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var isDataLoaded = false
    private lateinit var viewMvc: QuestionsListViewMvc
    private lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    private lateinit var dialogsNavigator: DialogsNavigator
    private lateinit var screenNavigator: ScreenNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        dialogsNavigator = compositionRoot.dialogNavigator
        screenNavigator = compositionRoot.screenNavigator

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //todo 3 (next ViewMvcFactory)
        viewMvc = compositionRoot.viewMvcFactory.newQuestionsListViewMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unRegisterListener(this)
    }

    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickQuestion: Question) {
        screenNavigator.toQuestionDetails(clickQuestion.id)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                val result = fetchQuestionsUseCase.fetchLatestQuestions()
                when (result) {
                    is FetchQuestionsUseCase.Result.Success -> {
                        viewMvc.bindQuestions(result.questions)
                        isDataLoaded = true
                    }
                    is FetchQuestionsUseCase.Result.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialogFragment()
    }
}