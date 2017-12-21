package com.zhongzi.taomanjia.model;

import android.content.SharedPreferences;

import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/18.
 * 订单信息
 */

public class OrderModel {

    public static OrderModel getInstance() {
        return OrderModel.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final OrderModel instance = new OrderModel();
    }

    private OrderModel() {
    }


    /**
     * 全部订单
     *
     * @param uid
     * @param observer
     * @param lifecycleSubject
     */
    public void getMyOrderList(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 待付款订单
     *
     * @param uid
     * @param observer
     * @param lifecycleSubject
     */
    public void getMyOrderList_1(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList_1(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    /**
     * 待发货订单
     * @param uid
     * @param observer
     * @param lifecycleSubject
     */
    public void getMyOrderList_2(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList_2(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    //待收货订单
    public void getMyOrderList_3(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList_3(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    //待评价订单
    public void getMyOrderList_4(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList_4(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }

    //退货订单
    public void getMyOrderList_5(String uid, HttpArrayObserver<OrderInfoRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject) {
        Observable observable = RetrofitUtil.getApiService().getMyOrderList_5(uid);
        RetrofitUtil.composeToSubscribe(observable, observer, lifecycleSubject);
    }


}
