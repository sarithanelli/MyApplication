package com.gm.settingsapp.ui.activities

import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsFragmentContainerActivityBinding
import com.gm.settingsapp.ui.activities.fragments.SettingsFavoritesMenuFragment
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import dagger.android.AndroidInjection

/**
 * To replace the different fragment with container layout
 */
class SettingsFragmentContainerActivity : BaseActivity() {

    private var binding: SettingsFragmentContainerActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = setContentSubView(R.layout.ics_settings_container_layout) as SettingsFragmentContainerActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        SetContentFragment()
    }

    override fun onEventResponse(view: View, obj: Any?) {

    }

    /**
     * To replace the fragments
     */
    fun SetContentFragment() {
        when (dataPoolDataHandler.SETTINGS_FIRST_LEVEL_CURRENT_SCREEN.get()) {
            Constants.FIRST_LEVEL_SYSTEM_TAB_FAVORITES ->
                ReplaceFragment(R.id.settings_container_framelayout, SettingsFavoritesMenuFragment())

        }
    }


    override fun onBackPressed() {
        GMSettingsApp.navigator.backNavigation()
    }

}