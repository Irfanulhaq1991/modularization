package com.irfan.modularization.di

import com.irfan.feature.details.di.DetailsDaggerComponent
import dagger.Component


@Component(modules = [SubComponentModule::class, AppDaggerModule::class])
interface AppDaggerComponent {
    fun detailComponent(): DetailsDaggerComponent.Factory
}