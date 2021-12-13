package com.android.a2mvcdandagger.networking

import com.android.a2mvcdandagger.questions.Question
import com.google.gson.annotations.SerializedName

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)