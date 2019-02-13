package com.gm.settingsservice.models


data class GlobalSettingsAvailibilityFlag_t(var rearSeatReminderFlag: Int = 0,
                                            var drivingModeFlag: Int = 0,
                                            var sportsModeCustomizationFlag: Int = 0,
                                            var autoModeCustomizationFlag: Int = 0,
                                            var collisionDetectionFlag: Int = 0,
                                            var comfortConvenienceFlag: Int = 0,
                                            var lightingFlag: Int = 0,
                                            var energyFlag: Int = 0,
                                            var powerTakeoffFlag: Int = 0)


data class SettingsAvailibilityFlag_t(var settingsAdaptiveForwardLightingFlag: Int = 0,
                                      var SettingsAdaptiveForwardLighting1Flag: Int = 0,
                                      var settingsAdaptiveForwardLightingWithGPSFlag: Int = 0,
                                      var settingsAdaptiveHighBeamAssistFlag: Int = 0,
                                      var settingsAdaptiveHighBeamAssistWithSensitivityFlag: Int = 0,
                                      var settingsAutoHighBeamAssistFlag: Int = 0,
                                      var settingsAutoHighBeamAssistWithSensitivityFlag: Int = 0,
                                      var settingsCollisionDetectionAlertTypeFlag: Int = 0,
                                      var settingsCollisionDetectionConnectedVehicleBrakingAlertsFlag: Int = 0,
                                      var settingsCollisionDetectionIntersectionStopAlertFlag: Int = 0,
                                      var settingsCollisionDetectionRearCameraParkAssistFlag: Int = 0,
                                      var settingsCollisionDetectionTrafficRoadSideInformationFlag: Int = 0,
                                      var settingsDaytimeTailLightsFlag: Int = 0,
                                      var settingsDriverDrowsinessDetectionCustomizationFlag: Int = 0,
                                      var settingsFrontPedestrianDetectionCustomizationFlag: Int = 0,
                                      var settingsGoNotifierCustomizationFlag: Int = 0,
                                      var settingsLaneChangeAlertFlag: Int = 0,
                                      var settingsLeftRightHandTrafficFlag: Int = 0,
                                      var settingsLeftRightHandTrafficWithGPSFlag: Int = 0,
                                      var settingsParkAssistFlag: Int = 0,
                                      var settingsParkAssistWithTowbarFlag: Int = 0,
                                      var settingsPedestrianFriendlyAlertFlag: Int = 0,
                                      var settingsRearPedestrianDetectionCustomizationFlag: Int = 0,
                                      var settingsSeatBeltTighteningCustomizationFlag: Int = 0,
                                      var settingsSideBlindZoneAlertFlag: Int = 0,
                                      var SettingsChangePerfModeSoundCustomizationFlag: Int = -1,
                                      var settingsSteeringCustomizationFlag: Int = -1,
                                      var settingsSuspensionCustomizationFlag: Int = -1,
                                      var settingsTractionCustomizationFlag: Int = -1,
                                      var settingstRearCrossTrafficAlertFlag: Int = 0,
                                      var setttingForwardCollisionAlertCustomizationFlag: Int = 0,
                                      var engineRunActiveSettingFlag: Int = 0,
                                      var settingsAutomaticVehicleHoldFlag: Int = 0,
                                      var settingsAutoMemoryRecallFlag: Int = 0,
                                      var settingsAutoMemoryRecall1Flag: Int = 0,
                                      var settingsAutoMemoryRecall2Flag: Int = 0,
                                      var settingsAutoMirrorFoldingFlag: Int = 0,
                                      var settingsAutoWipeinReverseGearFlag: Int = 0,
                                      var settingsEasyExitDriverSeatFlag: Int = 0,
                                      var settingsEasyExitOptionsFlag: Int = 0,
                                      var settingsEasyExitSteeringColumn1Flag: Int = 0,
                                      var settingsEasyExitSteeringColumn2Flag: Int = 0,
                                      var settingsExitLightingFlag: Int = 0,
                                      var settingsPersonalizationbyDriverFlag: Int = 0,
                                      var settingsRainSenseWipersFlag: Int = 0,
                                      var settingsReverseTiltMirrorFlag: Int = 0,
                                      var settingsReverseTiltMirror1Flag: Int = 0,
                                      var settingsReverseTiltMirror2Flag: Int = 0,
                                      var settingsSmartHighBeamAssistFlag: Int = 0,
                                      var settingsSurroundViewLightingFlag: Int = 0,
                                      var settingsTrunkControlFlag: Int = 0,
                                      var settingsVehicleLocatorLightsFlag: Int = 0,
                                      var settingsEasyExitSteeringColumnFlag: Int = 0,
                                      var settingsPerfModeDisplayCustomizationFlag: Int = 0,
                                      var settingsSportModeSportAdaptiveCruiseControlFlag: Int = 0,
                                      var settingsSportModeSportAWDFlag: Int = 0,
                                      var settingsSportModeSportDisplaysFlag: Int = 0,
                                      var settingsSportModeSportDriverSeatFlag: Int = 0,
                                      var settingsSportModeSportPassengerSeatFlag: Int = 0,
                                      var settingsSportModeSportSteeringFlag: Int = 0,
                                      var settingsSportModeSportSuspensionFlag: Int = 0,
                                      var driverSeatBeltAttachedValidityFlag: Int = 0,
                                      var passengerSeatBeltAttachedValidityFlag: Int = 0,
                                      var settingsEnergyLocationBasedChargingFlag: Int = 0,
                                      var settingsEnergySummaryPopupFlag: Int = 0,
                                      var settingsEnergyChargeStatusFeedbackFlag: Int = 0,
                                      var settingsEnergyChargeCordTheftAlertFlag: Int = 0,
                                      var settingsEnergyChargePowerLossAlertFlag: Int = 0,
                                      var settingsPowerTakeOffStandbySpeedFlag: Int = 0,
                                      var settingsPowerTakeOffSet1SpeedFlag: Int = 0,
                                      var settingsPowerTakeOffSet2SpeedFlag: Int = 0,
                                      var settingsPowerTakeOffTapStepSpeedFlag: Int = 0,
                                      var settingsPowerTakeOffShutdownTimeFlag: Int = 0)


