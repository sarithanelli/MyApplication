package com.gm.settingsservice.utils


/**
 *  Constant values for Settings app
 * *
 */
object Constants {
    /**
     * Maximum value for 12 hours format
     */
    val MAX_HOUR_VALUE_IN_12_HOUR_FORMAT = 12
    /**
     * Maximum value for 24 hours format
     */
    val MAX_HOUR_VALUE_IN_24_HOUR_FORMAT = 23
    /**
     * Minimum value for 12 hours format
     */
    val MIN_HOUR_VALUE_IN_12_HOUR_FORMAT = 1
    /**
     * Minimum value for 12 hours format
     */
    val MIN_HOUR_VALUE_IN_24_HOUR_FORMAT = 0
    /**
     * Maximum value for minute
     */
    val MAX_MINUTE_VALUE = 59
    /**
     * Minimum value for minute
     */
    val MIN_MINUTE_VALUE = 0

    const val SHARED_PREF_LHD_KEY = "lhd"
    const val SHARED_PREF_RHD_KEY = "rhd"
    const val SHARED_PREF_RTL_KEY = "rtl"
    const val SHARED_PREF_SKEW_KEY = "skew"
    /**
     * values for calibration touch screen target points
     */
    const val CALIBRATE_TOP_LEFT = 1
    const val CALIBRATE_TOP_RIFHT = 2
    const val CALIBRATE_BOTTOM_RIGHT = 3
    const val CALIBRATE_BOTTOM_LEFT = 4
    const val CENTER = 5;
    const val CALIBRATE_SUCCESS_POPUP = 6;
    const val shared_prefs_key = "settings_prefs"
    /**
     * end year for calender
     */
    val DEFAULT_END_YEAR = 2100
    /**
     * default start year for calender
     */
    val DEFAULT_START_YEAR = 2013
    /**
     * Time formats depending upon language locale
     */
    const val YY_MM_DD = 0
    const val YY_DD_MM = 1
    const val MM_DD_YY = 2
    const val MM_YY_DD = 3
    const val DD_MM_YY = 4
    const val DD_YY_MM = 5
    /**
     * TO differentiate set time and set date screen
     */
    const val SET_TIME = 1
    const val SET_DATE = 2
    /**
     * To display minute value with leading zero
     */
    const val MINUTE_LEADING_ZERO = 0
    const val MINUTE_LIMIT_LEADING_ZERO = 10
    const val HOUR_LIMIT_LEADING_ZERO = 10

    /**
     * Hour values for 24 hour and 12 hour format
     */
    const val HOURS_24 = "24"
    const val HOURS_12 = "12"


    const val AUTOMATIC_TIME_ZONE_SCREEN = 3
    /**
     * AM, PM values for differentiation
     */
    const val AM = "AM"
    const val PM = "PM"
    /**
     * Screen Differentiation when Time and Date screen events occured
     */
    const val SET_TIME_SCREEN = 1
    const val SET_DATE_SCREEN = 2
    const val USES_24HOUR_FORMAT_SCREEN = 5
    const val AUTOMATIC_TIME_AND_DATE_SCREEN = 0
    /**
     * TWELVE Value is displaying when hour value is zero
     */
    const val TWELVE = 12
    /**
     * checking skew availability
     */
    var isFromConfigSkew = false
    /**
     * default start/end day for calender
     */
    val DEFAULT_START_END_DATE = 31

    const val INCREMENT_DECREMENT_TONE_SETTINGS_VALUE = 1


    /**
     * below ids used for languages
     */
    val SETTING_LANGUAGE_ENGLISH = 0
    val SETTING_LANGUAGE_FRANCAIS = 2
    val SETTING_LANGUAGE_ESPANOL = 1

    /**
     * set number of audio Favorite constants
     */

    const val AUTO_FAVORITE = 0
    const val SYSTEM_FAV_SET_NUM_OF_AUD_FAVORITE = "system_fav_set_num_of_aud_fav"
    const val ANDROID_AUTO_ENABLED = "android_auto_enabled"
    const val CARPLAY_ENABLED = "carplay_enabled"
    const val BAIDU_CARLIFE_ENABLED = "baidu_carlife_enabled"

    /**
     * for vehicle List
     */
    const val VEHICLE_ENGINE_SOUND = 0
    const val VEHICLE_STEERING = 1
    const val VEHICLE_ENGINE_SUSPENSION = 2
    const val VEHICLE_AWD_OPTIMIZATION = 3
    const val VEHICLE_DRIVER_MODE = 4
    const val VEHICLE_AUTO = 4


