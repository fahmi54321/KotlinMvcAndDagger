package com.android.a2mvcdandagger.screens.common.navigator

interface ScreenNavigator {

    fun toQuestionDetails(questionId: String)

    fun navigateBack()

    fun toViewModelActivity()

}