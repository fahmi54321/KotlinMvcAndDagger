package com.android.a2mvcdandagger.screens.common.navigator

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.activity.ActivityScope
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreenNavigator @Inject constructor(
    private val activity: AppCompatActivity
) {

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack() {
        activity.onBackPressed()
    }

}