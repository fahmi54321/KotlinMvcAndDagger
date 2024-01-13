package com.android.a2mvcdandagger.screens.common.viewmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.a2mvcdandagger.screens.common.imageloader.ImageLoader
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsListViewMvc
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(
    private val layoutInflaterProvider: Provider<LayoutInflater>,
    private val imageLoaderProvider: Provider<ImageLoader>
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflaterProvider.get(), parent)
    }

    fun newQuestionsDetailsViewMvc(parent: ViewGroup?): QuestionDetailsListViewMvc {
        return QuestionDetailsListViewMvc(layoutInflaterProvider.get(),imageLoaderProvider.get(),parent)
    }

}