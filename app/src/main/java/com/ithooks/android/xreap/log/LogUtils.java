package com.ithooks.android.xreap.log;

import com.ithooks.android.xreap.BuildConfig;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:09
 * Description:Log 控制工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class LogUtils {
    public static void v(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.v(tag, msg, tr);
        }
    }

    public static void d(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.d(tag, msg, tr);
        }
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.i(tag, msg, tr);
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.w(tag, msg, tr);
        }
    }

    public static void w(String tag, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.w(tag, tr);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.e(tag, msg, tr);
        }
    }

    public static void e(String tag, String msg) {
        if (BuildConfig.LOG_DEBUG) {
            android.util.Log.e(tag, msg);
        }
    }
}
