package com.gm.settingsservice.apiintegration.apiinterfaces

/**
 * Request Methods for different features which are used  by [SimulationManager]
 */
interface ISettingsManagerReq {


    fun initListeners()
    /**
     * In set time option, To set AM/PM option to AM
     */
    fun onSETTINGS_REQ_CALIBRATION()

    fun onSETTINGS_REQ_SETTIMEAM(any: Any)
    fun onSETTINGS_REQ_SETSUSPENSIONTYPE(any: Any)
    fun onSETTINGS_REQ_SETSTEERINGTYPE(any: Any)
    fun onSETTINGS_REQ_SETTRACTIONTYPE(any: Any)
    fun onSETTINGS_MANAGE_SET_FAV()
    /**
     * In set time option, To decrement the value of Hour
     */
    fun onSETTINGS_REQ_SETTIMEHOURDEC(any: Any)

    /**
     * In set time option, To increment the value of Hour
     */
    fun onSETTINGS_REQ_SETTIMEHOURINC(any: Any)

    /**
     * In set time option, To decrement the value of Minute
     */
    fun onSETTINGS_REQ_SETTIMEMINUTEDEC(any: Any)

    /**
     * In set time option, To increment the value of Minute
     */
    fun onSETTINGS_REQ_SETTIMEMINUTEINC(any: Any)

    /**
     * To set time AM/PM option to PM
     */
    fun onSETTINGS_REQ_SETTIMEPM(any: Any)

    /**
     * To get current time information
     */
    fun onSETTINGS_REQ_GETTIMEINFO()

    /**
     * request time/date data
     */
    fun onSETTINGS_REQ_TIMEDATE()

    /**
     * To get current time information
     */
    fun onSETTINGS_REQ_GETDATEINFO()

    /**
     * To get Supported Languages
     */
    fun onSETTINGS_REQ_GETSUPPORTEDLANGUAGES()

    /**
     * To set Selected language
     * @param any Language
     */
    fun onSETTINGS_REQ_SETLANGUAGE(any: Any)

    /**
     * To decrement the value of day
     */
    fun onSETTINGS_REQ_SETDATEDAYDEC(any: Any)

    /**
     * To increment the value of day
     */
    fun onSETTINGS_REQ_SETDATEDAYINC(any: Any)

    /**
     * To decrement the value of month
     */
    fun onSETTINGS_REQ_SETDATEMONTHDEC(any: Any)

    /**
     * To increment the value of month
     */
    fun onSETTINGS_REQ_SETDATEMONTHINC(any: Any)

    /**
     * To decrement the value of Year
     */
    fun onSETTINGS_REQ_SETDATEYEARDEC(any: Any)

    /**
     * To increment the value of Year
     */
    fun onSETTINGS_REQ_SETDATEYEARINC(any: Any)

    /**
     * To enable 12_hour format or 24 hour format
     * @param any eSettingsDisplayStatus
     */
    fun onSETTINGS_REQ_SETTIMEDISPLAYFORMAT(any: Any)

    /**
     * To get 12_hour format or 24 hour format
     */

    fun onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()

    /**
     * To enable/disable Automatic time and date setting
     */
    fun onSETTINGS_REQ_SETAUTOTIMEDATEUPDATESETTING(any: Any)

    /**
     * To get Automatic time and date setting
     */
    fun onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()

    //request methods added for requirement

    /**
     * to know clicked item is set time or set date in timedate screen
     */
    fun onSETTINGS_REQ_TIMEORDATE(any: Any)

    /**
     * To set selected TimeZone
     * @param any com.gm.settingsservice.models.GmTimeZone
     */
    fun onSETTINGS_REQ_SETTIMEZONE(any: Any)

    /**
     * To set Automatic time zone
     */
    fun onSETTINGS_REQ_SETAUTOMATICTIMEZONE()

    /**
     * To get current time zone
     */
    fun onSETTINGS_REQ_GETTIMEZONE()

    /**
     * To get automatic timezone availability
     */
    fun onSETTINGS_REQ_GETAUTOMATICTIMEZONE()

    fun onSETTINGS_REQ_DISPLAY()
    fun onSETTINGS_REQ_DISPLAY_CADILLAC()
    fun onSETTINGS_REQ_SETDISPLAYMODETYPE(any: Any)
    fun SETTINGS_REQ_GETDISPLAYMODETYPE()
    fun onSETTINGS_REQ_SETDISPLAYSTATUS(any: Any)
    fun onSETTINGS_REQ_CALIBRATION_SUCCESS()
    fun onSETTINGS_REQ_SETPOWERLIFTGATETYPE(any: Any)
    /**
     *   To get the maximum startup volume
     */

    fun onSETTINGS_REQ_SETMAXSTARTUPVOLUME(any: Any)

    fun onSETTINGS_REQ_GETMAXSTARTUPVOLUME()

    fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK()

    /**
     * To set the maximum startup volume
     */

    fun onSETTINGS_REQ_SETAUDIBLETOUCHFEEDBACK(any: Any)


    /**
     *  To set he menu for sound module
     */
    fun onSETTINGS_REQ_SOUND_MENU()
    /**
     *  To set he menu for sound startup and shutdown volume
     */
    /**
     *  To set audio cues for sound module
     */
    fun onSETTINGS_REQ_SETAUDIOCUES(any: Any)

    fun onSETTINGS_REQ_GETAUDIOCUES()

    fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK2()

    fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK3()
    fun onSETTINGS_REQ_GETLANGUAGE()
    /**
     * To get selectable audio favorite count
     */
    fun onFAVORITE_REQ_GETAUDIOFAVORITECOUNT()

    /**
     * To set selectable audio favorite count
     * @param any count
     */
    fun onFAVORITE_REQ_SETAUDIOFAVORITECOUNT(any: Any)

    /**
     * To display the menu list
     */
    fun onSETTINGS_REQ_CONTAINER_LIST()

    /**
     * To display the driving mode list
     */
    fun onSETTINGS_REQ_DRIVINGMODELIST(driverModeList: Any)

    /**
     * To reset vehicle data
     */
    fun onSETTINGS_REQ_RESETVEHICLESETTINGS(any: Any)

    /**
     * To Erase settings personal data
     */
    fun onSETTINGS_RETURNTOFACTORY(any: Any)

    fun onSETTINGS_REQ_ERASESETTINGSPERSONALDATA(any: Any)
    //  fun onSETTINGS_REQ_VEHICLELIST(vehicleList: Any)
    fun onSETTINGS_REQ_SETENGINESOUNDTYPE(any: Any)

    fun onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST()

    fun onSETTINGS_REQ_GET_STORAGE_USAGE(any: Any)

    fun onSETTINGS_REQ_GET_CONFIRM_FORCESTOP()

    fun onSETTINGS_REQ_GET_RUNNINGAPPSTOP_POS(any: Any)

    /**
     * To display climate menu list
     */
    fun onSETTINGS_REQ_CLIMATE_MENU_LIST(any: Any)

    fun onCUSTOMIZATIONECC_REQ_SETAIRQUALITYSENSORSETTING(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETAUTODEFOGSETTING(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETIONIZERSETTINGS(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETAUTOFANSETTING(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETAUTOAIRDISTRSETTINGS(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETPOLLUTIONCONTROLSETTINGS(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETAUTOCOOLSEATSSETTING(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETAUTOHEATEDSEATSSETTING(any: Any)
    fun onCUSTOMIZATIONECC_REQ_SETREARZONESTARTUPSETTINGS(any: Any)
    fun onSETTINGS_REQ_CLIMATE_INNER(any: Any)
    fun onDEVICEPROJECTION_REQ_SETAPPLECARPLAYENABLE(any: Any)
    fun onDEVICEPROJECTION_REQ_SETGOOGLEAUTOLINKENABLE(any: Any)
    fun onSETTINGS_REQ_APPS_INNER(any: Any)
    fun onSETTINGS_APPS_REQ_DATA()
    fun onSETTINGS_REQ_SPORTMODESETTINGS(any: Any)
    fun onSETTINGS_REQ_SPORTMODESTEERINGSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODEDISPLAYSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODESUSPENSIONSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODETRACTIONSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODEDRIVERSEATSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODEPASSENGERSEATSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any) {}
    fun onSETTINGS_REQ_SPORTMODECHANGESETTINGS(any: Any)


    /**
     *  To display build number information
     */
    fun onSETTINGS_REQ_BUILDNUMBER()


    fun onSETTINGS_REQ_OPENSOURCE()

    fun onSETTINGS_REQ_BUILDCLICK()
    fun onSETTINGS_REQ_AUTOMATIC_ENTRY_EGRESS_ASSIST()
    fun SOUNDPARAMS_REQ_CHIMEVOLUMEDEC()
    fun SOUNDPARAMS_REQ_CHIMEVOLUMEINC()
    fun SOUNDPARAMS_REQ_SETCHIMEVOLUME()
    fun SOUNDPARAMS_REQ_GETCHIMEVOLUME()
    fun onSETTINGS_REQ_POWER_LIFTGATE()
    fun onSETTINGS_REQ_HANDSFREE_LIFTGATE()
    fun onSETTINGS_REQ_REVERSE_TILTMIRROR()
    fun onSETTINGS_REQ_REMOTE_MIRRORFOLDING()
    fun onSETTINGS_REQ_RAIN_SENSE_WIPERS()
    fun onSETTINGS_REQ_AUTO_WIPE_REVERSEGEAR()
    fun onSETTINGS_REQ_EXTENDED_HILL_START_ASSIST()
}