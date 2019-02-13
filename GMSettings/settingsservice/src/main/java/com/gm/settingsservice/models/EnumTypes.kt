package com.gm.settingsservice.models

enum class eSettingsTimeDisplayFormat {
    SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE,
    SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE
}

enum class eSettingsAutoTimeDateUpdateSetting {
    SETTINGS_SS_TIME_DATE_UPDATE_MANUAL,
    SETTINGS_SS_TIME_DATE_UPDATE_AUTO_PHONE,
    SETTINGS_SS_TIME_DATE_UPDATE_AUTO_RDS
}

enum class eSettingsPrivacyLocationServices {
    SETTINGS_PRIVACY_LOCATION_SERVICES_OFF,
    SETTINGS_PRIVACY_LOCATION_SERVICES_ON
}

enum class eSettingsdisplayMode(val value: Number) {
    SETTINGS_DISPLAY_MODE_AUTO(0) {
        override fun toString(): String {
            return "Auto"
        }
    },
    SETTINGS_DISPLAY_MODE_DAY(1) {
        override fun toString(): String {
            return "Day"
        }
    },
    SETTINGS_DISPLAY_MODE_NIGHT(2) {
        override fun toString(): String {
            return "Night"
        }
    }
}


enum class eSettingsTimeMeridiem(val value: Int) {
    SETTINGS_TIME_MERIDIEM_ANTE(0),
    SETTINGS_TIME_MERIDIEM_POST(1)
}


enum class eSettingsCollisionDetectionTrafficRoadSideInformation {
    SETTINGS_COLLISION_DETECTION_TARFFIC_ROAD_SIDE_INFORMATION_OFF,
    SETTINGS_COLLISION_DETECTION_TARFFIC_ROAD_SIDE_INFORMATION_ON
}

enum class eSettingsTrunkControl {
    SETTINGS_CC_TRUNKCONTROL_OFF,
    SETTINGS_CC_TRUNKCONTROL_OPEN_CLOSE,
    SETTINGS_CC_TRUNKCONTROL_OPEN
}

enum class eSettingsCollisionDetectionConnectedVehicleBrakingAlerts {
    SETTINGS_COLLISION_DETECTION_CONNECTED_VEHICLE_BRAKING_ALERTS_OFF,
    SETTINGS_COLLISION_DETECTION_CONNECTED_VEHICLE_BRAKING_ALERTS_ON
}

enum class eSettingsVehicleLocatorLights {
    SETTINGS_LIGHTING_VehicleLocatorLights_OFF,
    SETTINGS_LIGHTING_VehicleLocatorLights_ON
}

enum class eSettingsCollisionDetectionIntersectionStopAlert {
    SETTINGS_COLLISION_DETECTION_INTERSECTION_STOP_ALERT_OFF,
    SETTINGS_COLLISION_DETECTION_INTERSECTION_STOP_ALERT_ALERT,
    SETTINGS_COLLISION_DETECTION_INTERSECTION_STOP_ALERT_BRAKE
}


enum class eSettingsLaneChangeAlert {
    SETTINGS_OFF,
    SETTINGS_ON
}

enum class eSettingsLeftRightHandTraffic {
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_NOVALUE,
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_LEFTHAND_DRIVE,
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_RIGHTHAND_DRIVE
}

enum class eSettingsLeftRightHandTrafficWithGPS {
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_GPS_NOVALUE,
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_GPS_LEFTHAND_DRIVE,
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_GPS_RIGHTHAND_DRIVE,
    SETTINGS_LIGHTING_LEFT_RIGHT_HAND_TRAFFIC_CUSTOMIZATION_GPS_AUTOMATIC
}

enum class eSettingsParkingAssist {
    SETTINGS_PARKASSIST_OFF,
    SETTINGS_PARKASSIST_ON
}

enum class eSettingsParkAssistWithTowbar {
    SETTINGS_TOWBAR_OFF,
    SETTINGS_TOWBAR_ON,
    SETTINGS_Towbar
}


enum class eSettingsPedestrianFriendlyAlert {
    SETTINGS_PED_FRIENDLY_ALERT_SETTING_UNKNOWN,
    SETTINGS_PED_FRIENDLY_ALERT_OFF,
    SETTINGS_PED_FPED_FRIENDLY_ALERT_ON
}

enum class eSettingsPerfModeDisplayCustomization {
    SETTINGS_DRIVERMODE_DISPLAY_AUTO,
    SETTINGS_DRIVERMODE_DISPLAY_TOUR,
    SETTINGS_DRIVERMODE_DISPLAY_SPORT,
    SETTINGS_DRIVERMODE_DISPLAY_TRACK,
    SETTINGS_DRIVERMODE_DISPLAY_ECO,
    SETTINGS_DRIVERMODE_DISPLAY_SNOW_ICE_WEATHER
}

/*
enum class ESettingsChangePerfModeSound {
    SETTINGS_DRIVERMODE_ENGINESOUND_DEFAULT,
    SETTINGS_DRIVERMODE_ENGINESOUND_AUTO,
    SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH,
    SETTINGS_DRIVERMODE_ENGINESOUND_CITY,
    SETTINGS_DRIVERMODE_ENGINESOUND_TOUR,
    SETTINGS_DRIVERMODE_ENGINESOUND_SPORT,
    SETTINGS_DRIVERMODE_ENGINESOUND_TRACK,
    SETTINGS_DRIVERMODE_ENGINESOUND_OFF
}*/


enum class eSettingsPersonalizationbyDriver {
    SETTINGS_CC_PERSONALIZATIONBYDRIVER_OFF,
    SETTINGS_CC_PERSONALIZATIONBYDRIVER_ON
}

