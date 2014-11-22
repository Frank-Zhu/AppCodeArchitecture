package com.ithooks.android.xreap.utils;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:34
 * Description: 弹出信息工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class ToastHelper {
    public static void showInfo(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_INFO).show();
    }

    public static void showInfo(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_INFO).show();
    }

    public static void showBottomInfo(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_INFO).setLayoutGravity(Gravity.BOTTOM).show();
    }

    public static void showBottomInfo(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_INFO).setLayoutGravity(Gravity.BOTTOM).show();
    }

    public static void showAlert(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_ALERT).show();
    }

    public static void showAlert(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_ALERT).show();
    }

    public static void showBottomAlert(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_ALERT).setLayoutGravity(Gravity.BOTTOM).show();
    }

    public static void showBottomAlert(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_ALERT).setLayoutGravity(Gravity.BOTTOM).show();
    }

    public static void showConfirm(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_CONFIRM).show();
    }

    public static void showConfirm(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_CONFIRM).show();
    }

    public static void showBottomConfirm(Activity context, String msg) {
        AppMsg.makeText(context, msg, AppMsg.STYLE_CONFIRM).setLayoutGravity(Gravity.BOTTOM).show();
    }

    public static void showBottomConfirm(Activity context, int resId) {
        AppMsg.makeText(context, resId, AppMsg.STYLE_CONFIRM).setLayoutGravity(Gravity.BOTTOM).show();
    }


    public static void showMsg(Activity context, String msg, AppMsg.Style style) {
        AppMsg.makeText(context, msg, style).show();
    }

    public static void showMsg(Activity context, int resId, AppMsg.Style style) {
        AppMsg.makeText(context, resId, style).show();
    }

    public static void showMsg(Activity context, String msg, AppMsg.Style style, int gravity) {
        AppMsg.makeText(context, msg, style).setLayoutGravity(gravity).show();
    }

    public static void showMsg(Activity context, int resId, AppMsg.Style style, int gravity) {
        AppMsg.makeText(context, resId, style).setLayoutGravity(gravity).show();
    }
}
