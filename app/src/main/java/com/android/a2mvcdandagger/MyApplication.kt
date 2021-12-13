package com.android.a2mvcdandagger

import android.app.Application
import com.android.a2mvcdandagger.common.composition.AppCompositionRoot

class MyApplication: Application() {

    lateinit var appCompositionRoot: AppCompositionRoot

    override fun onCreate() {
        appCompositionRoot = AppCompositionRoot(this)
        super.onCreate()
    }

}