enum class eSettingsRainSenseWipers {
    SETTINGS_CC_RAINSENSEWIPERS_DISABLED,
    SETTINGS_CC_RAINSENSEWIPERS_ENABLED
}

enum class eSettingsCollisionDetectionRearCameraParkAssist {
    SETTINGS_COLLISION_DETECTION_REAR_CAMERA_PARK_ASSIST_OFF,
    SETTINGS_COLLISION_DETECTION_REAR_CAMERA_PARK_ASSIST_ON
}

enum class eSettingsRearCrossTrafficAlert {
    SETTINGS_REARCROSSTRAFFICALERT_OFF,
    SETTINGS_REARCROSSTRAFFICALERT_ON
}

enum class eSettingsRearPedestrianDetection {
    SETTINGS_REAR_PED_DETECT_ALERT,
    SETTINGS_REAR_PED_DETECT_OFF,
    SETTINGS_REAR_PED_DETECT_ALERT_BRAKE,
    SETTINGS_REAR_PED_DETECT_ALERT_BRAKE_STEER
}

enum class eSettingsReverseTiltMirror1 {
    SETTINGS_CC_ReverseTiltMirror1_OFF,
    SETTINGS_CC_ReverseTiltMirror1_ON_DRIVEANDPASSENGER,
    SETTINGS_CC_ReverseTiltMirror1_ON_DRIVER,
    SETTINGS_CC_ReverseTiltMirror1_ON_PASSENGER
}

enum class eSettingsReverseTiltMirror2 {
    SETTINGS_CC_ReverseTiltMirror2_OFF,
    SETTINGS_CC_ReverseTiltMirror2_ON,
    SETTINGS_CC_ReverseTiltMirror2_ON_DRIVEANDPASSENGER,
    SETTINGS_CC_ReverseTiltMirror2_ON_DRIVER,
    SETTINGS_CC_ReverseTiltMirror2_ON_PASSENGER
}

enum class eSettingsReverseTiltMirror {
    SETTINGS_CC_ReverseTiltMirror_OFF,
    SETTINGS_CC_ReverseTiltMirror_ON
}

enum class eSettingsSeatBeltTightening {
    SETTINGS_SEAT_BELT_TIGHTENING_CUSTOMIZATION_OFF,
    SETTINGS_SEAT_BELT_TIGHTENING_CUSTOMIZATION_ON
}

enum class eSettingsSideBlindZoneAlert {
    SETTINGS_BLINDZONEALERT_OFF,
    SETTINGS_BLINDZONEALERT_ON
}

enum class eSettingsSmartHighBeamAssist {
    SETTINGS_LIGHTING_AUTOHIGHBEAM,
    SETTINGS_LIGHTING_ADAPTIVEHIGHBEAM
}

enum class eSettingsSportAutoModeCustomizations {
    SETTINGS_SPORTAUTOMODE_NORMAL,
    SETTINGS_SPORTAUTOMODE_SPORT_SENSTIVE,
    SETTINGS_SPORTAUTOMODE_COMFORT_SENSITIVE,
    SETTINGS_SPORTAUTOMODE_SPORT_COMFORT_SENSITIVE,
    SETTINGS_SPORTAUTOMODE_SPORT_COMFORT_LESS_SENSITIVE,
    SETTINGS_SPORTAUTOMODE_AUTO_ADJUSTMENT_OFF,
    SETTINGS_SPORTAUTOMODE_AUTO_TOUR_OFF
}


enum class eSettingsLocationBasedCharging {
    SETTINGS_CC_LOCATIONBASEDCHARGING_NOACTION,
    SETTINGS_CC_LOCATIONBASEDCHARGING_OFF,
    SETTINGS_CC_LOCATIONBASEDCHARGING_ON,
    SETTINGS_CC_LOCATIONBASEDCHARGING_SETLOCATION
}

enum class eSettingsEnergySummaryPopup {
    SETTINGS_CC_ENERGYSUMMARYPOPUP_NOACTION,
    SETTINGS_CC_ENERGYSUMMARYPOPUP_OFF,
    SETTINGS_CC_ENERGYSUMMARYPOPUP_ON
}

enum class eSettingsChargeStatusFeedback {
    SETTINGS_CC_CHARGESTATUSFEEDBACK_NOACTION,
    SETTINGS_CC_CHARGESTATUSFEEDBACK_OFF,
    SETTINGS_CC_CHARGESTATUSFEEDBACK_ON
}

enum class eSettingsChargeCordTheftAlert {
    SETTINGS_CC_CHARGECORDTHEFTALERT_NOACTION,
    SETTINGS_CC_CHARGECORDTHEFTALERT_OFF,
    SETTINGS_CC_CHARGECORDTHEFTALERT_ON
}

enum class eSettingsChargePowerLossAlert {
    SETTINGS_CC_CHARGEPOWERLOSSALERT_NOACTION,
    SETTINGS_CC_CHARGEPOWERLOSSALERT_OFF,
    SETTINGS_CC_CHARGEPOWERLOSSALERT_ON
}

enum class eSettingsStandBySpeed {
    SETTINGS_CC_STANDBYSPEED_NOACTION,
    SETTINGS_CC_STANDBYSPEED_900,
    SETTINGS_CC_STANDBYSPEED_1000,
    SETTINGS_CC_STANDBYSPEED_1100,
    SETTINGS_CC_STANDBYSPEED_1200,
    SETTINGS_CC_STANDBYSPEED_1300,
    SETTINGS_CC_STANDBYSPEED_1400,
    SETTINGS_CC_STANDBYSPEED_1500
}

