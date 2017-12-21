package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.product.ProductTypeEvent;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeItemRes;
import com.zhongzi.taomanjia.presenter.ProductItemPresenter;
import com.zhongzi.taomanjia.presenter.iView.IProductItemView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.adapter.product.ProductItemAdapter;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/6.
 * 分类中的viewpager上的item
 */

public class ProductItemFragment extends BaseFragment implements IProductItemView ,ProductItemAdapter.OnProductItemListener{
    @BindView(R.id.product_item_recyclerview)
    RecyclerView productItemRecyclerview;
    private int position;
    private ProductItemPresenter mPresenter;
    private ProductItemAdapter mAdapter;
    private GridLayoutManager gridLayoutManager;

    public static ProductItemFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("key", position);
        ProductItemFragment fragment = new ProductItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_product_type;
    }

    @Override
    protected void initView() {
        position = getArguments().getInt("key");
        LogUtil.e("分类" + position);
        mPresenter = new ProductItemPresenter(this);
        mPresenter.getProudctCategroyInfo(position);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void child1BeanList(List<ProductTypeItemRes> productTypeItemRes) {
//        LogUtil.e(productTypeItemRes.get(0).toString());
        mAdapter = new ProductItemAdapter(mActivity, productTypeItemRes);
        mAdapter.setListener(this);
        gridLayoutManager=new GridLayoutManager(mActivity,3, GridLayoutManager.VERTICAL,false);
        productItemRecyclerview.setLayoutManager(gridLayoutManager);
        productItemRecyclerview.setHasFixedSize(true);
        productItemRecyclerview.setAdapter(mAdapter);

    }

    @Override
    public void onItemListener(String id,String name) {
        ToastUtil.show(id);
        UiUtils.startActivity(mActivity, BaseConstants.PRODUCT_TYPE_LIST,BaseConstants.CHECK_NOT_LOGIN);
        EventBusUtil.postStickyEvent(new ProductTypeEvent(name,id));
    }
}
