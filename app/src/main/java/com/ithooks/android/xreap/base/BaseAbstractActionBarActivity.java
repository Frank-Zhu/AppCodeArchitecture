package com.ithooks.android.xreap.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ithooks.android.xreap.R;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 15:13
 * Description: Fragment Activity 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseAbstractActionBarActivity extends BaseActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_base);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, getFragment())
                    .commit();
        }
    }

    public abstract Fragment getFragment();
}
