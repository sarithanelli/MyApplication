package com.gm.settingsapp.viewmodels


import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.GMSettingsApp.Companion.navigator
import com.gm.settingsapp.R
import com.gm.settingsapp.ui.customview.GMToast
import com.gm.settingsapp.ui.navigator.ActivityNavigator
import com.gm.settingsapp.ui.navigator.ScreenMapper
import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.Constants.event_type_navigate
import com.gm.settingsapp.viewmodels.Constants.event_type_process
import com.gm.settingsapp.viewmodels.Constants.json_key_keyboard
import com.gm.settingsapp.viewmodels.Constants.json_key_remote
import com.gm.settingsapp.viewmodels.Constants.json_key_voice
import com.gm.settingsservice.utils.Log
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Serializable
import javax.inject.Inject

class EventProcessor @Inject constructor(activityNavigator: ActivityNavigator, utility: Utility, context: Context){
    var utility: Utility = utility

    var eventTable = HashMap<String, Any>()
    var touchViewCommands = HashMap<String, Any>()
    var voiceCommands = HashMap<String, Any>()
    var keyboardCommands = HashMap<String, Any>()
    var remoteCommands = HashMap<String, Any>()
    companion object {
        private const val resFileCommands: Int = R.raw.commands
        private const val resFileEventMap: Int = R.raw.eventmap
    }

    init {
        voiceCommands = getCommands(resFileCommands, json_key_voice)
        keyboardCommands = getCommands(resFileCommands, json_key_keyboard)
        remoteCommands = getCommands(resFileCommands, json_key_remote)
        eventTable = getEventMapTable(resFileEventMap)

    }

    public fun getCommands(resFileRead: Int, commandType: String): HashMap<String, Any> {
        val jsonObj = JSONObject(getJsonString(appContext.resources.openRawResource(resFileRead))).getJSONObject(commandType)
        return hashMap(jsonObj)
    }

    private fun getEventMapTable(resFileRead: Int): HashMap<String, Any> {
        val jsonObj = JSONObject(getJsonString(appContext.resources.openRawResource(resFileRead)))
        return hashMap(jsonObj)
    }

    private fun hashMap(jsonObj: JSONObject): HashMap<String, Any> {
        val map = HashMap<String, Any>()
        val iterator = jsonObj.keys()
        while (iterator.hasNext()) {
            val key = iterator.next()
            try {
                val command = jsonObj.get(key)
                map[key] = command
            } catch (e: JSONException) {
            }

        }
        return map
    }

    fun getJsonString(stream: InputStream): String {

        val strBuilder = StringBuilder()
        var jsonString: String? = null
        val bfReader = BufferedReader(InputStreamReader(stream, "UTF-8"))
        while ({ jsonString = bfReader.readLine(); jsonString }() != null) {
            strBuilder.append(jsonString)
        }
        return strBuilder.toString()
    }

    fun getResourceIDValue(resName: String, resIdentifier: String): Int {
        return appContext.resources.getIdentifier(resName, resIdentifier, appContext.packageName)
    }

    fun getResourceName(id: Int): String {
        return appContext.resources.getResourceEntryName(id)
    }

    /**
     * Getting string from Resource files
     * @param id string id
     * @return String
     */
    fun getStringValue(id: Int): String {
        return GMSettingsApp.appContext.resources.getString(id)
    }

    /**
     * trigger the event corresponding to given eventType,eventName and activityName.
     * @param eventType passing which type of event has to perform.
     * @param eventName passing which name of event has to perform.
     * @param activityName passing which name of activity/fragment has to perform.
     * @param isProcess passing boolean status.
     * @param any  additional data that is passed.
     */
    fun triggerEvent(eventType: String, eventName: String, eventObject: Any?, activityName: String, isProcess: Boolean) {
        when (eventType) {
            event_type_navigate -> {
                println("eventProcessor::navigate ${eventName}")
                if (isProcess) {
                    processEvent(eventName, eventObject)
                }
                if (eventName == "evG_Recreate") {
                    println("eventProcessor::finish $eventObject.eventName")
                    navigator.recreateActivity()
                    return
                }

                when (activityName.isEmpty()) {
                    true -> navigator.backNavigation()
                    false -> {
                        if (appContext.activityContext.javaClass.simpleName == activityName) {
                            switchFragment(eventName, eventObject)
                        } else {
                            navigateScreen(eventName, eventObject, activityName)

                        }
                    }
                }
            }
            event_type_process -> {
                println("eventProcessor::process $eventObject.eventName")
                processEvent(eventName, eventObject)
            }
        }
    }

    /**
     * Calling Service and sending data to Service
     * @param eventName method name
     * @param eventObject to be passed data
     */
    fun processEvent(eventName: String, eventObject: Any?) {
        println("processEvent::process ${eventName} ${eventObject}")
        var serviceIntent = Intent()
        serviceIntent.action = "com.gm.settingsservice.apiintegration.SettingsService"
        serviceIntent.`package` = GMSettingsApp.appContext.packageName
        serviceIntent.putExtra("eventName", eventName)
        serviceIntent = bindIntentExtra(eventObject, serviceIntent)
        GMSettingsApp.appContext.startService(serviceIntent)
    }

    /**
     * Binding data of different type like  String, Int, Boolean, object  to Intent
     * @param eventObject to be passed data
     * @param serviceIntent Intent
     * @return Intent
     */
    private fun bindIntentExtra(eventObject: Any?, serviceIntent: Intent): Intent {
        when (eventObject) {
            is Parcelable -> {
                serviceIntent.putExtra("eventObj", eventObject)
            }

            is Serializable -> {
                serviceIntent.putExtra("eventSerializableObj", eventObject)
            }
            is String -> {
                serviceIntent.putExtra("eventString", eventObject)
            }
            is Long -> {
                serviceIntent.putExtra("eventLong", eventObject)
            }
            is Boolean -> {
                serviceIntent.putExtra("eventBoolean", eventObject)
            }
            is Int -> {
                serviceIntent.putExtra("eventInt", eventObject)
            }
            is Float -> {
                serviceIntent.putExtra("eventFloat", eventObject)
            }
        }
        return serviceIntent
    }

    /**
     * navigate the Activity corresponding to given eventName
     * @param eventName passing which name of event has to perform.
     * @param any  additional data that is passed.
     */
    private fun navigateScreen(eventName: String, any: Any?, screenName: String) {
        println("navigateScreen::navigate $eventName")
        if (screenName != null && screenName.contains("com.gm")) {
            if (!utility.isPackageInstalled(ScreenMapper.activityEventTable[eventName])) {
                GMToast.displayToast("Application not installed", Gravity.TOP)
                return
            }
        } else if (eventName == "onSETTINGS_PHONE_REQ" || eventName == "evG_Privacy") {
            GMToast.displayToast("Action Not Available.", Gravity.TOP)
            return
        }
        navigator.triggerActivity(eventName, any)
    }

    /**
     * add/replaces fragment corresponding to given eventName
     * @param eventName passing which name of event has to perform.
     * @param any  additional data that is passed.
     */

    private fun replaceScreen(view: View?, eventName: String, any: Any?) {
        println("navigateScreen::navigate $eventName")
    }

    /**
     * navigate the fragment corresponding to given eventName
     * @param eventName passing which name of event has to perform.
     * @param any  additional data that is passed.
     */
    private fun switchFragment(eventName: String, any: Any?) {
        println("switchFragment::navigate $eventName")
        navigator.triggerFragment(eventName, any)
    }


}