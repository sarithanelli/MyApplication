package com.gm.settingsservice.apiintegration.mock

import android.app.ActivityManager
import android.app.AlarmManager
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import android.content.pm.*
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.os.RemoteException
import android.text.format.Formatter
import android.widget.ProgressBar
import com.gm.settingsservice.apiintegration.SettingsService

import com.gm.settingsservice.apiintegration.apiinterfaces.IManager
import com.gm.settingsservice.models.*

import com.gm.settingsservice.utils.*
import com.gm.settingsservice.utils.Constants
import com.gm.settingsservice.utils.Constants.ENABLE_SETTING
import com.gm.settingsservice.utils.Log
import java.util.*
import kotlin.collections.ArrayList
import android.security.KeyStore.getApplicationContext
import com.gm.settingsservice.apiintegration.SystemListener
import java.io.File
import javax.inject.Inject


/**
 * To Perform functionalities when any event occurred and process the data and passing to [systemListener]
 */
class SimulationManager @Inject constructor(dataPoolDataHandler: DataPoolDataHandler, systemListener: SystemListener, utility: Utility, context: Context) : IManager, ApplicationsState.Callbacks {

    var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler

    var systemListener: SystemListener = systemListener

    var utility: Utility = utility

    var applicationContext: Context = context

    override fun onSETTINGS_MANAGE_SET_FAV() {
        systemListener.onSETTINGS_MANAGE_RES_FAV()
    }


    override fun onSETTINGS_REQ_SPORTMODESETTINGS(any: Any) {
        systemListener.onSETTINGS_RES_SPORTMODESETTINGS(any)
    }

    //request for display calibration touchscreen
    override fun onSETTINGS_REQ_CALIBRATION() {
        systemListener.onSETTINGS_RES_CALIBRATION()
    }

    override fun onSETTINGS_REQ_SPORTMODECHANGESETTINGS(any: Any) {
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
        systemListener.onSETTINGS_RES_SPORTMODESTEERINGSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODEDISPLAYSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODESUSPENSIONSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODETRACTIONSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODEDRIVERSEATSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODEPASSENGERSEATSETTINGS(requestValue)
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
        systemListener.onSETTINGS_RES_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(requestValue)
    }


