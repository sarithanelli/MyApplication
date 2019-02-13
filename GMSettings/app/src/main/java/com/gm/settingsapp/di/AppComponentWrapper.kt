package com.gm.settingsapp.di

import android.app.Application
import com.gm.settingsservice.di.ServiceAppComponent
import com.gm.settingsservice.di.ServiceAppComponentWrapper

class AppComponentWrapper {
    companion object {
        private var appComponentWrapper: AppComponentWrapper? = null

lateinit var app: Application
        fun getInstance(application: Application): AppComponentWrapper? {
            app = application
            if (appComponentWrapper == null) {
                synchronized(AppComponentWrapper::class.java) {
                    if (appComponentWrapper == null) {
                        appComponentWrapper = AppComponentWrapper()
                        initializeComponent(ServiceAppComponentWrapper.getServiceAppComponent(app)!!)
                    }
                }
            }
            return appComponentWrapper
        }

        private var appComponent: AppComponent? = null

        fun getAppComponent(application: Application): AppComponent? {
            val appComponentWrapper = getInstance(application)
            return appComponent
        }

        fun initializeComponent(serviceAppComponent: ServiceAppComponent): AppComponent? {
            appComponent = DaggerAppComponent.builder()
                    .application(app)
                    .serviceAppComponent(serviceAppComponent)
                    .build()
            return appComponent
        }
    }
}