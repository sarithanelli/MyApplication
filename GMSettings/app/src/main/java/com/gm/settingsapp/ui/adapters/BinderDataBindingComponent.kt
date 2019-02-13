package com.gm.settingsapp.ui.adapters

import androidx.databinding.DataBindingComponent
import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.models.DataPoolDataHandler

class BinderDataBindingComponent(val eventHandler: EventHandler, val eventProcessor: EventProcessor,utility: Utility,serviceUtility: com.gm.settingsservice.utils.Utility,dataPoolDataHandler: DataPoolDataHandler) : DataBindingComponent {

    private val adapter = BinderAdapter(eventHandler, this,eventProcessor,utility, serviceUtility, dataPoolDataHandler)

    override fun getBinderAdapter()= adapter




}