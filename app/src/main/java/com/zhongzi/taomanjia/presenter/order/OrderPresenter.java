package com.zhongzi.taomanjia.presenter.order;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.OrderModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IOrderView;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.util.List;


/**
 * Created by Administrator on 2017/12/18.
 * 订单的表现层
 */

public class OrderPresenter extends BasePresenter<IOrderView> {
    private static final String TAG = OrderPresenter.class.getSimpleName();
    private OrderModel mOrderModel;
    private String uid;

    public OrderPresenter(IOrderView iOrderView) {
        super(iOrderView);
        mOrderModel = OrderModel.getInstance();
        uid= UserInfoSP.getInstance().getUserId();
    }

    public void setOrder(int flag){
        switch (flag){
            case 0:
                LogUtil.e("ce测试待付款");
                onPayment();
                break;
            case 1:
                LogUtil.e("ce测试待收货");
                onDelivered();
                break;
            case 2:
                onReceivered();
                break;
            case 3:
                onEvaluated();
                break;
            case 4:
                onReturn();
                break;
        }
    }

    /**
     * 退换
     */
    private void onReturn() {
        LogUtil.e("退换");
        mOrderModel.getMyOrderList_5(uid, new HttpArrayObserver<OrderInfoRes>() {
            @Override
            public void onNext(String title, List<OrderInfoRes> t) {
                mIView.onReturn(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    /**
     * 待评价
     */
    private void onEvaluated() {
        LogUtil.e("待评价");
        mOrderModel.getMyOrderList_4(uid, new HttpArrayObserver<OrderInfoRes>() {
            @Override
            public void onNext(String title, List<OrderInfoRes> t) {
                mIView.onEvaluated(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    /**
     *待收货
     */
    private void onReceivered() {
        LogUtil.e("待收货");
        mOrderModel.getMyOrderList_3(uid, new HttpArrayObserver<OrderInfoRes>() {
            @Override
            public void onNext(String title, List<OrderInfoRes> t) {
                mIView.onReceived(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
    /**
     *待发货
     */
    private void onDelivered() {
        LogUtil.e("待发货");
        mOrderModel.getMyOrderList_2(uid, new HttpArrayObserver<OrderInfoRes>() {
            @Override
            public void onNext(String title, List<OrderInfoRes> t) {
                mIView.onDelivered(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
    /**
     *待付款
     */
    private void onPayment() {
        LogUtil.e("待付款");
        mOrderModel.getMyOrderList_1(uid, new HttpArrayObserver<OrderInfoRes>() {
            @Override
            public void onNext(String title, List<OrderInfoRes> t) {
                mIView.onPayment(t);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }
}
