package com.gm.settingsapp.ui.activities


import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.viewmodels.Constants
import dagger.android.AndroidInjection
import com.gm.settingsapp.databinding.AboutSettingsLauncherBinding


/*
 * This activity launch AboutSettingActivity Screen
 */
class AboutSettingsLauncherActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_ta_about_settings_launcher) as AboutSettingsLauncherBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler

        }
        initAboutList()
    }

       /*
        * This method is used for intialized the recycler view
        * */
    fun initAboutList() {
        dataPoolDataHandler.SETTINGS_SYSTEMS_ABOUT_DATA.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.about_data).forEach {
            dataPoolDataHandler.SETTINGS_SYSTEMS_ABOUT_DATA.add(it)
        }


    }


    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.updater_about))
        hideBottomBar()
    }

    private fun hideBottomBar() {
        dataPoolDataHandler.LAYOUT_ANIM.set(Constants.BOTTOM_BAR_HIDE)
    }

}