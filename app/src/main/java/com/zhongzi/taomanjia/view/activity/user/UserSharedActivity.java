package com.zhongzi.taomanjia.view.activity.user;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 我分享的用户
 */

public class UserSharedActivity extends ToolbarBaseActivity{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_shared);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我分享的用户");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
