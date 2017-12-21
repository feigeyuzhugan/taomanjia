package com.zhongzi.taomanjia.view.adapter.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.view.adapter.UserCenterAdapter;
import com.zhongzi.taomanjia.view.widget.NoScrollListView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 * 待付款的adapter
 */

public class OrderPaymentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<OrderInfoRes> mList;
    private LayoutInflater inflater;
    private PaymentViewHolder mPayHolder;//待付款
    private DeliveredViewHolder mDeliveredHolder;//待发货
    private ReceiveredViewHolder mReceiveredHolder;//待收货
    private EvaluatedViewHolder mEvaluatedHolder;//待评价
    private ReturnViewHolder mReturnHolder;//退换

    private OnOrderListener mListener;

    public OrderPaymentAdapter(List<OrderInfoRes> list, Context context, OnOrderListener listener) {
        this.mList = list;
        this.inflater = LayoutInflater.from(context);
        this.mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return BaseConstants.ONPAYMENT;
            case 1:
                return BaseConstants.ONDELIVERED;
            case 2:
                return BaseConstants.ONRECEIVERED;
            case 3:
                return BaseConstants.ONEVALUATED;
            case 4:
                return BaseConstants.ONRETURN;
            default:
                return BaseConstants.ONPAYMENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BaseConstants.ONPAYMENT://待付款
                if (mPayHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mPayHolder = new PaymentViewHolder(view);
                }
                return mPayHolder;
            case BaseConstants.ONDELIVERED://待收货
                if (mDeliveredHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mDeliveredHolder = new DeliveredViewHolder(view);
                }
                return mDeliveredHolder;
            case BaseConstants.ONRECEIVERED://待收货
                if (mReceiveredHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mReceiveredHolder = new ReceiveredViewHolder(view);
                }
                return mReceiveredHolder;
            case BaseConstants.ONEVALUATED://待评价
                if (mEvaluatedHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mEvaluatedHolder = new EvaluatedViewHolder(view);
                }
                return mEvaluatedHolder;
            case BaseConstants.ONRETURN://退换
                if (mReturnHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mReturnHolder = new ReturnViewHolder(view);
                }
                return mReturnHolder;
            default://默认待付款
                if (mPayHolder == null) {
                    View view = inflater.inflate(R.layout.item_order_payment, null);
                    mPayHolder = new PaymentViewHolder(view);
                }
                return mPayHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PaymentViewHolder) {
           onBindPayment(holder,position);
        } else if (holder instanceof DeliveredViewHolder) {
            onBindDelivered(holder,position);
        } else if (holder instanceof ReceiveredViewHolder) {
            onBindReceivered(holder,position);
        } else if (holder instanceof EvaluatedViewHolder) {
            onBindEvaluated(holder,position);
        } else if (holder instanceof ReturnViewHolder) {
            onBindReturn(holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    /**
     * 退换，退款
     */
    class ReturnViewHolder extends RecyclerView.ViewHolder {
        private TextView type;//类型：消费区
        private TextView status;//订单状态
        private NoScrollListView listView;
        private TextView shopping;//商品信息
        private TextView cancel;//取消订单
        private TextView payment;//去付款

        public ReturnViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.item_order_type);
            status = (TextView) itemView.findViewById(R.id.item_order_status);
            shopping = (TextView) itemView.findViewById(R.id.item_order_shopping);
            cancel = (TextView) itemView.findViewById(R.id.item_order_cancel);
            payment = (TextView) itemView.findViewById(R.id.item_order_payment);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_order_list);
        }
    }

    /**
     * 待评价
     */
    class EvaluatedViewHolder extends RecyclerView.ViewHolder {
        private TextView type;//类型：消费区
        private TextView status;//订单状态
        private NoScrollListView listView;
        private TextView shopping;//商品信息
        private TextView cancel;//取消订单
        private TextView payment;//去付款

        public EvaluatedViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.item_order_type);
            status = (TextView) itemView.findViewById(R.id.item_order_status);
            shopping = (TextView) itemView.findViewById(R.id.item_order_shopping);
            cancel = (TextView) itemView.findViewById(R.id.item_order_cancel);
            payment = (TextView) itemView.findViewById(R.id.item_order_payment);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_order_list);
        }
    }

    /**
     * 待收货
     */
    class ReceiveredViewHolder extends RecyclerView.ViewHolder {
        private TextView type;//类型：消费区
        private TextView status;//订单状态
        private NoScrollListView listView;
        private TextView shopping;//商品信息
        private TextView cancel;//取消订单
        private TextView payment;//去付款

        public ReceiveredViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.item_order_type);
            status = (TextView) itemView.findViewById(R.id.item_order_status);
            shopping = (TextView) itemView.findViewById(R.id.item_order_shopping);
            cancel = (TextView) itemView.findViewById(R.id.item_order_cancel);
            payment = (TextView) itemView.findViewById(R.id.item_order_payment);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_order_list);
        }
    }

    /**
     * 待发货
     */
    class DeliveredViewHolder extends RecyclerView.ViewHolder {
        private TextView type;//类型：消费区
        private TextView status;//订单状态
        private NoScrollListView listView;
        private TextView shopping;//商品信息
        private TextView cancel;//取消订单
        private TextView payment;//去付款

        public DeliveredViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.item_order_type);
            status = (TextView) itemView.findViewById(R.id.item_order_status);
            shopping = (TextView) itemView.findViewById(R.id.item_order_shopping);
            cancel = (TextView) itemView.findViewById(R.id.item_order_cancel);
            payment = (TextView) itemView.findViewById(R.id.item_order_payment);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_order_list);
        }
    }

    /**
     * 待付款
     */
    class PaymentViewHolder extends RecyclerView.ViewHolder {
        private TextView type;//类型：消费区
        private TextView status;//订单状态
        private NoScrollListView listView;
        private TextView shopping;//商品信息
        private TextView cancel;//取消订单
        private TextView payment;//去付款

        public PaymentViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.item_order_type);
            status = (TextView) itemView.findViewById(R.id.item_order_status);
            shopping = (TextView) itemView.findViewById(R.id.item_order_shopping);
            cancel = (TextView) itemView.findViewById(R.id.item_order_cancel);
            payment = (TextView) itemView.findViewById(R.id.item_order_payment);
            listView = (NoScrollListView) itemView.findViewById(R.id.item_order_list);
        }
    }

    interface OnOrderListener {
        void cancelOrder();//取消订单

        void onPayment();//去支付
    }

    /**
     * 绑定待付款
     * @param holder
     * @param position
     */
    private void onBindPayment(RecyclerView.ViewHolder holder,int position){

    }
    /**
     * 绑定待发货
     * @param holder
     * @param position
     */
    private void onBindDelivered(RecyclerView.ViewHolder holder,int position){

    }
    /**
     * 绑定待收货
     * @param holder
     * @param position
     */
    private void onBindReceivered(RecyclerView.ViewHolder holder,int position){

    }
    /**
     * 绑定评价
     * @param holder
     * @param position
     */
    private void onBindEvaluated(RecyclerView.ViewHolder holder,int position){

    }
    /**
     * 绑定待付款
     * @param holder
     * @param position
     */
    private void onBindReturn(RecyclerView.ViewHolder holder,int position){
        mPayHolder = (PaymentViewHolder) holder;
        OrderInfoRes infoRes=mList.get(position);
        mPayHolder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        mPayHolder.payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
//        mPayHolder.shopping.setText("共计 "+infoRes.);
    }
}
