package com.gm.settingsapp.ui.activities

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.R
import com.gm.settingsapp.databinding.SettingsContainerBinding
import com.gm.settingsapp.ui.adapters.BinderDataBindingComponent
import com.gm.settingsapp.utils.SubUtility.updateResources
import com.gm.settingsapp.utils.Utility
import com.gm.settingsapp.viewmodels.Constants
import com.gm.settingsapp.viewmodels.EventHandler
import com.gm.settingsapp.viewmodels.EventProcessor
import com.gm.settingsservice.models.DataPoolDataHandler
import com.gm.settingsservice.models.SETTINGS_CURRENT_HOME_PAGE
import com.gm.settingsservice.models.eLHD_RHD_RTL
import com.gm.settingsapp.utils.SubUtility.setLocale
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.ics_settings_container.view.*
import javax.inject.Inject

/**
 *This is abstract BaseActivity super class for all the Activity classes
 */
abstract class BaseActivity : AppCompatActivity(), EventResponseHandler {
    private var root_container: ViewGroup? = null


    @Inject
    lateinit var dataPoolDataHandler: DataPoolDataHandler
    @Inject
    lateinit var eventHandler: EventHandler

    @Inject
    lateinit var eventProcessor: EventProcessor

    @Inject
    lateinit var serviceUtility: com.gm.settingsservice.utils.Utility

    @Inject
    lateinit var utility: Utility
    lateinit var dataBindingComponent: DataBindingComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        dataBindingComponent = BinderDataBindingComponent(eventHandler, eventProcessor,utility,serviceUtility,dataPoolDataHandler)
        updateConfigurationData()
        utility.isCadillac(this,dataPoolDataHandler)
        val binding = DataBindingUtil.setContentView<SettingsContainerBinding>(this, R.layout.ics_settings_container,dataBindingComponent)

