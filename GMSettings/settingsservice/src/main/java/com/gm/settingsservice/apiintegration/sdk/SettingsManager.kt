package com.gm.settingsservice.apiintegration.sdk


import com.gm.settings.entities.vehiclesettings.ClimateAndAirQuality
import com.gm.settings.entities.vehiclesettings.PowerDoorLocks
import com.gm.settings.entities.vehiclesettings.SportMode
import com.gm.settings.entities.vehiclesettings.VehicleSettings
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.AppSignal
import com.gm.settingsservice.utils.Constants
import com.gm.settingsservice.utils.Constants.CLIMATE_AIR_QUALITY_SENSOR
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_AIR_DISTRIBUTION
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_COOLED_SETS
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_DEFOG
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_FAN_SPEED
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_HEATED_SETS
import com.gm.settingsservice.utils.Constants.CLIMATE_AUTO_REAR_DEFOG
import com.gm.settingsservice.utils.Constants.CLIMATE_IONIZER
import com.gm.settingsservice.utils.Constants.CLIMATE_POLLUTION_CONTROL
import com.gm.settingsservice.utils.Constants.SETTINGS_MAINMENU_TYPE
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_DRIVINGMODE_ENGINE_SOUND
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_DRIVINGMODE_STEEING
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT
import com.gm.settingsservice.utils.Log
import com.gm.settingsservice.utils.Signals
import gm.provider.GMDataAnalytics
import gm.vehicle.Customization
import gm.vehicle.DrivingMode
import javax.inject.Inject


class SettingsManager @Inject constructor(val systemListener: SystemListener, val customization: Customization) : SettingsListenerManager.IVehicleDataChangedListener {

    companion object {
        var mCustomization = Customization()
    }



