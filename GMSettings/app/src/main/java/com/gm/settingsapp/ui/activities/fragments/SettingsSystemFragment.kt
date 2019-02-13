package com.gm.settingsapp.ui.activities.fragments

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import com.gm.settingsapp.GMSettingsApp

import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsSystemFragmentBinding
import com.gm.settingsapp.ui.adapters.BinderDataBindingComponent

import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.utils.Constants
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * Fragment to display System list in viewpager
 */
class SettingsSystemFragment : BaseFragment() {

    lateinit var dataBindingComponent: DataBindingComponent

    @Inject
    lateinit var eventProcessor: EventProcessor
    override fun getContainerId(): Int {
      return R.layout.ics_settings_system_fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        dataBindingComponent = BinderDataBindingComponent(eventHandler,eventProcessor,utility,serviceUtility,dataPoolDataHandler)
        val settingsBinding = DataBindingUtil.inflate<SettingsSystemFragmentBinding>(inflater, R.layout.ics_settings_system_fragment, container, false,dataBindingComponent)
        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_REQ_SYSTEMDATA.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.system_data).forEach {
            dataPoolDataHandler.SETTINGS_REQ_SYSTEMDATA.add(it)
        }
        GMSettingsApp.appContext.recyclerViewAdapter = null

        eventHandler.initEvent("initListeners",null)
        return settingsBinding.root
    }

    fun onEventProcess(view:View, obj:Any?){
        if (obj is Int) {
            when (obj) {
                Constants.SET_TIME_SCREEN ->
                    dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.set(Constants.SET_TIME_SCREEN)
                Constants.SET_DATE_SCREEN ->
                    dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.set(Constants.SET_DATE_SCREEN)
                Constants.USES_24HOUR_FORMAT_SCREEN ->
                    dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.set(Constants.USES_24HOUR_FORMAT_SCREEN)
                Constants.AUTOMATIC_TIME_AND_DATE_SCREEN ->
                    dataPoolDataHandler.SETTINGS_CHILD_CURRENT_SCREEN.set(Constants.AUTOMATIC_TIME_AND_DATE_SCREEN)
                Constants.AUTOMATIC_TIME_ZONE_SCREEN-> {
                    dataPoolDataHandler.SETTINGS_Automatic_TIME_ZONE_SCREEN_STATUS.set(false)
                }
            }
        }

    }
}