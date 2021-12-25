package com.android.a2mvcdandagger.screens.common.navigator

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.viewmodel.ViewModelActivity

//todo 5 (finish) untuk mengakses screen navigator lihat contoh pada QuestionDetailsActivity
// yaitu

/**
    @Inject lateinit var screenNavigator: ScreenNavigator
    injector.inject(this)
 **/

class ScreenNavigator(
    private val activity: AppCompatActivity
) {

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toViewModelActivity() {
        ViewModelActivity.start(activity)
    }

}