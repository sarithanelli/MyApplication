package com.gm.settingsapp.ui.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsAppsFragmentBinding
import com.gm.settingsapp.ui.adapters.BinderDataBindingComponent
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.ANDROID_AUTO_TAG
import com.gm.settingsapp.viewmodels.Constants.APPLE_CARPLAY_TAG
import com.gm.settingsapp.viewmodels.Constants.AUDIO_TAG
import com.gm.settingsapp.viewmodels.Constants.APPS_ON_OF
import com.gm.settingsapp.viewmodels.Constants.CLIMATE_TAG
import com.gm.settingsapp.viewmodels.Constants.PRIVACY_TAG
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.models.AppsModeModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Fragment to display APPs list screen
 */
class SettingsAppsFragment : BaseFragment() {

    lateinit var dataBindingComponent: DataBindingComponent


    override fun getContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var eventProcessor: EventProcessor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        AndroidSupportInjection.inject(this)
        dataBindingComponent = BinderDataBindingComponent(eventHandler, eventProcessor, utility, serviceUtility, dataPoolDataHandler)
        val settingsBinding = DataBindingUtil.inflate<SettingsAppsFragmentBinding>(inflater, R.layout.ics_settings_apps_fragment, container, false, dataBindingComponent)

        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        return settingsBinding.root
    }


}