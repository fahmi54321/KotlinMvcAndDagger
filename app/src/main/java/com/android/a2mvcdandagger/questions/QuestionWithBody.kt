package com.android.a2mvcdandagger.questions

import com.android.a2mvcdandagger.users.User
import com.google.gson.annotations.SerializedName

data class QuestionWithBody(
        @SerializedName("title") val title: String,
        @SerializedName("question_id") val id: String,
        @SerializedName("body") val body: String,
        @SerializedName("owner") val owner: User
)