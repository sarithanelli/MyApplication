package com.gm.settingsapp.viewmodels

import com.gm.settingsapp.R

/**
 *  Constant values for Settings app
 *
 *
 */
object Constants {

    private const val basePackage = "com.gm.settingsapp"
    var SUBMIT_BUTTON_RECREATE: Boolean? = false
    var SUBMIT_BUTTON_STATE: Boolean? = false
    var SUBMIT_BUTTON: Boolean? = false
    const val SETTINGS_CALIBRATION = "eSettingCalibration"
    const val SETTINGS_CALIBRATION_POPUP = "eScreenDisplay"

    const val activityAction = "$basePackage.action"
    const val fragmentAction = "$basePackage.ui.activities.fragments"

    const val resource_raw_events_json = R.raw.events
    const val json_key_event_activity_actionmap = "events_activity_action_map"
    const val json_key_event_activity_actionmap_custom = "events_activity_action_map_custom"
    const val json_key_event_fragment_actionmap = "events_fragment_action_map"
    const val json_key_voice = "voice"
    const val json_key_touch = "touch"
    const val json_key_keyboard = "keyboard"
    const val json_key_remote = "remote"
    val DRIVEMODE_ENGINE = "eDriveModeEngine"
    val DRIVEMODE_STEERING = "eDriveModeSteering"
    val DRIVEMODE_SUSPENSION = "eDriveModeSuspension"
    val DRIVEMODE_TRACTION = "eDriveModeTraction"
    // const val resource_raw_events_json=R.raw.events

    const val event_type_navigate = "navigate"
    const val event_type_homescreen = "evG_HomeScreen"
    const val event_type_back = "evG_Back"
    const val event_type_close = "evG_Close"
    const val event_type_process = "process"
    const val event_type_finish = "finish"
    const val event_type_fragment = "fragment"

    /**
     * values for handler to update time/date
     */
    const val SET_TIME_HOUR_INCREMENT = 1
    const val SET_TIME_HOUR_DECREMENT = 2
    const val SET_TIME_MINUTE_INCREMENT = 3
    const val SET_TIME_MINUTE_DECREMENT = 4
    const val SET_TIME_YEAR_INCREMENT = 5
    const val SET_TIME_YEAR_DECREMENT = 6
    const val SET_TIME_MONTH_INCREMENT = 7
    const val SET_TIME_MONTH_DECREMENT = 8
    const val SET_TIME_DAY_INCREMENT = 9
    const val SET_TIME_DAY_DECREMENT = 10
    /**
     * below ids used for calibration touch screen
     */
    const val mode = 0;
    const val proximity = 1;
    const val calibration = 2;
    const val displayoff = 3;
    const val CALIBRATE_TOP_LEFT = 1
    const val CALIBRATE_TOP_RIFHT = 2
    const val CALIBRATE_BOTTOM_RIGHT = 3
    const val CALIBRATE_BOTTOM_LEFT = 4
    const val CENTER = 5;
    const val DISPLAY_MODE = 3001
    const val DISPLAY_PROXIMITY = 3002
    const val DISPLAY_CALIBRATE = 3003
    const val DISPLAY_TURN_OFF = 3004
    const val DISPLAY_HEAD_UP = 3005
    const val DISPLAY_INSTRUMENT = 3006
    const val DISPLAY_RADIO_DISPLAY = 3007
    const val DISPLAY_ADJUSTMENT = 3008
    const val DISPLAY_CONTROLS = 3009
    const val DISPLAY_LAYOUT = 3010
    const val DISPLAY_LEFT_VIEW = 3011
    const val DISPLAY_RIGHT_VIEW = 3012
    const val DISPLAY_SPEED = 3013
    const val DISPLAY_SCREEN_SAVER = 3014
    const val DISPLAY_REAR_CLIMATE = 3015
    const val DISPLAY_AIR_QUALITY = 3016

    const val DISPLAYMODE = "eMode"
    const val DISPLAYPROXIMITY = "eProximity"
    const val DISPLAYCALIBRATE = "eCalibrate"
    const val DISPLAYHEADUP = "eDisplayCadillac"
    const val DISPLAYINSTRUMENT = "eDisplayCadillac"
    const val DISPLAYRADIO_DISPLAY = "eDisplayCadillac"
    const val DISPLAYOFF = "eDisplayOff"

    const val mDecrementStatusEnabled = true
    const val mIncrementStatusEnabled = true

    const val EVENT_LONG_CLICK_PRESSED_INCREMENT = 1
    const val EVENT_LONG_CLICK_PRESSED_DECREMENT = 2
    const val DELAY_INC_DEC_TIME = 450
    /**
     * Fragment replacement in  SettingsFragmentContainerActivity
     */
    const val SYSTEM_FIRST_LEVEL_CONTAINER_TAG = "eScreenContainer"
    const val FIRST_LEVEL_SYSTEM_TAB_FAVORITES = 7

    /**
     * Climate menu list tags
     */

