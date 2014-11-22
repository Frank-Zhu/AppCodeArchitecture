package com.ithooks.android.xreap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:49
 * Description: ListView/GridView Adapter 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseAbstractAdapter<T> extends BaseAdapter {
    protected final Context mContext;
    protected final LayoutInflater mLayoutInflater;
    protected List<T> mListData;

    public BaseAbstractAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setListData(List<T> mListData) {
        this.mListData = mListData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mListData == null ? 0 : mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData == null ? null : mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract View getView(int position, View convertView, ViewGroup viewGroup);
}
