package com.android.a2mvcdandagger.common.dependencyinjection.app

import com.android.a2mvcdandagger.common.dependencyinjection.Retrofit1
import com.android.a2mvcdandagger.common.dependencyinjection.Retrofit2
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.networking.UrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Retrofit1
    fun retrofit1(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun urlProvider() = UrlProvider()

    @Provides
    @Singleton
    fun stackoverflowApi(@Retrofit1 retrofit: Retrofit): StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

}