    val AUTO_FAN_SPEED = 1001
    val AIR_QUALITY_SENSOR = 1002
    val AUTO_AIR_DISTRIBUTION = 1003
    val POLLUTION_CONTROL = 1004
    val AUTO_COOLED_SEATS = 1005
    val AUTO_HEATED_SEATS = 1006
    val AUTO_DEFOG = 1007
    val AUTO_REAR_DEFOG = 1008
    val ELEVATED_IDLE = 1009
    val IONIZER = 1010
    val REAR_ZONE = 1011
    val DRIVE_MODE_ENGINE_SOUND = 101
    val DRIVE_MODE_STEERING = 102
    val DRIVE_MODE_SUSPENSION = 103
    val DRIVE_MODE_TRACTION = 104


    val ANDROID_AUTO = 2001
    val APPLE_CARPLAY = 2002
    val AUDIO = 2003
    val CLIMATE = 2004
    val ENERGY = 2005
    val MIRROR_LINK = 2006
    val NAVIGATION = 2007
    val PHONE = 2008
    val TRAILERING = 2009
    val VIDEO = 2010
    val CAMERA = 2011


    val AUTO_FAN_SPEED_TAG = "eAutoFanSpeed"
    val AIR_QUALITY_SENSOR_TAG = "eAirQuality"
    val AUTO_AIR_DISTRIBUTION_TAG = "eAutoAirDistribution"
    val POLLUTION_CONTROL_TAG = "ePollutionControl"
    val AUTO_COOLED_SEATS_TAG = "eAutoCooledSeats"
    val AUTO_HEATED_SEATS_TAG = "eAutoHeatedSeats"
    val AUTO_DEFOG_TAG = "eAutoDefog"
    val AUTO_REAR_DEFOG_TAG = ""
    val ELEVATED_IDLE_TAG = ""
    val IONIZER_TAG = "eIonizer"
    val REAR_ZONE_TAG = ""
    val CLIMATE_ON_OF = "eClimateOnOf"
    val APPS_ON_OF = "eAppsOnOff"

    val ANDROID_AUTO_TAG = "eAndroidAuto"
    val APPLE_CARPLAY_TAG = "eAppleCarPLay"
    val AUDIO_TAG = "eAudio"
    val CLIMATE_TAG = "eClimate"
    val PRIVACY_TAG = "ePrivacy"
    val DRIVEMODE_TAG = "eDriveMode"
    val SPORTMODE_TAG = "eSportModeCustomization"
    val AUTOMODE_TAG = "eAutoModeCustomization"

    val LOW_VALUE = 1
    val MEDIUM_VALUE = 2
    val HEIGH_VALUE = 3

    val OFF_VALUE = 1
    val LOW_SENSITIVITY_VALUE = 2
    val HEIGH_SENSITIVITY_VALUE = 3

    val DIFFUES_AIRFLOW_VALUE = 1
    val DIRECT_AIRFLOW_VALUE = 2
    val NORMAL_AIRFLOW_VALUE = 3
    val OSCILLATING_AIRFLOW_VALUE = 4


    /**
     * Vehicle menu list tags
     */

    var DRIVING_MODE = "Driving Mode"


    /**
     * for engine sound mapping values
     */
    const val ENGINE_SOUND_AUTO = 7
    const val ENGINE_SOUND_STEALTH = 4
    const val ENGINE_SOUND_CITY = 5
    const val ENGINE_SOUND_TOUR = 1
    const val ENGINE_SOUND_SPORT = 2
    const val ENGINE_SOUND_TRACK = 3
    const val ENGINE_SOUND_OFF = 6

    /**
     * Enable constant
     */
    val ENABLE_SETTING = 1


    /*bottom bar tags*/

    const val BOTTOM_BAR_SHOW = 3
    const val BOTTOM_BAR_HIDE = 1
    const val BOTTOM_BAR_RE_OPEN = 2

    const val RADIOBUTTON_ON = "On"
    const val SPORT_TAG = "eSportModeCustomizationOnOff"
    const val SPORT_STEERING = "eSportModeCustomizationToggleOnOffSteering"
    const val SPORT_DISPLAY = "eSportModeCustomizationToggleOnOffDisplay"
    const val SPORT_SUSPENSION = "eSportModeCustomizationToggleOnOffSuspension"
    const val SPORT_TRACTION = "eSportModeCustomizationToggleOnOffTraction"
    const val SPORT_DRIVER_SEAT = "eSportModeCustomizationToggleOnOffDriverSeat"
    const val SPORT_PASSANGER_SEAT = "eSportModeCustomizationToggleOnOffPassengerSeat"
    const val SPORT_ADAPTIVE = "eSportModeCustomizationToggleOnOffAdaptiveCruiseControl"


    val MYMODE_TAG = "eMyMode"
    val VMODE_TAG = "eVMode"
    val MYMODE_ENGINE_TAG = "eMMEngine"
    val MYMODE_STEERING_TAG = "eMMSteering"
    val MYMODE_SUSPENSION_TAG = "eMMSuspension"
    val MYMODE_BRAKE_TAG = "eMMBrake"


