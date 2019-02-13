package com.gm.settingsservice.utils;

import gm.content.LanguageInfo;
import gm.content.SupportedLanguageListData;
import gm.dab.domain.audio.PresetInfo;
import gm.speech.UissConstants;
import gm.vehicle.ValueOutOfBoundsException;
import gm.calibrations.LANGUAGEANDREGIONALIZATIONGLOBALA_ENUM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import android.content.Context;

import com.android.internal.app.LocalePicker;
import com.gm.settingsservice.apiintegration.SettingsService;
import com.gm.settingsservice.apiintegration.sdk.SDKManager;
import com.gm.settingsservice.models.DataPoolDataHandler;

/**
 * This class is to get supported lanuage list and setting selected language
 */
public class LanguageListData {

    private static LanguageListData mLanguageListData = null;
    private static final String TAG = LanguageListData.class.getName();
    private static final int DEFAULT_LANGUAGE_ENABLED = 1;
    private Context mContext;
    // Language code and language data mapping
    private Map<Integer, LanguageInfo> mSettingsLanguageDataMap;

    private LanguageListData() {
        mSettingsLanguageDataMap = SupportedLanguageListData.getInstance().getLanguageMap();
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public static LanguageListData getInstance() {
        if (mLanguageListData == null) {
            mLanguageListData = new LanguageListData();
        }
        return mLanguageListData;
    }

    public Map<Integer, LanguageInfo> getLangaugeMap() {
        return mSettingsLanguageDataMap;
    }

    public List<Integer> getSupportedOnStarLanguageList(Context context) {

        LanguageInfo langInfo = null;
        List<Integer> supportedOnStarLanguageList = new ArrayList<Integer>();
        List<Integer> supportedLanguageKeys = SupportedLanguageListData.getInstance()
                .getSupportedLanguageList(context);

        for (Integer key : supportedLanguageKeys) {
            langInfo = mSettingsLanguageDataMap.get(key);
            supportedOnStarLanguageList.add(langInfo.getLanguageOnStarValue());


        }


        return supportedOnStarLanguageList;
    }



    public void setCurrentLanguage(int langKey, Context context) {


        List<Integer> supportedLanguageKeys = SupportedLanguageListData.getInstance()
                .getSupportedLanguageList(context);
        if (supportedLanguageKeys != null && supportedLanguageKeys.size() > 0
                && supportedLanguageKeys.contains(langKey)) {

            LanguageInfo langInfo = mSettingsLanguageDataMap.get(langKey);
            Locale selectedLocale = langInfo.getLanguageAndroidLocaleValue();
            localeToString(selectedLocale);

            LocalePicker.updateLocale(selectedLocale);

            LocalHelper.setLocale(mContext, String.valueOf(selectedLocale));




        }
    }

    /**
     * creating string from locale
     * @param l locale
     */
    public String localeToString(Locale l) {
        return l.getLanguage() + "," + l.getCountry();
    }

}