data class SettingsLocationBasedCharging_t(
        var flag: Int,
        var locationBasedCharging: eSettingsLocationBasedCharging
)

data class SettingsEnergySummaryPopup_t(
        var flag: Int,
        var energySummaryPopup: eSettingsEnergySummaryPopup
)
data class SettingsDriverStatus(var enginesound: Int = 0,
                                var steering: Int = 0,
                                var suspension: Int = 0,
                                var traction: Int = 0)

data class SettingsChargeStatusFeedback_t(var flag: Int, var chargeStatusFeedback: eSettingsChargeStatusFeedback)
data class SettingsChargeCordTheftAlert_t(var flag: Int, var chargeCordTheftAlert: eSettingsChargeCordTheftAlert)
data class SettingsChargePowerLossAlert_t(var flag: Int, var chargePowerLossAlert: eSettingsChargePowerLossAlert)
data class SettingsStandBySpeed_t(var flag: Int, var standBySpeed: eSettingsStandBySpeed)
data class SettingsSet1Speed_t(var flag: Int, var set1Speed: eSettingsSet1Speed)
data class SettingsSet2Speed_t(var flag: Int, var set2Speed: eSettingsSet2Speed)
data class SettingsShutDownTime_t(var flag: Int, var shutDownTime: eSettingsShutDownTime)
data class SettingsCollisionDetectionAlertType_t(var SettingAvailableFlag: Int, var AlertTypeCustomizationSetting: eSettingsCollisionDetectionAlertType)
data class SettingsAdaptiveHighBeamAssistWithSensitivity_t(var SettingAvailableFlag: Int, var AdaptiveHighBeamAssistWithSensitivity: eSettingsAdaptiveHighBeamAssistWithSensitivity)
data class SettingsAdaptiveHighBeamAssist_t(var SettingAvailableFlag: Int, var AutoHighBeamAssistWithSensitivity: eSettingsAutoHighBeamAssistWithSensitivity)
data class SettingsAdaptiveForwardLightingWithGPS_t(var SettingAvailableFlag: Int, var AdaptiveForwardLightingWithGPS: eSettingsAdaptiveForwardLightingWithGPS)
data class SettingsTapStepSpeed_t(var flag: Int, var tapStepSpeed: eSettingsTapStepSpeed)
data class SettingsAdaptiveForwardLighting1_t(var SettingAvailableFlag: Int, var AdaptiveForwardLighting: eSettingsAdaptiveForward1Lighting)
data class SettingsAdaptiveForwardLighting_t(var SettingAvailableFlag: Int, var AdaptiveForwardLighting: eSettingsAdaptiveForwardLighting)
data class SettingsAutoHighBeamAssist_t(var SettingAvailableFlag: Int, var AutoHighBeamAssist: eSettingsAutoHighBeamAssist)
data class SettingsAutoHighBeamAssistWithSensitivity_t(var SettingAvailableFlag: Int, var AutoHighBeamAssistWithSensitivity: eSettingsAutoHighBeamAssistWithSensitivity)
data class SettingsAutoMemoryRecall1_t(var flag: Int, var autoMemoryRecall1: eSettingsAutoMemoryRecall1)
data class SettingsAutoMemoryRecall2_t(var flag: Int, var autoMemoryRecall2: eSettingsAutoMemoryRecall2)

