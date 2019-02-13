package com.gm.settingsapp.ui.activities.fragments

import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.models.DataPoolDataHandler
import javax.inject.Inject


/**
 * Base fragment for all other fragments for settings module. Implement entry and exit animations, if any.
 */
abstract class BaseFragment : androidx.fragment.app.Fragment() {
    abstract fun getContainerId(): Int

    @Inject
    lateinit var eventHandler: EventHandler
    @Inject
    lateinit var dataPoolDataHandler: DataPoolDataHandler
    @Inject
    lateinit var serviceUtility: com.gm.settingsservice.utils.Utility
    @Inject
    lateinit var utility: Utility


}