        binding.let {
            it?.clickHandler = eventHandler
            it?.dataPoolHandler = dataPoolDataHandler
        }
        root_container = binding.root.root_container
        setImmersiveSticky()
        appContext.activityContext = this // Set the current child activity reference
        val decorView = window.decorView
        decorView.setOnSystemUiVisibilityChangeListener { setImmersiveSticky() }


    }


    override fun onResume() {
        super.onResume()
        setImmersiveSticky()
        when (dataPoolDataHandler.themeType.get()) {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }
        appContext.activityContext = this // Set the current child activity reference (in case an activity as dialog is displayed)
        eventHandler.registerEventListener(this)
        if (Constants.SUBMIT_BUTTON_STATE!!) {
            Constants.SUBMIT_BUTTON_STATE = false
            //recreate()
            val intent = Intent(this, SettingsHomeActivity::class.java)
            startActivity(intent)
        }
        hideBottomBar()
    }

     fun headerTitle(title: String) {
        dataPoolDataHandler.SETTINGS_HEADERTITLE_NAME.set(title)

    }

    private fun hideBottomBar() {
        dataPoolDataHandler.LAYOUT_ANIM.set(Constants.BOTTOM_BAR_HIDE)
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(setLocale(base))
    }

    /**
     * Set this activity in full screen mode.
     */
    private fun setImmersiveSticky() {
        val decorView = window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }


    private fun updateConfigurationData() {
        when (utility.getLanguageConfig(GMSettingsApp.appContext)) {
            "en" -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.LHD)
                dataPoolDataHandler.LHD_RHD_RTL.set(eLHD_RHD_RTL.LHD)
                if (utility.getLanguage(GMSettingsApp.appContext).equals("en")) {
                    updateResources(this, "en")
                } else {
                    updateResources(this, utility.getLanguage(GMSettingsApp.appContext))
                }
                window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
            }
            "uk" -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.RHD)
                dataPoolDataHandler.LHD_RHD_RTL.set(eLHD_RHD_RTL.RHD)
                updateResources(this, "uk")

            }
            "ar" -> {
                dataPoolDataHandler.layoutDirectionRadioBtnState.set(eLHD_RHD_RTL.RTL)
                dataPoolDataHandler.LHD_RHD_RTL.set(eLHD_RHD_RTL.RTL)
                updateResources(this, "ar")
                window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
            }
        }
        val skewState = utility.getSkewState(appContext)
        if (skewState) {
            dataPoolDataHandler.isSkewEnabled.set(true)
            dataPoolDataHandler.skewRadioButtonState.set(true)
            dataPoolDataHandler.SKEW_MAIN_ANGLE_8.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_8).toFloat())
            dataPoolDataHandler.SKEW_ANGLE_9.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_9).toFloat())
            dataPoolDataHandler.SKEW_ANGLE_15.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_15).toFloat())
        } else {
            dataPoolDataHandler.isSkewEnabled.set(false)
            dataPoolDataHandler.skewRadioButtonState.set(false)
            dataPoolDataHandler.SKEW_ANGLE_9.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_0).toFloat())
            dataPoolDataHandler.SKEW_ANGLE_15.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_0).toFloat())
        }
        dataPoolDataHandler.SKEW_ANGLE_8.set(appContext.resources.getInteger(R.integer.sloped_angle_skew_0).toFloat())
    }

    protected fun setContentSubView(layoutId: Int): ViewDataBinding {
        val inflater = LayoutInflater.from(this)
        return DataBindingUtil.inflate(inflater, layoutId, root_container, true,dataBindingComponent)
    }

    fun ReplaceFragment(layoutId: Int, fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(layoutId, fragment)
                .addToBackStack(null)
                .commit()
    }

    lateinit var adbIntentEvent: String

    /** * Listen to new intent and its extras. */
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        when {
            intent?.hasExtra("action")!! && intent.hasExtra("extra") -> {
                adbIntentEvent = intent.getStringExtra("action")!!
                val bundle = intent.extras!!
                val extra = bundle.get("extra")!!
                eventHandler.processEventByTag(adbIntentEvent, extra)
            }
            intent.hasExtra("action") -> {
                adbIntentEvent = intent.getStringExtra("action")!!
                eventHandler.processEventByTag(adbIntentEvent)
            }
            intent.hasExtra("tabIndex") -> {
                val position = intent.getIntExtra("tabIndex", 0)
                dataPoolDataHandler.homeScreenData.get()!!.currentHomePage = SETTINGS_CURRENT_HOME_PAGE.values()[position]
                dataPoolDataHandler.homeScreenData.notifyChange()
            }
            intent.hasExtra("screenShot") -> {
                adbIntentEvent = intent.getStringExtra("screenShot")!!
                // Check if write permissions are granted
                if (ActivityCompat.checkSelfPermission(this@BaseActivity,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    utility.captureScreen(adbIntentEvent)
                } else {
                    verifyStoragePermissions(this@BaseActivity)
                }
            }
        }


        /*when (true) {
            intent?.hasExtra("action")!! -> {
                adbIntentEvent = intent.getStringExtra("action")!!
                EventHandler.processEventByTag(adbIntentEvent)
            }
            intent.hasExtra("screenShot") -> {
                adbIntentEvent = intent.getStringExtra("screenShot")!!
                // Check if write permissions are granted
                if (ActivityCompat.checkSelfPermission(this@BaseActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Utility.captureScreen(adbIntentEvent)
                } else {
                    verifyStoragePermissions(this@BaseActivity)
                }
            }
        }*/
    }

    val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    /**
     * Checks if the app has permission to write to device storage *
     * If the app does not has permission then the user will be prompted to grant permissions *
     * @param activity Activity context */
    private fun verifyStoragePermissions(activity: Activity) {
        // Check if we have write permission
        val permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_EXTERNAL_STORAGE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Log.i(BaseActivity::class.java.simpleName, "Write permission granted")
                }
            }
        }

    }


}