package com.gm.settingsapp.ui.adapters


import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.R
import com.gm.settingsapp.ui.activities.SettingsHomeActivity
import com.gm.settingsapp.ui.customview.SkewConstraintLayout
import com.gm.settingsapp.ui.customview.SkewImageView
import com.gm.settingsapp.ui.customview.SkewMaterialButton
import com.gm.settingsapp.ui.customview.SkewTextView
import com.gm.settingsapp.utils.CustomNumberPicker
import com.gm.settingsapp.utils.RecyclerItemClickListener
import com.gm.settingsapp.utils.TouchCalibrationData
import com.gm.settingsapp.utils.TouchCalibrationTestAPI
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.Constants.DELAY_INC_DEC_TIME
import com.gm.settingsapp.viewmodels.Constants.EVENT_LONG_CLICK_PRESSED_DECREMENT
import com.gm.settingsapp.viewmodels.Constants.EVENT_LONG_CLICK_PRESSED_INCREMENT
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.apiintegration.SettingsService
import com.gm.settingsservice.models.*
import com.gm.settingsservice.utils.Constants.TWELVE
import com.gm.settingsservice.utils.Utility
import com.gm.uisdk.views.GMRecyclerView

import com.google.android.material.tabs.TabLayout
import java.util.*
import javax.inject.Inject


class BinderAdapter @Inject constructor(val eventHandler: EventHandler, val binderDataBindingComponent: BinderDataBindingComponent, val eventProcessor: EventProcessor, utility: com.gm.settingsapp.utils.Utility, serviceUtility: Utility, dataPoolDataHandler: DataPoolDataHandler) {

    var utility: com.gm.settingsapp.utils.Utility = utility

    var dataPoolDataHandler: DataPoolDataHandler = dataPoolDataHandler

    var serviceUtility: com.gm.settingsservice.utils.Utility = serviceUtility

    lateinit var pager: androidx.viewpager.widget.ViewPager
    /**
     * attaching viewPager to tabLayout
     * @param tabLayout tablayout view
     * @param viewPager Viewpager
     */
    @BindingAdapter("bind:viewPager")
    fun bindTabView(tabLayout: TabLayout, viewPager: ObservableField<androidx.viewpager.widget.ViewPager>) {
        tabLayout.setupWithViewPager(viewPager.get())
        tabLayout.tabGravity = TabLayout.GRAVITY_CENTER
        tabLayout.tabMode = TabLayout.MODE_FIXED
    }

    /**
     * attaching viewPager to tabLayout
     * @param tabLayout tablayout view
     * @param viewPager Viewpager
     */
    @BindingAdapter("bind:viewPager")
    fun bindTabLayout(tabLayout: TabLayout, viewPager: androidx.viewpager.widget.ViewPager) {
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabGravity = TabLayout.GRAVITY_CENTER
        tabLayout.tabMode = TabLayout.MODE_FIXED
    }

    /**
     * assigning adapter to viewpager
     * @param viewPager view
     * @param pagerItems listitems
     */
    @BindingAdapter("bind:pagerItems")
    fun bindViewpager(viewPager: androidx.viewpager.widget.ViewPager, pagerItems: ObservableField<settingsHomeViewer>) {
        pager = viewPager
        viewPager.adapter = SettingsPagerViewAdapter((viewPager.context as androidx.fragment.app.FragmentActivity).supportFragmentManager,dataPoolDataHandler,utility)
        viewPager.setCurrentItem(pagerItems.get()!!.currentHomePage.value as Int, true)
        GMSettingsApp.appContext.settingsPagerAdapter = SettingsPagerViewAdapter((viewPager.context as androidx.fragment.app.FragmentActivity).supportFragmentManager,dataPoolDataHandler,utility)
        addonPageChangeListener(viewPager, viewPager.adapter)
    }

