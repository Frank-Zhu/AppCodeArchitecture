package com.ithooks.android.xreap.base;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;

import com.ithooks.android.xreap.adapter.BaseAbstractRecycleCursorAdapter;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 18:48
 * Description: DB配合LoaderManager加载数据
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class BaseRecycleCursorFragment extends RecycleRefreshBaseFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    protected BaseAbstractRecycleCursorAdapter mCursorAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpCursorAdapter();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        return createCursorLoader();
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (mCursorAdapter != null) {
            mCursorAdapter.changeCursor(cursor);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (mCursorAdapter != null) {
            mCursorAdapter.changeCursor(null);
        }
    }

    protected abstract void setUpCursorAdapter();

    protected abstract Loader<Cursor> createCursorLoader();
}
