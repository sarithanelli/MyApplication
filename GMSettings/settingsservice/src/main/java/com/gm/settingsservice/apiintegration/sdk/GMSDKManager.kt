package com.gm.settingsservice.apiintegration.sdk

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.pm.IPackageStatsObserver
import android.content.pm.PackageManager
import android.content.pm.PackageStats
import android.os.*
import android.provider.Settings
import android.text.format.Formatter
import com.android.internal.app.LocalePicker
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.apiintegration.apiinterfaces.IManager
import com.gm.settingsservice.models.*

import com.gm.settingsservice.utils.*
import com.gm.settingsservice.utils.Constants.CLIMATE_DISABLE_SETTING
import com.gm.settingsservice.utils.Constants.CLIMATE_ENABLE_SETTING
import com.gm.settingsservice.utils.Constants.DISABLE_SETTING
import com.gm.settingsservice.utils.Constants.ENABLE_SETTING
import com.gm.settingsservice.utils.Constants.HOURS_12
import com.gm.settingsservice.utils.Constants.HOURS_24
import dagger.Lazy
import gm.content.LanguageInfo
import gm.content.SupportedLanguageListData
import gm.media.audio.VehicleAudioManager
import gm.panel.Panel
import gm.powermode.PowerModeManager
import gm.vehicle.DateAndTime
import java.util.*
import kotlin.collections.ArrayList
import gm.vehicle.Customization
import javax.inject.Inject


/**
 *  It should contain SETTING_REQs,
 *
 *  This file will also contain SDK calls from GM SDK.
 *  only some requests that are being used contain "SETTING_REQs" in function definition, only these should be added
 *  these funcs usually start after proxy constructor func in CAMFMProxy.cpp
 *  This should exclude all the functions under RecvData func, as the func in RecvData only corresponds to RES functions
 */
class GMSDKManager @Inject constructor(val dataPoolDataHandler: DataPoolDataHandler, val systemListener: SystemListener, val  utility: Utility, val settingsManager: SettingsManager, val vehicleAudioManager: dagger.Lazy<VehicleAudioManager>, val context: Context, val mCustomization : Customization, val supportedLanguageListData: Lazy<SupportedLanguageListData>): IManager, ApplicationsState.Callbacks {

    override fun onSETTINGS_MANAGE_SET_FAV() {
        systemListener.onSETTINGS_MANAGE_RES_FAV()
    }