    override fun onSETTINGS_APPS_REQ_DATA() {
        if (dataPoolDataHandler.SETTINGS_REQ_APPS_LIST[0].isToggleState) {
            systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(1)
        } else {
            systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(0)
        }

        if (dataPoolDataHandler.SETTINGS_REQ_APPS_LIST[1].isToggleState) {
            systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(1)
        } else {
            systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(0)
        }

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
                Constants.DISABLE_SETTING
            } else {
                ENABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                ENABLE_SETTING
            } else {
                Constants.DISABLE_SETTING
            }
        }
        systemListener.onDEVICEPROJECTION_RES_APPLECARPLAYENABLE(value)
    }

    override fun onDEVICEPROJECTION_REQ_SETGOOGLEAUTOLINKENABLE(any: Any) {
        val value: Int = if (any is AppsModeModel) {
            if (any.isToggleState) {
                Constants.DISABLE_SETTING
            } else {
                ENABLE_SETTING
            }
        } else {
            if (any as Boolean) {
                ENABLE_SETTING
            } else {
                Constants.DISABLE_SETTING
            }
        }
        systemListener.onDEVICEPROJECTION_RES_GOOGLEAUTOLINKENABLE(value)
    }

    override fun onSETTINGS_REQ_BUILDCLICK() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSETTINGS_REQ_BUILDNUMBER() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val DEFAULT_LICENSE_PATH = "/system/etc/NOTICE.html.gz"
    private val PROPERTY_LICENSE_PATH = "ro.config.license_path"


    override fun onSETTINGS_REQ_DISPLAY_CADILLAC() {
        systemListener.onSETTINGS_RES_DISPLAY_CADILLAC(dataPoolDataHandler.DISPLAY_CADILLAC_SELECT)
    }

    override fun onSETTINGS_REQ_CLIMATE_INNER(any: Any) {
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_TITLE.set((any as ClimateModeModel).primaryData)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_DES.set(any.description)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_STATE.set(any.isToggleState)
        dataPoolDataHandler.SETTINGS_SET_CLIMATE_INNER_REF.set(any.reference)
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTODEFOGSETTING(any: Any) {
        var check: Boolean = if (any is ClimateModeModel) {
            !any.isToggleState
        } else {
            any as Boolean
        }
        if (check) {
            systemListener.onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(SettingsClimateAutoDefog_t(1, eSettingsClimateAutoDefog.SETTINGS_CLIMATE_AUTO_DEFOG_OFF))
        } else {
            systemListener.onCUSTOMIZATIONECC_RES_AUTODEFOGSETTING(SettingsClimateAutoDefog_t(2, eSettingsClimateAutoDefog.SETTINGS_CLIMATE_AUTO_DEFOG_ON))
        }
    }

    override fun onCUSTOMIZATIONECC_REQ_SETIONIZERSETTINGS(any: Any) {
        var check: Boolean = if (any is ClimateModeModel) {
            !any.isToggleState
        } else {
            any as Boolean
        }
        if (check) {
            systemListener.onCUSTOMIZATIONECC_RES_IONIZERSETTING(SettingsClimateIonizer_t(1, eSettingsClimateIonizer.SETTINGS_CLIMATE_IONIZER_OFF))
        } else {
            systemListener.onCUSTOMIZATIONECC_RES_IONIZERSETTING(SettingsClimateIonizer_t(2, eSettingsClimateIonizer.SETTINGS_CLIMATE_IONIZER_ON))
        }
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOFANSETTING(any: Any) {
        systemListener.onCUSTOMIZATIONECC_RES_AUTOFANSETTING(SettingsClimateAutoFanSpeed_t(any as Int, eSettingsClimateAutoFanSpeed.SETTINGS_CLIMATE_AUTO_FAN_SPEED_HIGH))
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOAIRDISTRSETTINGS(any: Any) {
        systemListener.onCUSTOMIZATIONECC_RES_AUTOAIRDISTRSETTING(SettingsClimateAutoAirDistribution_t(any as Int, eSettingsClimateAutoAirDistribution.SETTINGS_CLIMATE_DIFFUSE_AIRFLOW))
    }

    override fun onCUSTOMIZATIONECC_REQ_SETPOLLUTIONCONTROLSETTINGS(any: Any) {
        var check: Boolean = if (any is ClimateModeModel) {
            !any.isToggleState
        } else {
            any as Boolean
        }

        if (check) {
            systemListener.onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(SettingsClimatePollutionControlSetting_t(1, eSettingsClimatePollutionControl.SETTINGS_CLIMATE_POLLUTION_CONTROL_OFF))
        } else {
            systemListener.onCUSTOMIZATIONECC_RES_POLLUTIONCONTROLSETTING(SettingsClimatePollutionControlSetting_t(2, eSettingsClimatePollutionControl.SETTINGS_CLIMATE_POLLUTION_CONTROL_ON))
        }
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOCOOLSEATSSETTING(any: Any) {
        var check = false
        check = if (any is ClimateModeModel) {
            !any.isToggleState
        } else {
            any as Boolean
        }
        if (check) {
            systemListener.onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(SettingsClimateAutoCoolSeatsSettingValue_t(1, eSettingsClimateAutoCooledSeats.SETTINGS_CLIMATE_AUTO_COOLEDSEATS_OFF))
        } else {
            systemListener.onCUSTOMIZATIONECC_RES_AUTOCOOLSEATSSETTING(SettingsClimateAutoCoolSeatsSettingValue_t(2, eSettingsClimateAutoCooledSeats.SETTINGS_CLIMATE_AUTO_COOLEDSEATS_ON))
        }
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAUTOHEATEDSEATSSETTING(any: Any) {
        var check = false
        check = if (any is ClimateModeModel) {
            !any.isToggleState
        } else {
            any as Boolean
        }
        if (check) {
            systemListener.onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(SettingsClimateAutoHeatedSeats_t(1, eSettingsClimateAutoHeatedSeats.SETTINGS_CLIMATE_AUTO_HEATEDSEATS_OFF))
        } else {
            systemListener.onCUSTOMIZATIONECC_RES_AUTOHEATEDSEATSSETTING(SettingsClimateAutoHeatedSeats_t(2, eSettingsClimateAutoHeatedSeats.SETTINGS_CLIMATE_AUTO_HEATEDSEATS_ON))
        }
    }

    override fun onCUSTOMIZATIONECC_REQ_SETREARZONESTARTUPSETTINGS(any: Any) {
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

    override fun onSETTINGS_REQ_GET_STORAGE_USAGE(any: Any) {

        val actvityManager = any as ActivityManager
        var freeStorage: Long = 0
        var totalStorage: Long = 0
        var usedStorage: Long = 0
        val memInfo = ActivityManager.MemoryInfo()
        actvityManager.getMemoryInfo(memInfo)
        freeStorage = memInfo.availMem
        totalStorage = memInfo.totalMem
        if (totalStorage > 0) {
            usedStorage = totalStorage - freeStorage
            dataPoolDataHandler.SETTINGS_RUNNING_USEDMEMORY_SIZE.set(Formatter.formatShortFileSize(SettingsService.appContext!!, usedStorage))

            dataPoolDataHandler.SETTINGS_RUNNING_AVAILABLE_SIZE.set(Formatter.formatShortFileSize(SettingsService.appContext!!, freeStorage))

            systemListener.onSETTINGS_RES_GET_STORAGE_USAGE(Formatter.formatShortFileSize(SettingsService.appContext!!, usedStorage),
                    Formatter.formatShortFileSize(SettingsService.appContext!!, freeStorage),
                    (usedStorage * 100 / totalStorage).toInt())
        }
    }

    private var mHandler: LocalHandler? = null
    private val TAG = "Runningapps"
    internal val mRunningAppList = java.util.ArrayList<AppInfo>()
    var mState: ApplicationsState? = null
    private var mDpm: DevicePolicyManager? = null
    internal val PidList = java.util.ArrayList<Int>()
    private val MSG_HANDLE_RUNNING_APPS_LIST_CHANGE = 1
    val processes = java.util.ArrayList<ActivityManager.RunningServiceInfo>()

    override fun onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST() {

        mState = ApplicationsState.getInstance(SettingsService.appContext)
        mState!!.newSession(this).resume()
        mDpm = SettingsService.appContext!!.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        mHandler = LocalHandler(Looper.getMainLooper())
        val actvityManager = SettingsService.appContext!!.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        //  val processes = actvityManager.runningAppProcesses
        val pm = SettingsService.appContext!!.getPackageManager()

        val processeslt1 = actvityManager.runningAppProcesses
        for (runningAppProcessInfo2 in processeslt1) {
            try {
                val packageInfo = pm.getPackageInfo(runningAppProcessInfo2.processName,
                        PackageManager.GET_META_DATA)
                Log.e(TAG, packageInfo.packageName + ":"
                        + packageInfo.applicationInfo.publicSourceDir)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
        }

        processes.addAll(actvityManager.getRunningServices(300))
        val componentList = getInstalledComponentList()
        onSETTINGS_REQ_GET_STORAGE_USAGE(actvityManager)
        val oldRunningAppList = ArrayList<AppInfo>(mRunningAppList)
        mRunningAppList.clear()
        if (PidList.size > 1)
            PidList.clear()


        val addedPackages = java.util.ArrayList<String>(processes.size)
        for (runningAppProcessInfo in processes) {
            try {
                val packageInfo = pm.getPackageInfo(runningAppProcessInfo.process,
                        PackageManager.GET_META_DATA)
                Log.e(TAG, packageInfo.packageName + ":"
                        + packageInfo.applicationInfo.publicSourceDir)

                if (componentList != null && componentList.contains(packageInfo.packageName)) {
                    //  val calibrationSettings = CalibrationSettings.getInstance(SettingsService.appContext)

                    /*  if (addedPackages.contains(packageInfo.packageName) ||
                              packageInfo.packageName == Utils.ONSTAR_SERVICES_PKG_NAME && !calibrationSettings.isOnStarServicesVisible() ||
                              packageInfo.packageName == Utils.APPSHOP_PKG_NAME && !calibrationSettings.isAppShopEnabled()) {
                          continue
                      }*/
                    val mAppInfo = AppInfo(packageInfo.packageName, "", "", 0)
                    val applinfo = pm.getApplicationInfo(packageInfo.packageName, PackageManager.GET_META_DATA)
                    mAppInfo.appName = pm.getApplicationLabel(applinfo) as String
                    mAppInfo.pid = runningAppProcessInfo.pid
                    for (ai in oldRunningAppList) {
                        if (ai.appPackageName == mAppInfo.appPackageName && ai.appSize.length > 0) {
                            mAppInfo.appSize = ai.appSize
                            break
                        }
                    }

                    val getPackageSizeInfo = pm.javaClass.getMethod(
                            "getPackageSizeInfo", String::class.java,
                            IPackageStatsObserver::class.java)
                    getPackageSizeInfo.invoke(pm, mAppInfo.appPackageName, observer)
                    if (!PidList.contains(mAppInfo.pid)) {
                        if (!addedPackages.contains(mAppInfo.appPackageName))
                            mRunningAppList.add(mAppInfo)
                        PidList.add(runningAppProcessInfo.pid)
                    }

                    addedPackages.add(packageInfo.packageName)
                }


            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

        }
        systemListener.onSETTINGS_RES_GET_RUNNING_APPLICATIONLIST(mRunningAppList)
        sendMessageToHandler(MSG_HANDLE_RUNNING_APPS_LIST_CHANGE, true, 0, 0, null, 0)

    }

    private fun getInstalledComponentList(): List<String> {
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val ril = SettingsService.appContext!!.getPackageManager().queryIntentActivities(mainIntent, 0)
        val componentList = java.util.ArrayList<String>()

        var i = 0
        for (ri in ril) {
            if (!isDevelopmentApp(ri)) {
                val name = ri.activityInfo.packageName
                componentList.add(name)
                // LogFile.ShowLog(TAG, name + " " + i)
                i++
            }
        }
        return componentList
    }

    private fun isDevelopmentApp(info: ResolveInfo): Boolean {
        val componentInfo = getComponentInfo(info)
        return mDevAppFilter.containsKey(getShortComponentName(componentInfo))
    }

    fun getComponentInfo(rInfo: ResolveInfo): ComponentInfo {
        if (rInfo.activityInfo != null)
            return rInfo.activityInfo
        if (rInfo.serviceInfo != null)
            return rInfo.serviceInfo
        if (rInfo.providerInfo != null)
            return rInfo.providerInfo
        throw IllegalStateException("Missing ComponentInfo!")
    }

    fun getShortComponentName(ci: ComponentInfo?): String? {
        var componentName: String? = null
        if (ci != null) {
            val sb = StringBuilder(ci.packageName.length + ci.name.length)
            ComponentName.appendShortString(sb, ci.packageName, ci.name)
            componentName = sb.toString()

            //      LogFile.ShowLog(TAG, "mComponentName$componentName")
        }
        return componentName
    }

    val VEHICLEP13N_APP_CMP_NAME = "com.gm.vehiclep13nbundletest/.VehicleP13NBundleTestMainActivity"
    val UPDATESERVICETEST_APP_CMP_NAME = "gm.update.test/.UpdateServiceTestMainActivity"
    val FRAMEWORK_TEST_APP_CMP_NAME = "com.harman.appframework.test/.MainActivity"
    val TBT_APP_CMP_NAME = "com.gm.tbt/.NoRouteActivity"
    val SEAT_APPLICATION_CMP_NAME = "com.gm.seatstatuspane/.MainActivity"

    val mDevAppFilter: HashMap<String, Boolean> = object : HashMap<String, Boolean>() {
        init {
            put("com.gm.texttospeech/.TextToSpeechActivity", true)
            put("com.gm.uisstestservice/.GMEventSimuApp", true)
            put("com.android.providers.downloads.ui/.DownloadList", true)
            put("gm.media.mediaPlayerTester/.UI.MainActivity", true)
            put("com.android.music/.MusicBrowserActivity", true)
            put("com.onstar.navmgr/.activities.MainActivity", true)
            put("com.harman.nav.navtest/.MainActivity", true)
            put("com.android.contacts/.activities.PeopleActivity", true)
            put("com.gm.rrsdk.test/.MainActivity", true)
            put("com.harman.softwareupdate/.UserConfirmActivity", true)
            put("com.android.soundrecorder/.SoundRecorder", true)
            put("com.gm.enggmodemenu/.EnggModeActivity", true)
            // This points to stack android app, but this app shall be removed
            // in future.
            put("com.android.settings/.Settings", true)
            put("com.gm.tbt/.NavigationActivity", true)
            put("com.gm.vr/.PTTActivity", true)
            put("com.onstar.gtbt.wackamole/.activities.Planning", true)
            put("com.example.proximityapplication/.MainActivity", true)
            put("com.example.maxstvol/.MainActivity", true)
            put("com.gm.vehiclemanagertest/.VehicleManagerTestMainActivity", true)
            put("com.gm.diagnosticsmanagertest/.MainActivity", true)
            put("com.gm.caltest/.CalTestMainActivity", true)
            put("com.gm.obdmanagertest/.OBDManagerTestMainActivity", true)
            put("com.android.browser/.BrowserActivity", true)
            put("com.gm.gmlogmanagertester/.MainActivityList", true)
            put("com.onstar.vttproxyserver/.MainActivity", true)
            put("com.gm.navmgr/.activities.MainActivity", true)
            put("com.android.mms/.ui.ConversationList", true)
            put("com.gm.media.mediatimer/.MediaTimer", true)
            put("com.gm.media.proxytester/.ProxyTesterMain", true)
            put(VEHICLEP13N_APP_CMP_NAME, true)
            put(UPDATESERVICETEST_APP_CMP_NAME, true)
            put(FRAMEWORK_TEST_APP_CMP_NAME, true)
            put(TBT_APP_CMP_NAME, true)
            put(SEAT_APPLICATION_CMP_NAME, true)
            put("gm.com.gmstopharmancamera/.GMStopHarmanCamera", true)
        }
    }


    internal var observer: IPackageStatsObserver.Stub = object : IPackageStatsObserver.Stub() {

        @Throws(RemoteException::class)
        override fun onGetStatsCompleted(stats: PackageStats?, succeeded: Boolean) {
            if (stats != null) {
                val size = stats.cacheSize + stats.codeSize + stats.dataSize
                //      LogFile.ShowLog(TAG, "App size received: " + stats.packageName + " size: " + size)
                for (ai in mRunningAppList) {
                    if (ai.appPackageName == stats.packageName) {
                        var Size_Info = utility.getSizeStr(size)


                        Log.e(TAG, "App Added to List:Size_Info " + Size_Info)
                        ai.appSize = Size_Info
                        //   LogFile.ShowLog(TAG, "App size set: " + stats.packageName + " size: " + size)
                        sendMessageToHandler(MSG_HANDLE_RUNNING_APPS_LIST_CHANGE, true, 0, 0, null, 0)
                        break
                    }
                }
            }
        }
    }


    private fun sendMessageToHandler(messageId: Int, replaceMessage: Boolean, arg1: Int, arg2: Int, obj: Any?, delayMs: Int) {
        if (replaceMessage) {
            mHandler!!.removeMessages(messageId)
        }

        mHandler!!.sendMessageDelayed(mHandler!!.obtainMessage(messageId, arg1, arg2, obj), delayMs.toLong())
    }

    private inner class LocalHandler(looper: Looper) : Handler(looper) {

        override fun handleMessage(msg: Message) {
            when (msg.what) {
                /*  MSG_HANDLE_RUNNING_APPS_LIST_CHANGE -> if (null != runningAppsSettingsAdapter) {
                      runningAppsSettingsAdapter.notifyDataSetChanged()
                  }*/
            }
        }
    }

    override fun onSETTINGS_REQ_GET_CONFIRM_FORCESTOP() {

        val appInfo = mRunningAppList.get(dataPoolDataHandler.SETTINGS_RUNNING_FORCESTOP_POSITION.get() as Int)


        forceStopPackage(appInfo.appPackageName, appInfo.pid)
    }

    private fun forceStopPackage(pkgName: String, pid: Int) {
        val am = SettingsService.appContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        try {
            val forceStopPackage = am!!.javaClass.getDeclaredMethod("forceStopPackage", String::class.java)
            forceStopPackage.isAccessible = true
            forceStopPackage.invoke(am, pkgName)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        systemListener.onSETTINGS_RES_GET_CONFIRM_FORCESTOP()
        PidList.clear()
        PidList.add(pid)
        onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST()
    }

    private var mUsedProgressBar: ProgressBar? = null


    override fun onSETTINGS_REQ_GET_RUNNINGAPPSTOP_POS(any: Any) {
        systemListener.onSETTINGS_RES_GET_RUNNINGAPPSTOP_POS(any as Int)
    }


    /*  override fun onSETTINGS_REQ_VEHICLELIST(vehicleList: Any) {
          val vehicleData = ArrayList<String>()
          vehicleData.add((vehicleList as Array<String>)[Constants.VEHICLE_DRIVER_MODE])
          //  vehicleData.add(resources.getString(R.string.settings_climate_app))
          systemListener.onSETTINGS_RES_VEHICLELIST(vehicleData)
      }*/

    /**
     *Request for driving mode list
     */
    override fun onSETTINGS_REQ_DRIVINGMODELIST(driverModeList: Any) {
        val vehicleData = ArrayList<DriveModeModel>()
        (driverModeList as Array<String>).forEach {
            when (it) {
                (driverModeList)[Constants.VEHICLE_ENGINE_SOUND] -> {
                    //vehicleData.add(0, DriveModeModel(driverModeList[Constants.VEHICLE_ENGINE_SOUND], ""))
                    // vehicleData.add(1, DriveModeModel(driverModeList[Constants.VEHICLE_STEERING], ""))
                    // vehicleData.add(2, DriveModeModel(driverModeList[Constants.VEHICLE_ENGINE_SUSPENSION], ""))
                    //   vehicleData.add(3, DriveModeModel(driverModeList[Constants.VEHICLE_AWD_OPTIMIZATION], ""))
                }
            }
        }
        systemListener.onSETTINGS_RES_DRIVINGMODELIST(vehicleData)

    }


    override fun onSETTINGS_RETURNTOFACTORY(any: Any) {

    }

    override fun onSETTINGS_REQ_SETAUDIOCUES(any: Any) {

        var changeVolume = dataPoolDataHandler.SETTINGS_AUDIOCUES.get()!! + any as Int
        /* var volume = vehicleAudioManager
                 .getStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE)
         var changeVolume = volume + any as Int
         //set set_audio_cue_volume
         vehicleAudioManager.setStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE, changeVolume)*/
        systemListener.onSETTINGS_RES_AUDIOCUES(changeVolume)
    }

    override fun onSETTINGS_REQ_ERASESETTINGSPERSONALDATA(any: Any) {

    }

    override fun onSETTINGS_REQ_RESETVEHICLESETTINGS(any: Any) {

    }

    override fun onSETTINGS_REQ_GETAUDIOCUES() {
        // for progress bar setMax value
        dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.set(100)
        // for default value for setProgress
        /*var volume = vehicleAudioManager
                .getStreamVolume(VehicleAudioManager.STREAM_NATIVE_AUDIO_CUE)*/
        systemListener.onSETTINGS_RES_AUDIOCUES(40)
    }

    override fun onSETTINGS_REQ_SETMAXSTARTUPVOLUME(any: Any) {
        var changeVolume = dataPoolDataHandler.SOUNDPARAMS_MAXTUNEVALUE.get()!! + any as Int
        systemListener.onSETTINGS_RES_GETMAXSTARTUPVOLUME(changeVolume)

    }

    override fun onSETTINGS_REQ_GETMAXSTARTUPVOLUME() {
        // for progress bar setMax value
        dataPoolDataHandler.SOUNDPARAMS_MAXIMUMSTARTUPVOLUME.set(100)
        // for default value for setProgress

        systemListener.onSETTINGS_RES_GETMAXSTARTUPVOLUME(30)
    }

    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK3() {
    }


    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK2() {
    }

    override fun onSETTINGS_REQ_SOUND_MENU() {
        systemListener.onSETTINGS_RES_SOUND_MENU()
    }

    /**
     *Request for vehicle tab
     */
    override fun initListeners() {
        systemListener.onSETTINGS_RES_GLOBALSUPPORTEDSETTINGS(GlobalSettingsAvailibilityFlag_t(drivingModeFlag = 1, autoModeCustomizationFlag = 1, sportsModeCustomizationFlag = 1))
        val mSettingsAvailibilityFlag_t = SettingsAvailibilityFlag_t()
        mSettingsAvailibilityFlag_t.SettingsChangePerfModeSoundCustomizationFlag = Constants.ENGINE_SOUND_AUTO
        mSettingsAvailibilityFlag_t.settingsSteeringCustomizationFlag = Constants.STEERING_AUTO
        mSettingsAvailibilityFlag_t.settingsSuspensionCustomizationFlag = Constants.SUSPENSION_MODE4
        mSettingsAvailibilityFlag_t.settingsTractionCustomizationFlag = Constants.TRACTION_AUTO

        systemListener.onSETTINGS_RES_SUPPORTEDSETTINGS(mSettingsAvailibilityFlag_t)
        val SettingsDriverModeStatus_t = SettingsDriverModeStatus_t()
        var SettingsDriverStatus = SettingsDriverStatus()


        val arrayListSoundModes = ArrayList<ESettingsChangePerfModeSound>()
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TOUR)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_SPORT)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_TRACK)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_STEALTH)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_CITY)
        arrayListSoundModes.add(ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_OFF)
        systemListener.onSETTINGS_RES_PERFMODESOUNDCUSTOMIZATIONSETTING(arrayListSoundModes)
        //SettingsDriverModeStatus_t.DriverSelectedMode1Status = DataPoolDataHandler.ENGINESOUND_MAP_STATE[Constants.ENGINE_SOUND_AUTO]!!
        SettingsDriverStatus.enginesound = Constants.ENGINE_SOUND_AUTO


        val arrayListSteeringModes = ArrayList<ESettingsSteeringCustomization>()
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_AUTO)
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TOUR)
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_SPORT)
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_TRACK)
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_ECO)
        arrayListSteeringModes.add(ESettingsSteeringCustomization.SETTINGS_DRIVERMODE_STEERING_CITY)
        systemListener.onSETTINGS_RES_SPORTMODESPORTSTEERINGSETTINGS(arrayListSteeringModes)
        SettingsDriverStatus.steering = Constants.STEERING_AUTO

        // SettingsDriverModeStatus_t.DriverSelectedMode2Status = DataPoolDataHandler.STEERING_MAP_STATE[Constants.STEERING_AUTO]!!

        val arrayListSuspensionModes = ArrayList<ESettingsSuspensionCustomization>()
        arrayListSuspensionModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TOUR)
        arrayListSuspensionModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_SPORT)
        arrayListSuspensionModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_TRACK)
        arrayListSuspensionModes.add(ESettingsSuspensionCustomization.SETTINGS_DRIVERMODE_SUSPENSION_AUTO)

        systemListener.onSETTINGS_RES_SPORTMODESPORTSUSPENSIONSETTINGS(arrayListSuspensionModes)
        SettingsDriverStatus.suspension = Constants.SUSPENSION_MODE4
        //SettingsDriverModeStatus_t.DriverSelectedMode3Status = DataPoolDataHandler.SUSPENSION_MAP_STATE[Constants.SUSPENSION_MODE4]!!

        val arrayListTractionModes = ArrayList<ESettingsTractionCustomization>()
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_AUTO)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TOUR)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SPORT)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACK)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_ECO)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_SNOW_ICE_WEATHER)
        arrayListTractionModes.add(ESettingsTractionCustomization.SETTINGS_DRIVERMODE_TRACTION_TRACKASSISTOFF)


        systemListener.onSETTINGS_RES_TRACTIONCONTROLSYSTEMSTATUS(arrayListTractionModes)
        SettingsDriverStatus.traction = Constants.TRACTION_AUTO
        // SettingsDriverModeStatus_t.DriverSelectedMode4Status = DataPoolDataHandler.TRACTION_MAP_STATE[Constants.TRACTION_AUTO]!!

        systemListener.onSETTINGS_RES_DRIVERSELECTEDMODESTATUS(SettingsDriverStatus)
        systemListener.onSETTINGS_RES_CLIMATE()
        systemListener.onSETTINGS_APPS_RES_DATA()
    }

    /**
     *Request for set engine sound type
     */
    override fun onSETTINGS_REQ_SETENGINESOUNDTYPE(any: Any) {
        systemListener.onSETTINGS_RES_SETMODESTATUS(SettingsDriverModeStatus_t(DriverSelectedMode1Status = dataPoolDataHandler.ENGINESOUND_MAP_STATE[dataPoolDataHandler.ENGINESOUND_MAP.get(any.toString())!!.toInt()]!!))
    }

    /**
     *Request for set steering type
     */
    override fun onSETTINGS_REQ_SETSTEERINGTYPE(any: Any) {
        systemListener.onSETTINGS_RES_SETMODESTATUS(SettingsDriverModeStatus_t(DriverSelectedMode2Status = dataPoolDataHandler.STEERING_MAP_STATE[dataPoolDataHandler.STEERING_MAP.get(any.toString())!!.toInt()]!!))
    }

    /**
     *Request for set suspension type
     */
    override fun onSETTINGS_REQ_SETSUSPENSIONTYPE(any: Any) {
        systemListener.onSETTINGS_RES_SETMODESTATUS(SettingsDriverModeStatus_t(DriverSelectedMode3Status = dataPoolDataHandler.SUSPENSION_MAP_STATE[dataPoolDataHandler.SUSPENSION_MAP.get(any.toString())!!.toInt()]!!))

    }

    /**
     *Request for set traction type
     */
    override fun onSETTINGS_REQ_SETTRACTIONTYPE(any: Any) {
        systemListener.onSETTINGS_RES_SETMODESTATUS(SettingsDriverModeStatus_t(DriverSelectedMode4Status = dataPoolDataHandler.TRACTION_MAP_STATE[dataPoolDataHandler.TRACTION_MAP.get(any.toString())!!.toInt()]!!))

    }


    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK() {

    }

    override fun onSETTINGS_REQ_SETAUDIBLETOUCHFEEDBACK(any: Any
    ) {

        var changeVolume = dataPoolDataHandler.SETTINGS_AUDIBLETOUCHFEEDBACK.get()!! + any as Int
        systemListener.onSETTINGS_RES_AUDIBLETOUCHFEEDBACK(changeVolume)

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
        //    dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.clear()
        /*  onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()
          onSETTINGS_REQ_GETTIMEINFO()
          onSETTINGS_REQ_GETDATEINFO()
          onSETTINGS_REQ_GETAUTOMATICTIMEZONE()
          onSETTINGS_REQ_GETTIMEZONE()*/
        //    onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()
        //dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.clear()
        onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()
        onSETTINGS_REQ_GETTIMEZONE()
        onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()
        onSETTINGS_REQ_GETDATEINFO()
        onSETTINGS_REQ_GETTIMEINFO()


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
        dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(any)
        (SettingsService.appContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager).setTime(utility.convertTimeInMillis(timeInfo))
    }

    override fun onSETTINGS_REQ_SETTIMEMINUTEINC(any: Any) {
        val timeInfo = utility.setCalenderTime(Calendar.MINUTE, any as Int)
        systemListener.onSETTINGS_RES_TIMEINFO(timeInfo)
        dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.set(any)
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


    override fun onSETTINGS_REQ_SETTIMEDISPLAYFORMAT(any: Any) {
        if (any is TimeDateModel) {
            if (any.isToggleState) {
                systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE)
            } else {
                systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE)

            }
        }
        systemListener.onSETTINGS_RES_TIMEINFO(utility.getCurrentTime())
    }

    override fun onSETTINGS_REQ_GETTIMEDISPLAYFORMAT() {
        val mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)
        Log.i("current date format", mydate)

        if (mydate.contains(Constants.AM) || mydate.contains(Constants.PM)) {
            systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE)
        } else {
            systemListener.onSETTINGS_RES_TIMEDISPLAYFORMAT(eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE)
        }
        //    systemListener.onSETTINGS_RES_TIMEINFO(utility.getCurrentTime())

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

    //request for display menu
    override fun onSETTINGS_REQ_DISPLAY() {
        //response for display menu.here i passed true for maintain proximity sensing.
        systemListener.onSETTINGS_RES_DISPLAY(true)
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
        systemListener.onSETTINGS_RES_DISPLAYSTATUS(any)

    }

    //request for calibration success
    override fun onSETTINGS_REQ_CALIBRATION_SUCCESS() {

    }


    /**
     * request for supported languages
     */
    override fun onSETTINGS_REQ_GETSUPPORTEDLANGUAGES() {
        var position = -1
        val languageList = ArrayList<ESettingsLanguageType>()
        for (enum in ESettingsLanguageType.values()) {
            position++
            languageList.add(enum)
            dataPoolDataHandler.languages.put(enum.toString(), position)
        }
        //set languages count and list to system listener
        systemListener.onSETTINGS_RES_SUPPORTEDLANGUAGES(SettingsSupportedLanguages_t(languageList.size, languageList))

    }

    /**
     * request for set language
     */
    override fun onSETTINGS_REQ_SETLANGUAGE(any: Any) {
        var selectedLocale: Locale = Locale("en", "GB");
        systemListener.onSETTINGS_RES_LANGUAGE(any, selectedLocale)
    }

    /**
     * request for get language
     */
    override fun onSETTINGS_REQ_GETLANGUAGE() {
        // systemListener.onSETTINGS_RES_LANGUAGE(dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.get()!!, selectedLocale)
    }

    override fun onFAVORITE_REQ_GETAUDIOFAVORITECOUNT() {
        systemListener.onFAVORITE_RES_AUDIOMAXFAVCOUNT(dataPoolDataHandler.SETTINGS_CURRENT_NUMBER_FAVORITES.get()!!)
    }

    override fun onFAVORITE_REQ_SETAUDIOFAVORITECOUNT(any: Any) {
        systemListener.onFAVORITE_RES_AUDIOMAXFAVCOUNT(any)

    }

    override fun onSETTINGS_REQ_CONTAINER_LIST() {
        systemListener.onSETTINGS_RES_CONTAINER_MENU_LIST()
    }

    override fun onSETTINGS_REQ_CLIMATE_MENU_LIST(any: Any) {
        systemListener.onSETTINGS_RES_CLIMATE_MENU_LIST()
    }

    override fun onCUSTOMIZATIONECC_REQ_SETAIRQUALITYSENSORSETTING(any: Any) {
        systemListener.onCUSTOMIZATIONECC_RES_AIRQUALITYSENSORSETTING(SettingsClimateAirQualitySensor_t(any as Int, eSettingsClimateAirQualitySensor.SETTINGS_CLIMATE_AIRQUALITYSENSOR_OFF))
    }

    /*
    * request for get path
    * */
    override fun onSETTINGS_REQ_OPENSOURCE() {
        //  val path =SettingsService.appContext.resources.assets
        //val path =File("//assets/NOTICE.html")


        //   systemListener.onSETTINGS_RES_OPENSOURCE(path.absolutePath)
        dataPoolDataHandler.HTML_INTENT_VIEW_PATH_DATA.set(false)

    }
}
