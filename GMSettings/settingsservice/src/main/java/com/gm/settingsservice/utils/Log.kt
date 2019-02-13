package com.gm.settingsservice.utils

import com.gm.settingsservice.BuildConfig


/**
 * Methods to display different type of Logs
 */

class Log {
    companion object {

        private var COMMON_PREFIX = "[#GMSettings#]"
        private var isLogsEnable = BuildConfig.isDebug

        // ======= DEBUG =============================
        /**
         * To display Debug Log
         * @param tag String to display and to differentiate other logs
         * @param msg data to be displayed
         * @param args
         */
        fun d(tag: String?, msg: String, vararg args: Any) {
            if (isLogsEnable) {
                val sb = StringBuffer()
                if (args != null) {
                    for (i in args.indices) {
                        sb.append(args[i])
                    }
                }
                android.util.Log.d(tag, COMMON_PREFIX +" " + msg + " " + sb.toString())
            }
        }

        // ======= ERROR =============================
        /**
         * To display error Log
         * @param tag String to display and to differentiate other logs
         * @param msg data to be displayed
         * @param args
         */
        fun e(tag: String?, msg: String, vararg args: Any) {
            if (isLogsEnable) {
                val sb = StringBuffer()
                if (args != null) {
                    for (i in args.indices) {
                        sb.append(args[i])
                    }
                }
                android.util.Log.e(tag, COMMON_PREFIX +" " +msg + " " + sb.toString())
            }
        }

        // ======= INFORMATION =============================

        /**
         * To display information Log
         * @param tag String to display and to differentiate other logs
         * @param msg data to be displayed
         * @param args
         */
        fun i(tag: String?, msg: String, vararg args: Any) {
            if (isLogsEnable) {
                val sb = StringBuffer()
                if (args != null) {
                    for (i in args.indices) {
                        sb.append(args[i])
                    }
                }
                android.util.Log.i(tag, COMMON_PREFIX +" " +msg + " " + sb.toString())
            }
        }

        // ======= VERBOSE =============================
        /**
         * To display Verbose Log
         * @param tag String to display and to differentiate other logs
         * @param msg data to be displayed
         * @param args
         */
        fun v(tag: String?, msg: String, vararg args: Any) {
            if (isLogsEnable) {
                val sb = StringBuffer()
                if (args != null) {
                    for (i in args.indices) {
                        sb.append(args[i])
                    }
                }
                android.util.Log.v(tag, COMMON_PREFIX +" " +msg + " " + sb.toString())
            }
        }

        // ======= WARNING =============================
        /**
         * To display Warning Log
         * @param tag String to display and to differentiate other logs
         * @param msg data to be displayed
         * @param args
         */
        fun w(tag: String?, msg: String, vararg args: Any) {
            if (isLogsEnable) {
                val sb = StringBuffer()
                if (args != null) {
                    for (i in args.indices) {
                        sb.append(args[i])
                    }
                }
                android.util.Log.w(tag, COMMON_PREFIX +" " +msg + " " + sb.toString())
            }
        }
    }
}