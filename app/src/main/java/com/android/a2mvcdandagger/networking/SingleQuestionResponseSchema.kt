package com.android.a2mvcdandagger.networking

import com.android.a2mvcdandagger.questions.QuestionWithBody
import com.google.gson.annotations.SerializedName

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}