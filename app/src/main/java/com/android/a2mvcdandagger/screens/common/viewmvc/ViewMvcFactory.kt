package com.android.a2mvcdandagger.screens.common.viewmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.a2mvcdandagger.screens.common.imageloader.ImageLoader
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsListViewMvc
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader //todo 6 (next ViewMvcFactory)
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionsDetailsViewMvc(parent: ViewGroup?): QuestionDetailsListViewMvc {
        return QuestionDetailsListViewMvc(layoutInflater,imageLoader,parent) //todo 7 (finish)
    }

}