package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;
import com.zhongzi.taomanjia.presenter.iView.IUserSystemView;
import com.zhongzi.taomanjia.presenter.user.UserSystemPresenter;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.adapter.user.UserSystemAdapter;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.OnRefreshListener;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.SwipeToLoadLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 系统通知
 */

public class UserSystemActivity extends ToolbarBaseActivity implements IUserSystemView, OnRefreshListener {

    @BindView(R.id.swipe_target)
    RecyclerView swipeTarget;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private UserSystemPresenter mPresenter;
    private UserSystemAdapter mAdapter;
    private LinearLayoutManager manager;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_system);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("系统通知");
        mPresenter = new UserSystemPresenter(this);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setRefreshing(true);
        manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        swipeTarget.setLayoutManager(manager);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void success(List<UserSystemRes> list) {
        swipeToLoadLayout.setRefreshing(false);
        mAdapter=new UserSystemAdapter(list,this);
        swipeTarget.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        mPresenter.getMessage();
    }

}
