package com.android.a2mvcdandagger.screens.common.viewmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.a2mvcdandagger.screens.common.imageloader.ImageLoader
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsListViewMvc
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(
    private val layoutInflater: LayoutInflater,
    private val imageLoaderProvider: Provider<ImageLoader> //todo 1 (finish)
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionsDetailsViewMvc(parent: ViewGroup?): QuestionDetailsListViewMvc {
        return QuestionDetailsListViewMvc(layoutInflater,imageLoaderProvider.get(),parent)
    }

}