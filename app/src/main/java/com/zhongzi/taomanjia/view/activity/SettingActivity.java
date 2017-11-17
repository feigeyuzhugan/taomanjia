package com.zhongzi.taomanjia.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.activity.setting.AboutUsActivity;
import com.zhongzi.taomanjia.view.activity.setting.SuggestionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/16.
 * 设置界面
 */

public class SettingActivity extends ToolbarBaseActivity {

    @BindView(R.id.setting_about)
    TextView settingAbout;
    @BindView(R.id.setting_suggestion)
    TextView settingSuggestion;
    @BindView(R.id.setting_check)
    TextView settingCheck;
    @BindView(R.id.settint_exit)
    Button settintExit;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void obtainData() {
        getToolbar().setTitle("设置");
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.setting_about, R.id.setting_suggestion, R.id.setting_check, R.id.settint_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_about:
                UiUtils.startActivity(this, AboutUsActivity.class);
                break;
            case R.id.setting_suggestion:
                UiUtils.startActivity(this, SuggestionActivity.class);
                break;
            case R.id.setting_check:
                break;
            case R.id.settint_exit:
                break;
        }
    }

}
