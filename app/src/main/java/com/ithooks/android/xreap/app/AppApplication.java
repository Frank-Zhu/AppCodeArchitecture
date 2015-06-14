package com.ithooks.android.xreap.app;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.ithooks.android.xreap.BuildConfig;
import com.ithooks.android.xreap.network.http.AppApiService;
import com.ithooks.android.xreap.utils.SharedPreferencesHelper;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 13:30
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class AppApplication extends MultiDexApplication {
    private static Context sContext;
    private static AppApiService sAppApiService;//API 请求Service对象

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        setUpSharedPreferencesHelper(getApplicationContext());//初始化SharedPreferences
        setUpApiService();//初始化APP API
    }

    private void setUpApiService() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.API_HOST)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .build();
        sAppApiService = restAdapter.create(AppApiService.class);
    }

    /**
     * 初始化SharedPreferences
     *
     * @param context 上下文
     */
    private void setUpSharedPreferencesHelper(Context context) {
        SharedPreferencesHelper.getInstance().Builder(context);
    }

    public static Context getContext() {
        return sContext;
    }

    public static AppApplication getInstance() {
        return (AppApplication) sContext;
    }

    public static AppApiService getAppApiService() {
        return sAppApiService;
    }
}
