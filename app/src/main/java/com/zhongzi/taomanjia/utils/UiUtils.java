package com.zhongzi.taomanjia.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/6/19.
 */

public class UiUtils {

    /**
     * 跳转界面
     *
     * @param activity
     * @param homeActivityClass
     */
    public static void startActivity(Activity activity, Class homeActivityClass) {
        Intent intent = new Intent(activity.getApplicationContext(), homeActivityClass);
        activity.startActivity(intent);
    }
    /**
     * 跳转界面2
     *
     * @param
     */
    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }


}
