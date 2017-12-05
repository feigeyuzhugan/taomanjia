package com.zhongzi.taomanjia.view.activity.bankcard;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 绑定银行卡
 */

public class BindingBankcardActivity extends ToolbarBaseActivity{

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_bankcard_binding);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("绑定银行卡");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
