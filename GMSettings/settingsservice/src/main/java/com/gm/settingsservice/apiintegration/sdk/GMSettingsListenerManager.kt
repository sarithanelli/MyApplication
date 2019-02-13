package com.gm.settingsservice.apiintegration.sdk


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
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_ADAPTIVECRUISECONTROL
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_DISPLAY
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_DRIVERSEAT
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_PASSENGERSEAT
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_STEERING
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_SUSPENSION
import com.gm.settingsservice.utils.Constants.SETTINGS_VEHICLE_SPORTMODE_TRACTION
import com.gm.settingsservice.utils.Log
import gm.vehicle.Customization
import gm.vehicle.OnVehicleDataChangedListener

class GMSettingsListenerManager(data: Any, _INSTANCE: Any, private val regEventName: String) : OnVehicleDataChangedListener {


    private val listener: IVehicleDataChangedListener = _INSTANCE as IVehicleDataChangedListener
    private val mCustomization = data as Customization


    interface IVehicleDataChangedListener {
        fun onVehicleDataChange(regEventName: String, data: Any)
        fun onVehicleDataChange(regEventName: String, data: Any, data1: Any)
    }


    override fun onVehicleDataChanged() {
        Log.e("Vehicle Data", "Received")
        println("Class: SettingsManager methodName: onVehicleDataChange values: $regEventName")
        when (regEventName) {
            SETTINGS_MAINMENU_TYPE -> listener.onVehicleDataChange(regEventName, mCustomization.performanceModeMainMenuType)

            SETTINGS_VEHICLE_SPORTMODE_STEERING -> listener.onVehicleDataChange(regEventName, mCustomization.steeringCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_DISPLAY -> listener.onVehicleDataChange(regEventName, mCustomization.displayPerformanceModeCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_SUSPENSION -> listener.onVehicleDataChange(regEventName, mCustomization.suspensionCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_TRACTION -> listener.onVehicleDataChange(regEventName, mCustomization.drivelineCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_DRIVERSEAT -> listener.onVehicleDataChange(regEventName, mCustomization.driverSeatPerformanceModeCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_PASSENGERSEAT -> listener.onVehicleDataChange(regEventName, mCustomization.passengerSeatPerformanceModeCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_SPORTMODE_ADAPTIVECRUISECONTROL -> listener.onVehicleDataChange(regEventName, mCustomization.adaptiveCruiseControlPerformanceModeCustomizationCurrentSettingValue)


            SETTINGS_VEHICLE_DRIVINGMODE_ENGINE_SOUND -> listener.onVehicleDataChange(regEventName, mCustomization.soundPerformanceModeCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_DRIVINGMODE_STEEING -> listener.onVehicleDataChange(regEventName, mCustomization.steeringCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_DRIVINGMODE_SUSPENSION -> listener.onVehicleDataChange(regEventName, mCustomization.suspensionCustomizationCurrentSettingValue)
            SETTINGS_VEHICLE_DRIVINGMODE_TRANSIT -> listener.onVehicleDataChange(regEventName, mCustomization.drivelineCustomizationCurrentSettingValue)


            CLIMATE_AIR_QUALITY_SENSOR -> listener.onVehicleDataChange(regEventName, mCustomization.airQualitySensorCustomizationCurrentSettingValue)
            CLIMATE_AUTO_FAN_SPEED -> listener.onVehicleDataChange(regEventName, mCustomization.automaticFanCustomizationCurrentSettingValue)
            CLIMATE_POLLUTION_CONTROL -> listener.onVehicleDataChange(regEventName, mCustomization.pollutionControlCustomizationCurrentSettingValue)
            CLIMATE_AUTO_COOLED_SETS -> listener.onVehicleDataChange(regEventName, mCustomization.automaticCooledSeatCustomizationCurrentSettingValue)
            CLIMATE_AUTO_HEATED_SETS -> listener.onVehicleDataChange(regEventName, mCustomization.automaticHeatedSeatCustomizationCurrentSettingValue)
            CLIMATE_AUTO_DEFOG -> listener.onVehicleDataChange(regEventName, mCustomization.automaticDefogCustomizationCurrentSettingValue)
            CLIMATE_AUTO_REAR_DEFOG -> listener.onVehicleDataChange(regEventName, mCustomization.rearDefogStartupCustomizationCurrentSettingValue)
            CLIMATE_AUTO_AIR_DISTRIBUTION -> listener.onVehicleDataChange(regEventName, mCustomization.automaticAirDistributionCustomizationCurrentSettingValue)
            CLIMATE_IONIZER -> listener.onVehicleDataChange(regEventName, mCustomization.ionizerControlCustomizationCurrentSettingValue)

        }
    }

    override fun onVehicleDataChanged(p0: Int) {

    }
}