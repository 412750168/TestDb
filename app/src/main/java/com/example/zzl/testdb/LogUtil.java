package com.example.zzl.testdb;

import android.util.Log;

/**
 * Created by zzl on 16/8/26.
 */
public class LogUtil {

    private static final String TAG = "zzl:::";
    public static void LogDebug(Class className,String str){

        Log.d(TAG,className.getName()+"::"+ str);
    }
}
