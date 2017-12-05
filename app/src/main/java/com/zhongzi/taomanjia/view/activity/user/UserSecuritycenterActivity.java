package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/29.
 * 安全中心
 */

public class UserSecuritycenterActivity extends ToolbarBaseActivity {
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_security);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("安全中心");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.security_uppwd, R.id.security_uppwd_pay, R.id.security_upphone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.security_uppwd://修改登录密码

                break;
            case R.id.security_uppwd_pay://修改支付密码

                break;
            case R.id.security_upphone://绑定手机号

                break;
        }
    }
}
