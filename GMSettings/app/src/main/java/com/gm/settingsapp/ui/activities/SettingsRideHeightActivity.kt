package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsRideHeightActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.AUTO_ENTRY_EGRESS
import com.gm.settingsapp.viewmodels.Constants.LOCATION_BASED_AUTO_LIFT
import com.gm.settingsservice.models.CollisionModeModel
import com.gm.settingsservice.models.RideHeightModel
import dagger.android.AndroidInjection

/**
 * To display Climate options/settings
 */
class SettingsRideHeightActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_vehicle_ride_height) as SettingsRideHeightActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

        dataPoolDataHandler.SETTINGS_RIDE_HEIGHT_MENU.clear()

        dataPoolDataHandler.SETTINGS_RIDE_HEIGHT_MENU.add(RideHeightModel(GMSettingsApp.appContext.resources.getString(R.string.settings_location_based_auto_lift), true, true, LOCATION_BASED_AUTO_LIFT))
        dataPoolDataHandler.SETTINGS_RIDE_HEIGHT_MENU.add(RideHeightModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_entry_egress_assist), true, true, AUTO_ENTRY_EGRESS))


    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_ride_height))
    }

    override fun onEventResponse(view: View, obj: Any?) {
        when ((obj as RideHeightModel).reference) {
            Constants.LOCATION_BASED_AUTO_LIFT -> view.tag = Constants.RIDE_HEIGHT_ON_OFF_TAG
            Constants.AUTO_ENTRY_EGRESS -> view.tag = Constants.RIDE_HEIGHT_ON_OFF_TAG

        }
    }
}