enum class eSettingsSet1Speed {
    SETTINGS_CC_SET1SPEED_NOACTION,
    SETTINGS_CC_SET1SPEED_1100,
    SETTINGS_CC_SET1SPEED_1200,
    SETTINGS_CC_SET1SPEED_1300,
    SETTINGS_CC_SET1SPEED_1400,
    SETTINGS_CC_SET1SPEED_1500,
    SETTINGS_CC_SET1SPEED_1600,
    SETTINGS_CC_SET1SPEED_1700,
    SETTINGS_CC_SET1SPEED_1800,
    SETTINGS_CC_SET1SPEED_1900,
    SETTINGS_CC_SET1SPEED_2000,
    SETTINGS_CC_SET1SPEED_2100,
    SETTINGS_CC_SET1SPEED_2200,
    SETTINGS_CC_SET1SPEED_2300,
    SETTINGS_CC_SET1SPEED_2400,
    SETTINGS_CC_SET1SPEED_2500
}

enum class eSettingsSet2Speed {
    SETTINGS_CC_SET2SPEED_NOACTION,
    SETTINGS_CC_SET2SPEED_1900,
    SETTINGS_CC_SET2SPEED_2000,
    SETTINGS_CC_SET2SPEED_2100,
    SETTINGS_CC_SET2SPEED_2200,
    SETTINGS_CC_SET2SPEED_2300,
    SETTINGS_CC_SET2SPEED_2400,
    SETTINGS_CC_SET2SPEED_2500,
    SETTINGS_CC_SET2SPEED_2600,
    SETTINGS_CC_SET2SPEED_2700,
    SETTINGS_CC_SET2SPEED_2800,
    SETTINGS_CC_SET2SPEED_2900
}

enum class eSettingsShutDownTime {
    SETTINGS_CC_SHUTDOWNTIME_NOACTION,
    SETTINGS_CC_SHUTDOWNTIME_10MIN,
    SETTINGS_CC_SHUTDOWNTIME_30MIN,
    SETTINGS_CC_SHUTDOWNTIME_1HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_2HR,
    SETTINGS_CC_SHUTDOWNTIME_2HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_3HR,
    SETTINGS_CC_SHUTDOWNTIME_3HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_4HR,
    SETTINGS_CC_SHUTDOWNTIME_4HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_5HR,
    SETTINGS_CC_SHUTDOWNTIME_5HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_6HR,
    SETTINGS_CC_SHUTDOWNTIME_6HALFHR,
    SETTINGS_CC_SHUTDOWNTIME_7HR,
    SETTINGS_CC_SHUTDOWNTIME_7HALFHR
}

enum class eSettingsCollisionDetectionAlertType {
    SETTINGS_COLLISION_DETECTION_ALERT_TYPE_BEEPS,
    SETTINGS_COLLISION_DETECTION_ALERT_TYPE_SAFETYALERT
}

enum class eSettingsAdaptiveHighBeamAssistWithSensitivity {
    SETTINGS_LIGHTING_ADAPTIVE_HIGH_BEAM_ASSIST_WITH_SENSITIVITY_CUSTOMIZATION_NOVALUE,
    SETTINGS_LIGHTING_ADAPTIVE_HIGH_BEAM_ASSIST_WITH_SENSITIVITY_CUSTOMIZATION_OFF,
    SETTINGS_LIGHTING_ADAPTIVE_HIGH_BEAM_ASSIST_WITH_SENSITIVITY_CUSTOMIZATION_ON_NORMAL_SENSITIVITY,
    SETTINGS_LIGHTING_ADAPTIVE_HIGH_BEAM_ASSIST_WITH_SENSITIVITY_CUSTOMIZATION_ON_REDUCED_SENSITIVITY
}

enum class eSettingsAutoHighBeamAssistWithSensitivity {
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_CUSTOMIZATION_ON,
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_CUSTOMIZATION_OFF,
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_CUSTOMIZATION_ON_NORMAL_SENSITIVITY,
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_CUSTOMIZATION_ON_REDUCED_SENSITIVITY
}

enum class eSettingsAdaptiveForwardLightingWithGPS {
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_WITH_GPS_UNKNOWN,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_WITH_GPS_CORNER_AND_CURVE_LIGHTING_ONLY,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_WITH_GPS_INTELLIGENT_LIGHT_DISTRIBUTION,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_WITH_GPS_ASSISTANCE,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_WITH_GPS_OFF
}

enum class eSettingsTapStepSpeed {
    SETTINGS_CC_TAPSTEPSPEED_NOACTION,
    SETTINGS_CC_TAPSTEPSPEED_5,
    SETTINGS_CC_TAPSTEPSPEED_10,
    SETTINGS_CC_TAPSTEPSPEED_25,
    SETTINGS_CC_TAPSTEPSPEED_50,
    SETTINGS_CC_TAPSTEPSPEED_100,
    SETTINGS_CC_TAPSTEPSPEED_250,
    SETTINGS_CC_TAPSTEPSPEED_500
}

enum class eSettingsAdaptiveForward1Lighting {
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING1_CORNER_AND_CURVE_LIGHTING_ONLY,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING1_OFF
}

enum class eSettingsAdaptiveForwardLighting {
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_UNKNOWN,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_CORNER_AND_CURVE_LIGHTING_ONLY,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_INTELLIGENT_LIGHT_DISTRIBUTION,
    SETTINGS_LIGHTING_ADAPTIVE_FWD_LIGHTING_OFF
}

enum class eSettingsAutoHighBeamAssist {
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_NOVALUE,
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_OFF,
    SETTINGS_LIGHTING_AUTO_HIGH_BEAM_ASSIST_ON
}

enum class eSettingsAutoMemoryRecall1 {
    SETTINGS_CC_AUTOMEMORYRECALL1_OFF,
    SETTINGS_CC_AUTOMEMORYRECALL1_ON_DRIVERDOORPEN,
    SETTINGS_CC_AUTOMEMORYRECALL1_ON_ATIGNITIONON
}

