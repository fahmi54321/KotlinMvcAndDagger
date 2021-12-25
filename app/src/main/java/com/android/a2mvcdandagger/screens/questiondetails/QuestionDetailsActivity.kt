package com.android.a2mvcdandagger.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class QuestionDetailsActivity : BaseActivity(), QuestionDetailsListViewMvc.Listeners {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    lateinit var questionId: String
    lateinit var mvc: QuestionDetailsListViewMvc

    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screenNavigator: ScreenNavigator
    @Inject lateinit var fetchDetailQuestionsUseCase: FetchDetailQuestionsUseCase
    @Inject lateinit var viewMvcFactory: ViewMvcFactory


    override fun onCreate(savedInstanceState: Bundle?) { //todo 8 hapus inject (next ViewModelActivity)
        super.onCreate(savedInstanceState)
        mvc = viewMvcFactory.newQuestionsDetailsViewMvc(null)
        setContentView(mvc.rootView)
        questionId = intent.extras!!.getString(EXTRA_QUESTION_ID)!!
    }

    override fun onStart() {
        super.onStart()
        mvc.registerListener(this)
        fetchQuestionDetails()
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        mvc.unRegisterListener(this)
    }

    override fun onBackClicked() {
        screenNavigator.navigateBack()
    }


    private fun fetchQuestionDetails() {
        coroutineScope.launch {
            mvc.showProgressIndication()
            try {
                val result = fetchDetailQuestionsUseCase.fetchQuestionDetails(questionId)
                when (result) {
                    is FetchDetailQuestionsUseCase.ResultDetails.Success -> {
                        mvc.bindQuestions(result.question)
                    }
                    is FetchDetailQuestionsUseCase.ResultDetails.Failure -> {
                        onFetchFailed()
                    }
                }
            } finally {
                mvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogsNavigator.showServerErrorDialogFragment()
    }

    companion object {
        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"
        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}