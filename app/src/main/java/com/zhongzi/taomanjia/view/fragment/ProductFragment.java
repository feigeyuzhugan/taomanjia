package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/23.
 */

public class ProductFragment extends BaseFragment {
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

    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }
}
