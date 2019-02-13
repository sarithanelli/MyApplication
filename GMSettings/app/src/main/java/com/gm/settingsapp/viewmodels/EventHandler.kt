package com.gm.settingsapp.viewmodels


import android.os.CountDownTimer
import android.os.Handler
import android.view.KeyEvent
import android.view.View
import android.widget.RadioGroup
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.R
import com.gm.settingsapp.ui.activities.EventResponseHandler
import com.gm.settingsapp.utils.SubUtility
import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.Constants.SUBMIT_BUTTON
import com.gm.settingsapp.viewmodels.Constants.SUBMIT_BUTTON_STATE

import com.gm.settingsservice.models.DataPoolDataHandler

import com.gm.settingsservice.models.eLHD_RHD_RTL
import com.gm.settingsservice.utils.Constants
import org.json.JSONObject
import javax.inject.Inject


/**
 * Handle view click events from views (xml)
 *
 *
 */


class EventHandler @Inject constructor(val eventProcessor: EventProcessor, utility: Utility, dataPoolDataHandler: DataPoolDataHandler): IEventHandler {
    private var utility: Utility = utility
    private var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler
    override fun onClickHandler(view: View, any: Any) {
        eventResponseHandler?.onEventResponse(view, any)
        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?
        if (null != eventObj)
            processEventHandler(eventObj, any)
    }

    /** * Added for test app to trigger event sent from test simulation. Use this method only for test simulation. */
    fun processEventByTag(tag: String) {
        val eventObj = eventProcessor.eventTable[tag] as JSONObject?
        processEventHandler(eventObj, null)
    }

    fun processEventByTag(tag: String,any: Any) {
        val eventObj = eventProcessor.eventTable[tag] as JSONObject?
        processEventHandler(eventObj, any)
    }

    override fun onItemClickHandler(view: View) {
        println("tagname:: ${view.tag}")
        eventResponseHandler?.onEventResponse(view, null)
        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?

        if (null != eventObj)
            processEventHandler(eventObj, null)
    }

    private var eventResponseHandler: EventResponseHandler? = null

    /**
     * getting EventResponseHandler Instance from activity
     * @param event Instance of EventResponseHandler
     */
    fun registerEventListener(event: EventResponseHandler) {
        eventResponseHandler = event
    }


    override fun onClickHandler(view: View) {
        println("onClickHandler::$view ")
        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?
        when (view.tag) {
            "eSubmit" -> {
                utility.updateSkewState(appContext, dataPoolDataHandler.skewRadioButtonState.get()!!)
                SubUtility.persistLanguageSkew(appContext, dataPoolDataHandler.layoutDirectionRadioBtnState.get()!!)
               /* val i = GMSettingsApp.appContext.packageManager
                        .getLaunchIntentForPackage(GMSettingsApp.appContext.packageName)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                GMSettingsApp.appContext.activityContext.startActivity(i)
                GMSettingsApp.appContext.activityContext.recreate()*/
                dataPoolDataHandler.SETTINGS_TAB_SELECTION.set(0)
                SUBMIT_BUTTON_STATE = true
                SUBMIT_BUTTON = true
                GMSettingsApp.appContext.activityContext.finish()
                return
            }
            else -> processEventHandler(eventObj, null)
        }
    }

    override fun onClickHandler(view: View, any: Any, position: Int) {
        println("onClickHandler::$view $any")
        eventResponseHandler?.onEventResponse(view, any)

        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?
        if (null != eventObj)
            processEventHandler(eventObj, any)
    }

