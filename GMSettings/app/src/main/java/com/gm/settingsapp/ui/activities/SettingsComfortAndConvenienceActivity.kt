package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsComfortConvenienceBinding
import com.gm.settingsapp.databinding.SettingsMyModeActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_ENTRY
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
    }
    override fun onResume() {
        super.onResume()
        headerTitle(getString(com.gm.settingsapp.R.string.settings_comfort_convenience))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as ComfortAndConvenienceModel).ref) {
            C_CHIME_VOLUME -> view.tag = Constants.CHIME_VOLUME
            C_AUTO_ENTRY -> view.tag = Constants.AUTOMATIC_ENTRY
            C_POWER_LIFTGATE -> view.tag = Constants.POWER_LIFTGATE
            C_REVERSE_TILT_MIRROR -> view.tag = Constants.AUTOMATIC_ENTRY
            C_REMOTE_MIRROR_FOLDING -> view.tag = Constants.AUTOMATIC_ENTRY
            C_AUTO_WIPE_IN_REVERSE_GEAR -> view.tag = Constants.AUTOMATIC_ENTRY
            C_RAIN_SENSE_WIPERS -> view.tag = Constants.RAINSENSEWIPER
            C_HANDSFREE_LIFTGATE -> view.tag = Constants.HANDFREELIFTGATE
            EXTENDED_HILL_START_ASSIST -> view.tag = Constants.EXTENDED_HILL_START_ASSIST_TAG

            /*  C_EASY_EXIT_SEAT -> view.tag = Constants.AUTOMATIC_ENTRY
           C_EASY_EXIT_OPTIONS -> view.tag = Constants.AUTOMATIC_ENTRY
           C_PERSONALIZATION_BY_DRIVER -> view.tag = Constants.AUTOMATIC_ENTRY
         C_EASY_EXIT_STEERING_COLUMN -> view.tag = Constants.AUTOMATIC_RUNNING_BOARDS
           C_AUTO_RUNNING_BOARDS -> view.tag = Constants.AUTOMATIC_RUNNING_BOARDS
           C_AUTO_MEMORY_RECALL -> view.tag = Constants.AUTOMATIC_ENTRY*/

        }
    }
}