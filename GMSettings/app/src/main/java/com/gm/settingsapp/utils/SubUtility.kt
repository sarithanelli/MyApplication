package com.gm.settingsapp.utils

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.CountDownTimer
import android.preference.PreferenceManager
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsservice.R
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.models.eLHD_RHD_RTL
import java.util.*

object SubUtility {

    fun setNewLocaleThemeType(c: Context, themeType: String): Context {
        persistThemeType(c, themeType)
        return updateResourcesTheme(c, themeType)
    }

    private fun persistThemeType(c: Context, themeType: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString("theme_type_key", themeType).apply()
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

    fun persistLanguageSkew(c: Context, eLhdRhdRtl: eLHD_RHD_RTL) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString(getStringById(R.string.shared_pref_language_key_config), getLanguageStringFrom(eLhdRhdRtl)).apply()
    }

    /**
     * Get String from Id
     * @param id String id
     * @return String
     */
    fun getStringById(id: Int): String {
        return GMSettingsApp.appContext.resources.getString(id)
    }

    private fun getLanguageStringFrom(eLhdRhdRtl: eLHD_RHD_RTL): String {
        return when (eLhdRhdRtl) {
            eLHD_RHD_RTL.LHD -> "en"
            eLHD_RHD_RTL.RHD -> "uk"
            eLHD_RHD_RTL.RTL -> "ar"
        }
    }

    /**
     * set Language to shared preferences
     * @param c activity context
     * @return String language
     */
     fun persistLanguage(c: Context, language: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(c)
        prefs.edit().putString(c.resources.getString(R.string.shared_pref_language_key), language).apply()
    }

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




}