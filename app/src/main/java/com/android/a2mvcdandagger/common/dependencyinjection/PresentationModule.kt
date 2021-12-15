package com.android.a2mvcdandagger.common.dependencyinjection

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

//todo 1 (next PresentationComponent)
@Module
class PresentationModule(
    private val activityCompositionRoot: ActivityCompositionRoot
) {


    @Provides
    fun layoutInflater() = activityCompositionRoot.layoutInflater

    @Provides
    fun fragmentManager() = activityCompositionRoot.fragmentManager

    @Provides
    fun stackoverflowApi() = activityCompositionRoot.stackoverflowApi

    @Provides
    fun screenNavigator() = activityCompositionRoot.screenNavigator

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchDetailQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchDetailQuestionsUseCase(stackoverflowApi)

}