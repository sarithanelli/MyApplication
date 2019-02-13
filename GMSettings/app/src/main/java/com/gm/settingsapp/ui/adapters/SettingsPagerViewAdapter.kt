package com.gm.settingsapp.ui.adapters


import com.gm.settingsapp.ui.activities.fragments.SettingsAppsFragment
import com.gm.settingsapp.ui.activities.fragments.SettingsSystemFragment
import com.gm.settingsapp.ui.activities.fragments.SettingsVehicleFragment
import com.gm.settingsapp.utils.Utility
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.models.SETTINGS_CURRENT_HOME_PAGE
import com.gm.settingsservice.models.eSettingsPersonalizationbyDriver

/**
 * Setting SettingsPagerViewAdapter to Tablayout to display App,System,Vehicle, Personnal tabs
 */
class SettingsPagerViewAdapter(fm: androidx.fragment.app.FragmentManager?, dataPoolDataHandler: DataPoolDataHandler, utility: Utility) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
    var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler
    var utility: Utility = utility

    override fun getItem(position: Int): androidx.fragment.app.Fragment? {

        var fragment: androidx.fragment.app.Fragment? = null
        when (position) {
            SETTINGS_CURRENT_HOME_PAGE.SETTING_SYSTEM_VIEW.value -> {
                fragment = SettingsSystemFragment()
            }
            SETTINGS_CURRENT_HOME_PAGE.SETTING_APPS_VIEW.value -> {
                fragment = SettingsAppsFragment()
            }
            SETTINGS_CURRENT_HOME_PAGE.SETTING_VEHICLE_VIEW.value -> {
                fragment = SettingsVehicleFragment()
            }
        }
        return fragment
    }

    override fun getCount(): Int {

        if (dataPoolDataHandler.SETTINGS_PERSONALIZATIONBYDRIVERSETTING.get() == eSettingsPersonalizationbyDriver.SETTINGS_CC_PERSONALIZATIONBYDRIVER_ON)
            return dataPoolDataHandler.homeScreenData.get()!!.itemsSize - 1
        else

            return dataPoolDataHandler.homeScreenData.get()!!.itemsSize - 1
    }

    /*override fun getPageTitle(position: Int): CharSequence? {
        Utility.setTabLayoutTitles()
        return DataPoolDataHandler.SETTINGS_MAINVIEWPAGER_TITLES.get(position)

    }*/

}