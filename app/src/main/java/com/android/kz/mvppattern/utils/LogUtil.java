package com.android.kz.mvppattern.utils;

import android.util.Log;

import com.android.kz.mvppattern.BuildConfig;


/**
 * User: kzhou
 * Date: 29/04/2015
 * Time: 4:24 PM
 */
public class LogUtil {
    public static final boolean IS_DEBUG = BuildConfig.SHOW_DEBUG_LOG;
    public static final String LOG_TAG = "*** MVP Debug ***";

    public static void v(String message) {
        if (IS_DEBUG) {
            Log.v(LOG_TAG, message);
        }
    }

    public static void i(String message) {
        if (IS_DEBUG) {
            Log.i(LOG_TAG, message);
        }
    }

    public static void d(String message) {
        if (IS_DEBUG) {
            Log.d(LOG_TAG, message);
        }
    }

    public static void e(String message) {
        if (IS_DEBUG) {
            Log.e(LOG_TAG, message);
        }
    }

    public static void w(String message) {
        if (IS_DEBUG) {
            Log.w(LOG_TAG, message);
        }
    }
}
