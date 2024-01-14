package com.android.a2mvcdandagger.questions

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Question(
        @SerializedName("title") val title: String,
        @SerializedName("question_id") val id: String
):Serializable //todo 12 (finish)