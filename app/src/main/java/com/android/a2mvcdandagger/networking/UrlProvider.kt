package com.android.a2mvcdandagger.networking

import com.android.a2mvcdandagger.Constants

//todo 1 (next AppModule)
class UrlProvider {

    fun getBaseUrl1():String{
        return Constants.BASE_URL
    }
    fun getBaseUrl2():String{
        return "base_url_2"
    }

}