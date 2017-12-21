package com.zhongzi.taomanjia.view.fragment.order;

import android.os.Bundle;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.presenter.iView.IOrderView;
import com.zhongzi.taomanjia.presenter.order.OrderPresenter;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 订单信息
 */

public class OrderFragment extends BaseFragment implements IOrderView{

    private int mFlag=0;//状态
    private TextView textView;
    private OrderPresenter mPresenter;

    public static OrderFragment newInstance(int flag) {
        Bundle args = new Bundle();
        args.putInt("flag",flag);
        LogUtil.e(""+flag);
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    protected int setContentLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {
        mFlag=getArguments().getInt("flag");
        LogUtil.e(mFlag+"--------------");
        textView= (TextView) findViewById(R.id.order_text);
        mPresenter=new OrderPresenter(this);
        mPresenter.setOrder(mFlag);
        textView.setText("待付款界面");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onPayment(List<OrderInfoRes> list) {
        textView.setText("待付款界面");
    }

    @Override
    public void onDelivered(List<OrderInfoRes> list) {
        textView.setText("待发货");
    }

    @Override
    public void onReceived(List<OrderInfoRes> list) {
        textView.setText("待收货");
    }

    @Override
    public void onEvaluated(List<OrderInfoRes> list) {
        textView.setText("待评价");
    }

    @Override
    public void onReturn(List<OrderInfoRes> list) {
        textView.setText("退款。退货");
    }
}
