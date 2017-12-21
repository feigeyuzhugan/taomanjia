package com.zhongzi.taomanjia.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.ILoginView;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;

/**
 * Created by Administrator on 2017/11/20.
 */

public class LoginPrestener extends BasePresenter<ILoginView> {

    private LoginModel mLoginModel;//登录的模块

    public LoginPrestener(ILoginView iBaseView){
        super(iBaseView);
        mLoginModel=LoginModel.getInstance();
    }

    /**
     * 登录
     * @param username
     * @param pwd
     */
    public void postLogin(@NonNull String username,@NonNull String pwd){
        boolean check=chack(username,pwd);
        if (!check) return;
        mLoginModel.postLogin(username, pwd, new HttpObserver<LoginRes>() {
            @Override
            public void onNext(String title, LoginRes loginRes) {
//                mLoginModel.saveLoginInfo(context,loginRes);
                UserInfoSP.getInstance().saveLoginInfo(loginRes);
                mIView.success();
            }
            @Override
            public void onError(int errType, String errMessage) {
//                mLoginModel.clearUser(context);
                UserInfoSP.getInstance().clearUser();
                mIView.fail();
            }
        },mIView.getLifeSubject());
    }

    /**
     * 检测用户名和密码是否为空
     * @param username
     * @param pwd
     * @return
     */
    private boolean chack(String username, String pwd) {
        if (username==null||username.isEmpty()){
            ToastUtil.show("账号不能为空");
            return false;
        }
        if (pwd==null||pwd.isEmpty()){
            ToastUtil.show("账户密码不能为空");
            return false;
        }
        return true;
    }
    public void loge(){
//        LogUtil.e("登录测试--",mLoginModel.getUserId(context)+"---");
//        LogUtil.e("登录测试--",mLoginModel.getUserName(context)+"---");
    }
}
