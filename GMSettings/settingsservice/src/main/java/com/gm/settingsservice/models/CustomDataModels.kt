package com.gm.settingsservice.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/* Custom Data Models */


/**
 * Non UI Variables
 */


/**
 *
 * This class wraps Parcelable Class object of Event Fired. Implements parcelable interface
 * to pass this class object through intent from one Component to Another.
 */
@Parcelize
open class ParcelableAny : kotlin.Any(), Parcelable

/**
 * Model to create data for timedate screen
 */
@Parcelize
data class TimeDateModel(
        var primaryData: String,
        var secondaryData: String,
        var isTogglevisible: Boolean,
        var isToggleState: Boolean,
        var tPosition: Int,
        var description: String
) : Parcelable

/**
 * Model to create data for display screen
 */
data class DisplayModel(
        var primaryData: String,
        var secondaryData: String,
        var isTogglevisible: Boolean,
        var isToggleState: Boolean,
        var reference: Int
)

/**
 * Model to create data for Climate
 */
@Parcelize
data class ClimateModeModel(
        var primaryData: String,
        var secondaryData: String,
        var isTogglevisible: Boolean,
        var isToggleState: Boolean,
        val reference: Int,
        val description: String


) : Parcelable


/**
 * Model to create data for Apps
 */
@Parcelize
data class AppsModeModel(
        var primaryData: String,
        var isToggleVisible: Boolean,
        var isToggleState: Boolean,
        val reference: Int,
        val description: String

) : Parcelable

/* Model to create data for apps*/

data class CollisionModeModel(
        var primaryData: String,
        var isToggleVisible: Boolean,
        var isToggleState: Boolean,
        val reference: Int,
        val description: String,
        var isArrowVisible: Boolean
)


/**
 * Model to create data for Audio
 */
@Parcelize
data class AudioModeModel(
        var primaryData: String,
        var secondaryData: String,
        var isToggleVisible: Boolean,
        var isToggleState: Boolean,
        var secondaryState: Boolean

) : Parcelable


/**
 * Model to create data for Drive Mode
 */

data class DriveModeModel(
        var primaryData: String,
        var secondaryData: String,
        var reference: Int
)

/**
 * Model to create data for V Mode and MyMode
 */


data class MyModeModel(
        var primaryData: String,
        var secondaryData: String,
        var ref: Int
)

data class VModeModel(
        var primaryData: String,
        var secondaryData: String,
        var ref: Int
)

data class ComfortAndConvenienceModel(
        var primaryData: String,
        var ref: Int
)

data class DriveModeCustomizationModel(
        var primaryData: String,
        var ref: Int,
        var isToggleVisible: Boolean,
        var isToggleState: Boolean
)

data class RideHeightModel(
        var primaryData: String,
        var isToggleVisible: Boolean,
        var isToggleState: Boolean,
        val reference: Int
)

/**
 * Model to create data for configuration screen
 */
data class SettingsConfigurationModel
(
        var configName: String,
        var status: Boolean
)

/**
 * Model to create data for Timezone
 */
@Parcelize
data class GmTimeZone(
        var id: String, var name: String, var displayOffset: String, var offsetMinutes: Int) : Parcelable


data class GMSoundMenu(
        var name: String, var isTogglevisible: Boolean,
        var isToggleState: Boolean, var tPosition: Int, var description: String)

data class SideBarModel(var imageSelectorId: Int, var isSelected: Boolean)


data class AppInfo(var appPackageName: String, var appSize: String, var appName: String, var pid: Int)


@Parcelize
data class SportModeModel(
        var primaryData: String,
        var isTogglevisible: Boolean,
        var isToggleState: Boolean,
        val reference: Int,
        val description: String) : Parcelable


data class AboutListItem(var mMainText: String, var mSubText: String, var mLatestVersion: String,
                         var mLatestUpdateDate: String, var mHistoryUpdateVersion: String, var mHistoryUpdateDate: String)
