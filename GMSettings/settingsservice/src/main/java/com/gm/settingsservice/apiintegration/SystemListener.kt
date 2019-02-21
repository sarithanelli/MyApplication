package com.gm.settingsservice.apiintegration

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.text.format.DateFormat
import androidx.databinding.ObservableField
import com.gm.settingsservice.apiintegration.apiinterfaces.ISettingsManagerRes
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.Log
import gm.update.UpdateManager
import java.io.File
import java.util.*
import javax.inject.Inject

/**
 * Updating the data to [dataPoolDataHandler] when UI event occurred
 */
class SystemListener @Inject constructor(dataPoolDataHandler: DataPoolDataHandler) : ISettingsManagerRes {
    override fun onSETTINGS_RES_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING(any: Any) {
        dataPoolDataHandler.SETTINGS_COLLISION_RECYCLER_VIEW.set(any as Int)
    }

    override fun onSETTINGS_RES_SETPOWERLIFTGATETYPE(any: Any) {
        dataPoolDataHandler.SETTINGS_POWER_LIFTGATE_TYPE.set(any as Int)

    }

    override fun onSETTINGS_RES__COMFORT_CONVENIENCE_MENU() {
        mCallback?.onSETTINGS_RES__COMFORT_CONVENIENCE_MENU()
    }

    override fun onSETTINGS_RES_AUTOMATIC_ENTRY_EGRESS_ASSIST() {
        mCallback?.onSETTINGS_RES_AUTOMATIC_ENTRY_EGRESS_ASSIST()

    }

    override fun onSETTINGS_RES_POWER_LIFTGATE() {
        dataPoolDataHandler.SETTINGS_POWER_LIFTGATE_TYPE.get()
        mCallback?.onSETTINGS_RES_POWER_LIFTGATE()

    }

    override fun onSETTINGS_RES_HANDSFREE_LIFTGATE() {
        mCallback?.onSETTINGS_RES_HANDSFREE_LIFTGATE()

    }

    override fun SOUNDPARAMS_RES_CHIMEVOLUME() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RES_REVERSE_TILTMIRROR() {
        mCallback?.onSETTINGS_RES_REVERSE_TILTMIRROR()

    }

    override fun onSETTINGS_RES_REMOTE_MIRRORFOLDING() {
        mCallback?.onSETTINGS_RES_REMOTE_MIRRORFOLDING()

    }

    override fun onSETTINGS_RES_RAIN_SENSE_WIPERS() {
        mCallback?.onSETTINGS_RES_RAIN_SENSE_WIPERS()

    }

    override fun onSETTINGS_RES_AUTO_WIPE_REVERSEGEAR() {
        mCallback?.onSETTINGS_RES_AUTO_WIPE_REVERSEGEAR()

    }

    override fun onSETTINGS_RES_EXTENDED_HILL_START_ASSIST() {
        mCallback?.onSETTINGS_RES_EXTENDED_HILL_START_ASSIST()
    }

    var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler
    override fun onSETTINGS_RES_SPORTMODESETTINGS(any: Any) {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set((any as SportModeModel).primaryData)
        dataPoolDataHandler.SETTINGS_SPORT_MODE_ON_OFF.set(any.description)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_STATE.set(any.isToggleState)
    }


    override fun onSETTINGS_MANAGE_RES_FAV() {
        mCallback?.onSETTINGS_MANAGE_RES_FAV()
    }

    //response for display status
    override fun onSETTINGS_RES_DISPLAYSTATUS(any: Any) {
        mCallback?.onSETTINGS_RES_DISPLAYSTATUS(any.toString())

    }

    //response for display calibration touchscreen
    override fun onSETTINGS_RES_CALIBRATION() {
        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(true)
        dataPoolDataHandler.CALIBRATE_TOGGLE_CENTER.set(false)
        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_RIGHT.set(false)
        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNER.set(false)
        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNERCORNER.set(false)
    }

    override fun onSETTINGS_RES_DISPLAY_CADILLAC(value: ObservableField<Int>) {
        mCallback?.onSETTINGS_RES_DISPLAY_CADILLAC(value)
    }

    override fun onSETTINGS_RES_CLIMATE() {
        mCallback?.onSETTINGS_RES_CLIMATE()
    }

    override fun onSETTINGS_RES_CLIMATE_MENU_LIST() {
        mCallback?.onSETTINGS_RES_CLIMATE_MENU_LIST()
    }


    override fun onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(any: Any) {
        dataPoolDataHandler.SETTINGS_RUNNINGAPPS_INFORMATION.clear()
        dataPoolDataHandler.SETTINGS_RUNNINGAPPS_INFORMATION.addAll(any as ArrayList<AppInfo>)
    }


    override fun onSETTINGS_RES_GET_RUNNINGAPPSTOP_POS(any: Any) {
        dataPoolDataHandler.SETTINGS_RUNNING_FORCESTOP_POSITION.set(any as Int)
    }

    override fun onSETTINGS_RES_GET_CONFIRM_FORCESTOP() {
        mCallback!!.onSETTINGS_RES_GET_CONFIRM_FORCESTOP()
    }


    override fun onSETTINGS_RES_GET_STORAGE_USAGE(usedStorage: String, freeStorage: String, progress: Int) {
        var usedStorage = usedStorage.replace("Ð“Ð±", "GB")
        usedStorage = usedStorage.replace(",", ".")
        usedStorage = usedStorage.replace("ÐœÐ±", "MB")
        var freeStorage = freeStorage.replace("Ð“Ð±", "GB")
        freeStorage = freeStorage.replace(",", ".")
        freeStorage = freeStorage.replace("ÐœÐ±", "MB")

        dataPoolDataHandler.SETTINGS_RUNNING_PROGRESSBAR_VALUE.set(progress)
        dataPoolDataHandler.SETTINGS_RUNNING_USEDMEMORY_SIZE.set(usedStorage)
        dataPoolDataHandler.SETTINGS_RUNNING_AVAILABLE_SIZE.set(freeStorage)
    }


    var mCallback: ISettingsManagerRes? = null

    fun registerApiCallback(callback: ISettingsManagerRes) {
        this.mCallback = callback
    }


    override fun onSETTINGS_RES_VEHICLEDISPLAYUNITS(pData: Int) {
        dataPoolDataHandler.SETTINGS_VEHICLEDISPLAYUNITS.set(pData)
    }


    override fun onSETTINGS_RES_PROPERUSEWARNING(pData: String) {
        //TODO
//        SETTINGS_PROPERUSEWARNING_DISPLAYSTATUS.set(pData)
    }

    override fun onSETTINGS_RES_PROPERUSEWARNINGACKNOWLEDGED(pData: Int) {
        dataPoolDataHandler.SETTINGS_PROPERUSEWARNING_DISPLAYSTATUS.set(pData)
    }

    override fun onSETTINGS_RES_SYSTEMFAULTSTATE(pData: Int) {
        dataPoolDataHandler.SETTINGS_SYSTEMFAULTSTATUS.set(pData)
    }

