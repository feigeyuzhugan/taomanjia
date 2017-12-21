package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/29.
 * 我的消费
 */

public class UserSpendingActivity extends ToolbarBaseActivity {
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_spending);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的消费");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.spending_redenvelopes, R.id.spending_cash, R.id.spending_pension, R.id.spending_spirit, R.id.spending_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spending_redenvelopes:
                ToastUtil.show("红包");
                UiUtils.startActivity(this, BaseConstants.MONEY_RED_ENVELOPES,BaseConstants.CHECK_NOT_LOGIN);
                break;
            case R.id.spending_cash:
                UiUtils.startActivity(this, BaseConstants.MONEY_CASH,BaseConstants.CHECK_NOT_LOGIN);
                ToastUtil.show("现金");
                break;
            case R.id.spending_pension:
                UiUtils.startActivity(this, BaseConstants.MONEY_PENSION,BaseConstants.CHECK_NOT_LOGIN);
                ToastUtil.show("养老");
                break;
            case R.id.spending_spirit:
                UiUtils.startActivity(this, BaseConstants.MONEY_SPIRIT,BaseConstants.CHECK_NOT_LOGIN);
                ToastUtil.show("金元");
                break;
            case R.id.spending_share:
                UiUtils.startActivity(this, BaseConstants.MONEY_SHARED,BaseConstants.CHECK_NOT_LOGIN);
                ToastUtil.show("分享");
                break;
        }
    }
}
