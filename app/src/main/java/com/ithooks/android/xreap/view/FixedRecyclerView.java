package com.ithooks.android.xreap.view;

import android.content.Context;
import android.util.AttributeSet;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-12-14 23:48
 * Description: fixed RecyclerView and SwipeRefreshLayout BUG
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-12-14      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class FixedRecyclerView extends ObservableRecyclerView {
    public FixedRecyclerView(Context context) {
        this(context, null);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        if (direction < 1) {
            boolean original = super.canScrollVertically(direction);
            return !original && getChildAt(0) != null && getChildAt(0).getTop() < 0 || original;
        }
        return super.canScrollVertically(direction);
    }
}