package com.android.a2mvcdandagger.common.dependencyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.android.a2mvcdandagger.common.dependencyinjection.app.AppComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationComponent
import com.android.a2mvcdandagger.common.dependencyinjection.presentation.PresentationModule
import com.android.a2mvcdandagger.networking.StackoverflowApi
import com.android.a2mvcdandagger.screens.common.navigator.ScreenNavigator
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(presentationModule: PresentationModule):PresentationComponent //todo 2 (next BaseActivity)

}