package com.android.a2mvcdandagger.common.dependencyinjection

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

//todo 2 (next PresentationComponent)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>) {
}