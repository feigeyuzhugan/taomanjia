package com.zhongzi.taomanjia.view.activity.user;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 我是收藏
 */

public class UserCollectionActivity extends ToolbarBaseActivity{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_collection);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的收藏");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
