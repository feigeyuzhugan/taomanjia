package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.ProductTypePresenter;
import com.zhongzi.taomanjia.presenter.iView.IProductTypeView;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.adapter.product.ProductAdapter;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.widget.loadlayout.OnLoadListener;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * Created by Administrator on 2017/6/23.
 */

public class ProductFragment extends BaseFragment implements IProductTypeView,OnLoadListener{
    @BindView(R.id.product_tablayout)
    TabLayout productTablayout;
    @BindView(R.id.product_viewpager)
    ViewPager productViewpager;

    private ProductTypePresenter mPresenter;
    private ProductAdapter adapter;
    private FragmentManager fm;
    private List<String> mList=new ArrayList<>();


    public static ProductFragment newInstance() {
        Bundle args = new Bundle();
        ProductFragment fragment = new ProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initView() {
        fm=getFragmentManager();
        mPresenter=new ProductTypePresenter(this);

        getLoadLayout().setOnLoadListener(this);
        getLoadLayout().setLayoutState(State.LOADING);
//        mPresenter.getProudctCategroyInfo(getLoadLayout());
        adapter=new ProductAdapter(fm,mList);
        productViewpager.setAdapter(adapter);
        productTablayout.setupWithViewPager(productViewpager);
        productTablayout.setTabMode(MODE_SCROLLABLE);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick(R.id.include_product_seach)
    public void onViewClicked() {
        //跳到搜索界面
    }

    @Override
    public void onLoad() {
        mPresenter.getProudctCategroyInfo();
    }

    @Override
    public void success(List<String> list) {
//        LogUtil.e(list.get(0).toString());
        getLoadLayout().setLayoutState(State.SUCCESS);
        mList.clear();
        mList.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void error() {
        getLoadLayout().setLayoutState(State.FAILED);
    }
}
