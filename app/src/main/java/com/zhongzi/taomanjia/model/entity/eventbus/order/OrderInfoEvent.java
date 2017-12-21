package com.zhongzi.taomanjia.model.entity.eventbus.order;

/**
 * Created by Administrator on 2017/12/18.
 * 订单信息那块
 */

public class OrderInfoEvent {

    private int flag;

    public OrderInfoEvent(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "OrderInfoEvent{" +
                "flag=" + flag +
                '}';
    }
}
