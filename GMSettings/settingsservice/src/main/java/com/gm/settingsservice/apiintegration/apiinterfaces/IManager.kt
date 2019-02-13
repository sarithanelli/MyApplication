package com.gm.settingsservice.apiintegration.apiinterfaces


/**
 * API calls for three platforms: GM SDK, Android SDK and Simulation.
 *
 */
interface IManager : ISettingsManagerReq {

    /**
     * Initialize for settings main screen
     */
    override fun initListeners()
override fun onSETTINGS_MANAGE_SET_FAV()
    override fun onSETTINGS_REQ_SETTIMEAM(any: Any)
    override fun onSETTINGS_REQ_CALIBRATION()

    override fun onSETTINGS_REQ_SETTIMEHOURDEC(any: Any)
    override fun onSETTINGS_REQ_SETTIMEHOURINC(any: Any)
    override fun onSETTINGS_REQ_SETTIMEMINUTEDEC(any: Any)
    override fun onSETTINGS_REQ_SETTIMEMINUTEINC(any: Any)
    override fun onSETTINGS_REQ_SETTIMEPM(any: Any)
    override fun onSETTINGS_REQ_GETTIMEINFO()
    override fun onSETTINGS_REQ_TIMEDATE()
    override fun onSETTINGS_REQ_GETDATEINFO()
    override fun onSETTINGS_REQ_SETDATEDAYDEC(any: Any)
    override fun onSETTINGS_REQ_SETDATEDAYINC(any: Any)
    override fun onSETTINGS_REQ_SETDATEMONTHDEC(any: Any)
    override fun onSETTINGS_REQ_SETDATEMONTHINC(any: Any)
    override fun onSETTINGS_REQ_SETDATEYEARDEC(any: Any)
    override fun onSETTINGS_REQ_SETDATEYEARINC(any: Any)
    override fun onSETTINGS_REQ_GETSUPPORTEDLANGUAGES()
    override fun onSETTINGS_REQ_SETLANGUAGE(any: Any)
    override fun onSETTINGS_REQ_TIMEORDATE(any: Any)
    override fun onSETTINGS_REQ_GETTIMEDISPLAYFORMAT()
    override fun onSETTINGS_REQ_SETTIMEDISPLAYFORMAT(any: Any)
    override fun onSETTINGS_REQ_SETAUTOTIMEDATEUPDATESETTING(any: Any)
    override fun onSETTINGS_REQ_GETAUTOTIMEDATEUPDATESETTING()
    override fun onSETTINGS_REQ_SETTIMEZONE(any: Any)
    override fun onSETTINGS_REQ_GETTIMEZONE()
    override fun onSETTINGS_REQ_GETAUTOMATICTIMEZONE()
    override fun onSETTINGS_REQ_SETAUTOMATICTIMEZONE()
    override fun onSETTINGS_REQ_DISPLAY()
    override fun onSETTINGS_REQ_DISPLAY_CADILLAC()
    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK()
    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK2()
    override fun onSETTINGS_REQ_GETAUDIBLETOUCHFEEDBACK3()

    override fun onSETTINGS_REQ_SETMAXSTARTUPVOLUME(any: Any)
    override fun onSETTINGS_REQ_GETMAXSTARTUPVOLUME()
    override fun onSETTINGS_REQ_SETAUDIBLETOUCHFEEDBACK(any: Any)
    override fun onSETTINGS_REQ_SOUND_MENU()
    override fun onSETTINGS_REQ_SETAUDIOCUES(any: Any)
    override fun onSETTINGS_REQ_GETAUDIOCUES()

    override fun onSETTINGS_REQ_SETDISPLAYMODETYPE(any: Any)
    override fun SETTINGS_REQ_GETDISPLAYMODETYPE()
    override fun onSETTINGS_REQ_SETDISPLAYSTATUS(any: Any)
    override fun onSETTINGS_REQ_CALIBRATION_SUCCESS()
    override fun onSETTINGS_REQ_GETLANGUAGE()

    override fun onFAVORITE_REQ_GETAUDIOFAVORITECOUNT()
    override fun onFAVORITE_REQ_SETAUDIOFAVORITECOUNT(any: Any)
    override fun onSETTINGS_REQ_CONTAINER_LIST()

    override fun onSETTINGS_REQ_ERASESETTINGSPERSONALDATA(any: Any)
    override fun onSETTINGS_REQ_RESETVEHICLESETTINGS(any: Any)

    override fun onSETTINGS_REQ_DRIVINGMODELIST(driverModeList: Any)
    override fun onSETTINGS_RETURNTOFACTORY(any: Any)
    //  override fun onSETTINGS_REQ_VEHICLELIST(vehicleList: Any)


    //  override fun onSETTINGS_REQ_VEHICLELIST(vehicleList: Any)


    override fun onSETTINGS_REQ_SETENGINESOUNDTYPE(any: Any)
    override fun onSETTINGS_REQ_GET_STORAGE_USAGE(any: Any)
    override fun onSETTINGS_REQ_GET_RUNNING_APPLICATIONLIST()
    override fun onSETTINGS_REQ_GET_CONFIRM_FORCESTOP()
    override fun onSETTINGS_REQ_GET_RUNNINGAPPSTOP_POS(any: Any)

    override fun onSETTINGS_REQ_CLIMATE_MENU_LIST(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAIRQUALITYSENSORSETTING(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAUTODEFOGSETTING(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETIONIZERSETTINGS(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAUTOFANSETTING(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAUTOAIRDISTRSETTINGS(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETPOLLUTIONCONTROLSETTINGS(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAUTOCOOLSEATSSETTING(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETAUTOHEATEDSEATSSETTING(any: Any)
    override fun onCUSTOMIZATIONECC_REQ_SETREARZONESTARTUPSETTINGS(any: Any)
    override fun onSETTINGS_REQ_CLIMATE_INNER(any: Any)
    override fun onDEVICEPROJECTION_REQ_SETAPPLECARPLAYENABLE(any: Any)
    override fun onDEVICEPROJECTION_REQ_SETGOOGLEAUTOLINKENABLE(any: Any)
    override fun onSETTINGS_REQ_APPS_INNER(any: Any)
    override fun onSETTINGS_APPS_REQ_DATA()
    override fun onSETTINGS_REQ_SPORTMODESETTINGS(any: Any)
    override fun onSETTINGS_REQ_SETSUSPENSIONTYPE(any: Any)
    override fun onSETTINGS_REQ_SETSTEERINGTYPE(any: Any)
    override fun onSETTINGS_REQ_SETTRACTIONTYPE(any: Any)
    override fun onSETTINGS_REQ_SPORTMODECHANGESETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODESTEERINGSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODEDISPLAYSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODESUSPENSIONSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODETRACTIONSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODEDRIVERSEATSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODEPASSENGERSEATSETTINGS(any: Any)
    override fun onSETTINGS_REQ_SPORTMODEADAPTIVECRUISECONTROLSETTINGS(any: Any)
    override fun onSETTINGS_REQ_BUILDNUMBER()
    override fun onSETTINGS_REQ_OPENSOURCE()

    override fun onSETTINGS_REQ_BUILDCLICK()

}