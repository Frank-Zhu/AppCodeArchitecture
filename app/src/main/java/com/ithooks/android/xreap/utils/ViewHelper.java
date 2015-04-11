package com.ithooks.android.xreap.utils;

import android.view.View;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:35
 * Description: View 帮助类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class ViewHelper {
    /**
     * 设置View 是否显示
     *
     * @param view   需要设置的View对象
     * @param isGone 是否隐藏
     * @param <V>    V
     * @return V 当前View
     */
    public static <V extends View> V setGone(V view, boolean isGone) {
        if (view != null) {
            if (isGone) {
                if (View.GONE != view.getVisibility())
                    view.setVisibility(View.GONE);
            } else {
                if (View.VISIBLE != view.getVisibility())
                    view.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }

    /**
     * 多个view隐藏或显示
     *
     * @param gone  true 隐藏；false 显示
     * @param views 多个view对象
     */
    public static void setViewsGone(boolean gone, View... views) {
        for (View view : views) {
            setGone(view, gone);
        }
    }
}