    /**
     * for engine sound
     */
    const val VEHICLE_ENGINE_SOUND_AUTO = 0
    const val VEHICLE_ENGINE_SOUND_STEALTH = 1
    const val VEHICLE_ENGINE_SOUND_CITY = 2
    const val VEHICLE_ENGINE_SOUND_TOUR = 3
    const val VEHICLE_ENGINE_SOUND_SPORT = 4
    const val VEHICLE_ENGINE_SOUND_TRACK = 5
    const val VEHICLE_ENGINE_SOUND_OFF = 6
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
    const val STEERING_TOUR = 1
    const val STEERING_SPORT = 2
    const val STEERING_TRACK = 3
    const val STEERING_ECO = 4
    const val STEERING_CITY = 5
    const val STEERING_AUTO = 7
    const val STEERING_MODE6 = 6

    const val SUSPENSION_TOUR = 1
    const val SUSPENSION_SPORT = 2
    const val SUSPENSION_TRACK = 3
    const val SUSPENSION_MODE4 = 4
    const val SUSPENSION_MODE5 = 5
    const val SUSPENSION_MODE6 = 6
    const val SUSPENSION_AUTO=7
    const val TRACTION_AUTO = 7
    const val TRACTION_TOUR = 1
    const val TRACTION_SPORT = 2
    const val TRACTION_TRACK = 3
    const val TRACTION_ECO = 4
    const val TRACTION_SNOW = 5
    const val TRACTION_OFF = 6
const val DEFAULT=0
    /**
     * for Climate List Tags
     */

    const val CLIMATE_AUTO_FAN_SPEED = "AutoFanSpeed"
    const val CLIMATE_AIR_QUALITY_SENSOR = "AirQulitySensor"
    const val CLIMATE_POLLUTION_CONTROL = "PollutionControl"
    const val CLIMATE_AUTO_COOLED_SETS = "AutoCooledSets"
    const val CLIMATE_AUTO_HEATED_SETS = "AutoHeatedSets"
    const val CLIMATE_AUTO_DEFOG = "AutoDefog"
    const val CLIMATE_AUTO_REAR_DEFOG = "AutoRearDefog"
    const val CLIMATE_AUTO_AIR_DISTRIBUTION = "AutoAirDistribution"
    const val CLIMATE_IONIZER = "Ionizer"


     const val POWERMODE_CHNAGE = "POWER"


    /**
     * Event Names for Hardware callback recognistion
     */
    val SETTINGS_VEHICLE_DRIVINGMODE_ENGINE_SOUND = "SettingsVehicleDrivingModeEngineSound"
    val SETTINGS_VEHICLE_DRIVINGMODE_STEEING = "SettingsVehicleDrivingModeSteering"
    val SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION = "SettingsVehicleDrivingModeSuspension"
    val SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT= "SettingsVehicleDrivingModeTransit"


    /**
     * Event Names for Hardware callback recognistion
     */
    val SETTINGS_MAINMENU_TYPE = "SettingsMainMenuType"
    val SETTINGS_VEHICLE_SPORTMODE_STEERING = "SettingsVehicleSportModeSteering"
    val SETTINGS_VEHICLE_SPORTMODE_DISPLAY = "SettingsVehicleSportModeDisplay"
    val SETTINGS_VEHICLE_SPORTMODE_SUSPENSION = "SettingsVehicleSportModeSuspension"
    val SETTINGS_VEHICLE_SPORTMODE_TRACTION= "SettingsVehicleSportModeTraction"
    val SETTINGS_VEHICLE_SPORTMODE_DRIVERSEAT= "SettingsVehicleSportModeDriverSeat"
    val SETTINGS_VEHICLE_SPORTMODE_PASSENGERSEAT= "SettingsVehicleSportModePassengerSeat"
    val SETTINGS_VEHICLE_SPORTMODE_ADAPTIVECRUISECONTROL= "SettingsVehicleSportModeAdaptiveCruiseControl"




    /**
     * Enable constant
     */
    val ENABLE_SETTING = 1

    /**
     * Disable constant
     */
    val DISABLE_SETTING = 0


    /**
     * Climate Enable constant
     */
    val CLIMATE_ENABLE_SETTING = 1

    /**
     * climate Disable constant
     */
    val CLIMATE_DISABLE_SETTING = 2


}
