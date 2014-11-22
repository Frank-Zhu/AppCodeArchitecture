package com.ithooks.android.xreap.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 16:47
 * Description: 默认全部展开的ListView
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class FullyExpandedListView extends ListView {
    public FullyExpandedListView(Context context) {
        super(context);
    }

    public FullyExpandedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullyExpandedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
