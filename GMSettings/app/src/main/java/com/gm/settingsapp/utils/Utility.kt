package com.gm.settingsapp.utils


import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Point
import android.os.*
import android.preference.PreferenceManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.PixelCopy
import android.view.Window
import android.view.WindowManager
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.R
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.Constants
import java.io.*
import java.util.*
import javax.inject.Inject


/**
 * Reusable methods for different functionality
 */
class Utility @Inject constructor(val context: Context){

    @Inject
    lateinit var dataPoolDataHandler: DataPoolDataHandler

    @Inject
    lateinit var eventHandler: EventHandler

    /**
     * Get String from Id
     * @param id String id
     * @return String
     */
    fun getStringById(id: Int): String {
        return appContext.resources.getString(id)
    }

    fun updateSkewState(c: Context, skewState: Boolean) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putBoolean(getStringById(R.string.shared_pref_skew_state_key), skewState).apply()
    }

    fun getSkewState(c: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        return prefs.getBoolean(c.getString(R.string.shared_pref_skew_state_key), false)
    }

    fun getLanguageConfig(c: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        return prefs.getString(c.getString(R.string.shared_pref_language_key_config), c.getString(R.string.language_type))
    }

    fun getJsonString(stream: InputStream): String {

        val strBuilder = StringBuilder()
        var jsonString: String? = null
        val bfReader = BufferedReader(InputStreamReader(stream, "UTF-8"))
        while ({ jsonString = bfReader.readLine(); jsonString }() != null) {
            strBuilder.append(jsonString)
        }
        return strBuilder.toString()
    }

    fun persistLanguageSkew(c: Context, eLhdRhdRtl: eLHD_RHD_RTL) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString(getStringById(R.string.shared_pref_language_key_config), getLanguageStringFrom(eLhdRhdRtl)).apply()
    }

    private fun getLanguageStringFrom(eLhdRhdRtl: eLHD_RHD_RTL): String {
        return when (eLhdRhdRtl) {
            eLHD_RHD_RTL.LHD -> "en"
            eLHD_RHD_RTL.RHD -> "uk"
            eLHD_RHD_RTL.RTL -> "ar"
        }
    }

    /**
     * set language title and language text
     */
    fun EngineSoundMode() {
        /*DataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_driving_mode_big))

        if (SettingsService.isSDKAvailable()) {
            DataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(0, DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_engine_sound), DataPoolDataHandler.ENGINESOUND_MAP_STATE.get(Signals.PerformanceModeSoundSignal().signalValue).toString()))
        } else {
            if (DataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.get() == null) {
                DataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(0, DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_engine_sound), ESettingsChangePerfModeSound.SETTINGS_DRIVERMODE_ENGINESOUND_AUTO.toString()))
            } else {
                DataPoolDataHandler.SETTINGS_DRIVING_MODE_MENU.set(0, DriveModeModel(GMSettingsApp.appContext.resources.getString(com.gm.settingsapp.R.string.settings_engine_sound), DataPoolDataHandler.SETTINGS_ENGINESOUNDTYPE.get().toString()))
            }
        }*/
    }

    /**
     * get language type,if language type not exist then set english as default language
     */
    fun getLanguageType() {
        if (SettingsService.isSDKAvailable()) {

        } else {
            val language = GMSettingsApp.sharedPreferences.getString(GMSettingsApp.appContext.getString(com.gm.settingsservice.R.string.shared_pref_lang_state), dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.get().toString())
            if (language.equals("null")) {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(ESettingsLanguageType.SETTINGS_LANGUAGE_SELECTION_English.toString())
            } else {
                dataPoolDataHandler.SETTINGS_LANGUAGE_TYPE.set(language)
            }
        }
    }

    /**
     * set NewLocale
     * @param c activity context
     * @param String language
     * @return Context
     */
    fun setNewLocale(c: Context, language: String): Context {
        persistLanguage(c, language)
        return updateResources(c, language)
    }

    /**
     * set Language to shared preferences
     * @param c activity context
     * @return String language
     */
    private fun persistLanguage(c: Context, language: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString(c.resources.getString(R.string.shared_pref_language_key), language).apply()
    }

    /**
     * set NewLocale abd update the configuration
     * @param c activity context
     * @param String language
     * @return Context
     */
    fun setLocale(context: Context): Context {

        persistLanguage(context, getLanguage(context))




        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, getLanguage(context))

        } else
            updateResourcesLegacy(context, getLanguage(context))
    }

    private fun persistThemeType(c: Context, themeType: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString("theme_type_key", themeType).apply()
    }

    fun setNewLocaleThemeType(c: Context, themeType: String): Context {
        persistThemeType(c, themeType)
        return updateResourcesTheme(c, themeType)
    }

    private fun updateResourcesTheme(context: Context, theme: String): Context {
        val locale = Locale(theme)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        return context.createConfigurationContext(config)
    }

    /**
     * Get Language from shared preferences
     * @param c activity context
     * @return String language
     */
    fun getLanguage(context: Context): String {
        val lang: String
        if (SettingsService.isSDKAvailable()) {
            val locale = context.getResources().getConfiguration().locale
            lang = locale.toString()
        } else {
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            lang = prefs.getString(context.getString(R.string.shared_pref_language_key), context.getString(R.string.language_type))
        }
        return lang
    }
    /*  fun getSystemLanguage(context: Context): String {
           val prefs = PreferenceManager.getDefaultSharedPreferences(context)
           return prefs.getString(context.getString(R.string.shared_pref_language_key), context.getString(R.string.language_type))
      }*/
    /**
     * Setting locale to configuration
     * @param context activity context
     * @param language language
     */
    @TargetApi(Build.VERSION_CODES.N)
    fun updateResources(context: Context, language: String): Context {
        val currentLanguage = language
        var locale: Locale? = null

        if (currentLanguage.contains("_")) {
            val language = language.split("_".toRegex())
            locale = Locale(language[0] + "", language[1] + "")
        } else {
            locale = Locale(language)
        }
        Locale.setDefault(locale)

        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
        return context.createConfigurationContext(configuration)

    }

    /**
     * To get current locale of device
     * @return locale
     */
    @SuppressWarnings("deprecation")
    fun getLocale(): Locale {
        return GMSettingsApp.appContext.getResources()
                .configuration.locale
    }

    /**
     * Setting locale to configuration for below VERSION_CODES.N
     * @param context activity context
     * @param language language
     */
    fun updateResourcesLegacy(context: Context, language: String): Context {
        val currentLanguage = language
        var locale: Locale? = null
        if (currentLanguage.contains("_")) {
            val language = language.split("_".toRegex())
            locale = Locale(language[0] + "", language[1] + "")
        } else {
            locale = Locale(currentLanguage)
        }
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
        return context
    }

    /**
     * adding 1 to month to display month with respective month changes
     * @return month+1
     */
    fun monthPlusOne(month: Int): Int {
        return month + 1

    }

    /**
     * adding hour value with zero to display zero when hour value below 10
     * @return String passing value with zero
     */
    fun addingZeroToHour(hour: Int): String {
        if (hour >= Constants.HOUR_LIMIT_LEADING_ZERO) {
            return hour.toString()
        } else {
            if (hour == 0 && dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE)
                return Constants.TWELVE.toString()
            else
                return "0" + hour.toString()

        }
    }

    /**
     * add tab titles
     */
    fun setTabLayoutTitles(dataPoolDataHandler: DataPoolDataHandler) {
        dataPoolDataHandler.SETTINGS_MAINVIEWPAGER_TITLES.clear()
        GMSettingsApp.appContext.resources.getStringArray(com.gm.settingsapp.R.array.tablayout_titlesdata).forEach {
            dataPoolDataHandler.SETTINGS_MAINVIEWPAGER_TITLES.add(it)
        }
    }

    /**
     * countdown timer for 15 sec if user does not tap on displayed target point touch area on calibration screen
     * @return countdown timer obj
     */
    fun calibrationStartTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
        dataPoolDataHandler.CALIBRATE_TIMER = object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
            }
            override fun onFinish() {
                eventHandler.processEventByTag(com.gm.settingsapp.viewmodels.Constants.SETTINGS_CALIBRATION)
            }
        }
        return dataPoolDataHandler.CALIBRATE_TIMER as CountDownTimer
    }
    val calendar = Calendar.getInstance()

    fun updateNumber(number: Int) {
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, number)
        dataPoolDataHandler.SETTINGS_DATEINFO_MAXVALUE.set(calendar.getActualMaximum(Calendar.DATE))

    }

    fun isPackageInstalled(packageName: String?): Boolean {
        val packageManager = GMSettingsApp.appContext.packageManager
        val intent = packageManager.getLaunchIntentForPackage(packageName!!.split("\\.action".toRegex())[0])
                ?: return false
        val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return !list.isEmpty()
    }

    fun getIntegerById(id: Int): Int {
        return appContext.activityContext?.resources?.getInteger(id) ?: 0
    }

    var mTAG = "BaseAct"

    /** * Capture current display screen and save it with [layoutName] * @param layoutName Screen's xml name used for image file name while saving */
    fun captureScreen(layoutName: String) {
        Log.i(mTAG, "Screen Capture started")
        val window = GMSettingsApp.appContext.activityContext.window
        val rootView = window.decorView.rootView
        val bitmap = Bitmap.createBitmap(rootView.width, rootView.height, Bitmap.Config.ARGB_8888)
        val hThread = HandlerThread("ScreenCapture")
        hThread.start()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            PixelCopy.request(window, bitmap, (PixelCopy.OnPixelCopyFinishedListener {
                if (it == PixelCopy.SUCCESS) {
                    saveBitmap(bitmap, layoutName)
                } else {
                    Log.e(mTAG, "Screen Capture failed")
                }
                hThread.quitSafely()
            }),
                    Handler(hThread.looper))
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Log.i(mTAG, "API is < 24")
            rootView.isDrawingCacheEnabled = true
            val bitmap1 = Bitmap.createBitmap(rootView.drawingCache)
            rootView.isDrawingCacheEnabled = false
            saveBitmap(bitmap1, layoutName)
        }
    }

    /** * Save given bitmap as a jpg image file under external_director/screenShots */
    private fun saveBitmap(bitmap: Bitmap, layoutName: String) {
        val folder = File("${Environment.getExternalStorageDirectory()}/screenShots")
        if (!folder.exists()) folder.mkdir()
        val imageFile = File("${Environment.getExternalStorageDirectory()}/screenShots/$layoutName.jpg")
        Log.i(mTAG, "Saving bitmap at: $imageFile")
        val os = BufferedOutputStream(FileOutputStream(imageFile))
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
        os.close()
    }


    /*To load cadillac or normal screens*/
    fun isCadillac(context: Context,dataPoolDataHandler: DataPoolDataHandler) {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val displayMetrics = DisplayMetrics()
        val point = Point()
        display.getRealSize(point)
        display.getMetrics(displayMetrics)
        val width = point.x
        val height = point.y
        val density = displayMetrics.densityDpi
        Log.e("density", density.toString())
        if (width >= 2940 && height >= 816 && density == 240) {
            dataPoolDataHandler.IS_CADILLAC.set(true)
        } else {
            dataPoolDataHandler.IS_CADILLAC.set(false)
        }
    }

    fun cadillacPopup(window: Window) {
        if (dataPoolDataHandler.IS_CADILLAC.get() == true) {
            GMSettingsApp.appContext.setTheme(com.gm.settingsapp.R.style.CustomPopup)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.setBackgroundDrawableResource(com.gm.settingsapp.R.drawable.cadillac_popup_bg)
        }
    }


}