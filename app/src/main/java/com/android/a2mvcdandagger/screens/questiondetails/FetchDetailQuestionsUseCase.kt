package com.android.a2mvcdandagger.screens.questiondetails

import com.android.a2mvcdandagger.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class FetchDetailQuestionsUseCase @Inject constructor(
    private var stackoverflowApi: StackoverflowApi
) {

    sealed class ResultDetails{
        class Success(val questionId: String) :ResultDetails()
        object Failure:ResultDetails()
    }

    suspend fun fetchQuestionDetails(detailsId:String):ResultDetails{
        return withContext(Dispatchers.IO){
            try {
                val response = stackoverflowApi.questionDetails(detailsId)
                if (response.isSuccessful && response.body() != null){
                    return@withContext ResultDetails.Success(response.body()!!.question.body)
                }else{
                    return@withContext ResultDetails.Failure
                }
            }catch (t: Throwable){
                if (t !is CancellationException){
                    return@withContext ResultDetails.Failure
                }else{
                    throw t
                }
            }
        }
    }

}