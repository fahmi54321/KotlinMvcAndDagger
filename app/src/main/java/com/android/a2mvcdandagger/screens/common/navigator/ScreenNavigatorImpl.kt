package com.android.a2mvcdandagger.screens.common.navigator

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityScope
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreenNavigatorImpl @Inject constructor(private val activity: AppCompatActivity): ScreenNavigator {

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    override fun navigateBack() {
        activity.onBackPressed()
    }

}