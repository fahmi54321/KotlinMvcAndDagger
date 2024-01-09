package com.android.a2mvcdandagger.common.dependencyinjection.activity

import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    //todo 4 hapus UseCasesModule (next BaseActivity)
    fun newPresentationComponent(): PresentationComponent

}