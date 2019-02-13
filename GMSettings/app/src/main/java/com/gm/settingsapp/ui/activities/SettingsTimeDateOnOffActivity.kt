package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.ToggleButton
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsTimeDateOnOffActivityBinding
import com.gm.settingsapp.viewmodels.Constants.RADIOBUTTON_ON
import com.gm.settingsservice.models.TimeDateModel
import com.gm.settingsservice.utils.BroadcastController
import com.gm.settingsservice.utils.ITimeChanged
import dagger.android.AndroidInjection


/**
 * This screen is to enable or disable the options like use 24-hour format, Automatic time update
 */
class SettingsTimeDateOnOffActivity : BaseActivity(), ITimeChanged {


    override fun onEventResponse(view: View, obj: Any?) {
        if (obj is TimeDateModel && view is ToggleButton) {
            if (obj.tPosition == 2) {
                if (view is ToggleButton) {
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_STATUS.set(view.isChecked)
                }
            }
            dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.get()!!.isToggleState = view.isChecked
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(obj.tPosition,
                    TimeDateModel(obj.primaryData, obj.secondaryData, obj.isTogglevisible, view.isChecked, obj.tPosition, obj.description))
            if (dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.get()!!.isToggleState) {
                dataPoolDataHandler.SETTINGS_ON_OFF_TEXT_STATUS.set(resources.getString(R.string.settings_on))
            } else {
                dataPoolDataHandler.SETTINGS_ON_OFF_TEXT_STATUS.set(resources.getString(R.string.autohighbeam_list))
            }

        } else if (obj is TimeDateModel) {
            if (obj.tPosition == 2) {
                if ((view as RadioButton).text == RADIOBUTTON_ON) {
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_STATUS.set(true)
                } else {
                    dataPoolDataHandler.SETTINGS_TIMEPICKER_STATUS.set(false)
                }
            }
            dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.get()!!.isToggleState = (view as RadioButton).text == RADIOBUTTON_ON
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW[obj.tPosition] = TimeDateModel(obj.primaryData, obj.secondaryData, obj.isTogglevisible, dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.get()!!.isToggleState, obj.tPosition, obj.description)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_timedate_on_off) as SettingsTimeDateOnOffActivityBinding
        binding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        if (dataPoolDataHandler.SETTINGS_REQ_TIMEDATEDATAOBJ.get()!!.isToggleState) {
            dataPoolDataHandler.SETTINGS_ON_OFF_TEXT_STATUS.set(resources.getString(R.string.settings_on))
        } else {
            dataPoolDataHandler.SETTINGS_ON_OFF_TEXT_STATUS.set(resources.getString(R.string.autohighbeam_list))
        }
    }

    override fun onResume() {
        super.onResume()
        BroadcastController.getInstance(applicationContext)!!.addTimeChangedListener(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        BroadcastController.getInstance(applicationContext)!!.removeTimeChangedListener(this)
    }

    /**
     * This method is used to update time
     */
    override fun OnTimeChanged() {
        eventHandler.initEvent("onSETTINGS_REQ_TIMEDATE", null)
    }


}