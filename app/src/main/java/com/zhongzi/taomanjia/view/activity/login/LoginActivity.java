package com.zhongzi.taomanjia.view.activity.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.LoginPrestener;
import com.zhongzi.taomanjia.presenter.iView.ILoginView;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/16.
 * 登录界面
 */

public class LoginActivity extends ToolbarBaseActivity implements ILoginView{

    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_commit)
    Button loginCommit;
    @BindView(R.id.login_reg)
    Button loginReg;
    @BindView(R.id.login_ll)
    LinearLayout loginLl;
    @BindView(R.id.login_forget_pwd)
    TextView loginForgetPwd;

    private LoginPrestener mLoginPrestener;
    private String username=null;
    private String pwd=null;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        mLoginPrestener=new LoginPrestener(this);
    }

    @Override
    protected void obtainData() {
//        getToolbar().setTitle("登录");
        setToolbarCenterTitle("登录");
    }

    @Override
    protected void initEvent() {

    }


    @OnClick({R.id.login_commit, R.id.login_reg, R.id.login_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_commit:
                username=loginName.getText().toString().trim();
                pwd=loginPwd.getText().toString().trim();
                mLoginPrestener.postLogin(username,pwd);
                break;
            case R.id.login_reg:
                UiUtils.startActivity(this,RegisterActivity.class);
                break;
            case R.id.login_forget_pwd:
                UiUtils.startActivity(this,ForgetActivity.class);
                break;
        }
    }

    @Override
    public void success() {
//        LogUtil.e("-------登录成功----");
        mLoginPrestener.loge();
        finish();
    }

    @Override
    public void fail() {
        ToastUtil.show("账号或密码错误");
//        LogUtil.e("-------失败成功----");
    }
}
