package com.ithooks.android.xreap.network.callback;

import com.ithooks.android.xreap.log.LogUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:55
 * Description: Http 数据请求 CallBack
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class HttpBaseCallBack<T> implements Callback<T> {
    protected String TAG = HttpBaseCallBack.class.getSimpleName();

    @Override
    public void success(T data, Response response) {
        LogUtils.d(TAG, "success--> url = " + response.getUrl());
    }

    @Override
    public void failure(RetrofitError retrofitError) {
        LogUtils.e(TAG, "failure--> url = " + retrofitError.getUrl());
        retrofitError.printStackTrace();
    }
}