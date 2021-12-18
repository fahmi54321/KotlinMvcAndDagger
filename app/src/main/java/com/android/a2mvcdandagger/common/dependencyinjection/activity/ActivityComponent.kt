package com.android.a2mvcdandagger.common.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity:AppCompatActivity):Builder //todo 2 (next BaseActivity)
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

}