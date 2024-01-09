package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class,UseCasesModule::class])
interface PresentationComponent {
    fun inject(questionsListFragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)

}