    override fun onRemoteHandler(remoteControlCommands: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     *  Listen's the click of row item of a List/RecyclerView
     */
    override fun onItemClickHandler(view: View, obj: Any) {
        println("tagname:: ${view.tag}")
        eventResponseHandler?.onEventResponse(view, obj)
        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?

        if (null != eventObj)
        processEventHandler(eventObj, obj)
    }


    override fun onClickHandler(view: View, state: Boolean) {

        println("tagname:: ${view.tag}")
        eventResponseHandler?.onEventResponse(view, state)
        val eventObj = eventProcessor.eventTable[view.tag] as JSONObject?

        if (null != eventObj)
            processEventHandler(eventObj, state)
    }


    override fun onVoiceHandler(vararg voiceControlCommands: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onKeyHandler(keyCode: Int, event: KeyEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     * Initialize custom events with given string
     *
     * @param eventName Custom event name
     */
    fun initEvent(eventName: String, obj: Any?) {
        println("initEvent:: $eventName")
        eventProcessor.processEvent(eventName, obj)
    }


    fun initRemoteEvent(eventName: String) {
        println("initEvent:: $eventName")
    }

    /**
     * Process the event passed by keyboard, voice, remote and user click actions.
     *
     * @param eventObj A JSON object mapped w.r.t the event type (defined in eventmap.json as a raw resource)
     * @param data Extra data that need to be passed while processing this event.
     */
    private fun processEventHandler(eventObj: JSONObject?, data: Any?) {
        if (eventObj != null) {
            val eventType = eventObj.getString("eventType")
            val eventName = eventObj.getString("eventName")
            val activityName = eventObj.getString("activityName")
            val isProcess = eventObj.getBoolean("isProcess")
            println("processEventHandler::$eventType $eventName $activityName $isProcess")
            eventProcessor.triggerEvent(eventType, eventName, data, activityName, isProcess)
        }
    }

    fun onRadioChanged(radioGroup: RadioGroup, id: Int) {
        // This will get the radiobutton that has changed in its check state

        when (id) {
            R.id.radioButton1 ->
                dataPoolDataHandler.themeType.set(true)
            R.id.radioButton2 ->
                dataPoolDataHandler.themeType.set(false)
            R.id.lhdRadiButton -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.LHD)
                utility.updateResources(appContext, "en")
            }
            R.id.rhdRadioButton -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.RHD)
            }
            R.id.rtlRadioButton -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.RTL)
            }
            R.id.SideBarEnable ->
                dataPoolDataHandler.isLargeScreenLayout.set(true)
            R.id.SideBarDisable -> {
                dataPoolDataHandler.isLargeScreenLayout.set(false)
                dataPoolDataHandler.isInfoCurvedView.set(false)
            }
            R.id.curveEnable ->
                dataPoolDataHandler.isInfoCurvedView.set(true)
            R.id.curveDisable ->
                dataPoolDataHandler.isInfoCurvedView.set(false)
            R.id.SkewEnable -> {
                dataPoolDataHandler.skewRadioButtonState.set(true)
            }
            R.id.SkewDisable -> {
                dataPoolDataHandler.skewRadioButtonState.set(false)
            }
        }

        when (id) {
            R.id.SpriteEnable -> {
                SubUtility.setNewLocaleThemeType(GMSettingsApp.appContext, "sprite")

                dataPoolDataHandler.themeType.set(false)
            }
            R.id.AzureEnable -> {
                SubUtility.setNewLocaleThemeType(GMSettingsApp.appContext, "azure")
                dataPoolDataHandler.themeType.set(true)
            }
        }
    }


    /**
     * countdown timer for 15 sec if user does not tap on displayed target point touch area on calibration screen
     * @return countdown timer obj
     */
    fun calibrationStartTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
        dataPoolDataHandler.CALIBRATE_TIMER = object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                eventProcessor.triggerEvent("navigate", "evG_calibrationfailurepopup", null, "SettingsCalibrationFailureActivity", false)
            }
        }
        return dataPoolDataHandler.CALIBRATE_TIMER as CountDownTimer
    }


    /**
     * start touch calibration on view
     * @param Int when onTouch event occurred on calibration toggle buttons, it return position
     * @param ToggleButton
     */
    fun startTouchScreenCalibration(position: Int, view: ToggleButton) {
        val handler: Handler? = Handler()
        handler!!.postDelayed({
            kotlin.run {
                dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_RIGHT.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNER.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNERCORNER.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_CENTER.set(false)

                when (position) {
                    Constants.CALIBRATE_TOP_LEFT ->
                        view.visibility = View.VISIBLE
                    Constants.CALIBRATE_TOP_RIFHT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_RIGHT.set(true)
                    }
                    Constants.CALIBRATE_BOTTOM_RIGHT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNER.set(true)

                    }
                    Constants.CALIBRATE_BOTTOM_LEFT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNERCORNER.set(true)
                    }
                    Constants.CENTER -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)

                        dataPoolDataHandler.CALIBRATE_TOGGLE_CENTER.set(true)

                    }

                }
            }
        }, 1000)
    }
}