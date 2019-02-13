package com.gm.settingsapp.ui.activities.fragments

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.sharedPreferences
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsThemeBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor

import com.gm.settingsservice.models.SettingsConfigurationModel
import com.gm.settingsservice.utils.Constants
import com.gm.settingsservice.utils.Constants.SHARED_PREF_LHD_KEY
import com.gm.settingsservice.utils.Constants.SHARED_PREF_RHD_KEY
import com.gm.settingsservice.utils.Constants.SHARED_PREF_RTL_KEY
import com.gm.settingsservice.utils.Constants.SHARED_PREF_SKEW_KEY
import com.gm.settingsservice.utils.Constants.isFromConfigSkew
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Fragment to display Configuration settings list screen
 */
class SettingsConfigurationFragment : BaseFragment() {
    override fun getContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var eventProcessor: EventProcessor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val settingsConfigBinding = DataBindingUtil.inflate<SettingsThemeBinding>(inflater, R.layout.ics_setting_themes_fragment, container, false)

        settingsConfigBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }

        return settingsConfigBinding.root
    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.settingsConfigurationList.clear()
        if(dataPoolDataHandler.isLHD.get()!! ==false&& dataPoolDataHandler.isRHD.get()!! ==false&& dataPoolDataHandler.isRTL.get()==false && dataPoolDataHandler.isSkew.get()==false){
            sharedPreferences.edit().putBoolean(SHARED_PREF_LHD_KEY,true).apply()
            dataPoolDataHandler.isLHD.set(true)

        }
        getSettingsConfigList()

    }

    /**
     * Setting Default Configuration setup
     */
    private fun getSettingsConfigList() {

        dataPoolDataHandler.settingsConfigurationList.clear()
        dataPoolDataHandler.isLHD.set( sharedPreferences.getBoolean(SHARED_PREF_LHD_KEY, true))
        dataPoolDataHandler.isRHD.set( sharedPreferences.getBoolean(SHARED_PREF_RHD_KEY, false))
        dataPoolDataHandler.isRTL.set(sharedPreferences.getBoolean(SHARED_PREF_RTL_KEY, false))
        dataPoolDataHandler.isSkew.set(sharedPreferences.getBoolean(SHARED_PREF_SKEW_KEY, false))
        dataPoolDataHandler.settingsConfigurationList.add(SettingsConfigurationModel("LHD",dataPoolDataHandler.isLHD.get()!!))
        dataPoolDataHandler.settingsConfigurationList.add(SettingsConfigurationModel("RHD",dataPoolDataHandler.isRHD.get()!!))
        dataPoolDataHandler.settingsConfigurationList.add(SettingsConfigurationModel("RTL",dataPoolDataHandler.isRTL.get()!!))
        dataPoolDataHandler.settingsConfigurationList.add(SettingsConfigurationModel("Skew",dataPoolDataHandler.isSkew.get()!!))
        dataPoolDataHandler.isSkew.set(sharedPreferences.getBoolean(SHARED_PREF_SKEW_KEY, false))
        try {

            dataPoolDataHandler.settingsConfiguration.set(dataPoolDataHandler.settingsConfigurationList.filter { a->a.status }[0])// need to handle the exception in case if we dont have any
        }
        catch (ioe:IndexOutOfBoundsException){

        }
    }
    fun onEventProcess(view:View, obj:Any?){
        if(view is ToggleButton){
            (obj as SettingsConfigurationModel).status = view.isChecked


            when(obj.configName)
            {
                "LHD" -> {
                    if (obj.status) {
                        sharedPreferences.edit().putBoolean(SHARED_PREF_RHD_KEY, false).apply()
                        sharedPreferences.edit().putBoolean(SHARED_PREF_RTL_KEY, false).apply()
                    }
                    dataPoolDataHandler.isLHD.set(true)
                    dataPoolDataHandler.settingsConfiguration.set(SettingsConfigurationModel("LHD", obj.status))
                    sharedPreferences.edit().putBoolean(SHARED_PREF_LHD_KEY, obj.status).apply()
                }
                "RHD" -> {
                    if (obj.status) {
                        sharedPreferences.edit().putBoolean(SHARED_PREF_LHD_KEY, false).apply()
                        sharedPreferences.edit().putBoolean(SHARED_PREF_RTL_KEY, false).apply()
                    }
                    dataPoolDataHandler.isLHD.set(false)
                    dataPoolDataHandler.isRHD.set(true)

                    dataPoolDataHandler.settingsConfiguration.set(SettingsConfigurationModel("RHD", obj.status))
                    sharedPreferences.edit().putBoolean(SHARED_PREF_RHD_KEY, obj.status).apply()
                }
                "RTL" -> {
                    if (obj.status) {
                        sharedPreferences.edit().putBoolean(SHARED_PREF_LHD_KEY, false).apply()
                        sharedPreferences.edit().putBoolean(SHARED_PREF_RHD_KEY, false).apply()
                    }
                    dataPoolDataHandler.isLHD.set(true)
                    dataPoolDataHandler.settingsConfiguration.set(SettingsConfigurationModel("RTL", obj.status))
                    sharedPreferences.edit().putBoolean(SHARED_PREF_RTL_KEY, obj.status).apply()
                }
                "Skew" -> {
                    dataPoolDataHandler.isSkew.set(obj.status)
                    sharedPreferences.edit().putBoolean(SHARED_PREF_SKEW_KEY, obj.status).apply()
                    isFromConfigSkew=true
                    GMSettingsApp.appContext.activityContext.recreate()
                }

            }
        }
        getSettingsConfigList()
    }
}