    override fun onSETTINGS_APPS_REQ_DATA() {
        systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.ANDROID_AUTO_ENABLED))
        systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.CARPLAY_ENABLED))
    }

    override fun onSETTINGS_REQ_APPS_INNER(any: Any) {
        dataPoolDataHandler.SETTINGS_SET_APPS_INNER_TITLE.set((any as AppsModeModel).primaryData)
        dataPoolDataHandler.SETTINGS_SET_APPS_INNER_DES.set(any.description)
        dataPoolDataHandler.SETTINGS_SET_APPS_INNER_STATE.set(any.isToggleState)
        dataPoolDataHandler.SETTINGS_SET_APPS_INNER_REF.set(any.reference)
    }


    override fun onDEVICEPROJECTION_REQ_SETAPPLECARPLAYENABLE(any: Any) {

        val value: Int = if (any is AppsModeModel) {
            if (any.isToggleState) {
                DISABLE_SETTING
            } else {
                ENABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                ENABLE_SETTING
            } else {
                DISABLE_SETTING
            }
        }
        Settings.System.putInt(SettingsService.appContext.contentResolver, Constants.CARPLAY_ENABLED, value)
        systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.CARPLAY_ENABLED))
        /* if (value == 0) {
             systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.BAIDU_CARLIFE_ENABLED))
         }*/
    }

    override fun onDEVICEPROJECTION_REQ_SETGOOGLEAUTOLINKENABLE(any: Any) {
        val value: Int = if (any is AppsModeModel) {
            if (any.isToggleState) {
                DISABLE_SETTING
            } else {
                ENABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                ENABLE_SETTING
            } else {
                DISABLE_SETTING
            }
        }
        Settings.System.putInt(SettingsService.appContext.contentResolver, Constants.ANDROID_AUTO_ENABLED, value)
        systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.ANDROID_AUTO_ENABLED))
        /* if (value == 0) {
             systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.BAIDU_CARLIFE_ENABLED))
         }*/
    }


    /**
     *Request for set engine sound type
     */
    override fun onSETTINGS_REQ_SETENGINESOUNDTYPE(any: Any) {
        val value = dataPoolDataHandler.ENGINESOUND_MAP.get(any.toString())!!
        mCustomization.setSoundPerformanceModeCustomizationSettingRequest(value)
    }

    /**
     *Request for set suspension type
     */
    override fun onSETTINGS_REQ_SETSUSPENSIONTYPE(any: Any) {
        val value: Int = dataPoolDataHandler.SUSPENSION_MAP.get(any.toString())!!
        Signals.PerformanceModeSuspensionSignal().setSignalValue(value)

    }

    /**
     *Request for set steering type
     */
    override fun onSETTINGS_REQ_SETSTEERINGTYPE(any: Any) {

        val value: Int = dataPoolDataHandler.STEERING_MAP.get(any.toString())!!
        Signals.PerformanceModeSteeringSignal().setSignalValue(value)
    }

    /**
     *Request for set traction type
     */
    override fun onSETTINGS_REQ_SETTRACTIONTYPE(any: Any) {
        val value: Int = dataPoolDataHandler.TRACTION_MAP.get(any.toString())!!
        Signals.PerformanceModeDrivelineSignal().setSignalValue(value)
    }

    override fun onSETTINGS_REQ_SPORTMODESETTINGS(any: Any) {
        systemListener.onSETTINGS_RES_SPORTMODESETTINGS(any)
    }

    override fun onSETTINGS_REQ_SPORTMODECHANGESETTINGS(any: Any) {}


    override fun onSETTINGS_REQ_DISPLAY_CADILLAC() {
        systemListener.onSETTINGS_RES_DISPLAY_CADILLAC(dataPoolDataHandler.DISPLAY_CADILLAC_SELECT)
    }

    override fun onSETTINGS_REQ_CLIMATE_INNER(any: Any) {
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_TITLE.set((any as ClimateModeModel).primaryData)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_DES.set(any.description)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_STATE.set(any.isToggleState)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_REF.set(any.reference)
    }

    override fun onRunningStateChanged(running: Boolean) {
    }

    override fun onPackageListChanged() {
    }

    override fun onRebuildComplete(apps: java.util.ArrayList<ApplicationsState.AppEntry>?) {
    }

    override fun onPackageIconChanged() {
    }

    override fun onPackageSizeChanged(packageName: String?) {
    }

    override fun onAllSizesComputed() {
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAIRQUALITYSENSORSETTING(any: Any) {
        mCustomization.setAirQualitySensorCustomizationChangeSettingRequest(any as Int)
    }

    override fun onSETTINGS_REQ_CLIMATE_MENU_LIST(any: Any) {
        systemListener.onSETTINGS_RES_CLIMATE_MENU_LIST()
    }


    override fun onCUSTOMIZATIONECC_REQ_SETAUTODEFOGSETTING(any: Any) {
        val value: Int = if (any is ClimateModeModel) {
            if (any.isToggleState) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        }
        mCustomization.setAutomaticDefogCustomizationChangeSettingRequest(value)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETIONIZERSETTINGS(any: Any) {
        val value: Int = if (any is ClimateModeModel) {
            if (any.isToggleState) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        }
        mCustomization.setIonizerControlCustomizationChangeSettingRequest(value)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOFANSETTING(any: Any) {
        mCustomization.setAutomaticFanCustomizationChangeSettingRequest(any as Int)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOAIRDISTRSETTINGS(any: Any) {
        mCustomization.setAutoAirDistributionCustomizationChangeSettingRequest(any as Int)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETPOLLUTIONCONTROLSETTINGS(any: Any) {
        val value: Int = if (any is ClimateModeModel) {
            if (any.isToggleState) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        }
        mCustomization.setPollutionControlCustomizationChangeSettingRequest(value)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOCOOLSEATSSETTING(any: Any) {
        val value: Int = if (any is ClimateModeModel) {
            if (any.isToggleState) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        }
        mCustomization.setAutomaticCooledSeatCustomizationChangeSettingRequest(value)

    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOHEATEDSEATSSETTING(any: Any) {
        val value: Int = if (any is ClimateModeModel) {
            if (any.isToggleState) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                CLIMATE_ENABLE_SETTING
            } else {
                CLIMATE_DISABLE_SETTING
            }
        }
        mCustomization.setAutomaticHeatedSeatCustomizationChangeSettingRequest(value)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETREARZONESTARTUPSETTINGS(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onSETTINGS_RETURNTOFACTORY(any: Any) {

    }

    override fun onSETTINGS_REQ_DRIVINGMODELIST(driverModeList: Any) {
        val vehicleData = ArrayList<DriveModeModel>()
        (driverModeList as Array<String>).forEach {
            when (it) {
                (driverModeList)[Constants.VEHICLE_ENGINE_SOUND] -> {
                    if ((AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).isAvailable &&
                                    AppSignal.getInstance(AppSignal.SignalKey.PerformanceModeSound).hasAvailableOptions())) {

                    }
                }

            }
        }
        systemListener.onSETTINGS_RES_DRIVINGMODELIST(vehicleData)
    }

    override fun onSETTINGS_REQ_GETLANGUAGE() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_REQ_ERASESETTINGSPERSONALDATA(any: Any) {
    }


    override fun onSETTINGS_REQ_RESETVEHICLESETTINGS(any: Any) {
    }

    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onSETTINGS_REQ_SETAUDIBLETOUCHFEEDBACK(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK3() {
    }

    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK2() {
    }




    override fun initListeners() {
        settingsManager.initListeners()
    }

    private var mSupportedLanguageKeys: ArrayList<Int>? = null
    private var mContext: Context? = null

    private var mCurrentKey: Int? = 0
    private var mLanInfo: LanguageInfo? = null
    private var mTimeAndDate = DateAndTime()


    // request for current time
    override fun onSETTINGS_REQ_GETTIMEINFO() {
        systemListener.onSETTINGS_RES_TIMEINFO(utility.getCurrentTime())
    }

    // request for current date
    override fun onSETTINGS_REQ_GETDATEINFO() {
        utility.setMinMaxLimits()
        systemListener.onSETTINGS_RES_DATEINFO(utility.getCurrentDate())
    }

    override fun onSETTINGS_REQ_TIMEDATE() {
        //dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.clear()
        onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()
        onSETTINGS_REQ_GETTIMEZONE()
        onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()
        onSETTINGS_REQ_GETDATEINFO()
        onSETTINGS_REQ_GETTIMEINFO()
        /*onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()
        onSETTINGS_REQ_GETTIMEINFO()
        onSETTINGS_REQ_GETDATEINFO()
        onSETTINGS_REQ_GETAUTOMATICTIMEZONE()
        onSETTINGS_REQ_GETTIMEZONE()
        onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()*/
    }

    /**
     * This method is launch the sound menu list
     */
    override fun onSETTINGS_REQ_SOUND_MENU() {
        systemListener.onSETTINGS_RES_SOUND_MENU()
    }

    override fun onSETTINGS_REQ_SETTIMEHOURDEC(any: Any) {
        val timeInfo = utility.setCalenderTime(Calendar.HOUR_OF_DAY, any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(any)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))

    }

    override fun onSETTINGS_REQ_SETTIMEHOURINC(any: Any) {
        val timeInfo = utility.setCalenderTime(Calendar.HOUR_OF_DAY, any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(any)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }

    override fun onSETTINGS_REQ_SETTIMEMINUTEDEC(any: Any) {
        val timeInfo = utility.setCalenderTime(Calendar.MINUTE, any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        //   dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(any)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }

    override fun onSETTINGS_REQ_SETTIMEMINUTEINC(any: Any) {
        val timeInfo = utility.setCalenderTime(Calendar.MINUTE, any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        // dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(any)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }

    override fun onSETTINGS_REQ_SETTIMEPM(any: Any) {
        val timeInfo = utility.setTimeMeridien(any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_POST)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }


    override fun onSETTINGS_REQ_SETTIMEAM(any: Any) {
        val timeInfo = utility.setTimeMeridien(any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }

    override fun onSETTINGS_REQ_SETDATEDAYDEC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.DATE, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())
    }

    override fun onSETTINGS_REQ_SETDATEDAYINC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.DATE, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())
    }

    override fun onSETTINGS_REQ_SETDATEMONTHDEC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.MONTH, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())
    }

    override fun onSETTINGS_REQ_SETDATEMONTHINC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.MONTH, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())
    }

    override fun onSETTINGS_REQ_SETDATEYEARDEC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.YEAR, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())

    }

    override fun onSETTINGS_REQ_SETDATEYEARINC(any: Any) {
        val dateInfo_t = utility.setCalenderDate(Calendar.YEAR, any as Int)
        dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.set(any)
        systemListener.onSETTINGS_RES_DATEINFO(dateInfo_t)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertDateInMillis())
    }


    override fun onSETTINGS_REQ_TIMEORDATE(any: Any) {
        if (dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.get() == Constants.SET_TIME_SCREEN) {
            systemListener.onSETTINGS_RES_TIME_OR_DATE(true)
            onSETTINGS_REQ_GETTIMEINFO()
        } else if (dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.get() == Constants.SET_DATE_SCREEN) {
            systemListener.onSETTINGS_RES_TIME_OR_DATE(false)
            onSETTINGS_REQ_GETDATEINFO()

        }
    }

    override fun onSETTINGS_REQ_SETTIMEDISPLAYFORMAT(any: Any) {
        if (any is TimeDateModel) {
            if (any.isToggleState) {
                Settings.System.putString(SettingsService.appContext.contentResolver,
                        Settings.System.TIME_12_24, HOURS_24)
                systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE)
                val calender = Calendar.getInstance()
                dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR_OF_DAY))
            } else {
                Settings.System.putString(SettingsService.appContext.contentResolver,
                        Settings.System.TIME_12_24, HOURS_12)
                systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE)
                val calender = Calendar.getInstance()
                dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR))
            }
        }
        systemListener.onSETTINGS_RES_TIMEINFO(utility.getCurrentTime())
    }

    override fun onSETTINGS_REQ_GETTIMEDISPLAYFORMAT() {
        val formatVal = Settings.System.getString(SettingsService.appContext.contentResolver, Settings.System.TIME_12_24)
        if (formatVal == HOURS_24) {
            systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE)
        } else {
            systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE)
        }
    }

    override fun onSETTINGS_REQ_SETAUTOTIMEDATEUPDATESETTING(any: Any) {

        if (any is TimeDateModel) {
            if (!any.isToggleState) {
                systemListener.onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(SettingsAutoTimeUpdateSetting_t(eSettingsAutoTimeDateUpdateSetting.SETTINGS_SS_TIME_DATE_UPDATE_MANUAL, 1, 1))
            } else {
                systemListener.onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(SettingsAutoTimeUpdateSetting_t(eSettingsAutoTimeDateUpdateSetting.SETTINGS_SS_TIME_DATE_UPDATE_AUTO_PHONE, 1, 1))
            }
        }

    }

    override fun onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING() {
        systemListener.onSETTINGS_RES_AUTOTIMEDATEUPDATESETTING(SettingsAutoTimeUpdateSetting_t(eSettingsAutoTimeDateUpdateSetting.SETTINGS_SS_TIME_DATE_UPDATE_AUTO_PHONE, 1, 1))

    }

    override fun onSETTINGS_REQ_SETTIMEZONE(any: Any) {
        val alarm = SettingsService.appContext
                .getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarm.setTimeZone((any as GmTimeZone).id)
        systemListener.onSETTINGS_RES_TIMEZONE()

        onSETTINGS_REQ_GETTIMEINFO()
    }

    override fun onSETTINGS_REQ_SETAUTOMATICTIMEZONE() {
        systemListener.onSETTINGS_RES_AUTOMATICTIMEZONE()
    }

    override fun onSETTINGS_REQ_GETTIMEZONE() {
        systemListener.onSETTINGS_RES_TIMEZONE()
    }

    override fun onSETTINGS_REQ_GETAUTOMATICTIMEZONE() {
        systemListener.onSETTINGS_RES_AUTOMATICTIMEZONE()
    }

   // var vehicleAudioManager: VehicleAudioManager = VehicleAudioManager(SettingsService.appContext)

    override fun onSETTINGS_REQ_GETMAXSTARTUPVOLUME() {
        // for progress bar setMax value
        dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.set(VehicleAudioManager.STREAM_VOLUME_MAX)
        // for default value for setProgress
        var volume = vehicleAudioManager.get().maxStartupVolume
        systemListener.onSETTINGS_RES_GETMAXSTARTUPVOLUME(volume)

    }

    override fun onSETTINGS_REQ_SETMAXSTARTUPVOLUME(any: Any) {
        var changeVolume = vehicleAudioManager.get().maxStartupVolume + any as Int
        vehicleAudioManager.get().maxStartupVolume = changeVolume
        systemListener.onSETTINGS_RES_GETMAXSTARTUPVOLUME(changeVolume)
    }


    override fun onSETTINGS_REQ_SETAUDIOCUES(any: Any) {
        var volume = vehicleAudioManager.get()
                .getStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE)
        var changeVolume = volume + any as Int
        //set set_audio_cue_volume
        vehicleAudioManager.get().setStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE, changeVolume)
        systemListener.onSETTINGS_RES_AUDIOCUES(changeVolume)
    }

    override fun onSETTINGS_REQ_GETAUDIOCUES() {
        // for progress bar setMax value
        dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.set(VehicleAudioManager.STREAM_VOLUME_MAX)
        // for default value for setProgress
        var volume = vehicleAudioManager.get()
                .getStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE)
        systemListener.onSETTINGS_RES_AUDIOCUES(volume)
    }


    /**
     * request for supported languages
     */
    override fun onSETTINGS_REQ_GETSUPPORTEDLANGUAGES() {
        val mSupportedLanguageKeys = SupportedLanguageListData.getInstance().getSupportedLanguageList(SettingsService.appContext)
        val languageList = ArrayList<ESettingsLanguageType>()
        mSupportedLanguageKeys.sort()
        if (mSupportedLanguageKeys != null && mSupportedLanguageKeys.size > 0) {
            for (lang in mSupportedLanguageKeys) {
                val mSettingsLanguageDataMap = SupportedLanguageListData.getInstance().languageMap
                val langInfo = mSettingsLanguageDataMap.get(lang)
                val selectedLocale = langInfo!!.languageAndroidLocaleValue
                for (enum in ESettingsLanguageType.values()) {
                    if (enum.ordinal == lang) {
                        dataPoolDataHandler.languageMapSdk[selectedLocale.toString()] = enum.toString()
                        languageList.add(enum)
                        dataPoolDataHandler.languages[enum.toString()] = lang
                        break
                    }
                }
            }
            //set languages count and list to system listener
            systemListener.onSETTINGS_RES_SUPPORTEDLANGUAGES(SettingsSupportedLanguages_t(languageList.size, languageList))
        }
    }

    // request for display menu
    override fun onSETTINGS_REQ_DISPLAY() {
        //  var isProximity: Boolean = false
        //this function check proximity exist or not

        systemListener.onSETTINGS_RES_DISPLAY(CalibrationSettings.getInstance(
                SettingsService.appContext).doesProximityExits() && CalibrationSettings.getInstance
        (SettingsService.appContext).doesNavigationExits())

        //request for get display mode type
        SETTINGS_REQ_GETDISPLAYMODETYPE()
    }

    //request for set display mode
    override fun onSETTINGS_REQ_SETDISPLAYMODETYPE(any: Any) {
        systemListener.onSETTINGS_RES_DISPLAYMODETYPE(any as eSettingsdisplayMode)
    }

    //request for get display mode
    override fun SETTINGS_REQ_GETDISPLAYMODETYPE() {
        systemListener.onSETTINGS_RES_DISPLAYMODETYPE(dataPoolDataHandler.SETTINGS_DISPLAYMODETYPE.get()!!)
    }

    //request for display status
    override fun onSETTINGS_REQ_SETDISPLAYSTATUS(any: Any) {
        val booleanValue = java.lang.Boolean.valueOf(any.toString())
        PowerModeManager.getInstance().requestDisplayMode(booleanValue)
        systemListener.onSETTINGS_RES_DISPLAYSTATUS(any.toString())
    }

    //request for display calibration touchscreen
    override fun onSETTINGS_REQ_CALIBRATION() {
        systemListener.onSETTINGS_RES_CALIBRATION()
    }

    //request for calibration success
    override fun onSETTINGS_REQ_CALIBRATION_SUCCESS() {
        val panel: Panel
        panel = Panel.getPanel()
        if (panel != null) {
            panel.stop5PointCalibration()

        }
    }

    /**
     * request for set language
     */
    override fun onSETTINGS_REQ_SETLANGUAGE(any: Any) {
        val mSettingsLanguageDataMap = SupportedLanguageListData.getInstance().languageMap
        val langInfo = mSettingsLanguageDataMap.get(dataPoolDataHandler.languages.get(any.toString()))
        val selectedLocale = langInfo!!.languageAndroidLocaleValue
        systemListener.localeToString(selectedLocale)
        LocalePicker.updateLocale(selectedLocale)
        systemListener.onSETTINGS_RES_LANGUAGE(any as ESettingsLanguageType, selectedLocale)
    }


    override fun onFAVORITE_REQ_GETAUDIOFAVORITECOUNT() {
        val systemSize = Settings.System.getInt(SettingsService.appContext.contentResolver, Constants.SYSTEM_FAV_SET_NUM_OF_AUD_FAVORITE)
        systemListener.onFAVORITE_RES_AUDIOMAXFAVCOUNT(systemSize)
        systemListener.onFAVORITE_RES_AUDIOMAXFAVCOUNT(dataPoolDataHandler.SETTINGS_CURRENT_NUMBER_FAVORITES.get()!!)
    }

    override fun onFAVORITE_REQ_SETAUDIOFAVORITECOUNT(any: Any) {
        //To update audio favorite count to hardware
        systemListener.onFAVORITE_RES_AUDIOMAXFAVCOUNT(any)
        Settings.System.putInt(SettingsService.appContext.contentResolver, Constants.SYSTEM_FAV_SET_NUM_OF_AUD_FAVORITE, any as Int)

    }

    override fun onSETTINGS_REQ_CONTAINER_LIST() {
        systemListener.onSETTINGS_RES_CONTAINER_MENU_LIST()
    }


    override fun onSETTINGS_REQ_GET_STORAGE_USAGE(any: Any) {
        val actvityManager = any as ActivityManager
        var freeStorage: Long = 0
        var totalStorage: Long = 0
        var usedStorage: Long = 0
        //var progress = 0
        val memInfo = ActivityManager.MemoryInfo()
        actvityManager.getMemoryInfo(memInfo)
        freeStorage = memInfo.availMem
        totalStorage = memInfo.totalMem
        if (totalStorage > 0) {
            usedStorage = totalStorage - freeStorage
            systemListener.onSETTINGS_RES_GET_STORAGE_USAGE(Formatter.formatShortFileSize(SettingsService.appContext, usedStorage),
                    Formatter.formatShortFileSize(SettingsService.appContext, freeStorage),
                    (usedStorage * 100 / totalStorage).toInt())
        }
    }

    internal val mRunningAppList = java.util.ArrayList<AppInfo>()
    var mState: ApplicationsState? = null
    private var mDpm: DevicePolicyManager? = null
    internal val PidList = ArrayList<Int>()

    override fun onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST() {
        mState = ApplicationsState.getInstance(SettingsService.appContext)
        mState!!.newSession(this).resume()
        mDpm = SettingsService.appContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        mHandler = LocalHandler(Looper.getMainLooper())
        val actvityManager = SettingsService.appContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        //val processes = actvityManager.getRunningServices(300)
        val componentList = utility.getInstalledComponentList()
        onSETTINGS_REQ_GET_STORAGE_USAGE(actvityManager)
        val oldRunningAppList = ArrayList<AppInfo>(mRunningAppList)
        mRunningAppList.clear()
        val pm = SettingsService.appContext.packageManager
        val addedPackages = ArrayList<String>(componentList.size)
        for (componentName in componentList) {//get the all running apps informations
            try {

                Log.e("MyLogltprocess:,process value:", componentName)
                val packageInfo = pm.getPackageInfo(componentName,
                        PackageManager.GET_META_DATA)
                if (componentList != null && componentList.contains(packageInfo.packageName)) {
                    val calibrationSettings = CalibrationSettings.getInstance(SettingsService.appContext)
                    if (addedPackages.contains(packageInfo.packageName) ||
                            packageInfo.packageName == "com.gm.onstar" && !calibrationSettings.isOnStarServicesVisible ||
                            packageInfo.packageName == "com.gm.appshop" && !calibrationSettings.isAppShopEnabled) {
                        continue
                    }
                    val mAppInfo = AppInfo(packageInfo.packageName,
                            "", "", 0)
                    mAppInfo.appName = utility.getAppLabel(SettingsService.appContext, pm, packageInfo)!!

                    if (!addedPackages.contains(packageInfo.packageName)) {
                        mRunningAppList.add(mAppInfo)
                        addedPackages.add(packageInfo.packageName)
                    }
                    val getPackageSizeInfo = pm.javaClass.getMethod(
                            "getPackageSizeInfo", String::class.java,
                            IPackageStatsObserver::class.java)
                    getPackageSizeInfo.invoke(pm, mAppInfo.appPackageName, observer)
                    for (ai in oldRunningAppList) {
                        if (ai.appPackageName == mAppInfo.appPackageName) {
                            if (mAppInfo.appSize != null) {
                                mAppInfo.appSize = ai.appSize
                                break
                            }
                        }
                    }
                }

            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

        }
        systemListener.onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(mRunningAppList)
        sendMessageToHandler(MSG_HANDLE_RUNNING_APPS_LIST_CHANGE, true, 0, 0, null, 200)
    }


    private val MSG_HANDLE_RUNNING_APPS_LIST_CHANGE = 1

    private inner class LocalHandler(looper: Looper) : Handler(looper) {

        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_HANDLE_RUNNING_APPS_LIST_CHANGE -> systemListener.onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(mRunningAppList)
            }
        }
    }

    private var mHandler: LocalHandler? = null
    private fun sendMessageToHandler(messageId: Int, replaceMessage: Boolean, arg1: Int, arg2: Int, obj: Any?, delayMs: Int) {
        if (replaceMessage) {
            mHandler!!.removeMessages(messageId)
        }

        mHandler!!.sendMessageDelayed(mHandler!!.obtainMessage(messageId, arg1, arg2, obj), delayMs.toLong())
    }


    internal var observer: IPackageStatsObserver.Stub = object : IPackageStatsObserver.Stub() {

        @Throws(RemoteException::class)
        override fun onGetStatsCompleted(stats: PackageStats?, succeeded: Boolean) {
            if (stats != null) {
                val size = stats.cacheSize + stats.codeSize + stats.dataSize

                for (ai in mRunningAppList) {
                    if (ai.appPackageName == stats.packageName) {

                        var Size_Info = utility.getSizeStr(size)
                        Size_Info = Size_Info.replace("Мб", "MB")
                        Size_Info = Size_Info.replace("Кб", "KB")
                        Size_Info = Size_Info.replace(",", ".")
                        ai.appSize = Size_Info
                        sendMessageToHandler(MSG_HANDLE_RUNNING_APPS_LIST_CHANGE, true, 0, 0, null, 200)
                        break
                    }
                }
            }
        }
    }

    override fun onSETTINGS_REQ_GET_CONFIRM_FORCESTOP() {
        val appInfo = dataPoolDataHandler.SETTINGS_RUNNINGAPPS_INFORMATION.get(dataPoolDataHandler.SETTINGS_RUNNING_FORCESTOP_POSITION.get() as Int)
        forceStopPackage(appInfo.appPackageName, appInfo.pid)
    }

    private fun forceStopPackage(pkgName: String, pid: Int) {
        checkForceStop(pkgName, pid)
        PidList.clear()
        PidList.add(pid)
        onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST()
    }

    private fun checkForceStop(pkgName: String, pid: Int) {
        val am = SettingsService.appContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        try {
            val forceStopPackage = am!!.javaClass.getDeclaredMethod("forceStopPackage", String::class.java)
            forceStopPackage.isAccessible = true
            forceStopPackage.invoke(am, pkgName)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        systemListener.onSETTINGS_RES_GET_CONFIRM_FORCESTOP()
    }


    override fun onSETTINGS_REQ_GET_RUNNINGAPPSTOP_POS(any: Any) {
        systemListener.onSETTINGS_RES_GET_RUNNINGAPPSTOP_POS(any as Int)
    }


    override fun onSETTINGS_REQ_BUILDCLICK() {
        val um = SettingsService.appContext.getSystemService(Context.USER_SERVICE) as UserManager
        if (um.hasUserRestriction(UserManager.DISALLOW_DEBUGGING_FEATURES)) {
            return
        }


        systemListener.onSETTINGS_RES_BUILDCLICK()

    }

    override fun onSETTINGS_REQ_BUILDNUMBER() {

        systemListener.onSETTINGS_RES_BUILDNUMBER()


    }

    private val DEFAULT_LICENSE_PATH = "/system/etc/NOTICE.html.gz"
    private val PROPERTY_LICENSE_PATH = "ro.config.license_path"

    override fun onSETTINGS_REQ_OPENSOURCE() {
        val path = SystemProperties.get(PROPERTY_LICENSE_PATH, DEFAULT_LICENSE_PATH)
        systemListener.onSETTINGS_RES_OPENSOURCE(path)

    }

    override fun onSETTINGS_REQ_SPORTMODESTEERINGSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2

        mCustomization.setSteeringCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODEDISPLAYSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setDisplayPerformanceModeCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODESUSPENSIONSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setSuspensionCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODETRACTIONSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setDrivelineCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODEDRIVERSEATSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setDriverSeatPerformanceModeCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODEPASSENGERSEATSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setPassengerSeatPerformanceModeCustomizationSettingRequest(requestValue)

    }

    override fun onSETTINGS_REQ_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any) {
        var check: Boolean
        if (any is SportModeModel) {
            any.isToggleState = !any.isToggleState
            check = any.isToggleState
        } else {
            check = any as Boolean
        }
        var requestValue = 1
        if (check)
            requestValue = 2
        mCustomization.setAdaptiveCruiseControlPerformanceModeCustomizationSettingRequest(requestValue)
    }


}


