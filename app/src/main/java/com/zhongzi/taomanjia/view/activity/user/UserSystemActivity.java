package com.zhongzi.taomanjia.view.activity.user;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 系统通知
 */

public class UserSystemActivity extends ToolbarBaseActivity{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_system);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("系统通知");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
