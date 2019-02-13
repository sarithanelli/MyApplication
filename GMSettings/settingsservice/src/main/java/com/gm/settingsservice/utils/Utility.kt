package com.gm.settingsservice.utils


import android.content.Context
import android.content.Intent
import android.content.pm.*
import android.content.res.Resources
import android.os.Handler
import android.preference.PreferenceManager
import android.provider.Settings
import android.text.format.Formatter
import android.view.KeyEvent
import android.view.View
import android.widget.ToggleButton
import com.gm.settingsservice.R
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.apiintegration.SettingsService.Companion.appContext
import com.gm.settingsservice.apiintegration.SettingsService.Companion.mMaxDate
import com.gm.settingsservice.apiintegration.SettingsService.Companion.mMinDate
import com.gm.settingsservice.apiintegration.SettingsService.Companion.mTempDate
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.Constants.DD_MM_YY
import com.gm.settingsservice.utils.Constants.DD_YY_MM
import com.gm.settingsservice.utils.Constants.HOURS_12
import com.gm.settingsservice.utils.Constants.HOURS_24
import com.gm.settingsservice.utils.Constants.MINUTE_LEADING_ZERO
import com.gm.settingsservice.utils.Constants.MM_DD_YY
import com.gm.settingsservice.utils.Constants.MM_YY_DD
import com.gm.settingsservice.utils.Constants.YY_DD_MM
import com.gm.settingsservice.utils.Constants.YY_MM_DD
import gm.calibrations.LANGUAGEANDREGIONALIZATIONGLOBALA_ENUM
import gm.mfc.MfcExt
import gm.mfc.MfcExt.isInMfcMode
import gm.mfc.MfcExt.isMfcKey
import gm.panel.Panel
import gm.powermode.PowerModeManager
import gm.view.GMKeyEvent
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.AM
import java.util.Calendar.PM
import javax.inject.Inject

/**
 * Reusable functionalities
 */
class Utility @Inject constructor(dataPoolDataHandler: DataPoolDataHandler){

    @Inject
    lateinit var dataPoolDataHandler: DataPoolDataHandler

    var TAG = "TimeDate"
    /**
     * set NewLocale and update the configuration
     * @param c activity context
     * @param String language
     * @return Context
     */
    /*fun setLocale(context: Context): Context {


        persistLanguage(context, getLanguage(context))

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, getLanguage(context))
        } else
            updateResourcesLegacy(context, getLanguage(context))

       // return updateResources(c, getLanguage(c))
    }*/
    /*  @TargetApi(Build.VERSION_CODES.N)
      private fun updateResources(context: Context, language: String): Context {
          val currentString = language
          var locale: Locale? = null

          if (currentString.contains("_")) {
              val language = language.split("_".toRegex())

              locale = Locale(language[0] + "", language[1] + "")

          } else {
              locale = Locale(language)

          }
          Locale.setDefault(locale)

          val configuration = context.resources.configuration
          configuration.setLocale(locale)
          SettingsService.appContext.resources.updateConfiguration(configuration, SettingsService.appContext.resources.displayMetrics)
          return context.createConfigurationContext(configuration)

      }*/

