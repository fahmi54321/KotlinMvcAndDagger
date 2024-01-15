package com.android.a2mvcdandagger.common.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//todo 1 (next MyViewModel)
abstract class SavedStateViewModel: ViewModel() {
    abstract fun init(savedStateHandle: SavedStateHandle)
}