data class SettingsAutoMemoryRecall_t(var flag: Int, var value: eSettingsAutoMemoryRecall)
data class SettingsAutoMirrorFolding_t(var flag: Int, var value: eSettingsAutoMirrorFolding)
data class SettingsAutoTimeUpdateSetting_t(var autoTimeUpdateSettingEnum: eSettingsAutoTimeDateUpdateSetting,
                                           var autoRDSUpdateOptionEnabled: Int, var autoTimePhoneUpdateOptionEnabled: Int)

data class SettingsAutoWipeinReverseGear_t(var flag: Int, var value: eSettingsAutoWipeinReverseGear)
data class SettingsAutomaticVehicleHold_t(var flag: Int, var value: eSettingsAutomaticVehicleHold)
data class SettingsExtendedHillStartAssist_t(var flag: Int, var value: Int)

data class SettingsDaytimeTailLights_t(var SettingAvailableFlag: Int, var DaytimeTailLights: eSettingsDaytimeTailLights)
data class SettingsDriverDrowsinessDetectionCustomization_t(var SettingAvailableFlag: Int,
                                                            var DriverDrowsinessDetectionCustomizationSetting: eSettingsDriverDrowsinessDetectionCustomization)

data class SettingsDriverModeStatus_t(var DriverSelectedMode1Status: ESettingsChangePerfModeSound = ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_DEFAULT,
                                      var DriverSelectedMode2Status: ESettingsSteeringCustomization = ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_DEFAULT,
                                      var DriverSelectedMode3Status: ESettingsSuspensionCustomization = ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_DEFAULT,
                                      var DriverSelectedMode4Status: ESettingsTractionCustomization = ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_DEFAULT)

data class SettingsEasyExitDriverSeat_t(var flag: Int, var value: eSettingsEasyExitDriverSeat)
data class SettingsEasyExitOptions_t(var flag: Int, var value: eSettingsEasyExitOptions)
data class SettingsEasyExitSteeringColumn1_t(var flag: Int, var value: eSettingsEasyExitSteeringColumn1)
data class SettingsEasyExitSteeringColumn2_t(var flag: Int, var value: eSettingsEasyExitSteeringColumn2)
data class SettingsEasyExitSteeringColumn_t(var flag: Int, var value: eSettingsEasyExitSteeringColumn)
data class EngineRunActiveSetting_t(var flag: Int, var value: eEngineRunActiveSetting)
data class SettingsExitLighting_t(var flag: Int, var value: eSettingsExitLighting)
data class SetttingForwardCollisionAlertCustomization_t(var SettingAvailableFlag: Int,
                                                        var ForwardCollisionAlertCustomizationSettings: eSettingForwardCollisionAlert)

data class SettingsFrontPedestrianDetectionCustomization_t(var SettingAvailableFlag: Int,
                                                           var FrontPedestrianDetectionCustomizationSetting: eSettingsFrontPedestrianDetection)

data class SettingsGoNotifierCustomization_t(var SettingAvailableFlag: Int,
                                             var GoNotifierCustomizationSettings: eSettingGoNotifierCustomization)

data class SettingsCollisionDetectionIntersectionStopAlert_t(var SettingAvailableFlag: Int,
                                                             var IntersectionStopAlertCustomizationSetting: eSettingsCollisionDetectionIntersectionStopAlert)


