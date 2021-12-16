package com.android.a2mvcdandagger.users

import com.google.gson.annotations.SerializedName

//todo 1 (next QuestionWithBody)
data class User(
    @SerializedName("display_name") val name: String,
    @SerializedName("profile_image") val imageUrl: String
)