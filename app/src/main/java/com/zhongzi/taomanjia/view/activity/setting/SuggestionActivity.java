package com.zhongzi.taomanjia.view.activity.setting;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/16.
 * 意见反馈
 */

public class SuggestionActivity extends ToolbarBaseActivity{

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_setting_suggestion);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void obtainData() {
        getToolbar().setTitle("意见反馈");
    }

    @Override
    protected void initEvent() {
    }
}
