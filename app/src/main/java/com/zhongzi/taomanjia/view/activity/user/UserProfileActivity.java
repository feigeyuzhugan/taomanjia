package com.zhongzi.taomanjia.view.activity.user;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 我的资料
 */

public class UserProfileActivity extends ToolbarBaseActivity{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_profile);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的资料");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
