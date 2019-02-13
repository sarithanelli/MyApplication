package com.gm.settingsservice.utils

import gm.vehicle.VehicleDataUnavailableException

class Signals {


    class PerformanceModeMainMenuTypeSignal : AppSignal() {
        override val signalValue: Int
            get() {
                try {
                    return mCustomization.performanceModeMainMenuType

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return AppSignal.RESULT_NONE
                }
            }
    }

    //this class used for engine sound availability
    class PerformanceModeSoundSignal : AppSignal() {

        override val isAvailable: Boolean
            get() {
                try {
                    return mCustomization.soundPerformanceModeCustomizationSettingAvailable

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return false
                }
            }

        fun setSignalValue(value: Int): Int {

            return mCustomization.setSoundPerformanceModeCustomizationSettingRequest(value)

        }

        override val signalValue: Int
            get() {
                try {
                    return mCustomization.soundPerformanceModeCustomizationCurrentSettingValue

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return AppSignal.RESULT_NONE
                }
            }


        override fun hasAvailableOptions(): Boolean {
            try {
                println("EngineAvailble" + mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode1Available)
                return mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode1Available ||
                        mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode2Available ||
                        mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode3Available ||
                        mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode4Available ||
                        mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode5Available ||
                        mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode6Available
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }

    //this class used for steering availability
    class PerformanceModeSteeringSignal : AppSignal() {
        override val isAvailable: Boolean
            get() {
                try {
                    return mCustomization.steeringCustomizationSettingAvailable

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return false
                }
            }

        fun setSignalValue(value: Int): Int {

            return mCustomization.setSteeringCustomizationSettingRequest(value)

        }

        override val signalValue: Int
            get() {
                try {
                    return mCustomization.steeringCustomizationCurrentSettingValue

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return AppSignal.RESULT_NONE
                }
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                println("SteeringAvailble" + mCustomization.soundPerformanceModeCustomizationAvailableSoundPerformanceMode1Available)
                return mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode1Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode2Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode3Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode4Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode5Available ||
                        mCustomization.steeringPerformanceModeCustomizationAvailableSteeringPerformanceMode6Available
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }

    //this class used for suspension availability
    class PerformanceModeSuspensionSignal : AppSignal() {
        override val isAvailable: Boolean
            get() {
                try {
                    return mCustomization.suspensionCustomizationSettingAvailable

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return false
                }
            }

        fun setSignalValue(value: Int): Int {

            return mCustomization.setSuspensionCustomizationSettingRequest(value)

        }

        override val signalValue: Int
            get() {
                try {
                    return mCustomization.suspensionCustomizationCurrentSettingValue

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return AppSignal.RESULT_NONE
                }
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                println("SuspensionAvailble" + mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode1Available)
                return mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode1Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode2Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode3Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode4Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode5Available ||
                        mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode6Available
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }

    //this class used for suspension availability
    class PerformanceModeDrivelineSignal : AppSignal() {
        override val isAvailable: Boolean
            get() {
                try {
                    return mCustomization.drivelineCustomizationSettingAvailable

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return false
                }
            }

        fun setSignalValue(value: Int): Int {

            return mCustomization.setDrivelineCustomizationSettingRequest(value)

        }

        override val signalValue: Int
            get() {
                try {
                    return mCustomization.drivelineCustomizationCurrentSettingValue

                } catch (e: VehicleDataUnavailableException) {
                    e.printStackTrace()
                    return AppSignal.RESULT_NONE
                }
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                println("SuspensionAvailble" + mCustomization.suspensionPerformanceModeCustomizationAvailableSuspensionPerformanceMode1Available)
                return mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode1Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode2Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode3Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode4Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode5Available ||
                        mCustomization.drivelinePerformanceModeCustomizationAvailableDrivelinePerformanceMode6Available
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }
        }
    }

    //this class used for engine Air Quality Sensor
    class AirQualitySensorSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.airQualitySensorCustomizationSettingAvailable

        override var signalValue: Int = mCustomization.airQualitySensorCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAirQualitySensorCustomizationChangeSettingRequest(value)
            }


        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.airQualitySensorCustomizationAvailabilityFlag1 ||
                        mCustomization.airQualitySensorCustomizationAvailabilityFlag2 ||
                        mCustomization.airQualitySensorCustomizationAvailabilityFlag3
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Auto Fan Speed
    class AutomaticFanSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.automaticFanCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.automaticFanCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAutomaticFanCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.automaticFanCustomizationAvailabilityFlag1 ||
                        mCustomization.automaticFanCustomizationAvailabilityFlag2 ||
                        mCustomization.automaticFanCustomizationAvailabilityFlag3
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Pollution Control
    class PollutionControlSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.pollutionControlCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.pollutionControlCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setPollutionControlCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.pollutionControlCustomizationAvailabilityFlag1 ||
                        mCustomization.pollutionControlCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Automatic Heated Seats
    class AutomaticHeatedSeatSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.automaticHeatedSeatCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.automaticHeatedSeatCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAutomaticHeatedSeatCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.automaticHeatedSeatCustomizationAvailabilityFlag1 ||
                        mCustomization.automaticHeatedSeatCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Automatic Cooled Seats
    class AutomaticCooledSeatSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.automaticCooledSeatCustomizationSettingAvailable

        override var signalValue: Int = mCustomization.automaticCooledSeatCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAutomaticCooledSeatCustomizationChangeSettingRequest(value)
            }


        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.automaticCooledSeatCustomizationAvailabilityFlag1 ||
                        mCustomization.automaticCooledSeatCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Rear Defog Startup
    class RearDefogStartupSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.rearDefogStartupCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.rearDefogStartupCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setRearDefogStartupCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.rearDefogStartupCustomizationAvailabilityFlag1 ||
                        mCustomization.rearDefogStartupCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Rear Climate Startup
    class RearZoneStartupSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.rearZoneStartupCustomizationSettingAvailable

