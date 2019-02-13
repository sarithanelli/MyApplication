package com.gm.settingsapp.ui.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsVehicleFragmentBinding
import com.gm.settingsapp.ui.adapters.BinderDataBindingComponent
import com.gm.settingsapp.viewmodels.EventProcessor
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Fragment to display Vehicle list in viewpager
 */
class SettingsVehicleFragment : BaseFragment() {

    private val DRIVEMODE_TAG: String = "eDriveMode"
    private val CLIMATE_TAG: String = "eClimate"
    lateinit var dataBindingComponent: DataBindingComponent

    @Inject
    lateinit var eventProcessor: EventProcessor

    override fun getContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        dataBindingComponent = BinderDataBindingComponent(eventHandler,eventProcessor,utility,serviceUtility,dataPoolDataHandler)
        val settingsBinding = DataBindingUtil.inflate<SettingsVehicleFragmentBinding>(inflater, R.layout.ics_settings_vehicle_fragment, container, false,dataBindingComponent)
        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }
        return settingsBinding.root
    }
}