    fun initListeners() {

       ClimateAndAirQuality.AUTO_DEFOG.ordinal
        mCustomization.setOnPerformanceModeMainMenuTypeChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_MAINMENU_TYPE))
        mCustomization.setOnSoundPerformanceModeCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_ENGINE_SOUND))
        mCustomization.setOnDriverSeatPerformanceModeCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_DRIVERSEAT))
        mCustomization.setOnDisplayPerformanceModeCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_DISPLAY))
        mCustomization.setOnPassengerSeatPerformanceModeCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_PASSENGERSEAT))
        mCustomization.setOnAdaptiveCruiseControlPerformanceModeCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_ADAPTIVECRUISECONTROL))

        initVehicleList()
        mCustomization.setOnAirQualitySensorCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AIR_QUALITY_SENSOR))
        mCustomization.setOnAutomaticFanCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_FAN_SPEED))
        mCustomization.setOnPollutionControlCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_POLLUTION_CONTROL))
        mCustomization.setOnPollutionControlCustomizationSettingAvailableChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_POLLUTION_CONTROL))
        mCustomization.setOnAutomaticCooledSeatCustomizationSettingAvailableChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_COOLED_SETS))
        mCustomization.setOnAutomaticCooledSeatCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_COOLED_SETS))
        mCustomization.setOnAutomaticHeatedSeatCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_HEATED_SETS))
        mCustomization.setOnAutomaticDefogCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_DEFOG))
        mCustomization.setOnRearDefogStartupCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_REAR_DEFOG))
        mCustomization.setOnAutomaticAirDistributionCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_AUTO_AIR_DISTRIBUTION))
        mCustomization.setOnIonizerControlCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, CLIMATE_IONIZER))

    }

    override fun onVehicleDataChange(regEventName: String, data: Any, data1: Any) {

    }

    override fun onVehicleDataChange(regEventName: String, data: Any) {
        println("Class: SettingsManager methodName: onVehicleDataChange values_Demo: $regEventName $data")
        when (regEventName) {
            SETTINGS_MAINMENU_TYPE -> listnerRegistrations(data)
            SETTINGS_VEHICLE_DRIVINGMODE_ENGINE_SOUND -> systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus(enginesound = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue,
                    steering = mCustomization.steeringCustomizationCurrentSettingValue,
                    suspension = mCustomization.suspensionCustomizationCurrentSettingValue,
                    traction = mCustomization.drivelineCustomizationCurrentSettingValue
            ))
            SETTINGS_VEHICLE_DRIVINGMODE_STEEING -> systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus(enginesound = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue,
                    steering = mCustomization.steeringCustomizationCurrentSettingValue,
                    suspension = mCustomization.suspensionCustomizationCurrentSettingValue,
                    traction = mCustomization.drivelineCustomizationCurrentSettingValue
            ))
            SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION -> systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus(enginesound = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue,
                    steering = mCustomization.steeringCustomizationCurrentSettingValue,
                    suspension = mCustomization.suspensionCustomizationCurrentSettingValue,
                    traction = mCustomization.drivelineCustomizationCurrentSettingValue
            ))
            SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT -> systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus(enginesound = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue,
                    steering = mCustomization.steeringCustomizationCurrentSettingValue,
                    suspension = mCustomization.suspensionCustomizationCurrentSettingValue,
                    traction = mCustomization.drivelineCustomizationCurrentSettingValue
            ))

            CLIMATE_AIR_QUALITY_SENSOR -> systemListener.onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(SettingsClimateAirQualitySensor_t(data as Int, eSettingsClimateAirQualitySensor.SETTINGS_CLIMATE_AIRQUALITYSENSOR_HIGH))
            CLIMATE_AUTO_FAN_SPEED -> systemListener.onCUSTOMIZATIONECC_RES_AUTOFANSETTING(SettingsClimateAutoFanSpeed_t(data as Int, eSettingsClimateAutoFanSpeed.SETTINGS_CLIMATE_AUTO_FAN_SPEED_HIGH))
            CLIMATE_POLLUTION_CONTROL -> systemListener.onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(SettingsClimatePollutionControlSetting_t(data as Int, eSettingsClimatePollutionControl.SETTINGS_CLIMATE_POLLUTION_CONTROL_ON))
            CLIMATE_AUTO_COOLED_SETS -> systemListener.onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(SettingsClimateAutoCoolSeatsSettingValue_t(data as Int, eSettingsClimateAutoCooledSeats.SETTINGS_CLIMATE_AUTO_COOLEDSEATS_ON))
            CLIMATE_AUTO_HEATED_SETS -> systemListener.onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(SettingsClimateAutoHeatedSeats_t(data as Int, eSettingsClimateAutoHeatedSeats.SETTINGS_CLIMATE_AUTO_HEATEDSEATS_ON))
            CLIMATE_AUTO_DEFOG -> systemListener.onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(SettingsClimateAutoDefog_t(data as Int, eSettingsClimateAutoDefog.SETTINGS_CLIMATE_AUTO_DEFOG_ON))
            CLIMATE_AUTO_REAR_DEFOG -> systemListener.onCUSTOMIZATIONECC_RES_REARDEFOGSTARTUPSETTING(SettingsClimateAutoRearDefog_t(data as Int, eSettingsClimateAutoRearDefog.SETTINGS_CLIMATE_REAR_DEFOG_MANUAL))
            CLIMATE_AUTO_AIR_DISTRIBUTION -> systemListener.onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(SettingsClimateAutoAirDistribution_t(data as Int, eSettingsClimateAutoAirDistribution.SETTINGS_CLIMATE_DIFFUSE_AIRFLOW))
            CLIMATE_IONIZER -> systemListener.onCUSTOMIZATIONECC_RES_IONIZERSETTING(SettingsClimateIonizer_t(data as Int, eSettingsClimateIonizer.SETTINGS_CLIMATE_IONIZER_OFF))

            Constants.SETTINGS_VEHICLE_SPORTMODE_STEERING -> systemListener.onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_DISPLAY -> systemListener.onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_SUSPENSION -> systemListener.onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_TRACTION -> systemListener.onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_DRIVERSEAT -> systemListener.onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_PASSENGERSEAT -> systemListener.onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(data)
            Constants.SETTINGS_VEHICLE_SPORTMODE_ADAPTIVECRUISECONTROL -> systemListener.onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(data)
        }
    }

    fun listnerRegistrations(any: Any) {
        Log.e("Listners", "Vehicle" + any)
        when (any as Int) {
            2 -> {
                mCustomization.removeOnSteeringCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_STEERING))
                mCustomization.removeOnSuspensionCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_SUSPENSION))
                mCustomization.removeOnDrivelineCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_TRACTION))

                mCustomization.setOnSteeringCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_STEEING))
                mCustomization.setOnSuspensionCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION))
                mCustomization.setOnDrivelineCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT))
            }
            3 -> {
                mCustomization.removeOnSteeringCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_STEEING))
                mCustomization.removeOnSuspensionCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION))
                mCustomization.removeOnDrivelineCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT))
                mCustomization.setOnSteeringCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_STEERING))
                mCustomization.setOnSuspensionCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_SUSPENSION))
                mCustomization.setOnDrivelineCustomizationCurrentSettingValueChangedListener(SettingsListenerManager(mCustomization, this, Constants.SETTINGS_VEHICLE_SPORTMODE_TRACTION))
            }
        }
    }

    fun initVehicleList() {

        systemListener.onSETTINGS_APPS_RES_DATA()
        listnerRegistrations(mCustomization.performanceModeMainMenuType)
        val mSettingsAvailibilityFlag_t = SettingsAvailibilityFlag_t()
        var drivingModeFlag = 0
        var sportModeFlag = 0
        var autoModeFlag = 0
        var mPerformanceModeMainMenuTypeValue = -1
        mPerformanceModeMainMenuTypeValue = Signals.PerformanceModeMainMenuTypeSignal().signalValue

        if (mPerformanceModeMainMenuTypeValue == Customization.PerformanceModeMainMenuType.PERFMDMAINMENUTY_MAIN_MENU_TYPE_2) {
            if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).isAvailable &&
                            AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).hasAvailableOptions()) ||
                    (AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).isAvailable &&
                            AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).hasAvailableOptions()) ||
                    (AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).isAvailable &&
                            AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).hasAvailableOptions()) ||
                    (AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).isAvailable &&
                            AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).hasAvailableOptions())) {
                drivingModeFlag = Constants.ENABLE_SETTING
            }
        }
        val SettingsDriverModeStatus_t = SettingsDriverModeStatus_t()
        var SettingsDriverStatus = SettingsDriverStatus()
        if (mPerformanceModeMainMenuTypeValue == Customization.PerformanceModeMainMenuType.PERFMDMAINMENUTY_MAIN_MENU_TYPE_3) {
            var sportSteering = 0
            var sportDisplay = 0
            var sportSuspension = 0
            var sportTraction = 0
            var sportDriverSeat = 0
            var sportPassengerSeat = 0
            var sportAdaptiveCruiseControl = 0
            if (mCustomization.steeringCustomizationSettingAvailable || mCustomization.displayPerformanceModeCustomizationSettingAvailable
                    || mCustomization.suspensionCustomizationSettingAvailable || mCustomization.drivelineCustomizationSettingAvailable ||
                    mCustomization.driverSeatPerformanceModeCustomizationSettingAvailable || mCustomization.passengerSeatPerformanceModeCustomizationSettingAvailable
                    || mCustomization.adaptiveCruiseControlPerformanceModeCustomizationSettingAvailable) {
                if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode1Available || mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode2Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode3Available || mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode4Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode5Available || mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode6Available) {
                    sportSteering = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportSteeringFlag = mCustomization.steeringCustomizationCurrentSettingValue
                }
                if (mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode1Available || mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode2Available ||
                        mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode3Available || mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode4Available ||
                        mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode5Available || mCustomization.displayPerformanceModeCustomizationAvailableDisplayPerformanceMode6Available) {
                    sportDisplay = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportDisplaysFlag = mCustomization.displayPerformanceModeCustomizationCurrentSettingValue
                }
                if (mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode1Available || mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode2Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode3Available || mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode4Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode5Available || mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode6Available) {
                    sportSuspension = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportSuspensionFlag = mCustomization.suspensionCustomizationCurrentSettingValue
                }
                if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode1Available || mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode2Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode3Available || mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode4Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode5Available || mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode6Available) {
                    sportTraction = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportAWDFlag = mCustomization.drivelineCustomizationCurrentSettingValue
                }
                if (mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode1Available || mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode2Available ||
                        mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode3Available || mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode4Available ||
                        mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode5Available || mCustomization.driverSeatPerformanceModeCustomizationAvailableDriverSeatPerformanceMode6Available) {
                    sportDriverSeat = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportDriverSeatFlag = mCustomization.driverSeatPerformanceModeCustomizationCurrentSettingValue
                }
                if (mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode1Available || mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode2Available ||
                        mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode3Available || mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode4Available ||
                        mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode5Available || mCustomization.passengerSeatPerformanceModeCustomizationAvailablePassengerSeatPerformanceMode6Available) {
                    sportPassengerSeat = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportPassengerSeatFlag = mCustomization.passengerSeatPerformanceModeCustomizationCurrentSettingValue
                }
                if (mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode1Available || mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode2Available ||
                        mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode3Available || mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode4Available ||
                        mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode5Available || mCustomization.adaptiveCruiseControlPerformanceModeCustomizationAvailableAdaptiveCruiseControlPerformanceMode6Available) {
                    sportAdaptiveCruiseControl = 1
                    mSettingsAvailibilityFlag_t.settingsSportModeSportAdaptiveCruiseControlFlag = mCustomization.adaptiveCruiseControlPerformanceModeCustomizationCurrentSettingValue
                }
                if (sportSteering == 1 || sportDisplay == 1 || sportSuspension == 1 || sportTraction == 1 || sportDriverSeat == 1 || sportPassengerSeat == 1 || sportAdaptiveCruiseControl == 1) {
                    sportModeFlag = Constants.ENABLE_SETTING
                }
            }
        }
        systemListener.onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(GlobalSettingsAvailibilityFlag_t(drivingModeFlag = drivingModeFlag, sportsModeCustomizationFlag = sportModeFlag, autoModeCustomizationFlag = autoModeFlag))

        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).hasAvailableOptions())) {
            mSettingsAvailibilityFlag_t.SettingsChangePerfModeSoundCustomizationFlag = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue
        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).hasAvailableOptions())) {
            mSettingsAvailibilityFlag_t.settingsSteeringCustomizationFlag = mCustomization.steeringCustomizationCurrentSettingValue
        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).hasAvailableOptions())) {
            mSettingsAvailibilityFlag_t.settingsSuspensionCustomizationFlag = mCustomization.suspensionCustomizationCurrentSettingValue
        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).hasAvailableOptions())) {
            mSettingsAvailibilityFlag_t.settingsTractionCustomizationFlag = mCustomization.drivelineCustomizationCurrentSettingValue
        }
        systemListener.onSETTINGS_RES_SUPPORTEDSETTINGS(mSettingsAvailibilityFlag_t)
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).hasAvailableOptions())) {
            val arrayListSoundModes = ArrayList<ESettingsChangePerfModeSound>()
            arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode1Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode2Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode3Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode4Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode5Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY)
            if (mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode6Available)
                arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF)
            systemListener.onSETTINGS_RES_PERFMODESOUNDCUSTOMIZATIONSETTING(arrayListSoundModes)
            SettingsDriverStatus.enginesound = mCustomization.soundPerformanceModeCustomizationCurrentSettingValue

        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSteering).hasAvailableOptions())) {
            val arrayListSteeringModes = ArrayList<ESettingsSteeringCustomization>()
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode1Available)
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR)
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode2Available)
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT)
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode3Available)
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK)
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode4Available)
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO)
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode5Available)
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY)
            if (mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode6Available || (mPerformanceModeMainMenuTypeValue == Customization.PerformanceModeMainMenuType.PERFMDMAINMENUTY_MAIN_MENU_TYPE_2))
                arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO)
            systemListener.onSETTINGS_RES_SPORTMODESPORTSTEERINGSETTINGS(arrayListSteeringModes)
            SettingsDriverStatus.steering = mCustomization.steeringCustomizationCurrentSettingValue
        }

        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSuspension).hasAvailableOptions())) {
            val arrayListSteeringModes = ArrayList<ESettingsSuspensionCustomization>()
            if (mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode1Available)
                arrayListSteeringModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR)
            if (mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode2Available)
                arrayListSteeringModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT)
            if (mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode3Available)
                arrayListSteeringModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK)
            if (mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode4Available ||
                    mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode5Available ||
                    mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode6Available ||
                    mPerformanceModeMainMenuTypeValue == Customization.PerformanceModeMainMenuType.PERFMDMAINMENUTY_MAIN_MENU_TYPE_2) {
                arrayListSteeringModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)
            }
            systemListener.onSETTINGS_RES_SPORTMODESPORTSUSPENSIONSETTINGS(arrayListSteeringModes)
            SettingsDriverStatus.suspension = mCustomization.suspensionCustomizationCurrentSettingValue
        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeDriveline).hasAvailableOptions())) {
            val arrayListTractionModes = ArrayList<ESettingsTractionCustomization>()
            arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode1Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode2Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode3Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode4Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode5Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER)
            if (mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode6Available)
                arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF)
            systemListener.onSETTINGS_RES_TRACTIONCONTROLSYSTEMSTATUS(arrayListTractionModes)
            SettingsDriverStatus.traction = mCustomization.drivelineCustomizationCurrentSettingValue
        }
        if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).isAvailable &&
                        AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).hasAvailableOptions())) {

        }
        systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus)


        if (mCustomization.airQualitySensorCustomizationSettingAvailable ||
                mCustomization.automaticFanCustomizationSettingAvailable ||
                mCustomization.pollutionControlCustomizationSettingAvailable ||
                mCustomization.automaticHeatedSeatCustomizationSettingAvailable ||
                mCustomization.automaticCooledSeatCustomizationSettingAvailable ||
                mCustomization.rearDefogStartupCustomizationSettingAvailable ||
                mCustomization.rearZoneStartupCustomizationSettingAvailable ||
                mCustomization.automaticDefogCustomizationSettingAvailable ||
                mCustomization.elevatedIdleCustomizationSettingAvailable ||
                mCustomization.automaticAirDistributionCustomizationSettingAvailable ||
                mCustomization.ionizerControlCustomizationSettingAvailable) {
            systemListener.onSETTINGS_RES_CLIMATE()
        }

    }


}