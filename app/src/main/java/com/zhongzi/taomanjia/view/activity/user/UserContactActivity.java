package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/29.
 * 联系客户
 */

public class UserContactActivity extends ToolbarBaseActivity {
    @BindView(R.id.contact_phone)
    TextView contactPhone;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_contact);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("联系客户");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
    }

    @OnClick(R.id.contact_phone)
    public void onViewClicked() {
        UiUtils.callPhone(this);
    }
}