enum class eSettingsAutoMemoryRecall2 {
    SETTINGS_CC_AUTOMEMORYRECALL2_OFF,
    SETTINGS_CC_AUTOMEMORYRECALL2_ON,
    SETTINGS_CC_AUTOMEMORYRECALL2_ON_DRIVERDOORPEN,
    SETTINGS_CC_AUTOMEMORYRECALL2_ON_ATIGNITIONON
}

enum class eSettingsRearSeatReminder {
    SETTINGS_REAR_SEAT_REMINDER_NO_ACTION,
    SETTINGS_REAR_SEAT_REMAINDER_OFF,
    SETTINGS_REAR_SEAT_REMAINDER_ON
}


enum class eSettingsAutoMemoryRecall {
    SETTINGS_CC_AUTOMEMORYRECALL_OFF,
    SETTINGS_CC_AUTOMEMORYRECALL_ON
}

enum class eSettingsAutoMirrorFolding {
    SETTINGS_CC_AutoMirrorFolding_OFF,
    SETTINGS_CC_AutoMirrorFolding_ON
}


enum class eSettingsAutoWipeinReverseGear {
    SETTINGS_CC_AUTOWIPEINREVERSEGEAR_OFF,
    SETTINGS_CC_AUTOWIPEINREVERSEGEAR_ON
}

enum class eSettingsAutomaticVehicleHold {
    SETTINGS_CC_AUTOMATICVEHICLEHOLD_SHORT_BRAKE_OFF,
    SETTINGS_CC_AUTOMATICVEHICLEHOLD_LONG_BRAKE_ON
}

enum class eSettingsDaytimeTailLights {
    SETTINGS_LIGHTING_DAYTIMETAILLIGHTS_OFF,
    SETTINGS_LIGHTING_DAYTIMETAILLIGHTS_ON
}

enum class eSettingsDriverDrowsinessDetectionCustomization {
    SETTINGS_DRIVER_DROWSINESS_DETECTION_CUSTOMIZATION_NOVALUE,
    SETTINGS_DRIVER_DROWSINESS_DETECTION_CUSTOMIZATION_OFF,
    SETTINGS_DRIVER_DROWSINESS_DETECTION_CUSTOMIZATION_ON
}


enum class eSettingsEasyExitDriverSeat {
    SETTINGS_CC_EASYEXITDRIVERSEAT_OFF,
    SETTINGS_CC_EASYEXITDRIVERSEAT_ON
}

enum class eSettingsEasyExitOptions {
    SETTINGS_CC_EASYEXITOPTIONS_OFF,
    SETTINGS_CC_EASYEXITOPTIONS_ON
}

enum class eSettingsEasyExitSteeringColumn1 {
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN1_OFF,
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN1_ON_COLUMNUP
}

enum class eSettingsEasyExitSteeringColumn2 {
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN2_OFF,
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN2_ON_COLUMNIN,
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN2_ON_COLUMNUP,
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN2_ON_COLUMNINANDUP
}

enum class eSettingsEasyExitSteeringColumn {
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN_OFF,
    SETTINGS_CC_EASYEXITSTEERINGCOLUMN_ON_COLUMNUP
}

enum class eEngineRunActiveSetting {
    SETTINGS_ENGINE_RUN_ACTIVE,
    SETTINGS_ENGINE_RUN_INACTIVE
}

enum class eSettingsExitLighting {
    SETTINGS_LIGHTING_EXITLIGHTING_OFF,
    SETTINGS_LIGHTING_EXITLIGHTING_30SEC,
    SETTINGS_LIGHTING_EXITLIGHTING_60SEC,
    SETTINGS_LIGHTING_EXITLIGHTING_120SEC
}

enum class eSettingForwardCollisionAlert {
    SETTINGS_FORWARD_COLLISION_ALERT_CUSTOMIZATION_ALERT,
    SETTINGS_FORWARD_COLLISION_ALERT_CUSTOMIZATION_ALERT_BRAKE,
    SETTINGS_FORWARD_COLLISION_ALERT_CUSTOMIZATION_OFF,
    SETTINGS_FORWARD_COLLISION_ALERT_CUSTOMIZATION_ALERT_BRAKE_STEER
}

enum class eSettingsFrontPedestrianDetection {
    SETTINGS_FRONT_PED_DETECT_ALERT_BRAKE_STEER,
    SETTINGS_FRONT_PED_DETECT_OFF,
    SETTINGS_FRONT_PED_DETECT_ALERT,
    SETTINGS_FRONT_PED_DETECT_ALERT_AND_BRAKE
}

enum class eSettingGoNotifierCustomization {
    Settings_GO_NOTIFIER_CUSTOMIZATION_UNKNOWN,
    Settings_GO_NOTIFIER_CUSTOMIZATION_OFF,
    Settings_GO_NOTIFIER_CUSTOMIZATION_ON
}

enum class eSettingsTractionControlSystemActive {
    SETTINGS_TRACTION_CONTROL_SYSTEM_NOT_ACTIVE,
    SETTINGS_TRACTION_CONTROL_SYSTEM_ACTIVE
}

enum class eSettingsTractionControlSystemOperatingStatus {
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_STATUS_INACTIVE,
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_STATUS_ACTIVE,
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_STATUS_FAULT
}

enum class eSettingsTractionControlSystemOperatingMode {
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_MODE_OFF,
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_MODE_NORMAL,
    SETTINGS_TRACTION_CONTROL_SYSTEM_OPERATING_MODE_OFFROAD
}

