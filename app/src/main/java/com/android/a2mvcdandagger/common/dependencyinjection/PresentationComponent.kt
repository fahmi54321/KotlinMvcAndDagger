package com.android.a2mvcdandagger.common.dependencyinjection

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.screens.common.dialogs.DialogsNavigator
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import com.android.a2mvcdandagger.screens.common.viewmvc.ViewMvcFactory
import com.android.a2mvcdandagger.screens.questiondetails.FetchDetailQuestionsUseCase
import com.android.a2mvcdandagger.screens.questionslist.FetchQuestionsUseCase
import dagger.Component
import dagger.Provides

//todo 2 (next rebuild dan Injector)
@Component(modules = [PresentationModule::class])
interface PresentationComponent {

    fun viewMvcFactory(): ViewMvcFactory
    fun dialogNavigator(): DialogsNavigator
    fun screenNavigator(): ScreenNavigator
    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
    fun fetchDetailQuestionsUseCase(): FetchDetailQuestionsUseCase

}