data class SettingsLaneChangeAlert_t(var ValidityFlag: Int, var LaneChangeAlertSettingValue: eSettingsLaneChangeAlert)

data class SettingsLeftRightHandTraffic_t(var SettingAvailableFlag: Int, var LeftRightHandTraffic: eSettingsLeftRightHandTraffic)
data class SettingsLeftRightHandTrafficWithGPS_t(var SettingAvailableFlag: Int, var LeftRightHandTrafficWithGPS: eSettingsLeftRightHandTrafficWithGPS)
data class SettingsParkAssist_t(var ValidityFlag: Int, var ParkAssistSettingValue: eSettingsParkingAssist)
data class SettingsParkAssistWithTowbar_t(var ValidityFlag: Int, var ParkAssistWithTowbarSettingValue: eSettingsParkAssistWithTowbar)
data class SettingsPedestrianFriendlyAlert_t(var SettingAvailableFlag: Int, var PedestrianFriendlyAlertCustomizationSetting: eSettingsPedestrianFriendlyAlert)
data class SettingsPerfModeDisplayCustomization_t(var flag: Int, var value: eSettingsPerfModeDisplayCustomization)
data class SettingsChangePerfModeSoundCustomization_t(var SettingAvailableFlag: Int, var PerfModeSoundCustomizationSettings: ESettingsChangePerfModeSound)
data class SettingsSteeringCustomization_t(var SettingAvailableFlag: Int, var SteeringCustomizationSettings: ESettingsSteeringCustomization)
data class SettingsPersonalizationbyDriver_t(var flag: Int, var value: eSettingsPersonalizationbyDriver)
data class SettingsRainSenseWipers_t(var flag: Int, var value: eSettingsRainSenseWipers)
data class SettingsCollisionDetectionRearCameraParkAssist_t(var SettingAvailableFlag: Int,
                                                            var RearCameraParkAssistCustomizationSettings: eSettingsCollisionDetectionRearCameraParkAssist)

data class SettingstRearCrossTrafficAlert_t(var ValidityFlag: Int, var RearCrossTrafficAlertSettingValue: eSettingsRearCrossTrafficAlert)
data class SettingsRearPedestrianDetectionCustomization_t(var SettingAvailableFlag: Int, var RearPedestrianDetectionCustomizationSetting: eSettingsRearPedestrianDetection)
data class SettingsRearSeatReminder_t(var SettingAvailableFlag: Int, var RearSeatReminderCustomizationSetting: eSettingsRearSeatReminder)
data class SettingsReverseTiltMirror1_t(var flag: Int, var value: eSettingsReverseTiltMirror1)
data class SettingsReverseTiltMirror2_t(var flag: Int, var value: eSettingsReverseTiltMirror2)
data class SettingsReverseTiltMirror_t(var flag: Int, var value: eSettingsReverseTiltMirror)
data class SettingsSeatBeltAttachedStatus_t(var driverSeatBeltAttached: Int, var driverSeatBeltAttachedValidityFlag: Int,
                                            var passengerSeatBeltAttached: Int, var passengerSeatBeltAttachedValidityFlag: Int)

data class SettingsSeatBeltTighteningCustomization_t(var SettingAvailableFlag: Int, var SeatBeltTighteningCustomizationSettings: eSettingsSeatBeltTightening)
data class SettingsSideBlindZoneAlert_t(var ValidityFlag: Int, var SideBlindZoneAlertSettingValue: eSettingsSideBlindZoneAlert)
data class SettingsSmartHighBeamAssist_t(var flag: Int, var value: eSettingsSmartHighBeamAssist)
data class SettingsSportAutoModeCustomizations_t(var SettingAvailableFlag: Int, var SportAutoModeCustomizations: eSettingsSportAutoModeCustomizations)
data class SettingsSportModeSportAWD_t(var flag: Int, var SportModeSportAWDFlag: Int)


data class SettingsSportModeSportAdaptiveCruiseControl_t(var flag: Int, var SportModeSportAdaptiveCruiseControlFlag: Int)

data class SettingsSportModeSportDisplays_t(var flag: Int, var SportModeSportDisplaysFlag: Int)
data class SettingsSportModeSportDriverSeat_t(var flag: Int, var SportModeSportDriverSeatFlag: Int)
data class SettingsSportModeSportPassengerSeat_t(var flag: Int, var SportModeSportPassengerSeatFlag: Int)
data class SettingsSportModeSportSteering_t(var flag: Int, var SportModeSportSteeringFlag: Int)