    fun setMode(c: Context, mode: eSettingsdisplayMode) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString(getStringById(R.string.shared_pref_mode), mode.toString()).apply()
    }

    fun getMode(c: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        return prefs.getString(c.getString(R.string.shared_pref_mode), "")
    }

    fun getStringById(id: Int): String {
        return appContext.resources.getString(id)
    }

    fun displayModeChange(value: Boolean) {
        try {
            PowerModeManager.getInstance().requestDisplayMode(value)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun isSupportedByVRTTS(regionNum: Int, locale: Locale): Boolean {
        var ret: Boolean = false

        if (regionNum != -1 && locale != null) {
            // For North America region
            if (regionNum == LANGUAGEANDREGIONALIZATIONGLOBALA_ENUM.REGIONS.GMNA.ordinal) run {
                if (locale == Locale("en") || locale == Locale("en", "US") ||
                        locale == Locale("fr", "CA") ||
                        locale == Locale("es", "MX")) {

                    ret = true
                }
            } // For Europe region
            else if (regionNum == LANGUAGEANDREGIONALIZATIONGLOBALA_ENUM.REGIONS.EUROPE.ordinal) run {
                if (locale == Locale("en", "GB") ||
                        locale == Locale("da", "DK") ||
                        locale == Locale("nl", "NL") ||
                        locale == Locale("fr", "FR") ||
                        locale == Locale("de", "DE") ||
                        locale == Locale("it", "IT") ||
                        locale == Locale("pl", "PL") ||
                        locale == Locale("pt", "PT") ||
                        locale == Locale("ru", "RU") ||
                        locale == Locale("es", "ES") ||
                        locale == Locale("tr", "TR") ||
                        locale == Locale("cs", "CZ") ||
                        locale == Locale("fi", "FI") ||
                        locale == Locale("el", "GR") ||
                        locale == Locale("hu", "HU") ||
                        locale == Locale("nn", "NO") ||
                        locale == Locale("ro", "RO") ||
                        locale == Locale("sk", "SK") ||
                        locale == Locale("sv", "SE")) {
                    ret = true
                }
            } // For rest of the world
            else run {
                if (locale == Locale("ar", "WW") ||
                        locale == Locale("en", "AU") ||
                        locale == Locale("en", "GB") ||
                        locale == Locale("en", "US") ||
                        locale == Locale("en", "ZA") ||
                        locale == Locale("fr", "CA") ||
                        locale == Locale("ja", "JP") ||
                        locale == Locale("ko", "KR") ||
                        locale == Locale("zh", "CN") ||
                        locale == Locale("pt", "BR") ||
                        locale == Locale("es", "MX") ||
                        locale == Locale("tr", "TR")) {
                    ret = true
                }
            }
        }
        return ret
    }

    fun getPanel() {
        val panel: Panel

        panel = Panel.getPanel()
        if (panel != null) {
            panel.stop5PointCalibration()
            Log.i("successcal", panel.stop5PointCalibration().toString())
        }
    }


    /**
     * Setting locale to configuration for below VERSION_CODES.N
     * @param context activity context
     * @param language language
     */
    /*  fun updateResourcesLegacy(context: Context, language: String): Context {

          val currentString = language
          var locale: Locale? = null
          if (currentString.contains("_")) {
              val language = language.split("_".toRegex())

              locale = Locale(language[0] + "", language[1] + "")

          } else {
              locale = Locale(currentString)

          }
          Locale.setDefault(locale)

          val resources = context.resources

          val configuration = resources.configuration
          configuration.locale = locale
          SettingsService.appContext.resources.updateConfiguration(configuration, SettingsService.appContext.resources.displayMetrics)

          return context
      }*/

    /**
     * get Language and update the configuration
     * @param c activity context
     * @return String language
     */


    /**
     * Update language to configuration
     * @param context called activity current context
     * @param language to be update language
     * @return Context context of current activity
     */
    /* private fun updateResources(context: Context, language: String): Context {

         val locale = Locale(language)
         Locale.setDefault(locale)
         val res = context.resources
         val config = Configuration(res.configuration)
         config.setLocale(locale)
         return context.createConfigurationContext(config)
     }
 */
    /**
     * To Increase the value of hour when hourUp button clicked
     * @return hour value
     */
    fun incrementHour(): TimeInfo_t {
        var hour: Int = dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!
        hour++
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            if (hour > Constants.MAX_HOUR_VALUE_IN_12_HOUR_FORMAT) {
                hour = Constants.MIN_HOUR_VALUE_IN_12_HOUR_FORMAT
            }
        } else if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_24HRMODE) {
            if (hour > Constants.MAX_HOUR_VALUE_IN_24_HOUR_FORMAT) {
                hour = Constants.MIN_HOUR_VALUE_IN_24_HOUR_FORMAT
            }
        }
        return setTime(hour, dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!, dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
    }

    /**
     * To Decrease the value of hour when hourDown button clicked
     * @return hour value
     */
    fun decrementHour(): TimeInfo_t {
        var hour: Int = dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!
        hour--
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            if (hour < Constants.MIN_HOUR_VALUE_IN_12_HOUR_FORMAT)
                hour = Constants.MAX_HOUR_VALUE_IN_12_HOUR_FORMAT
        } else {
            if (hour < Constants.MIN_HOUR_VALUE_IN_24_HOUR_FORMAT)
                hour = Constants.MAX_HOUR_VALUE_IN_24_HOUR_FORMAT
        }
        return setTime(hour, dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!, dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
    }

    /**
     * To Increase the value of minute when minuteUp button clicked
     * @return minute value
     */
    fun incrementMinute(): TimeInfo_t {
        var minute: Int = dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!
        minute++
        if (minute > Constants.MAX_MINUTE_VALUE)
            minute = Constants.MIN_MINUTE_VALUE

        return setTime(dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!, minute, dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
    }

    /**
     * To Decrease the value of minute when minuteDown button clicked
     * @return minute value
     */
    fun decrementMinute(): TimeInfo_t {
        var minute: Int = dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!
        minute--
        if (minute < Constants.MIN_MINUTE_VALUE)
            minute = Constants.MAX_MINUTE_VALUE

        return setTime(dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!, minute, dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
    }

    /* added*/
    fun setTimeMeridien(value: Int): TimeInfo_t {
        if (value == 1) {
            dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_POST)
        } else {
            dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.set(eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
        }
        return setTime(dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!,
                dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!,
                dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
    }

    /**
     * To get Current system time
     * @return TimeInfo_t
     */
    fun getCurrentTime(): TimeInfo_t {
        val mHour: Int
        val mMinute: Int
        var eSettingsTimeMeridiem: eSettingsTimeMeridiem = eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_POST

        val calendarObj = Calendar.getInstance()
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            mHour = calendarObj.get(Calendar.HOUR_OF_DAY)
        } else {
            mHour = calendarObj.get(Calendar.HOUR)
            if (calendarObj.get(Calendar.AM_PM) == Calendar.AM)
                eSettingsTimeMeridiem = com.gm.settingsservice.models.eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE
            else
                eSettingsTimeMeridiem = com.gm.settingsservice.models.eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_POST

        }
        mMinute = calendarObj.get(Calendar.MINUTE)
        return TimeInfo_t(mHour, mMinute, eSettingsTimeMeridiem)
    }

    /**
     * To get current date
     * @return DateInfo_t
     */
    fun getCurrentDate(): DateInfo_t {
        var CalendarYear: Int = 0
        var CalendarMonth: Int = 0
        var CalendarDay: Int = 0
        try {
            mTempDate = Calendar.getInstance()
            CalendarYear = mTempDate!!.get(Calendar.YEAR)
            CalendarMonth = mTempDate!!.get(Calendar.MONTH)
            CalendarDay = mTempDate!!.get(Calendar.DATE)

            Log.e("naresh", "" + CalendarYear + "" + CalendarMonth + "" + CalendarDay)

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return DateInfo_t(
                CalendarDay,
                CalendarMonth,
                CalendarYear
        )

    }
    /* added*/
    /**Set calender date
     * @param value
     * @param mValue
     * @return DateInfo_t
     */
    fun setCalenderDate(value: Int, mValue: Int): DateInfo_t {
        mTempDate = Calendar.getInstance()
        mTempDate!!.set(value, mValue)
        return DateInfo_t(mTempDate!!.get(Calendar.YEAR), mTempDate!!.get(Calendar.MONTH),
                mTempDate!!.get(Calendar.DAY_OF_MONTH))
    }
    /* added*/
    /**Set calender time
     * @param value
     * @param mValue
     * @return DateInfo_t
     */
    fun setCalenderTime(value: Int, mValue: Int): TimeInfo_t {
        mTempDate = Calendar.getInstance()
        mTempDate!!.set(value, mValue)
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            return TimeInfo_t(mTempDate!!.get(Calendar.HOUR_OF_DAY), mTempDate!!.get(Calendar.MINUTE),
                    dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
        } else {
            return TimeInfo_t(mTempDate!!.get(Calendar.HOUR), mTempDate!!.get(Calendar.MINUTE),
                    dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get()!!)
        }
    }

    /**
     * Method to set time to calender
     * @param hourOfDay
     * @param minute
     * @param esettingsTimeMeridiem
     * @return TimeInfo_t object
     */
    fun setTime(hourOfDay: Int, minute: Int, esettingsTimeMeridiem: eSettingsTimeMeridiem): TimeInfo_t {
        val c = Calendar.getInstance()
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            c.set(Calendar.HOUR_OF_DAY, hourOfDay)
        } else {
            c.set(Calendar.HOUR, hourOfDay)
            if (dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get() == eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
                c.set(Calendar.AM_PM, AM)
            else
                c.set(Calendar.AM_PM, PM)
        }
        c.set(Calendar.MINUTE, minute)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        return TimeInfo_t(hourOfDay, minute, esettingsTimeMeridiem)
    }

    /**
     * To set changed date to system
     * @param year
     * @param month
     * @param day
     * @return [DateInfo_t]
     */
    private fun setDate(year: Int, month: Int, day: Int): DateInfo_t {
        if (mTempDate!!.after(mMaxDate)) {
            mTempDate!!.set(Calendar.YEAR, mMaxDate!!.get(Calendar.YEAR))
            mTempDate!!.set(Calendar.DATE, mMaxDate!!.get(Calendar.DATE))
            mTempDate!!.set(Calendar.MONTH, mMaxDate!!.get(Calendar.MONTH))

        } else if (mTempDate!!.before(mMinDate)) {
            mTempDate!!.set(Calendar.YEAR, mMinDate!!.get(Calendar.YEAR))
            mTempDate!!.set(Calendar.DATE, mMinDate!!.get(Calendar.DATE))
            mTempDate!!.set(Calendar.MONTH, mMinDate!!.get(Calendar.MONTH))
        } else {
            mTempDate = Calendar.getInstance()
            mTempDate!!.set(Calendar.YEAR, year)
            mTempDate!!.set(Calendar.MONTH, month)
            mTempDate!!.set(Calendar.DATE, day)
        }
        return DateInfo_t(
                day,
                month,
                year
        )
    }

    /**
     * converting time into millis
     * @return time in millis
     */
    fun convertDateInMillis(): Long {
        return mTempDate!!.timeInMillis
    }

    /**
     * converting time into millis
     * @param timeInfo_t
     * @return Long time in millis
     *
     */
    fun convertTimeInMillis(timeInfo_t: TimeInfo_t): Long {
        val c = Calendar.getInstance()
        if (dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() != eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {
            c.set(Calendar.HOUR_OF_DAY, timeInfo_t.HourOfDay)
        } else {
            c.set(Calendar.HOUR, timeInfo_t.HourOfDay)
            if (dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get() == eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE)
                c.set(Calendar.AM_PM, AM)
            else
                c.set(Calendar.AM_PM, PM)
        }
        c.set(Calendar.MINUTE, timeInfo_t.MinuteOfHour)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        val timeInMillis = c.timeInMillis
        return timeInMillis
    }

    /**
     * Minimum and maximum limits for date
     */
    fun setMinMaxLimits() {
        mMinDate = Calendar.getInstance()
        mMinDate!!.clear()
        mMinDate!!.set(Constants.DEFAULT_START_YEAR, Calendar.DECEMBER, Constants.DEFAULT_START_END_DATE)

        mMaxDate = Calendar.getInstance()
        mMaxDate!!.clear()
        mMaxDate!!.set(Constants.DEFAULT_END_YEAR, Calendar.DECEMBER, Constants.DEFAULT_START_END_DATE)
    }

    /**
     * To increment calender (date by 1/ year by 1/month by 1)
     * @param value
     * @return DateInfo_t
     */
    fun incrementDateCalender(value: Int): DateInfo_t {
        mTempDate!!.add(value, 1)
        setDate(mTempDate!!.get(Calendar.YEAR), mTempDate!!.get(Calendar.MONTH),
                mTempDate!!.get(Calendar.DATE))
        return DateInfo_t(mTempDate!!.get(Calendar.DATE), mTempDate!!.get(Calendar.MONTH),
                mTempDate!!.get(Calendar.YEAR))

    }

    /**
     * To decrement calender (date by 1/ year by 1/month by 1)
     * @param value
     * @return [DateInfo_t]
     */
    fun decrementDateCalender(value: Int): DateInfo_t {
        mTempDate!!.add(value, -1)
        setDate(mTempDate!!.get(Calendar.YEAR), mTempDate!!.get(Calendar.MONTH),
                mTempDate!!.get(Calendar.DATE))
        return DateInfo_t(mTempDate!!.get(Calendar.DATE), mTempDate!!.get(Calendar.MONTH),
                mTempDate!!.get(Calendar.YEAR))
    }


    /**
     * this method is to returns current locale date format
     *
     * @return : Date format of the current locale
     */

    fun getCurrentDateFormat(): Int {

        val dateFormatter: DateFormat
        val mCurrentLocale = getLocale()

        if (mCurrentLocale.language == "es" && mCurrentLocale.country == "MX") {
            return MM_DD_YY
        }

        dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, mCurrentLocale)

        val sdf = dateFormatter as SimpleDateFormat
        val pattern = sdf.toPattern()

        val month = pattern.indexOf('M')
        val day = pattern.indexOf('d')
        val year = pattern.indexOf('y')

        if (month >= 0 && day >= 0 && year >= 0) {

            if (year < month && year < day) {
                if (month < day) {
                    Log.d(TAG, "yyyy, MM, dd")
                    return YY_MM_DD
                } else {
                    Log.d(TAG, "yyyy, dd, MM")
                    return YY_DD_MM
                }
            } else if (month < day) {
                if (day < year) {
                    Log.d(TAG, "MM, dd, yyyy")
                    return MM_DD_YY
                } else { // unlikely
                    Log.d(TAG, "MM,  yyyy, dd")
                    return MM_YY_DD
                }
            } else { // day < month
                if (month < year) {
                    Log.d(TAG, "dd, MM,  yyyy")
                    return DD_MM_YY
                } else { // unlikely
                    Log.d(TAG, "dd, yyyy,MM")
                    return DD_YY_MM
                }
            }

        }
        return 0
    }


    /**
     * To get current locale of device
     * @return locale
     */
    @SuppressWarnings("deprecation")
    fun getLocale(): Locale {
        return SettingsService.appContext.resources
                .configuration.locale
    }

    /**
     * Adding Zero to minute to display with leading zero for below MINUTE_LIMIT_LEADING_ZERO
     * @param minute with leading zero/ minute
     */
    fun getMinuteWithLeadingZero(minute: Int): String {
        if (minute < Constants.MINUTE_LIMIT_LEADING_ZERO)
            return MINUTE_LEADING_ZERO.toString() + minute.toString()
        else
            return minute.toString()
    }

    /**
     * Setting 12-hour/24-format
     * @param is24Hour 12-hour/24-hour
     */
    fun set24Hour(is24Hour: Boolean) {
        Settings.System.putString(SettingsService.appContext.contentResolver,
                Settings.System.TIME_12_24,
                if (is24Hour) HOURS_24 else HOURS_12)
    }

    /**
     * start touch calibration on view
     * @param Int when onTouch event occurred on calibration toggle buttons, it return position
     * @param ToggleButton
     */
    fun startTouchScreenCalibration(position: Int, view: ToggleButton) {
        val handler: Handler? = Handler()
        handler!!.postDelayed({
            kotlin.run {
                dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_RIGHT.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNER.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNERCORNER.set(false)
                dataPoolDataHandler.CALIBRATE_TOGGLE_CENTER.set(false)

                when (position) {
                    Constants.CALIBRATE_TOP_LEFT ->
                        view.visibility = View.VISIBLE
                    Constants.CALIBRATE_TOP_RIFHT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_RIGHT.set(true)
                    }
                    Constants.CALIBRATE_BOTTOM_RIGHT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNER.set(true)

                    }
                    Constants.CALIBRATE_BOTTOM_LEFT -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)
                        dataPoolDataHandler.CALIBRATE_TOGGLE_BOTTOM_RIGHTCORNERCORNER.set(true)
                    }
                    Constants.CENTER -> {
                        dataPoolDataHandler.CALIBRATE_TOGGLE_TOP_LEFT.set(false)

                        dataPoolDataHandler.CALIBRATE_TOGGLE_CENTER.set(true)

                    }

                }
            }
        }, 1000)
    }

    //key events for trigger events used in display off
    val KEYCODE_GM_VOLUME_SLIDER = gm.view.GMKeyEvent.KEYCODE_GM_VOLUME_SLIDER
    val KEYCODE_MFC_AUDIO = GMKeyEvent.KEYCODE_MFC_AUDIO
    val KEYCODE_MFC_NAVIGATION = GMKeyEvent.KEYCODE_MFC_NAVIGATION
    val KEYCODE_MFC_PHONE = GMKeyEvent.KEYCODE_MFC_PHONE
    val KEYCODE_GM_TUNE_DOWN = GMKeyEvent.KEYCODE_GM_TUNE_DOWN
    val KEYCODE_GM_TUNE_UP = GMKeyEvent.KEYCODE_GM_TUNE_UP

    val NAVIGATION_PKG_NAME = "com.telenav.app.denali.na"
    fun getAppLabel(context: Context, pm: PackageManager, pkgInfo: PackageInfo?): String? {
        // For Navigation App, use String resource "Navigation" instead of App Label "Nav"
        if (pkgInfo != null && NAVIGATION_PKG_NAME == pkgInfo.packageName) {
            return "Navigation"
        }
        var appLabel: String? = null
        val calibrationSettings: CalibrationSettings = CalibrationSettings.getInstance(context)
        appLabel = loadAppLabelFromMetaData(pm, pkgInfo, CalibrationSettings.getAppLabelCal())
        if (appLabel == null) {
            appLabel = loadLabelFromPackage(pm, pkgInfo)
        }
        return appLabel
    }

    /**
     * Returns String for associated with metadataKey
     *
     */
    private fun loadAppLabelFromMetaData(pkgMgr: PackageManager?,
                                         rInfo: ResolveInfo?, metadataKey: String?): String? {
        /*if (LogFile.DEBUG) {
            android.util.Log.d(TAG, "loadAppLabelFromMetaData : metaKey : " + metadataKey!!)
        }*/
        if (rInfo == null || pkgMgr == null || metadataKey == null) {
            return null
        }

        var label: String? = null
        val cmpInfo = getComponentInfo(rInfo)

        if (cmpInfo != null) {
            try {
                val ai = pkgMgr.getApplicationInfo(cmpInfo.packageName,
                        PackageManager.GET_META_DATA)
                val bundle = ai.metaData
                if (bundle != null) {
                    val resId = bundle.getInt(metadataKey)
                    if (resId > 0) {
                        val resources = pkgMgr
                                .getResourcesForApplication(cmpInfo.packageName)
                        if (resources != null) {
                            label = resources.getString(resId)
                        }
                    }
                }
            } catch (e: Exception) {
                android.util.Log.e(TAG, "Exception in getting application info$e")
            }

        }
        return label
    }

    private fun getComponentInfo(rInfo: ResolveInfo): ComponentInfo? {
        if (rInfo.activityInfo != null) {
            return rInfo.activityInfo
        }
        if (rInfo.serviceInfo != null) {
            return rInfo.serviceInfo
        }
        return if (rInfo.providerInfo != null) {
            rInfo.providerInfo
        } else null
    }


    /**
     * Returns String for associated with metadataKey
     *
     */
    private fun loadAppLabelFromMetaData(pkgMgr: PackageManager?,
                                         pkgInfo: PackageInfo?, metadataKey: String?): String? {
        /*if (LogFile.DEBUG) {
            android.util.Log.d(TAG, "loadAppLabelFromMetaData : metaKey : " + metadataKey!!)
        }*/
        if (pkgInfo == null || pkgMgr == null || metadataKey == null) {
            return null
        }

        var label: String? = null
        val ai = pkgInfo.applicationInfo
        if (ai != null) {
            val bundle = ai.metaData
            if (bundle != null) {
                val resId = bundle.getInt(metadataKey)
                if (resId > 0) {
                    var resources: Resources? = null
                    try {
                        resources = pkgMgr
                                .getResourcesForApplication(pkgInfo.packageName)
                    } catch (e: PackageManager.NameNotFoundException) {
                        e.printStackTrace()
                    }

                    if (resources != null) {
                        label = resources.getString(resId)
                        /* if (LogFile.DEBUG) {
                             android.util.Log.d(TAG, "loadAppLabelFromMetaData : label : " + label!!)
                         }*/
                    }
                }
            }
        }
        return label
    }


    fun getAppLabel(context: Context, pm: PackageManager, ri: ResolveInfo?): String? {
        // For Navigation App, use String resource "Navigation" instead of App Label "Nav"
        if (ri != null && ri.activityInfo != null && NAVIGATION_PKG_NAME == ri.activityInfo.packageName) {
            return "Navigation"
        }
        val calibrationSettings: CalibrationSettings = CalibrationSettings.getInstance(context)
        var appLabel: String? = null
        appLabel = loadAppLabelFromMetaData(pm, ri,
                CalibrationSettings.getAppLabelCal())
        if (appLabel == null) {
            appLabel = loadLabelFromPackage(pm, ri)
        }
        return appLabel
    }


    /**
     * Returns String for associated with PackageManager
     *
     */
    private fun loadLabelFromPackage(pm: PackageManager?, pkgInfo: PackageInfo?): String? {
        var label: String? = null
        if (pkgInfo == null || pm == null) {
            return null
        }

        label = pm.getApplicationLabel(pkgInfo.applicationInfo).toString()
        return label
    }

    /**
     * Returns String for associated with PackageManager
     *
     */
    private fun loadLabelFromPackage(pm: PackageManager?, ri: ResolveInfo?): String? {
        var label: String? = null
        if (ri == null || pm == null) {
            return null
        }

        label = ri.activityInfo.loadLabel(pm).toString()
        return label
    }

    fun getInstalledComponentList(): List<String> {
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val ril = SettingsService.appContext.packageManager.queryIntentActivities(mainIntent, 0)
        val componentList = ArrayList<String>()

        var i = 0
        for (ri in ril) {
            if ((ri.activityInfo.applicationInfo.flags and ApplicationInfo.FLAG_STOPPED) != 0) {
            } else {
                val componentInfo = getComponentInfo(ri)
                //   Log.e("MyLoglttest","appName:"+ri.activityInfo.applicationInfo.processName+",packagename:"+ri.activityInfo.applicationInfo.packageName+": running")
                val name = ri.activityInfo.packageName
                if (!isDevelopmentApp(ri)) {
                    componentList.add(name)
                    i++
                }

            }

        }
        return componentList
    }


    private fun isSYSTEM(pkgInfo: ApplicationInfo): Boolean {

        return pkgInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }

    private fun isSTOPPED(pkgInfo: ApplicationInfo): Boolean {

        return pkgInfo.flags and ApplicationInfo.FLAG_STOPPED != 0
    }

    private fun isDevelopmentApp(info: ResolveInfo): Boolean {
        val componentInfo = getComponentInfo(info)
        return mDevAppFilter.containsKey(getShortComponentName(componentInfo))
    }


    fun getShortComponentName(ci: ComponentInfo?): String? {
        var componentName: String? = null
        if (ci != null) {
            val sb = StringBuilder(ci.packageName.length + ci.name.length)
            ComponentName.appendShortString(sb, ci.packageName, ci.name)
            componentName = sb.toString()

            Log.e("babuprashant2", "mComponentName$componentName" + ", package4:" + ci.applicationInfo.packageName)
        }
        return componentName
    }

    val VEHICLEP13N_APP_CMP_NAME = "com.gm.vehiclep13nbundletest/.VehicleP13NBundleTestMainActivity"
    val UPDATESERVICETEST_APP_CMP_NAME = "gm.update.test/.UpdateServiceTestMainActivity"
    val FRAMEWORK_TEST_APP_CMP_NAME = "com.harman.appframework.test/.MainActivity"
    val TBT_APP_CMP_NAME = "com.gm.tbt/.NoRouteActivity"
    val SEAT_APPLICATION_CMP_NAME = "com.gm.seatstatuspane/.MainActivity"


    val mDevAppFilter: HashMap<String, Boolean> = object : HashMap<String, Boolean>() {
        init {
            put("com.gm.texttospeech/.TextToSpeechActivity", true)
            put("com.gm.uisstestservice/.GMEventSimuApp", true)
            put("com.android.providers.downloads.ui/.DownloadList", true)
            put("gm.media.mediaPlayerTester/.UI.MainActivity", true)
            put("com.android.music/.MusicBrowserActivity", true)
            put("com.onstar.navmgr/.activities.MainActivity", true)
            put("com.harman.nav.navtest/.MainActivity", true)
            put("com.android.contacts/.activities.PeopleActivity", true)
            put("com.gm.rrsdk.test/.MainActivity", true)
            put("com.harman.softwareupdate/.UserConfirmActivity", true)
            put("com.android.soundrecorder/.SoundRecorder", true)
            put("com.gm.enggmodemenu/.EnggModeActivity", true)
            // This points to stack android app, but this app shall be removed
            // in future.
            put("com.android.settings/.Settings", true)
            put("com.gm.tbt/.NavigationActivity", true)
            put("com.gm.vr/.PTTActivity", true)
            put("com.onstar.gtbt.wackamole/.activities.Planning", true)
            put("com.example.proximityapplication/.MainActivity", true)
            put("com.example.maxstvol/.MainActivity", true)
            put("com.gm.vehiclemanagertest/.VehicleManagerTestMainActivity", true)
            put("com.gm.diagnosticsmanagertest/.MainActivity", true)
            put("com.gm.caltest/.CalTestMainActivity", true)
            put("com.gm.obdmanagertest/.OBDManagerTestMainActivity", true)
            put("com.android.browser/.BrowserActivity", true)
            put("com.gm.gmlogmanagertester/.MainActivityList", true)
            put("com.onstar.vttproxyserver/.MainActivity", true)
            put("com.gm.navmgr/.activities.MainActivity", true)
            put("com.android.mms/.ui.ConversationList", true)
            put("com.gm.media.mediatimer/.MediaTimer", true)
            put("com.gm.media.proxytester/.ProxyTesterMain", true)
            put(VEHICLEP13N_APP_CMP_NAME, true)
            put(UPDATESERVICETEST_APP_CMP_NAME, true)
            put(FRAMEWORK_TEST_APP_CMP_NAME, true)
            put(TBT_APP_CMP_NAME, true)
            put(SEAT_APPLICATION_CMP_NAME, true)
            put("gm.com.gmstopharmancamera/.GMStopHarmanCamera", true)

            put("com.onstar.vttproxyserver/.ui.MainActivity", true)
            put("com.harman.www.emc_usb_mode_cahnger/.MainActivity", true)
            put("com.gm.lvm/.NavLaunchFromHomeScreen", true)
            put("com.gm.lvm/.DmbLaunchFromHomeScreen", true)
            put("com.gm.lvm/.PdrLaunchFromHomeScreen", true)
            put("com.gm.carlife/.ui.CarLifeMainActivity", true)
            put("com.mea.rsi.app/.main.MainActivity", true)
            put("com.gm.mymode/.MyModeActivity", true)
            put("com.gm.otadebug/.OTADebugActivity", true)
            //  put("com.gm.onstar/.MainActivity", true)


        }
    }


    // invalid size value used initially and also when size retrieval through
    // PackageManager
    // fails for whatever reason
    private val SIZE_INVALID = -1

    fun getSizeStr(size: Long): String {
        return if (size == SIZE_INVALID.toLong()) {
            //mInvalidSizeStr.toString()
            "Unable to compute package size."
        } else {
            Formatter.formatFileSize(SettingsService.appContext, size)
        }
    }


    fun getSystemState(): Boolean {
        var state = PowerModeManager.STATE_SLEEP
        var sysState = false
        try {
            state = PowerModeManager.getInstance().systemState
            sysState = state == PowerModeManager.STATE_LOCALINFOTAINMENT
        } catch (e: Exception) {
            android.util.Log.w("", "PowerModer Service not found")
        }

        return sysState
    }


}


