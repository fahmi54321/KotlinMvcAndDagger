package com.android.a2mvcdandagger.screens.common.navigator

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import com.android.a2mvcdandagger.screens.viewmodel.ViewModelActivity
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ScreenNavigatorImpl @Inject constructor(private val activity: AppCompatActivity): ScreenNavigator {

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toViewModelActivity() {
        ViewModelActivity.start(activity)
    }

}