    val VMODE_ENGINE_TAG = "eVModeEngine"
    val VMODE_STEERING_TAG = "eVMSteering"
    val VMODE_SUSPENSION_TAG = "eVMSuspension"
    val VMODE_BRAKE_TAG = "eVMBrake"
    val VMODE_POWER_TAG = "eVMPower"

    val COMFORT_AND_CONVENIENCE_TAG = "eComfort"
    val AUTOMATIC_RUNNING_BOARDS = "eAutoRunningBoards"
    val AUTOMATIC_ENTRY = "eAutomaticEntry"
    val REVERSE_MIRROR = "eReverseTiltMirror"
    val REMOTE_MIRROR_FOLDING = "eRemoteMirrorFolding"
    val AUTO_WIPE_REVERSE_GEAR = "eAutoWipeReverseGear"

    val POWER_LIFTGATE = "ePowerLiftGate"
    val HANDFREELIFTGATE = "eHandFreeLiftGate"
    val RAINSENSEWIPER = "eRainSenseWiper"
    val REVERSETILTMIRROR = "eAutomaticEntry"
    val CHIME_VOLUME = "eChimeVolume"
    val RIDE_HEIGHT_TAG = "evRideHeight"
    val RIDE_HEIGHT_ON_OFF_TAG = "evRideHeightOnOff"


    const val MY_MODE_ENGINE = 10001
    const val MY_MODE_STEERING = 10002
    const val MY_MODE_SUSPENSION = 10003
    const val MY_MODE_BRAKE = 10004

    const val V_MODE_ENGINE = 10005
    const val V_MODE_STEERING = 10006
    const val V_MODE_SUSPENSION = 10007
    const val V_MODE_BRAKE = 10008
    const val V_MODE_POWER = 10009

    const val C_AUTO_RUNNING_BOARDS = 10101
    const val C_AUTO_ENTRY = 10102
    const val C_AUTO_MEMORY_RECALL = 10103
    const val C_EASY_EXIT_SEAT = 10104
    const val C_EASY_EXIT_STEERING_COLUMN = 10105
    const val C_EASY_EXIT_OPTIONS = 10106
    const val C_CHIME_VOLUME = 10107
    const val C_POWER_LIFTGATE = 10108
    const val C_HANDSFREE_LIFTGATE = 10109
    const val C_REVERSE_TILT_MIRROR = 10110
    const val C_REMOTE_MIRROR_FOLDING = 10111
    const val C_PERSONALIZATION_BY_DRIVER = 10112
    const val C_RAIN_SENSE_WIPERS = 10113
    const val C_AUTO_WIPE_IN_REVERSE_GEAR = 10114
    const val EXTENDED_HILL_START_ASSIST = 10115
    const val EXTENDED_HILL_START_ASSIST_TAG = "eHillStart"


    val PEDESTRIAN_FRIENDLY_ALERT = 4001
    val PEDESTRIAN_FRIENDLY_ALERT_SOUND = 4002
    val ALERT_TYPE = 4003
    val FORWORD_COLLISION_SYSTEM = 4004
    val FRONT_PEDESTRIAN_DETECTION = 4005
    val INTERSECTIONS_TOP_ALERT = 4006
    val CONNECTED_VEHICLE_BRAKING_ALERT = 4007
    val TRAFFIC_AND_ROADSIDE_INFORMATION = 4008
    val DROWSY_DRIVER_ALETRT = 4009
    val ADAPTIVE_CRUISEGO_NOTIFIER = 4010
    val SIDE_BELTZONE_ALERT = 4011
    val LANE_CHANGE_ALERT = 4012
    val SEATBEL_TTIEGHTENING = 4013
    val PARK_ASSIST = 4014
    val PARK_ASSIST_TOWBAR = 4015
    val REAR_CAMERA_PARK_ASSIST_SYMBOLS = 4016
    val REAR_CROSS_TRAFFIC_ALERT = 4017
    val REAR_PEDESTRAIN_DETECTION = 4018

    val PEDESTRIAN_FRIENDLY_ALERT_TAG = "evGCollisionOnOff"
    val COLLISION_SYSTEMS_TAG = "evGCollision"
    val PEDESTRIAN_FRIENDLY_ALERT_SOUND_TAG = "evGParkAssist"
    val REAR_PEDESTRIAN_DETECTION_TAG = "evGPedestrian"
    const val C_EXTENDED_HILL_START_ASSIST = 10115

    const val C_AUTO_EGRESS_ASSIST = 10102

    const val V_MODE_Z_MODE = 10010
    const val MY_MODE = 10011
    const val VISUALIZATION = 10012

    // val EXTENDED_HILL_START_ASSIST="eExtendedHillStartAssist"
    val DRIVE_MODE_CUSTOMIZATION_TAG = "eDriveModeCustomization"


    const val LOCATION_BASED_AUTO_LIFT = 10016
    const val AUTO_ENTRY_EGRESS = 10017

}