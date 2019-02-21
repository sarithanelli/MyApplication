package com.gm.settingsapp.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.databinding.ObservableField
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.utils.SubUtility
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_ENTRY
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_MEMORY_RECALL
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_RUNNING_BOARDS
import com.gm.settingsapp.viewmodels.Constants.C_AUTO_WIPE_IN_REVERSE_GEAR
import com.gm.settingsapp.viewmodels.Constants.C_CHIME_VOLUME
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_OPTIONS
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_SEAT
import com.gm.settingsapp.viewmodels.Constants.C_EASY_EXIT_STEERING_COLUMN
import com.gm.settingsapp.viewmodels.Constants.C_EXTENDED_HILL_START_ASSIST
import com.gm.settingsapp.viewmodels.Constants.C_HANDSFREE_LIFTGATE
import com.gm.settingsapp.viewmodels.Constants.C_PERSONALIZATION_BY_DRIVER
import com.gm.settingsapp.viewmodels.Constants.C_POWER_LIFTGATE
import com.gm.settingsapp.viewmodels.Constants.C_RAIN_SENSE_WIPERS
import com.gm.settingsapp.viewmodels.Constants.C_REMOTE_MIRROR_FOLDING
import com.gm.settingsapp.viewmodels.Constants.C_REVERSE_TILT_MIRROR
import com.gm.settingsapp.viewmodels.Constants.DIFFUES_AIRFLOW_VALUE
import com.gm.settingsapp.viewmodels.Constants.DIRECT_AIRFLOW_VALUE
import com.gm.settingsapp.viewmodels.Constants.DISPLAY_TURN_OFF
import com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_ENGINE_SOUND
import com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_STEERING
import com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_SUSPENSION
import com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_TRACTION
import com.gm.settingsapp.viewmodels.Constants.HEIGH_SENSITIVITY_VALUE
import com.gm.settingsapp.viewmodels.Constants.HEIGH_VALUE
import com.gm.settingsapp.viewmodels.Constants.LOW_SENSITIVITY_VALUE
import com.gm.settingsapp.viewmodels.Constants.LOW_VALUE
import com.gm.settingsapp.viewmodels.Constants.MEDIUM_VALUE
import com.gm.settingsapp.viewmodels.Constants.NORMAL_AIRFLOW_VALUE
import com.gm.settingsapp.viewmodels.Constants.OFF_VALUE
import com.gm.settingsapp.viewmodels.Constants.OSCILLATING_AIRFLOW_VALUE
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.apiintegration.apiinterfaces.ISettingsManagerRes
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.AppSignal
import com.gm.settingsservice.utils.CalibrationSettings
import com.gm.settingsservice.utils.Constants
import com.gm.settingsservice.utils.Constants.DEFAULT
import com.gm.settingsservice.utils.Log
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class GMResponseListner @Inject constructor(utility: com.gm.settingsapp.utils.Utility, serviceUtility: com.gm.settingsservice.utils.Utility, dataPoolDataHandler: DataPoolDataHandler, systemListener: SystemListener, context: Context) : ISettingsManagerRes {
    override fun onSETTINGS_RES_AUTOMATIC_ENTRY_EGRESS_ASSIST() {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(getStringFromResource(R.string.settings_automatic_entry_egress_assist))
    }
    override fun onSETTINGS_RES_REVERSE_TILTMIRROR() {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(getStringFromResource(R.string.settings_reverse_tilt_mirror))
    }

    override fun onSETTINGS_RES_REMOTE_MIRRORFOLDING() {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(getStringFromResource(R.string.settings_remote_mirror_folding))
    }
    override fun onSETTINGS_RES__COMFORT_CONVENIENCE_MENU() {

        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.clear()
        // dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_running_boards_long),C_AUTO_RUNNING_BOARDS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_entry_egress_assist), C_AUTO_ENTRY))
        // dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_memory_recall), C_AUTO_MEMORY_RECALL))
        //dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_driver_seat), C_EASY_EXIT_SEAT))
        //dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_steering_column), C_EASY_EXIT_STEERING_COLUMN))
        // dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_easy_exit_options_big), C_EASY_EXIT_OPTIONS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_chime_volume), C_CHIME_VOLUME))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_power_liftgate), C_POWER_LIFTGATE))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_handsfree_liftgate_trunk_control), C_HANDSFREE_LIFTGATE))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_reverse_tilt_mirror), C_REVERSE_TILT_MIRROR))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_remote_mirror_folding_short), C_REMOTE_MIRROR_FOLDING))
        //  dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_personalization_by_driver_big), C_PERSONALIZATION_BY_DRIVER))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rain_sense_wipers_big), C_RAIN_SENSE_WIPERS))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_wipe_in_reverse_gear_big), C_AUTO_WIPE_IN_REVERSE_GEAR))
        dataPoolDataHandler.SETTINGS_COMFORT_AND_CONVENIENCE.add(ComfortAndConvenienceModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_vehicle_hold_long), com.gm.settingsapp.viewmodels.Constants.EXTENDED_HILL_START_ASSIST))
    }
    override fun onSETTINGS_RES_RAIN_SENSE_WIPERS() {
    }

    override fun onSETTINGS_RES_AUTO_WIPE_REVERSEGEAR() {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(getStringFromResource(R.string.settings_auto_wipe_in_reverse_gear_big))

    }

    override fun onSETTINGS_RES_EXTENDED_HILL_START_ASSIST() {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(getStringFromResource(R.string.settings_extended_hill_start_assist))

    }


    override fun SOUNDPARAMS_RES_CHIMEVOLUME() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_POWER_LIFTGATE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_HANDSFREE_LIFTGATE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    var utility: com.gm.settingsapp.utils.Utility = utility

    var serviceUtility: com.gm.settingsservice.utils.Utility = serviceUtility

    var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler

    override fun onSETTINGS_APPS_RES_DATA() {

        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.clear()
        /*   if (SettingsService.isSDKAvailable()) {
               if (CalibrationSettings.getInstance(GMSettingsApp.appContext).doesNavigationExits() || CalibrationSettings.getInstance(GMSettingsApp.appContext).doesCarPlayEnabled())
                   dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_android_auto), true, dataPoolDataHandler.DEVICEPROJECTION_GOOGLEAUTOLINKENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.ANDROID_AUTO, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_android_auto_settings_content)))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_apple_carplay_short1), true, dataPoolDataHandler.DEVICEPROJECTION_APPLECARPLAYENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.APPLE_CARPLAY, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_apple_carplay_settings_content)))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_audio_small), false, false, com.gm.settingsapp.viewmodels.Constants.AUDIO, ""))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_Cameras), false, false, com.gm.settingsapp.viewmodels.Constants.CAMERA, ""))
               if (dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_climate_app))) {
                   dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_climate), false, false, com.gm.settingsapp.viewmodels.Constants.CLIMATE, ""))
               }
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_energy), false, false, com.gm.settingsapp.viewmodels.Constants.ENERGY, ""))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_mirrorlink), true, dataPoolDataHandler.DEVICEPROJECTION_GOOGLEAUTOLINKENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.MIRROR_LINK, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_mirror_link_settings_content)))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_navigation_short), false, false, com.gm.settingsapp.viewmodels.Constants.NAVIGATION, ""))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_phone_small2), false, false, com.gm.settingsapp.viewmodels.Constants.PHONE, ""))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_trailering), false, false, com.gm.settingsapp.viewmodels.Constants.TRAILERING, ""))
               dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_video), true, true, com.gm.settingsapp.viewmodels.Constants.VIDEO, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_video_voice_content)))
           } else {*/
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_android_auto), true, true, com.gm.settingsapp.viewmodels.Constants.ANDROID_AUTO, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_android_auto_settings_content)))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_apple_carplay_short1), true, true, com.gm.settingsapp.viewmodels.Constants.APPLE_CARPLAY, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_apple_carplay_settings_content)))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_audio_small), false, false, com.gm.settingsapp.viewmodels.Constants.AUDIO, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_Cameras), false, false, com.gm.settingsapp.viewmodels.Constants.CAMERA, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_climate), false, false, com.gm.settingsapp.viewmodels.Constants.CLIMATE, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_energy), false, false, com.gm.settingsapp.viewmodels.Constants.ENERGY, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_mirrorlink), true, true, com.gm.settingsapp.viewmodels.Constants.MIRROR_LINK, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_mirror_link_settings_content)))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_navigation_short), false, false, com.gm.settingsapp.viewmodels.Constants.NAVIGATION, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_phone_small2), false, false, com.gm.settingsapp.viewmodels.Constants.PHONE, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_trailering), false, false, com.gm.settingsapp.viewmodels.Constants.TRAILERING, ""))
        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.add(AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_video), true, true, com.gm.settingsapp.viewmodels.Constants.VIDEO, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_video_voice_content)))
        //}
    }

    //response for display status
    override fun onSETTINGS_RES_DISPLAYSTATUS(any: Any) {
        dataPoolDataHandler.SETTINGS_DISPLAYSTATUS.set(any.toString())
    }

    override fun onSETTINGS_RES_DISPLAY_CADILLAC(value: ObservableField<Int>) {
        var num: Int = value.get()!!
        when (num) {
            com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP -> {
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.clear()
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_head_up), GMSettingsApp.appContext.resources.getString(R.string.ui_on), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_adjustment), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_ADJUSTMENT))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_head_up_control), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
                dataPoolDataHandler.SETTINGS_TAB_DISPLAY_SELECTION.set(0)
            }
            com.gm.settingsapp.viewmodels.Constants.DISPLAY_INSTRUMENT -> {
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.clear()
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_layout), GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_gauge), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_left_view), GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_weather), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_ADJUSTMENT))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_right_view), GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_audio), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_speed_info), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
                dataPoolDataHandler.SETTINGS_TAB_DISPLAY_SELECTION.set(1)
            }

            com.gm.settingsapp.viewmodels.Constants.DISPLAY_RADIO_DISPLAY -> {
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.clear()
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_screen_saver), GMSettingsApp.appContext.resources.getString(R.string.ui_off), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_rear_climate), GMSettingsApp.appContext.resources.getString(R.string.ui_off), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_ADJUSTMENT))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_air_quality), GMSettingsApp.appContext.resources.getString(R.string.ui_off), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_turn_off), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
                dataPoolDataHandler.SETTINGS_TAB_DISPLAY_SELECTION.set(2)
            }
        }
    }

    override fun onSETTINGS_RES_SPORTMODESPORTSTEERINGSETTINGS(settingssportmodesportsteering: java.util.ArrayList<ESettingsSteeringCustomization>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESETTINGS(any: Any) {
    }

    override fun onSETTINGS_RES_OPENSOURCE(path: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_BUILDNUMBER() {
        if (GMSettingsApp.appContext.activityContext.isFinishing()) {
            return
        }

        mDevHitCountdown =
                if (GMSettingsApp.appContext.getSharedPreferences(PREF_FILE,
                                Context.MODE_PRIVATE).getBoolean(PREF_SHOW,
                                android.os.Build.TYPE == "eng"))
                    -1
                else
                    TAPS_TO_BE_A_DEVELOPER
        mDevHitToast = null

    }


    internal val TAPS_TO_BE_A_DEVELOPER = 7
    internal var mDevHitCountdown: Int = 0
    internal var mDevHitToast: Toast? = null
    val PREF_FILE = "development"
    val PREF_SHOW = "show"
    override fun onSETTINGS_RES_BUILDCLICK() {

        if (mDevHitCountdown > 0) {
            mDevHitCountdown--;
            if (mDevHitCountdown == 0) {
                GMSettingsApp.appContext.getSharedPreferences(PREF_FILE,
                        Context.MODE_PRIVATE).edit().putBoolean(
                        PREF_SHOW, true).apply()
                if (mDevHitToast != null) {
                    mDevHitToast!!.cancel()
                }
                mDevHitToast = Toast.makeText(GMSettingsApp.appContext, GMSettingsApp.appContext.getResources().getString(R.string.show_dev_on),
                        Toast.LENGTH_LONG)
                mDevHitToast!!.show()

            } else if (mDevHitCountdown > 0
                    && mDevHitCountdown < (TAPS_TO_BE_A_DEVELOPER - 2)) {
                if (mDevHitToast != null) {
                    mDevHitToast!!.cancel()
                }
                mDevHitToast = Toast.makeText(GMSettingsApp.appContext, GMSettingsApp.appContext.getResources().getQuantityString(
                        R.plurals.show_dev_countdown, mDevHitCountdown, mDevHitCountdown),
                        Toast.LENGTH_SHORT)
                mDevHitToast!!.show();
            }
        } else if (mDevHitCountdown < 0) {
            if (mDevHitToast != null) {
                mDevHitToast!!.cancel()
            }
            mDevHitToast = Toast.makeText(GMSettingsApp.appContext, GMSettingsApp.appContext.resources.getString(R.string.show_dev_already),
                    Toast.LENGTH_LONG);
            mDevHitToast!!.show();
        }


    }


    override fun onSETTINGS_RES_CLIMATE_MENU_LIST() {

        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.clear()

        var qualityTag: String? = null
        var fanTag: String? = null
        var distributionTag: String? = null


        /*if (SettingsService.isSDKAvailable()) {
            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AutomaticFan).isAvailable) {
                    when (AppSignal.getInstance(AppSignal.SignalKey.AutomaticFan).signalValue) {
                        LOW_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_low)
                        MEDIUM_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_medium)
                        HEIGH_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_high)
                    }
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_fan_max_speed), fanTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED, ""))
                    dataPoolDataHandler.SETTINGS_AUTO_FAN_SPEED_VALUE.set(AppSignal.getInstance(AppSignal.SignalKey.AutomaticFan).signalValue)
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AirQualitySensor).isAvailable) {

                    when (AppSignal.getInstance(AppSignal.SignalKey.AirQualitySensor).signalValue) {
                        OFF_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.ui_off)
                        LOW_SENSITIVITY_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_low_sensitivity)
                        HEIGH_SENSITIVITY_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_high_sensitivity)
                    }
                    dataPoolDataHandler.SETTINGS_AIR_QUALITY_SENSOR_VALUE.set(AppSignal.getInstance(AppSignal.SignalKey.AirQualitySensor).signalValue)
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_air_quality_sensor), qualityTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR, ""))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.PollutionControl).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_pollution_control), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.PollutionControl).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_pollution_control_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }


            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AutomaticCooledSeat).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_cooled_seats_big), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.AutomaticCooledSeat).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_cooled_seats_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AutomaticHeatedSeat).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_heated_seats_big), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.AutomaticHeatedSeat).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_heat_seats_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.RearZoneStartup).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rear_zone_temp_big), GMSettingsApp.appContext.resources.getString(R.string.settings_rear_last_known), false, false, com.gm.settingsapp.viewmodels.Constants.REAR_ZONE, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_rear_zone_temp_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AutomaticDefog).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_defog_big), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.AutomaticDefog).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_defog_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.RearDefogStartup).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_rear_defog), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.RearDefogStartup).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.AUTO_REAR_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_rear_defog_content)))
                }

            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.ElevatedIdle).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_elevated_idle_short), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.ElevatedIdle).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.ELEVATED_IDLE, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_elevated_idle_content)))
                }

            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.AutoAirDistribution).isAvailable) {

                    when (AppSignal.getInstance(AppSignal.SignalKey.AutoAirDistribution).signalValue) {
                        DIFFUES_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_diffuse_airflow)
                        DIRECT_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_direct_airflow)
                    }
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_air_distribution_big), distributionTag!!, false, true, com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION, ""))
                    dataPoolDataHandler.SETTINGS_AUTO_AIR_DISTRIBUTION_VALUE.set(AppSignal.getInstance(AppSignal.SignalKey.AutoAirDistribution).signalValue)
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }

            try {
                if (AppSignal.getInstance(AppSignal.SignalKey.IonizerControl).isAvailable) {
                    dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_ionizer), "", true,
                            AppSignal.getInstance(AppSignal.SignalKey.IonizerControl).signalValue == 2, com.gm.settingsapp.viewmodels.Constants.IONIZER, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_ionizer_content)))
                }
            } catch (e: Exception) {
                Log.i("", "Exception " + e.printStackTrace())
            }
        } else {*/

        when (dataPoolDataHandler.SETTINGS_AIR_QUALITY_SENSOR_VALUE.get()) {
            OFF_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.ui_off)
            LOW_SENSITIVITY_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_low_sensitivity)
            HEIGH_SENSITIVITY_VALUE -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_high_sensitivity)
        }

        when (dataPoolDataHandler.SETTINGS_AUTO_FAN_SPEED_VALUE.get()) {
            LOW_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_low)
            MEDIUM_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_medium)
            HEIGH_VALUE -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_high)
        }

        when (dataPoolDataHandler.SETTINGS_AUTO_AIR_DISTRIBUTION_VALUE.get()) {
            DIFFUES_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_diffuse_airflow)
            DIRECT_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_direct_airflow)
            NORMAL_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_direct_normalflow)
            OSCILLATING_AIRFLOW_VALUE -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_oscillating_airflow)
        }

        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_fan_max_speed), fanTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED, ""))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_air_quality_sensor), qualityTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR, ""))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_pollution_control), "", true, true, com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_pollution_control_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_cooled_seats_big), "", true, true, com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_cool_seats_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_heated_seats_big), "", true, true, com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_heated_seats_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_rear_zone_temp_big), GMSettingsApp.appContext.resources.getString(R.string.settings_rear_last_known), false, true, com.gm.settingsapp.viewmodels.Constants.REAR_ZONE, ""))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_defog_big), "", true, true, com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_defog_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_rear_defog), "", true, true, com.gm.settingsapp.viewmodels.Constants.AUTO_REAR_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_rear_defog_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_elevated_idle_short), "", true, true, com.gm.settingsapp.viewmodels.Constants.ELEVATED_IDLE, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_elevated_idle_content)))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_air_distribution_big), distributionTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION, ""))
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.add(ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_ionizer), "", true, true, com.gm.settingsapp.viewmodels.Constants.IONIZER, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_ionizer_content)))

        // }

    }

    override fun onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(any: Any) {
    }

    override fun onSETTINGS_RES_GET_STORAGE_USAGE(usedStorage: String, freeStorage: String, progress: Int) {
    }

    override fun onSETTINGS_RES_GET_CONFIRM_FORCESTOP() {
        GMSettingsApp.appContext.activityContext.finish()
    }

    override fun onSETTINGS_RES_GET_RUNNINGAPPSTOP_POS(any: Any) {
    }


    override fun onSETTINGS_RES_ENGINESOUNDLIST(enginemodeList: ArrayList<ESettingsChangePerfModeSound>) {
        /*  if (dataPoolDataHandler.SETTINGS_DRIVE_MODE_ENGINE.size == 0) {
          //    dataPoolDataHandler.SETTINGS_DRIVE_MODE_ENGINE.addAll(enginemodeList)
              if (!SettingsService.isSDKAvailable())
                  dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(dataPoolDataHandler.ENGINESOUND_MAP_STATE.get(7))
          }
          if (SettingsService.isSDKAvailable()) {
              dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(dataPoolDataHandler.ENGINESOUND_MAP_STATE.get(Signals.PerformanceModeSoundSignal().signalValue))
          }*/
    }

    override fun onSETTINGS_RES_DRIVINGMODELIST(driverModeList: ArrayList<DriveModeModel>) {
        utility.EngineSoundMode()
    }

    override fun onSETTINGS_RES_VEHICLELIST(vehicleList: ArrayList<String>) {

    }


    override fun onSETTINGS_RES_CLIMATE() {
        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_drive_mode_customization))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_drive_mode_customization))
        }

        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_vmode))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_vmode))
        }
        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_mymode))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_mymode))
        }
        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_climate_app))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_climate_app))
        }

        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_collision))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_collision))
        }

        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_comfort_and_convenience))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_comfort_and_convenience))
        }

        if (!dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.contains(GMSettingsApp.appContext.getString(R.string.settings_ride_height))) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_ride_height))
        }
    }

    init {
        systemListener.registerApiCallback(this)
    }

    override fun onSETTINGS_RES_VEHICLEDISPLAYUNITS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PROPERUSEWARNING(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PROPERUSEWARNINGACKNOWLEDGED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SYSTEMFAULTSTATE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING(settingsadaptiveforwardlighting: SettingsAdaptiveForwardLighting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING(settingsadaptiveforwardlighting1: SettingsAdaptiveForwardLighting1_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING(settingsadaptiveforwardlightingwithgps: SettingsAdaptiveForwardLightingWithGPS_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsadaptivehighbeamassist: SettingsAdaptiveHighBeamAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsadaptivehighbeamassistwithsensitivity: SettingsAdaptiveHighBeamAssistWithSensitivity_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LOCATIONBASEDCHARGING(settingslocationbasedcharging: SettingsLocationBasedCharging_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ENERGYSUMMARYPOPUP(settingsenergysummarypopup: SettingsEnergySummaryPopup_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_CHARGESTATUSFEEDBACK(settingschargestatusfeedback: SettingsChargeStatusFeedback_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_CHARGECORDTHEFTALERT(settingschargecordtheftalert: SettingsChargeCordTheftAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_CHARGEPOWERLOSSALERT(settingschargepowerlossalert: SettingsChargePowerLossAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_STANDBYSPEED(settingsstandbyspeed: SettingsStandBySpeed_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SET1SPEED(settingsset1speed: SettingsSet1Speed_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SET2SPEED(settingsset2speed: SettingsSet2Speed_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_TAPSTEPSPEED(settingstapstepspeed: SettingsTapStepSpeed_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SHUTDOWNTIME(settingsshutdowntime: SettingsShutDownTime_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ALERTTYPESETTINGS(settingscollisiondetectionalerttype: SettingsCollisionDetectionAlertType_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     *
     */
    override fun onSETTINGS_RES_AUDIBLETOUCHFEEDBACK(pData: Int) {


    }

    override fun onSETTINGS_RES_AUDIOCUES(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsautohighbeamassist: SettingsAutoHighBeamAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsautohighbeamassistwithsensitivity: SettingsAutoHighBeamAssistWithSensitivity_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALL1SETTING(settingsautomemoryrecall1: SettingsAutoMemoryRecall1_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALL2SETTING(settingsautomemoryrecall2: SettingsAutoMemoryRecall2_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALLSETTING(settingsautomemoryrecall: SettingsAutoMemoryRecall_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOMIRRORFOLDINGSETTING(settingsautomirrorfolding: SettingsAutoMirrorFolding_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_AUTOWIPEINREVERSEGEARSETTING(settingsautowipeinreversegear: SettingsAutoWipeinReverseGear_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_AUTOMATICVEHICLEHOLDSETTING(settingsautomaticvehiclehold: SettingsAutomaticVehicleHold_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EXTENDEDHILLSTARTASSISTSETTING(settingsextendedhillstartassist: SettingsExtendedHillStartAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING(settingsdaytimetaillights: SettingsDaytimeTailLights_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING(settingsdriverdrowsinessdetectioncustomization: SettingsDriverDrowsinessDetectionCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     *Response for vehicle tab
     */
    override fun onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsavailibilityflag: GlobalSettingsAvailibilityFlag_t) {
        dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.clear()
        if (globalsettingsavailibilityflag.drivingModeFlag == Constants.ENABLE_SETTING) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_driving_mode_big))
        }
        if (globalsettingsavailibilityflag.sportsModeCustomizationFlag == Constants.ENABLE_SETTING) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_sport_mode_customization))
        }
        if (globalsettingsavailibilityflag.autoModeCustomizationFlag == Constants.ENABLE_SETTING) {
            dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.add(GMSettingsApp.appContext.getString(R.string.settings_auto_mode_customization))
        }

        mapDriverModeEngineSoundValues()
        mapDriverModeSteeringValues()
        mapDriverModeSuspensionValues()
        mapDriverModeTractionValues()
    }

    fun mapDriverModeEngineSoundValues() {
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(DEFAULT, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_AUTO, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_STEALTH, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_CITY, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_TOUR, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_SPORT, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_TRACK, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK)
        dataPoolDataHandler.ENGINESOUND_MAP_STATE.set(Constants.ENGINE_SOUND_OFF, ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO.toString(), Constants.ENGINE_SOUND_AUTO)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH.toString(), Constants.ENGINE_SOUND_STEALTH)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY.toString(), Constants.ENGINE_SOUND_CITY)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR.toString(), Constants.ENGINE_SOUND_TOUR)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT.toString(), Constants.ENGINE_SOUND_SPORT)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK.toString(), Constants.ENGINE_SOUND_TRACK)
        dataPoolDataHandler.ENGINESOUND_MAP.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF.toString(), Constants.ENGINE_SOUND_OFF)
    }

    fun mapDriverModeSteeringValues() {
        dataPoolDataHandler.STEERING_MAP_STATE.set(DEFAULT, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_TOUR, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_SPORT, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_TRACK, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_ECO, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_CITY, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_AUTO, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO)
        dataPoolDataHandler.STEERING_MAP_STATE.set(Constants.STEERING_MODE6, ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO.toString(), Constants.STEERING_AUTO)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO.toString(), Constants.STEERING_MODE6)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR.toString(), Constants.STEERING_TOUR)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT.toString(), Constants.STEERING_SPORT)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR.toString(), Constants.ENGINE_SOUND_TOUR)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK.toString(), Constants.STEERING_TRACK)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO.toString(), Constants.STEERING_ECO)
        dataPoolDataHandler.STEERING_MAP.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY.toString(), Constants.STEERING_CITY)
    }

    fun mapDriverModeSuspensionValues() {
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(DEFAULT, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_TOUR, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_SPORT, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_TRACK, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_MODE4, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_MODE5, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_MODE6, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP_STATE.set(Constants.SUSPENSION_AUTO, ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO.toString(), Constants.SUSPENSION_AUTO)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR.toString(), Constants.SUSPENSION_TOUR)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT.toString(), Constants.SUSPENSION_SPORT)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK.toString(), Constants.SUSPENSION_TRACK)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO.toString(), Constants.SUSPENSION_MODE4)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO.toString(), Constants.SUSPENSION_MODE5)
        dataPoolDataHandler.SUSPENSION_MAP.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO.toString(), Constants.SUSPENSION_MODE6)
    }

    fun mapDriverModeTractionValues() {
        dataPoolDataHandler.TRACTION_MAP_STATE.set(DEFAULT, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.STEERING_AUTO, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_TOUR, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_SPORT, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_TRACK, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_ECO, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_SNOW, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER)
        dataPoolDataHandler.TRACTION_MAP_STATE.set(Constants.TRACTION_OFF, ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO.toString(), Constants.STEERING_AUTO)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR.toString(), Constants.TRACTION_TOUR)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT.toString(), Constants.TRACTION_SPORT)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO.toString(), Constants.TRACTION_ECO)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER.toString(), Constants.TRACTION_SNOW)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK.toString(), Constants.TRACTION_TRACK)
        dataPoolDataHandler.TRACTION_MAP.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF.toString(), Constants.TRACTION_OFF)
    }

    override fun onSETTINGS_MANAGE_RES_FAV() {
        dataPoolDataHandler.SETTINGS_SET_NUMBER_FAVORITES.clear()
        GMSettingsApp.appContext.resources.getIntArray(R.array.favorite_set_audio_number_favorites).forEach {
            dataPoolDataHandler.SETTINGS_SET_NUMBER_FAVORITES.add(it)
        }
    }

    /**
     *Response for driver mode
     */
    override fun onSETTINGS_RES_SUPPORTEDSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        getDriverModeListItems(settingsavailibilityflag)
        getSportModeListItems(settingsavailibilityflag)
    }

    override fun onSETTINGS_RES_SUPPORTEDSPORTSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        getSportModeListItems(settingsavailibilityflag)
    }

    fun getDriverModeListItems(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.clear()
        val list = ArrayList<DriveModeModel>()
        if (settingsavailibilityflag.SettingsChangePerfModeSoundCustomizationFlag >= 0) {
            list.add(DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_engine_sound), "", com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_ENGINE_SOUND))
        }
        if (settingsavailibilityflag.settingsSteeringCustomizationFlag >= 0) {
            list.add(DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_steering), "", com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_STEERING))
        }
        if (settingsavailibilityflag.settingsSuspensionCustomizationFlag >= 0) {
            list.add(DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_suspension), "", com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_SUSPENSION))
        }
        if (settingsavailibilityflag.settingsTractionCustomizationFlag >= 0) {
            list.add(DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_traction_big), "", com.gm.settingsapp.viewmodels.Constants.DRIVE_MODE_TRACTION))
        }
        list.forEach {
            dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.add(it)
        }
    }

    /**
     *Response for driver mode status
     */
    override fun onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(any: Any) {
        if (any is SettingsDriverStatus) {
            getEngineSoundStatus(SettingsDriverModeStatus_t(DriverSelectedMode1Status = dataPoolDataHandler.ENGINESOUND_MAP_STATE[any.enginesound]!!))
            getSteeringStatus(SettingsDriverModeStatus_t(DriverSelectedMode2Status = dataPoolDataHandler.STEERING_MAP_STATE[any.steering]!!))
            getSuspensionStatus(SettingsDriverModeStatus_t(DriverSelectedMode3Status = dataPoolDataHandler.SUSPENSION_MAP_STATE[any.suspension]!!))
            getTractionStatus(SettingsDriverModeStatus_t(DriverSelectedMode4Status = dataPoolDataHandler.TRACTION_MAP_STATE[any.traction]!!))
        }
    }

    override fun onSETTINGS_RES_SETMODESTATUS(settingsDriverModeStatus_t: SettingsDriverModeStatus_t) {

        getEngineSoundStatus(settingsDriverModeStatus_t)
        getSteeringStatus(settingsDriverModeStatus_t)
        getSuspensionStatus(settingsDriverModeStatus_t)
        getTractionStatus(settingsDriverModeStatus_t)
    }

    fun getEngineSoundStatus(settingsdrivermodestatus: SettingsDriverModeStatus_t) {
        when (settingsdrivermodestatus.DriverSelectedMode1Status) {
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO -> {
                getEngineSoundType(R.string.settings_auto)
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO.toString())

            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH.toString())

                getEngineSoundType(R.string.settings_drivingmode_stealth)
            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY.toString())

                getEngineSoundType(R.string.settings_drivingmode_city)
            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR.toString())

                getEngineSoundType(R.string.settings_tour)
            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT.toString())

                getEngineSoundType(R.string.settings_sport)
            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK.toString())

                getEngineSoundType(R.string.settings_track)
            }
            ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF -> {
                dataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.set(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF.toString())

                getEngineSoundType(R.string.settings_off)
            }
        }
    }

    fun getSteeringStatus(settingsdrivermodestatus: SettingsDriverModeStatus_t) {
        when (settingsdrivermodestatus.DriverSelectedMode2Status) {

            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO.toString())


                getSteeringType(R.string.settings_auto)

            }
            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO.toString())

                getSteeringType(R.string.settings_traction_eco)
            }
            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY.toString())

                getSteeringType(R.string.settings_drivingmode_city)
            }
            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR.toString())

                getSteeringType(R.string.settings_tour)
            }
            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT.toString())

                getSteeringType(R.string.settings_sport)
            }
            ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK -> {
                dataPoolDataHandler.SETTINGS_STEERINGTYPE.set(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK.toString())

                getSteeringType(R.string.settings_track)
            }
        }
    }

    fun getSuspensionStatus(settingsdrivermodestatus: SettingsDriverModeStatus_t) {
        when (settingsdrivermodestatus.DriverSelectedMode3Status) {
            ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO -> {
                dataPoolDataHandler.SETTINGS_SUSPENSIONTYPE.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO.toString())

                getSuspensionType(R.string.settings_auto)
            }
            ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR -> {
                dataPoolDataHandler.SETTINGS_SUSPENSIONTYPE.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR.toString())

                getSuspensionType(R.string.settings_tour)
            }
            ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT -> {
                dataPoolDataHandler.SETTINGS_SUSPENSIONTYPE.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT.toString())

                getSuspensionType(R.string.settings_sport)
            }
            ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK -> {
                dataPoolDataHandler.SETTINGS_SUSPENSIONTYPE.set(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK.toString())

                getSuspensionType(R.string.settings_track)
            }
        }
    }

    fun getTractionStatus(settingsdrivermodestatus: SettingsDriverModeStatus_t) {
        when (settingsdrivermodestatus.DriverSelectedMode4Status) {
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO.toString())

                getTractionType(R.string.settings_auto)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR.toString())

                getTractionType(R.string.settings_tour)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT.toString())

                getTractionType(R.string.settings_sport)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK.toString())

                getTractionType(R.string.settings_track)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO.toString())

                getTractionType(R.string.settings_traction_eco)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER.toString())

                getTractionType(R.string.settings_customdrivingmode_snow_ice_weather)
            }
            ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF -> {
                dataPoolDataHandler.SETTINGS_TRACTIONTYPE.set(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF.toString())

                getTractionType(R.string.settings_traction_assist_off)
            }

        }

    }

    private fun getStringFromResource(id: Int): String {
        return GMSettingsApp.appContext.resources.getString(id)
    }

    private fun getEngineSoundType(id: Int) {
        dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(0, DriveModeModel(getStringFromResource(R.string.settings_engine_sound),
                getStringFromResource(id), DRIVE_MODE_ENGINE_SOUND))
    }

    private fun getSteeringType(id: Int) {
        dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(1, DriveModeModel(getStringFromResource(R.string.settings_steering),
                getStringFromResource(id), DRIVE_MODE_STEERING))
    }

    private fun getSuspensionType(id: Int) {
        dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(2, DriveModeModel(getStringFromResource(R.string.settings_suspension),
                getStringFromResource(id), DRIVE_MODE_SUSPENSION))
    }

    private fun getTractionType(id: Int) {
        dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(3, DriveModeModel(getStringFromResource(R.string.settings_traction_big),
                getStringFromResource(id), DRIVE_MODE_TRACTION))
    }


    override fun onSETTINGS_RES_EASYEXITDRIVERSEATSETTING(settingseasyexitdriverseat: SettingsEasyExitDriverSeat_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EASYEXITOPTIONSSETTING(settingseasyexitoptions: SettingsEasyExitOptions_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN1SETTING(settingseasyexitsteeringcolumn1: SettingsEasyExitSteeringColumn1_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN2SETTING(settingseasyexitsteeringcolumn2: SettingsEasyExitSteeringColumn2_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMNSETTING(settingseasyexitsteeringcolumn: SettingsEasyExitSteeringColumn_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ENGINERUNACTIVE(enginerunactivesetting: EngineRunActiveSetting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_EXITLIGHTINGCUSTOMIZATIONSETTING(settingsexitlighting: SettingsExitLighting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING(setttingforwardcollisionalertcustomization: SetttingForwardCollisionAlertCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsfrontpedestriandetectioncustomization: SettingsFrontPedestrianDetectionCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_GONOTIFIERCUSTOMIZATIONSETTINGS(settingsgonotifiercustomization: SettingsGoNotifierCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_INTERSECTIONSTOPALERTSETTINGS(settingscollisiondetectionintersectionstopalert: SettingsCollisionDetectionIntersectionStopAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LANECHANGEALERTSETTING(settingslanechangealert: SettingsLaneChangeAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING(settingsleftrighthandtraffic: SettingsLeftRightHandTraffic_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING(settingsleftrighthandtrafficwithgps: SettingsLeftRightHandTrafficWithGPS_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LOCATIONSERVICES(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PARKASSISTSETTING(settingsparkassist: SettingsParkAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PARKASSISTWITHTOWBARSETTING(settingsparkassistwithtowbar: SettingsParkAssistWithTowbar_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING(settingspedestrianfriendlyalert: SettingsPedestrianFriendlyAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PERFMODEDISPLAYCUSTOMIZATIONSETTING(settingsperfmodedisplaycustomization: SettingsPerfModeDisplayCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PERFMODESOUNDCUSTOMIZATIONSETTING(settingschangeperfmodesoundcustomization: ArrayList<ESettingsChangePerfModeSound>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PERFMODESTEERINGCUSTOMIZATIONSETTINGS(settingssteeringcustomization: SettingsSteeringCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PERSONALIZATIONBYDRIVERSETTING(settingspersonalizationbydriver: SettingsPersonalizationbyDriver_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_RAINSENSEWIPERSSETTING(settingsrainsensewipers: SettingsRainSenseWipers_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REARCAMERAPARKASSISTSETTINGS(settingscollisiondetectionrearcameraparkassist: SettingsCollisionDetectionRearCameraParkAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REARCROSSTRAFFICALERTSETTING(settingstrearcrosstrafficalert: SettingstRearCrossTrafficAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsrearpedestriandetectioncustomization: SettingsRearPedestrianDetectionCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REARSEATREMINDERCUSTOMIZATIONSETTINGS(settingsrearseatreminder: SettingsRearSeatReminder_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REVERSETILTMIRROR1SETTING(settingsreversetiltmirror1: SettingsReverseTiltMirror1_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REVERSETILTMIRROR2SETTING(settingsreversetiltmirror2: SettingsReverseTiltMirror2_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_REVERSETILTMIRRORSETTING(settingsreversetiltmirror: SettingsReverseTiltMirror_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SEATBELTATTACHEDSTATUS(settingsseatbeltattachedstatus: SettingsSeatBeltAttachedStatus_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING(settingsseatbelttighteningcustomization: SettingsSeatBeltTighteningCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SETTINGSPERSONALDATAERASED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SIDEBLINDZONEALERTSETTING(settingssideblindzonealert: SettingsSideBlindZoneAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingssmarthighbeamassist: SettingsSmartHighBeamAssist_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTAUTOMODECUSTOMIZATIONS(settingssportautomodecustomizations: SettingsSportAutoModeCustomizations_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESPORTAWDSETTINGS(settingssportmodesportawd: SettingsSportModeSportAWD_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESPORTADAPTIVECRUISECONTROL(settingssportmodesportadaptivecruisecontrol: SettingsSportModeSportAdaptiveCruiseControl_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESPORTDISPLAYSETTINGS(settingssportmodesportdisplays: SettingsSportModeSportDisplays_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESPORTDRIVERSEAT(settingssportmodesportdriverseat: SettingsSportModeSportDriverSeat_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SPORTMODESPORTPASSENGERSEAT(settingssportmodesportpassengerseat: SettingsSportModeSportPassengerSeat_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_SPORTMODESPORTSUSPENSIONSETTINGS(settingssportmodesportsuspension: java.util.ArrayList<ESettingsSuspensionCustomization>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_SURROUNDVIEWLIGHTING(settingssurroundviewlighting: SettingsSurroundViewLighting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_SUSPENSIONCUSTOMIZATIONSETTINGS(settingssuspensioncustomization: SettingsSuspensionCustomization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_TRACTIONCONTROLSYSTEMSTATUS(settingstractioncustomization: java.util.ArrayList<ESettingsTractionCustomization>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_TRAFFICROADSIDEINFORMATIONSETTINGS(settingscollisiondetectiontrafficroadsideinformation: SettingsCollisionDetectionTrafficRoadSideInformation_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_TRUNKCONTROL(settingstrunkcontrol: SettingsTrunkControl_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLEBRAKINGALERTSSETTINGS(settingscollisiondetectionconnectedvehiclebrakingalerts: SettingsCollisionDetectionConnectedVehicleBrakingAlerts_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING(settingsvehiclelocatorlights: SettingsVehicleLocatorLights_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VALETMODESUCCESSFUL(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VALETMODEFAILED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VALETMODERECOVERYSUCCESSFUL(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VALETMODERECOVERYFAILED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLEMOVEMENTSTATE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_DRIVERWORLOADCONDITIONS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_IGNITIONSTATUS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_IGNITIONOFFSLEEPTIMEOUT(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_INIT(settingsinitialization: SettingsInitialization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOUNLOCKINGSETTING(settingsdl_setunlock: SettingsDL_SetUnlock_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_LASTDOORCLOSEDLOCKINGSETTING(settingsdl_lastdoorclosedlocking: SettingsDL_LastDoorClosedLocking_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_OPENDOORANTILOCKOUTSETTING(settingsdl_setopendoorantilockout: SettingsDL_SetOpenDoorAntiLockOut_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOLOCKINGSETTING(settingsdl_setautolock: SettingsDL_SetAutoLock_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING(settingsdl_setremoteunlockllightingfeedback: SettingsDL_SetRemoteUnlocklLightingFeedback_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTELOCKINGFEEDBACKSETTING(settingsdl_setremotelockingfeedback: SettingsDL_SetRemoteLockingFeedback_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_SELECTIVEUNLOCKINGSETTING(settingsdl_setselectiveunlocking: SettingsDL_SetSelectiveUnlocking_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_RELOCKREMOTEUNLOCKEDDOORSETTING(settingsdl_setrelockremoteunlockeddoor: SettingsDL_SetRelockRemoteUnlockedDoor_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESTART(settingsdl_setremotestart: SettingsDL_SetRemoteStart_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATS(settingsdl_setremotestartautocoolseats: SettingsDL_SetRemoteStartAutoCoolSeats_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATSSETTINGS(settingsdl_setremotestartautocoolseatssettings: SettingsDL_SetRemoteStartAutoCoolSeatsSettings_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATS(settingsdl_setremotestartautoheatseats: SettingsDL_SetRemoteStartAutoHeatSeats_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATSSETTINGS(settingsdl_setremotestartautoheatseatssettings: SettingsDL_SetRemoteStartAutoHeatSeatsSettings_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEWINDOWOPERATION(settingsdl_setremotewindowoperation: SettingsDL_SetRemoteWindowOperation_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVEUNLOCKINGSETTING(settingsdl_setpassiveunlock: SettingsDL_SetPassiveUnlock_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVELOCKINGSETTING(settingsdl_setpassivelock: SettingsDL_SetPassiveLock_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEINVEHICLEREMINDERSETTING(settingsdl_setremoteinvehiclereminder: SettingsDL_SetRemoteInVehicleReminder_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEREMOVEDFROMVEHICLEALERT(settingsdl_setremoteremovedfromvehiclealert: SettingsDL_SetRemoteRemovedFromVehicleAlert_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESLIDINGDOORSETTING(settingsdl_setremoteslidingdoor: SettingsDL_SetRemoteSlidingDoor_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(settingsclimateautodefog: SettingsClimateAutoDefog_t) {
        var defog = false
        if (settingsclimateautodefog.ValidityFlag == 1) {
            defog = true
        } else if (settingsclimateautodefog.ValidityFlag == 2) {
            defog = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, element ->
            if (element.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG) {
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_defog_big), "", true, defog, com.gm.settingsapp.viewmodels.Constants.AUTO_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_defog_content))
            }
        }

    }

    override fun onCUSTOMIZATIONECC_RES_REARDEFOGSTARTUPSETTING(settingsclimateautoreardefog: SettingsClimateAutoRearDefog_t) {
        var rearDefog = false
        if (settingsclimateautoreardefog.ValidityFlag == 1) {
            rearDefog = true
        } else if (settingsclimateautoreardefog.ValidityFlag == 2) {
            rearDefog = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, element ->
            if (element.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_REAR_DEFOG) {
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_rear_defog), "", true, rearDefog, com.gm.settingsapp.viewmodels.Constants.AUTO_REAR_DEFOG, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_rear_defog_content))
            }
        }

    }

    override fun onCUSTOMIZATIONECC_RES_ELEVATEDIDLESETTING(settingsclimateelevatedidlecustomization: SettingsClimateElevatedIdleCustomization_t) {
        var elevated = false
        if (settingsclimateelevatedidlecustomization.SettingAvailableFlag == 1) {
            elevated = true
        } else if (settingsclimateelevatedidlecustomization.SettingAvailableFlag == 2) {
            elevated = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.ELEVATED_IDLE) {
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_elevated_idle_big), "", true, elevated, com.gm.settingsapp.viewmodels.Constants.ELEVATED_IDLE, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_elevated_idle_content))
            }
        }
    }

    override fun onCUSTOMIZATIONECC_RES_IONIZERSETTING(settingsclimateionizer: SettingsClimateIonizer_t) {
        var ionizer = false
        if (settingsclimateionizer.ValidityFlag == 1) {
            ionizer = true
        } else if (settingsclimateionizer.ValidityFlag == 2) {
            ionizer = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.IONIZER)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_ionizer), "", true, ionizer, com.gm.settingsapp.viewmodels.Constants.IONIZER, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_ionizer_content))

        }


    }

    override fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGSETTING(engineassistedheatingsetting: EngineAssistedHeatingSetting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGPLUGGEDINSETTING(engineassistedheatingpluggedinsetting: EngineAssistedHeatingPluggedInSetting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOFANSETTING(settingsclimateautofanspeed: SettingsClimateAutoFanSpeed_t) {
        var fanTag: String? = null
        when (settingsclimateautofanspeed.ValidityFlag) {
            1 -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_low)
            2 -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_medium)
            3 -> fanTag = GMSettingsApp.appContext.resources.getString(R.string.ui_high)
        }
        dataPoolDataHandler.SETTINGS_AUTO_FAN_SPEED_VALUE.set(settingsclimateautofanspeed.ValidityFlag)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_fan_max_speed), fanTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AUTO_FAN_SPEED, "")
        }


    }

    override fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(settingsclimateautoairdistribution: SettingsClimateAutoAirDistribution_t) {
        var distributionTag: String? = null
        when (settingsclimateautoairdistribution.ValidityFlag) {
            1 -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_diffuse_airflow)
            3 -> distributionTag = GMSettingsApp.appContext.resources.getString(R.string.settings_direct_airflow)
        }
        dataPoolDataHandler.SETTINGS_AUTO_AIR_DISTRIBUTION_VALUE.set(settingsclimateautoairdistribution.ValidityFlag)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_air_distribution_big), distributionTag!!, false, true, com.gm.settingsapp.viewmodels.Constants.AUTO_AIR_DISTRIBUTION, "")
        }
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTR1SETTING(settingsclimateautoairdistribution1: SettingsClimateAutoAirDistribution1_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(settingsclimateairqualitysensor: SettingsClimateAirQualitySensor_t) {
        var qualityTag: String? = null
        when (settingsclimateairqualitysensor.ValidityFlag) {
            1 -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.ui_off)
            2 -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_low_sensitivity)
            3 -> qualityTag = GMSettingsApp.appContext.resources.getString(R.string.settings_high_sensitivity)
        }
        dataPoolDataHandler.SETTINGS_AIR_QUALITY_SENSOR_VALUE.set(settingsclimateairqualitysensor.ValidityFlag)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_air_quality_sensor), qualityTag!!, false, false, com.gm.settingsapp.viewmodels.Constants.AIR_QUALITY_SENSOR, "")
        }
    }

    override fun onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(settingsclimatepollutioncontrolsetting: SettingsClimatePollutionControlSetting_t) {
        var pollution = false
        if (settingsclimatepollutioncontrolsetting.ValidityFlag == 1) {
            pollution = true
        } else if (settingsclimatepollutioncontrolsetting.ValidityFlag == 2) {
            pollution = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_pollution_control), "", true, pollution, com.gm.settingsapp.viewmodels.Constants.POLLUTION_CONTROL, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_pollution_control_content))
        }

    }

    override fun onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(settingsclimateautocoolseatssettingvalue: SettingsClimateAutoCoolSeatsSettingValue_t) {
        var coolSeats = false
        if (settingsclimateautocoolseatssettingvalue.ValidityFlag == 1) {
            coolSeats = true
        } else if (settingsclimateautocoolseatssettingvalue.ValidityFlag == 2) {
            coolSeats = false
        }

        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_cooled_seats_big), "", true, coolSeats, com.gm.settingsapp.viewmodels.Constants.AUTO_COOLED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_cooled_seats_content))
        }
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(settingsclimateautoheatedseats: SettingsClimateAutoHeatedSeats_t) {
        var heatedSeats = false
        if (settingsclimateautoheatedseats.ValidityFlag == 1) {
            heatedSeats = true
        } else if (settingsclimateautoheatedseats.ValidityFlag == 2) {
            heatedSeats = false
        }
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW.forEachIndexed { index, climateModeModel ->
            if (climateModeModel.reference == com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS)
                dataPoolDataHandler.SETTINGS_SET_CLIMATE_ROW[index] = ClimateModeModel(GMSettingsApp.appContext.resources.getString(R.string.settings_auto_heated_seats_big), "", true, heatedSeats, com.gm.settingsapp.viewmodels.Constants.AUTO_HEATED_SEATS, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_auto_heated_seats_content))
        }

    }

    override fun onCUSTOMIZATIONECC_RES_REARZONESTARTUPSETTING(settingsrearclimateonstartup: SettingsRearClimateOnStartUp_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(pData: Int) {
        if (dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.size > 0)
            dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.forEachIndexed { index, element ->
                if (element.reference == com.gm.settingsapp.viewmodels.Constants.APPLE_CARPLAY) {
                    dataPoolDataHandler.SETTINGS_REQ_APPS_LIST[index] = AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_apple_carplay_short1), true, dataPoolDataHandler.DEVICEPROJECTION_APPLECARPLAYENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.APPLE_CARPLAY, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_apple_carplay_settings_content))
                }
            }
    }

    override fun onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(pData: Int) {
        if (dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.size > 0)
            dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.forEachIndexed { index, element ->
                if (element.reference == com.gm.settingsapp.viewmodels.Constants.ANDROID_AUTO) {
                    dataPoolDataHandler.SETTINGS_REQ_APPS_LIST[index] = AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.ui_android_auto), true, dataPoolDataHandler.DEVICEPROJECTION_GOOGLEAUTOLINKENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.ANDROID_AUTO, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_android_auto_settings_content))
                }
            }

        dataPoolDataHandler.SETTINGS_REQ_APPS_LIST.forEachIndexed { index, element ->
            if (element.reference == com.gm.settingsapp.viewmodels.Constants.MIRROR_LINK) {
                dataPoolDataHandler.SETTINGS_REQ_APPS_LIST[index] = AppsModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_mirrorlink), true, dataPoolDataHandler.DEVICEPROJECTION_GOOGLEAUTOLINKENABLE.get() == 1, com.gm.settingsapp.viewmodels.Constants.MIRROR_LINK, GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.cm_enable_disable_mirror_link_settings_content))
            }
        }
    }

    override fun onCUSTOMIZATIONECC_RES_SUPPORTEDSETTINGS(customizationeccavailibilityflag: CustomizationECCAvailibilityFlag_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_SUPPORTEDSETTINGS(settingsdl_availibilityflag: SettingsDL_AvailibilityFlag_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsdl_availibilityflag: GlobalSettingsDL_AvailibilityFlag_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCUSTOMIZATIONECC_RES_GLOBALSUPPORTEDSETTINGS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERACTIVE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINSTOREDSTATUS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERREPORTCARDDATA(settingsteendriverreportcarddata: SettingsTeenDriverReportCardData_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING(settingsteendriverspeedlimitcustomizationsetting: SettingsTeenDriverSpeedLimitCustomizationSetting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING(settingsteendriveroverspeedwarningcustomizationsetting: SettingsTeenDriverOverspeedWarningCustomizationSetting_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINSUCESSFUL(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINFAILED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYSPINCLEARED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYCONFIGURATION(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERPRESENT(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYTRADITIONALKEYCONFIGURATIONSTATUS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERCONFIGURATIONSTATUS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_CHECK_KEY(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_INIT(teendriverinitialization: TeenDriverInitialization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONSUCCESSFUL(uint32: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONFAILED(uint32: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_AMPDSPMODE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_AUDIOCUEVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_BALANCE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_BASS(max_volume_length: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_CHIMEVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_FADE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_SURROUND(max_volume_length: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_MAXIMUMSTARTUPVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_MIDRANGE(max_volume_length: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_MUTE(muteres: MuteRes_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERMAXIMUMVOLUMELIMIT(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERMINIMUMVOLUMELIMIT(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERVOLUMELIMITINGENABLED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_TREBLE(max_volume_length: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_SPEEDVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTED(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTIONCOMPLETE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_VOLUME(volumegroupextent: VolumeGroupExtent_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_NONE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_MAIN() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_EMERGENCY_PHONE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_RING_TONE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_ALERT() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_CHIME() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_ANDROIDAUTO() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_ALERTVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_MAINVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_PHONEVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_PROMPTVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_RINGTONEVOLUME(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_VOLUMEGROUPEXTENTS(spvolumegroupextentstream: SPVolumeGroupExtentStream_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_CARPLAY() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_PHONE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_PROMPT() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onLGSP_VG_TRAFFIC() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLGSP_VG_AUDIO_CUE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onLGSP_VG_TEENDRIVER() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_MODEINIT(soundparametersmodeinitialization: SoundParametersModeInitialization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSOUNDPARAMS_RES_VOLUMEINIT(soundparametersvolumeinitialization: SoundParametersVolumeInitialization_t) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_PROPERUSEWARNING(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_LOCATIONSERVICESNOTIFICATION(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VALETMODESTORAGEUNLOCK(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLEGEARSTATE(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_VALETMODESTATUS(pData: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_RES_OUTTEMPERATURE_VAL(max_oat_val_len: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_TIME_OR_DATE(timeOrDate: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }


    override fun onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(settingsautotimeupdatesetting: SettingsAutoTimeUpdateSetting_t) {
        if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 3) {
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(2, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_time_date), "", true,
                    dataPoolDataHandler.SETTINGS_AUTOMATIC_TIMEDATE_TOGGLESTATE.get()!!, 2, GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_time_date_content)))
        }
    }

    override fun onSETTINGS_RES_TIMEDISPLAYFORMAT(timDisplayType: eSettingsTimeDisplayFormat) {
        if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 3) {
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(0, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_use_24_hour_format), "", true, dataPoolDataHandler.SETTINGS_USE_24HOUR_FORMAT_TOGGLESTATE.get()!!, 0, GMSettingsApp.appContext.resources.getString(R.string.settings_use_24_hr_format_content)))
        }
    }

    override fun onSETTINGS_RES_TIMEINFO(timeinfo: TimeInfo_t) {
        /*   if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 6) {
               Log.i("calling ", "onSETTINGS_RES_TIMEINFO")
               dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(1, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_set_time_big), addingZeroToHour(dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!) + ":" + Utility.getMinuteWithLeadingZero(dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!) + " " +
                       if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE) {
                           if (dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get() == eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
                               com.gm.settingsservice.utils.Constants.AM
                           else
                               com.gm.settingsservice.utils.Constants.PM
                       } else "", false, false))
           } else {
               dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(1, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_set_time_big), addingZeroToHour(dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!) + ":" + Utility.getMinuteWithLeadingZero(dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!) + " " +
                       if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE) {
                           if (dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get() == eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
                               com.gm.settingsservice.utils.Constants.AM
                           else
                               com.gm.settingsservice.utils.Constants.PM
                       } else "", false, false))
           }*/

    }


    override fun onSETTINGS_RES_DATEINFO(dateinfo: DateInfo_t) {
        /*if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 6) {
            Log.i("calling ", "onSETTINGS_RES_DATEINFO")
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(2, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_set_date_big), dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.get().toString() + "/" + com.gm.settingsapp.utils.Utility.monthPlusOne(dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.get()!!).toString() + "/" + dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.get().toString(), false, false))
        } else {
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(2, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_set_date_big), dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.get().toString() + "/" + com.gm.settingsapp.utils.Utility.monthPlusOne(dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.get()!!).toString().toString() + "/" + dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.get().toString(), false, false))
        }*/
    }


    // for sound module menu screen data
    override fun onSETTINGS_RES_SOUND_MENU() {

        if (dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA.size == 0) {
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA.add(0, GMSoundMenu(GMSettingsApp.appContext.resources.getString(R.string.settings_maximum_startup_volume), false, false, 0, ""))
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA.add(1, GMSoundMenu(GMSettingsApp.appContext.resources.getString(R.string.settings_audio_cues_shutdown), true, true, 1, GMSettingsApp.appContext.resources.getString(R.string.settings_audio_cues_shutdown_content)))
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA.add(2, GMSoundMenu(GMSettingsApp.appContext.resources.getString(R.string.settings_set_audio_cue_shutdown_volume), false, false, 2, ""))
            dataPoolDataHandler.SETTINGS_REQ_SOUNDDATA.add(3, GMSoundMenu(GMSettingsApp.appContext.resources.getString(R.string.settings_audible_touch_feedback_large), true, false, 3, GMSettingsApp.appContext.resources.getString(R.string.settings_audible_touch_feedback_medium_content)))
        }

    }


    override fun onSETTINGS_RES_TIMEZONE() {
        if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 3) {
            dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.set(GMSettingsApp.appContext.resources.getString(R.string.settings_auto))
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(1, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_select_time_zone_long), dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.get() + "", false, false, 1, ""))
        } else {
            dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(1, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_select_time_zone_long), dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.get() + "", false, false, 1, ""))
        }


    }

    override fun onSETTINGS_RES_AUTOMATICTIMEZONE() {
        /* if (dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.size < 6) {
             Log.i("calling ", "onSETTINGS_RES_AUTOMATICTIMEZONE")
    */
        //  dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.add(1, TimeDateModel(GMSettingsApp.app
        //  Context.resources.getString(R.string.settings_automatic_time_zone), GMSettingsApp.appContext.resources.getString(R.string.settings_use_network_provided_time), false, false))
        /*    } else {
                dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(3, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_automatic_time_zone), GMSettingsApp.appContext.resources.getString(R.string.settings_use_network_provided_time), true, false))
            }*/
    }

    override fun onSETTINGS_RES_GETMAXSTARTUPVOLUME(pData: Int) {

        if (dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.get() == pData) {
            dataPoolDataHandler.SETTINGS_SOUND_MAX_VOLUME.set(false)
        } else {
            dataPoolDataHandler.SETTINGS_SOUND_MAX_VOLUME.set(true)
        }

        if (pData <= 0) {
            dataPoolDataHandler.SETTINGS_SOUND_MIN_VOLUME.set(false)
        } else {
            dataPoolDataHandler.SETTINGS_SOUND_MIN_VOLUME.set(true)
        }
    }

    //response for display menu
    override fun onSETTINGS_RES_DISPLAY(isProximity: Boolean) {
        dataPoolDataHandler.settingsDisplayOff.set(DISPLAY_TURN_OFF)
        //add the display menu items if list not exists
        if (dataPoolDataHandler.IS_CADILLAC.get() == true) {

            if (dataPoolDataHandler.SETTINGS_DISPLAY_MENU.size == 0) {
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_head_up), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP))
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_instrument), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_INSTRUMENT))
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_radio), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_RADIO_DISPLAY))
            }

            if (dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.size == 0) {
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_head_up), GMSettingsApp.appContext.resources.getString(R.string.ui_on), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_HEAD_UP))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_adjustment), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_ADJUSTMENT))
                dataPoolDataHandler.SETTINGS_DISPLAY_CADILLAC_SECOND_MENU.add(DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.cadillac_display_head_up_control), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CONTROLS))
            }


        } else {
            if (dataPoolDataHandler.SETTINGS_DISPLAY_MENU.size == 0) {
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(0, DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.settings_mode), GMSettingsApp.appContext.resources.getString(R.string.settings_auto), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_MODE))
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(1, DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.settings_calibrate_touchscreen), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_CALIBRATE))
                dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(2, DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.settings_turn_display_off), "", false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_TURN_OFF))
                if (isProximity) {
                    dataPoolDataHandler.SETTINGS_DISPLAY_MENU.add(1, DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.settings_proximity_sensing), "", true, true, com.gm.settingsapp.viewmodels.Constants.DISPLAY_PROXIMITY))
                }
                dataPoolDataHandler.SETTINGS_DISPLAYMODETYPE.set(eSettingsdisplayMode.SETTINGS_DISPLAY_MODE_AUTO)
            }
        }
    }

    //response for set display mode
    override fun onSETTINGS_RES_DISPLAYMODETYPE(eSettingsdisplayMode: eSettingsdisplayMode) {
        //set display mode to the list of display menu
        dataPoolDataHandler.SETTINGS_DISPLAY_MENU[0] = DisplayModel(GMSettingsApp.appContext.resources.getString(R.string.settings_mode), dataPoolDataHandler.SETTINGS_DISPLAYMODETYPE.get().toString(), false, false, com.gm.settingsapp.viewmodels.Constants.DISPLAY_MODE)
    }


    /**
     * response for supported languages
     * update languages list and count
     * @param SettingsSupportedLanguages_t passes count,arraylist of language type
     */
    override fun onSETTINGS_RES_SUPPORTEDLANGUAGES(settingssupportedlanguages: SettingsSupportedLanguages_t) {
        if (SettingsService.isSDKAvailable()) {
            val locale = GMSettingsApp.appContext.resources.configuration.locale
            if (locale.toString().equals("en") || locale.toString().equals("uk")) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(dataPoolDataHandler.languageMapSdk.get("en_US"))
            } else if (locale.toString().equals("ar")) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(dataPoolDataHandler.languageMapSdk.get("ar_SA"))
            } else {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(dataPoolDataHandler.languageMapSdk.get(locale.toString()))
            }
            val region = CalibrationSettings.getInstance(GMSettingsApp.appContext).region
            val dynamic = serviceUtility.isSupportedByVRTTS(region, utility.getLocale())
            if (dynamic) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_language_content_dynamic)))
            } else {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), ""))
            }
        } else {
            var pos = -1
            GMSettingsApp.appContext.resources.getStringArray(R.array.locale_values).forEach {
                pos++
                dataPoolDataHandler.languagesSimulation.put(pos, it.toString())
            }
            //get language type as English,Français,Español
            val languageType = GMSettingsApp.sharedPreferences.getString(GMSettingsApp.appContext.getString(com.gm.settingsservice.R.string.shared_pref_lang_state), dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.get().toString())
            if (languageType.equals("null")) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(ESettingsLanguageType.SETTINGS_LANGUAGE_SELECTION_English.toString())
            } else {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(languageType)
            }
            dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_language_content_dynamic)))
        }
    }

    /**
     * response for set language
     * @param ESettingsLanguageType passes language type
     */
    override fun onSETTINGS_RES_LANGUAGE(any: Any, selectedLocale: Locale) {
        if (SettingsService.isSDKAvailable()) {
            val lang = dataPoolDataHandler.languageMapSdk.get(selectedLocale.toString())
            dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set((lang))
            utility.setNewLocale(GMSettingsApp.appContext, selectedLocale.toString())
            val region = CalibrationSettings.getInstance(GMSettingsApp.appContext).region
            val dynamic = serviceUtility.isSupportedByVRTTS(region, utility.getLocale())
            if (dynamic) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_language_content_dynamic)))
            } else {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), ""))
            }
        } else {

            GMSettingsApp.sharedPreferences.edit().putString(SubUtility.getStringById(R.string.shared_pref_lang_state), any.toString()).apply()
            val position = dataPoolDataHandler.languages.get(any.toString())
            dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(any.toString())
            var language = dataPoolDataHandler.languagesSimulation.get(position)
            utility.setNewLocale(GMSettingsApp.appContext, language.toString())
            dataPoolDataHandler.SETTINGS_LANGUAGE_TEXT.set(String.format(GMSettingsApp.appContext.resources.getString(R.string.settings_language_content), GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_language_content_dynamic)))
        }
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_language_big))
    }

    override fun onFAVORITE_RES_AUDIOMAXFAVCOUNT(any: Any) {
        dataPoolDataHandler.SETTINGS_RECYCLERVIEW_SCROLL_STATE.set(GMSettingsApp.appContext.resources.getIntArray(R.array.favorite_set_audio_number_favorites).indexOf(any as Int))
    }

    //response for display calibration touchscreen
    override fun onSETTINGS_RES_CALIBRATION() {
    }


    override fun onSETTINGS_RES_CONTAINER_MENU_LIST() {
        dataPoolDataHandler.SETTINGS_FAVORITES_DATA.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.favorite_list).forEach {
            dataPoolDataHandler.SETTINGS_FAVORITES_DATA.add(it)
        }
    }

    fun getSportModeListItems(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.clear()
        if (settingsavailibilityflag.settingsSportModeSportSteeringFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportSteeringFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(0, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_steering_big), true, enableStatus, 2001, "Sport Steering stiffens the steering feel while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportDisplaysFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportDisplaysFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(1, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_display_big), true, enableStatus, 2002, "Sport Display adjusts the appearance of the instrument cluster to a sport themed display while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportSuspensionFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportSuspensionFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(2, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_suspension_big), true, enableStatus, 2003, "Sport Suspension stiffens the suspension feel while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportAWDFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportAWDFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(3, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_awd_big), true, enableStatus, 2004, "Sport Traction optimizes All wheeld drive calibrations to improve vehicle performance while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportDriverSeatFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportDriverSeatFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(4, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_driver_seat_big), true, enableStatus, 2005, "Sport Driver Seat adjusts the driver seat bolsters for increased lateral support while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportPassengerSeatFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportPassengerSeatFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(5, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_passenger_seat_big), true, enableStatus, 2006, "Sport Passenger Seat adjusts the passenger seat bolsters for increased lateral support while in Sport Mode."))
        }
        if (settingsavailibilityflag.settingsSportModeSportAdaptiveCruiseControlFlag >= 0) {
            var enableStatus = false
            if (settingsavailibilityflag.settingsSportModeSportAdaptiveCruiseControlFlag == 2) {
                enableStatus = true
            }
            dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.add(6, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_adaptive_cruise_control_big), true, enableStatus, 2007, "Sport Adaptive Cruise Control enables enhanced dynamic behavior of adaptive cruise mode while in Sport Mode"))
        }
    }

    override fun onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[0].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(0, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_steering_big), true, any as Int == 2, 2001, "Sport Steering stiffens the steering feel while in Sport Mode."))

    }

    override fun onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[1].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(1, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_display_big), true, any as Int == 2, 2002, "Sport Display adjusts the appearance of the instrument cluster to a sport themed display while in Sport Mode."))


    }

    override fun onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[2].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(2, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_suspension_big), true, any as Int == 2, 2003, "Sport Suspension stiffens the suspension feel while in Sport Mode."))

    }

    override fun onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[3].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(3, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_awd_big), true, any as Int == 2, 2004, "Sport Traction optimizes All wheeld drive calibrations to improve vehicle performance while in Sport Mode."))


    }

    override fun onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[4].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(4, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_driver_seat_big), true, any as Int == 2, 2005, "Sport Driver Seat adjusts the driver seat bolsters for increased lateral support while in Sport Mode."))


    }

    override fun onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[5].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(5, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_passenger_seat_big), true, any as Int == 2, 2006, "Sport Passenger Seat adjusts the passenger seat bolsters for increased lateral support while in Sport Mode."))


    }

    override fun onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION[6].isToggleState = any as Int == 2
        dataPoolDataHandler.SETTINGS_SPORT_MODE_CUSTOMAIZATION.set(6, SportModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_sport_adaptive_cruise_control_big), true, any as Int == 2, 2007, "Sport Adaptive Cruise Control enables enhanced dynamic behavior of adaptive cruise mode while in Sport Mode"))

    }
}
