package com.android.a2mvcdandagger.common.dependencyinjection.service

import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {

}