data class SettingsSportModeSportSuspension_t(var flag: Int, var SportModeSportSuspensionFlag: Int)

data class SettingsSurroundViewLighting_t(var flag: Int, var SportModeSportAWDFlag: Int)
data class SettingsSuspensionCustomization_t(var SettingAvailableFlag: Int, var SuspensionCustomizationSettings: ESettingsSuspensionCustomization)

data class SettingsTractionCustomization_t(var SettingAvailableFlag: Int, var TractionCustomizationSettings: ESettingsTractionCustomization)
data class SettingsCollisionDetectionTrafficRoadSideInformation_t(var SettingAvailableFlag: Int,
                                                                  var TrafficRoadSideInformationCustomizationSetting: eSettingsCollisionDetectionTrafficRoadSideInformation)

data class SettingsTrunkControl_t(var flag: Int, var value: eSettingsTrunkControl)
data class SettingsCollisionDetectionConnectedVehicleBrakingAlerts_t(var SettingAvailableFlag: Int,
                                                                     var ConnectedVehicleBrakingAlertsCustomizationSetting: eSettingsCollisionDetectionConnectedVehicleBrakingAlerts)

data class SettingsVehicleLocatorLights_t(var flag: Int, var value: eSettingsVehicleLocatorLights)
data class SettingsInitialization_t(var timeInfoHour: Int, var timeInfoMinute: Int, var timeInfoMeridiem: eSettingsTimeMeridiem,
                                    var timeDisplayFormat: eSettingsTimeDisplayFormat, var autoTimeUpdateRdsOption: Int,
                                    var autoTimeUpdatePhoneOption: Int, var autoTimeUpdateSetting: eSettingsAutoTimeDateUpdateSetting,
                                    var locationServicesSetting: eSettingsPrivacyLocationServices, var displayModeType: eSettingsdisplayMode,
                                    var CalendarDay: Int, var CalendarMonth: Int, var CalendarYear: Int, var driverSeatBeltAttached: Int,
                                    var passengerSeatBeltAttached: Int)


data class SettingsDL_SetUnlock_t(var flag: Int, var value: eSettingsDL_SetUnlock)
data class SettingsDL_LastDoorClosedLocking_t(var flag: Int, var value: eSettingsDL_LastDoorClosedLocking)
data class SettingsDL_SetOpenDoorAntiLockOut_t(var flag: Int, var value: eSettingsDL_SetOpenDoorAntiLockOut)
data class SettingsDL_SetAutoLock_t(var flag: Int, var value: eSettingsDL_SetAutoLock)
data class SettingsDL_SetRemoteUnlocklLightingFeedback_t(var flag: Int, var value: eSettingsDL_SetRemoteUnlocklLightingFeedback)
data class SettingsDL_SetRemoteLockingFeedback_t(var flag: Int, var value: eSettingsDL_SetRemoteLockingFeedback)
data class SettingsDL_SetSelectiveUnlocking_t(var flag: Int, var value: eSettingsDL_SetSelectiveUnlocking)
data class SettingsDL_SetRelockRemoteUnlockedDoor_t(var flag: Int, var value: eSettingsDL_SetRelockRemoteUnlockedDoor)
data class SettingsDL_SetRemoteStart_t(var flag: Int, var value: eSettingsDL_SetRemoteStart)
data class SettingsDL_SetRemoteStartAutoCoolSeats_t(var flag: Int, var value: eSettingsDL_SetRemoteStartAutoCoolSeats)
data class SettingsDL_SetRemoteStartAutoCoolSeatsSettings_t(var flag: Int, var value: eSettingsDL_SetRemoteStartAutoCoolSeatsSettings)
data class SettingsDL_SetRemoteStartAutoHeatSeats_t(var flag: Int, var value: eSettingsDL_SetRemoteStartAutoHeatSeats)
data class SettingsDL_SetRemoteStartAutoHeatSeatsSettings_t(var flag: Int, var value: eSettingsDL_SetRemoteStartAutoHeatSeatsSettings)
data class SettingsDL_SetRemoteWindowOperation_t(var flag: Int, var value: eSettingsDL_SetRemoteWindowOperation)
data class SettingsDL_SetPassiveUnlock_t(var flag: Int, var value: eSettingsDL_SetPassiveUnlock)
data class SettingsDL_SetPassiveLock_t(var flag: Int, var value: eSettingsDL_SetPassiveLock)
data class SettingsDL_SetRemoteInVehicleReminder_t(var flag: Int, var value: eSettingsDL_SetRemoteInVehicleReminder)
data class SettingsDL_SetRemoteRemovedFromVehicleAlert_t(var flag: Int, var value: eSettingsDL_SetRemoteRemovedFromVehicleAlert)
data class SettingsDL_SetRemoteSlidingDoor_t(var flag: Int, var value: eSettingsDL_SetRemoteSlidingDoor)
data class SettingsClimateAutoDefog_t(var ValidityFlag: Int, var AutoDefogValue: eSettingsClimateAutoDefog)

