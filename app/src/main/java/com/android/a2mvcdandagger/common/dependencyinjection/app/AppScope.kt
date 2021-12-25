package com.android.a2mvcdandagger.common.dependencyinjection.app

import dagger.hilt.migration.AliasOf
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@AliasOf(Singleton::class) //todo 2 (finish)
annotation class AppScope()
