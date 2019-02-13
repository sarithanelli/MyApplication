package com.gm.settingsservice.apiintegration.mock

import com.gm.settingsservice.R
import com.gm.settingsservice.apiintegration.SettingsService
import org.json.JSONObject

/**
 *
 * Created by Naresh
 */

class JSONParser : IDataSourceProvider {

    init {
        val stream = SettingsService.appContext.resources?.openRawResource(R.raw.simulationdata)
    }

    override fun getSimulationData(): JSONObject? {
        return null
    }

}