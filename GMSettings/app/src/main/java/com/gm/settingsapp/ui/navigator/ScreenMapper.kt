package com.gm.settingsapp.ui.navigator


import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.viewmodels.Constants.activityAction
import com.gm.settingsapp.viewmodels.Constants.fragmentAction
import com.gm.settingsapp.viewmodels.Constants.json_key_event_activity_actionmap
import com.gm.settingsapp.viewmodels.Constants.json_key_event_activity_actionmap_custom
import com.gm.settingsapp.viewmodels.Constants.json_key_event_fragment_actionmap
import com.gm.settingsapp.viewmodels.Constants.resource_raw_events_json
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


/**
 * This class calls when eny ui event occurred.
 * It returns respective methods for tags in layout when Any onclick or ontouch events
 */
object ScreenMapper {

    var activityEventTable: Map<String, String> = HashMap()
    var fragmentEventTable: Map<String, String> = HashMap()

    init {
        activityEventTable = getActivityEventTable()
        fragmentEventTable = getFragmentEventTable()
    }

    /**
     * To get Methods and activity to navigate when any UI related event occurred
     * @return Methods and Activity
     */
    private fun getActivityEventTable(): HashMap<String, String> {
        val eventTable = HashMap<String, String>()
        val jsonEventObject = getJsonObject(json_key_event_activity_actionmap)
        val iterator = jsonEventObject.keys()
        iterator.forEach {
            eventTable[it] = "$activityAction.${jsonEventObject.getString(it)}"
        }
        val jsonEventObjectCustom = getJsonObject(json_key_event_activity_actionmap_custom)
        val iterator1 = jsonEventObjectCustom.keys()
        iterator1.forEach {
            eventTable[it] = jsonEventObjectCustom.getString(it)
        }
        return eventTable
    }
    /**
     * To get Methods and Fragment to navigate when any UI related event occurred
     * @return Methods and Fragment
     */
    private fun getFragmentEventTable(): HashMap<String, String> {
        val eventTable = HashMap<String, String>()
        val jsonEventObject = getJsonObject(json_key_event_fragment_actionmap)
        val iterator = jsonEventObject.keys()
        iterator.forEach {
            eventTable[it] = "$fragmentAction.${jsonEventObject.getString(it)}"
        }
        return eventTable
    }
    /**
     * To get JSONObject when any UI related event occurred
     * @param jsonKey
     * @return Methods and JSONObject
     */

    private fun getJsonObject(jsonKey:String): JSONObject {
        val stream = appContext.resources.openRawResource(resource_raw_events_json)
        return JSONObject(getJsonString(stream)).getJSONObject(jsonKey)
    }

    /**
     * Get Commands when Keyboard events occured
     * @param stream
     * @return data from keyboard
     */
    private fun getJsonString(stream: InputStream): String {
        val strBuilder = StringBuilder()
        var jsonString: String? = null
        val bfReader = BufferedReader(InputStreamReader(stream,"UTF-8"))
        while ({ jsonString = bfReader.readLine(); jsonString }() != null) {
            strBuilder.append(jsonString)
        }
        return strBuilder.toString()
    }

}