package com.gm.settingsapp.ui.activities


import android.os.Bundle
import android.view.View
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.TimeZonetActivityBinding
import com.gm.settingsapp.viewmodels.TimeZoneParse
import com.gm.settingsservice.models.GmTimeZone
import com.gm.settingsservice.models.TimeDateModel
import dagger.android.AndroidInjection
import java.util.*
import kotlin.collections.ArrayList

/**
 * To change time zone of system
 */
class SettingsTimeZoneActivity : BaseActivity() {
    override fun onEventResponse(view: View, obj: Any?) {

        dataPoolDataHandler.SETTINGS_TIMEZONE_VALUE.set(obj as GmTimeZone)
        val tzId = TimeZone.getDefault().id
        val tz = dataPoolDataHandler.SETTINGS_TIMEZONE_VALUE.get()
        val text = if (tz != null) tz!!.displayOffset + ", " + tz!!.name else tzId
        dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.set(text)
        if (dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.get().equals(resources.getString(R.string.autoTimeZone))) {
            dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.set(resources.getString(R.string.settings_auto))
        }
        dataPoolDataHandler.SETTINGS_SET_TIMEDATE_ROW.set(1, TimeDateModel(GMSettingsApp.appContext.resources.getString(R.string.settings_select_time_zone_long), dataPoolDataHandler.SETTINGS_SELECTTIMEZONE_VALUE.get() + "", false, false, 1, ""))
        dataPoolDataHandler.SETTINGS_RECYCLERVIEW_SCROLL_STATE.set(dataPoolDataHandler.SETTINGS_TIMEZONE_VALUES.indexOf(obj))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = setContentSubView(R.layout.ics_settings_timezone_list) as TimeZonetActivityBinding
        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        dataPoolDataHandler.SETTINGS_TIMEZONE_VALUES.clear()
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(R.string.settings_select_time_zone))
        val valuelist = TimeZoneParse.sTimeZoneList.keys
        val sortingList = ArrayList<String>()
        valuelist.forEach {
            sortingList.add(it)
            Collections.sort(sortingList)
        }
        sortingList.forEach {
            dataPoolDataHandler.SETTINGS_TIMEZONE_VALUES.add(TimeZoneParse.getTimeZone(it))
        }
        if (dataPoolDataHandler.SETTINGS_TIMEZONE_VALUE.get() == null) {
            dataPoolDataHandler.SETTINGS_TIMEZONE_VALUE.set(TimeZoneParse.getTimeZone(resources.getString(R.string.autoKey)))
            dataPoolDataHandler.SETTINGS_RECYCLERVIEW_SCROLL_STATE.set(dataPoolDataHandler.SETTINGS_TIMEZONE_VALUES.indexOf(TimeZoneParse.getTimeZone(resources.getString(R.string.autoKey))))
        } else {
            dataPoolDataHandler.SETTINGS_RECYCLERVIEW_SCROLL_STATE.set(dataPoolDataHandler.SETTINGS_TIMEZONE_VALUES.indexOf(dataPoolDataHandler.SETTINGS_TIMEZONE_VALUE.get()))

        }
    }

    override fun onResume() {
        super.onResume()
    }

}
