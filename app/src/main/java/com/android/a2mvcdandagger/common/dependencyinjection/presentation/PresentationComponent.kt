package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListFragment
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(questionsListFragment: QuestionsListFragment) //todo 4 (next QuestionDetailsActivity)
    fun inject(questionDetailsActivity: QuestionDetailsActivity) //todo 8 (finish)

}