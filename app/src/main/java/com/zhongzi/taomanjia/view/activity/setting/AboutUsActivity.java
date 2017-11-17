package com.zhongzi.taomanjia.view.activity.setting;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/16.
 * 关于我们，该界面是webview
 */

public class AboutUsActivity extends ToolbarBaseActivity {

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_setting_about_us);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void obtainData() {
        getToolbar().setTitle("关于我们");
    }

    @Override
    protected void initEvent() {
    }
}
