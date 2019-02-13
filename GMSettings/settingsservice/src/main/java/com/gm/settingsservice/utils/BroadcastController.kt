package com.gm.settingsservice.utils

import android.content.Context
import android.util.Log
import kotlin.collections.ArrayList

class BroadcastController private constructor(context: Context) {
    private val TAG = BroadcastController::class.java.simpleName
    private val mContext: Context = context
    private var registerBroadcastList: RegisterdBroadcastList? = null
    var mTimeChangedListener = ArrayList<ITimeChanged>()
    var mSystemStateChangedListener = ArrayList<ISystemStateChanged>()
    var mConnectionStateListener = ArrayList<IConnectionStateChanged>()

    companion object {
        private var myObj: BroadcastController? = null
        @Volatile
        private var isReceiverRegistered = false

        /**
         * Create a static method to get instance.
         */
        fun getInstance(context: Context): BroadcastController? {
            if (myObj == null) {
                synchronized(BroadcastController::class.java) {
                    if (myObj == null) {
                        myObj = BroadcastController(context)
                    }
                }
            }
            return myObj
        }
    }

    fun registerBroadcastReceiver() {
        synchronized(BroadcastController::class.java) {
            if (!isReceiverRegistered) {
                registerBroadcastList = RegisterdBroadcastList.getInstance(mContext)
                for (broadCastType in RegisterdBroadcastList.BroadCastType.values()) {
                    registerBroadcastList!!.registerBroadcast(broadCastType)
                    Log.e(TAG, "Registering broadcast: $broadCastType")
                }
                isReceiverRegistered = true
            }
        }
    }

    fun unregisterBroadcastReceiver() {
        synchronized(BroadcastController::class.java) {
            if (isReceiverRegistered) {
                registerBroadcastList = RegisterdBroadcastList.getInstance(mContext)
                for (broadCastType in RegisterdBroadcastList.BroadCastType.values()) {
                    registerBroadcastList!!.unregisterBroadcast(broadCastType)
                    Log.e(TAG, "UnRegistering broadcast: $broadCastType")
                }
                isReceiverRegistered = false
            }
        }
    }

    fun addTimeChangedListener(listener: ITimeChanged) {
        if (!mTimeChangedListener.contains(listener)) {
            mTimeChangedListener.add(listener)
        }
    }

    fun removeTimeChangedListener(listener: ITimeChanged) {
        if (mTimeChangedListener.contains(listener)) {
            mTimeChangedListener.remove(listener)
        }
    }

    fun addSystemStateChangedListener(listener: ISystemStateChanged) {
        if (!mSystemStateChangedListener.contains(listener)) {
            mSystemStateChangedListener.add(listener)
        }
    }

    fun removeSystemStateChangedListener(listener: ISystemStateChanged) {
        if (mSystemStateChangedListener.contains(listener)) {
            mSystemStateChangedListener.remove(listener)
        }
    }

    fun addConnectionStateListener(listener: IConnectionStateChanged) {
        if (!mConnectionStateListener.contains(listener)) {
            mConnectionStateListener.add(listener)
        }
    }

    fun removeConnectionStateListener(listener: IConnectionStateChanged) {
        mConnectionStateListener.remove(listener)
    }


}