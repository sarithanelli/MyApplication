package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsMyModeActivityBinding
import com.gm.settingsapp.databinding.SettingsVModeActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsservice.models.MyModeModel
import com.gm.settingsservice.models.VModeModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsVModeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_vmode) as SettingsVModeActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_VMODE_MENU.clear()
        dataPoolDataHandler.SETTINGS_VMODE_MENU.add(VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_enginesound), resources.getStringArray(R.array.my_mode_engine)[dataPoolDataHandler.SETTINGS_MYMODE_ENGINE_POS.get()!!], Constants.V_MODE_ENGINE))
        dataPoolDataHandler.SETTINGS_VMODE_MENU.add(VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_steering), resources.getStringArray(R.array.my_mode_steering)[dataPoolDataHandler.SETTINGS_MYMODE_STEERING_POS.get()!!], Constants.V_MODE_STEERING))
        dataPoolDataHandler.SETTINGS_VMODE_MENU.add(VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_suspension), resources.getStringArray(R.array.my_mode_suspension)[dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION_POS.get()!!], Constants.V_MODE_SUSPENSION))
        dataPoolDataHandler.SETTINGS_VMODE_MENU.add(VModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_power_train_engine), resources.getStringArray(R.array.vmode_brake)[dataPoolDataHandler.SETTINGS_VMODE_POWER_TRAIN_POS.get()!!], Constants.V_MODE_POWER))
        dataPoolDataHandler.SETTINGS_VMODE_MENU.add(VModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_brakefeel_response), resources.getStringArray(R.array.my_mode_brake)[dataPoolDataHandler.SETTINGS_MYMODE_BRAKE_POS.get()!!], Constants.V_MODE_BRAKE))
    }


    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_vmode))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as VModeModel).ref) {
            Constants.V_MODE_ENGINE -> view.tag = Constants.VMODE_ENGINE_TAG
            Constants.V_MODE_STEERING -> view.tag = Constants.VMODE_STEERING_TAG
            Constants.V_MODE_SUSPENSION -> view.tag = Constants.VMODE_SUSPENSION_TAG
            Constants.V_MODE_BRAKE -> view.tag = Constants.VMODE_BRAKE_TAG
            Constants.V_MODE_POWER -> view.tag = Constants.VMODE_POWER_TAG
        }
    }
}