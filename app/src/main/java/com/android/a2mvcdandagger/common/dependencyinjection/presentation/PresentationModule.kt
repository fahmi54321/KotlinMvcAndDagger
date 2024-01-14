package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides

//todo 7 (next ActivityComponent)
@Module
class PresentationModule(private val savedStateRegistryOwner: SavedStateRegistryOwner) {

    @Provides
    fun savedStateRegistryOwner() = savedStateRegistryOwner

}