enum class eSettingsAdaptiveHighBeamAssist {
    SETTINGS_LIGHT_ADAPTIVE_HIGH_BEAM_ASSIST_CUSTOMIZATION_NOVALUE,
    SETTINGS_LIGHT_ADAPTIVE_HIGH_BEAM_ASSIST_CUSTOMIZATION_OFF,
    SETTINGS_LIGHT_ADAPTIVE_HIGH_BEAM_ASSIST_CUSTOMIZATION_ON
}

enum class eSettingsAudioCues {
    SETTINGS_AUDIO_CUES_OFF,
    SETTINGS_AUDIO_CUES_ON
}

enum class eSettingsAudioTouchFeedback {
    SETTINGS_AUDIO_TOUCH_FEEDBACK_OFF,
    SETTINGS_AUDIO_TOUCH_FEEDBACK_ON
}

enum class eSettingsDisplayStatus(val value: Number) {
    SETTINGS_DISPLAY_STATUS_OFF(0) {
        override fun toString(): String {
            return "false"
        }
    },
    SETTINGS_DISPLAY_STATUS_ON(1) {
        override fun toString(): String {
            return "true"
        }
    }

}

enum class eSettingsPrivacyDataServices {
    SETTINGS_PRIVACY_DATA_SERVICES_OFF,
    SETTINGS_PRIVACY_DATA_SERVICES_ON
}

enum class eSettingsSurroundViewLighting {
    SETTINGS_SURROUNDVIEWLIGHTING_OFF,
    SETTINGS_SURROUNDVIEWLIGHTING_ON
}

enum class eSettingsValetModePinStored {
    VALETMODE_PIN_SUCCESSFUL,
    VALETMODE_PIN_FAILED
}

enum class eSettingsVehicleMovementState {
    VEHICLE_MOVEMENT_STATE_PARKED,
    VEHICLE_MOVEMENT_STATE_NEUTRAL,
    VEHICLE_MOVEMENT_STATE_FORWARD,
    VEHICLE_MOVEMENT_STATE_REVERSE,
    VEHICLE_MOVEMENT_STATE_INVALID
}

enum class eSettingsIgnitionStatus {
    SETTINGS_IGNITION_OFF,
    SETTINGS_IGNITION_CRANK,
    SETTINGS_ACC_ON,
    SETTINGS_ENGINE_ON
}

enum class eSettingsDriverLoadConditions {
    SETTINGS_DRIVERWORKLOADCONDITION_UNRESTRICTED,
    SETTINGS_DRIVERWORKLOADCONDITION_VEHICLESTOPPED,
    SETTINGS_DRIVERWORKLOADCONDITION_VEHICLELOWSPEED,
    SETTINGS_DRIVERWORKLOADCONDITION_VEHICLEMEDHISPEED,
    SETTINGS_DRIVERWORKLOADCONDITION_VEHICLETEENDRIVER,
    SETTINGS_DRIVERWORKLOADCONDITION_RESERVED1,
    SETTINGS_DRIVERWORKLOADCONDITION_RESERVED2,
    SETTINGS_DRIVERWORKLOADCONDITION_RESTRICTIONSNA
}

enum class eValetModeStatus {
    SETTINGS_VALETMODE_INACTIVE,
    SETTINGS_VALETMODE_ACTIVE
}

enum class eSettingsSystemFaultState {
    SETTINGS_SYSTEMFAULTSTATE_NORMAL_MODE,
    SETTINGS_SYSTEMFAULTSTATE_THEFTLOCKED_MODE,
    SETTINGS_SYSTEMFAULTSTATE_NOVIN_MODE,
    SETTINGS_SYSTEMFAULTSTATE_NOCALIBRATION_MODE
}

enum class eSettingsVehicleDisplayUnits {
    SETTINGS_VEHICLE_DISPLAY_UNITS_METRIC,
    SETTINGS_VEHICLE_DISPLAY_UNITS_US,
    SETTINGS_VEHICLE_DISPLAY_UNITS_IMPERIAL
}

enum class eSettingsDateFormat {
    MMDDYYYY,
    MMDYYYY,
    DDMMYYYY,
    DMMYYYY,
    YYYYMMDD,
    YYYYMMD
}

enum class eSettingsExtendedHillStartAssist {
    SETTINGS_CC_EXTENDEDHILLSTARTASSIST_EXTENDED_HOLD,
    SETTINGS_CC_EXTENDEDHILLSTARTASSIST_STANDARD_HOLD
}


enum class eSettingsDL_SetUnlock {
    SETTINGS_DOORLOCK_Unlocking_Off,
    SETTINGS_DOORLOCK_Unlocking_DriverDoor,
    SETTINGS_DOORLOCK_Unlocking_AllDoors
}

enum class eSettingsDL_LastDoorClosedLocking {
    SETTINGS_DOORLOCK_LastDoorClosedLockingOff,
    SETTINGS_DOORLOCK_LastDoorClosedLockingOn
}

enum class eSettingsDL_SetOpenDoorAntiLockOut {
    SETTINGS_DOORLOCK_OpenDoorAntiLockOut_Off,
    SETTINGS_DOORLOCK_OpenDoorAntiLockOut_On
}

enum class eSettingsDL_SetAutoLock {
    SETTINGS_DOORLOCK_AutoLockingOff,
    SETTINGS_DOORLOCK_AutoLockingOn
}

enum class eSettingsDL_SetRemoteUnlocklLightingFeedback {
    SETTINGS_DOORLOCK_SetRemoteUnlocklLightingFeedback_Off,
    SETTINGS_DOORLOCK_SetRemoteUnlocklLightingFeedback_Flash
}

