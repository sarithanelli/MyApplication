package com.gm.settingsapp.ui.navigator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.gm.settingsapp.ui.activities.BaseActivity
import com.gm.settingsapp.ui.activities.fragments.BaseFragment

/**
 * This class provides interface for screen navigation . It can start new screen or can replace old
 * screen with new screen in same container.
 * It also closes the visible screen
 */
interface Navigator {

    /**
    It finishes the current activity
     */
    fun finishActivity()

    /**
    It recreate the current activity
     */
    fun recreateActivity()

    /**
     * Launches new Activity
     *
     * @param intent intent to start
     */

    fun startActivity(intent: Intent)

    /**
     * Launches new Activity
     *
     * @param action intent action to start
     */
    fun startActivity(action: String)

    /**
     * Launches new Activity
     *
     * @param action intent action to start
     * @param args additional data passed to the new activity
     */
    fun startActivity(action: String, args: Bundle)

    /**
     * Launches new Activity
     *
     * @param action intent action to start
     * @param uri uri passed to the new activity
     */
    fun startActivity(action: String, uri: Uri)

    /**
     * Launches new Activity
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     */
    fun startActivity(activityClass: Class<out BaseActivity>)

    /**
     * Launches new Activity
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     */
    fun startActivity(activityClass: Class<out BaseActivity>, args: Bundle)

    /**
     * Launches new Activity
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     */
    fun startActivity(activityClass: Class<out BaseActivity>, args: Parcelable)

    /**
     * Launches new Activity
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     */
    fun startActivity(activityClass: Class<out BaseActivity>, arg: String)

    /**
     * Launches new Activity
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data that is passed to the new activity
     */
    fun startActivity(activityClass: Class<out BaseActivity>, arg: Int)

    /**
     * Launches new Activity. New activity returns data when it is closed
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param requestCode code to be returned in onActivityResult when new activity exits.
     * */
    fun startActivityForResult(activityClass: Class<out BaseActivity>, requestCode: Int)

    /**
     * Launches new Activity. New activity returns data when it exits
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     * @param requestCode code to be returned in onActivityResult when new activity exits.
     * */
    fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: Parcelable, requestCode: Int)

    /**
     * Launches new Activity. New activity returns data when it exits
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     * @param requestCode code to be returned in onActivityResult when new activity exits.
     * */
    fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: String, requestCode: Int)

    /**
     * Launches new Activity. New activity returns data when it exits
     *
     * @param activityClass compiled class of BaseActivity and its Derivation to be launched
     * @param args additional data passed to the new activity
     * @param requestCode code to be returned in onActivityResult when new activity exits.
     * */
    fun startActivityForResult(activityClass: Class<out BaseActivity>, arg: Int, requestCode: Int)

    /**
     * Replaces the given fragment in the given container
     *
     * @param containerId container in which fragment is added/replaced
     * @param fragment fragment to be added/replaced
     * @param args additional data that is passed to the fragment
     */
    fun replaceFragment(@IdRes containerId: Int, fragment: BaseFragment, args: Bundle)

    /**
     * Replaces the given fragment in the given container
     *
     * @param containerId container in which fragment is added/replaced
     * @param fragment fragment to be added/replaced
     * @param fragmentTag used to identify the fragment transaction
     * @param args additional data that is passed to the fragment
     */
    fun replaceFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String, args: Bundle)

    /**
     * Replaces the given fragment in the given container and also adds to the backStack
     *
     * @param containerId container in which fragment is added/replaced
     * @param fragment fragment to be added/replaced
     * @param args additional data that is passed to the fragment
     * @param backstackTag optional name for this backstack or null
     */
    fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, args: Bundle,
                                         backstackTag: String)

    /**
     * Replaces the given fragment in the given container and also adds to the backStack
     *
     * @param containerId container in which fragment is added/replaced
     * @param fragment fragment to be added/replaced
     * @param fragmentTag used to identify the fragment transaction
     * @param args additional data passed to the fragment
     * @param backstackTag optional name for this backstack or null
     */
    fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag:
    String, args: Bundle, backstackTag: String)


    /**
     * Back navigation  functionality for both fragment and activity
     */
    fun backNavigation()

}
