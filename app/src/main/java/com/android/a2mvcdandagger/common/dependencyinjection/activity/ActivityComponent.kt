package com.android.a2mvcdandagger.common.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity:AppCompatActivity):Builder
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

}