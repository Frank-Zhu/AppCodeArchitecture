package com.ithooks.android.xreap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ithooks.android.xreap.R;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import butterknife.InjectView;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/12/30  15:28.
 * Description: RecycleRefresh 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/12/30        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class RecycleRefreshBaseFragment extends BaseFragment {
    @InjectView(R.id.recycle_view)
    protected SuperRecyclerView mRecycleView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recycle_refresh_base;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecycleView();
    }

    private void setUpRecycleView() {
        mRecycleView.setRefreshingColorResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mRecycleView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onDataRefresh();
            }
        });
        mRecycleView.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int numberOfItems, int numberBeforeMore, int currentItemPos) {
                onDataMore();
            }
        });
    }

    public abstract void onDataRefresh();

    public abstract void onDataMore();
}
