package com.zhongzi.taomanjia.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;
import com.zhongzi.taomanjia.utils.PreferenceUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/11/20.
 * 登录的model
 */
public class LoginModel {

    public static LoginModel getInstance() {
        return LoginModel.SingletonHolder.instance;
    }
    private SharedPreferences sp=null;
    private static class SingletonHolder {
        private static final LoginModel instance = new LoginModel();
    }

    private LoginModel() {
    }

    /**
     * 登录界面
     * @param username
     * @param pwd
     * @param observer
     * @param lifecycleSubject
     */
    public void postLogin(String username,String pwd,HttpObserver<LoginRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
       Observable observable= RetrofitUtil.getApiService().postLoginRes(username,pwd);
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

    public void saveLoginInfo(Context context,LoginRes loginRes){
        sp= PreferenceUtil.getPreference(context, BaseConstants.APP_LOGIN_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=sp.edit();
        mEditor.putString("id",loginRes.getId());
        mEditor.putString("userName",loginRes.getUserName());
        mEditor.putString("phone",loginRes.getPhone());
        mEditor.commit();
    }

    /**
     * 获取id
     * @param context
     * @return
     */
    public String getUserId(Context context){
        sp= PreferenceUtil.getPreference(context, BaseConstants.APP_LOGIN_USER,Context.MODE_PRIVATE);
        String id= sp.getString("id",null);
        if (id==null||id.isEmpty()){
            throw new NullException("没有登录");
        }
        return id;
    }

    /**
     * 获取用户名
     * @param context
     * @return
     */
    public String getUserName(Context context){
        sp= PreferenceUtil.getPreference(context, BaseConstants.APP_LOGIN_USER,Context.MODE_PRIVATE);
        String userName= sp.getString("userName",null);
        if (userName==null||userName.isEmpty()){
            throw new NullException("没有登录");
        }
        return userName;
    }

    /**
     * 获取手机号
     * @param context
     * @return
     */
    public String getPhoneNum(Context context){
        sp= PreferenceUtil.getPreference(context, BaseConstants.APP_LOGIN_USER,Context.MODE_PRIVATE);
        String phone= sp.getString("phone",null);
        if (phone==null||phone.isEmpty()){
            throw new NullException("没有登录");
        }
        return phone;
    }

    /**
     * 清空
     * @param context
     */
    public void clearUser(Context context){
        sp= PreferenceUtil.getPreference(context, BaseConstants.APP_LOGIN_USER,Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor=sp.edit();
        mEditor.putString("id",null);
        mEditor.putString("userName",null);
        mEditor.putString("phone",null);
        mEditor.commit();
    }


}
