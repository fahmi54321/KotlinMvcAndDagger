package com.android.a2mvcdandagger.common.dependencyinjection.presentation

import androidx.lifecycle.ViewModel
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel
import com.android.a2mvcdandagger.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//todo 6 (next PresentationComponent)
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewmodel(myViewModel: MyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewmodel2(myViewModel2: MyViewModel2): ViewModel

}