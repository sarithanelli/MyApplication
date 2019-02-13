package com.gm.settingsapp.ui.activities.fragments

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsPersonalFragmentBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.support.AndroidSupportInjection

/**
 * Fragment to display Personal tab list screen
 */
class SettingsPersonalFragment : BaseFragment() {
    override fun getContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)

        val settingsBinding = DataBindingUtil.inflate<SettingsPersonalFragmentBinding>(inflater, R.layout.ics_settings_personal_fragment, container, false)

        settingsBinding.let {
            it.clickHandler = eventHandler
            it.dataPoolHandler = dataPoolDataHandler
        }

        return settingsBinding.root
    }

    fun onEventProcess(view:View, obj:Any?){
    }
}