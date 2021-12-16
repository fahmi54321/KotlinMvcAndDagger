package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityComponent
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityModule
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    // todo 2 (hapus semua ketergantungan pada activity component) (next BaseActivity)

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchDetailQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchDetailQuestionsUseCase(stackoverflowApi)

}