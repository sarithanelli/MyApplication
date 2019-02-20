package com.gm.settingsapp.di

import android.app.Application
import android.content.Context
import com.gm.settingsapp.ui.navigator.ActivityNavigator
import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsapp.viewmodels.GMResponseListner
import com.gm.settingsapp.viewmodels.ResponseListner
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    @AppScope
    fun providesContext(application: Application): Context {
        return application
    }

    @Provides
    @AppScope
    fun provideEventHandler(eventProcessor: EventProcessor, utility: Utility, dataPoolDataHandler: DataPoolDataHandler): EventHandler {
        return EventHandler(eventProcessor, utility, dataPoolDataHandler)
    }


    @Provides
    @AppScope
    fun provideEventProcessor(activityNavigator: ActivityNavigator, utility: Utility,context: Context): EventProcessor {
        return EventProcessor(activityNavigator, utility,context)
    }


    @Provides
    @AppScope
    fun provideActivityNavigator(): ActivityNavigator {
        return ActivityNavigator()
    }


    @Provides
    @AppScope
    fun provideResponseListner(utility: Utility, serviceUtility: com.gm.settingsservice.utils.Utility, dataPoolDataHandler: DataPoolDataHandler, systemListener: SystemListener,context: Context): ResponseListner {
        return ResponseListner(utility, serviceUtility, dataPoolDataHandler, systemListener,context)
    }

    @Provides
    @AppScope
    fun provideGMResponseListner(utility: Utility, serviceUtility: com.gm.settingsservice.utils.Utility, dataPoolDataHandler: DataPoolDataHandler, systemListener: SystemListener,context: Context): GMResponseListner {
        return GMResponseListner(utility, serviceUtility, dataPoolDataHandler, systemListener,context)
    }

    @Provides
    @AppScope
    fun provideUtility(context: Context): Utility {
        return Utility(context)
    }
}