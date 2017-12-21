package com.zhongzi.taomanjia.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.UserInfoModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.eventbus.LoginEvent;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.base.IBaseView;
import com.zhongzi.taomanjia.presenter.iView.ISplashView;
import com.zhongzi.taomanjia.presenter.iView.IUserView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.PermissionUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.loadlayout.LoadLayout;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

/**
 * Created by Administrator on 2017/11/16.
 * 个人中心
 */

public class UserPrestener extends BasePresenter<IUserView> {

    private static final String TAG = UserPrestener.class.getSimpleName();
    private UserInfoModel mUserInfoModel;
    private String id;
//    private LoadLayout mLoadLayout;

    public UserPrestener(IUserView iuserView) {
        super(iuserView);
//        this.mLoadLayout=loadLayout;
        mUserInfoModel = UserInfoModel.getInstance();
    }

    public void getUserInfo() {
        loginging();
        if (id == null) return;//当没有登录时，下面就不会执行
        LogUtil.e("--------------------------");
//        mLoadLayout.setLayoutState(State.LOADING);
        mUserInfoModel.postUserinfo(id, new HttpObserver<UserInfoRes>() {
            @Override
            public void onNext(String title, UserInfoRes userInfoRes) {
//                mLoadLayout.setLayoutState(State.SUCCESS);
                mIView.getSuccessUserInfo(userInfoRes);

            }

            @Override
            public void onError(int errType, String errMessage) {
//                mLoadLayout.setLayoutState(State.FAILED);
            }
        }, mIView.getLifeSubject());
    }

    public void loginging() {
        try {
//            LogUtil.e("---是否登录"+id+"---");
            id= UserInfoSP.getInstance().getUserId();
            mIView.login();
        } catch (NullException e) {
//            ToastUtil.show("还没有登录");
            mIView.noLogin();
        }
    }

    /**
     * 上传照片
     * @param uri
     */
    public void upLoadPhoto(String uri, final LoadLayout mLoadLayout) {
//        loginging(context);
//        mLoadLayout.setLayoutState(State.LOADING);
        mUserInfoModel.upLoadPhoto(id, uri, new HttpObserver<String>() {
            @Override
            public void onNext(String title, String s) {
//                mLoadLayout.setLayoutState(State.SUCCESS);
                mIView.uploadePhoto(s);
                ToastUtil.show("上传成功");
            }
            @Override
            public void onError(int errType, String errMessage) {
                LogUtil.e(errMessage);
//                mLoadLayout.setLayoutState(State.FAILED);
                ToastUtil.show("上传失败");
            }
        },mIView.getLifeSubject());
    }
}
