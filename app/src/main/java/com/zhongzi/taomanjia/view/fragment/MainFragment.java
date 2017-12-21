package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.main.MainRes;
import com.zhongzi.taomanjia.presenter.iView.IMainView;
import com.zhongzi.taomanjia.presenter.main.MainPresenter;
import com.zhongzi.taomanjia.utils.DensityUtil;
import com.zhongzi.taomanjia.view.adapter.main.MainMultipleRecycleAdapter;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.fragment.main.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/16.
 */

public class MainFragment extends BaseFragment implements IMainView {


    //    @BindView(R.id.main_recyclerview)
    @BindView(R.id.swipe_target)
    RecyclerView mRecyclerview;
    private MainMultipleRecycleAdapter mAdapter;

    private MainPresenter mMainPresenter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mMainPresenter = new MainPresenter(this);
        GridLayoutManager manager = new GridLayoutManager(mActivity, 4, GridLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(getContext(), 3)));
        mAdapter = new MainMultipleRecycleAdapter();
        mRecyclerview.setAdapter(mAdapter);
        mMainPresenter.test();
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.include_main_scan, R.id.include_main_search, R.id.include_main_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.include_main_scan:
                break;
            case R.id.include_main_search:
                break;
            case R.id.include_main_login:
                break;
        }
    }

    @Override
    public void text() {
        List<MainRes> mainResList = new ArrayList<>();
        mainResList.clear();
        mainResList.add(new MainRes(BaseConstants.topBanner));
        mainResList.add(new MainRes(BaseConstants.iconList));
        mainResList.add(new MainRes(BaseConstants.scrollSwitcher));
        mainResList.add(new MainRes(BaseConstants.todayRecommended));
        mainResList.add(new MainRes(BaseConstants.newProduct));
        mainResList.add(new MainRes(BaseConstants.adSwitch));
        mainResList.add(new MainRes(BaseConstants.branDzone));
        mainResList.add(new MainRes(BaseConstants.choice));

        mainResList.add(new MainRes(BaseConstants.titleMayLike));
        mainResList.add(new MainRes(BaseConstants.mayLike));
        mainResList.add(new MainRes(BaseConstants.mayLike));
        mainResList.add(new MainRes(BaseConstants.mayLike));
        mainResList.add(new MainRes(BaseConstants.mayLike));

        mAdapter.getData().clear();
        mAdapter.resetMaxHasLoadPosition();
        mAdapter.setNewData(mainResList);
    }
}