enum class eSettingsDL_SetRemoteLockingFeedback {
    SETTINGS_DOORLOCK_RemoteLockingFeedback_FlashLightsOnly,
    SETTINGS_DOORLOCK_RemoteLockingFeedback_HornAndLightsOn,
    SETTINGS_DOORLOCK_RemoteLockingFeedback_HornChirpOnly,
    SETTINGS_DOORLOCK_RemoteLockingFeedback_HornAndLightsOff
}

enum class eSettingsDL_SetSelectiveUnlocking {
    SETTINGS_DOORLOCK_SetSelectiveUnlocking_DriverDoorOnly,
    SETTINGS_DOORLOCK_SetSelectiveUnlocking_AllDoors
}

enum class eSettingsDL_SetRelockRemoteUnlockedDoor {
    SETTINGS_DOORLOCK_RelockRemoteUnlockedDoor_Off,
    SETTINGS_DOORLOCK_RelockRemoteUnlockedDoor_On
}

enum class eSettingsDL_SetRemoteStart {
    SETTINGS_DOORLOCK_REMOTESTART_OFF,
    SETTINGS_DOORLOCK_REMOTESTART_ON
}

enum class eSettingsDL_SetRemoteStartAutoCoolSeatsSettings {
    SETTINGS_DOORLOCK_REMOTESTARTAUTOCOOLSEATSSETTINGS_OFF,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOCOOLSEATSSETTINGS_DRIVER,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOCOOLSEATSSETTINGS_DRIVER_PASSENGER
}

enum class eSettingsDL_SetRemoteStartAutoHeatSeats {
    SETTINGS_DOORLOCK_REMOTESTARTAUTOHEATSEATS_OFF,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOHEATSEATS_ON
}

enum class eSettingsDL_SetRemoteStartAutoHeatSeatsSettings {
    SETTINGS_DOORLOCK_REMOTESTARTAUTOHEATSEATSSETTINGS_OFF,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOHEATSEATSETTINGS_DRIVER,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOHEATSEATSETTINGS_DRIVER_PASSENGER
}

enum class eSettingsDL_SetRemoteWindowOperation {
    SETTINGS_DOORLOCK_REMOTEWINDOWOPERATION_OFF,
    SETTINGS_DOORLOCK_REMOTEWINDOWOPERATION_ON
}

enum class eSettingsDL_SetPassiveUnlock {
    SETTINGS_DOORLOCK_PassiveUnlock_DriverDoor,
    SETTINGS_DOORLOCK_PassiveUnlock_AllDoors
}

enum class eSettingsDL_SetPassiveLock {
    SETTINGS_DOORLOCK_PassiveLock_Off,
    SETTINGS_DOORLOCK_PassiveLock_On,
    SETTINGS_DOORLOCK_PassiveLock_OnWithChirp
}

enum class eSettingsDL_SetRemoteInVehicleReminder {
    SETTINGS_DOORLOCK_RemoteInVehicleReminder_Off,
    SETTINGS_DOORLOCK_RemoteInVehicleReminder_On
}

enum class eSettingsDL_SetRemoteRemovedFromVehicleAlert {
    SETTINGS_DOORLOCK_REMOTEREMOVEDFROMVEHICLEALERT_OFF,
    SETTINGS_DOORLOCK_REMOTEREMOVEDFROMVEHICLEALERT_ON
}

enum class eSettingsDL_SetRemoteSlidingDoor {
    SETTINGS_DOORLOCK_SetRemoteSlidingDoor_Courtesy,
    SETTINGS_DOORLOCK_SetRemoteSlidingDoor_Security
}

enum class eSettingsClimateAutoDefog {
    SETTINGS_CLIMATE_AUTO_DEFOG_OFF,
    SETTINGS_CLIMATE_AUTO_DEFOG_ON
}

enum class eSettingsClimateAutoRearDefog {
    SETTINGS_CLIMATE_REAR_DEFOG_MANUAL,
    SETTINGS_CLIMATE_REAR_DEFOG_AUTO
}

enum class eSettingsClimateElevatedIdleCustomization {
    SETTINGS_CLIMATE_ELEVATED_IDLE_UNKNOWN,
    SETTINGS_CLIMATE_ELEVATED_IDLE_DISABLED,
    SETTINGS_CLIMATE_ELEVATED_IDLE_ENABLED
}

enum class eEngineAssistedHeatingSetting {
    SETTINGS_CLIMATE_ENGINEASSISTEDHEATING_DEFERRED,
    SETTINGS_CLIMATE_ENGINEASSISTEDHEATING_ON
}

enum class eEngineAssistedHeatingPluggedInSetting {
    SETTINGS_CLIMATE_ENGINEASSISTEDHEATINGPLUGGEDIN_OFF,
    SETTINGS_CLIMATE_ENGINEASSISTEDHEATINGPLUGGEDIN_ON
}

enum class eSettingsClimateAutoFanSpeed {
    SETTINGS_CLIMATE_AUTO_FAN_SPEED_LOW,
    SETTINGS_CLIMATE_AUTO_FAN_SPEED_MEDIUM,
    SETTINGS_CLIMATE_AUTO_FAN_SPEED_HIGH
}

enum class eSettingsClimateAutoAirDistribution {
    SETTINGS_CLIMATE_DIRECT_AIRFLOW,
    SETTINGS_CLIMATE_DIFFUSE_AIRFLOW
}

enum class eSettingsClimateAutoAirDistribution1 {
    SETTINGS_CLIMATE_DIRECT1_AIRFLOW,
    SETTINGS_CLIMATE_DIFFUSE1_AIRFLOW,
    SETTINGS_CLIMATE_NORMAL_AIRFLOW,
    SETTINGS_CLIMATE_OSCILLATING_AIRFLOW
}

