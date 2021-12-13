package com.android.a2mvcdandagger.screens.common.navigator

import android.app.Activity
import com.android.a2mvcdandagger.screens.questiondetails.QuestionDetailsActivity

class ScreenNavigator(
    private val activity: Activity
) {

    fun toQuestionDetails(questionId:String){
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack(){
        activity.onBackPressed()
    }

}