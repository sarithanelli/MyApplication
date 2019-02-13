package com.gm.settingsapp.ui.activities

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.ActivityThemeBinding
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.AndroidInjection

/**
 * Fragment is used to show the configuration screen which contains RTC,RHD,LHD,SKEW enable
 * and disable options
 * **/
class ConfigurationActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {
        
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityThemeBinding>(this, R.layout.ics_themes)
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
    }

}