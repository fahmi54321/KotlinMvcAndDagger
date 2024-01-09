package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppComponent
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppModule
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(
    val activity: AppCompatActivity,
) {

    //todo 1 tidak bisa inject otomatis karena tidak mengakses constructor activity
    @Provides
    fun activity() = activity

    //todo 4 hapus screenNavigator (next ScreenNavigator)

    //todo 2 tidak bisa inject otomatis karena tidak mengakses constructor layoutInflater
    @Provides
    fun layoutInflater() = LayoutInflater.from(activity)

    //todo 3 tidak bisa inject otomatis karena tidak mengakses constructor fragmentManager
    @Provides
    fun fragmentManager() = activity.supportFragmentManager
}