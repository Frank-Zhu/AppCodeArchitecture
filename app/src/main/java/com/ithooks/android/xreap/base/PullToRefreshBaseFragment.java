package com.ithooks.android.xreap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ithooks.android.xreap.R;
import com.ithooks.android.xreap.view.PageListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 16:33
 * Description: PullToRefreshList Fragment 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class PullToRefreshBaseFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeContainer;
    @InjectView(R.id.page_list_view)
    PageListView mPageListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pull_to_refresh_base_view, container, false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutResId() {
        return 0;//不调用父类布局，所以返回0
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeContainer.setOnRefreshListener(this);
        mSwipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
}
