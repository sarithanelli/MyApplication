package com.gm.settingsservice.apiintegration.mock

import org.json.JSONObject

/**
 *
 * Created by Naresh
 */

interface IDataSourceProvider {

    fun getSimulationData(): JSONObject?
}