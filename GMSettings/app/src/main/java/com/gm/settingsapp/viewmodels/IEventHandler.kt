package com.gm.settingsapp.viewmodels

import android.view.KeyEvent
import android.view.View

interface IEventHandler {

    /**
     * To handle the click events.
     * @param view View, passing which type of view has to perform.
     */
    fun onClickHandler(view: View)

    /**
     * To handle the click events.
     * @param view View, passing which type of view has to perform.
     * @param any  additional data that is passed.
     */
    fun onClickHandler(view: View, any: Any)

    /**
     * To handle keypad events
     * @param keyCode passing keycode
     * @param event is KeyEvent,passing key event.
     */
    fun onKeyHandler(keyCode: Int, event: KeyEvent?)

    /**
     * To handle voice control commands.
     * @param voiceControlCommands passing voice commands.

     */
    fun onVoiceHandler(vararg voiceControlCommands: String)

    /**
     * To handle remote control commands.
     * @param remoteControlCommands passing remote commands.

     */
    fun onRemoteHandler(remoteControlCommands: String)

    /**
     * To handle the List Item click events.
     * @param view View, passing which type of view has to perform.
     * @param any  additional data that is passed.
     */
    fun onItemClickHandler(view:View,obj:Any)

    /**
     * To handle the List Item click events.
     * @param view View, passing which type of view has to perform.
     */
    fun onItemClickHandler(view:View)
    /**
     * To handle the click events.
     * @param view View, passing which type of view has to perform.
     * @param state  additional data that is passed.
     */
    fun onClickHandler(view: View,state:Boolean)
    /**
     * To handle the click events.
     * @param view View, passing which type of view has to perform.
     * @param position  additional data that is passed.
     */
    fun onClickHandler(view:View,obj:Any,position: Int)
}