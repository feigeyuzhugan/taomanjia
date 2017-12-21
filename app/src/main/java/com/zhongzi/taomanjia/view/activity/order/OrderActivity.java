package com.zhongzi.taomanjia.view.activity.order;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.order.OrderInfoEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.adapter.order.OrderPagerAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/28.
 * 全部订单
 */

public class OrderActivity extends ToolbarBaseActivity {

    @BindView(R.id.order_tablayout)
    TabLayout orderTablayout;
    @BindView(R.id.order_viewpager)
    ViewPager orderViewpager;

    private OrderPagerAdapter mAdapter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_orderinfo);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的订单");
        mAdapter=new OrderPagerAdapter(getSupportFragmentManager());
        orderViewpager.setAdapter(mAdapter);
        orderTablayout.setupWithViewPager(orderViewpager);
        orderTablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(OrderInfoEvent event) {
        select(event);
    }

    /**
     * 选择那种状态
     *
     * @param event
     */
    private void select(OrderInfoEvent event) {
        switch (event.getFlag()) {
            case BaseConstants.ONPAYMENT://待付款
                orderViewpager.setCurrentItem(0);
                break;
            case BaseConstants.ONDELIVERED://待发货
                orderViewpager.setCurrentItem(1);
                break;
            case BaseConstants.ONRECEIVERED://待收货
                orderViewpager.setCurrentItem(2);
                break;
            case BaseConstants.ONEVALUATED://待评价
                orderViewpager.setCurrentItem(3);
                break;
            case BaseConstants.ONRETURN://退货
                orderViewpager.setCurrentItem(4);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }

}
