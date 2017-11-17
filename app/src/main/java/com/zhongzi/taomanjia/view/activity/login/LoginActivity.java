package com.zhongzi.taomanjia.view.activity.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/16.
 * 登录界面
 */

public class LoginActivity extends ToolbarBaseActivity {

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

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void obtainData() {
        getToolbar().setTitle("登录");
    }

    @Override
    protected void initEvent() {

    }


    @OnClick({R.id.login_commit, R.id.login_reg, R.id.login_forget_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_commit:
                break;
            case R.id.login_reg:
                UiUtils.startActivity(this,RegisterActivity.class);
                break;
            case R.id.login_forget_pwd:
                break;
        }
    }
}
