package com.android.a2mvcdandagger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//todo 1 hapus app component,activitycomponent,presentationcomponent,dan servicecomponent
//todo 2 (next BaseActivity)
@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}