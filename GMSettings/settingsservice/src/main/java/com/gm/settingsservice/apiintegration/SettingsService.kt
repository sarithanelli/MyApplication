package com.gm.settingsservice.apiintegration

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.gm.settingsservice.BuildConfig
import dagger.android.AndroidInjection
import java.util.*
import javax.inject.Inject

/**
 * This class To Process data when UI event occurred,
 * Calling methods from respective tags and updating data and creating context, single instances.
 */
class SettingsService : Service() {

    @Inject
    lateinit var systemController: SystemController

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
         appContext = this

        AndroidInjection.inject(this)


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        if (intent!=null) {
            systemController.execute(intent.getStringExtra("eventName"), getIntentExtra(intent))
        }

        return super.onStartCommand(intent, flags, startId)
    }

    companion object {

        var any: Any? = null

        /** Context object for accessing resources and components across Settingservice*/
        var mTempDate: Calendar? =null
        var mMinDate: Calendar? =null
        var mMaxDate: Calendar? =null



        /**
         * Check if this application is running on GM's OS build
         */
        lateinit var appContext: Context

        fun isSDKAvailable(): Boolean =
                android.os.Build.MANUFACTURER == BuildConfig.VENDOR

    }
    /**
     * getting data of different type like  String, Int, Boolean, object from Intent
     * @param eventObject to be passed data
     * @param serviceIntent Intent
     * @return Any data comes from Intent
     */

    private fun getIntentExtra(intent: Intent?): Any? {
        var eventObject: Any?= null
        if (intent!!.hasExtra("eventObj"))
            eventObject= intent.getParcelableExtra("eventObj")
        else if (intent.hasExtra("eventString"))
            eventObject= intent.getStringExtra("eventString")
        else if (intent.hasExtra("eventLong"))
            eventObject= intent.getLongExtra("eventLong", 0)
        else if (intent.hasExtra("eventBoolean"))
            eventObject= intent.getBooleanExtra("eventBoolean", false)
        else if (intent.hasExtra("eventInt"))
            eventObject= intent.getIntExtra("eventInt", 0)
        else if (intent.hasExtra("eventFloat"))
            eventObject= intent.getFloatExtra("eventFloat", 0f)
        else if (intent.hasExtra("eventSerializableObj"))
            eventObject= intent.getSerializableExtra("eventSerializableObj")

        return eventObject
    }

}