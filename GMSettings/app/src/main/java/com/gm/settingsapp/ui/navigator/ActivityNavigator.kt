package com.gm.settingsapp.ui.navigator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.gm.settingsapp.GMSettingsApp
import com.gm.settingsapp.GMSettingsApp.Companion.appContext
import com.gm.settingsapp.ui.activities.BaseActivity
import com.gm.settingsapp.ui.activities.fragments.BaseFragment


/**
 * Class used for navigating to other Activity or fragment
 */
open class ActivityNavigator : Navigator {

    private val fragmentArgKey = "fragmentName"

    /**
     * starts activity corresponding to given eventName
     *
     * @param eventName it identifies the activity in 'eventTable' table
     * @param any  additional data that is passed to the activity
     */
    fun triggerActivity(eventName: String, any: Any?) {
        startActivity(ScreenMapper.activityEventTable[eventName]!!, Bundle())
    }

    /**
     * add/replaces fragment corresponding to given eventName
     *
     * @param eventName it identifies the fragment in 'eventFragmentTable' table
     * @param any  additional data that is passed to the fragment
     */
    fun triggerFragment(eventName: String, any: Any?) {
        val fragmentName = ScreenMapper.fragmentEventTable[eventName]
        val fragment: BaseFragment = androidx.fragment.app.Fragment.instantiate(appContext.activityContext, fragmentName) as BaseFragment
        val args = Bundle()
        args.putString(fragmentArgKey, eventName)
        replaceFragment(fragment.getContainerId(), fragment, args)
    }

    //clear all the history of fragments
    fun clearBackStack() {
        for (i in 0 until appContext.activityContext.supportFragmentManager.backStackEntryCount) {
            appContext.activityContext.supportFragmentManager.popBackStack()
        }
    }

    override fun finishActivity() {
        appContext.activityContext.finish()
    }

    override fun recreateActivity() {
    }

    override fun startActivity(intent: Intent) {
        appContext.activityContext.startActivity(intent)
    }

    override fun startActivity(action: String) {
        val intent = Intent(action)
        startActivity(intent)
    }

    override fun startActivity(action: String, uri: Uri) {}

    override fun startActivity(action: String, args: Bundle) {
        val intent = Intent(action)
        intent.putExtras(args)
        startActivity(intent)
    }

    override fun startActivity(activityClass: Class<out BaseActivity>) {
        startActivity(Intent(appContext.activityContext, activityClass))
    }

    override fun startActivity(activityClass: Class<out BaseActivity>, args: Bundle) {}

    override fun startActivity(activityClass: Class<out BaseActivity>, args: Parcelable) {}

    override fun startActivity(activityClass: Class<out BaseActivity>, arg: String) {}

    override fun startActivity(activityClass: Class<out BaseActivity>, arg: Int) {}

    override fun startActivityForResult(activityClass: Class<out BaseActivity>, requestCode: Int) {}


    override fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: Parcelable,
                                        requestCode: Int) {
    }

    override fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: String,
                                        requestCode: Int) {
    }

    override fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: Int,
                                        requestCode: Int) {
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: BaseFragment, args: Bundle) {
        appContext.activityContext.supportFragmentManager.beginTransaction()
                .replace(containerId, fragment, args.getString(fragmentArgKey)).addToBackStack(null).commit()
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String,
                                 args: Bundle) {
    }

    override fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment,
                                                  args: Bundle, backstackTag: String) {
    }

    override fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment,
                                                  fragmentTag: String, args: Bundle,
                                                  backstackTag: String) {
    }


    override fun backNavigation() {
        if (appContext.activityContext.supportFragmentManager.getBackStackEntryCount() > 1){
            appContext.activityContext.supportFragmentManager.popBackStack()
        }else{
            GMSettingsApp.navigator.finishActivity()
        }
    }
}
