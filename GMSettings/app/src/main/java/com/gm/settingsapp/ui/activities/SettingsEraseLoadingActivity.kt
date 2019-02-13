package com.gm.settingsapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsEraseBinding
import dagger.android.AndroidInjection

/**
 * Used to Erase Data from App
 */
class SettingsEraseLoadingActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_erase_loading) as SettingsEraseBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@SettingsEraseLoadingActivity, SettingsDataResetPopupActivity::class.java))
            binding.progressBar.visibility = View.INVISIBLE
        }, 2000)
    }

    override fun onResume() {
        super.onResume()

    }
}