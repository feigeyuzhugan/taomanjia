package com.zhongzi.taomanjia.presenter;

import android.content.Context;

import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.ILoginView;
import com.zhongzi.taomanjia.presenter.iView.ISettingView;
import com.zhongzi.taomanjia.utils.PreferenceUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.view.widget.MaterialDialog;

/**
 * Created by Administrator on 2017/11/23.
 * setting界面的表现层
 */

public class SettingPresenter extends BasePresenter<ISettingView>{
    private LoginModel mLoginModel;//登录的模块


    public SettingPresenter(ISettingView iBaseView){
        super(iBaseView);
        mLoginModel=LoginModel.getInstance();
    }

    /**
     * 要弹出对话框
     * @param context
     */
    public void exit(Context context){
        mLoginModel.clearUser(context);
        mIView.exit();
    }

    /**
     * 是否已经登录
     */
    public void loginning(Context context){
        try {
            mLoginModel.getUserId(context);
        }catch (NullException e){
            mIView.hide();
        }
    }
}
