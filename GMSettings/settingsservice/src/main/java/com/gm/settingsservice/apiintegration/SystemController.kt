package com.gm.settingsservice.apiintegration

import com.gm.settingsservice.apiintegration.SettingsService.Companion.isSDKAvailable
import com.gm.settingsservice.apiintegration.apiinterfaces.IManager
import com.gm.settingsservice.apiintegration.mock.SimulationManager
import com.gm.settingsservice.apiintegration.sdk.GMSDKManager

import com.gm.settingsservice.apiintegration.sdk.SDKManager
import dagger.Lazy
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject


/**
 * A controller decides which platform api call must be invoked.
 *
 * Created by GM on 3/9/2018.
 */
class SystemController @Inject constructor(val sdkManager: Lazy<GMSDKManager>, val simulationManager: Lazy<SimulationManager>,val gmSdkManager : Lazy<GMSDKManager>){

    private var manager: IManager

    /**
     * Get [IManager] w.r.t to the working platform
     * @return [IManager]
     */
    fun getSourceManager(): IManager {
        manager = when {
            isSDKAvailable() -> {
             //   sdkManager.get()
                gmSdkManager.get()
            }
            else -> simulationManager.get()
        }

        return manager
    }

    /**
     * Trigger the produced event using obtained [IManager] object
     * @param event method name
     * @param any data
     */
    fun execute(event: String,any: Any?) {

        val cls = IManager::class.java
        try {

            if (any != null) {
                val method = cls.getDeclaredMethod(event, Any::class.java)
                method.invoke(manager, any)
            }
            else {
                val method = cls.getDeclaredMethod(event)
                method.invoke(manager)
            }

        } catch (ex: InvocationTargetException) {
            print(ex)
        }

    }

    init {
        manager = getSourceManager()
    }
}