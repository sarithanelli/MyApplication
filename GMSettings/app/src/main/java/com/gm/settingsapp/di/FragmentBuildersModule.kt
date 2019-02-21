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

import com.gm.settingsapp.ui.activities.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSettingsAppsFragment(): SettingsAppsFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsConfigurationFragment(): SettingsConfigurationFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFavoritesMenuFragment(): SettingsFavoritesMenuFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsPersonalFragment(): SettingsPersonalFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsSetNumberFavoritesFragment(): SettingsNumberFavoritesFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsSystemFragment(): SettingsSystemFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsVehicleFragment(): SettingsVehicleFragment
}
