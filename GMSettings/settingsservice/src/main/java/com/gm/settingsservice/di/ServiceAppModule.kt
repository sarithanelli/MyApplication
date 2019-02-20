package com.gm.settingsservice.di

import android.app.Application
import android.content.Context
import com.gm.settingsservice.apiintegration.GMSystemListener
import com.gm.settingsservice.apiintegration.SystemController
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.apiintegration.mock.SimulationManager
import com.gm.settingsservice.apiintegration.sdk.GMSDKManager
import com.gm.settingsservice.apiintegration.sdk.GMSettingsManager
import com.gm.settingsservice.apiintegration.sdk.SDKManager
import com.gm.settingsservice.apiintegration.sdk.SettingsManager
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.utils.Utility
import dagger.Module
import dagger.Provides
import gm.content.SupportedLanguageListData
import gm.media.audio.VehicleAudioManager
import gm.vehicle.Customization
import javax.inject.Singleton

@Module
class ServiceAppModule {
    @Provides
    @Singleton
    fun providesContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideSettingsManager(systemListener: SystemListener, customization: Customization): SettingsManager {
        return SettingsManager(systemListener, customization)
    }

    @Provides
    @Singleton
    fun provideSystemController(sdkManager: dagger.Lazy<SDKManager>, simulationManager: dagger.Lazy<SimulationManager>,gmSdkManager : dagger.Lazy<GMSDKManager>): SystemController {
        return SystemController(sdkManager, simulationManager,gmSdkManager)

    }

    @Provides
    @Singleton
    fun provideSupportedLanguageListData(): SupportedLanguageListData {
        return SupportedLanguageListData.getInstance()
    }



    @Provides
    @Singleton
    fun provideSDKManager(dataPoolDataHandler: DataPoolDataHandler, systemListener: SystemListener, utility: Utility, settingsManager: SettingsManager,context: Context,mCustomization : Customization, vehicleAudioManager: dagger.Lazy<VehicleAudioManager>, supportedLanguageListData: dagger.Lazy<SupportedLanguageListData>): SDKManager {
        return SDKManager(dataPoolDataHandler, systemListener, utility, settingsManager, vehicleAudioManager,context,mCustomization, supportedLanguageListData)
    }
    @Provides
    @Singleton
    fun provideGMSDKManager(dataPoolDataHandler: DataPoolDataHandler, gmsystemListener: GMSystemListener, utility: Utility, gmsettingsManager: GMSettingsManager, context: Context, mCustomization : Customization, vehicleAudioManager: dagger.Lazy<VehicleAudioManager>, supportedLanguageListData: dagger.Lazy<SupportedLanguageListData>): GMSDKManager {
        return GMSDKManager(dataPoolDataHandler, gmsystemListener, utility, gmsettingsManager, vehicleAudioManager,context,mCustomization, supportedLanguageListData)
    }


    @Provides
    @Singleton
    fun provideSimulationManager(dataPoolDataHandler: DataPoolDataHandler,systemListener: SystemListener,utility: Utility,context: Context): SimulationManager {
        return SimulationManager(dataPoolDataHandler, systemListener, utility,context)
    }

    @Provides
    @Singleton
    fun provideDataPoolDataHandler(): DataPoolDataHandler {
        return DataPoolDataHandler()
    }

    @Provides
    @Singleton
    fun provideSystemListener(dataPoolDataHandler: DataPoolDataHandler): SystemListener {
        return SystemListener(dataPoolDataHandler)
    }

    @Provides
    @Singleton
    fun provideUtility(dataPoolDataHandler: DataPoolDataHandler): Utility {
        return Utility(dataPoolDataHandler)
    }

    @Provides
    @Singleton
    fun provideCustomization(): Customization {
        return Customization()
    }

    @Provides
    @Singleton
    fun provideVehicleAudioManager(context: Context): VehicleAudioManager {
        return VehicleAudioManager(context)
    }

}