package com.zhongzi.taomanjia.view.activity.order;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/28.
 * 全部订单
 */

public class OrderAllActivity extends ToolbarBaseActivity{

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_order_all);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("全部订单");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
