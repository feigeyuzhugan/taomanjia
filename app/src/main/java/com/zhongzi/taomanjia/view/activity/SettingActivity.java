package com.zhongzi.taomanjia.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.presenter.SettingPresenter;
import com.zhongzi.taomanjia.presenter.iView.ISettingView;
import com.zhongzi.taomanjia.utils.ToastUtil;
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

public class SettingActivity extends ToolbarBaseActivity implements ISettingView{

    @BindView(R.id.setting_about)
    TextView settingAbout;
    @BindView(R.id.setting_suggestion)
    TextView settingSuggestion;
    @BindView(R.id.setting_check)
    TextView settingCheck;
    @BindView(R.id.settint_exit)
    Button settintExit;

    private SettingPresenter mSettingPresenter;
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void initView() {
        mSettingPresenter=new SettingPresenter(this);
        mSettingPresenter.loginning();
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
                UiUtils.startActivity(this, BaseConstants.ABOUT_US,BaseConstants.CHECK_NOT_LOGIN);
                break;
            case R.id.setting_suggestion:
                UiUtils.startActivity(this, BaseConstants.SUGGESTION,BaseConstants.CHECK_NOT_LOGIN);
                break;
            case R.id.setting_check:
                break;
            case R.id.settint_exit:
                mSettingPresenter.exit();
                break;
        }
    }

    @Override
    public void exit() {
        ToastUtil.show("退出应用");

        finish();
    }

    @Override
    public void hide() {
        settintExit.setVisibility(View.GONE);
    }
}
