package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public interface IOrderView extends IBaseView {
    //待付款
    void onPayment(List<OrderInfoRes> list);
    //待发货
    void onDelivered(List<OrderInfoRes> list);
    //待收货
    void onReceived(List<OrderInfoRes> list);
    //待评价
    void onEvaluated(List<OrderInfoRes> list);
    //退货
    void onReturn(List<OrderInfoRes> list);
}
