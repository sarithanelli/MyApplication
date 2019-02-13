package com.gm.settingsservice.di

import android.app.Application


class ServiceAppComponentWrapper {


    companion object {

        var serviceAppComponentWrapper: ServiceAppComponentWrapper? = null

        fun getInstance(app: Application): ServiceAppComponentWrapper? {
            if (serviceAppComponentWrapper == null) {
                synchronized(ServiceAppComponentWrapper::class.java) {
                    if (serviceAppComponentWrapper == null) {
                        serviceAppComponentWrapper = ServiceAppComponentWrapper()
                        initializeComponent(app)
                    }
                }
            }
            return serviceAppComponentWrapper
        }

        var baseComponent: ServiceAppComponent? = null

        fun getServiceAppComponent(app: Application): ServiceAppComponent? {
            val appComponentWrapper = getInstance(app)
            return baseComponent
        }

        fun initializeComponent(app: Application): ServiceAppComponent? {
            baseComponent = DaggerServiceAppComponent.builder()
                    .application(app)
                    .build()
            return baseComponent
        }
    }
}