package com.gm.settingsservice.utils;

import android.content.Context;
import android.content.SharedPreferences;

import gm.calibrations.DISPLAYGESTURESANDTIMEOUTS;
import gm.calibrations.GIS500_UI;
import gm.calibrations.GIS501_HOMESCREENUI;
import gm.calibrations.GIS513_DEVICEPROJECTION;
import gm.calibrations.GLOBAL_INFO3;
import gm.calibrations.GMCalibrationsManager;
import gm.calibrations.LANGUAGEANDREGIONALIZATIONGLOBALA;

public class CalibrationSettings {
    private GMCalibrationsManager mCalManager = null;
    private static CalibrationSettings myObj;
    private final SharedPreferences mPrefs;
    private final static String PREFS_CAL_NAME = "settings_prefs_cals";


    private CalibrationSettings(Context mContext) {
        mCalManager = new GMCalibrationsManager(mContext);

        mPrefs = mContext.getSharedPreferences(PREFS_CAL_NAME, mContext.MODE_PRIVATE);
    }

    /**
     * Create a static method to get instance.
     */
    public static CalibrationSettings getInstance(Context mContext) {
        if (myObj == null) {
            setInstance(mContext, new GMCalibrationsManager(mContext));
        }
        return myObj;
    }

    /**
     * Allow injection of a new calibrations manager (needed for unit test). Use
     * calManager = null to reset.
     */
    public static void setInstance(Context context, GMCalibrationsManager calManager) {
        myObj = new CalibrationSettings(context);
        if (calManager != null) {
            myObj.mCalManager = calManager;
        }
    }

    public boolean doesProximityExits() {
        return getBooleanCalibration("ENABLE_PROXIMITY_SENSING",
                DISPLAYGESTURESANDTIMEOUTS.ENABLE_PROXIMITY_SENSING_CalID, false);
    }



    public boolean isOnStarServicesVisible() {
        boolean status = getBooleanCalibration("ONSTAR_ENABLED",
                GIS501_HOMESCREENUI.APPLICATION_HOMESCREEN_ONSTAR_ENABLED_CalID, false);

       /* if (DEBUG) {
            Log.d(TAG, "isOnStarServicesVisible:" + status);
        }*/
        return status;
    }

    public boolean isAppShopEnabled() {
        boolean status = getBooleanCalibration("APPSHOP_ENABLED",
                GIS501_HOMESCREENUI.APPLICATION_HOMESCREEN_APPSHOP_ENABLED_CalID, false);

        /*if (DEBUG) {
            Log.d(TAG, "isAppShopEnabled:" + status);
        }*/
        return status;
    }


    public boolean doesNavigationExits() {
        return getBooleanCalibration("NavigationExits",
                GLOBAL_INFO3.ENABLE_APPLICATION_NAVIGATION_CalID, false);
    }


    public boolean doesCarPlayEnabled() {
        boolean status = getBooleanCalibration("Enable_Application_Apple_Carplay",
                GIS513_DEVICEPROJECTION.Enable_Application_Apple_Carplay_CalID, false);

        /*if (DEBUG) {
            Log.d(TAG, "doesCarPlayEnabled::" + status);
        }*/
        return status;
    }


    public boolean getBooleanCalibration(String calText, String calID, boolean defaultValue) {
        Boolean mValue = defaultValue;
        Object mCalValue = getCalibration(calText, calID, GMCalibrationsManager.CTYPE_BOOLEAN);
        if (mCalValue != null && mCalValue instanceof Boolean) {
            mValue = (Boolean) mCalValue;
        }
        return mValue;
    }

    public Object getCalibration(String calText, String calID, byte calibrationType) {
        Object mCalValue = null;
        try {
            if (mCalManager != null) {
                switch (calibrationType) {
                    case GMCalibrationsManager.CTYPE_STRING:
                        mCalValue = mCalManager.getString(calID);
                        break;
                    case GMCalibrationsManager.CTYPE_INTEGER:
                        mCalValue = mCalManager.getInteger(calID);
                        break;
                    case GMCalibrationsManager.CTYPE_BOOLEAN:
                        mCalValue = mCalManager.getBoolean(calID);
                        break;
                    case GMCalibrationsManager.CTYPE_ENUM:
                        mCalValue = mCalManager.getEnumeration(calID);
                        break;
                    case GMCalibrationsManager.CTYPE_INTEGER_ARRAY:
                        mCalValue = mCalManager.getIntegerArray(calID);
                        break;
                    case GMCalibrationsManager.CTYPE_FLOAT:
                        mCalValue = mCalManager.getFloat(calID);
                        break;
                    default:
                        break;
                }
            }
        } catch (GMCalibrationsManager.CalibrationsException e) {

        }
        return mCalValue;
    }

    public int getRegion() {
        int receivedEnum = -1;
        if (mCalManager != null) {
            receivedEnum = getEnumCalibration("CURRENT_REGION",
                    LANGUAGEANDREGIONALIZATIONGLOBALA.REGIONS_CalID, 0);
        }
        return receivedEnum;
    }

    public int getEnumCalibration(String calText, String calID, int defaultValue) {
        int mValue = defaultValue;
        Object mCalValue = getCalibration(calText, calID, GMCalibrationsManager.CTYPE_ENUM);
        if (mCalValue != null && mCalValue instanceof Integer) {
            mValue = (Integer) mCalValue;
        }


        return mValue;
    }

    private static String sAppLabelMetaKey = null;
    private static String sModelName = null;
    private static final String LABEL_META_DATA_KEY_PREFIX = "com.gm.application.label.";
    /**
     * @return key Associate to Meatadata
     */
    public static String getAppLabelCal() {
        if (sAppLabelMetaKey == null) {
            sAppLabelMetaKey = LABEL_META_DATA_KEY_PREFIX.concat(getModelNameCal());
        }

        return sAppLabelMetaKey;
    }

    private static final String DEFAULT_MODEL_NAME = "";
    /**
     * @return Current model Name
     */
    public static String getModelNameCal() {
        if (sModelName == null) {
            try {
                int model = myObj.mCalManager.getEnumeration(GIS500_UI.GMBrand_CalID);
                String modelName = gm.calibrations.GIS500_UI_ENUM.GM_Brand.fromOrdinal(model)
                        .name();
              /*  if (DEBUG) {
                    Log.d(TAG, "mpodel Name " + modelName);
                }*/

                if (modelName != null) {
                    sModelName = modelName;
                }
            } catch (Exception e) {
                //  Log.w(TAG, " Model Name not found:" + e);
                sModelName = DEFAULT_MODEL_NAME;
            }
        }

        return sModelName;
    }


}
