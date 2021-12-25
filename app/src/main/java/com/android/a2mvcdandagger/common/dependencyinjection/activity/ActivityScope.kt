package com.android.a2mvcdandagger.common.dependencyinjection.activity

import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.migration.AliasOf
import javax.inject.Scope

@Scope
@AliasOf(ActivityScoped::class) //todo 1 (next AppScope)
annotation class ActivityScope()