        override var signalValue: Int = mCustomization.rearZoneStartupCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setRearZoneStartupCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.rearZoneStartupCustomizationAvailabilityFlag1 ||
                        mCustomization.rearZoneStartupCustomizationAvailabilityFlag2 ||
                        mCustomization.rearZoneStartupCustomizationAvailabilityFlag3
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine  Auto Defog
    class AutomaticDefogSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.automaticDefogCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.automaticDefogCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAutomaticDefogCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.automaticDefogCustomizationAvailabilityFlag1 ||
                        mCustomization.automaticDefogCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine  Rapid  Heat Elevated Idle
    class ElevatedIdleSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.elevatedIdleCustomizationSettingAvailable

        override var signalValue: Int = mCustomization.elevatedIdleCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setElevatedIdleCustomizationChangeSettingRequest(value)
            }

        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.remoteLeftVehicleReminderCustomizationAvailabilityFlag1 ||
                        mCustomization.remoteLeftVehicleReminderCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine Auto Air Distribution
    class AutoAirDistributionSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.automaticAirDistributionCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.automaticAirDistributionCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setAutoAirDistributionCustomizationChangeSettingRequest(value)
            }


        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.automaticAirDistributionCustomizationAvailabilityFlag1 ||
                        mCustomization.automaticAirDistributionCustomizationAvailabilityFlag2 ||
                        mCustomization.automaticAirDistributionCustomizationAvailabilityFlag3 ||
                        mCustomization.automaticAirDistributionCustomizationAvailabilityFlag4
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }


    //this class used for engine IonizerControl
    class IonizerControlSignal : AppSignal() {

        override var isAvailable: Boolean = mCustomization.ionizerControlCustomizationSettingAvailable


        override var signalValue: Int = mCustomization.ionizerControlCustomizationCurrentSettingValue
            set(value) {
                mCustomization.setIonizerControlCustomizationChangeSettingRequest(value)
            }


        override fun hasAvailableOptions(): Boolean {
            try {
                return mCustomization.ionizerControlCustomizationAvailabilityFlag1 ||
                        mCustomization.ionizerControlCustomizationAvailabilityFlag2
            } catch (e: VehicleDataUnavailableException) {
                e.printStackTrace()
                return false
            }

        }
    }

}

