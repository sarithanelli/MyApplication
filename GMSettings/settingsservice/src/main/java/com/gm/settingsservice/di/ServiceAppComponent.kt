package com.gm.settingsservice.di

import android.app.Application
import com.gm.settingsservice.apiintegration.SystemController
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.utils.Utility
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceAppModule::class])
interface ServiceAppComponent {

    @Component.Builder
    interface Builder {



        fun build(): ServiceAppComponent
        fun dataServiceAppModule(module: ServiceAppModule): Builder
        @BindsInstance
        fun application(application: Application): Builder
    }


    fun provide(): SystemController
    fun getDataPoolDataHandler(): DataPoolDataHandler

    fun getSystemListener(): SystemListener
    fun provideUtility(): Utility
}