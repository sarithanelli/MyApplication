/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gm.settingsapp.di


import com.gm.settingsapp.ui.activities.*
import com.gm.settingsservice.apiintegration.SettingsService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FragmentBuildersModule::class])
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeSettingsHomeActivity(): SettingsHomeActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsAutomaticTimeZoneActivity(): SettingsAutomaticTimeZoneActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsCalibrationActivity(): SettingsCalibrationActivity

    @ContributesAndroidInjector
    abstract fun contributSettingsCalibrationFailureActivity(): SettingsCalibrationFailureActivity

    @ContributesAndroidInjector
    abstract fun contributSettingsDisplayActivity(): SettingsDisplayActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDisplayModeActivity(): SettingsDisplayModeActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragmentContainerActivity(): SettingsFragmentContainerActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsLanguagesActivity(): SettingsLanguagesActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsOnOffActivitySounds(): SettingsOnOffActivitySounds

    @ContributesAndroidInjector
    abstract fun contributeSettingsPopupActivity(): SettingsPopupActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSearchButtonActivity(): SettingsSearchButtonActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSoundsActivity(): SettingsSoundsActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSoundsAudioCueVolActivity(): SettingsSoundsAudioCueVolActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSoundsMaxVolumeActivity(): SettingsSoundsMaxVolumeActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSoundsPopupCueActivity(): SettingsSoundsPopupCueActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsTimeDateActivity(): SettingsTimeDateActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsTimeDateOnOffActivity(): SettingsTimeDateOnOffActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsTimeZoneActivity(): SettingsTimeZoneActivity

    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun contributeDisplayOffActivity(): DisplayOffActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsFavoritesActivity(): SettingsFavoritesActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsManageFavoritesActivity(): SettingsManageFavoritesActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsService(): SettingsService

    @ContributesAndroidInjector
    abstract fun contributeAirQualitySensorSettingsActivity(): AirQualitySensorSettingsActivity

    @ContributesAndroidInjector
    abstract fun contributeAutoFanSpeedActivity(): AutoFanSpeedActivity

    @ContributesAndroidInjector
    abstract fun contributeAutoAirDistributionActivity(): AutoAirDistributionActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsVehicleDriveModeEngineActivity(): SettingsVehicleDriveModeEngineActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsClearDefaultPopupActivity(): SettingsClearDefaultPopupActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsClimateActivity(): SettingsClimateActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDataResetPopupActivity(): SettingsDataResetPopupActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDrivingModeActivity(): SettingsDrivingModeActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsEraseLoadingActivity(): SettingsEraseLoadingActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsEraseSettingsPopupActivity(): SettingsEraseSettingsPopupActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsFactoryPopupActivity(): SettingsFactoryPopupActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsFactoryRetryActivity(): SettingsFactoryRetryActivity

    @ContributesAndroidInjector
    abstract fun contributeConfigurationActivity(): ConfigurationActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsReturnToFactoryActivity(): SettingsReturnToFactoryActivity

    @ContributesAndroidInjector
    abstract fun contributeRunningAppsSettingsActivity(): RunningAppsSettingsActivity

    @ContributesAndroidInjector
    abstract fun contributeRunningsAppsPopupSettingsActivity(): RunningsAppsPopupSettingsActivity

    @ContributesAndroidInjector
    abstract fun contributeHTMLViewerActivity() :  HTMLViewerActivity
    @ContributesAndroidInjector
    abstract fun contributeAboutSettingsLauncherActivity() : AboutSettingsLauncherActivity
    @ContributesAndroidInjector
    abstract fun contributeSettingsAboutBuildNumberActivity() :SettingsAboutBuildNumberActivity
    @ContributesAndroidInjector
    abstract fun contributeSettingsAboutDeviceRegistrationActivity() :SettingsAboutDeviceRegistrationActivity
    @ContributesAndroidInjector
    abstract fun contributeSettingsAppsAudioActivity() :SettingsAppsAudioActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsAppsOnOffActivity() :SettingsAppsOnOffActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsAutoModeCustomizationActivity() :SettingsAutoModeCustomizationActivity
    @ContributesAndroidInjector
    abstract fun contributeSettingsClimateOnOffActivity() :SettingsClimateOnOffActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDriveModeSteeringActivity() :SettingsDriveModeSteeringActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDrivingModeSuspensionActivity() :SettingsDrivingModeSuspensionActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsDrivingModeTractionActivity() :SettingsDrivingModeTractionActivity

    @ContributesAndroidInjector
    abstract fun contributeSettingsSportModeCustomizationActivity() :SettingsSportModeCustomizationActivity
    @ContributesAndroidInjector
    abstract fun contributeSettingsSportModeCustomizationOnOffActivity() :SettingsSportModeCustomizationOnOffActivity


    @ContributesAndroidInjector
    abstract fun SettingsMyModeActivity(): SettingsMyModeActivity

    @ContributesAndroidInjector
    abstract fun SettingsVehicleMyModeEngineActivity(): SettingsVehicleMyModeEngineActivity

    @ContributesAndroidInjector
    abstract fun SettingsVehicleMyModeSteeringActivity(): SettingsVehicleMyModeSteeringActivity

    @ContributesAndroidInjector
    abstract fun SettingsVehicleMyModeSuspensionActivity(): SettingsVehicleMyModeSuspensionActivity

    @ContributesAndroidInjector
    abstract fun SettingsVehicleMyModeBrakeActivity(): SettingsVehicleMyModeBrakeActivity

    @ContributesAndroidInjector
    abstract fun SettingsVModeActivity(): SettingsVModeActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleVModeEngineActivity(): SettingsVehicleVModeEngineActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleVModeSteeringActivity(): SettingsVehicleVModeSteeringActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleVModeSuspensionActivity(): SettingsVehicleVModeSuspensionActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleVModeBrakeActivity(): SettingsVehicleVModeBrakeActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleVModePowertrainActivity(): SettingsVehicleVModePowertrainActivity
    @ContributesAndroidInjector
    abstract fun SettingsComfortAndConvenienceActivity(): SettingsComfortAndConvenienceActivity
    @ContributesAndroidInjector
    abstract fun SettingsAutomaticRunningBoardsActivity(): SettingsAutomaticRunningBoardsActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleComfortAutomaticEntryActivity(): SettingsVehicleComfortAndConvenienceOnOffActivity
       @ContributesAndroidInjector
    abstract fun SettingsVehicleComfortPowerLiftgateActivity(): SettingsVehicleComfortPowerLiftgateActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleHandFreeLiftgateActivity(): SettingsVehicleHandFreeLiftgateActivity
    @ContributesAndroidInjector
    abstract fun SettingsVehicleComfortRainSenseWiperActivity(): SettingsVehicleComfortRainSenseWiperActivity


}
