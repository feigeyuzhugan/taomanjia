package com.zhongzi.taomanjia.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.ILoginView;
import com.zhongzi.taomanjia.utils.PreferenceUtil;
import com.zhongzi.taomanjia.utils.StringUtils;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;

/**
 * Created by Administrator on 2017/11/20.
 */

public class LoginPrestener extends BasePresenter<ILoginView> {

    private LoginModel mLoginModel;//登录的模块
    private PreferenceUtil mPreferenceUtil;//
//    private Context mContext;

    public LoginPrestener(ILoginView iBaseView){
        super(iBaseView);
//        mContext= (Context) iBaseView;
        mLoginModel=LoginModel.getInstance();
//        mPreferenceUtil=PreferenceUtil.getDefaultPreference(this)
    }

    /**
     * 登录
     * @param username
     * @param pwd
     */
    public void postLogin(final Context context,@NonNull String username,@NonNull String pwd){
        boolean check=chack(username,pwd);
        if (!check) return;
        mLoginModel.postLogin(username, pwd, new HttpObserver<LoginRes>() {
            @Override
            public void onNext(String title, LoginRes loginRes) {
                mLoginModel.saveLoginInfo(context,loginRes);
                mIView.success();
            }
            @Override
            public void onError(int errType, String errMessage) {
                mLoginModel.clearUser(context);
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
//        if (!StringUtils.isMobileNO(username)){
//            ToastUtil.show("手机号格式不正确");
//            return false;
//        }
        if (pwd==null||pwd.isEmpty()){
            ToastUtil.show("账户密码不能为空");
            return false;
        }
        return true;
    }
    public void loge(Context context){
        LogUtil.e("登录测试--",mLoginModel.getUserId(context)+"---");
        LogUtil.e("登录测试--",mLoginModel.getUserName(context)+"---");
    }
}
