package com.parkifast.mymappi.myapisdk.logger;

import com.parkifast.mymappi.myapisdk.BuildConfig;

public class Log {

    public static final boolean ENABLE_LOG = true & BuildConfig.DEBUG;

    private static final boolean DEBUG = true & ENABLE_LOG;

    private static final boolean VERBOSE = true & ENABLE_LOG;

    private static final boolean TEMP = true & ENABLE_LOG;

    private static final boolean WARNING = true & ENABLE_LOG;

    private static final boolean INFO = true & ENABLE_LOG;

    private static final boolean ERROR = true & ENABLE_LOG;

    public static void obvious(String tag, String msg) {
        if (DEBUG) {
            msg = "*********************************\n" + msg
                    + "\n*********************************";
            android.util.Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG)
            android.util.Log.d(tag, msg);
    }

    public static void d(boolean bool, String tag, String msg) {
        if (TEMP&bool)
            android.util.Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (INFO)
            android.util.Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (ERROR)
            android.util.Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable t) {
        if (TEMP)
            android.util.Log.e(tag, msg, t);
    }

    public static void v(String tag, String msg) {
        if (VERBOSE)
            android.util.Log.v(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (WARNING)
            android.util.Log.w(tag, msg);
    }

    public static String getStackTraceString(Exception e) {
        return android.util.Log.getStackTraceString(e);
    }

    public static void w(String tag, String msg, Exception e) {
        if (WARNING)
            android.util.Log.w(tag, msg,e);
    }
}