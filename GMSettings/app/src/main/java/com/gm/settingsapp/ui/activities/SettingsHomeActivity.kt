package com.gm.settingsapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsHomeActivityBinding
import com.gm.settingsapp.ui.activities.fragments.SettingsAppsFragment
import com.gm.settingsapp.ui.activities.fragments.SettingsSystemFragment
import com.gm.settingsapp.ui.activities.fragments.SettingsVehicleFragment
import com.gm.settingsapp.ui.adapters.SettingsPagerViewAdapter
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.CLIMATE_TAG
import com.gm.settingsapp.viewmodels.Constants.DRIVEMODE_TAG
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.BroadcastController
import com.gm.settingsservice.utils.IConnectionStateChanged
import com.gm.settingsservice.utils.ISystemStateChanged
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.ics_settings_system_main.view.*
import javax.inject.Inject

/**
 * Activity is to Launch home screen with tabs
 */
class SettingsHomeActivity : BaseActivity(), ISystemStateChanged, IConnectionStateChanged , HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private var VEHICLE_POWER_ON: Int = 8
    private var binding: SettingsHomeActivityBinding? = null
    override fun onEventResponse(view: View, obj: Any?) {

        when (dataPoolDataHandler.homeScreenData.get()!!.currentHomePage) {
            SETTINGS_CURRENT_HOME_PAGE.SETTING_SYSTEM_VIEW -> SettingsSystemFragment().onEventProcess(view, obj)
            SETTINGS_CURRENT_HOME_PAGE.SETTING_APPS_VIEW -> {
               // SettingsAppsFragment().onEventProcess(view, obj)
                if (obj == null) {
                    return
                }
                if (view is ToggleButton) {
                    when ((obj as AppsModeModel).reference) {
                        Constants.ANDROID_AUTO -> view.tag = Constants.ANDROID_AUTO_TAG
                        Constants.MIRROR_LINK -> view.tag = Constants.ANDROID_AUTO_TAG
                        Constants.APPLE_CARPLAY -> view.tag = Constants.APPLE_CARPLAY_TAG
                    }

                } else if (obj is AppsModeModel) {
                    when (obj.reference) {
                        Constants.ANDROID_AUTO -> view.tag = Constants.APPS_ON_OF
                        Constants.APPLE_CARPLAY -> view.tag = Constants.APPS_ON_OF
                        Constants.MIRROR_LINK -> view.tag = Constants.APPS_ON_OF
                        Constants.VIDEO -> view.tag = Constants.APPS_ON_OF
                        Constants.AUDIO -> view.tag = Constants.AUDIO_TAG
                        Constants.CLIMATE -> view.tag = CLIMATE_TAG
                        Constants.CLIMATE -> {
                            if (!dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.get()!!)
                                view.tag = CLIMATE_TAG
                        }
                        Constants.ENERGY -> view.tag = Constants.PRIVACY_TAG
                        Constants.NAVIGATION -> view.tag = Constants.PRIVACY_TAG
                        Constants.PHONE -> view.tag = Constants.PRIVACY_TAG
                        Constants.TRAILERING -> view.tag = Constants.PRIVACY_TAG
                        Constants.CAMERA -> view.tag = Constants.PRIVACY_TAG
                    }
                }
            }
            SETTINGS_CURRENT_HOME_PAGE.SETTING_VEHICLE_VIEW -> {
                //SettingsVehicleFragment().onEventProcess(view, obj)
                if (obj != null && obj is String) {
                    when (obj) {
                        GMSettingsApp.appContext.resources.getString(R.string.settings_sport_mode_customization) -> view.tag = Constants.SPORTMODE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_auto_mode_customization) -> view.tag = Constants.AUTOMODE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_driving_mode_big) -> view.tag = DRIVEMODE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_mymode) -> view.tag = Constants.MYMODE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_vmode) -> view.tag = Constants.VMODE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_comfort_and_convenience) -> view.tag= Constants.COMFORT_AND_CONVENIENCE_TAG
                        GMSettingsApp.appContext.resources.getString(R.string.settings_climate_app) -> {
                            if (!dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.get()!!)
                                view.tag = CLIMATE_TAG
                        }
                    }
                }
            }
        }
        when (view.tag) {
            Constants.SYSTEM_FIRST_LEVEL_CONTAINER_TAG ->
                dataPoolDataHandler.SETTINGS_FIRST_LEVEL_CURRENT_SCREEN.set(Constants.FIRST_LEVEL_SYSTEM_TAB_FAVORITES)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        utility.setTabLayoutTitles(dataPoolDataHandler)
        binding = setContentSubView(R.layout.ics_settings_system_main) as SettingsHomeActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_PERSONALIZATIONBYDRIVERSETTING.set(eSettingsPersonalizationbyDriver.SETTINGS_CC_PERSONALIZATIONBYDRIVER_ON)
        dataPoolDataHandler.viewPagerObj.set(binding!!.root.homeviewPager)
        dataPoolDataHandler.homeScreenData.set(settingsHomeViewer())
        BroadcastController.getInstance(applicationContext)!!.registerBroadcastReceiver()
    }

    override fun onResume() {
        super.onResume()
        if (Constants.SUBMIT_BUTTON!!) {
            Constants.SUBMIT_BUTTON = false
            recreate()
        }

        if (SettingsService.isSDKAvailable() && serviceUtility.getSystemState()) {
            dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.set(true)
        } else {
            dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.set(false)
        }

        if (dataPoolDataHandler.homeScreenData.get()!!.currentHomePage.toString() == "SETTING_SYSTEM_VIEW") {
            binding!!.root.homeviewPager.adapter = SettingsPagerViewAdapter((binding!!.root.homeviewPager.context as androidx.fragment.app.FragmentActivity).supportFragmentManager,dataPoolDataHandler,utility)
        }
        eventProcessor.processEvent("onSETTINGS_APPS_REQ_DATA", null)
        BroadcastController.getInstance(GMSettingsApp.appContext)!!.addSystemStateChangedListener(this)
        hideBottomBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        BroadcastController.getInstance(applicationContext)!!.removeSystemStateChangedListener(this)
    }

    override fun OnSystemStateChanged(mSystemState: Int) {
        if (mSystemState == VEHICLE_POWER_ON) {
            dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.set(true)
        } else {
            dataPoolDataHandler.SETTINGS_VEHICLE_POWER_ON_OFF.set(false)
        }
    }

    override fun OnConnectionStateChanged(connectionState: String, intent: Intent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * This method used to hide bottom bar by showing it with animation for cadillac screens
     */
    private fun hideBottomBar() {
        dataPoolDataHandler.LAYOUT_ANIM.set(Constants.BOTTOM_BAR_SHOW)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

}