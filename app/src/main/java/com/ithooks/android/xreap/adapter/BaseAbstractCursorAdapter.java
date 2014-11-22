package com.ithooks.android.xreap.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:52
 * Description: ListView/GridView Cursor Adapter 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseAbstractCursorAdapter extends CursorAdapter {
    protected final Context mContext;
    protected final LayoutInflater mLayoutInflater;

    public BaseAbstractCursorAdapter(Context context, Cursor c) {
        this(context, c, false);
    }

    public BaseAbstractCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public int getTotalCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup parent);

    public abstract void bindView(View view, Context context, Cursor cursor);
}
