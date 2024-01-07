package com.android.a2mvcdandagger.common.dependencyinjection

import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListFragment

class Injector(
    private val compositionRoot: PresentationCompositionRoot
) {

    fun inject(fragment: QuestionsListFragment) {

        fragment.dialogsNavigator = compositionRoot.dialogNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.screenNavigator = compositionRoot.screenNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.screenNavigator = compositionRoot.screenNavigator
        activity.dialogsNavigator = compositionRoot.dialogNavigator
        activity.fetchDetailQuestionsUseCase = compositionRoot.fetchDetailQuestionsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}