    /**
     * adding OnPageChangeListener to viewPager
     * @param viewPager view
     */
    fun addonPageChangeListener(viewPager: androidx.viewpager.widget.ViewPager, adapter: androidx.viewpager.widget.PagerAdapter?) {
        viewPager.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                var fragment: androidx.fragment.app.Fragment? = null
                when (appContext.activityContext) {
                    is SettingsHomeActivity -> {
                        viewPager.setCurrentItem(position, true)
                        dataPoolDataHandler.homeScreenData.get()!!.currentHomePage = SETTINGS_CURRENT_HOME_PAGE.values()[position]
                        dataPoolDataHandler.SETTINGS_TAB_SELECTION.set(position)
                    }

                }
            }

        })
    }

    /**
     * Adding adapter to FastScrollRecyclerView
     * @param recyclerView
     * @param items list items
     * @param childlayout row layout
     */
    @BindingAdapter("bind:items", "bind:childLayout")
    fun bindList(recyclerView: GMRecyclerView, items: ObservableArrayList<*>, childlayout: Int) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        //if(recyclerView.adapter!! == null) {
        //  recyclerView.adapter = RecyclerViewAdapter(items, childlayout)
        recyclerView.adapter = RecyclerViewAdapter(items, childlayout, eventHandler, binderDataBindingComponent, dataPoolDataHandler)
        recyclerView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                recyclerView.setSkewAttributes((dataPoolDataHandler.isSkewEnabled.get()!!), 8f)
                recyclerView.setUpRecyclerView(recyclerView.width, recyclerView.height)
                recyclerView.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
        //}
        recyclerView.adapter!!.notifyDataSetChanged()
        recyclerView.setActivityContext(GMSettingsApp.appContext.activityContext)
        /*if (items.size > 6) {
        recyclerView.setFastScrollType(1)
    } else {
        recyclerView.setFastScrollType(0)
    }*/
        // recyclerView.scrollToPosition(dataPoolDataHandler.SETTINGS_RECYCLERVIEW_SCROLL_STATE.get()!!)
        when (dataPoolDataHandler.LHD_RHD_RTL.get()!!) {
            eLHD_RHD_RTL.RHD -> {
                recyclerView.setFastScrollRHD(true)
            }
            eLHD_RHD_RTL.LHD -> {
                recyclerView.setFastScrollRHD(false)
            }
            eLHD_RHD_RTL.RTL -> {
                recyclerView.setFastScrollRHD(true)
            }
        }

    }

    /**
     * Adding adapter to RecyclerView
     * @param recyclerView
     * @param items list items
     * @param childlayout row layout
     */
    @BindingAdapter("bind:childItems", "bind:childLayoutId")
    fun bindList(recyclerView: androidx.recyclerview.widget.RecyclerView, items: ObservableArrayList<*>, childlayout: Int) {
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(recyclerView.context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = RecyclerViewAdapter(items, childlayout, eventHandler, binderDataBindingComponent, dataPoolDataHandler)
        GMSettingsApp.appContext.childLayoutID = childlayout

    }


    /**
     * Adding adapter to tabs
     * @param androidx.recyclerview.widget.RecyclerView
     * @param tabItems list items
     * @param tabChildLayout row layout
     */
    @SuppressLint("WrongConstant")
    @BindingAdapter("bind:tabChildLayout", "bind:tabItems")
    fun bindList(recyclerView: androidx.recyclerview.widget.RecyclerView, childlayout: Int, items: ObservableArrayList<*>) {
        val lp = ConstraintLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        recyclerView.layoutParams = lp
        if (dataPoolDataHandler.IS_CADILLAC.get() == true)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
        else
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
        // recyclerView.adapter = RecyclerViewAdapter(items, layout)
        recyclerView.adapter = RecyclerViewAdapter(items, childlayout, eventHandler, binderDataBindingComponent, dataPoolDataHandler)
        recyclerView.adapter!!.notifyDataSetChanged()

        recyclerView.addOnItemTouchListener(RecyclerItemClickListener(appContext, recyclerView, object : RecyclerItemClickListener.OnItemClickListener {
            override fun onLongItemClick(view: View?, position: Int) {

            }

            override fun onItemClick(view: View, position: Int) {
                if (dataPoolDataHandler.IS_CADILLAC.get() == true) {
                    if (position < 2) {
                        pager.setCurrentItem(position, true)
                    }
                } else {
                    pager.setCurrentItem(position, true)
                }

            }

        }))
    }


    @BindingAdapter("bind:background")
    fun setImageResource(imageButton: ImageButton, resource: Int) {
        imageButton.setImageResource(resource)
    }

    /**
     * Adding adapter
     * to FastScrollRecyclerView for languages
     * @param recyclerView
     * @param itemsbind list items
     * @param childlayout row layout
     */
    @BindingAdapter("bind:itemsbind", "bind:childLayout")
    fun bindList(recyclerView: GMRecyclerView, items: ObservableField<ArrayList<ESettingsLanguageType>>, childlayout: Int) {
        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
        //this code used for set LHD,RHD,RTL
        when (dataPoolDataHandler.LHD_RHD_RTL.get()!!) {
            eLHD_RHD_RTL.RHD -> {
                recyclerView.setFastScrollRHD(true)
            }
            eLHD_RHD_RTL.LHD -> {
                recyclerView.setFastScrollRHD(false)
            }
            eLHD_RHD_RTL.RTL -> {
                recyclerView.setFastScrollRHD(true)
            }
        }
        GMSettingsApp.appContext.recyclerViewAdapter = RecyclerViewAdapter(items, childlayout, eventHandler, binderDataBindingComponent, dataPoolDataHandler)
        if (recyclerView.adapter == null) {
            val adapter = RecyclerViewAdapter(items, childlayout, eventHandler, binderDataBindingComponent, dataPoolDataHandler)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        recyclerView.setActivityContext(GMSettingsApp.appContext.activityContext)
        /*if (items.get()!!.size > 6) {
        recyclerView.setFastScrollType(1)
    } else {
        recyclerView.setFastScrollType(0)
    }*/
        recyclerView.adapter = GMSettingsApp.appContext.recyclerViewAdapter
        GMSettingsApp.appContext.recyclerViewAdapter!!.notifyDataSetChanged()
    }

    @BindingAdapter("bind:seekbarTouch")
    fun setOnSeekbarTouchListener(seek: SeekBar, number: Int) {
        seek.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                return true  // Returning true will block the Touch/Click/Drag functionality for Seekbar.
            }
        })
    }


    // for sound cue module
    @SuppressLint("HandlerLeak")
    inner class SoundSettingsCueHandler : Handler() {
        override fun handleMessage(msg: Message) {
            /*  if (!mKeyStatePressed) {
              return
          }*/

            when (msg.what) {
                EVENT_LONG_CLICK_PRESSED_INCREMENT -> this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETAUDIOCUES", 1, "SettingsSoundsAudioCueVolActivity", true)
                EVENT_LONG_CLICK_PRESSED_DECREMENT -> this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETAUDIOCUES", -1, "SettingsSoundsAudioCueVolActivity", true)
            }

            sendEmptyMessageDelayed(msg.what, DELAY_INC_DEC_TIME.toLong())
        }
    }

    // for sound module
    @SuppressLint("HandlerLeak")
    inner class SoundSettingsHandler : Handler() {
        override fun handleMessage(msg: Message) {
            /*  if (!mKeyStatePressed) {
              return
          }*/

            when (msg.what) {
                EVENT_LONG_CLICK_PRESSED_INCREMENT -> this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETMAXSTARTUPVOLUME", 1, "SettingsSoundsMaxVolumeActivity", true)
                EVENT_LONG_CLICK_PRESSED_DECREMENT -> this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETMAXSTARTUPVOLUME", -1, "SettingsSoundsMaxVolumeActivity", true)
            }

            sendEmptyMessageDelayed(msg.what, DELAY_INC_DEC_TIME.toLong())
        }
    }

    @BindingAdapter("bind:SeekBarCuelongPress")
    fun setCueTouchListner(updown: ImageButton, eventNamedata: Int) {
        var soundSettingsCueHandler = SoundSettingsCueHandler()
        updown.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, motionEvent: MotionEvent): Boolean {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        updown.isPressed = true
                        if (v.id == R.id.volume_increase) {
                            soundSettingsCueHandler.sendEmptyMessageDelayed(EVENT_LONG_CLICK_PRESSED_INCREMENT, DELAY_INC_DEC_TIME.toLong())
                        } else if (v.id == R.id.volume_reduce) {
                            soundSettingsCueHandler.sendEmptyMessageDelayed(EVENT_LONG_CLICK_PRESSED_DECREMENT, DELAY_INC_DEC_TIME.toLong())
                        }

                    }

                    MotionEvent.ACTION_UP -> {
                        updown.isPressed = false
                        soundSettingsCueHandler.removeMessages(EVENT_LONG_CLICK_PRESSED_DECREMENT)
                        soundSettingsCueHandler.removeMessages(EVENT_LONG_CLICK_PRESSED_INCREMENT)
                        when (v.id) {
                            R.id.volume_increase ->
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETAUDIOCUES", 1, "SettingsSoundsAudioCueVolActivity", true)
                            R.id.volume_reduce ->
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETAUDIOCUES", -1, "SettingsSoundsAudioCueVolActivity", true)

                        }
                    }
                }
                return true
            }
        })

    }


    // for sound module seekbar increment and decrement code
    @BindingAdapter("bind:SeekBarlongPress")
    fun setSeekTouchListener(updown: ImageButton, eventName: Int) {
        var soundSettingsCueHandler = SoundSettingsCueHandler()

        updown.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, motionEvent: MotionEvent): Boolean {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        updown.isPressed = true
                        if (v.id == R.id.volume_increase) {
                            soundSettingsCueHandler.sendEmptyMessageDelayed(EVENT_LONG_CLICK_PRESSED_INCREMENT, DELAY_INC_DEC_TIME.toLong())
                        } else if (v.id == R.id.volume_reduce) {
                            soundSettingsCueHandler.sendEmptyMessageDelayed(EVENT_LONG_CLICK_PRESSED_DECREMENT, DELAY_INC_DEC_TIME.toLong())
                        }

                    }

                    MotionEvent.ACTION_UP -> {
                        updown.isPressed = false
                        soundSettingsCueHandler.removeMessages(EVENT_LONG_CLICK_PRESSED_DECREMENT)
                        soundSettingsCueHandler.removeMessages(EVENT_LONG_CLICK_PRESSED_INCREMENT)
                        when (v.id) {
                            R.id.volume_increase ->
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETMAXSTARTUPVOLUME", 1, "SettingsSoundsMaxVolumeActivity", true)
                            R.id.volume_reduce ->
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETMAXSTARTUPVOLUME", -1, "SettingsSoundsMaxVolumeActivity", true)

                        }
                    }
                }
                return true
            }
        })

    }


    @BindingAdapter("bind:monthDisplayValues")
    fun monthDisplayValuesDate(numberPicker: CustomNumberPicker, month: Int) {

        numberPicker.displayedValues = GMSettingsApp.appContext.resources.getStringArray(R.array.month_values)

    }


    @BindingAdapter("bind:ampmvalues")
    fun AmPmValuesData(numberPicker: CustomNumberPicker, month: Int) {

        numberPicker.displayedValues = GMSettingsApp.appContext.resources.getStringArray(R.array.month_ampm)

    }

    var scrollNum: Int = 999
    /* added*/
    @BindingAdapter("bind:monthWheelChange")
    fun monthWheelChangelistner(numberPicker: CustomNumberPicker, mValue: String) {
        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            numberPicker.setOnScrollListener { view: CustomNumberPicker?, scrollState: Int ->
                if (scrollState == 0) {
                    if (oldVal < newVal) {
                        when (mValue) {
                            "month" -> {
                                scrollNum = 0
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEMONTHINC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "date" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEDAYINC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "year" -> {
                                scrollNum = 0
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEYEARINC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "hour" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEHOURINC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "mins" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEMINUTEINC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "ampm" -> {
                                if (newVal == 1) {
                                    this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEPM", newVal, "SettingsSetTimeActivity", true)
                                } else {
                                    this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEAM", newVal, "SettingsSetTimeActivity", true)
                                }
                            }

                        }
                    } else if (oldVal > newVal) {
                        when (mValue) {
                            "month" -> {
                                scrollNum = 0
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEMONTHDEC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "date" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEDAYDEC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "year" -> {
                                scrollNum = 0
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETDATEYEARDEC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "hour" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEHOURDEC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "mins" -> {
                                this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEMINUTEDEC", newVal, "SettingsSetTimeActivity", true)
                            }
                            "ampm" -> {
                                if (newVal == 1) {
                                    this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEPM", newVal, "SettingsSetTimeActivity", true)
                                } else {
                                    this@BinderAdapter.eventProcessor.triggerEvent("process", "onSETTINGS_REQ_SETTIMEAM", newVal, "SettingsSetTimeActivity", true)
                                }
                            }

                        }
                    }
                }


            }
            /*  when (mValue) {
              "month"  -> {
                  updateDateValue(newVal,"onSETTINGS_REQ_SETDATEMONTHINC")
              }
              "year"  -> {
                  updateDateValue(newVal,"onSETTINGS_REQ_SETDATEYEARINC")
              }

          }*/
        }

    }

    val calendar = Calendar.getInstance()
    fun getNumber(number: Int) {
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR))
        calendar.set(Calendar.MONTH, number)
        dataPoolDataHandler.SETTINGS_DATEINFO_MAXVALUE.set(calendar.getActualMaximum(Calendar.DATE))

    }

    fun updateDateValue(newVal: Int, type: String) {

        if (scrollNum == 999) {
            getNumber(newVal)
            this@BinderAdapter.eventProcessor.triggerEvent("process", type, newVal, "SettingsSetTimeActivity", true)
        }

    }

    @BindingAdapter("bind:np_hour_max")
    fun updateHourValue(numberPicker: CustomNumberPicker, boolean: Boolean) {
        if (boolean) {
            numberPicker.maxValue = com.gm.settingsservice.utils.Constants.MAX_HOUR_VALUE_IN_24_HOUR_FORMAT
            numberPicker.minValue = com.gm.settingsservice.utils.Constants.MIN_HOUR_VALUE_IN_24_HOUR_FORMAT
            val calender = Calendar.getInstance()
            dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR_OF_DAY))
            numberPicker.value = dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!
        } else {
            numberPicker.maxValue = com.gm.settingsservice.utils.Constants.MAX_HOUR_VALUE_IN_12_HOUR_FORMAT
            numberPicker.minValue = com.gm.settingsservice.utils.Constants.MIN_HOUR_VALUE_IN_12_HOUR_FORMAT
            val calender = Calendar.getInstance()
            dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.set(calender.get(Calendar.HOUR))
            numberPicker.value = dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!
        }
    }

    @BindingAdapter("bind:np_max")
    fun updateDateValue(numberPicker: CustomNumberPicker, date: Int) {
        numberPicker.maxValue = dataPoolDataHandler.SETTINGS_DATEINFO_MAXVALUE.get()!!

    }

    @BindingAdapter("bind:np_value")
    fun currentValueUpdate(numberPicker: CustomNumberPicker, any: Any) {
        when (any) {
            "month" -> numberPicker.value = dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARMONTH.get()!!
            "date" -> numberPicker.value = dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARDAY.get()!!
            "year" -> numberPicker.value = dataPoolDataHandler.SETTINGS_DATEINFO_CALENDARYEAR.get()!!
            "hour" -> numberPicker.value = dataPoolDataHandler.SETTINGS_TIMEINFO_HOUROFDAY.get()!!
            "mins" -> numberPicker.value = dataPoolDataHandler.SETTINGS_TIMEINFO_MINUTEOFHOUR.get()!!
            else -> {
                if (dataPoolDataHandler.SETTINGS_USE_24HOUR_FORMAT_TOGGLESTATE.get()!!) {
                    numberPicker.visibility = View.GONE
                } else {
                    numberPicker.visibility = View.VISIBLE
                    if (dataPoolDataHandler.SETTINGS_TIMEINFO_MERIDIEM.get() == eSettingsTimeMeridiem.SETTINGS_TIME_MERIDIEM_ANTE) {
                        numberPicker.value = 0
                    } else {
                        numberPicker.value = 1
                    }
                }
            }
        }

    }

    /**
     * assigning leading zero to minute in settime
     */
    @SuppressLint("SetTextI18n")
    @BindingAdapter("bind:hour")
    fun setHourValue(textView: TextView, hour: Int) {
        if (dataPoolDataHandler.SETTINGS_TIME_OR_DATE.get()!!) {
            if (hour == 0 && dataPoolDataHandler.SETTINGS_TIMEDISPLAYFORMAT.get() == eSettingsTimeDisplayFormat.SETTINGS_SS_TIME_DISPLAY_FORMAT_12HRMODE) {

                textView.text = TWELVE.toString()
            } else {
                textView.text = hour.toString()
            }
        } else {
            textView.text = hour.toString()
        }
    }


    /**
     * To get current locale of device
     */
    @SuppressWarnings("deprecation")
    fun getLocale(): Locale {
        return GMSettingsApp.appContext.resources
                .configuration.locale
    }

    /**
     * adding description text for Set time,date, automatic time update,24-hour format
     * @param textView
     * @param currentScreen when onclick event occured on timedate list, it return current screen
     */
    @BindingAdapter("bind:sideDescText")
    fun setSideDescriptionText(textView: TextView, currentScreen: Int) {
        if (currentScreen == com.gm.settingsservice.utils.Constants.USES_24HOUR_FORMAT_SCREEN)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_use_24_hr_format_content)
        else if (currentScreen == com.gm.settingsservice.utils.Constants.AUTOMATIC_TIME_AND_DATE_SCREEN)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_automatic_time_date_content)
        else if (currentScreen == com.gm.settingsservice.utils.Constants.SET_TIME_SCREEN)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_set_time_content)
        else if (currentScreen == com.gm.settingsservice.utils.Constants.SET_DATE_SCREEN)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_set_date_content)
        else if (currentScreen == com.gm.settingsservice.utils.Constants.SET_DATE_SCREEN)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_set_date_content)

    }

    @BindingAdapter("bind:DescText")
    fun setDescriptionText(textView: TextView, currentScreen: Int){
        if (currentScreen == Constants.PEDESTRIAN_FRIENDLY_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_pedestrian_friendly_alert_content)

        else if (currentScreen == Constants.PEDESTRIAN_FRIENDLY_ALERT_SOUND)
            textView.text = GMSettingsApp.appContext.getText(R.string.pedestrian_friendly_alert_sound_text)

        else if (currentScreen == Constants.ALERT_TYPE)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_alert_type_content)

        else if (currentScreen == Constants.FORWORD_COLLISION_SYSTEM)
            textView.text = GMSettingsApp.appContext.getText(R.string.forward_collision_system_text)

        else if (currentScreen == Constants.FRONT_PEDESTRIAN_DETECTION)
            textView.text = GMSettingsApp.appContext.getText(R.string.front_pedestrian_detection_text)

        else if (currentScreen == Constants.INTERSECTIONS_TOP_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.intersection_stop_alert_text)

        else if (currentScreen == Constants.CONNECTED_VEHICLE_BRAKING_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.connected_vehicle_braking_alert_text)

        else if (currentScreen == Constants.TRAFFIC_AND_ROADSIDE_INFORMATION)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_traffic_and_roadside_information)

        else if (currentScreen == Constants.DROWSY_DRIVER_ALETRT)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_drowsy_driver_alert_content)

        else if (currentScreen == Constants.ADAPTIVE_CRUISEGO_NOTIFIER)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_adaptive_cruise_go_notifier_content)

        else if (currentScreen == Constants.SIDE_BELTZONE_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.side_belt_zone_alert_text)

        else if (currentScreen == Constants.LANE_CHANGE_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.lane_change_alert_text)

        else if (currentScreen == Constants.SEATBEL_TTIEGHTENING)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_seat_belt_tightening_content)

        else if (currentScreen == Constants.PARK_ASSIST)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_park_assist)

        else if (currentScreen == Constants.PARK_ASSIST_TOWBAR)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_park_assist_towbar)

        else if (currentScreen == Constants.REAR_CAMERA_PARK_ASSIST_SYMBOLS)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_rear_camera_park_assist_symbols_content)

        else if (currentScreen == Constants.REAR_CROSS_TRAFFIC_ALERT)
            textView.text = GMSettingsApp.appContext.getText(R.string.settings_rear_cross_traffic_alerts_content)

        else if (currentScreen == Constants.REAR_PEDESTRAIN_DETECTION)
            textView.text = GMSettingsApp.appContext.getText(R.string.rear_pedestrian_detection_text)
    }


    /**
     * Changing Configuration settings for configuration screen
     * @param view
     * @param layoutDirection  SettingsConfigurationModel
     */
    @BindingAdapter("bind:layoutDirection")
    fun setLayoutDirection(view: View, layoutDirection: ObservableField<SettingsConfigurationModel>) {
        if (layoutDirection.get() != null) {

            when (layoutDirection.get()!!.configName) {
                "LHD" -> {
                    if (layoutDirection.get()!!.status) {
                        view.layoutDirection = View.LAYOUT_DIRECTION_LOCALE
                        dataPoolDataHandler.isRHD.set(false)
                    }
                }
                "RHD" -> {
                    dataPoolDataHandler.isRHD.set(layoutDirection.get()!!.status)

                }
                "RTL" -> {
                    if (layoutDirection.get()!!.status) {
                        view.layoutDirection = View.LAYOUT_DIRECTION_RTL
                        dataPoolDataHandler.isRHD.set(false)
                    } else
                        view.layoutDirection = View.LAYOUT_DIRECTION_LOCALE
                }

            }
        }
    }

    /**
     * Set Layout directions for RHD/LHD
     * @param view
     * @param direction layout direction
     */
    @BindingAdapter("bind:layoutDirectionRhd")
    fun setLayoutDirection(view: View?, direction: Int) {
        when (dataPoolDataHandler.LHD_RHD_RTL.get()) {
            eLHD_RHD_RTL.RHD -> {
                when (direction) {
                    0 -> view?.layoutDirection = View.LAYOUT_DIRECTION_LTR
                    1 -> view?.layoutDirection = View.LAYOUT_DIRECTION_RTL
                }
            }
            else -> {
            }
        }
    }

    @BindingAdapter("bind:slopedAngle")
    fun setSloppedAngle(view: View, angle: Float) {
        when {
            dataPoolDataHandler.isSkewEnabled.get()!! ->
                when (view) {
                    is SkewConstraintLayout -> view.setAngle(angle)
                    is SkewTextView -> view.setAngle(angle)
                    is SkewMaterialButton -> view.setAngle(angle)
                    is SkewImageView -> view.setAngle(angle)
                }
        }
    }

    @BindingAdapter("bind:enabled")
    fun setEnabled(picker: View, enableState: Boolean) {
        if (picker is CustomNumberPicker)
            if (enableState) {
                picker.selectedTextColor = GMSettingsApp.appContext.resources.getColor(R.color.picker_grey)
            } else {
                picker.selectedTextColor = GMSettingsApp.appContext.resources.getColor(R.color.np_select_color)
            }

        if (picker is TextView) {
            if (enableState) {
                picker.setTextColor(GMSettingsApp.appContext.resources.getColor(R.color.picker_grey))
            } else {
                picker.setTextColor(GMSettingsApp.appContext.resources.getColor(R.color.np_select_color))
            }
        }

        picker.isEnabled = !enableState
        picker.isClickable = !enableState

    }

    /**
     * Methos is used for programmatically setting width while skew is enabled
     */
    @BindingAdapter("bind:skewValue")
    fun setWidth(view: View, isSkew: ObservableField<Boolean>) {

        if (isSkew.get()!!) {
            val params = view.layoutParams

            val windowManager = GMSettingsApp.appContext.getSystemService(Context.WINDOW_SERVICE)
                    as WindowManager
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display.getMetrics(displayMetrics)
            val vto = view.viewTreeObserver
            vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    val height = view.measuredHeight
                    val mWidth = view.measuredWidth
                    val extrawidth = (height * 0.15).toInt()
                    params.width = mWidth - extrawidth
                    view.layoutParams = params

                }
            })
        }
    }


    /**
     * displaying current status for radio buttons
     * @param view
     * @param currentScreen when onclick event occurred on timedate list it return current screen and display mode list it return position
     */
    @BindingAdapter("bind:radioBtnChecked")
    fun SetRadioButtonSatus(view: View, currentScreen: Int) {
        when (view.id) {

        }
    }

    /**
     * when radio button click event occur
     * @param view
     * @param currentScreen when onclick event occurred on timedate list it return current screen and display mode list it return position
     */
    @BindingAdapter("bind:onClick")
    fun SetOnRadioClickEvent(view: View, currentScreen: Int) {
        view.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                when (p0!!.id) {

                }
            }


        }
        )
    }

    /**
     * when ToggleButton touch event occur
     * @param ToggleButton
     * @param Int when onTouch event occurred on calibration toggle buttons, it return position
     */
    @BindingAdapter("bind:checked")
    fun SetOnToggleTouchEvent(view: ToggleButton, position: Int) {
        view.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {
                if (dataPoolDataHandler.CALIBRATE_TIMER != null) {
                    dataPoolDataHandler.CALIBRATE_TIMER!!.cancel()
                }
                val touchCalibrationData: TouchCalibrationData? = TouchCalibrationData()
                val touchCalibrationTestAPI: TouchCalibrationTestAPI? = TouchCalibrationTestAPI()
                when (motionEvent!!.action) {
                    MotionEvent.ACTION_UP -> {
                        view.isPressed = true
                        when (position) {
                            Constants.CALIBRATE_TOP_LEFT -> {
                                //start countdown timer 15 sec
                                eventHandler.calibrationStartTimer(15000, 1000).start()
                                //set toggle button visibility based on position



                                eventHandler.startTouchScreenCalibration(position + 1, view)
                                if (touchCalibrationData != null) {
                                    touchCalibrationTestAPI!!.setTouchCalibrationPoint(touchCalibrationData.leftTopPoint)
                                }
                            }
                            Constants.CALIBRATE_TOP_RIFHT -> {
                                //start countdown timer 15 sec
                                eventHandler.calibrationStartTimer(15000, 1000).start()
                                //set toggle button visibility based on position
                                eventHandler.startTouchScreenCalibration(position + 1, view)
                                if (touchCalibrationData != null) {
                                    touchCalibrationTestAPI!!.setTouchCalibrationPoint(touchCalibrationData.rightTopPoint)
                                }
                            }
                            Constants.CALIBRATE_BOTTOM_RIGHT -> {
                                //start countdown timer 15 sec
                                eventHandler.calibrationStartTimer(15000, 1000).start()
                                //set toggle button visibility based on position
                                eventHandler.startTouchScreenCalibration(position + 1, view)
                                if (touchCalibrationData != null) {
                                    touchCalibrationTestAPI!!.setTouchCalibrationPoint(touchCalibrationData
                                            .rightBottomPoint)
                                }
                            }

                            Constants.CALIBRATE_BOTTOM_LEFT -> {
                                //start countdown timer 15 sec
                                eventHandler.calibrationStartTimer(15000, 1000).start()
                                //set toggle button visibility based on position
                                eventHandler.startTouchScreenCalibration(position + 1, view)
                                if (touchCalibrationData != null) {
                                    touchCalibrationTestAPI!!.setTouchCalibrationPoint(touchCalibrationData.leftBottomPoint)
                                }
                            }
                            Constants.CENTER -> {
                                if (touchCalibrationData != null) {
                                    touchCalibrationTestAPI!!.setTouchCalibrationPoint(touchCalibrationData.centerPoint)
                                }
                                this@BinderAdapter.eventProcessor.triggerEvent("navigate", "onSETTINGS_REQ_CALIBRATION_SUCCESS", null, "SettingsPopupActivity", true)
                            }
                        }
                    }
                }
                return true
            }
        })
    }


    @BindingAdapter("bind:layoutAnim")
    fun layout(view: View, value: Int) {
        when (value) {
            1 -> {
                val loadAnimation = AnimationUtils.loadAnimation(GMSettingsApp.appContext, R.anim.bottom_down)
                view.startAnimation(loadAnimation)
                view.visibility = View.INVISIBLE
            }
            2 -> {
                val loadAnimation = AnimationUtils.loadAnimation(GMSettingsApp.appContext, R.anim.bottom_up)
                view.startAnimation(loadAnimation)
                view.visibility = View.VISIBLE
            }
            else -> {
                view.visibility = View.VISIBLE
            }
        }
    }

    @BindingAdapter("bind:layoutShow")
    fun layoutShow(view: View, value: Int) {
        view.setOnClickListener {
            dataPoolDataHandler.LAYOUT_ANIM.set(value)
            object : CountDownTimer(15000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                }

                override fun onFinish() {
                    dataPoolDataHandler.LAYOUT_ANIM.set(Constants.BOTTOM_BAR_HIDE)
                }
            }.start()
        }
    }


}












