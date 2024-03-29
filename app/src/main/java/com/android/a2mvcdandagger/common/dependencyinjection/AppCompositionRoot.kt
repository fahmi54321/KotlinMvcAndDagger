package com.android.a2mvcdandagger.common.dependencyinjection

import android.app.Application
import androidx.annotation.UiThread
import com.android.a2mvcdandagger.Constants
import com.android.a2mvcdandagger.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
class AppCompositionRoot(val application: Application) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val stackoverflowApi : StackoverflowApi by lazy {
        retrofit.create(StackoverflowApi::class.java)
    }

}