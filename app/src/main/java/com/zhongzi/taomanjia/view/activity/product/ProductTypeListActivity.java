package com.zhongzi.taomanjia.view.activity.product;

import android.os.Bundle;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.product.ProductTypeEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.widget.CustonProductTypeView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/7.
 * 商品分类列表界面
 * PlateInfoId----id小分类的
 * ordertype---SaleNum 销量  CreateTime 上架时间  price1 价格
 * sort -----升/降
 * page-----第几页
 * pagesize----一页多少个
 */

public class ProductTypeListActivity extends ToolbarBaseActivity implements CustonProductTypeView.OnCustonProductTypeListener {
    @BindView(R.id.product_type_custom)
    CustonProductTypeView productTypeCustom;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_product_type_list);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        productTypeCustom.setOnCustonProductTypeListener(this);
        EventBusUtil.register(this);
    }



    @Override
    public void onNewProductDownListener() {
        ToastUtil.show("新品降----------");
    }

    @Override
    public void onNewProductUpListener() {
        ToastUtil.show("新品升----------");
    }

    @Override
    public void onSalesDownListener() {
        ToastUtil.show("销量降----------");
    }

    @Override
    public void onSalesUpListener() {
        ToastUtil.show("销量升----------");
    }

    @Override
    public void onPriceDownListener() {
        ToastUtil.show("价格降----------");
    }

    @Override
    public void onPriceUpListener() {
        ToastUtil.show("价格升----------");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(ProductTypeEvent event){
        LogUtil.e(event.toString());
        setToolbarCenterTitle(event.getTitle());
    }
}
