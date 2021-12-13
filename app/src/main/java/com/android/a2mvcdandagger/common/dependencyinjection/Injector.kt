package com.android.a2mvcdandagger.common.dependencyinjection

import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.questionslist.QuestionsListFragment

class Injector(
    private val compositionRoot: PresentationCompositionRoot //todo 1 (next BaseFragment)
) {

    //todo 4 (next QuestionsListFragment)
    fun inject(fragment: QuestionsListFragment) {

        //todo 7 (next BaseActivity)
        fragment.dialogsNavigator = compositionRoot.dialogNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.screenNavigator = compositionRoot.screenNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    //todo 11 (finish)
    fun inject(activity: QuestionDetailsActivity) {
        activity.screenNavigator = compositionRoot.screenNavigator
        activity.dialogsNavigator = compositionRoot.dialogNavigator
        activity.fetchDetailQuestionsUseCase = compositionRoot.fetchDetailQuestionsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}