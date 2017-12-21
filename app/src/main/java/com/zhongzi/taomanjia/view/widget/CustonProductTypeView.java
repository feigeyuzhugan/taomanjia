package com.zhongzi.taomanjia.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.ToastUtil;

/**
 * Created by Administrator on 2017/12/7.
 * 分类那块的，商品列表的头部，主要用新品，销量等
 */

public class CustonProductTypeView extends LinearLayout implements View.OnClickListener{

    private TextView newProductsTv;//新品
    private TextView salesTv;//销量s
    private TextView priceTv;//价格
    private OnCustonProductTypeListener mListener;
    private View view;
    private int flagNewProduct=0;//新品的标志
    private int flagPrice=0;//价格的标志
    private int flagSales=1;//销量的标志
    private Drawable delaultDrawable;
    private Drawable upDrawable;
    private Drawable downDrawable;


    public void setOnCustonProductTypeListener(OnCustonProductTypeListener listener) {
        this.mListener = listener;
    }

    public CustonProductTypeView(Context context) {
        this(context,null);
    }

    public CustonProductTypeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    private void initview(Context context) {
        delaultDrawable=getResources().getDrawable(R.drawable.product_list_arrow4);
        delaultDrawable.setBounds(0,0,delaultDrawable.getIntrinsicWidth(),delaultDrawable.getIntrinsicHeight());
        upDrawable=getResources().getDrawable(R.drawable.product_list_arrow4a);
        upDrawable.setBounds(0,0,upDrawable.getIntrinsicWidth(),upDrawable.getIntrinsicHeight());
        downDrawable=getResources().getDrawable(R.drawable.product_list_arrow4d);
        downDrawable.setBounds(0,0,downDrawable.getIntrinsicWidth(),downDrawable.getIntrinsicHeight());
        view= LayoutInflater.from(context).inflate(R.layout.custom_product_type_select,this);
        newProductsTv= (TextView) view.findViewById(R.id.custom_product_type_newproduct);
        salesTv= (TextView) view.findViewById(R.id.custom_product_type_sales);
        priceTv= (TextView) view.findViewById(R.id.custom_product_type_price);
        newProductsTv.setOnClickListener(this);
        salesTv.setOnClickListener(this);
        priceTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener==null) {
            ToastUtil.show("没有设置点击监听....");
            return;
        }
        if (v==newProductsTv){
            setFlagNewProduct();
            flagNewProduct=flagNewProduct%2==1?BaseConstants.CUSTOM_TYPE_NEWPRODUCT_DOWN:BaseConstants.CUSTOM_TYPE_NEWPRODUCT_UP;
            setTypeView(flagNewProduct);
        }else if (v==salesTv){
            setFlagSales();
            flagSales=flagSales%2==1?BaseConstants.CUSTOM_TYPE_SALES_DOWN:BaseConstants.CUSTOM_TYPE_SALES_UP;
            setTypeView(flagSales);
        }else {
            setFlagPrice();
            flagPrice=flagPrice%2==1?BaseConstants.CUSTOM_TYPE_PRICE_DOWN:BaseConstants.CUSTOM_TYPE_PRICE_UP;
            setTypeView(flagPrice);
        }
    }
    //新品---判断标记
    private void setFlagNewProduct(){
        flagNewProduct++;
        flagPrice=0;
        flagSales=0;
    }
    //价格---判断标记
    private void setFlagPrice(){
        flagNewProduct=0;
        flagPrice++;
        flagSales=0;
    }
    //销量---判断标记
    private void setFlagSales(){
        flagNewProduct=0;
        flagPrice=0;
        flagSales++;
    }


    public interface OnCustonProductTypeListener{
        void onNewProductDownListener();
        void onNewProductUpListener();
        void onSalesDownListener();
        void onSalesUpListener();
        void onPriceDownListener();
        void onPriceUpListener();
    }

    /**
     *
     * @param type----是新品或者销量或者价格
     */
    private void setTypeView(int type){
        switch (type){
            case BaseConstants.CUSTOM_TYPE_NEWPRODUCT_DOWN://新品
                setNewProductDown();
                mListener.onNewProductDownListener();

                break;
            case BaseConstants.CUSTOM_TYPE_NEWPRODUCT_UP://新品
                setNewProductUp();
                mListener.onNewProductUpListener();
                break;
            case BaseConstants.CUSTOM_TYPE_SALES_DOWN://销量
                setSalesDown();
                mListener.onSalesDownListener();
                break;
            case BaseConstants.CUSTOM_TYPE_SALES_UP://销量
                setSalesUp();
                mListener.onSalesUpListener();
                break;
            case BaseConstants.CUSTOM_TYPE_PRICE_DOWN://价格降
                setPriceDown();
                mListener.onPriceDownListener();
                break;
            case BaseConstants.CUSTOM_TYPE_PRICE_UP://价格升
                mListener.onPriceUpListener();
                setPriceUp();
                break;
        }
    }
    /**
     * 新品将
     */
    private void setNewProductDown() {
        priceTv.setTextColor(Color.BLACK);
        priceTv.setCompoundDrawables(null,null,delaultDrawable,null);
        newProductsTv.setTextColor(Color.RED);
        newProductsTv.setCompoundDrawables(null,null,downDrawable,null);
        salesTv.setTextColor(Color.BLACK);
        salesTv.setCompoundDrawables(null,null,delaultDrawable,null);
    }
    /**
     * 价格升
     */
    private void setNewProductUp() {
        priceTv.setTextColor(Color.BLACK);

        priceTv.setCompoundDrawables(null,null,delaultDrawable,null);
        newProductsTv.setTextColor(Color.RED);
        newProductsTv.setCompoundDrawables(null,null,upDrawable,null);
        salesTv.setTextColor(Color.BLACK);
        salesTv.setCompoundDrawables(null,null,delaultDrawable,null);
    }
    /**
     * 销量将
     */
    private void setSalesDown() {
        priceTv.setTextColor(Color.BLACK);
        priceTv.setCompoundDrawables(null,null,delaultDrawable,null);
        newProductsTv.setTextColor(Color.BLACK);
        newProductsTv.setCompoundDrawables(null,null,delaultDrawable,null);
        salesTv.setTextColor(Color.RED);
        salesTv.setCompoundDrawables(null,null,downDrawable,null);
    }
    /**
     * 销量升
     */
    private void setSalesUp() {
        priceTv.setTextColor(Color.BLACK);
        priceTv.setCompoundDrawables(null,null,delaultDrawable,null);
        newProductsTv.setTextColor(Color.BLACK);
        newProductsTv.setCompoundDrawables(null,null,delaultDrawable,null);
        salesTv.setTextColor(Color.RED);
        salesTv.setCompoundDrawables(null,null,upDrawable,null);
    }

    /**
     * 价格将
     */
    private void setPriceDown() {
        priceTv.setTextColor(Color.RED);
        priceTv.setCompoundDrawables(null,null,downDrawable,null);
        newProductsTv.setTextColor(Color.BLACK);
        newProductsTv.setCompoundDrawables(null,null,delaultDrawable,null);
        salesTv.setTextColor(Color.BLACK);
        salesTv.setCompoundDrawables(null,null,delaultDrawable,null);
    }
    /**
     * 价格升
     */
    private void setPriceUp() {
        priceTv.setTextColor(Color.RED);
        priceTv.setCompoundDrawables(null,null,upDrawable,null);
        newProductsTv.setTextColor(Color.BLACK);
        newProductsTv.setCompoundDrawables(null,null,delaultDrawable,null);
        salesTv.setTextColor(Color.BLACK);
        salesTv.setCompoundDrawables(null,null,delaultDrawable,null);
    }
}
