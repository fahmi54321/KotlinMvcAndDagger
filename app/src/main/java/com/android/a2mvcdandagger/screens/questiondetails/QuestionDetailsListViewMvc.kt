package com.android.a2mvcdandagger.screens.questiondetails

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.a2mvcdandagger.R
import com.android.a2mvcdandagger.questions.QuestionWithBody
import com.android.a2mvcdandagger.screens.common.imageloader.ImageLoader
import com.android.a2mvcdandagger.screens.common.toolbar.MyToolbar
import com.android.a2mvcdandagger.screens.common.viewmvc.BaseViewMvc

class QuestionDetailsListViewMvc(
    layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    parent: ViewGroup?
): BaseViewMvc<QuestionDetailsListViewMvc.Listeners>(
    layoutInflater,
    parent,
    R.layout.activity_question_details
) {

    interface Listeners{
        fun onBackClicked()
    }

    private var txtQuestionBody: TextView
    private var txtUserName: TextView
    private var imgUser: ImageView

    var swipeRefresh: SwipeRefreshLayout
    var toolbar: MyToolbar

    init {
        txtQuestionBody = findViewById(R.id.txt_question_body)
        txtUserName = findViewById(R.id.txt_user_name)
        imgUser = findViewById(R.id.img_user)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners){
                listener.onBackClicked()
            }
        }

        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing){
            swipeRefresh.isRefreshing = false
        }
    }

    fun bindQuestions(question: QuestionWithBody) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            txtQuestionBody.text = Html.fromHtml(question.body, Html.FROM_HTML_MODE_LEGACY)
        }else{
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(question.body)
        }

        imageLoader.loadImage(question.owner.imageUrl,imgUser)
        txtUserName.text = question.owner.name
    }


}