package com.zhongzi.taomanjia.presenter;

import android.content.Context;

import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.ILoginView;
import com.zhongzi.taomanjia.presenter.iView.ISettingView;
import com.zhongzi.taomanjia.utils.PreferenceUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.MaterialDialog;

/**
 * Created by Administrator on 2017/11/23.
 * setting界面的表现层
 */

public class SettingPresenter extends BasePresenter<ISettingView>{

    public SettingPresenter(ISettingView iBaseView){
        super(iBaseView);
    }

    /**
     * 要弹出对话框
     */
    public void exit(){
        UserInfoSP.getInstance().clearUser();
        mIView.exit();
    }

    /**
     * 是否已经登录
     */
    public void loginning(){
        try {
            UserInfoSP.getInstance().getUserId();
        }catch (NullException e){
            LogUtil.e(e.toString());
            mIView.hide();
        }
    }
}
