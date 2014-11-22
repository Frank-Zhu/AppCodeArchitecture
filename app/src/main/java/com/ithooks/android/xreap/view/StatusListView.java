package com.ithooks.android.xreap.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ithooks.android.xreap.R;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 16:41
 * Description: 不同状态的自定义ListView empty / loading / error
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class StatusListView extends ListView {
    private static final String VIEW_TAG = "tag";
    private LayoutInflater mLayoutInflater;
    private View mLoadingView;
    private View mEmptyView;
    private View mErrorView;
    private TextView mEmptyMsgView;
    private Button mEmptyButton;
    private TextView mErrorMsgView;
    private Button mErrorButton;
    private boolean isInitViews = true;
    private boolean isInvalidateView;

    public StatusListView(Context context) {
        this(context, null);
    }

    public StatusListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            //初始化状态View
            mLayoutInflater = LayoutInflater.from(getContext());

            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StatusListView);

            int loadingViewResId = a.getResourceId(R.styleable.StatusListView_loadingView, 0);
            if (loadingViewResId > 0) {
                mLoadingView = mLayoutInflater.inflate(loadingViewResId, null);
            }

            int emptyViewResId = a.getResourceId(R.styleable.StatusListView_emptyView, 0);
            if (emptyViewResId > 0) {
                mEmptyView = mLayoutInflater.inflate(emptyViewResId, null);
                mEmptyMsgView = (TextView) mEmptyView.findViewById(R.id.tv_list_empty);
                mEmptyButton = (Button) mEmptyView.findViewById(R.id.btn_list_empty);
            }

            int errorViewResId = a.getResourceId(R.styleable.StatusListView_errorView, 0);
            if (errorViewResId > 0) {
                mErrorView = mLayoutInflater.inflate(errorViewResId, null);
                mErrorMsgView = (TextView) mErrorView.findViewById(R.id.tv_list_error);
                mErrorButton = (Button) mErrorView.findViewById(R.id.btn_list_error);
            }
            a.recycle();
        }
    }

    public static class Builder {

        private Context mContext;
        private LayoutInflater mLayoutInflater;

        private View mLoadingView;
        private View mEmptyView;
        private View mErrorView;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        public Builder loadingView(View view) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mLoadingView = view;
            return this;
        }

        public Builder loadingView(View view, OnClickListener clickListener) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mLoadingView = view;
            mLoadingView.setOnClickListener(clickListener);
            return this;
        }

        public Builder loadingView(int resId) {
            if (resId <= 0) {
                throw new IllegalArgumentException("View resource id must be greater than 0.");
            }
            mLoadingView = mLayoutInflater.inflate(resId, null);
            return this;
        }

        public Builder emptyView(View view) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mEmptyView = view;
            return this;
        }

        public Builder emptyView(View view, OnClickListener clickListener) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mEmptyView = view;
            mEmptyView.setOnClickListener(clickListener);
            return this;
        }

        public Builder emptyView(int resId) {
            if (resId <= 0) {
                throw new IllegalArgumentException("View resource id must be greater than 0.");
            }
            mEmptyView = mLayoutInflater.inflate(resId, null);
            return this;
        }

        public Builder errorView(View view) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mErrorView = view;
            return this;
        }

        public Builder errorView(View view, OnClickListener clickListener) {
            if (view == null) {
                throw new IllegalArgumentException("View must not be null.");
            }
            mErrorView = view;
            mErrorView.setOnClickListener(clickListener);
            return this;
        }

        public Builder errorView(int resId) {
            if (resId <= 0) {
                throw new IllegalArgumentException("View resource id must be greater than 0.");
            }
            mErrorView = mLayoutInflater.inflate(resId, null);
            return this;
        }

        public StatusListView build() {
            return new StatusListView(mContext);
        }
    }

    //================================================================================
    // Getters
    //================================================================================

    public View getLoadingView() {
        return mLoadingView;
    }

    @Override
    public View getEmptyView() {
        return mEmptyView;
    }

    public View getErrorView() {
        return mErrorView;
    }

    public TextView getEmptyTextView() {
        return mEmptyMsgView;
    }

    public TextView getErrorTextView() {
        return mErrorMsgView;
    }
    //================================================================================
    // Setters
    //================================================================================

    public void setLoadingView(View view) {
        setLoadingView(view, false);
    }

    public void setLoadingView(View view, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mLoadingView = view;
        isInvalidateView = invalidateView;
    }

    public void setLoadingView(int resId) {
        setLoadingView(resId, false);
    }

    public void setLoadingView(int resId, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mLoadingView = mLayoutInflater.inflate(resId, null);
        isInvalidateView = invalidateView;
    }

    public void setLoadingView(View view, OnClickListener clickListener) {
        setLoadingView(view, clickListener, false);
    }

    public void setLoadingView(View view, OnClickListener clickListener, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mLoadingView = view;
        mLoadingView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setLoadingView(int resId, OnClickListener clickListener) {
        setLoadingView(resId, clickListener, false);
    }

    public void setLoadingView(int resId, OnClickListener clickListener, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mLoadingView = mLayoutInflater.inflate(resId, null);
        mLoadingView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setLoadingViewClickListener(OnClickListener clickListener) {
        if (mLoadingView == null) {
            throw new IllegalStateException("Loading view is null. Cannot set click listener.");
        }
        mLoadingView.setOnClickListener(clickListener);
    }

    @Override
    public void setEmptyView(View view) {
        setEmptyView(view, false);
    }

    public void setEmptyView(View view, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mEmptyView = view;
        isInvalidateView = invalidateView;
    }

    public void setEmptyView(int resId) {
        setEmptyView(resId, false);
    }

    public void setEmptyView(int resId, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mEmptyView = mLayoutInflater.inflate(resId, null);
        isInvalidateView = invalidateView;
    }

    public void setEmptyView(View view, OnClickListener clickListener) {
        setEmptyView(view, clickListener, false);
    }

    public void setEmptyView(View view, OnClickListener clickListener, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mEmptyView = view;
        mEmptyView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setEmptyView(int resId, OnClickListener clickListener) {
        setEmptyView(resId, clickListener, false);
    }

    public void setEmptyView(int resId, OnClickListener clickListener, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mEmptyView = mLayoutInflater.inflate(resId, null);
        mEmptyView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setEmptyViewClickListener(OnClickListener clickListener) {
        if (mEmptyView == null) {
            throw new IllegalStateException("Empty view is null. Cannot set click listener.");
        }
        mEmptyView.setOnClickListener(clickListener);
    }

    public void setErrorView(View view) {
        setErrorView(view, false);
    }

    public void setErrorView(View view, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mErrorView = view;
        isInvalidateView = invalidateView;
    }

    public void setErrorView(int resId) {
        setErrorView(resId, false);
    }

    public void setErrorView(int resId, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mErrorView = mLayoutInflater.inflate(resId, null);
        isInvalidateView = invalidateView;
    }

    public void setErrorView(View view, OnClickListener clickListener) {
        setErrorView(view, clickListener, false);
    }

    public void setErrorView(View view, OnClickListener clickListener, boolean invalidateView) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null.");
        }
        mErrorView = view;
        mErrorView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setErrorView(int resId, OnClickListener clickListener) {
        setErrorView(resId, clickListener, false);
    }

    public void setErrorView(int resId, OnClickListener clickListener, boolean invalidateView) {
        if (resId <= 0) {
            throw new IllegalArgumentException("View resource id must be greater than 0.");
        }
        mErrorView = mLayoutInflater.inflate(resId, null);
        mErrorView.setOnClickListener(clickListener);
        isInvalidateView = invalidateView;
    }

    public void setErrorViewClickListener(OnClickListener clickListener) {
        if (mErrorView == null) {
            throw new IllegalStateException("Error view is null. Cannot set click listener.");
        }
        mErrorView.setOnClickListener(clickListener);
    }

    //================================================================================
    // State Handling
    //================================================================================

    public static enum State {
        LOADING,
        EMPTY,
        ERROR
    }

    public void showLoadingView() {
        showView(State.LOADING);
    }

    public void showEmptyView() {
        showView(State.EMPTY);
    }

    public void showErrorView() {
        showView(State.ERROR);
    }

    public void showView(State state) {
        if (isInitViews || isInvalidateView) {
            initViews();
            isInitViews = isInvalidateView = false;
        }

        boolean showLoadingView = false;
        boolean showEmptyView = false;
        boolean showErrorView = false;

        switch (state) {
            case LOADING:
                showLoadingView = true;
                break;
            case EMPTY:
                showEmptyView = true;
                break;
            case ERROR:
                showErrorView = true;
                break;
        }

        if (mLoadingView != null) {
            mLoadingView.setVisibility(showLoadingView ? View.VISIBLE : View.GONE);
        }

        if (mEmptyView != null) {
            mEmptyView.setVisibility(showEmptyView ? View.VISIBLE : View.GONE);
        }

        if (mErrorView != null) {
            mErrorView.setVisibility(showErrorView ? View.VISIBLE : View.GONE);
        }
    }

    private void initViews() {
        ViewGroup parent = (ViewGroup) getParent();
        if (parent == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " is not attached to parent view.");
        }

        ViewGroup container = getContainerView(parent);
        container.removeAllViews();

        parent.removeView(container);
        parent.addView(container);

        if (mLoadingView != null) {
            container.addView(mLoadingView);
        }

        if (mEmptyView != null) {
            container.addView(mEmptyView);
        }

        if (mErrorView != null) {
            container.addView(mErrorView);
        }

        super.setEmptyView(container);
    }

    private ViewGroup getContainerView(ViewGroup parent) {
        ViewGroup container = findContainerView(parent);
        if (container == null) {
            container = createContainerView();
        }
        return container;
    }

    private ViewGroup findContainerView(ViewGroup parent) {
        return (ViewGroup) parent.findViewWithTag(VIEW_TAG);
    }

    private ViewGroup createContainerView() {
        AbsListView.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        FrameLayout container = new FrameLayout(getContext());
        container.setTag(VIEW_TAG);
        container.setLayoutParams(lp);
        return container;
    }

    public void setEmptyViewMsg(String msg) {
        if (mEmptyMsgView != null) {
            mEmptyMsgView.setText(msg);
        }
    }

    public void setEmptyViewMsg(int resId) {
        if (mEmptyMsgView != null) {
            mEmptyMsgView.setText(resId);
        }
    }

    public void setErrorViewMsg(String msg) {
        if (mErrorMsgView != null) {
            mErrorMsgView.setText(msg);
        }
    }

    public void setErrorViewMsg(int resId) {
        if (mErrorMsgView != null) {
            mErrorMsgView.setText(resId);
        }
    }

    public void setEmptyButtonListener(OnClickListener listener) {
        if (mEmptyButton != null) {
            mEmptyButton.setOnClickListener(listener);
        }
    }

    public void setErrorButtonListener(OnClickListener listener) {
        if (mErrorButton != null) {
            mErrorButton.setOnClickListener(listener);
        }
    }

}