data class SettingsClimateAutoRearDefog_t(var ValidityFlag: Int, var AutoDefogValue: eSettingsClimateAutoRearDefog)

data class SettingsClimateElevatedIdleCustomization_t(var SettingAvailableFlag: Int, var ElevatedIdleCustomizationSetting: eSettingsClimateElevatedIdleCustomization)

data class SettingsClimateIonizer_t(var ValidityFlag: Int, var IonizerSettingValue: eSettingsClimateIonizer)

data class EngineAssistedHeatingSetting_t(var flag: Int, var value: eEngineAssistedHeatingSetting)
data class EngineAssistedHeatingPluggedInSetting_t(var flag: Int, var value: eEngineAssistedHeatingPluggedInSetting)

data class SettingsClimateAutoFanSpeed_t(var ValidityFlag: Int, var AutoFanSpeedValue: eSettingsClimateAutoFanSpeed)


data class SettingsClimateAutoAirDistribution_t(var ValidityFlag: Int, var AutoAirDistrSettingValue: eSettingsClimateAutoAirDistribution)
data class SettingsClimateAutoAirDistribution1_t(var ValidityFlag: Int, var AutoAirDistrSettingValue: eSettingsClimateAutoAirDistribution1)

data class SettingsClimateAirQualitySensor_t(var ValidityFlag: Int, var AirQualitySensorValue: eSettingsClimateAirQualitySensor)

data class SettingsClimatePollutionControlSetting_t(var ValidityFlag: Int, var PollutionControlSettingValue: eSettingsClimatePollutionControl)


data class SettingsClimateAutoCoolSeatsSettingValue_t(var ValidityFlag: Int, var AutoCoolSeatsSettingValue: eSettingsClimateAutoCooledSeats)
data class SettingsClimateAutoHeatedSeats_t(var ValidityFlag: Int, var AutoHeatedSeatsSettingValue: eSettingsClimateAutoHeatedSeats)

data class SettingsRearClimateOnStartUp_t(var ValidityFlag: Int, var RearClimateOnStartUpSettingValue: eSettingsClimateRearZoneStartup)
data class CustomizationECCAvailibilityFlag_t(var settingsClimateACModeSettingFlag: Int,
                                              var settingsClimateAirQualitySensorFlag: Int,
                                              var settingsClimateAutoAirDistributionFlag: Int,
                                              var settingsClimateAutoCoolSeatsSettingValueFlag: Int,
                                              var settingsClimateAutoDefogFlag: Int,
                                              var settingsClimateAutoFanSpeedFlag: Int,
                                              var settingsClimateAutoHeatedSeatsFlag: Int,
                                              var settingsClimateAutoRearDefogFlag: Int,
                                              var settingsClimateAutoZoneFlag: Int,
                                              var settingsClimateElevatedIdleCustomizationFlag: Int,
                                              var settingsClimateHVACRemoteStartSettingFlag: Int,
                                              var settingsClimatePollutionControlSettingFlag: Int,
                                              var settingsRearClimateOnStartUpFlag: Int,
                                              var settingsClimateAutoAirDistribution1Flag: Int,
                                              var engineAssistedHeatingPluggedInSettingFlag: Int,
                                              var engineAssistedHeatingSettingFlag: Int,
                                              var settingsClimateIonizerFlag: Int)

