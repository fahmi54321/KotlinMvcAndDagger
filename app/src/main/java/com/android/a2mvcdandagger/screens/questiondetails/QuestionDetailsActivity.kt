package com.android.a2mvcdandagger.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.widget.TextView
import com.android.a2mvcdandagger.common.dependencyinjection.Service
import com.android.a2mvcdandagger.screens.common.activities.BaseActivity
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionDetailsActivity : BaseActivity(), QuestionDetailsListViewMvc.Listeners {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    lateinit var questionId: String
    lateinit var mvc: QuestionDetailsListViewMvc

    //todo 3 (next Injector)
    @field:Service private lateinit var dialogsNavigator: DialogsNavigator
    @field:Service private lateinit var screenNavigator: ScreenNavigator
    @field:Service private lateinit var fetchDetailQuestionsUseCase: FetchDetailQuestionsUseCase
    @field:Service private lateinit var viewMvcFactory: ViewMvcFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
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
                        mvc.bindQuestions(result.questionId)
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