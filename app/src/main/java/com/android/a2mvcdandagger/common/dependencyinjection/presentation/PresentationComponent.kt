package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityComponent
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListFragment
import dagger.Component

//todo 1 (next PresentationModule)
@PresentationScope
@Component(dependencies = [ActivityComponent::class], modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(questionsListFragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)

}