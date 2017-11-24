package com.zhongzi.taomanjia.model.entity.eventbus;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/23.
 * 针对的是没有登录的
 */

public class LoginEvent {
    Activity mContext;
//    private type;

    public LoginEvent(Activity mContext) {
        this.mContext = mContext;
    }

    public Activity getmContext() {
        return mContext;
    }

    public void setmContext(Activity mContext) {
        this.mContext = mContext;
    }
}
