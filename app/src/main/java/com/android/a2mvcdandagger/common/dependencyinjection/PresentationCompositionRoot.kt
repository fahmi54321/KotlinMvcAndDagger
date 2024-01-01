package com.android.a2mvcdandagger.common.dependencyinjection

import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase


class PresentationCompositionRoot(
    private val activityCompositionRoot: ActivityCompositionRoot
) {


    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    private val stackoverflowApi get() = activityCompositionRoot.stackoverflowApi

    val screenNavigator get() = activityCompositionRoot.screenNavigator
    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val dialogNavigator get() = DialogsNavigator(fragmentManager)
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchDetailQuestionsUseCase get() = FetchDetailQuestionsUseCase(stackoverflowApi)

}