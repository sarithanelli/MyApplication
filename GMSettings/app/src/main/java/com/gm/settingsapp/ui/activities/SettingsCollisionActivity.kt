package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsCollisionSystemsActivityBinding
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.ADAPTIVE_CRUISEGO_NOTIFIER
import com.gm.settingsapp.viewmodels.Constants.ALERT_TYPE
import com.gm.settingsapp.viewmodels.Constants.CONNECTED_VEHICLE_BRAKING_ALERT
import com.gm.settingsapp.viewmodels.Constants.DROWSY_DRIVER_ALETRT
import com.gm.settingsapp.viewmodels.Constants.FORWORD_COLLISION_SYSTEM
import com.gm.settingsapp.viewmodels.Constants.FRONT_PEDESTRIAN_DETECTION
import com.gm.settingsapp.viewmodels.Constants.INTERSECTIONS_TOP_ALERT
import com.gm.settingsapp.viewmodels.Constants.LANE_CHANGE_ALERT
import com.gm.settingsapp.viewmodels.Constants.PARK_ASSIST
import com.gm.settingsapp.viewmodels.Constants.PARK_ASSIST_TOWBAR
import com.gm.settingsapp.viewmodels.Constants.PEDESTRIAN_FRIENDLY_ALERT
import com.gm.settingsapp.viewmodels.Constants.PEDESTRIAN_FRIENDLY_ALERT_SOUND
import com.gm.settingsapp.viewmodels.Constants.PEDESTRIAN_FRIENDLY_ALERT_SOUND_TAG
import com.gm.settingsapp.viewmodels.Constants.PEDESTRIAN_FRIENDLY_ALERT_TAG
import com.gm.settingsapp.viewmodels.Constants.REAR_CAMERA_PARK_ASSIST_SYMBOLS
import com.gm.settingsapp.viewmodels.Constants.REAR_CROSS_TRAFFIC_ALERT
import com.gm.settingsapp.viewmodels.Constants.REAR_PEDESTRAIN_DETECTION
import com.gm.settingsapp.viewmodels.Constants.REAR_PEDESTRIAN_DETECTION_TAG
import com.gm.settingsapp.viewmodels.Constants.SEATBEL_TTIEGHTENING
import com.gm.settingsapp.viewmodels.Constants.SIDE_BELTZONE_ALERT
import com.gm.settingsapp.viewmodels.Constants.TRAFFIC_AND_ROADSIDE_INFORMATION
import com.gm.settingsservice.models.CollisionModeModel
import dagger.android.AndroidInjection

/**
 * To display Climate options/settings
 */
class SettingsCollisionActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_collision_systems) as SettingsCollisionSystemsActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }

        dataPoolDataHandler.SETTINGS_COLLISION_LIST.clear()

        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_pedestrian_friendly_alert_big), true, true, PEDESTRIAN_FRIENDLY_ALERT, GMSettingsApp.appContext.resources.getString(R.string.settings_pedestrian_friendly_alert_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_pedestrian_alert_sound), false, false, PEDESTRIAN_FRIENDLY_ALERT_SOUND, "", true))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_alert_type), true, false, ALERT_TYPE, "", false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_forward_collision_system_short), false, false, FORWORD_COLLISION_SYSTEM, "", true))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_front_pedestrian_detection), false, false, FRONT_PEDESTRIAN_DETECTION, "", true))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_intersection_stop_alert), false, false, INTERSECTIONS_TOP_ALERT, "", true))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_connected_vehicle_braking), true, true, CONNECTED_VEHICLE_BRAKING_ALERT, GMSettingsApp.appContext.resources.getString(R.string.settings_connected_vehicle_braking_alert), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel("Park Assist", true, true, TRAFFIC_AND_ROADSIDE_INFORMATION, GMSettingsApp.appContext.resources.getString(R.string.settings_traffic_and_roadside_information), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_drowsy_driver_alert_big), true, true, DROWSY_DRIVER_ALETRT, GMSettingsApp.appContext.resources.getString(R.string.settings_drowsy_driver_alert_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_adaptive_cruise_go_notifier_big), true, true, ADAPTIVE_CRUISEGO_NOTIFIER, GMSettingsApp.appContext.resources.getString(R.string.settings_adaptive_cruise_go_notifier_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_side_beltzone_alert_content), true, true, SIDE_BELTZONE_ALERT, GMSettingsApp.appContext.resources.getString(R.string.settings_side_blind_zone_alert_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_lane_change_alert_big), true, true, LANE_CHANGE_ALERT, GMSettingsApp.appContext.resources.getString(R.string.settings_lane_change_alert), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_seatbelt_tightening), true, true, SEATBEL_TTIEGHTENING, GMSettingsApp.appContext.resources.getString(R.string.settings_seat_belt_tightening_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_park_assist_short), true, true, PARK_ASSIST, GMSettingsApp.appContext.resources.getString(R.string.settings_park_assist), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel("Park Assist Primary Text", true, true, PARK_ASSIST_TOWBAR, GMSettingsApp.appContext.resources.getString(R.string.settings_park_assist_towbar), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rear_camera_park_assist_symbols_big), true, true, REAR_CAMERA_PARK_ASSIST_SYMBOLS, GMSettingsApp.appContext.resources.getString(R.string.settings_rear_camera_park_assist_symbols_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rear_cross_traffic_alerts), true, true, REAR_CROSS_TRAFFIC_ALERT, GMSettingsApp.appContext.resources.getString(R.string.settings_rear_cross_traffic_alerts_content), false))
        dataPoolDataHandler.SETTINGS_COLLISION_LIST.add(CollisionModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rear_pedestrian_detection), false, false, REAR_PEDESTRAIN_DETECTION, "", true))


    }

    override fun onResume() {
        super.onResume()
        headerTitle(GMSettingsApp.appContext.resources.getString(R.string.settings_collision))
    }

    override fun onEventResponse(view: View, obj: Any?) {

        when ((obj as CollisionModeModel).reference) {
            PEDESTRIAN_FRIENDLY_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            PEDESTRIAN_FRIENDLY_ALERT_SOUND -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_SOUND_TAG
            ALERT_TYPE -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            FORWORD_COLLISION_SYSTEM -> view.tag = REAR_PEDESTRIAN_DETECTION_TAG
            FRONT_PEDESTRIAN_DETECTION -> view.tag = REAR_PEDESTRIAN_DETECTION_TAG
            INTERSECTIONS_TOP_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_SOUND_TAG
            CONNECTED_VEHICLE_BRAKING_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            TRAFFIC_AND_ROADSIDE_INFORMATION -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            DROWSY_DRIVER_ALETRT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            ADAPTIVE_CRUISEGO_NOTIFIER -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            SIDE_BELTZONE_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            LANE_CHANGE_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            SEATBEL_TTIEGHTENING -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            PARK_ASSIST -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            PARK_ASSIST_TOWBAR -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            REAR_CAMERA_PARK_ASSIST_SYMBOLS -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            REAR_CROSS_TRAFFIC_ALERT -> view.tag = PEDESTRIAN_FRIENDLY_ALERT_TAG
            REAR_PEDESTRAIN_DETECTION -> view.tag = REAR_PEDESTRIAN_DETECTION_TAG
        }
    }
}

