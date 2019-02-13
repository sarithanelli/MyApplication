package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.ReturnToFactoryActivityBinding
import dagger.android.AndroidInjection

/**
 * This Activity is used to display the list of Return to factory settings
 */
class SettingsReturnToFactoryActivity:BaseActivity(){
    override fun onEventResponse(view: View, obj: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding=setContentSubView(R.layout.ics_settings_return_to_factory) as ReturnToFactoryActivityBinding
        binding.let{
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_RETURN_FACTORY.clear()
        GMSettingsApp.appContext.resources.getStringArray(R.array.return_data).forEach {
            dataPoolDataHandler.SETTINGS_RETURN_FACTORY.add(it)
        }
        GMSettingsApp.appContext.recyclerViewAdapter = null
    }

    override fun onResume() {
        super.onResume()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.
                getString(R.string.settings_reset_to_factory_settings))
    }
}