package com.zhongzi.taomanjia.view.activity.money;

import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.user.ToMoneyRuleEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseWhiteActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 分享收益
 */

public class MoneySharedActivity extends ToolbarBaseWhiteActivity implements View.OnClickListener{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_money_shared);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("分享收益");
        setToolbarRightTv("规则");
        getTvToolbarRight().setOnClickListener(this);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.MONEY_RULE,BaseConstants.CHECK_LOGIN);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBusUtil.postStickyEvent(new ToMoneyRuleEvent(BaseConstants.MONEY_SHARED));
    }
}
