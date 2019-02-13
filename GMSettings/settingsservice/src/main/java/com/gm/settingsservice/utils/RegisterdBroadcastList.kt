package com.gm.settingsservice.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import gm.connection.DeviceConnectionManager
import gm.powermode.PowerModeManager

class RegisterdBroadcastList private constructor(context: Context) {
    private val mContext: Context = context
    private var mTimeChanged: BroadcastReceiver? = null
    private var mSystemStateChanged: BroadcastReceiver? = null
    private var mConnectionStateChanged: BroadcastReceiver? = null
    private val broadcastController = BroadcastController.getInstance(context)

    companion object {
        private var myObj: RegisterdBroadcastList? = null
        /**
         * Create a static method to get instance.
         */
        fun getInstance(context: Context): RegisterdBroadcastList? {
            if (myObj == null) {
                synchronized(BroadcastController::class.java) {
                    if (myObj == null) {
                        myObj = RegisterdBroadcastList(context)
                    }
                }
            }
            return myObj
        }
    }

    enum class BroadCastType {
         SYSTEM_STATE_CHANGED, CONNECTION_STATE_CHANGED,TIME_CHANGED

    }

    fun registerBroadcast(broadCastType: BroadCastType) {
        when (broadCastType) {
            BroadCastType.TIME_CHANGED -> registerTimeChangedBroadcast()
            BroadCastType.SYSTEM_STATE_CHANGED -> registerSystemStateChangedBroadcast()
            BroadCastType.CONNECTION_STATE_CHANGED -> registerConnectionStateChange()
        }
    }

    fun unregisterBroadcast(broadCastType: BroadCastType) {
        when (broadCastType) {
            BroadCastType.TIME_CHANGED -> unregisterBroadcastReceiver(mTimeChanged)
            BroadCastType.SYSTEM_STATE_CHANGED -> unregisterBroadcastReceiver(mSystemStateChanged)
            BroadCastType.CONNECTION_STATE_CHANGED -> unregisterBroadcastReceiver(mConnectionStateChanged)
        }
    }

    private fun unregisterBroadcastReceiver(broadcastReceiver: BroadcastReceiver?) {
        if (broadcastReceiver != null) {
            mContext.unregisterReceiver(broadcastReceiver)
        }
    }

    private fun registerTimeChangedBroadcast() {
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_TIME_TICK)
        filter.addAction(Intent.ACTION_TIME_CHANGED)
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED)
        mTimeChanged = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                for (i in 0 until broadcastController!!.mTimeChangedListener.size) {
                    val timeChanged = broadcastController.mTimeChangedListener[i]
                    timeChanged.OnTimeChanged()
                }
            }
        }
        mContext.registerReceiver(mTimeChanged, filter)
    }


    private fun registerSystemStateChangedBroadcast() {
        val filter = IntentFilter()
        filter.addAction(PowerModeManager.ACTION_SYSTEM_STATE_CHANGE)
        mSystemStateChanged = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val systemState = intent!!.getIntExtra(PowerModeManager.EXTRA_SYSTEM_STATE,
                        PowerModeManager.STATE_SLEEP)
                for (i in 0 until broadcastController!!.mSystemStateChangedListener.size) {
                    val stateChanged = broadcastController.mSystemStateChangedListener[i]
                    stateChanged.OnSystemStateChanged(systemState)
                }
            }

        }
        mContext.registerReceiver(mSystemStateChanged, filter)
    }

    private fun registerConnectionStateChange() {
        val filter = IntentFilter()
        filter.addAction(DeviceConnectionManager.DEVICE_CONNECTION_EVENT)
        mConnectionStateChanged = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.e("", " ConnectionState change  receiver ")
                val action = intent!!.action
                for (connectionStateChange in broadcastController!!.mConnectionStateListener) {
                    connectionStateChange.OnConnectionStateChanged(action, intent)
                }
            }

        }
        mContext.registerReceiver(mConnectionStateChanged, filter)


    }

}