package com.gm.settingsapp.di

import android.app.Application
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsservice.di.ServiceAppComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(modules = [AndroidInjectionModule::class, AppModule::class, MainActivityModule::class], dependencies = [ServiceAppComponent::class])
@AppScope
interface AppComponent {


    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun serviceAppComponent(serviceAppComponent: ServiceAppComponent): Builder
@BindsInstance
fun application(application: Application): Builder
    }

    // need to change (dependency injection)
    fun inject(gmSettingsApp: GMSettingsApp)
}
