package com.gm.settingsservice.utils

import android.content.Intent

interface IConnectionStateChanged {
    fun OnConnectionStateChanged(connectionState: String, intent: Intent);
}