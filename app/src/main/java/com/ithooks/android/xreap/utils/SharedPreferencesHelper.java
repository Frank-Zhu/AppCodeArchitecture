package com.ithooks.android.xreap.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 14:14
 * Description: SharedPreferences 帮助类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class SharedPreferencesHelper {
    private static SharedPreferences sPreferences = null;
    private String DEFAULT_APP_IMAGE_DATA_DIRECTORY;
    public static String lastImagePath = "";

    private SharedPreferencesHelper() {
    }

    private static class SharedPreferencesHelperHolder {
        private static SharedPreferencesHelper appSharedPreferencesHelper = new SharedPreferencesHelper();
    }

    public static SharedPreferencesHelper getInstance() {
        return SharedPreferencesHelperHolder.appSharedPreferencesHelper;
    }

    public void Builder(Context context) {
        if (sPreferences == null) {
            sPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public Bitmap getImage(String path) {
        Bitmap theGottenBitmap = null;
        try {
            theGottenBitmap = BitmapFactory.decodeFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theGottenBitmap;
    }

    /**
     * Returns the String path of the last image that was saved with this Object
     * <p/>
     */
    public String getSavedImagePath() {
        return lastImagePath;
    }

    /**
     * Returns the String path of the last image that was saved with this FullPath
     *
     * @param theFolder    String
     *                     the theFolder - the folder path dir you want to save it to e.g
     *                     "DropBox/WorkImages"
     * @param theImageName String
     *                     the theImageName - the name you want to assign to the image file e.g
     *                     "MeAtlunch.png"
     */
    public String putImagePNG(String theFolder, String theImageName,
                              Bitmap theBitmap) {
        this.DEFAULT_APP_IMAGE_DATA_DIRECTORY = theFolder;
        String mFullPath = setupFolderPath(theImageName);
        saveBitmapPNG(mFullPath, theBitmap);
        lastImagePath = mFullPath;
        return mFullPath;
    }

    private String setupFolderPath(String imageName) {
        File filePath = Environment.getExternalStorageDirectory();
        File mFolder = new File(filePath, DEFAULT_APP_IMAGE_DATA_DIRECTORY);
        if (!mFolder.exists()) {
            if (!mFolder.mkdirs()) {
                Log.e("While creating save path",
                        "Default Save Path Creation Error");
            }
        }
        return mFolder.getPath() + '/' + imageName;
    }

    private boolean saveBitmapPNG(String strFileName, Bitmap bitmap) {
        if (strFileName == null || bitmap == null)
            return false;
        boolean bSuccess1 = false;
        boolean bSuccess2;
        boolean bSuccess3;
        File saveFile = new File(strFileName);

        if (saveFile.exists()) {
            if (!saveFile.delete())
                return false;
        }

        try {
            bSuccess1 = saveFile.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        OutputStream out = null;
        try {
            out = new FileOutputStream(saveFile);
            bSuccess2 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
            bSuccess2 = false;
        }
        try {
            if (out != null) {
                out.flush();
                out.close();
                bSuccess3 = true;
            } else
                bSuccess3 = false;

        } catch (IOException e) {
            e.printStackTrace();
            bSuccess3 = false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return (bSuccess1 && bSuccess2 && bSuccess3);
    }

    public int getInt(String key) {
        return sPreferences.getInt(key, 0);
    }

    public long getLong(String key) {
        return sPreferences.getLong(key, 0l);
    }

    public String getString(String key) {
        return sPreferences.getString(key, "");
    }

    public String getString(String key, String defaultValue) {
        return sPreferences.getString(key, defaultValue);
    }

    public double getDouble(String key) {
        String number = getString(key);
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void putDouble(String key, double value) {
        putString(key, String.valueOf(value));
    }

    public void putString(String key, String value) {

        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putList(String key, ArrayList<String> array) {

        SharedPreferences.Editor editor = sPreferences.edit();
        String[] lists = array.toArray(new String[array.size()]);
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        editor.putString(key, TextUtils.join("‚‗‚", lists));
        editor.apply();
    }

    public ArrayList<String> getList(String key) {
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        String[] lists = TextUtils.split(sPreferences.getString(key, ""), "‚‗‚");
        return new ArrayList<String>(Arrays.asList(lists));
    }

    public void putListInt(String key, ArrayList<Integer> array,
                           Context context) {
        SharedPreferences.Editor editor = sPreferences.edit();
        Integer[] lists = array.toArray(new Integer[array.size()]);
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        editor.putString(key, TextUtils.join("‚‗‚", lists));
        editor.apply();
    }

    public ArrayList<Integer> getListInt(String key,
                                         Context context) {
        // the comma like character used below is not a comma it is the SINGLE
        // LOW-9 QUOTATION MARK unicode 201A and unicode 2017 they are used for
        // seprating the items in the list
        String[] mylist = TextUtils.split(sPreferences.getString(key, ""), "‚‗‚");
        ArrayList<String> gottenlist = new ArrayList<String>(Arrays.asList(mylist));
        ArrayList<Integer> gottenlist2 = new ArrayList<Integer>();
        for (String data : gottenlist) {
            gottenlist2.add(Integer.parseInt(data));
        }

        return gottenlist2;
    }

    public void putListBoolean(String key, ArrayList<Boolean> marray) {
        ArrayList<String> origList = new ArrayList<String>();
        for (Boolean b : marray) {
            if (b) {
                origList.add("true");
            } else {
                origList.add("false");
            }
        }
        putList(key, origList);
    }

    public ArrayList<Boolean> getListBoolean(String key) {
        ArrayList<String> origList = getList(key);
        ArrayList<Boolean> mBools = new ArrayList<Boolean>();
        for (String b : origList) {
            if (b.equals("true")) {
                mBools.add(true);
            } else {
                mBools.add(false);
            }
        }
        return mBools;
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return sPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return sPreferences.getBoolean(key, defaultValue);
    }

    public void putFloat(String key, float value) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public float getFloat(String key) {
        return sPreferences.getFloat(key, 0f);
    }

    public void remove(String key) {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public Map<String, ?> getAll() {
        return sPreferences.getAll();
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