enum class eSettingsClimateAirQualitySensor {
    SETTINGS_CLIMATE_AIRQUALITYSENSOR_OFF,
    SETTINGS_CLIMATE_AIRQUALITYSENSOR_LOW,
    SETTINGS_CLIMATE_AIRQUALITYSENSOR_HIGH
}

enum class eSettingsClimatePollutionControl {
    SETTINGS_CLIMATE_POLLUTION_CONTROL_OFF,
    SETTINGS_CLIMATE_POLLUTION_CONTROL_ON
}

enum class eSettingsClimateAutoCooledSeats {
    SETTINGS_CLIMATE_AUTO_COOLEDSEATS_OFF,
    SETTINGS_CLIMATE_AUTO_COOLEDSEATS_ON
}

enum class eSettingsClimateAutoHeatedSeats {
    SETTINGS_CLIMATE_AUTO_HEATEDSEATS_OFF,
    SETTINGS_CLIMATE_AUTO_HEATEDSEATS_ON
}

enum class eSettingsClimateRearZoneStartup {
    SETTINGS_CLIMATE_REAR_ON_STARTUP_REAR_OFF,
    SETTINGS_CLIMATE_REAR_ON_STARTUP_REAR_MIMIC_FRONT,
    SETTINGS_CLIMATE_REAR_ON_STARTUP_REAR_LAST_KNOWN
}

enum class eSpeedLimitStatus {
    SETTINGS_SPD_LIMIT_STATUS_NO_ACTION,
    SETTINGS_SPD_LIMIT_STATUS_OFF,
    SETTINGS_SPD_LIMIT_STATUS_ON
}

enum class eOverspeedWarningCurrentStatus {
    SETTINGS_OVRSPD_WARNING_STATUS_NO_ACTION,
    SETTINGS_OVRSPD_WARNING_STATUS_OFF,
    SETTINGS_OVRSPD_WARNING_STATUS_ON
}

enum class eTeenDriverKeyConfigurationType {
    TEENDRIVER_KEYCONFIGURATION_TRADITIONALKEY,
    TEENDRIVER_KEYCONFIGURATION_KEYLESSTRANSMITTER
}

enum class eTeenDriverTraditionalKeyConfigStatus {
    TEENDRIVER_TRADITIONALKEY_CONFIGURED,
    TEENDRIVER_TRADITIONALKEY_NOT_CONFIGURED
}

enum class eTeenDriverKeylessConfigStatus {
    TEENDRIVER_KEYLESS_CONFIGURED,
    TEENDRIVER_KEYLESS_NOT_CONFIGURED
}

enum class eTeenDriverKeylessTransmitterPresent {
    TEENDRIVER_KEYLESSTRANSMITTER_PRESENT,
    TEENDRIVER_KEYLESSTRANSMITTER_NOT_PRESENT
}

enum class eSPVolumeGroup {
    SP_VG_NONE,
    SP_VG_MAIN,
    SP_VG_PHONE,
    SP_VG_EMERGENCY_PHONE,
    SP_VG_PROMPT,
    SP_VG_RING_TONE,
    SP_VG_ALERT,
    SP_VG_AUDIO_CUE,
    SP_VG_CHIME,
    SP_VG_TEENDRIVER,
    SP_VG_ANDROIDAUTO,
    SP_VG_CARPLAY
}

enum class eSPAMPDSPMode {
    SP_DSP_MODE_Normal,
    SP_DSP_MODE_Driver,
    SP_DSP_MODE_Rear,
    SP_DSP_MODE_Centerpoint
}

enum class eTeenDriverAvailibilty {
    TEENDRIVER_NOT_AVAILABLE,
    TEENDRIVER_AVAILABLE
}

enum class eSettingsClimateIonizer {
    SETTINGS_CLIMATE_IONIZER_OFF,
    SETTINGS_CLIMATE_IONIZER_ON
}

enum class eSettingsDL_SetRemoteStartAutoCoolSeats {
    SETTINGS_DOORLOCK_REMOTESTARTAUTOCOOLSEATS_OFF,
    SETTINGS_DOORLOCK_REMOTESTARTAUTOCOOLSEATS_ON
}


//below lines are not belongs to low radio
/**
 * Home page tabs (System, Apps, Vehicle, Personal)
 */
enum class SETTINGS_CURRENT_HOME_PAGE(val value: Number) {
    SETTING_SYSTEM_VIEW(0),
    SETTING_VEHICLE_VIEW(1),
    SETTING_APPS_VIEW(2)
    // SETTING_CONFIGURATION_VIEW(3)

    // SETTING_PERSONAL_VIEW(3)


}

enum class eLHD_RHD_RTL(val value: Number) {
    LHD(0) {
        override fun toString(): String {
            return "LHD"
        }
    },
    RHD(1) {
        override fun toString(): String {
            return "RHD"
        }
    },
    RTL(2) {
        override fun toString(): String {
            return "RTL"
        }
    }
}

/**
 * return language type as English,Français,Español
 */
