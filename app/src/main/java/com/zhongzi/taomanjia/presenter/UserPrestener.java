package com.zhongzi.taomanjia.presenter;

import android.app.Activity;
import android.content.Context;

import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.UserInfoModel;
import com.zhongzi.taomanjia.model.entity.eventbus.LoginEvent;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.base.IBaseView;
import com.zhongzi.taomanjia.presenter.iView.ISplashView;
import com.zhongzi.taomanjia.presenter.iView.IUserView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.utils.log.LogUtil;

/**
 * Created by Administrator on 2017/11/16.
 * 个人中心
 */

public class UserPrestener extends BasePresenter<IUserView>{

    private static final String TAG = UserPrestener.class.getSimpleName();
    private UserInfoModel mUserInfoModel;
    private LoginModel mLoginModel;
    private String id;
    public UserPrestener(IUserView iuserView) {
        super(iuserView);
        mUserInfoModel=UserInfoModel.getInstance();
        mLoginModel=LoginModel.getInstance();
    }

    public void getUserInfo(Context context){
        if (id==null)return;
        mUserInfoModel.postUserinfo(id, new HttpObserver<UserInfoRes>() {
            @Override
            public void onNext(String title, UserInfoRes userInfoRes) {

            }
            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    public void loginging(Context context){
        try{
           id=mLoginModel.getUserId(context);
            LogUtil.e("---是否登录"+id+"---");
            mIView.login();
        }catch (NullException e){
            ToastUtil.show("还没有登录");
            mIView.noLogin();
        }
    }
}
