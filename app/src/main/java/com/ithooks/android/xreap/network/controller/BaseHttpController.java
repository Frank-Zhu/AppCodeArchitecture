package com.ithooks.android.xreap.network.controller;

import com.ithooks.android.xreap.app.AppApplication;
import com.ithooks.android.xreap.network.AppNetworkInfo;
import com.ithooks.android.xreap.network.callback.UiDisplayListener;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 13:28
 * Description:网络请求控制类父类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseHttpController<T> {
    protected UiDisplayListener<T> uiDisplayListener;

    public BaseHttpController() {
    }

    public BaseHttpController(UiDisplayListener<T> uiDisplayListener) {
        this.uiDisplayListener = uiDisplayListener;
    }

    public void setUiDisplayListener(UiDisplayListener<T> uiDisplayListener) {
        this.uiDisplayListener = uiDisplayListener;
    }

    public void loadData() {
        if (AppNetworkInfo.isNetworkAvailable(AppApplication.getContext())) {//没有网络时直接调用失败接口
            getNetData();
        } else {
            if (uiDisplayListener != null) {
                uiDisplayListener.onFailDisplay();
            }
        }
    }

    /**
     * 获取网络数据
     */
    protected abstract void getNetData();
}
