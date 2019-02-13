package com.gm.settingsapp.ui.activities.fragments

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsAudioFavoritesFragmentBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.support.AndroidSupportInjection


/**
 * To display and set the Audio favorites number limit
 */
class SettingsNumberFavoritesFragment: BaseFragment() {
    override fun getContainerId(): Int {
        return R.id.settings_container_framelayout
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val settingsBinding = DataBindingUtil.inflate<SettingsAudioFavoritesFragmentBinding>(inflater, R.layout.ics_settings_set_audio_favorites, container, false)

        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_set_number_of_audio_favorites))
        GMSettingsApp.appContext.recyclerViewAdapter = null

        dataPoolDataHandler.SETTINGS_SET_NUMBER_FAVORITES.clear()
        GMSettingsApp.appContext.resources.getIntArray(R.array.favorite_set_audio_number_favorites).forEach {
            dataPoolDataHandler.SETTINGS_SET_NUMBER_FAVORITES.add(it)
        }

        return settingsBinding.root
    }

    fun onEventProcess(view: View, obj: Any?) {


    }
}