data class SettingsDL_AvailibilityFlag_t(
        var settingsDL_LastDoorClosedLockingFlag: Int,
        var settingsDL_SetAutoLockFlag: Int,
        var settingsDL_SetOpenDoorAntiLockOutFlag: Int,
        var settingsDL_SetPassiveLockFlag: Int,
        var settingsDL_SetPassiveUnlockFlag: Int,
        var settingsDL_SetRelockRemoteUnlockedDoorFlag: Int,
        var settingsDL_SetRemoteInVehicleReminderFlag: Int,
        var settingsDL_SetRemoteLockingFeedbackFlag: Int,
        var settingsDL_SetRemoteRemovedFromVehicleAlertFlag: Int,
        var settingsDL_SetRemoteSlidingDoorFlag: Int,
        var settingsDL_SetRemoteStartFlag: Int,
        var settingsDL_SetRemoteStartAutoCoolSeatsFlag: Int,
        var settingsDL_SetRemoteStartAutoCoolSeatsSettingsFlag: Int,
        var settingsDL_SetRemoteStartAutoHeatSeatsFlag: Int,
        var settingsDL_SetRemoteStartAutoHeatSeatsSettingsFlag: Int,
        var settingsDL_SetRemoteUnlocklLightingFeedbackFlag: Int,
        var settingsDL_SetRemoteWindowOperationFlag: Int,
        var settingsDL_SetSelectiveUnlockingFlag: Int,
        var settingsDL_SetUnlockFlag: Int)


data class GlobalSettingsDL_AvailibilityFlag_t(var powerDoorLockFlag: Int, var remoteLockFlag: Int)
data class SettingsTeenDriverReportCardData_t(
        var TeenDriverMaximumSpeedReport: Int,
        var TeenDriveDistanceDrivenReport: Int,
        var TeenDriverOverspeedEventsReport: Int,
        var TeenDriverTractionControlEventsReport: Int,
        var TeenDriverStabilityControlEventsReport: Int,
        var TeenDriverAntilockBrakeSystemActiveEventsReport: Int,
        var TeenDriverForwardCollisionHeadwayAlertsReport: Int,
        var TeenDriverForwardCollisionImminentAlertsReport: Int,
        var TeenDriverReverseCollisionMitigationBrakingEventsReport: Int,
        var TeenDriverForwardCollisionMitigationBrakingEventsReport: Int,
        var TeenDriverDrowsyDriverAlertsReport: Int,
        var TeenDriverWideOpenThrottleEventsReport: Int,
        var TeenDriverLaneDepartureWarningEventsReport: Int,
        var TeenDriverTailgatingAlertsReport: Int,
        var TeenDriverMaxSpeedAvailabilityFlag: Int,
        var TeenDriverDistanceDrivenAvailabilityFlag: Int,
        var TeenDriverOverspeedAvailabilityFlag: Int,
        var TeenDriverTractionControlAvailabilityFlag: Int,
        var TeenDriverStabilityControlAvailabilityFlag: Int,
        var TeenDriverABSActiveAvailabilityFlag: Int,
        var TeenDriverFwdCollisionHeadwayAlertAvailabilityFlag: Int,
        var TeenDriverFwdCollisionImminentAlertAvailabilityFlag: Int,
        var TeenDriverRevCollisionMitigationBrakingAvailabilityFlag: Int,
        var TeenDriverFwdCollisionMitigationBrakingAvailabilityFlag: Int,
        var TeenDriverDrowsyDriverAlertAvailabilityFlag: Int,
        var TeenDriverWideOpenThrottleAvailabilityFlag: Int,
        var TeenDriverLaneDepartureWarningAvailabilityFlag: Int,
        var TeenDriverTailgatingAlertAvailabilityFlag: Int
)

data class SettingsTeenDriverSpeedLimitCustomizationSetting_t(var SettingAvailableFlag: Int,
                                                              var SpeedLimitStatus: eSpeedLimitStatus,
                                                              var SpeedLimitDisplayValue: Int)

data class SettingsTeenDriverOverspeedWarningCustomizationSetting_t(var SettingAvailableFlag: Int,
                                                                    var OverspeedWarningCurrentStatus: eOverspeedWarningCurrentStatus,
                                                                    var OverspeedWarningCurrentSettingValue: Int)

