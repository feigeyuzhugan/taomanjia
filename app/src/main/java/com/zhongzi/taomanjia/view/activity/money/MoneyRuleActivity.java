package com.zhongzi.taomanjia.view.activity.money;

import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.user.ToMoneyRuleEvent;
import com.zhongzi.taomanjia.presenter.iView.IMoneyRuleView;
import com.zhongzi.taomanjia.presenter.money.MoneyRulePresenter;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/11/29.
 * 规则
 */

public class MoneyRuleActivity extends ToolbarBaseActivity implements IMoneyRuleView {

    @BindView(R.id.money_rule_text)
    TextView moneyRuleText;
    private MoneyRulePresenter mMoneyRulePresenter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_money_rule);
    }

    @Override
    protected void initView() {
        mMoneyRulePresenter=new MoneyRulePresenter(this);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ToMoneyRuleEvent event) {
        switch (event.getType()) {
            case BaseConstants.MONEY_RED_ENVELOPES:
                mMoneyRulePresenter.getMessage(BaseConstants.MONEY_RED_ENVELOPES,this);
                break;
            case BaseConstants.MONEY_CASH:
                mMoneyRulePresenter.getMessage(BaseConstants.MONEY_CASH,this);
                break;
            case BaseConstants.MONEY_PENSION:
                mMoneyRulePresenter.getMessage(BaseConstants.MONEY_PENSION,this);
                break;
            case BaseConstants.MONEY_SHARED:
                mMoneyRulePresenter.getMessage(BaseConstants.MONEY_SHARED,this);
                break;
            case BaseConstants.MONEY_SPIRIT:
                mMoneyRulePresenter.getMessage(BaseConstants.MONEY_SPIRIT,this);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        EventBusUtil.unregister(this);
        super.onDestroy();
    }

    @Override
    public void message(String title, String content) {
        setToolbarCenterTitle(title);
        moneyRuleText.setText(content);
    }

}
