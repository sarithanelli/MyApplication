package com.gm.settingsapp

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import com.gm.settingsapp.di.AppComponentWrapper
import com.gm.settingsapp.ui.activities.BaseActivity
import com.gm.settingsapp.ui.activities.SettingsHomeActivity
import com.gm.settingsapp.ui.adapters.RecyclerViewAdapter
import com.gm.settingsapp.ui.adapters.SettingsPagerViewAdapter
import com.gm.settingsapp.ui.navigator.ActivityNavigator
import com.gm.settingsapp.utils.SubUtility
import com.gm.settingsapp.viewmodels.GMResponseListner
import com.gm.settingsapp.viewmodels.TimeZoneParse
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.utils.Constants.shared_prefs_key

import com.gm.settingsapp.viewmodels.ResponseListner
import com.gm.settingsservice.apiintegration.SystemListener
import com.gm.settingsservice.models.SideBarModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject


/**
 * Custom application class to maintain application global state
 */
class GMSettingsApp : Application(), Application.ActivityLifecycleCallbacks, HasActivityInjector, HasServiceInjector {


    @Inject
    lateinit var dataPoolDataHandler: DataPoolDataHandler
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingServiceAndroidInjector: DispatchingAndroidInjector<Service>
    @Inject
    lateinit var responseListner: ResponseListner

    @Inject
    lateinit var gmresponseListner: GMResponseListner
    @Inject
    lateinit var systemListener: SystemListener


    /** Reference to the current visible child activity */
    lateinit var activityContext: BaseActivity
    lateinit var themeChange: SettingsHomeActivity
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    var settingsPagerAdapter: SettingsPagerViewAdapter? = null

    var screenWidth: Int = 0
    var screenHeight: Int = 0
    var childLayoutID: Int? = null

    companion object {
        /** Context object for accessing resources and components across application */
        lateinit var appContext: GMSettingsApp
        /** Navigation helper */
        var navigator: ActivityNavigator = ActivityNavigator()
        /** A singleton reference to store data in shared preferences */
        lateinit var sharedPreferences: SharedPreferences
         var mGMTTimeZoneParse : TimeZoneParse = TimeZoneParse
        var IS_RTL = true
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this //Get this class reference as application context
        AppComponentWrapper.getAppComponent(this)?.inject(this)
        setLayoutDirection()
        registerActivityLifecycleCallbacks(this)
        dataPoolDataHandler.themeType.set(false)
       // sharedPreferences = getSharedPreferences(shared_prefs_key, Context.MODE_PRIVATE)
sharedPreferences = getSharedPreferences(shared_prefs_key, Context.MODE_PRIVATE)
        mGMTTimeZoneParse.parseTimeZoneList(appContext)
     //   EventHandler.initEvent(event_init_service)

        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.vehicle_selector,false))
        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.info_selector,false))
        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.settings_selector,false))
        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.phone_selector,false))
        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.audio_selector,false))
        dataPoolDataHandler.SETTINGS_SIDEBAR_DATA.add(SideBarModel(R.drawable.home_selector,false))



    }

    /**
     * To set Default layout configuration
     */
    private fun setLayoutDirection() {
        val resources = resources
        val config = resources.configuration
        val direction = config.layoutDirection
        IS_RTL = direction == View.LAYOUT_DIRECTION_LTR
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(SubUtility.setLocale(base))

        //  MultiDex.install(this)
    }


    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
        activityContext = activity!! as BaseActivity
        if (screenWidth == 0) {
            getDeviceResolution()
        }
    }

    private fun getDeviceResolution() {
        val displayMetrics = DisplayMetrics()
        activityContext.windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels
        Log.e("test", "width/height$screenWidth/$screenHeight")
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        SubUtility.setLocale(this)
    }


    override fun activityInjector() = dispatchingAndroidInjector

    override fun serviceInjector()= dispatchingServiceAndroidInjector

}