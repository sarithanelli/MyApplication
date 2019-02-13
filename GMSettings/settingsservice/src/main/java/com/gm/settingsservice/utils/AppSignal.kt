package com.gm.settingsservice.utils

import gm.vehicle.Customization

open class AppSignal{
    open var mCustomization: Customization = Customization()

    open val signalValue: Int
        get() = RESULT_NONE

    open val isAvailable: Boolean
        get() = false

    enum class SignalKey {
        PerformanceModeSound,
        PerformanceModeSteering,
        PerformanceModeSuspension,
        PerformanceModeDriveline,
        PerformanceModeMainMenuType,
        AirQualitySensor,
        AutomaticFan,
        PollutionControl,
        AutomaticCooledSeat,
        AutomaticHeatedSeat,
        RearDefogStartup,
        RearZoneStartup,
        AutomaticDefog,
        ElevatedIdle,
        AutoAirDistribution,
        IonizerControl
    }

    open fun hasAvailableOptions(): Boolean {
        return false
    }

    companion object {
        val RESULT_NONE = -1

        fun getInstance(mSignalKey: SignalKey): AppSignal {
            when (mSignalKey) {
                AppSignal.SignalKey.PerformanceModeSound -> return Signals.PerformanceModeSoundSignal()
                AppSignal.SignalKey.PerformanceModeMainMenuType->return Signals.PerformanceModeMainMenuTypeSignal()
                AppSignal.SignalKey.PerformanceModeSteering->return Signals.PerformanceModeSteeringSignal()
                AppSignal.SignalKey.PerformanceModeSuspension->return Signals.PerformanceModeSuspensionSignal()
                AppSignal.SignalKey.PerformanceModeDriveline->return Signals.PerformanceModeDrivelineSignal()
                AppSignal.SignalKey.AirQualitySensor -> return Signals.AirQualitySensorSignal()
                AppSignal.SignalKey.AutomaticFan -> return Signals.AutomaticFanSignal()
                AppSignal.SignalKey.PollutionControl -> return Signals.PollutionControlSignal()
                AppSignal.SignalKey.AutomaticCooledSeat -> return Signals.AutomaticCooledSeatSignal()
                AppSignal.SignalKey.AutomaticHeatedSeat -> return Signals.AutomaticHeatedSeatSignal()
                AppSignal.SignalKey.RearDefogStartup -> return Signals.RearDefogStartupSignal()
                AppSignal.SignalKey.RearZoneStartup -> return Signals.RearZoneStartupSignal()
                AppSignal.SignalKey.AutomaticDefog -> return Signals.AutomaticDefogSignal()
                AppSignal.SignalKey.ElevatedIdle -> return Signals.ElevatedIdleSignal()
                AppSignal.SignalKey.AutoAirDistribution -> return Signals.AutoAirDistributionSignal()
                AppSignal.SignalKey.IonizerControl -> return Signals.IonizerControlSignal()
            }
            return AppSignal()
        }
    }
}