    override fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: String) {
        dataPoolDataHandler.UI_PHONE_ACTIVEINCALLSWITCHSCREEN.set(pData.toInt())
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING(settingsadaptiveforwardlighting: SettingsAdaptiveForwardLighting_t) {
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING_FLAG.set(settingsadaptiveforwardlighting.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING.set(settingsadaptiveforwardlighting.AdaptiveForwardLighting)
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING(settingsadaptiveforwardlighting1: SettingsAdaptiveForwardLighting1_t) {
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING_FLAG.set(settingsadaptiveforwardlighting1.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING.set(settingsadaptiveforwardlighting1.AdaptiveForwardLighting)
    }

    override fun onSETTINGS_RES_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING(settingsadaptiveforwardlightingwithgps: SettingsAdaptiveForwardLightingWithGPS_t) {
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTINGWITHGPS_FLAG.set(settingsadaptiveforwardlightingwithgps.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTINGWITHGPS.set(settingsadaptiveforwardlightingwithgps.AdaptiveForwardLightingWithGPS)
    }

    override fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsadaptivehighbeamassist: SettingsAdaptiveHighBeamAssist_t) {
        dataPoolDataHandler.SETTINGS_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsadaptivehighbeamassist.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY.set(settingsadaptivehighbeamassist.AutoHighBeamAssistWithSensitivity)
    }

    override fun onSETTINGS_RES_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsadaptivehighbeamassistwithsensitivity: SettingsAdaptiveHighBeamAssistWithSensitivity_t) {
        dataPoolDataHandler.SETTINGS_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsadaptivehighbeamassistwithsensitivity.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITY.set(settingsadaptivehighbeamassistwithsensitivity.AdaptiveHighBeamAssistWithSensitivity)
    }

    override fun onSETTINGS_RES_LOCATIONBASEDCHARGING(settingslocationbasedcharging: SettingsLocationBasedCharging_t) {
        dataPoolDataHandler.SETTINGS_LOCATIONBASEDCHARGING_FLAG.set(settingslocationbasedcharging.flag)
        dataPoolDataHandler.SETTINGS_LOCATIONBASEDCHARGING.set(settingslocationbasedcharging.locationBasedCharging)
    }

    override fun onSETTINGS_RES_ENERGYSUMMARYPOPUP(settingsenergysummarypopup: SettingsEnergySummaryPopup_t) {
        dataPoolDataHandler.SETTINGS_ENERGYSUMMARYPOPUP_FLAG.set(settingsenergysummarypopup.flag)
        dataPoolDataHandler.SETTINGS_ENERGYSUMMARYPOPUP.set(settingsenergysummarypopup.energySummaryPopup)
    }

    override fun onSETTINGS_RES_CHARGESTATUSFEEDBACK(settingschargestatusfeedback: SettingsChargeStatusFeedback_t) {
        dataPoolDataHandler.SETTINGS_CHARGESTATUSFEEDBACK_FLAG.set(settingschargestatusfeedback.flag)
        dataPoolDataHandler.SETTINGS_CHARGESTATUSFEEDBACK.set(settingschargestatusfeedback.chargeStatusFeedback)
    }

    override fun onSETTINGS_RES_CHARGECORDTHEFTALERT(settingschargecordtheftalert: SettingsChargeCordTheftAlert_t) {
        dataPoolDataHandler.SETTINGS_CHARGECORDTHEFTALERT_FLAG.set(settingschargecordtheftalert.flag)
        dataPoolDataHandler.SETTINGS_CHARGECORDTHEFTALERT.set(settingschargecordtheftalert.chargeCordTheftAlert)
    }

    override fun onSETTINGS_RES_CHARGEPOWERLOSSALERT(settingschargepowerlossalert: SettingsChargePowerLossAlert_t) {
        dataPoolDataHandler.SETTINGS_CHARGEPOWERLOSSALERT_FLAG.set(settingschargepowerlossalert.flag)
        dataPoolDataHandler.SETTINGS_CHARGEPOWERLOSSALERT.set(settingschargepowerlossalert.chargePowerLossAlert)
    }

    override fun onSETTINGS_RES_STANDBYSPEED(settingsstandbyspeed: SettingsStandBySpeed_t) {
        dataPoolDataHandler.SETTINGS_STANDBYSPEED_FLAG.set(settingsstandbyspeed.flag)
        dataPoolDataHandler.SETTINGS_STANDBYSPEED.set(settingsstandbyspeed.standBySpeed)
    }

    override fun onSETTINGS_RES_SET1SPEED(settingsset1speed: SettingsSet1Speed_t) {
        dataPoolDataHandler.SETTINGS_SET1SPEED_FLAG.set(settingsset1speed.flag)
        dataPoolDataHandler.SETTINGS_SET1SPEED.set(settingsset1speed.set1Speed)
    }

    override fun onSETTINGS_RES_SET2SPEED(settingsset2speed: SettingsSet2Speed_t) {
        dataPoolDataHandler.SETTINGS_SET2SPEED_FLAG.set(settingsset2speed.flag)
        dataPoolDataHandler.SETTINGS_SET2SPEED.set(settingsset2speed.set2Speed)
    }

    override fun onSETTINGS_RES_TAPSTEPSPEED(settingstapstepspeed: SettingsTapStepSpeed_t) {
        dataPoolDataHandler.SETTINGS_TAPSTEPSPEED_FLAG.set(settingstapstepspeed.flag)
        dataPoolDataHandler.SETTINGS_TAPSTEPSPEED.set(settingstapstepspeed.tapStepSpeed)
    }

    override fun onSETTINGS_RES_SHUTDOWNTIME(settingsshutdowntime: SettingsShutDownTime_t) {
        dataPoolDataHandler.SETTINGS_SHUTDOWNTIME_FLAG.set(settingsshutdowntime.flag)
        dataPoolDataHandler.SETTINGS_SHUTDOWNTIME.set(settingsshutdowntime.shutDownTime)
    }

    override fun onSETTINGS_RES_ALERTTYPESETTINGS(settingscollisiondetectionalerttype: SettingsCollisionDetectionAlertType_t) {
        dataPoolDataHandler.SETTINGS_ALERTTYPESETTINGS_ALERTTYPECUSTOMIZATIONSETTING_FLAG.set(settingscollisiondetectionalerttype.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_ALERTTYPESETTINGS_ALERTTYPECUSTOMIZATIONSETTING.set(settingscollisiondetectionalerttype.AlertTypeCustomizationSetting)
    }

    override fun onSETTINGS_RES_AUDIBLETOUCHFEEDBACK(pData: Int) {

    }


    override fun onSETTINGS_RES_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingsautohighbeamassist: SettingsAutoHighBeamAssist_t) {
        dataPoolDataHandler.SETTINGS_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSIST_FLAG.set(settingsautohighbeamassist.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSIST.set(settingsautohighbeamassist.AutoHighBeamAssist)
    }

    override fun onSETTINGS_RES_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING(settingsautohighbeamassistwithsensitivity: SettingsAutoHighBeamAssistWithSensitivity_t) {
        dataPoolDataHandler.SETTINGS_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsautohighbeamassistwithsensitivity.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY.set(settingsautohighbeamassistwithsensitivity.AutoHighBeamAssistWithSensitivity)
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALL1SETTING(settingsautomemoryrecall1: SettingsAutoMemoryRecall1_t) {
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALL1SETTING_FLAG.set(settingsautomemoryrecall1.flag)
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALL1SETTING.set(settingsautomemoryrecall1.autoMemoryRecall1)
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALL2SETTING(settingsautomemoryrecall2: SettingsAutoMemoryRecall2_t) {
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALL2SETTING_FLAG.set(settingsautomemoryrecall2.flag)
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALL2SETTING.set(settingsautomemoryrecall2.autoMemoryRecall2)
    }

    override fun onSETTINGS_RES_AUTOMEMORYRECALLSETTING(settingsautomemoryrecall: SettingsAutoMemoryRecall_t) {
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALLSETTING_FLAG.set(settingsautomemoryrecall.flag)
        dataPoolDataHandler.SETTINGS_AUTOMEMORYRECALLSETTING.set(settingsautomemoryrecall.value)
    }

    override fun onSETTINGS_RES_AUTOMIRRORFOLDINGSETTING(settingsautomirrorfolding: SettingsAutoMirrorFolding_t) {
        dataPoolDataHandler.SETTINGS_AUTOMIRRORFOLDINGSETTING_FLAG.set(settingsautomirrorfolding.flag)
        dataPoolDataHandler.SETTINGS_AUTOMIRRORFOLDINGSETTING.set(settingsautomirrorfolding.value)
    }


    override fun onSETTINGS_RES_AUTOWIPEINREVERSEGEARSETTING(settingsautowipeinreversegear: SettingsAutoWipeinReverseGear_t) {
        dataPoolDataHandler.SETTINGS_AUTOWIPEINREVERSEGEARSETTING_FLAG.set(settingsautowipeinreversegear.flag)
        dataPoolDataHandler.SETTINGS_AUTOWIPEINREVERSEGEARSETTING.set(settingsautowipeinreversegear.value)
    }

    override fun onSETTINGS_RES_AUTOMATICVEHICLEHOLDSETTING(settingsautomaticvehiclehold: SettingsAutomaticVehicleHold_t) {
        dataPoolDataHandler.SETTINGS_AUTOMATICVEHICLEHOLDSETTING_FLAG.set(settingsautomaticvehiclehold.flag)
        dataPoolDataHandler.SETTINGS_AUTOMATICVEHICLEHOLDSETTING.set(settingsautomaticvehiclehold.value)
    }

    override fun onSETTINGS_RES_EXTENDEDHILLSTARTASSISTSETTING(settingsextendedhillstartassist: SettingsExtendedHillStartAssist_t) {
        dataPoolDataHandler.SETTINGS_EXTENDEDHILLSTARTASSISTSETTING_FLAG.set(settingsextendedhillstartassist.flag)
        dataPoolDataHandler.SETTINGS_EXTENDEDHILLSTARTASSISTSETTING.set(settingsextendedhillstartassist.value)
    }


    override fun onSETTINGS_RES_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING(settingsdaytimetaillights: SettingsDaytimeTailLights_t) {
        dataPoolDataHandler.SETTINGS_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING_DAYTIMETAILLIGHTS_FLAG.set(settingsdaytimetaillights.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING_DAYTIMETAILLIGHTS.set(settingsdaytimetaillights.DaytimeTailLights)
    }

    override fun onSETTINGS_RES_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING(settingsdriverdrowsinessdetectioncustomization: SettingsDriverDrowsinessDetectionCustomization_t) {
        dataPoolDataHandler.SETTINGS_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsdriverdrowsinessdetectioncustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING.set(settingsdriverdrowsinessdetectioncustomization.DriverDrowsinessDetectionCustomizationSetting)
    }


    override fun onSETTINGS_RES_EASYEXITDRIVERSEATSETTING(settingseasyexitdriverseat: SettingsEasyExitDriverSeat_t) {
        dataPoolDataHandler.SETTINGS_EASYEXITDRIVERSEATSETTING_FLAG.set(settingseasyexitdriverseat.flag)
        dataPoolDataHandler.SETTINGS_EASYEXITDRIVERSEATSETTING.set(settingseasyexitdriverseat.value)
    }

    override fun onSETTINGS_RES_EASYEXITOPTIONSSETTING(settingseasyexitoptions: SettingsEasyExitOptions_t) {
        dataPoolDataHandler.SETTINGS_EASYEXITOPTIONSSETTING_FLAG.set(settingseasyexitoptions.flag)
        dataPoolDataHandler.SETTINGS_EASYEXITOPTIONSSETTING.set(settingseasyexitoptions.value)
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN1SETTING(settingseasyexitsteeringcolumn1: SettingsEasyExitSteeringColumn1_t) {
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMN1SETTING_FLAG.set(settingseasyexitsteeringcolumn1.flag)
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMN1SETTING.set(settingseasyexitsteeringcolumn1.value)
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMN2SETTING(settingseasyexitsteeringcolumn2: SettingsEasyExitSteeringColumn2_t) {
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMN2SETTING_FLAG.set(settingseasyexitsteeringcolumn2.flag)
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMN2SETTING.set(settingseasyexitsteeringcolumn2.value)
    }

    override fun onSETTINGS_RES_EASYEXITSTEERINGCOLUMNSETTING(settingseasyexitsteeringcolumn: SettingsEasyExitSteeringColumn_t) {
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMNSETTING_FLAG.set(settingseasyexitsteeringcolumn.flag)
        dataPoolDataHandler.SETTINGS_EASYEXITSTEERINGCOLUMNSETTING.set(settingseasyexitsteeringcolumn.value)
    }

    override fun onSETTINGS_RES_ENGINERUNACTIVE(enginerunactivesetting: EngineRunActiveSetting_t) {
        dataPoolDataHandler.SETTINGS_ENGINERUNACTIVE_FLAG.set(enginerunactivesetting.flag)
        dataPoolDataHandler.SETTINGS_ENGINERUNACTIVE.set(enginerunactivesetting.value)
    }

    override fun onSETTINGS_RES_EXITLIGHTINGCUSTOMIZATIONSETTING(settingsexitlighting: SettingsExitLighting_t) {
        dataPoolDataHandler.SETTINGS_EXITLIGHTINGCUSTOMIZATIONSETTING_FLAG.set(settingsexitlighting.flag)
        dataPoolDataHandler.SETTINGS_EXITLIGHTINGCUSTOMIZATIONSETTING.set(settingsexitlighting.value)
    }

    override fun onSETTINGS_RES_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING(setttingforwardcollisionalertcustomization: SetttingForwardCollisionAlertCustomization_t) {
        dataPoolDataHandler.SETTINGS_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTINGS_FLAG.set(setttingforwardcollisionalertcustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTINGS.set(setttingforwardcollisionalertcustomization.ForwardCollisionAlertCustomizationSettings)
    }

    override fun onSETTINGS_RES_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsfrontpedestriandetectioncustomization: SettingsFrontPedestrianDetectionCustomization_t) {
        dataPoolDataHandler.SETTINGS_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsfrontpedestriandetectioncustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING.set(settingsfrontpedestriandetectioncustomization.FrontPedestrianDetectionCustomizationSetting)
    }

    override fun onSETTINGS_RES_GONOTIFIERCUSTOMIZATIONSETTINGS(settingsgonotifiercustomization: SettingsGoNotifierCustomization_t) {
        dataPoolDataHandler.SETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS_FLAG.set(settingsgonotifiercustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS.set(settingsgonotifiercustomization.GoNotifierCustomizationSettings)
    }

    override fun onSETTINGS_RES_INTERSECTIONSTOPALERTSETTINGS(settingscollisiondetectionintersectionstopalert: SettingsCollisionDetectionIntersectionStopAlert_t) {
        dataPoolDataHandler.SETTINGS_INTERSECTIONSTOPALERTSETTINGS_INTERSECTIONSTOPALERTCUSTOMIZATIONSETTING_FLAG.set(settingscollisiondetectionintersectionstopalert.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_INTERSECTIONSTOPALERTSETTINGS_INTERSECTIONSTOPALERTCUSTOMIZATIONSETTING.set(settingscollisiondetectionintersectionstopalert.IntersectionStopAlertCustomizationSetting)
    }

    override fun onSETTINGS_RES_LANECHANGEALERTSETTING(settingslanechangealert: SettingsLaneChangeAlert_t) {
        dataPoolDataHandler.SETTINGS_LANECHANGEALERTSETTING_LANECHANGEALERTSETTING_FLAG.set(settingslanechangealert.ValidityFlag)
        dataPoolDataHandler.SETTINGS_LANECHANGEALERTSETTING_LANECHANGEALERTSETTING.set(settingslanechangealert.LaneChangeAlertSettingValue)
    }


    override fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING(settingsleftrighthandtraffic: SettingsLeftRightHandTraffic_t) {
        dataPoolDataHandler.SETTINGS_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFIC_FLAG.set(settingsleftrighthandtraffic.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFIC.set(settingsleftrighthandtraffic.LeftRightHandTraffic)
    }

    override fun onSETTINGS_RES_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING(settingsleftrighthandtrafficwithgps: SettingsLeftRightHandTrafficWithGPS_t) {
        dataPoolDataHandler.SETTINGS_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFICWITHGPS_FLAG.set(settingsleftrighthandtrafficwithgps.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFICWITHGPS.set(settingsleftrighthandtrafficwithgps.LeftRightHandTrafficWithGPS)
    }

    override fun onSETTINGS_RES_LOCATIONSERVICES(pData: Int) {
        //TODO
//        SETTINGS_LOCATIONSERVICES.set(pData)
        dataPoolDataHandler.HMI_LOCATION_SERVICE.set(pData)
    }

    override fun onSETTINGS_RES_PARKASSISTSETTING(settingsparkassist: SettingsParkAssist_t) {
        dataPoolDataHandler.SETTINGS_PARKASSISTSETTING_PARKASSISTSETTING_FLAG.set(settingsparkassist.ValidityFlag)
        dataPoolDataHandler.SETTINGS_PARKASSISTSETTING_PARKASSISTSETTING.set(settingsparkassist.ParkAssistSettingValue)
    }

    override fun onSETTINGS_RES_PARKASSISTWITHTOWBARSETTING(settingsparkassistwithtowbar: SettingsParkAssistWithTowbar_t) {
        dataPoolDataHandler.SETTINGS_PARKASSISTWITHTOWBARSETTING_PARKASSISTWITHTOWBARSETTING_FLAG.set(settingsparkassistwithtowbar.ValidityFlag)
        dataPoolDataHandler.SETTINGS_PARKASSISTWITHTOWBARSETTING_PARKASSISTWITHTOWBARSETTING.set(settingsparkassistwithtowbar.ParkAssistWithTowbarSettingValue)
    }

    override fun onSETTINGS_RES_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING(settingspedestrianfriendlyalert: SettingsPedestrianFriendlyAlert_t) {
        dataPoolDataHandler.SETTINGS_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING_FLAG.set(settingspedestrianfriendlyalert.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING.set(settingspedestrianfriendlyalert.PedestrianFriendlyAlertCustomizationSetting)
    }

    override fun onSETTINGS_RES_PERFMODEDISPLAYCUSTOMIZATIONSETTING(settingsperfmodedisplaycustomization: SettingsPerfModeDisplayCustomization_t) {
        dataPoolDataHandler.SETTINGS_PERFMODEDISPLAYCUSTOMIZATIONSETTING.set(settingsperfmodedisplaycustomization.flag)
        dataPoolDataHandler.SETTINGS_PERFMODEDISPLAYCUSTOMIZATIONSETTING_FLAG.set(settingsperfmodedisplaycustomization.value)
    }


    override fun onSETTINGS_RES_PERFMODESTEERINGCUSTOMIZATIONSETTINGS(settingssteeringcustomization: SettingsSteeringCustomization_t) {
        dataPoolDataHandler.SETTINGS_PERFMODESTEERINGCUSTOMIZATIONSETTINGS_STEERINGCUSTOMIZATIONSETTINGS_FLAG.set(settingssteeringcustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_PERFMODESTEERINGCUSTOMIZATIONSETTINGS_STEERINGCUSTOMIZATIONSETTINGS.set(settingssteeringcustomization.SteeringCustomizationSettings)
    }

    override fun onSETTINGS_RES_PERSONALIZATIONBYDRIVERSETTING(settingspersonalizationbydriver: SettingsPersonalizationbyDriver_t) {
        dataPoolDataHandler.SETTINGS_PERSONALIZATIONBYDRIVERSETTING_FLAG.set(settingspersonalizationbydriver.flag)
        dataPoolDataHandler.SETTINGS_PERSONALIZATIONBYDRIVERSETTING.set(settingspersonalizationbydriver.value)
    }

    override fun onSETTINGS_RES_RAINSENSEWIPERSSETTING(settingsrainsensewipers: SettingsRainSenseWipers_t) {
        dataPoolDataHandler.SETTINGS_RAINSENSEWIPERSSETTING_FLAG.set(settingsrainsensewipers.flag)
        dataPoolDataHandler.SETTINGS_RAINSENSEWIPERSSETTING.set(settingsrainsensewipers.value)
    }

    override fun onSETTINGS_RES_REARCAMERAPARKASSISTSETTINGS(settingscollisiondetectionrearcameraparkassist: SettingsCollisionDetectionRearCameraParkAssist_t) {
        dataPoolDataHandler.SETTINGS_REARCAMERAPARKASSISTSETTINGS_REARCAMERAPARKASSISTCUSTOMIZATIONSETTINGS_FLAG.set(settingscollisiondetectionrearcameraparkassist.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_REARCAMERAPARKASSISTSETTINGS_REARCAMERAPARKASSISTCUSTOMIZATIONSETTINGS.set(settingscollisiondetectionrearcameraparkassist.RearCameraParkAssistCustomizationSettings)
    }

    override fun onSETTINGS_RES_REARCROSSTRAFFICALERTSETTING(settingstrearcrosstrafficalert: SettingstRearCrossTrafficAlert_t) {
        dataPoolDataHandler.SETTINGS_REARCROSSTRAFFICALERTSETTING_REARCROSSTRAFFICALERTSETTING_FLAG.set(settingstrearcrosstrafficalert.ValidityFlag)
        dataPoolDataHandler.SETTINGS_REARCROSSTRAFFICALERTSETTING_REARCROSSTRAFFICALERTSETTING.set(settingstrearcrosstrafficalert.RearCrossTrafficAlertSettingValue)
    }

    override fun onSETTINGS_RES_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING(settingsrearpedestriandetectioncustomization: SettingsRearPedestrianDetectionCustomization_t) {
        dataPoolDataHandler.SETTINGS_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsrearpedestriandetectioncustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING.set(settingsrearpedestriandetectioncustomization.RearPedestrianDetectionCustomizationSetting)
    }

    override fun onSETTINGS_RES_REARSEATREMINDERCUSTOMIZATIONSETTINGS(settingsrearseatreminder: SettingsRearSeatReminder_t) {
        dataPoolDataHandler.SETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTING_FLAG.set(settingsrearseatreminder.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTING.set(settingsrearseatreminder.RearSeatReminderCustomizationSetting)
    }

    override fun onSETTINGS_RES_REVERSETILTMIRROR1SETTING(settingsreversetiltmirror1: SettingsReverseTiltMirror1_t) {
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRROR1SETTING_FLAG.set(settingsreversetiltmirror1.flag)
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRROR1SETTING.set(settingsreversetiltmirror1.value)
    }

    override fun onSETTINGS_RES_REVERSETILTMIRROR2SETTING(settingsreversetiltmirror2: SettingsReverseTiltMirror2_t) {
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRROR2SETTING_FLAG.set(settingsreversetiltmirror2.flag)
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRROR2SETTING.set(settingsreversetiltmirror2.value)
    }

    override fun onSETTINGS_RES_REVERSETILTMIRRORSETTING(settingsreversetiltmirror: SettingsReverseTiltMirror_t) {
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRRORSETTING_FLAG.set(settingsreversetiltmirror.flag)
        dataPoolDataHandler.SETTINGS_REVERSETILTMIRRORSETTING.set(settingsreversetiltmirror.value)
    }

    override fun onSETTINGS_RES_SEATBELTATTACHEDSTATUS(settingsseatbeltattachedstatus: SettingsSeatBeltAttachedStatus_t) {
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_DRIVERSEATBELTATTACHEDSTATUS.set(settingsseatbeltattachedstatus.driverSeatBeltAttached)
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_DRIVERSEATBELTATTACHED_FLAG.set(settingsseatbeltattachedstatus.driverSeatBeltAttachedValidityFlag)
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_PASSENGERSEATBELTATTACHEDSTATUS.set(settingsseatbeltattachedstatus.passengerSeatBeltAttached)
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_PASSENGERSEATBELTATTACHED_FLAG.set(settingsseatbeltattachedstatus.passengerSeatBeltAttachedValidityFlag)
    }

    override fun onSETTINGS_RES_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING(settingsseatbelttighteningcustomization: SettingsSeatBeltTighteningCustomization_t) {
        dataPoolDataHandler.SETTINGS_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING_SEATBELTTIGHTENINGCUSTOMIZATIONSETTINGS_FLAG.set(settingsseatbelttighteningcustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING_SEATBELTTIGHTENINGCUSTOMIZATIONSETTINGS.set(settingsseatbelttighteningcustomization.SeatBeltTighteningCustomizationSettings)
    }

    override fun onSETTINGS_RES_SETTINGSPERSONALDATAERASED(pData: Int) {
    }

    override fun onSETTINGS_RES_SIDEBLINDZONEALERTSETTING(settingssideblindzonealert: SettingsSideBlindZoneAlert_t) {
        dataPoolDataHandler.SETTINGS_SIDEBLINDZONEALERTSETTING_SIDEBLINDZONEALERTSETTING_FLAG.set(settingssideblindzonealert.ValidityFlag)
        dataPoolDataHandler.SETTINGS_SIDEBLINDZONEALERTSETTING_SIDEBLINDZONEALERTSETTING.set(settingssideblindzonealert.SideBlindZoneAlertSettingValue)
    }

    override fun onSETTINGS_RES_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING(settingssmarthighbeamassist: SettingsSmartHighBeamAssist_t) {
        dataPoolDataHandler.SETTINGS_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING_FLAG.set(settingssmarthighbeamassist.flag)
        dataPoolDataHandler.SETTINGS_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING.set(settingssmarthighbeamassist.value)
    }

    override fun onSETTINGS_RES_SPORTAUTOMODECUSTOMIZATIONS(settingssportautomodecustomizations: SettingsSportAutoModeCustomizations_t) {
        dataPoolDataHandler.SETTINGS_SPORTAUTOMODECUSTOMIZATIONS_SPORTAUTOMODECUSTOMIZATIONS_FLAG.set(settingssportautomodecustomizations.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_SPORTAUTOMODECUSTOMIZATIONS_SPORTAUTOMODECUSTOMIZATIONS.set(settingssportautomodecustomizations.SportAutoModeCustomizations)
    }

    override fun onSETTINGS_RES_SPORTMODESPORTAWDSETTINGS(settingssportmodesportawd: SettingsSportModeSportAWD_t) {
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTAWDSETTINGS_FLAG.set(settingssportmodesportawd.flag)
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTAWDSETTINGS.set(settingssportmodesportawd.SportModeSportAWDFlag)
    }

    override fun onSETTINGS_RES_SPORTMODESPORTADAPTIVECRUISECONTROL(settingssportmodesportadaptivecruisecontrol: SettingsSportModeSportAdaptiveCruiseControl_t) {
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTADAPTIVECRUISECONTROL_FLAG.set(settingssportmodesportadaptivecruisecontrol.SportModeSportAdaptiveCruiseControlFlag)
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTADAPTIVECRUISECONTROL.set(settingssportmodesportadaptivecruisecontrol.flag)
    }

    override fun onSETTINGS_RES_SPORTMODESPORTDISPLAYSETTINGS(settingssportmodesportdisplays: SettingsSportModeSportDisplays_t) {
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTDISPLAYSETTINGS_FLAG.set(settingssportmodesportdisplays.SportModeSportDisplaysFlag)
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTDISPLAYSETTINGS.set(settingssportmodesportdisplays.flag)
    }

    override fun onSETTINGS_RES_SPORTMODESPORTDRIVERSEAT(settingssportmodesportdriverseat: SettingsSportModeSportDriverSeat_t) {
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTDRIVERSEAT_FLAG.set(settingssportmodesportdriverseat.SportModeSportDriverSeatFlag)
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTDRIVERSEAT.set(settingssportmodesportdriverseat.flag)
    }

    override fun onSETTINGS_RES_SPORTMODESPORTPASSENGERSEAT(settingssportmodesportpassengerseat: SettingsSportModeSportPassengerSeat_t) {
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTPASSENGERSEAT_FLAG.set(settingssportmodesportpassengerseat.SportModeSportPassengerSeatFlag)
        dataPoolDataHandler.SETTINGS_SPORTMODESPORTPASSENGERSEAT.set(settingssportmodesportpassengerseat.flag)
    }


    override fun onSETTINGS_RES_SURROUNDVIEWLIGHTING(settingssurroundviewlighting: SettingsSurroundViewLighting_t) {
        dataPoolDataHandler.SETTINGS_SURROUNDVIEWLIGHTING_FLAG.set(settingssurroundviewlighting.SportModeSportAWDFlag)
        dataPoolDataHandler.SETTINGS_SURROUNDVIEWLIGHTING.set(settingssurroundviewlighting.flag)
    }

    override fun onSETTINGS_RES_SUSPENSIONCUSTOMIZATIONSETTINGS(settingssuspensioncustomization: SettingsSuspensionCustomization_t) {
        dataPoolDataHandler.SETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_FLAG.set(settingssuspensioncustomization.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS.set(settingssuspensioncustomization.SuspensionCustomizationSettings)
    }


    override fun onSETTINGS_RES_TRAFFICROADSIDEINFORMATIONSETTINGS(settingscollisiondetectiontrafficroadsideinformation: SettingsCollisionDetectionTrafficRoadSideInformation_t) {
        dataPoolDataHandler.SETTINGS_TRAFFICROADSIDEINFORMATIONSETTINGS_TRAFFICROADSIDEINFORMATIONCUSTOMIZATIONSETTING_FLAG.set(settingscollisiondetectiontrafficroadsideinformation.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_TRAFFICROADSIDEINFORMATIONSETTINGS_TRAFFICROADSIDEINFORMATIONCUSTOMIZATIONSETTING.set(settingscollisiondetectiontrafficroadsideinformation.TrafficRoadSideInformationCustomizationSetting)
    }

    override fun onSETTINGS_RES_TRUNKCONTROL(settingstrunkcontrol: SettingsTrunkControl_t) {
        dataPoolDataHandler.SETTINGS_TRUNKCONTROL_FLAG.set(settingstrunkcontrol.flag)
        dataPoolDataHandler.SETTINGS_TRUNKCONTROL.set(settingstrunkcontrol.value)
    }

    override fun onSETTINGS_RES_VEHICLEBRAKINGALERTSSETTINGS(settingscollisiondetectionconnectedvehiclebrakingalerts: SettingsCollisionDetectionConnectedVehicleBrakingAlerts_t) {
        dataPoolDataHandler.SETTINGS_VEHICLEBRAKINGALERTSSETTINGS_CONNECTEDVEHICLEBRAKINGALERTSCUSTOMIZATIONSETTING_FLAG.set(settingscollisiondetectionconnectedvehiclebrakingalerts.SettingAvailableFlag)
        dataPoolDataHandler.SETTINGS_VEHICLEBRAKINGALERTSSETTINGS_CONNECTEDVEHICLEBRAKINGALERTSCUSTOMIZATIONSETTING.set(settingscollisiondetectionconnectedvehiclebrakingalerts.ConnectedVehicleBrakingAlertsCustomizationSetting)
    }

    override fun onSETTINGS_RES_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING(settingsvehiclelocatorlights: SettingsVehicleLocatorLights_t) {
        dataPoolDataHandler.SETTINGS_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING_FLAG.set(settingsvehiclelocatorlights.flag)
        dataPoolDataHandler.SETTINGS_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING.set(settingsvehiclelocatorlights.value)
    }

    override fun onSETTINGS_RES_VALETMODESUCCESSFUL(pData: Int) {
    }

    override fun onSETTINGS_RES_VALETMODEFAILED(pData: Int) {
    }

    override fun onSETTINGS_RES_VALETMODERECOVERYSUCCESSFUL(pData: Int) {
    }

    override fun onSETTINGS_RES_VALETMODERECOVERYFAILED(pData: Int) {
    }


    override fun onSETTINGS_RES_VEHICLEMOVEMENTSTATE(pData: Int) {
        dataPoolDataHandler.SETTINGS_VEHICLEMOVEMENTSTATE.set(pData)
    }


    override fun onSETTINGS_RES_DRIVERWORLOADCONDITIONS(pData: Int) {
        dataPoolDataHandler.SETTINGS_DRIVERWORKLOADCONDITIONS.set(pData)
    }

    override fun onSETTINGS_RES_IGNITIONSTATUS(pData: Int) {
        dataPoolDataHandler.SETTINGS_IGNITIONSTATUS.set(pData)
    }

    override fun onSETTINGS_RES_IGNITIONOFFSLEEPTIMEOUT(pData: Int) {
    }

    override fun onSETTINGS_RES_INIT(settingsinitialization: SettingsInitialization_t) {
        dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(settingsinitialization.timeInfoHour)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(settingsinitialization.timeInfoMinute)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(settingsinitialization.timeInfoMeridiem)
        dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.set(settingsinitialization.timeDisplayFormat)
        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTORDSUPDATEOPTIONENABLED.set(settingsinitialization.autoTimeUpdateRdsOption)
        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTOTIMEPHONEUPDATEOPTIONENABLED.set(settingsinitialization.autoTimeUpdatePhoneOption)
        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTOTIMEUPDATESETTINGENUM.set(settingsinitialization.autoTimeUpdateSetting)
        dataPoolDataHandler.SETTINGS_LOCATIONSERVICES.set(settingsinitialization.locationServicesSetting)
        dataPoolDataHandler.SETTINGS_DISPLAYMODETYPE.set(settingsinitialization.displayModeType)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.set(settingsinitialization.CalendarDay)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.set(settingsinitialization.CalendarMonth)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.set(settingsinitialization.CalendarYear)
        //TODO
//        UI_PHONE_ACTIVEINCALLSWITCHSCREEN.set(settingsinitialization.)
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_DRIVERSEATBELTATTACHEDSTATUS.set(settingsinitialization.driverSeatBeltAttached)
        dataPoolDataHandler.SETTINGS_SEATBELTATTACHEDSTATUS_PASSENGERSEATBELTATTACHEDSTATUS.set(settingsinitialization.passengerSeatBeltAttached)
    }

//    fun ondataPoolDataHandler.SETTINGS_RES_OUTTEMPERATURE_VAL(uint32 + max_oat_val_len : Int + MAX_OAT_VAL_LEN)
//    {
//        dataPoolDataHandler.SETTINGS_OUTVEHICLETEMPERATURE.set(null)
//    }


    override fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: String) {
        dataPoolDataHandler.MEDIA_ALBUMARTSTATE.set(pData.toInt())
    }

    override fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: String) {
        dataPoolDataHandler.HMI_SETTINGS_RESTIRCTION_POPUP_FLAG.set(pData.toInt())
    }

    override fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: String) {
        dataPoolDataHandler.HMI_SETTINGS_RESET_MUSICINDEX_FLAG.set(pData.toInt())
    }

    override fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: String) {
        dataPoolDataHandler.SETTINGS_VEHICLESPEED_AVG_NONDRIVEN_VALIDITY.set(pData.toInt())
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOUNLOCKINGSETTING(settingsdl_setunlock: SettingsDL_SetUnlock_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOUNLOCKINGSETTING_FLAG.set(settingsdl_setunlock.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOUNLOCKINGSETTING.set(settingsdl_setunlock.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_LASTDOORCLOSEDLOCKINGSETTING(settingsdl_lastdoorclosedlocking: SettingsDL_LastDoorClosedLocking_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_LASTDOORCLOSEDLOCKINGSETTING_FLAG.set(settingsdl_lastdoorclosedlocking.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_LASTDOORCLOSEDLOCKINGSETTING.set(settingsdl_lastdoorclosedlocking.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_OPENDOORANTILOCKOUTSETTING(settingsdl_setopendoorantilockout: SettingsDL_SetOpenDoorAntiLockOut_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_OPENDOORANTILOCKOUTSETTING_FLAG.set(settingsdl_setopendoorantilockout.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_OPENDOORANTILOCKOUTSETTING.set(settingsdl_setopendoorantilockout.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_AUTOLOCKINGSETTING(settingsdl_setautolock: SettingsDL_SetAutoLock_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOLOCKINGSETTING_FLAG.set(settingsdl_setautolock.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOLOCKINGSETTING.set(settingsdl_setautolock.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING(settingsdl_setremoteunlockllightingfeedback: SettingsDL_SetRemoteUnlocklLightingFeedback_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING_FLAG.set(settingsdl_setremoteunlockllightingfeedback.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING.set(settingsdl_setremoteunlockllightingfeedback.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTELOCKINGFEEDBACKSETTING(settingsdl_setremotelockingfeedback: SettingsDL_SetRemoteLockingFeedback_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTELOCKINGFEEDBACKSETTING_FLAG.set(settingsdl_setremotelockingfeedback.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTELOCKINGFEEDBACKSETTING.set(settingsdl_setremotelockingfeedback.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_SELECTIVEUNLOCKINGSETTING(settingsdl_setselectiveunlocking: SettingsDL_SetSelectiveUnlocking_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_SELECTIVEUNLOCKINGSETTING_FLAG.set(settingsdl_setselectiveunlocking.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_SELECTIVEUNLOCKINGSETTING.set(settingsdl_setselectiveunlocking.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_RELOCKREMOTEUNLOCKEDDOORSETTING(settingsdl_setrelockremoteunlockeddoor: SettingsDL_SetRelockRemoteUnlockedDoor_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_RELOCKREMOTEUNLOCKEDDOORSETTING_FLAG.set(settingsdl_setrelockremoteunlockeddoor.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_RELOCKREMOTEUNLOCKEDDOORSETTING.set(settingsdl_setrelockremoteunlockeddoor.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESTART(settingsdl_setremotestart: SettingsDL_SetRemoteStart_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESTART_FLAG.set(settingsdl_setremotestart.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESTART.set(settingsdl_setremotestart.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATS(settingsdl_setremotestartautocoolseats: SettingsDL_SetRemoteStartAutoCoolSeats_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATS_FLAG.set(settingsdl_setremotestartautocoolseats.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATS.set(settingsdl_setremotestartautocoolseats.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOCOOLSEATSSETTINGS(settingsdl_setremotestartautocoolseatssettings: SettingsDL_SetRemoteStartAutoCoolSeatsSettings_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATSSETTINGS_FLAG.set(settingsdl_setremotestartautocoolseatssettings.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATSSETTINGS.set(settingsdl_setremotestartautocoolseatssettings.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATS(settingsdl_setremotestartautoheatseats: SettingsDL_SetRemoteStartAutoHeatSeats_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATS_FLAG.set(settingsdl_setremotestartautoheatseats.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATS.set(settingsdl_setremotestartautoheatseats.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEAUTOHEATSEATSSETTINGS(settingsdl_setremotestartautoheatseatssettings: SettingsDL_SetRemoteStartAutoHeatSeatsSettings_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATSSETTINGS_FLAG.set(settingsdl_setremotestartautoheatseatssettings.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATSSETTINGS.set(settingsdl_setremotestartautoheatseatssettings.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEWINDOWOPERATION(settingsdl_setremotewindowoperation: SettingsDL_SetRemoteWindowOperation_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEWINDOWOPERATION_FLAG.set(settingsdl_setremotewindowoperation.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEWINDOWOPERATION.set(settingsdl_setremotewindowoperation.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVEUNLOCKINGSETTING(settingsdl_setpassiveunlock: SettingsDL_SetPassiveUnlock_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVEUNLOCKINGSETTING_FLAG.set(settingsdl_setpassiveunlock.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVEUNLOCKINGSETTING.set(settingsdl_setpassiveunlock.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_PASSIVELOCKINGSETTING(settingsdl_setpassivelock: SettingsDL_SetPassiveLock_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVELOCKINGSETTING_FLAG.set(settingsdl_setpassivelock.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVELOCKINGSETTING.set(settingsdl_setpassivelock.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEINVEHICLEREMINDERSETTING(settingsdl_setremoteinvehiclereminder: SettingsDL_SetRemoteInVehicleReminder_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEINVEHICLEREMINDERSETTING_FLAG.set(settingsdl_setremoteinvehiclereminder.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEINVEHICLEREMINDERSETTING.set(settingsdl_setremoteinvehiclereminder.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTEREMOVEDFROMVEHICLEALERT(settingsdl_setremoteremovedfromvehiclealert: SettingsDL_SetRemoteRemovedFromVehicleAlert_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEREMOVEDFROMVEHICLEALERT_FLAG.set(settingsdl_setremoteremovedfromvehiclealert.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEREMOVEDFROMVEHICLEALERT.set(settingsdl_setremoteremovedfromvehiclealert.value)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_REMOTESLIDINGDOORSETTING(settingsdl_setremoteslidingdoor: SettingsDL_SetRemoteSlidingDoor_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESLIDINGDOORSETTING_FLAG.set(settingsdl_setremoteslidingdoor.flag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESLIDINGDOORSETTING.set(settingsdl_setremoteslidingdoor.value)
    }

    //CCustomizationECCProxy.cpp
    override fun onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(settingsclimateautodefog: SettingsClimateAutoDefog_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTODEFOGSETTING_AUTODEFOG_FLAG.set(settingsclimateautodefog.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTODEFOGSETTING_AUTODEFOG.set(settingsclimateautodefog.AutoDefogValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(settingsclimateautodefog)
    }

    override fun onCUSTOMIZATIONECC_RES_REARDEFOGSTARTUPSETTING(settingsclimateautoreardefog: SettingsClimateAutoRearDefog_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_REARDEFOGSTARTUPSETTING_REARDEFOG_FLAG.set(settingsclimateautoreardefog.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_REARDEFOGSTARTUPSETTING_REARDEFOG.set(settingsclimateautoreardefog.AutoDefogValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_REARDEFOGSTARTUPSETTING(settingsclimateautoreardefog)
    }

    override fun onCUSTOMIZATIONECC_RES_ELEVATEDIDLESETTING(settingsclimateelevatedidlecustomization: SettingsClimateElevatedIdleCustomization_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_ELEVATEDIDLESETTING_ELEVATEDIDLECUSTOMIZATIONSETTING_FLAG.set(settingsclimateelevatedidlecustomization.SettingAvailableFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ELEVATEDIDLESETTING_ELEVATEDIDLECUSTOMIZATIONSETTING.set(settingsclimateelevatedidlecustomization.ElevatedIdleCustomizationSetting)
        mCallback!!.onCUSTOMIZATIONECC_RES_ELEVATEDIDLESETTING(settingsclimateelevatedidlecustomization)
    }

    override fun onCUSTOMIZATIONECC_RES_IONIZERSETTING(settingsclimateionizer: SettingsClimateIonizer_t) {
        dataPoolDataHandler.HVAC_IONIZER_VEHICLESETTING_FLAG.set(settingsclimateionizer.ValidityFlag)
        dataPoolDataHandler.HVAC_IONIZER_VEHICLESETTING.set(settingsclimateionizer.IonizerSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_IONIZERSETTING(settingsclimateionizer)
    }

    override fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGSETTING(engineassistedheatingsetting: EngineAssistedHeatingSetting_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGSETTING_FLAG.set(engineassistedheatingsetting.flag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGSETTING.set(engineassistedheatingsetting.value)
    }

    override fun onCUSTOMIZATIONECC_RES_ENGINEASSISTEDHEATINGPLUGGEDINSETTING(engineassistedheatingpluggedinsetting: EngineAssistedHeatingPluggedInSetting_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGPLUGGEDINSETTING_FLAG.set(engineassistedheatingpluggedinsetting.flag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGPLUGGEDINSETTING.set(engineassistedheatingpluggedinsetting.value)
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOFANSETTING(settingsclimateautofanspeed: SettingsClimateAutoFanSpeed_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOFANSETTING_AUTOFANSPEED_FLAG.set(settingsclimateautofanspeed.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOFANSETTING_AUTOFANSPEED.set(settingsclimateautofanspeed.AutoFanSpeedValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AUTOFANSETTING(settingsclimateautofanspeed)
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(settingsclimateautoairdistribution: SettingsClimateAutoAirDistribution_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTRSETTING_AUTOAIRDISTRSETTING_FLAG.set(settingsclimateautoairdistribution.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTRSETTING_AUTOAIRDISTRSETTING.set(settingsclimateautoairdistribution.AutoAirDistrSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(settingsclimateautoairdistribution)
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOAIRDISTR1SETTING(settingsclimateautoairdistribution1: SettingsClimateAutoAirDistribution1_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTR1SETTING_AUTOAIRDISTRSETTING_FLAG.set(settingsclimateautoairdistribution1.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTR1SETTING_AUTOAIRDISTRSETTING.set(settingsclimateautoairdistribution1.AutoAirDistrSettingValue)
    }

    override fun onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(settingsclimateairqualitysensor: SettingsClimateAirQualitySensor_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AIRQUALITYSENSORSETTING_AIRQUALITYSENSOR_FLAG.set(settingsclimateairqualitysensor.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AIRQUALITYSENSORSETTING_AIRQUALITYSENSOR.set(settingsclimateairqualitysensor.AirQualitySensorValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(settingsclimateairqualitysensor)
    }

    override fun onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(settingsclimatepollutioncontrolsetting: SettingsClimatePollutionControlSetting_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_POLLUTIONCONTROLSETTING_POLLUTIONCONTROLSETTING_FLAG.set(settingsclimatepollutioncontrolsetting.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_POLLUTIONCONTROLSETTING_POLLUTIONCONTROLSETTING.set(settingsclimatepollutioncontrolsetting.PollutionControlSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(settingsclimatepollutioncontrolsetting)
    }


    override fun onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(settingsclimateautocoolseatssettingvalue: SettingsClimateAutoCoolSeatsSettingValue_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOCOOLSEATSSETTING_AUTOCOOLSEATSSETTING_FLAG.set(settingsclimateautocoolseatssettingvalue.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOCOOLSEATSSETTING_AUTOCOOLSEATSSETTING.set(settingsclimateautocoolseatssettingvalue.AutoCoolSeatsSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(settingsclimateautocoolseatssettingvalue)
    }

    override fun onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(settingsclimateautoheatedseats: SettingsClimateAutoHeatedSeats_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOHEATEDSEATSSETTING_AUTOHEATEDSEATSSETTING_FLAG.set(settingsclimateautoheatedseats.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOHEATEDSEATSSETTING_AUTOHEATEDSEATSSETTING.set(settingsclimateautoheatedseats.AutoHeatedSeatsSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(settingsclimateautoheatedseats)
    }

    override fun onCUSTOMIZATIONECC_RES_REARZONESTARTUPSETTING(settingsrearclimateonstartup: SettingsRearClimateOnStartUp_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_REARZONESTARTUPSETTING_REARCLIMATEONSTARTUPSETTING_FLAG.set(settingsrearclimateonstartup.ValidityFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_REARZONESTARTUPSETTING_REARCLIMATEONSTARTUPSETTING.set(settingsrearclimateonstartup.RearClimateOnStartUpSettingValue)
        mCallback!!.onCUSTOMIZATIONECC_RES_REARZONESTARTUPSETTING(settingsrearclimateonstartup)
    }

    //CDeviceProjectionProxy.cpp
    override fun onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(pData: Int) {
        dataPoolDataHandler.DEVICEPROJECTION_APPLECARPLAYENABLE.set(pData)
        mCallback?.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(pData)
    }

    override fun onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(pData: Int) {
        dataPoolDataHandler.DEVICEPROJECTION_GOOGLEAUTOLINKENABLE.set(pData)
        mCallback?.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(pData)
    }

    //CCustomizationECCProxy.cpp
    override fun onCUSTOMIZATIONECC_RES_SUPPORTEDSETTINGS(customizationeccavailibilityflag: CustomizationECCAvailibilityFlag_t) {
        dataPoolDataHandler.CUSTOMIZATIONECC_ACMODESETTING_ACMODESETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateACModeSettingFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AIRQUALITYSENSORSETTING_AIRQUALITYSENSOR_FLAG.set(customizationeccavailibilityflag.settingsClimateAirQualitySensorFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTRSETTING_AUTOAIRDISTRSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoAirDistributionFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOCOOLSEATSSETTING_AUTOCOOLSEATSSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoCoolSeatsSettingValueFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTODEFOGSETTING_AUTODEFOG_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoDefogFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOFANSETTING_AUTOFANSPEED_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoFanSpeedFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOHEATEDSEATSSETTING_AUTOHEATEDSEATSSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoHeatedSeatsFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_REARDEFOGSTARTUPSETTING_REARDEFOG_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoRearDefogFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOZONETEMPSETTING_AUTOZONESETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoZoneFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ELEVATEDIDLESETTING_ELEVATEDIDLECUSTOMIZATIONSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateElevatedIdleCustomizationFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_HVACREMOTESTARTSETTING_HVACREMOTESTARTSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateHVACRemoteStartSettingFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_POLLUTIONCONTROLSETTING_POLLUTIONCONTROLSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimatePollutionControlSettingFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_REARZONESTARTUPSETTING_REARCLIMATEONSTARTUPSETTING_FLAG.set(customizationeccavailibilityflag.settingsRearClimateOnStartUpFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_AUTOAIRDISTR1SETTING_AUTOAIRDISTRSETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateAutoAirDistribution1Flag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGPLUGGEDINSETTING_FLAG.set(customizationeccavailibilityflag.engineAssistedHeatingPluggedInSettingFlag)
        dataPoolDataHandler.CUSTOMIZATIONECC_ENGINEASSISTEDHEATINGSETTING_FLAG.set(customizationeccavailibilityflag.engineAssistedHeatingSettingFlag)
        dataPoolDataHandler.HVAC_IONIZER_SETTING_FLAG.set(customizationeccavailibilityflag.settingsClimateIonizerFlag)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_SUPPORTEDSETTINGS(settingsdl_availibilityflag: SettingsDL_AvailibilityFlag_t) {
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_LASTDOORCLOSEDLOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_LastDoorClosedLockingFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOLOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetAutoLockFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_OPENDOORANTILOCKOUTSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetOpenDoorAntiLockOutFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_SELECTIVEUNLOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetPassiveLockFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_AUTOUNLOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetPassiveUnlockFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVELOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRelockRemoteUnlockedDoorFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_PASSIVEUNLOCKINGSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteInVehicleReminderFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_RELOCKREMOTEUNLOCKEDDOORSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteLockingFeedbackFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEINVEHICLEREMINDERSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteRemovedFromVehicleAlertFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTELOCKINGFEEDBACKSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteSlidingDoorFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEREMOVEDFROMVEHICLEALERT_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteStartFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESLIDINGDOORSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteStartAutoCoolSeatsFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTESTART_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteStartAutoCoolSeatsSettingsFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATS_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteStartAutoHeatSeatsFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOCOOLSEATSSETTINGS_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteStartAutoHeatSeatsSettingsFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATS_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteUnlocklLightingFeedbackFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEAUTOHEATSEATSSETTINGS_FLAG.set(settingsdl_availibilityflag.settingsDL_SetRemoteWindowOperationFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEUNLOCKLIGHTINGFEEDBACKSETTING_FLAG.set(settingsdl_availibilityflag.settingsDL_SetSelectiveUnlockingFlag)
        dataPoolDataHandler.CUSTOMIZATIONDOORLOCKS_REMOTEWINDOWOPERATION_FLAG.set(settingsdl_availibilityflag.settingsDL_SetUnlockFlag)
    }

    override fun onCUSTOMIZATIONDOORLOCKS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsdl_availibilityflag: GlobalSettingsDL_AvailibilityFlag_t) {
        dataPoolDataHandler.VEHICLESETTINGS_POWERDOORLOCK_FLAG.set(globalsettingsdl_availibilityflag.powerDoorLockFlag)
        dataPoolDataHandler.VEHICLESETTINGS_REMOTELOCK_FLAG.set(globalsettingsdl_availibilityflag.remoteLockFlag)
    }

    override fun onCUSTOMIZATIONECC_RES_GLOBALSUPPORTEDSETTINGS(pData: Int) {
        dataPoolDataHandler.VEHICLESETTINGS_CLIMATE_FLAG.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERACTIVE(pData: Int) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERACTIVE.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINSTOREDSTATUS(pData: Int) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERPINSTOREDSTATUS.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERREPORTCARDDATA(settingsteendriverreportcarddata: SettingsTeenDriverReportCardData_t) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERMAXIMUMSPEEDREPORT.set(settingsteendriverreportcarddata.TeenDriverMaximumSpeedReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVEDISTANCEDRIVENREPORT.set(settingsteendriverreportcarddata.TeenDriveDistanceDrivenReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVEROVERSPEEDEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverOverspeedEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERTRACTIONCONTROLEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverTractionControlEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERSTABILITYCONTROLEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverStabilityControlEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERANTILOCKBRAKESYSTEMACTIVEEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverAntilockBrakeSystemActiveEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFORWARDCOLLISIONHEADWAYALERTSREPORT.set(settingsteendriverreportcarddata.TeenDriverForwardCollisionHeadwayAlertsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFORWARDCOLLISIONIMMINENTALERTSREPORT.set(settingsteendriverreportcarddata.TeenDriverForwardCollisionImminentAlertsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERREVERSECOLLISIONMITIGATIONBRAKINGEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverReverseCollisionMitigationBrakingEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFORWARDCOLLISIONMITIGATIONBRAKINGEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverForwardCollisionMitigationBrakingEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERDROWSYDRIVERALERTSREPORT.set(settingsteendriverreportcarddata.TeenDriverDrowsyDriverAlertsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERWIDEOPENTHROTTLEEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverWideOpenThrottleEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERLANEDEPARTUREWARNINGEVENTSREPORT.set(settingsteendriverreportcarddata.TeenDriverLaneDepartureWarningEventsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERTAILGATINGALERTSREPORT.set(settingsteendriverreportcarddata.TeenDriverTailgatingAlertsReport)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERMAXSPEEDAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverMaxSpeedAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERDISTANCEDRIVENAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverDistanceDrivenAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVEROVERSPEEDAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverOverspeedAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERTRACTIONCONTROLAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverTractionControlAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERSTABILITYCONTROLAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverStabilityControlAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERABSACTIVEAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverABSActiveAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFWDCOLLISIONHEADWAYALERTAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverFwdCollisionHeadwayAlertAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFWDCOLLISIONIMMINENTALERTAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverFwdCollisionImminentAlertAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERREVCOLLISIONMITIGATIONBRAKINGAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverRevCollisionMitigationBrakingAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERFWDCOLLISIONMITIGATIONBRAKINGAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverFwdCollisionMitigationBrakingAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERDROWSYDRIVERALERTAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverDrowsyDriverAlertAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERWIDEOPENTHROTTLEAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverWideOpenThrottleAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERLANEDEPARTUREWARNINGAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverLaneDepartureWarningAvailabilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERREPORTCARDDATA_TEENDRIVERTAILGATINGALERTAVAILABILITY_FLAG.set(settingsteendriverreportcarddata.TeenDriverTailgatingAlertAvailabilityFlag)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING(settingsteendriverspeedlimitcustomizationsetting: SettingsTeenDriverSpeedLimitCustomizationSetting_t) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING_SETTINGAVAILABLE_FLAG.set(settingsteendriverspeedlimitcustomizationsetting.SettingAvailableFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING_SPEEDLIMITSTATUS.set(settingsteendriverspeedlimitcustomizationsetting.SpeedLimitStatus)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERSPEEDLIMITCUSTOMIZATIONSETTING_SPEEDLIMITDISPLAYVALUE.set(settingsteendriverspeedlimitcustomizationsetting.SpeedLimitDisplayValue)
    }

    override fun onTEENDRIVER_RES_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING(settingsteendriveroverspeedwarningcustomizationsetting: SettingsTeenDriverOverspeedWarningCustomizationSetting_t) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING_SETTINGAVAILABLE_FLAG.set(settingsteendriveroverspeedwarningcustomizationsetting.SettingAvailableFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING_OVERSPEEDWARNINGCURRENTSTATUS.set(settingsteendriveroverspeedwarningcustomizationsetting.OverspeedWarningCurrentStatus)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVEROVERSPEEDWARNINGCUSTOMIZATIONSETTING_OVERSPEEDWARNINGCURRENTSETTINGVALUE.set(settingsteendriveroverspeedwarningcustomizationsetting.OverspeedWarningCurrentSettingValue)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINSUCESSFUL(pData: Int) {
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINFAILED(pData: Int) {
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYSPINCLEARED(pData: Int) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERKEYSPINCLEARED.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYCONFIGURATION(pData: Int) {
        //TODO
        //TEENDRIVER_TEENDRIVERKEYCONFIGURATION.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERPRESENT(pData: Int) {
        //TODO
//        TEENDRIVER_TEENDRIVERKEYLESSTRANSMITTERPRESENT.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYTRADITIONALKEYCONFIGURATIONSTATUS(pData: Int) {
//TODO
//        TEENDRIVER_TEENDRIVERTRADITIONALKEYCONFIGURATIONSTATUS.set(pData)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERKEYLESSTRANSMITTERCONFIGURATIONSTATUS(pData: Int) {
        //TODO
//        TEENDRIVER_TEENDRIVERKEYLESSTRANSMITTERCONFIGURATIONSTATUS.set(pData)
    }

    override fun onTEENDRIVER_RES_CHECK_KEY(pData: Int) {
    }

    override fun onTEENDRIVER_RES_INIT(teendriverinitialization: TeenDriverInitialization_t) {
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERACTIVE.set(teendriverinitialization.teenDriverActive)
        dataPoolDataHandler.SETTINGS_TEENDRIVER_AVAILABLE_FLAG.set(teendriverinitialization.teenDriverAvailibilityFlag)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERKEYCONFIGURATION.set(teendriverinitialization.configType)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERTRADITIONALKEYCONFIGURATIONSTATUS.set(teendriverinitialization.configStatus)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERKEYLESSTRANSMITTERCONFIGURATIONSTATUS.set(teendriverinitialization.keylessConfigStatus)
        dataPoolDataHandler.TEENDRIVER_TEENDRIVERKEYLESSTRANSMITTERPRESENT.set(teendriverinitialization.keylessTransmitterPresent)
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONSUCCESSFUL(uint32: Int) {
    }

    override fun onTEENDRIVER_RES_TEENDRIVERPINAUTHENTICATIONFAILED(uint32: Int) {
    }


    /**/

    override fun onSOUNDPARAMS_RES_AMPDSPMODE(pData: Int) {
        //TODO
//        SOUNDPARAMS_AMPDSPMODE.set(pData)
    }

    override fun onSOUNDPARAMS_RES_AUDIOCUEVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_AUDIOCUEVOLUME.set(pData)
        dataPoolDataHandler.SOUNDPARAMS_AUDIOCUEVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_BALANCE(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_BALANCE.set(pData)
    }

    override fun onSOUNDPARAMS_RES_BASS(max_volume_length: Int) {
        dataPoolDataHandler.SOUNDPARAMS_BASS.set(max_volume_length.toString())
    }

    override fun onSOUNDPARAMS_RES_CHIMEVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_CHIMEVOLUME.set(pData)
        dataPoolDataHandler.SOUNDPARAMS_CHIMEVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_FADE(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_FADE.set(pData)
    }

    override fun onSOUNDPARAMS_RES_SURROUND(max_volume_length: Int) {
        dataPoolDataHandler.SOUNDPARAMS_SURROUND.set(max_volume_length.toString())
    }

    override fun onSOUNDPARAMS_RES_MAXIMUMSTARTUPVOLUME(pData: Int) {

        dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.set(pData)

    }

    override fun onSOUNDPARAMS_RES_MIDRANGE(max_volume_length: Int) {
        dataPoolDataHandler.SOUNDPARAMS_MIDRANGE.set(max_volume_length.toString())
    }

    override fun onSOUNDPARAMS_RES_MUTE(muteres: MuteRes_t) {
        dataPoolDataHandler.SOUNDPARAMS_MUTE.set(muteres.mute)
        dataPoolDataHandler.SOUNDPARAMS_AUDIO_MUTE.set(muteres.mute)
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERMAXIMUMVOLUMELIMIT(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMAXIMUMVOLUMELIMIT.set(pData)
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERMINIMUMVOLUMELIMIT(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMINIMUMVOLUMELIMIT.set(pData)
    }

    override fun onSOUNDPARAMS_RES_TEENDRIVERVOLUMELIMITINGENABLED(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERVOLUMELIMITINGENABLED.set(pData)
    }

    override fun onSOUNDPARAMS_RES_TREBLE(max_volume_length: Int) {
        dataPoolDataHandler.SOUNDPARAMS_TREBLE.set(max_volume_length.toString())
    }

    override fun onSOUNDPARAMS_RES_SPEEDVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_SPEEDVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTED(pData: Int) {
    }

    override fun onSOUNDPARAMS_RES_SEATBELTATTACHEDSTATUSVOLUMERESTRICTIONCOMPLETE(pData: Int) {
    }

    override fun onSOUNDPARAMS_RES_VOLUME(volumegroupextent: VolumeGroupExtent_t) {

    }

    override fun onLGSP_VG_NONE() {
    }

    override fun onLGSP_VG_MAIN() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_MAINVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_AUDIO_MUTE.set(null)
        dataPoolDataHandler.SOUNDPARAMS_AUDIO_MUTE.set(null)
    }


    override fun onLGSP_VG_EMERGENCY_PHONE() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_EMERGENCY_PHONE_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_EMERGENCY_PHONE_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_EMERGENCYPHONEVOLUME.set(null)
    }


    override fun onLGSP_VG_RING_TONE() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_RING_TONE_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_RING_TONE_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_RINGTONEVOLUME.set(null)
    }

    override fun onLGSP_VG_ALERT() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_ALERT_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_ALERT_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_ALERTVOLUME.set(null)
    }


    override fun onLGSP_VG_CHIME() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_CHIME_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_CHIME_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_CHIMEVOLUME.set(null)
    }


    override fun onLGSP_VG_ANDROIDAUTO() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_MAINVOLUME.set(null)
    }

    override fun onSOUNDPARAMS_RES_ALERTVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_ALERTVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_MAINVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_MAINVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_PHONEVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_PHONEVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_PROMPTVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_PROMPTVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_RINGTONEVOLUME(pData: Int) {
        dataPoolDataHandler.SOUNDPARAMS_RINGTONEVOLUME.set(pData)
    }

    override fun onSOUNDPARAMS_RES_VOLUMEGROUPEXTENTS(spvolumegroupextentstream: SPVolumeGroupExtentStream_t) {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_VOLUMEGROUPEXTENTCNT.set(spvolumegroupextentstream.volumeGroupExtentCnt)
    }

    override fun onLGSP_VG_CARPLAY() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_MAINVOLUME.set(null)
    }

    override fun onLGSP_VG_PHONE() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PHONE_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PHONE_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_PHONEVOLUME.set(null)
    }

    override fun onLGSP_VG_PROMPT() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PROMPT_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PROMPT_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_PROMPTVOLUME.set(null)
    }


    override fun onLGSP_VG_TRAFFIC() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_TRAFFIC_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_TRAFFIC_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_TRAFFICVOLUME.set(null)
    }

    override fun onLGSP_VG_AUDIO_CUE() {
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_AUDIO_CUE_MINIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_AUDIO_CUE_MAXIMUMVOLUME.set(null)
        dataPoolDataHandler.SOUNDPARAMS_AUDIOCUEVOLUME.set(null)
    }


    override fun onLGSP_VG_TEENDRIVER() {
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMINIMUMVOLUMELIMIT.set(null)
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMAXIMUMVOLUMELIMIT.set(null)
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERVOLUME.set(null)
    }


    override fun onSOUNDPARAMS_RES_MODEINIT(soundparametersmodeinitialization: SoundParametersModeInitialization_t) {
        dataPoolDataHandler.SOUNDPARAMS_AMPDSPMODE.set(soundparametersmodeinitialization.modeType)
        dataPoolDataHandler.SOUNDPARAMS_BASS.set(soundparametersmodeinitialization.bass)
        dataPoolDataHandler.SOUNDPARAMS_BALANCE.set(soundparametersmodeinitialization.balance)
        dataPoolDataHandler.SOUNDPARAMS_FADE.set(soundparametersmodeinitialization.fade)
        dataPoolDataHandler.SOUNDPARAMS_SURROUND.set(soundparametersmodeinitialization.surround)
        dataPoolDataHandler.SOUNDPARAMS_TREBLE.set(soundparametersmodeinitialization.treble)
        dataPoolDataHandler.SOUNDPARAMS_MIDRANGE.set(soundparametersmodeinitialization.midrange)

        dataPoolDataHandler.SOUNDPARAMS_MUTE.set(soundparametersmodeinitialization.muteFlag)
    }


    override fun onSOUNDPARAMS_RES_VOLUMEINIT(soundparametersvolumeinitialization: SoundParametersVolumeInitialization_t) {
        dataPoolDataHandler.SOUNDPARAMS_MAINVOLUME.set(soundparametersvolumeinitialization.mainvolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxMainVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_MAIN_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minMainVolume)
        dataPoolDataHandler.SOUNDPARAMS_PHONEVOLUME.set(soundparametersvolumeinitialization.phonevolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PHONE_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxPhoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PHONE_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minPhoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_EMERGENCYPHONEVOLUME.set(soundparametersvolumeinitialization.emergencyPhoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_EMERGENCY_PHONE_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxEmergencyPhoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_EMERGENCY_PHONE_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minEmergencyPhoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_PROMPTVOLUME.set(soundparametersvolumeinitialization.promptVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PROMPT_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxPromptVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_PROMPT_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minPromptVolume)
        dataPoolDataHandler.SOUNDPARAMS_RINGTONEVOLUME.set(soundparametersvolumeinitialization.ringtoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_RING_TONE_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxRingtoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_RING_TONE_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minRingtoneVolume)
        dataPoolDataHandler.SOUNDPARAMS_ALERTVOLUME.set(soundparametersvolumeinitialization.alertVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_ALERT_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxAlertVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_ALERT_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minAlertVolume)
        dataPoolDataHandler.SOUNDPARAMS_AUDIOCUEVOLUME.set(soundparametersvolumeinitialization.audiocueVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_AUDIO_CUE_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxAudiocueVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_AUDIO_CUE_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minAudiocueVolume)
        dataPoolDataHandler.SOUNDPARAMS_CHIMEVOLUME.set(soundparametersvolumeinitialization.chimevolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_CHIME_MAXIMUMVOLUME.set(soundparametersvolumeinitialization.maxChimeVolume)
        dataPoolDataHandler.SOUNDPARAMS_VOLUMEGROUPEXTENTS_CHIME_MINIMUMVOLUME.set(soundparametersvolumeinitialization.minChimeVolume)
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMAXIMUMVOLUMELIMIT.set(soundparametersvolumeinitialization.maxTeendrivervolume)
        dataPoolDataHandler.SOUNDPARAMS_TEENDRIVERMINIMUMVOLUMELIMIT.set(soundparametersvolumeinitialization.minTeendrivervolume)
    }


    override fun onSETTINGS_RES_PROPERUSEWARNING(pData: Int) {
        dataPoolDataHandler.SETTINGS_PROPERUSEWARNING_DISPLAYSTATUS.set(pData)
    }

    override fun onSETTINGS_RES_MEDIAALBUMARTSTATE(pData: Int) {
        dataPoolDataHandler.MEDIA_ALBUMARTSTATE.set(pData)
    }

    override fun onSETTINGS_RES_LOCATIONSERVICESNOTIFICATION(pData: Int) {
        //TODO
//        SETTINGS_LOCATIONSERVICES.set(pData)
        dataPoolDataHandler.HMI_LOCATION_SERVICE.set(pData)
    }

    override fun onSETTINGS_RES_VALETMODESTORAGEUNLOCK(pData: Int) {
    }

    override fun onSETTINGS_RES_RESETMUSICINDEXENABLE(pData: Int) {
        dataPoolDataHandler.HMI_SETTINGS_RESET_MUSICINDEX_FLAG.set(pData)
    }

    override fun onSETTINGS_RES_VEHICLEGEARSTATE(pData: Int) {
        dataPoolDataHandler.SETTINGS_VEHICLEGEARVALUE.set(pData)
    }

    override fun onSETTINGS_RES_ACTIVECALLVIEWSETTING(pData: Int) {
        dataPoolDataHandler.UI_PHONE_ACTIVEINCALLSWITCHSCREEN.set(pData)
    }

    override fun onSETTINGS_RES_RESTRICTIONPOPUP(pData: Int) {
        dataPoolDataHandler.HMI_SETTINGS_RESTIRCTION_POPUP_FLAG.set(pData)
    }

    override fun onSETTINGS_RES_VEHICLESPEEDAVGNONDRIVENVALIDITY(pData: Int) {
        dataPoolDataHandler.SETTINGS_VEHICLESPEED_AVG_NONDRIVEN_VALIDITY.set(pData)
    }

    override fun onSETTINGS_RES_VALETMODESTATUS(pData: Int) {
        dataPoolDataHandler.SETTINGS_VALETMODE_STATUS.set(pData)
    }


    override fun onSETTINGS_RES_OUTTEMPERATURE_VAL(max_oat_val_len: Int) {
        dataPoolDataHandler.SETTINGS_OUTVEHICLETEMPERATURE.set(max_oat_val_len)
    }

    override fun onSETTINGS_RES_DATEINFO(dateinfo: DateInfo_t) {
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.set(dateinfo.CalendarDay)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.set(dateinfo.CalendarMonth)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.set(dateinfo.CalendarYear)
        val calendar = Calendar.getInstance()
        dataPoolDataHandler.SETTINGS_DATEINFO_MAXVALUE.set(calendar.getActualMaximum(Calendar.DATE))
    }

    override fun onSETTINGS_RES_TIMEINFO(timeinfo: TimeInfo_t) {
        dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(timeinfo.HourOfDay)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(timeinfo.MinuteOfHour)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(timeinfo.meridiem)
        mCallback?.onSETTINGS_RES_TIMEINFO(timeinfo)


        //TODO
//        HMI_STATUSBAR_TIME_TIMEINFO.set(timeinfo.)
//        HMI_SETTINGS_DATETIME_MINUTE.set(timeinfo.)
//        HMI_SETTINGS_DATETIME_MERIDIEM.set(null)
//        HMI_SETTINGS_DATETIME_TIMEINFO.set(null)
    }

    /**
     * response for supported languages
     * update languages list and count
     * @param SettingsSupportedLanguages_t passes list count,list of language type
     */
    override fun onSETTINGS_RES_SUPPORTEDLANGUAGES(settingssupportedlanguages: SettingsSupportedLanguages_t) {
        dataPoolDataHandler.SETTINGS_SUPPORTEDLANGUAGES_COUNT.set(settingssupportedlanguages.count)
        dataPoolDataHandler.SETTINGS_SUPPORTEDLANGUAGES_VALUES.set(settingssupportedlanguages.languageType)
        mCallback?.onSETTINGS_RES_SUPPORTEDLANGUAGES(settingssupportedlanguages)
    }


    override fun onSETTINGS_RES_TIME_OR_DATE(timeOrDate: Boolean) {
        dataPoolDataHandler.SETTINGS_TIME_OR_DATE.set(timeOrDate)

    }

    /**
     * creating string from lanuages and contry
     * @param Locale
     */
    fun localeToString(language: Locale): String {
        return language.language + "," + language.country
    }

    override fun onSETTINGS_RES_TIMEDISPLAYFORMAT(timDisplayType: eSettingsTimeDisplayFormat) {
        dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.set(timDisplayType)
        val calender = Calendar.getInstance()
        if (timDisplayType == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE) {
            dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR_OF_DAY))
            dataPoolDataHandler.SETTINGS_USE_24HOUR_FORMAT_TOGGLESTATE.set(true)
        } else {
            dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR))
            dataPoolDataHandler.SETTINGS_USE_24HOUR_FORMAT_TOGGLESTATE.set(false)
        }
        mCallback?.onSETTINGS_RES_TIMEDISPLAYFORMAT(timDisplayType)
    }

    override fun onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(settingsautotimeupdatesetting: SettingsAutoTimeUpdateSetting_t) {

        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTOTIMEUPDATESETTINGENUM.set(settingsautotimeupdatesetting.autoTimeUpdateSettingEnum)
        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTORDSUPDATEOPTIONENABLED.set(settingsautotimeupdatesetting.autoRDSUpdateOptionEnabled)
        dataPoolDataHandler.SETTINGS_AUTOTIMEDATEUPDATESETTING_AUTOTIMEPHONEUPDATEOPTIONENABLED.set(settingsautotimeupdatesetting.autoTimePhoneUpdateOptionEnabled)
        if (settingsautotimeupdatesetting.autoTimeUpdateSettingEnum == eSettingsAutoTimeDateUpdateSetting.SETTINGS_SS_TIME_DATE_UPDATE_MANUAL) {
            dataPoolDataHandler.SETTINGS_AUTOMATIC_TIMEDATE_TOGGLESTATE.set(false)
        } else {
            dataPoolDataHandler.SETTINGS_AUTOMATIC_TIMEDATE_TOGGLESTATE.set(true)
        }

        mCallback?.onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(settingsautotimeupdatesetting)


    }

    override fun onSETTINGS_RES_TIMEZONE() {

        mCallback!!.onSETTINGS_RES_TIMEZONE()
    }

    override fun onSETTINGS_RES_AUTOMATICTIMEZONE() {
        mCallback!!.onSETTINGS_RES_AUTOMATICTIMEZONE()
    }


    override fun onSETTINGS_RES_SOUND_MENU() {
        mCallback?.onSETTINGS_RES_SOUND_MENU()
    }

    // for sound module maxvolume setup
    override fun onSETTINGS_RES_GETMAXSTARTUPVOLUME(pData: Int) {
        // SOUNDPARAMS_CHIMEVOLUME.set(pData)
        dataPoolDataHandler.SOUNDPARAMS_MAXTUNEVALUE.set(pData)

        mCallback?.onSETTINGS_RES_GETMAXSTARTUPVOLUME(pData)
    }


    // for sound module audiocue volume
    override fun onSETTINGS_RES_AUDIOCUES(pData: Int) {
        dataPoolDataHandler.SETTINGS_AUDIOCUES.set(pData)
        mCallback?.onSETTINGS_RES_AUDIOCUES(pData)
    }


    /**
     * response for set language
     * @param ESettingsLanguageType passes language type
     */
    override fun onSETTINGS_RES_LANGUAGE(any: Any, selectedLocale: Locale) {
        dataPoolDataHandler.SETTINGS_LANGUAGE.set(any.toString())
        mCallback?.onSETTINGS_RES_LANGUAGE(any, selectedLocale)
    }


    override fun onFAVORITE_RES_AUDIOMAXFAVCOUNT(any: Any) {
        dataPoolDataHandler.SETTINGS_CURRENT_NUMBER_FAVORITES.set(any as Int)
        mCallback?.onFAVORITE_RES_AUDIOMAXFAVCOUNT(any)

    }


    override fun onSETTINGS_RES_CONTAINER_MENU_LIST() {
        mCallback!!.onSETTINGS_RES_CONTAINER_MENU_LIST()
    }


    /**
     *Response for vehicle list
     */
    override fun onSETTINGS_RES_VEHICLELIST(vehicleList: ArrayList<String>) {
        dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.clear()
        dataPoolDataHandler.SETTINGS_REQ_VEHICLEDATA.addAll(vehicleList)
        mCallback?.onSETTINGS_RES_VEHICLELIST(vehicleList)
    }

    /**
     *Response for driving mode list
     */
    override fun onSETTINGS_RES_DRIVINGMODELIST(driverModeList: ArrayList<DriveModeModel>) {
        if (dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.size == 0) {
            dataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.addAll(driverModeList)
        }
        mCallback?.onSETTINGS_RES_DRIVINGMODELIST(driverModeList)
    }

    /**
     *Response for engine sound list
     */
    override fun onSETTINGS_RES_ENGINESOUNDLIST(enginemodeList: ArrayList<ESettingsChangePerfModeSound>) {

        mCallback?.onSETTINGS_RES_ENGINESOUNDLIST(enginemodeList)
    }


    override fun onSETTINGS_RES_BUILDCLICK() {
        mCallback?.onSETTINGS_RES_BUILDCLICK()
    }


    override fun onSETTINGS_RES_BUILDNUMBER() {

        // for build number
        val sb = StringBuilder()

        try {

            val result = UpdateManager.getInstance().installedPackages
            if (result != null) {
                val installedPackages = result.value
                if (installedPackages.size != 0) {
                    Collections.sort(installedPackages,
                            Comparator { o1, o2 ->
                                if (o1.installedDateTime === o2.installedDateTime) {
                                    return@Comparator 0

                                }
                                if (o1.installedDateTime.after(o2.installedDateTime)) -1 else 1
                            })

                    for (installedPackage in installedPackages) {

                        val aboutInfoItem = AboutListItem(installedPackage.title, installedPackage.version,
                                DateFormat.getMediumDateFormat(SettingsService.appContext!!).format(installedPackage.installedDateTime),
                                installedPackage.version, installedPackage.releaseNotes, ""
                        )
                        dataPoolDataHandler.SETTINGS_ABOUT_INFO_DATA.add(aboutInfoItem)
                        // for build number
                        sb.append(DateFormat.getLongDateFormat(SettingsService.appContext!!).format(installedPackage.installedDateTime))
                        sb.append(":")
                        sb.append(installedPackage.title)
                        sb.append(":")
                        sb.append(installedPackage.version)
                        sb.append(System.getProperty("line.separator", "\n"))

                    }
                }

            }

        } catch (e: Exception) {
            //    android.util.Log.e(TAG, "There was an error retrieving the installation history", e)
        }

        mCallback?.onSETTINGS_RES_BUILDNUMBER()
    }

    private val TAG_OpenSource = "AboutOpenSourceSoftwareActivity"
    override fun onSETTINGS_RES_OPENSOURCE(path: String) {
        if (TextUtils.isEmpty(path)) {
            Log.e(TAG_OpenSource, "The system property for the license file is empty")
            return
        }
        val files = arrayOfNulls<File>(1)
        files[0] = File(path)
        if (!files[0]!!.exists() || files[0]!!.length() == 0L) {
            com.gm.settingsservice.utils.Log.e(TAG_OpenSource, "License file $path does not exist")
            return
        }

        // Kick off external viewer due to WebView security restrictions; we
        // carefully point it at HTMLViewer, since it offers to decompress
        // before viewing.
        dataPoolDataHandler.HTML_VIEWER_PATH.set(path)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.fromFile(files[0]), "text/html")
        intent.putExtra(Intent.EXTRA_TITLE, "Open Source Software")
        //  intent.putExtra("DriveMode", getDriverWorkloadTriggerLevel())
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.setPackage("com.gm.htmlviewer")
        dataPoolDataHandler.HTML_INTENT_VIEW.set(intent)
        try {
            //    SettingsService.appContext.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e(TAG_OpenSource, "Failed to find viewer", e)
        }

    }

    /**
     *Response for vehicle tab
     */
    override fun onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsavailibilityflag: GlobalSettingsAvailibilityFlag_t) {
        /*    SETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTINGS_REARSEATREMINDERCUSTOMIZATIONSETTING_FLAG.set(globalsettingsavailibilityflag.rearSeatReminderFlag)
            VEHICLESETTINGS_DRIVINGMODE_FLAG.set(globalsettingsavailibilityflag.drivingModeFlag)
            VEHICLESETTINGS_SPORTSMODE_FLAG.set(globalsettingsavailibilityflag.sportsModeCustomizationFlag)
            SETTINGS_SPORTAUTOMODECUSTOMIZATIONS_SPORTAUTOMODECUSTOMIZATIONS_FLAG.set(globalsettingsavailibilityflag.autoModeCustomizationFlag)
            VEHICLESETTINGS_COLLISIONDETECTION_FLAG.set(globalsettingsavailibilityflag.collisionDetectionFlag)
            VEHICLESETTINGS_COMFORTCONVENIENCE_FLAG.set(globalsettingsavailibilityflag.comfortConvenienceFlag)
            VEHICLESETTINGS_LIGHTING_FLAG.set(globalsettingsavailibilityflag.lightingFlag)
            VEHICLESETTINGS_ENERGY_FLAG.set(globalsettingsavailibilityflag.energyFlag)
            VEHICLESETTINGS_POWERTAKEOFF_FLAG.set(globalsettingsavailibilityflag.powerTakeoffFlag)*/
        mCallback?.onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(globalsettingsavailibilityflag)
    }

    override fun onSETTINGS_RES_SETMODESTATUS(settingsDriverModeStatus_t: SettingsDriverModeStatus_t) {
        mCallback?.onSETTINGS_RES_SETMODESTATUS(settingsDriverModeStatus_t)
    }

    /**
     *Response for driver mode status
     */
    override fun onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(any: Any) {
        /*  SETTINGS_DRIVERSELECTEDMODESTATUS_DRIVERSELECTEDMODE1STATUS.set(settingsdrivermodestatus.DriverSelectedMode1Status)
          SETTINGS_DRIVERSELECTEDMODESTATUS_DRIVERSELECTEDMODE2STATUS.set(settingsdrivermodestatus.DriverSelectedMode2Status)
          SETTINGS_DRIVERSELECTEDMODESTATUS_DRIVERSELECTEDMODE3STATUS.set(settingsdrivermodestatus.DriverSelectedMode3Status)
          SETTINGS_DRIVERSELECTEDMODESTATUS_DRIVERSELECTEDMODE4STATUS.set(settingsdrivermodestatus.DriverSelectedMode4Status)
          SETTINGS_DRIVERSELECTEDMODESTATUS_DRIVERSELECTEDMODE5STATUS.set(settingsdrivermodestatus.DriverSelectedMode5Status)*/
        mCallback?.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(any)
    }

    /**
     *Response for driver mode
     */
    override fun onSETTINGS_RES_SUPPORTEDSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        /*  SETTINGS_ADAPTIVEFORWARDLIGHTINGCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING_FLAG.set(settingsavailibilityflag.settingsAdaptiveForwardLightingFlag)
          SETTINGS_ADAPTIVEFORWARDLIGHTING1CUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTING_FLAG.set(settingsavailibilityflag.SettingsAdaptiveForwardLighting1Flag)
          SETTINGS_ADAPTIVEFORWARDLIGHTINGWITHGPSCUSTOMIZATIONSETTING_ADAPTIVEFORWARDLIGHTINGWITHGPS_FLAG.set(settingsavailibilityflag.settingsAdaptiveForwardLightingWithGPSFlag)
          SETTINGS_ADAPTIVEHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsavailibilityflag.settingsAdaptiveHighBeamAssistWithSensitivityFlag)
          SETTINGS_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_ADAPTIVEHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsavailibilityflag.settingsAdaptiveHighBeamAssistWithSensitivityFlag)
          SETTINGS_AUTOHIGHBEAMASSISTCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSIST_FLAG.set(settingsavailibilityflag.settingsAutoHighBeamAssistFlag)
          SETTINGS_AUTOHIGHBEAMASSISTWITHSENSITIVITYCUSTOMIZATIONSETTING_AUTOHIGHBEAMASSISTWITHSENSITIVITY_FLAG.set(settingsavailibilityflag.settingsAutoHighBeamAssistWithSensitivityFlag)
          SETTINGS_DAYTIMETAILLIGHTSCUSTOMIZATIONSETTING_DAYTIMETAILLIGHTS_FLAG.set(settingsavailibilityflag.settingsDaytimeTailLightsFlag)
          SETTINGS_LEFTRIGHTHANDTRAFFICCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFIC_FLAG.set(settingsavailibilityflag.settingsLeftRightHandTrafficFlag)
          SETTINGS_LEFTRIGHTHANDTRAFFICWITHGPSCUSTOMIZATIONSETTING_LEFTRIGHTHANDTRAFFICWITHGPS_FLAG.set(settingsavailibilityflag.settingsLeftRightHandTrafficWithGPSFlag)
          SETTINGS_SMARTHIGHBEAMASSISTCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsSmartHighBeamAssistFlag)
          SETTINGS_EXITLIGHTINGCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsExitLightingFlag)
          SETTINGS_SURROUNDVIEWLIGHTING_FLAG.set(settingsavailibilityflag.settingsSurroundViewLightingFlag)
          SETTINGS_VEHICLELOCATORLIGHTSCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsVehicleLocatorLightsFlag)
          SETTINGS_ALERTTYPESETTINGS_ALERTTYPECUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsCollisionDetectionAlertTypeFlag)
          SETTINGS_VEHICLEBRAKINGALERTSSETTINGS_CONNECTEDVEHICLEBRAKINGALERTSCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsCollisionDetectionConnectedVehicleBrakingAlertsFlag)
          SETTINGS_INTERSECTIONSTOPALERTSETTINGS_INTERSECTIONSTOPALERTCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsCollisionDetectionIntersectionStopAlertFlag)
          SETTINGS_REARCAMERAPARKASSISTSETTINGS_REARCAMERAPARKASSISTCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsCollisionDetectionRearCameraParkAssistFlag)
          SETTINGS_TRAFFICROADSIDEINFORMATIONSETTINGS_TRAFFICROADSIDEINFORMATIONCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsCollisionDetectionTrafficRoadSideInformationFlag)
          SETTINGS_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING_DRIVERDROWSINESSDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsDriverDrowsinessDetectionCustomizationFlag)
          SETTINGS_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FRONTPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsFrontPedestrianDetectionCustomizationFlag)
          SETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS_GONOTIFIERCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsGoNotifierCustomizationFlag)
          SETTINGS_LANECHANGEALERTSETTING_LANECHANGEALERTSETTING_FLAG.set(settingsavailibilityflag.settingsLaneChangeAlertFlag)
          SETTINGS_PARKASSISTSETTING_PARKASSISTSETTING_FLAG.set(settingsavailibilityflag.settingsParkAssistFlag)
          SETTINGS_PARKASSISTWITHTOWBARSETTING_PARKASSISTWITHTOWBARSETTING_FLAG.set(settingsavailibilityflag.settingsParkAssistWithTowbarFlag)
          SETTINGS_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING_PEDESTRIANFRIENDLYALERTCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsPedestrianFriendlyAlertFlag)
          SETTINGS_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_REARPEDESTRIANDETECTIONCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsRearPedestrianDetectionCustomizationFlag)
          SETTINGS_SEATBELTTIGHTENINGCUSTOMIZATIONSETTING_SEATBELTTIGHTENINGCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSeatBeltTighteningCustomizationFlag)
          SETTINGS_SIDEBLINDZONEALERTSETTING_SIDEBLINDZONEALERTSETTING_FLAG.set(settingsavailibilityflag.settingsSideBlindZoneAlertFlag)
          SETTINGS_REARCROSSTRAFFICALERTSETTING_REARCROSSTRAFFICALERTSETTING_FLAG.set(settingsavailibilityflag.settingstRearCrossTrafficAlertFlag)
          SETTINGS_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTING_FORWARDCOLLISIONALERTCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.setttingForwardCollisionAlertCustomizationFlag)
          //TODO
  //        SETTINGS_PERFMODESOUNDCUSTOMIZATIONSETTING_PERFMODESOUNDCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.modes)
          SETTINGS_PERFMODESTEERINGCUSTOMIZATIONSETTINGS_STEERINGCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSteeringCustomizationFlag)
          SETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSuspensionCustomizationFlag)
          SETTINGS_TRACTIONCONTROLSYSTEMSTATUS_TRACTIONCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsTractionCustomizationFlag)
          SETTINGS_ENGINERUNACTIVE_FLAG.set(settingsavailibilityflag.engineRunActiveSettingFlag)
          //TODO
  //        SETTINGS_PERFMODEDISPLAYCUSTOMIZATIONSETTING_FLAG.set(settingsavailibilityflag.settingsPerfModeDisplayCustomizationFlag)
          SETTINGS_AUTOMATICVEHICLEHOLDSETTING_FLAG.set(settingsavailibilityflag.settingsAutomaticVehicleHoldFlag)
          SETTINGS_AUTOMEMORYRECALLSETTING_FLAG.set(settingsavailibilityflag.settingsAutoMemoryRecallFlag)
          SETTINGS_AUTOMEMORYRECALL1SETTING_FLAG.set(settingsavailibilityflag.settingsAutoMemoryRecall1Flag)
          SETTINGS_AUTOMEMORYRECALL2SETTING_FLAG.set(settingsavailibilityflag.settingsAutoMemoryRecall2Flag)
          SETTINGS_AUTOMIRRORFOLDINGSETTING_FLAG.set(settingsavailibilityflag.settingsAutoMirrorFoldingFlag)
          SETTINGS_AUTOWIPEINREVERSEGEARSETTING_FLAG.set(settingsavailibilityflag.settingsAutoWipeinReverseGearFlag)
          SETTINGS_EASYEXITDRIVERSEATSETTING_FLAG.set(settingsavailibilityflag.settingsEasyExitDriverSeatFlag)
          SETTINGS_EASYEXITOPTIONSSETTING_FLAG.set(settingsavailibilityflag.settingsEasyExitOptionsFlag)
          SETTINGS_EASYEXITSTEERINGCOLUMN1SETTING_FLAG.set(settingsavailibilityflag.settingsEasyExitSteeringColumn1Flag)
          SETTINGS_EASYEXITSTEERINGCOLUMN2SETTING_FLAG.set(settingsavailibilityflag.settingsEasyExitSteeringColumn2Flag)
          SETTINGS_PERSONALIZATIONBYDRIVERSETTING_FLAG.set(settingsavailibilityflag.settingsPersonalizationbyDriverFlag)
          SETTINGS_RAINSENSEWIPERSSETTING_FLAG.set(settingsavailibilityflag.settingsRainSenseWipersFlag)
          SETTINGS_REVERSETILTMIRRORSETTING_FLAG.set(settingsavailibilityflag.settingsReverseTiltMirrorFlag)
          SETTINGS_REVERSETILTMIRROR1SETTING_FLAG.set(settingsavailibilityflag.settingsReverseTiltMirror1Flag)
          SETTINGS_REVERSETILTMIRROR2SETTING_FLAG.set(settingsavailibilityflag.settingsReverseTiltMirror2Flag)
          SETTINGS_TRUNKCONTROL_FLAG.set(settingsavailibilityflag.settingsTrunkControlFlag)
          SETTINGS_EASYEXITSTEERINGCOLUMNSETTING_FLAG.set(settingsavailibilityflag.settingsEasyExitSteeringColumnFlag)
          SETTINGS_SPORTMODESPORTADAPTIVECRUISECONTROL_FLAG.set(settingsavailibilityflag.settingsSportModeSportAdaptiveCruiseControlFlag)
          SETTINGS_SPORTMODESPORTAWDSETTINGS_FLAG.set(settingsavailibilityflag.settingsSportModeSportAWDFlag)
          SETTINGS_SPORTMODESPORTDISPLAYSETTINGS_FLAG.set(settingsavailibilityflag.settingsSportModeSportDisplaysFlag)
          SETTINGS_SPORTMODESPORTDRIVERSEAT_FLAG.set(settingsavailibilityflag.settingsSportModeSportDriverSeatFlag)
          SETTINGS_SPORTMODESPORTPASSENGERSEAT_FLAG.set(settingsavailibilityflag.settingsSportModeSportPassengerSeatFlag)
          SETTINGS_SPORTMODESPORTSTEERINGSETTINGS_FLAG.set(settingsavailibilityflag.settingsSportModeSportSteeringFlag)
          SETTINGS_SPORTMODESPORTSUSPENSIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSportModeSportSuspensionFlag)
          SETTINGS_SEATBELTATTACHEDSTATUS_DRIVERSEATBELTATTACHED_FLAG.set(settingsavailibilityflag.driverSeatBeltAttachedValidityFlag)
          SETTINGS_SEATBELTATTACHEDSTATUS_PASSENGERSEATBELTATTACHED_FLAG.set(settingsavailibilityflag.passengerSeatBeltAttachedValidityFlag)
          SETTINGS_STANDBYSPEED_FLAG.set(settingsavailibilityflag.settingsPowerTakeOffStandbySpeedFlag)
          SETTINGS_SET1SPEED_FLAG.set(settingsavailibilityflag.settingsPowerTakeOffSet1SpeedFlag)
          SETTINGS_SET2SPEED_FLAG.set(settingsavailibilityflag.settingsPowerTakeOffSet2SpeedFlag)
          SETTINGS_TAPSTEPSPEED_FLAG.set(settingsavailibilityflag.settingsPowerTakeOffTapStepSpeedFlag)
          SETTINGS_SHUTDOWNTIME_FLAG.set(settingsavailibilityflag.settingsPowerTakeOffShutdownTimeFlag)
          SETTINGS_LOCATIONBASEDCHARGING_FLAG.set(settingsavailibilityflag.settingsEnergyLocationBasedChargingFlag)
          SETTINGS_ENERGYSUMMARYPOPUP_FLAG.set(settingsavailibilityflag.settingsEnergySummaryPopupFlag)
          SETTINGS_CHARGESTATUSFEEDBACK_FLAG.set(settingsavailibilityflag.settingsEnergyChargeStatusFeedbackFlag)
          SETTINGS_CHARGECORDTHEFTALERT_FLAG.set(settingsavailibilityflag.settingsEnergyChargeCordTheftAlertFlag)
          SETTINGS_CHARGEPOWERLOSSALERT_FLAG.set(settingsavailibilityflag.settingsEnergyChargePowerLossAlertFlag)*/
        //SETTINGS_PERFMODESOUNDCUSTOMIZATIONSETTING_PERFMODESOUNDCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.SettingsChangePerfModeSoundCustomizationFlag)
        // SETTINGS_PERFMODESTEERINGCUSTOMIZATIONSETTINGS_STEERINGCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSteeringCustomizationFlag)
        // SETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_SUSPENSIONCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsSuspensionCustomizationFlag)
        // SETTINGS_TRACTIONCONTROLSYSTEMSTATUS_TRACTIONCUSTOMIZATIONSETTINGS_FLAG.set(settingsavailibilityflag.settingsTractionCustomizationFlag)
        mCallback?.onSETTINGS_RES_SUPPORTEDSETTINGS(settingsavailibilityflag)
    }

    //response for display menu
    override fun onSETTINGS_RES_DISPLAY(isProximity: Boolean) {
        //below id used for set Proximity sensing
        dataPoolDataHandler.SETTINGS_DISPLAY_PROXI.set(isProximity)
        mCallback?.onSETTINGS_RES_DISPLAY(dataPoolDataHandler.SETTINGS_DISPLAY_PROXI.get()!!)

    }

    //response for set display mode
    override fun onSETTINGS_RES_DISPLAYMODETYPE(eSettingsdisplayMode: eSettingsdisplayMode) {
        dataPoolDataHandler.SETTINGS_DISPLAYMODETYPE.set(eSettingsdisplayMode)
        mCallback?.onSETTINGS_RES_DISPLAYMODETYPE(eSettingsdisplayMode)
    }

    /**
     *Response for engine sound
     */
    override fun onSETTINGS_RES_PERFMODESOUNDCUSTOMIZATIONSETTING(settingschangeperfmodesoundcustomization: ArrayList<ESettingsChangePerfModeSound>) {
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_ENGINE.clear()
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_ENGINE.addAll(settingschangeperfmodesoundcustomization)
    }

    /**
     *Response for engine sound
     */
    override fun onSETTINGS_RES_SUPPORTEDSPORTSETTINGS(settingsavailibilityflag: SettingsAvailibilityFlag_t) {
        mCallback?.onSETTINGS_RES_SUPPORTEDSPORTSETTINGS(settingsavailibilityflag)
    }

    /**
     *Response for steering
     */
    override fun onSETTINGS_RES_SPORTMODESPORTSTEERINGSETTINGS(settingssportmodesportsteering: ArrayList<ESettingsSteeringCustomization>) {
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_STEERING.clear()
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_STEERING.addAll(settingssportmodesportsteering)
    }

    /**
     *Response for suspension
     */
    override fun onSETTINGS_RES_SPORTMODESPORTSUSPENSIONSETTINGS(settingssportmodesportsuspension: ArrayList<ESettingsSuspensionCustomization>) {
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_SUSPENSION.clear()
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_SUSPENSION.addAll(settingssportmodesportsuspension)

    }

    /**
     *Response for traction
     */
    override fun onSETTINGS_RES_TRACTIONCONTROLSYSTEMSTATUS(settingstractioncustomization: ArrayList<ESettingsTractionCustomization>) {
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_TRACTION.clear()
        dataPoolDataHandler.SETTINGS_DRIVE_MODE_TRACTION.addAll(settingstractioncustomization)
    }


    override fun onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(any)
    }

    override fun onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any) {
        mCallback?.onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any)
    }

    override fun onSETTINGS_APPS_RES_DATA() {
        mCallback?.onSETTINGS_APPS_RES_DATA()
    }

    override fun onSETTINGS_RES_COLLISION_DATA() {
        mCallback?.onSETTINGS_RES_COLLISION_DATA()
    }



}
