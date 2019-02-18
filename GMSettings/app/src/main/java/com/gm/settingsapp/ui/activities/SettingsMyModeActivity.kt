package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsMyModeActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_BRAKE
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_ENGINE
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_STEERING
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_SUSPENSION
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsMyModeActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_mymode) as SettingsMyModeActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_MYMODE_MENU.clear()

        dataPoolDataHandler.SETTINGS_MYMODE_MENU.add(MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_enginesound), resources.getStringArray(R.array.my_mode_engine)[dataPoolDataHandler.SETTINGS_MYMODE_ENGINE_POS.get()!!], MY_MODE_ENGINE))
        dataPoolDataHandler.SETTINGS_MYMODE_MENU.add(MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_steering), resources.getStringArray(R.array.my_mode_steering)[dataPoolDataHandler.SETTINGS_MYMODE_STEERING_POS.get()!!], MY_MODE_STEERING))
        dataPoolDataHandler.SETTINGS_MYMODE_MENU.add(MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_suspension), resources.getStringArray(R.array.my_mode_suspension)[dataPoolDataHandler.SETTINGS_MYMODE_SUSPENSION_POS.get()!!], MY_MODE_SUSPENSION))
        dataPoolDataHandler.SETTINGS_MYMODE_MENU.add(MyModeModel(GMSettingsApp.appContext.resources.getString(R.string.drive_mode_brakefeel_response), resources.getStringArray(R.array.my_mode_brake)[dataPoolDataHandler.SETTINGS_MYMODE_BRAKE_POS.get()!!], MY_MODE_BRAKE))
    }


    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_mymode))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as MyModeModel).ref) {
            MY_MODE_ENGINE -> view.tag = Constants.MYMODE_ENGINE_TAG
            MY_MODE_STEERING -> view.tag = Constants.MYMODE_STEERING_TAG
            MY_MODE_SUSPENSION -> view.tag = Constants.MYMODE_SUSPENSION_TAG
            MY_MODE_BRAKE -> view.tag = Constants.MYMODE_BRAKE_TAG
        }
    }
}