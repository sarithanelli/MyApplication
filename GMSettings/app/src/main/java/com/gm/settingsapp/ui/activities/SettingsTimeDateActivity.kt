package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.Settingstimedateactivitybinding
import com.gm.settingsapp.viewmodels.TimeZoneParse
import com.gm.settingsservice.models.TimeDateModel
import com.gm.settingsservice.utils.BroadcastController
import com.gm.settingsservice.utils.ITimeChanged
import dagger.android.AndroidInjection
import java.util.*

/**
 * To display time and date options/settings
 */
class SettingsTimeDateActivity : BaseActivity(), ITimeChanged {
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_timedate_list) as Settingstimedateactivitybinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

        if (dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.get() == null) {
            val tzId = TimeZone.getDefault().id
            val tz = TimeZoneParse.getTimeZone(tzId)
            val text = if (tz != null) tz.displayOffset + ", " + tz.name else tzId
            dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.set(text)
        }
    }
    override fun onResume() {
        super.onResume()
        /*DataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_time_date_small))*/
        dataPoolDataHandler.SETTINGS_TIMEPICKER_VISIBILITY.set(true)
        BroadcastController.getInstance(applicationContext)!!.addTimeChangedListener(this)

        if (dataPoolDataHandler.IS_CADILLAC.get()==true) {
            dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_time_date_cadillactitle))
        }else{
            dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_time_date_small))
        }
    }

    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is TimeDateModel) {
            if (view is ToggleButton) {
                obj.isToggleState = view.isChecked
                if (obj.primaryData.equals(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_time_date))) {
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_STATUS.set(view.isChecked)
                } else if (obj.tPosition == 2) {
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_STATUS.set(view.isChecked)
                }
                dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(obj.tPosition, TimeDateModel(obj.primaryData, obj.secondaryData, obj.isTogglevisible, view.isChecked, obj.tPosition, obj.description))
            } else {
                if (obj.tPosition == 0) {
                    dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_use_24_hour_format))
                    dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.set(obj)
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_VISIBILITY.set(false)
                } else if (obj.tPosition == 2) {

                    dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_time_date))
                    dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.set(obj)
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_VISIBILITY.set(true)
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        BroadcastController.getInstance(applicationContext)!!.removeTimeChangedListener(this)
    }
    override fun OnTimeChanged() {
        eventHandler.initEvent("onSETTINGS_REQ_TIMEDATE", null)
    }
}

