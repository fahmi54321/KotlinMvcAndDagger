package com.android.a2mvcdandagger.common.dependencyinjection.app

import android.app.Application
import com.android.a2mvcdandagger.Constants
import com.android.a2mvcdandagger.common.dependencyinjection.Retrofit1
import com.android.a2mvcdandagger.common.dependencyinjection.Retrofit2
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @AppScope
    @Provides
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    fun application() = application

    @AppScope
    @Provides
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

}