package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

//todo 5 (next ViewModelModule)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)