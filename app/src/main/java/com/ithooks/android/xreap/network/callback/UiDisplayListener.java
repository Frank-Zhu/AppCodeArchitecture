package com.ithooks.android.xreap.network.callback;

import retrofit.RetrofitError;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 15:06
 * Description: HTTP 请求刷新UI回调接口
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public interface UiDisplayListener<T> {
    /**
     * HTTP请求成功回调
     *
     * @param data GSON解析之后的数据model
     */
    public void onSuccessDisplay(T data);

    /**
     * HTTP请求失败回调
     */
    public void onFailDisplay(RetrofitError retrofitError);
}
