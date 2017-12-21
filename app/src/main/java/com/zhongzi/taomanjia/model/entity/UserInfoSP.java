package com.zhongzi.taomanjia.model.entity;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.utils.PreferenceUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;

/**
 * Created by Administrator on 2017/12/8.
 * 存储了用户信息
 */

public class UserInfoSP {
    public static UserInfoSP getInstance() {
        return UserInfoSP.SingletonHolder.instance;
    }

    private SharedPreferences sp = null;
    private SharedPreferences.Editor mEditor;

    private static class SingletonHolder {
        private static final UserInfoSP instance = new UserInfoSP();
    }

    private Context mContext;

    private UserInfoSP() {

    }

    public void init(Context context) {
        this.mContext = context;
    }

    /**
     * 存储
     * @param loginRes
     */
    public void saveLoginInfo( LoginRes loginRes) {
        sp = PreferenceUtil.getPreference(mContext, BaseConstants.APP_LOGIN_USER, Context.MODE_PRIVATE);
        mEditor = sp.edit();
        mEditor.putString("id", loginRes.getId());
        mEditor.putString("userName", loginRes.getUserName());
        mEditor.putString("phone", loginRes.getPhone());
        mEditor.commit();
    }

    /**
     * 获取id
     *
     * @return
     */
    public String getUserId() {
        sp = PreferenceUtil.getPreference(mContext, BaseConstants.APP_LOGIN_USER, Context.MODE_PRIVATE);
        String id = sp.getString("id", null);
        if (id == null || id.isEmpty()) {
            throw new NullException("没有登录");
        }
        return id;
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getUserName() {
        sp = PreferenceUtil.getPreference(mContext, BaseConstants.APP_LOGIN_USER, Context.MODE_PRIVATE);
        String userName = sp.getString("userName", null);
        if (userName == null || userName.isEmpty()) {
            throw new NullException("没有登录");
        }
        return userName;
    }

    /**
     * 获取手机号
     *
     * @return
     */
    public String getPhoneNum() {
        sp = PreferenceUtil.getPreference(mContext, BaseConstants.APP_LOGIN_USER, Context.MODE_PRIVATE);
        String phone = sp.getString("phone", null);
        if (phone == null || phone.isEmpty()) {
            throw new NullException("没有登录");
        }
        return phone;
    }

    /**
     * 清空
     */
    public void clearUser() {
        sp = PreferenceUtil.getPreference(mContext, BaseConstants.APP_LOGIN_USER, Context.MODE_PRIVATE);
        mEditor = sp.edit();
        mEditor.putString("id", null);
        mEditor.putString("userName", null);
        mEditor.putString("phone", null);
        mEditor.commit();
    }

}