data class TeenDriverInitialization_t(var teenDriverActive: Int,
                                      var teenDriverAvailibilityFlag: eTeenDriverAvailibilty,
                                      var configType: eTeenDriverKeyConfigurationType,
                                      var configStatus: eTeenDriverTraditionalKeyConfigStatus,
                                      var keylessConfigStatus: eTeenDriverKeylessConfigStatus,
                                      var keylessTransmitterPresent: eTeenDriverKeylessTransmitterPresent)


data class MuteRes_t(var VolumeGroup: eSPVolumeGroup, var mute: Int)
data class VolumeGroupExtent_t(var VolumeGroup: eSPVolumeGroup, var MinimumVolume: Int,
                               var MaximumVolume: Int, var CurrentVolume: Int)

data class SPVolumeGroupExtentStream_t(var volumeGroupExtentCnt: Int, var volumeGroupExtent: ArrayList<VolumeGroupExtent_t>)
data class SoundParametersModeInitialization_t
(
        var modeType: eSPAMPDSPMode,
        var bass: String,
        var balance: Int,
        var fade: Int,
        var surround: String,
        var treble: String,
        var midrange: String,
        var muteFlag: Int
)

data class SoundParametersVolumeInitialization_t
(
        var mainvolume: Int,
        var maxMainVolume: Int,
        var minMainVolume: Int,
        var phonevolume: Int,
        var maxPhoneVolume: Int,
        var minPhoneVolume: Int,
        var emergencyPhoneVolume: Int,
        var maxEmergencyPhoneVolume: Int,
        var minEmergencyPhoneVolume: Int,
        var promptVolume: Int,
        var maxPromptVolume: Int,
        var minPromptVolume: Int,
        var ringtoneVolume: Int,
        var maxRingtoneVolume: Int,
        var minRingtoneVolume: Int,
        var alertVolume: Int,
        var maxAlertVolume: Int,
        var minAlertVolume: Int,
        var audiocueVolume: Int,
        var maxAudiocueVolume: Int,
        var minAudiocueVolume: Int,
        var chimevolume: Int,
        var maxChimeVolume: Int,
        var minChimeVolume: Int,
        var maxTeendrivervolume: Int,
        var minTeendrivervolume: Int
)


// Not used
data class SettingChangeForwardCollisionAlertCustomization_t(var SenderHandle: Int, var ForwardCollisionAlertCustomizationSettings: eSettingForwardCollisionAlert)

data class SettingChangeGoNotifierCustomization_t(var SenderHandle: Int, var GoNotifierCustomizationSettings: eSettingGoNotifierCustomization)
data class SettingsChangeDriverDrowsinessDetectorCustomization_t(var SenderHandle: Int, var DriverDrowsinessDetectionCustomizationSetting: eSettingsDriverDrowsinessDetectionCustomization)
data class SettingsChangeFrontPedestrianDetectionCustomization_t(var SenderHandle: Int, var FrontPedestrianDetectionCustomizationSetting: eSettingsFrontPedestrianDetection)
data class SettingsChangePedestrianFriendlyAlert_t(var SenderHandle: Int, var PedestrianFriendlyAlertCustomizationSetting: eSettingsPedestrianFriendlyAlert)
data class SettingsChangeRearPedestrianDetection_t(var SenderHandle: Int, var RearPedestrianDetectionCustomizationSetting: eSettingsRearPedestrianDetection)
data class SettingsTractionControlSystemStatus_t(var TractionControlSystemActive: eSettingsTractionControlSystemActive,
                                                 var TractionControlSystemOperatingStatus: eSettingsTractionControlSystemOperatingStatus,
                                                 var TractionControlSystemOperatingMode: eSettingsTractionControlSystemOperatingMode)


data class settingsHomeViewer(var itemsSize: Int = 4, var currentHomePage: SETTINGS_CURRENT_HOME_PAGE = SETTINGS_CURRENT_HOME_PAGE.SETTING_SYSTEM_VIEW)

data class TimeInfo_t(
        var HourOfDay: Int,
        var MinuteOfHour: Int,
        var meridiem: eSettingsTimeMeridiem
)

data class DateInfo_t(
        var CalendarDay: Int,
        var CalendarMonth: Int,
        var CalendarYear: Int)


//for languages count and languages list
data class SettingsSupportedLanguages_t(
        var count: Int,
        var languageType: ArrayList<ESettingsLanguageType>)
