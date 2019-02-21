package com.gm.settingsservice.apiintegration.apiinterfaces

import androidx.databinding.ObservableField
import com.gm.settingsservice.models.*
import java.util.*

/**
 * To Update [DataPoolDataHandler] variables in respective methods.
 */
interface ISettingsManagerRes {
    fun onSETTINGS_RES__COMFORT_CONVENIENCE_MENU()
    fun onSETTINGS_RES_AUTOMATIC_ENTRY_EGRESS_ASSIST()
    fun SOUNDPARAMS_RES_CHIMEVOLUME()
    fun onSETTINGS_RES_POWER_LIFTGATE()
    fun onSETTINGS_RES_HANDSFREE_LIFTGATE()
    fun onSETTINGS_RES_REVERSE_TILTMIRROR()
    fun onSETTINGS_RES_REMOTE_MIRRORFOLDING()
    fun onSETTINGS_RES_RAIN_SENSE_WIPERS()
    fun onSETTINGS_RES_AUTO_WIPE_REVERSEGEAR()
    fun onSETTINGS_RES_EXTENDED_HILL_START_ASSIST()

    fun onSETTINGS_RES_VEHICLEDISPLAYUNITS(pData: Int)
    fun onSETTINGS_RES_PROPERUSEWARNING(pData: String)
    fun onSETTINGS_RES_DISPLAYSTATUS(any: Any)
    fun onSETTINGS_RES_CALIBRATION()
    fun onSETTINGS_MANAGE_RES_FAV()
    fun  onSETTINGS_RES_SETMODESTATUS(settingsDriverModeStatus_t:SettingsDriverModeStatus_t)
    fun onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(any: Any)
    fun onSETTINGS_RES_PROPERUSEWARNINGACKNOWLEDGED(pData: Int)
    fun onSETTINGS_RES_SYSTEMFAULTSTATE(pData: Int)
    fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: String)
    fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING(settingsadaptiveforwardlighting: SettingsAdaptiveForwardLighting_t)
    fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING(settingsadaptiveforwardlighting1: SettingsAdaptiveForwardLighting1_t)
    fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING(settingsadaptiveforwardlightingwithgps: SettingsAdaptiveForwardLightingWithGPS_t)
    fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsadaptivehighbeamassist: SettingsAdaptiveHighBeamAssist_t)
    fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsadaptivehighbeamassistwithsensitivity: SettingsAdaptiveHighBeamAssistWithSensitivity_t)
    fun onSETTINGS_RES_LOCATIONBASEDCHARGING(settingslocationbasedcharging: SettingsLocationBasedCharging_t)
    fun onSETTINGS_RES_ENERGYSUMMARYPOPUP(settingsenergysummarypopup: SettingsEnergySummaryPopup_t)
    fun onSETTINGS_RES_CHARGESTATUSFEEDBACK(settingschargestatusfeedback: SettingsChargeStatusFeedback_t)
    fun onSETTINGS_RES_CHARGECORDTHEFTALERT(settingschargecordtheftalert: SettingsChargeCordTheftAlert_t)
    fun onSETTINGS_RES_CHARGEPOWERLOSSALERT(settingschargepowerlossalert: SettingsChargePowerLossAlert_t)
    fun onSETTINGS_RES_STANDBYSPEED(settingsstandbyspeed: SettingsStandBySpeed_t)
    fun onSETTINGS_RES_SET1SPEED(settingsset1speed: SettingsSet1Speed_t)
    fun onSETTINGS_RES_SET2SPEED(settingsset2speed: SettingsSet2Speed_t)
    fun onSETTINGS_RES_TAPSTEPSPEED(settingstapstepspeed: SettingsTapStepSpeed_t)
    fun onSETTINGS_RES_SHUTDOWNTIME(settingsshutdowntime: SettingsShutDownTime_t)
    fun onSETTINGS_RES_ALERTTYPESETTINGS(settingscollisiondetectionalerttype: SettingsCollisionDetectionAlertType_t)


    fun onSETTINGS_RES_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsautohighbeamassist: SettingsAutoHighBeamAssist_t)
    fun onSETTINGS_RES_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsautohighbeamassistwithsensitivity: SettingsAutoHighBeamAssistWithSensitivity_t)
    fun onSETTINGS_RES_AUTOMEMORYRECALL1SETTING(settingsautomemoryrecall1: SettingsAutoMemoryRecall1_t)
    fun onSETTINGS_RES_AUTOMEMORYRECALL2SETTING(settingsautomemoryrecall2: SettingsAutoMemoryRecall2_t)
    fun onSETTINGS_RES_AUTOMEMORYRECALLSETTING(settingsautomemoryrecall: SettingsAutoMemoryRecall_t)
    fun onSETTINGS_RES_AUTOMIRRORFOLDINGSETTING(settingsautomirrorfolding: SettingsAutoMirrorFolding_t)
    fun onSETTINGS_RES_AUTOWIPEINREVERSEGEARSETTING(settingsautowipeinreversegear: SettingsAutoWipeinReverseGear_t)
    fun onSETTINGS_RES_AUTOMATICVEHICLEHOLDSETTING(settingsautomaticvehiclehold: SettingsAutomaticVehicleHold_t)
    fun onSETTINGS_RES_EXTENDEDHILLSTARTASSISTSETTING(settingsextendedhillstartassist: SettingsExtendedHillStartAssist_t)

    fun onSETTINGS_RES_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING(settingsdaytimetaillights: SettingsDaytimeTailLights_t)
    fun onSETTINGS_RES_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING(settingsdriverdrowsinessdetectioncustomization: SettingsDriverDrowsinessDetectionCustomization_t)
    fun onSETTINGS_RES_EASYEXITDRIVERSEATSETTING(settingseasyexitdriverseat: SettingsEasyExitDriverSeat_t)
    fun onSETTINGS_RES_EASYEXITOPTIONSSETTING(settingseasyexitoptions: SettingsEasyExitOptions_t)
    fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN1SETTING(settingseasyexitsteeringcolumn1: SettingsEasyExitSteeringColumn1_t)
    fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN2SETTING(settingseasyexitsteeringcolumn2: SettingsEasyExitSteeringColumn2_t)
    fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMNSETTING(settingseasyexitsteeringcolumn: SettingsEasyExitSteeringColumn_t)
    fun onSETTINGS_RES_ENGINERUNACTIVE(enginerunactivesetting: EngineRunActiveSetting_t)
    fun onSETTINGS_RES_EXITLIGHTINGCUSTOMIZATIONSETTING(settingsexitlighting: SettingsExitLighting_t)
    fun onSETTINGS_RES_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING(setttingforwardcollisionalertcustomization: SetttingForwardCollisionAlertCustomization_t)
    fun onSETTINGS_RES_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsfrontpedestriandetectioncustomization: SettingsFrontPedestrianDetectionCustomization_t)
    fun onSETTINGS_RES_GONOTIFIERCUSTOMIZATIONSETTINGS(settingsgonotifiercustomization: SettingsGoNotifierCustomization_t)
    fun onSETTINGS_RES_INTERSECTIONSTOPALERTSETTINGS(settingscollisiondetectionintersectionstopalert: SettingsCollisionDetectionIntersectionStopAlert_t)
    fun onSETTINGS_RES_LANECHANGEALERTSETTING(settingslanechangealert: SettingsLaneChangeAlert_t)
    fun onSETTINGS_RES_DISPLAYMODETYPE(eSettingsdisplayMode: eSettingsdisplayMode)
    fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING(settingsleftrighthandtraffic: SettingsLeftRightHandTraffic_t)
    fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING(settingsleftrighthandtrafficwithgps: SettingsLeftRightHandTrafficWithGPS_t)
    fun onSETTINGS_RES_LOCATIONSERVICES(pData: Int)
    fun onSETTINGS_RES_PARKASSISTSETTING(settingsparkassist: SettingsParkAssist_t)
    fun onSETTINGS_RES_PARKASSISTWITHTOWBARSETTING(settingsparkassistwithtowbar: SettingsParkAssistWithTowbar_t)
    fun onSETTINGS_RES_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING(settingspedestrianfriendlyalert: SettingsPedestrianFriendlyAlert_t)
    fun onSETTINGS_RES_PERFMODEDISPLAYCUSTOMIZATIONSETTING(settingsperfmodedisplaycustomization: SettingsPerfModeDisplayCustomization_t)
    fun onSETTINGS_RES_PERFMODESOUNDCUSTOMIZATIONSETTING(settingschangeperfmodesoundcustomization: ArrayList<ESettingsChangePerfModeSound>)
    fun onSETTINGS_RES_PERFMODESTEERINGCUSTOMIZATIONSETTINGS(settingssteeringcustomization: SettingsSteeringCustomization_t)
    fun onSETTINGS_RES_PERSONALIZATIONBYDRIVERSETTING(settingspersonalizationbydriver: SettingsPersonalizationbyDriver_t)
    fun onSETTINGS_RES_RAINSENSEWIPERSSETTING(settingsrainsensewipers: SettingsRainSenseWipers_t)
    fun onSETTINGS_RES_REARCAMERAPARKASSISTSETTINGS(settingscollisiondetectionrearcameraparkassist: SettingsCollisionDetectionRearCameraParkAssist_t)
    fun onSETTINGS_RES_REARCROSSTRAFFICALERTSETTING(settingstrearcrosstrafficalert: SettingstRearCrossTrafficAlert_t)
    fun onSETTINGS_RES_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsrearpedestriandetectioncustomization: SettingsRearPedestrianDetectionCustomization_t)
    fun onSETTINGS_RES_REARSEATREMINDERCUSTOMIZATIONSETTINGS(settingsrearseatreminder: SettingsRearSeatReminder_t)
    fun onSETTINGS_RES_REVERSETILTMIRROR1SETTING(settingsreversetiltmirror1: SettingsReverseTiltMirror1_t)
    fun onSETTINGS_RES_REVERSETILTMIRROR2SETTING(settingsreversetiltmirror2: SettingsReverseTiltMirror2_t)
    fun onSETTINGS_RES_REVERSETILTMIRRORSETTING(settingsreversetiltmirror: SettingsReverseTiltMirror_t)
    fun onSETTINGS_RES_SEATBELTATTACHEDSTATUS(settingsseatbeltattachedstatus: SettingsSeatBeltAttachedStatus_t)
    fun onSETTINGS_RES_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING(settingsseatbelttighteningcustomization: SettingsSeatBeltTighteningCustomization_t)
    fun onSETTINGS_RES_SETTINGSPERSONALDATAERASED(pData: Int)
    fun onSETTINGS_RES_SIDEBLINDZONEALERTSETTING(settingssideblindzonealert: SettingsSideBlindZoneAlert_t)
    fun onSETTINGS_RES_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingssmarthighbeamassist: SettingsSmartHighBeamAssist_t)
    fun onSETTINGS_RES_SPORTAUTOMODECUSTOMIZATIONS(settingssportautomodecustomizations: SettingsSportAutoModeCustomizations_t)
    fun onSETTINGS_RES_SPORTMODESPORTAWDSETTINGS(settingssportmodesportawd: SettingsSportModeSportAWD_t)
    fun onSETTINGS_RES_SPORTMODESPORTADAPTIVECRUISECONTROL(settingssportmodesportadaptivecruisecontrol: SettingsSportModeSportAdaptiveCruiseControl_t)
    fun onSETTINGS_RES_SPORTMODESPORTDISPLAYSETTINGS(settingssportmodesportdisplays: SettingsSportModeSportDisplays_t)
    fun onSETTINGS_RES_SPORTMODESPORTDRIVERSEAT(settingssportmodesportdriverseat: SettingsSportModeSportDriverSeat_t)
    fun onSETTINGS_RES_SPORTMODESPORTPASSENGERSEAT(settingssportmodesportpassengerseat: SettingsSportModeSportPassengerSeat_t)
    fun onSETTINGS_RES_SPORTMODESPORTSUSPENSIONSETTINGS(settingssportmodesportsuspension: ArrayList<ESettingsSuspensionCustomization>)
    fun onSETTINGS_RES_SUPPORTEDLANGUAGES(settingssupportedlanguages: SettingsSupportedLanguages_t)
    fun onSETTINGS_RES_SURROUNDVIEWLIGHTING(settingssurroundviewlighting: SettingsSurroundViewLighting_t)
    fun onSETTINGS_RES_SUSPENSIONCUSTOMIZATIONSETTINGS(settingssuspensioncustomization: SettingsSuspensionCustomization_t)

    fun onSETTINGS_RES_TRACTIONCONTROLSYSTEMSTATUS(settingstractioncustomization: ArrayList<ESettingsTractionCustomization>)
    fun onSETTINGS_RES_TRAFFICROADSIDEINFORMATIONSETTINGS(settingscollisiondetectiontrafficroadsideinformation: SettingsCollisionDetectionTrafficRoadSideInformation_t)
    fun onSETTINGS_RES_TRUNKCONTROL(settingstrunkcontrol: SettingsTrunkControl_t)
    fun onSETTINGS_RES_VEHICLEBRAKINGALERTSSETTINGS(settingscollisiondetectionconnectedvehiclebrakingalerts: SettingsCollisionDetectionConnectedVehicleBrakingAlerts_t)
    fun onSETTINGS_RES_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING(settingsvehiclelocatorlights: SettingsVehicleLocatorLights_t)
    fun onSETTINGS_RES_VALETMODESUCCESSFUL(pData: Int)
    fun onSETTINGS_RES_VALETMODEFAILED(pData: Int)
    fun onSETTINGS_RES_VALETMODERECOVERYSUCCESSFUL(pData: Int)
    fun onSETTINGS_RES_VALETMODERECOVERYFAILED(pData: Int)
    fun onSETTINGS_RES_VEHICLEMOVEMENTSTATE(pData: Int)
    fun onSETTINGS_RES_DRIVERWORLOADCONDITIONS(pData: Int)
    fun onSETTINGS_RES_IGNITIONSTATUS(pData: Int)
    fun onSETTINGS_RES_IGNITIONOFFSLEEPTIMEOUT(pData: Int)

    fun onSETTINGS_RES_INIT(settingsinitialization: SettingsInitialization_t)
    fun onSETTINGS_RES_SUPPORTEDSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t)
    fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: String)
    fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: String)
    fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: String)
    fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: String)
    fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOUNLOCKINGSETTING(settingsdl_setunlock: SettingsDL_SetUnlock_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_LASTDOORCLOSEDLOCKINGSETTING(settingsdl_lastdoorclosedlocking: SettingsDL_LastDoorClosedLocking_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_OPENDOORANTILOCKOUTSETTING(settingsdl_setopendoorantilockout: SettingsDL_SetOpenDoorAntiLockOut_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOLOCKINGSETTING(settingsdl_setautolock: SettingsDL_SetAutoLock_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING(settingsdl_setremoteunlockllightingfeedback: SettingsDL_SetRemoteUnlocklLightingFeedback_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTELOCKINGFEEDBACKSETTING(settingsdl_setremotelockingfeedback: SettingsDL_SetRemoteLockingFeedback_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_SELECTIVEUNLOCKINGSETTING(settingsdl_setselectiveunlocking: SettingsDL_SetSelectiveUnlocking_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_RELOCKREMOTEUNLOCKEDDOORSETTING(settingsdl_setrelockremoteunlockeddoor: SettingsDL_SetRelockRemoteUnlockedDoor_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESTART(settingsdl_setremotestart: SettingsDL_SetRemoteStart_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATS(settingsdl_setremotestartautocoolseats: SettingsDL_SetRemoteStartAutoCoolSeats_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATSSETTINGS(settingsdl_setremotestartautocoolseatssettings: SettingsDL_SetRemoteStartAutoCoolSeatsSettings_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATS(settingsdl_setremotestartautoheatseats: SettingsDL_SetRemoteStartAutoHeatSeats_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATSSETTINGS(settingsdl_setremotestartautoheatseatssettings: SettingsDL_SetRemoteStartAutoHeatSeatsSettings_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEWINDOWOPERATION(settingsdl_setremotewindowoperation: SettingsDL_SetRemoteWindowOperation_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVEUNLOCKINGSETTING(settingsdl_setpassiveunlock: SettingsDL_SetPassiveUnlock_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVELOCKINGSETTING(settingsdl_setpassivelock: SettingsDL_SetPassiveLock_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEINVEHICLEREMINDERSETTING(settingsdl_setremoteinvehiclereminder: SettingsDL_SetRemoteInVehicleReminder_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEREMOVEDFROMVEHICLEALERT(settingsdl_setremoteremovedfromvehiclealert: SettingsDL_SetRemoteRemovedFromVehicleAlert_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESLIDINGDOORSETTING(settingsdl_setremoteslidingdoor: SettingsDL_SetRemoteSlidingDoor_t)
    //CCustomizationECCProxy.cpp
    fun onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(settingsclimateautodefog: SettingsClimateAutoDefog_t)

    fun onCUSTOMIZATIONECC_RES_REARDEFOGSTARTUPSETTING(settingsclimateautoreardefog: SettingsClimateAutoRearDefog_t)
    fun onCUSTOMIZATIONECC_RES_ELEVATEDIDLESETTING(settingsclimateelevatedidlecustomization: SettingsClimateElevatedIdleCustomization_t)
    fun onCUSTOMIZATIONECC_RES_IONIZERSETTING(settingsclimateionizer: SettingsClimateIonizer_t)
    fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGSETTING(engineassistedheatingsetting: EngineAssistedHeatingSetting_t)
    fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGPLUGGEDINSETTING(engineassistedheatingpluggedinsetting: EngineAssistedHeatingPluggedInSetting_t)
    fun onCUSTOMIZATIONECC_RES_AUTOFANSETTING(settingsclimateautofanspeed: SettingsClimateAutoFanSpeed_t)
    fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(settingsclimateautoairdistribution: SettingsClimateAutoAirDistribution_t)
    fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTR1SETTING(settingsclimateautoairdistribution1: SettingsClimateAutoAirDistribution1_t)
    fun onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(settingsclimateairqualitysensor: SettingsClimateAirQualitySensor_t)
    fun onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(settingsclimatepollutioncontrolsetting: SettingsClimatePollutionControlSetting_t)
    fun onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(settingsclimateautocoolseatssettingvalue: SettingsClimateAutoCoolSeatsSettingValue_t)
    fun onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(settingsclimateautoheatedseats: SettingsClimateAutoHeatedSeats_t)
    fun onCUSTOMIZATIONECC_RES_REARZONESTARTUPSETTING(settingsrearclimateonstartup: SettingsRearClimateOnStartUp_t)
    //CDeviceProjectionProxy.cpp
    fun onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(pData: Int)

    fun onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(pData: Int)
    //CCustomizationECCProxy.cpp
    fun onCUSTOMIZATIONECC_RES_SUPPORTEDSETTINGS(customizationeccavailibilityflag: CustomizationECCAvailibilityFlag_t)

    fun onCUSTOMIZATIONDOORLOCKS_RES_SUPPORTEDSETTINGS(settingsdl_availibilityflag: SettingsDL_AvailibilityFlag_t)
    fun onCUSTOMIZATIONDOORLOCKS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsdl_availibilityflag: GlobalSettingsDL_AvailibilityFlag_t)
    fun onCUSTOMIZATIONECC_RES_GLOBALSUPPORTEDSETTINGS(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERACTIVE(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERPINSTOREDSTATUS(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERREPORTCARDDATA(settingsteendriverreportcarddata: SettingsTeenDriverReportCardData_t)
    fun onTEENDRIVER_RES_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING(settingsteendriverspeedlimitcustomizationsetting: SettingsTeenDriverSpeedLimitCustomizationSetting_t)
    fun onTEENDRIVER_RES_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING(settingsteendriveroverspeedwarningcustomizationsetting: SettingsTeenDriverOverspeedWarningCustomizationSetting_t)
    fun onTEENDRIVER_RES_TEENDRIVERPINSUCESSFUL(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERPINFAILED(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERKEYSPINCLEARED(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERKEYCONFIGURATION(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERPRESENT(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERKEYTRADITIONALKEYCONFIGURATIONSTATUS(pData: Int)
    fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERCONFIGURATIONSTATUS(pData: Int)
    fun onTEENDRIVER_RES_CHECK_KEY(pData: Int)
    fun onTEENDRIVER_RES_INIT(teendriverinitialization: TeenDriverInitialization_t)
    fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONSUCCESSFUL(uint32: Int)
    fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONFAILED(uint32: Int)
    fun onSOUNDPARAMS_RES_AMPDSPMODE(pData: Int)
    fun onSOUNDPARAMS_RES_AUDIOCUEVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_BALANCE(pData: Int)
    fun onSOUNDPARAMS_RES_BASS(max_volume_length: Int)
    fun onSOUNDPARAMS_RES_CHIMEVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_FADE(pData: Int)
    fun onSOUNDPARAMS_RES_SURROUND(max_volume_length: Int)
    fun onSOUNDPARAMS_RES_MAXIMUMSTARTUPVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_MIDRANGE(max_volume_length: Int)
    fun onSOUNDPARAMS_RES_MUTE(muteres: MuteRes_t)
    fun onSOUNDPARAMS_RES_TEENDRIVERMAXIMUMVOLUMELIMIT(pData: Int)
    fun onSOUNDPARAMS_RES_TEENDRIVERMINIMUMVOLUMELIMIT(pData: Int)
    fun onSOUNDPARAMS_RES_TEENDRIVERVOLUMELIMITINGENABLED(pData: Int)
    fun onSOUNDPARAMS_RES_TREBLE(max_volume_length: Int)
    fun onSOUNDPARAMS_RES_SPEEDVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTED(pData: Int)
    fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTIONCOMPLETE(pData: Int)
    fun onSOUNDPARAMS_RES_VOLUME(volumegroupextent: VolumeGroupExtent_t)
    fun onLGSP_VG_NONE()
    fun onLGSP_VG_MAIN()
    fun onLGSP_VG_EMERGENCY_PHONE()
    fun onLGSP_VG_RING_TONE()
    fun onLGSP_VG_ALERT()
    fun onLGSP_VG_CHIME()
    fun onLGSP_VG_ANDROIDAUTO()
    fun onSOUNDPARAMS_RES_ALERTVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_MAINVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_PHONEVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_PROMPTVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_RINGTONEVOLUME(pData: Int)
    fun onSOUNDPARAMS_RES_VOLUMEGROUPEXTENTS(spvolumegroupextentstream: SPVolumeGroupExtentStream_t)
    fun onLGSP_VG_CARPLAY()
    fun onLGSP_VG_PHONE()
    fun onLGSP_VG_PROMPT()
    fun onLGSP_VG_TRAFFIC()
    fun onLGSP_VG_AUDIO_CUE()
    fun onLGSP_VG_TEENDRIVER()
    fun onSOUNDPARAMS_RES_MODEINIT(soundparametersmodeinitialization: SoundParametersModeInitialization_t)
    fun onSOUNDPARAMS_RES_VOLUMEINIT(soundparametersvolumeinitialization: SoundParametersVolumeInitialization_t)
    fun onSETTINGS_RES_PROPERUSEWARNING(pData: Int)
    fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: Int)
    fun onSETTINGS_RES_LOCATIONSERVICESNOTIFICATION(pData: Int)
    fun onSETTINGS_RES_VALETMODESTORAGEUNLOCK(pData: Int)
    fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: Int)
    fun onSETTINGS_RES_VEHICLEGEARSTATE(pData: Int)
    fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: Int)
    fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: Int)
    fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: Int)
    fun onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsavailibilityflag: GlobalSettingsAvailibilityFlag_t)
    fun onSETTINGS_RES_CLIMATE()
    fun onSETTINGS_RES_VALETMODESTATUS(pData: Int)
    fun onSETTINGS_RES_OUTTEMPERATURE_VAL(max_oat_val_len: Int)

    /**
     * To update Language
     * @param pData ESettingsLanguageType
     */
    fun onSETTINGS_RES_LANGUAGE(any: Any, selectedLocale: Locale)
    //user defined response methods
    /**
     * To know time or date screen
     */
    fun onSETTINGS_RES_TIME_OR_DATE(timeOrDate: Boolean)

    /**
     * To Update Timezone
     */
    fun onSETTINGS_RES_TIMEZONE()

    fun onSETTINGS_RES_DISPLAY(boolean: Boolean)
    fun onSETTINGS_RES_DISPLAY_CADILLAC(value: ObservableField<Int>)

    /**
     * To Update Automatic time zone availability
     */
    fun onSETTINGS_RES_AUTOMATICTIMEZONE()

    /**
     * To update Time information
     * @param timeinfo
     */
    fun onSETTINGS_RES_TIMEINFO(timeinfo: TimeInfo_t)

    /**
     * To update Time Display format
     * @param timDisplayType eSettingsTimeDisplayFormat
     */
    fun onSETTINGS_RES_TIMEDISPLAYFORMAT(timDisplayType: eSettingsTimeDisplayFormat)

    /**
     * To update date information
     * @param dateinfo
     */
    fun onSETTINGS_RES_DATEINFO(dateinfo: DateInfo_t)

    /**
     * To update Automatic time date availability
     * @param settingsautotimeupdatesetting SettingsAutoTimeUpdateSetting_t
     */
    fun onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(settingsautotimeupdatesetting: SettingsAutoTimeUpdateSetting_t)

    /**
     * To update the maximum startup volume to hardware
     */
    fun onSETTINGS_RES_AUDIBLETOUCHFEEDBACK(pData: Int)


    /**
     *  To update data for sound menu
     */

    fun onSETTINGS_RES_GETMAXSTARTUPVOLUME(pData: Int)


    /**
     *   For sound menu
     */

    fun onSETTINGS_RES_SOUND_MENU()

    /**
     *   To update audio cue volume
     */
    fun onSETTINGS_RES_AUDIOCUES(pData: Int)

    /**
     * To update audio favorite count
     * @param any
     */
    fun onFAVORITE_RES_AUDIOMAXFAVCOUNT(any: Any)

    /**
     * To display the menu list
     */
    fun onSETTINGS_RES_CONTAINER_MENU_LIST()

    /**
     * To display the driving mode list
     */
    fun onSETTINGS_RES_DRIVINGMODELIST(driverModeList: ArrayList<DriveModeModel>)

    fun onSETTINGS_RES_VEHICLELIST(vehicleList: ArrayList<String>)
    fun onSETTINGS_RES_ENGINESOUNDLIST(enginemodeList: ArrayList<ESettingsChangePerfModeSound>)


    fun onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(any: Any)

    /**
     *  To dispaly ram size and info running applications
     */

    fun onSETTINGS_RES_GET_STORAGE_USAGE(usedStorage: String, freeStorage: String, progress: Int)

    fun onSETTINGS_RES_GET_CONFIRM_FORCESTOP()

    fun onSETTINGS_RES_GET_RUNNINGAPPSTOP_POS(any: Any)
    /**
     * To display climat menu  list
     */
    fun onSETTINGS_RES_CLIMATE_MENU_LIST()

    fun onSETTINGS_RES_SPORTMODESPORTSTEERINGSETTINGS(settingssportmodesportsteering: ArrayList<ESettingsSteeringCustomization>)
    fun onSETTINGS_RES_SPORTMODESETTINGS(any: Any)

    fun onSETTINGS_RES_BUILDCLICK()

    fun onSETTINGS_RES_BUILDNUMBER()

    fun onSETTINGS_RES_OPENSOURCE(path: String)

    fun onSETTINGS_RES_SUPPORTEDSPORTSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t) {}


    fun onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(any: Any) {
    }

    fun onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any) {
    }

    fun onSETTINGS_APPS_RES_DATA()

    fun onSETTINGS_RES_COLLISION_DATA()
}