enum class ESettingsLanguageType(i: Int) {
    SETTINGS_LANGUAGE_SELECTION_NA_ENGLISH(0) {
        override fun toString(): String {
            return "English"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_GERMAN(1) {
        override fun toString(): String {
            return "Français "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_SPAN(2) {
        override fun toString(): String {
            return "Español"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_DUTCH(3) {
        override fun toString(): String {
            return "Deutsch"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_UK_ENGLISH(4) {
        override fun toString(): String {
            return "English "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_ITALIAN(5) {
        override fun toString(): String {
            return "Italiano"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_SPANISH(6) {
        override fun toString(): String {
            return "Español "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_FRENCH(7) {
        override fun toString(): String {
            return "Français"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_NORWEGIAN(8) {
        override fun toString(): String {
            return "中文"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_FINNISH(9) {
        override fun toString(): String {
            return "Русский"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_DANISH(10) {
        override fun toString(): String {
            return "Nederlands"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_GREEK(11) {
        override fun toString(): String {
            return "Türkçe"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_JAPANESE(12) {
        override fun toString(): String {
            return "Polski"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_PORTUGUESE(13) {
        override fun toString(): String {
            return "Português "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_STANDARD_CHINESE(14) {
        override fun toString(): String {
            return "한국어"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_ARABIC(15) {
        override fun toString(): String {
            return "العربية "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_TURKISH(16) {
        override fun toString(): String {
            return "Ελληνικά"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_KOREAN(17) {
        override fun toString(): String {
            return "Svenska"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_ZA_ENGLISH(18) {
        override fun toString(): String {
            return "English  "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_HUNGARIAN(19) {
        override fun toString(): String {
            return "Magyar"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_POLISH(20) {
        override fun toString(): String {
            return "Português"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_English(21) {
        override fun toString(): String {
            return "English   "
        }
    },
    SETTINGS_LANGUAGE_SELECTION_SLOVAK(22) {
        override fun toString(): String {
            return "Dansk"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_RUSSIAN(23) {
        override fun toString(): String {
            return "Română"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_BRAZIL(24) {
        override fun toString(): String {
            return "Norsk"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_THAILAND(25) {
        override fun toString(): String {
            return "Suomi"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_BULGARIAN(26) {
        override fun toString(): String {
            return "Hrvatski"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_ROMANIAN(27) {
        override fun toString(): String {
            return "Slovenščina"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_SLOV(28) {
        override fun toString(): String {
            return "ไท"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_SLOVENIAN(29) {
        override fun toString(): String {
            return "ไทย"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_UKRAINIAN(30) {
        override fun toString(): String {
            return "Čeština"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_FRENCH_CANADIAN(31) {
        override fun toString(): String {
            return "Slovenčina"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_NORTH_AMERICAN_SPANISH(32) {
        override fun toString(): String {
            return "български"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_NORTH_AMERICAN_CROATIAN(33) {
        override fun toString(): String {
            return "Українська"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_NORTH_AMERICAN_BULGARIAN(34) {
        override fun toString(): String {
            return "Srpski"
        }
    },
    SETTINGS_LANGUAGE_SELECTION_NORTH_AMERICAN_SERBIAN(35) {
        override fun toString(): String {
            return "日本語"
        }
    },
}

enum class ESettingsChangePerfModeSound(i: Int) {
    SETTINGS_DRIVERMODE_ENGINESOUND_DEFAULT(0) {
        override fun toString(): String {
            return ""
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_AUTO(1) {
        override fun toString(): String {
            return "Auto"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH(2) {
        override fun toString(): String {
            return "Stealth"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_CITY(3) {
        override fun toString(): String {
            return "City"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_TOUR(4) {
        override fun toString(): String {
            return "Tour"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_SPORT(5) {
        override fun toString(): String {
            return "Sport"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_TRACK(6) {
        override fun toString(): String {
            return "Track"
        }
    },
    SETTINGS_DRIVERMODE_ENGINESOUND_OFF(7) {
        override fun toString(): String {
            return "OFF"
        }
    },
}

enum class ESettingsSteeringCustomization(i: Int) {
    SETTINGS_DRIVERMODE_STEERING_DEFAULT(0) {
        override fun toString(): String {
            return ""
        }
    },
    SETTINGS_DRIVERMODE_STEERING_AUTO(1) {
        override fun toString(): String {
            return "Auto"
        }
    },
    SETTINGS_DRIVERMODE_STEERING_ECO(2) {
        override fun toString(): String {
            return "Eco"
        }
    },
    SETTINGS_DRIVERMODE_STEERING_CITY(3) {
        override fun toString(): String {
            return "City"
        }
    },
    SETTINGS_DRIVERMODE_STEERING_TOUR(4) {
        override fun toString(): String {
            return "Tour"
        }
    },
    SETTINGS_DRIVERMODE_STEERING_SPORT(5) {
        override fun toString(): String {
            return "Sport"
        }
    },
    SETTINGS_DRIVERMODE_STEERING_TRACK(6) {
        override fun toString(): String {
            return "Track"
        }
    }
}

enum class ESettingsSuspensionCustomization(i: Int) {
    SETTINGS_DRIVERMODE_SUSPENSION_DEFAULT(0) {
        override fun toString(): String {
            return ""
        }
    },
    SETTINGS_DRIVERMODE_SUSPENSION_AUTO(1) {
        override fun toString(): String {
            return "Auto"
        }
    },
    SETTINGS_DRIVERMODE_SUSPENSION_TOUR(2) {
        override fun toString(): String {
            return "Tour"
        }
    },
    SETTINGS_DRIVERMODE_SUSPENSION_SPORT(3) {
        override fun toString(): String {
            return "Sport"
        }
    },
    SETTINGS_DRIVERMODE_SUSPENSION_TRACK(4) {
        override fun toString(): String {
            return "Track"
        }
    }
}

enum class ESettingsTractionCustomization(i: Int) {
    SETTINGS_DRIVERMODE_TRACTION_DEFAULT(0) {
        override fun toString(): String {
            return ""
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_AUTO(1) {
        override fun toString(): String {
            return "Auto"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER(2) {
        override fun toString(): String {
            return "Snow / Ice / Weather"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_ECO(3) {
        override fun toString(): String {
            return "Eco"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_TOUR(4) {
        override fun toString(): String {
            return "Tour"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_SPORT(5) {
        override fun toString(): String {
            return "Sport"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_TRACK(6) {
        override fun toString(): String {
            return "Track"
        }
    },
    SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF(7) {
        override fun toString(): String {
            return "Traction Assist Off"
        }
    }
}