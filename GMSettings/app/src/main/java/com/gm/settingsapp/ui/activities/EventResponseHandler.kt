package com.gm.settingsapp.ui.activities

import android.view.View

/**
 * Redirect the user click events from [com.gm.settings.viewmodels.EventHandler] to current visible activity.
 */
interface EventResponseHandler {

    /**
     * Event response callback along with (any) data.
     */
    fun onEventResponse(view:View, obj:Any?)

}
