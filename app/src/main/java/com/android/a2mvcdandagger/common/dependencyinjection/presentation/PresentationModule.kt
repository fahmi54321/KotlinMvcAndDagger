package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
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
    private val activityModule: ActivityModule
) {


    @Provides
    fun layoutInflater() = activityModule.layoutInflater()

    @Provides
    fun fragmentManager() = activityModule.fragmentManager()

    @Provides
    fun stackoverflowApi() = activityModule.stackoverflowApi()

    @Provides
    fun screenNavigator() = activityModule.screenNavigator(activityModule.activity)

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchDetailQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchDetailQuestionsUseCase(stackoverflowApi)

}