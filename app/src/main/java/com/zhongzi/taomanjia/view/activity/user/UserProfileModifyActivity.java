package com.zhongzi.taomanjia.view.activity.user;

import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 修改我的资料
 */

public class UserProfileModifyActivity extends ToolbarBaseActivity implements View.OnClickListener{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_profile);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("修改资料");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        
    }
}
