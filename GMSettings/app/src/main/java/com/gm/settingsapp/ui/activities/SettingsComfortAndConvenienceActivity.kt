package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsComfortConvenienceBinding
import com.gm.settingsapp.databinding.SettingsMyModeActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_EGRESS_ASSIST
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_MEMORY_RECALL
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_RUNNING_BOARDS
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_WIPE_IN_REVERSE_GEAR
import com.gm.settingsapp.viewmodels.Constants.C_CHIME_VOLUME
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_OPTIONS
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_SEAT
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_STEERING_COLUMN
import com.gm.settingsapp.viewmodels.Constants.C_HANDSFREE_LIFTGATE
import com.gm.settingsapp.viewmodels.Constants.C_PERSONALIZATION_BY_DRIVER
import com.gm.settingsapp.viewmodels.Constants.C_POWER_LIFTGATE
import com.gm.settingsapp.viewmodels.Constants.C_RAIN_SENSE_WIPERS
import com.gm.settingsapp.viewmodels.Constants.C_REMOTE_MIRROR_FOLDING
import com.gm.settingsapp.viewmodels.Constants.C_REVERSE_TILT_MIRROR
import com.gm.settingsapp.viewmodels.Constants.EXTENDED_HILL_START_ASSIST
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_BRAKE
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_ENGINE
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_STEERING
import com.gm.settingsapp.viewmodels.Constants.MY_MODE_SUSPENSION
import com.gm.settingsservice.models.ComfortAndConvenienceModel
import com.gm.settingsservice.models.MyModeModel
import dagger.android.AndroidInjection

/**
 * Activity for displaying Driving Mode List
 */
class SettingsComfortAndConvenienceActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_comfort_and_convenience) as SettingsComfortConvenienceBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.clear()

        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_running_boards_long),C_AUTO_RUNNING_BOARDS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_entry_egress_assist),C_AUTO_EGRESS_ASSIST))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_memory_recall), C_AUTO_MEMORY_RECALL))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_driver_seat), C_EASY_EXIT_SEAT))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_steering_column), C_EASY_EXIT_STEERING_COLUMN))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_options_big), C_EASY_EXIT_OPTIONS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_chime_volume), C_CHIME_VOLUME))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_power_liftgate), C_POWER_LIFTGATE))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_handsfree_liftgate_trunk_control), C_HANDSFREE_LIFTGATE))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_reverse_tilt_mirror), C_REVERSE_TILT_MIRROR))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_remote_mirror_folding_short), C_REMOTE_MIRROR_FOLDING))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_personalization_by_driver_big), C_PERSONALIZATION_BY_DRIVER))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rain_sense_wipers_big), C_RAIN_SENSE_WIPERS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_wipe_in_reverse_gear_big), C_AUTO_WIPE_IN_REVERSE_GEAR))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_vehicle_hold_long), EXTENDED_HILL_START_ASSIST))


    }


    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_comfort_convenience))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as ComfortAndConvenienceModel).ref) {
            C_AUTO_RUNNING_BOARDS -> view.tag = Constants.AUTOMATIC_RUNNING_BOARDS
           /* MY_MODE_STEERING -> view.tag = Constants.MYMODE_STEERING_TAG
            MY_MODE_SUSPENSION -> view.tag = Constants.MYMODE_SUSPENSION_TAG
            MY_MODE_BRAKE -> view.tag = Constants.MYMODE_BRAKE_TAG*/
        }
    }
}