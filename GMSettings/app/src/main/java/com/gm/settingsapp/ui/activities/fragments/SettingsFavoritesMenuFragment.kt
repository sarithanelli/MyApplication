package com.gm.settingsapp.ui.activities.fragments

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsFavoritesMenuFragmentBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.support.AndroidSupportInjection

/**
 * To display the list of favorites settings
 */
class SettingsFavoritesMenuFragment: BaseFragment() {
    override fun getContainerId(): Int {
        return R.id.settings_container_framelayout
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val settingsBinding = DataBindingUtil.inflate<SettingsFavoritesMenuFragmentBinding>(inflater, R.layout.ics_settings_system_favorites, container, false)

        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        GMSettingsApp.appContext.recyclerViewAdapter = null
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_favorites_big))


        return settingsBinding.root
    }

    fun onEventProcess(view: View, obj: Any?) {

    }
}