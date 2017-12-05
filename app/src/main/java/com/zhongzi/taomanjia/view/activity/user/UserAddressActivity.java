package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfo;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.presenter.address.AddressInfoPresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddressInfoView;
import com.zhongzi.taomanjia.utils.MaterialDialogUtils;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.adapter.UserAddressAdapter;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.OnRefreshListener;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.SwipeToLoadLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 我的地址
 */

public class UserAddressActivity extends ToolbarBaseActivity implements View.OnClickListener, IAddressInfoView, OnRefreshListener,UserAddressAdapter.UserAddressEditorListener,UserAddressAdapter.UserAddressRemoveListener {
    @BindView(R.id.swipe_target)
    RecyclerView userAddressRecyclerview;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private AddressInfoPresenter mPresenter;
    private UserAddressAdapter mAdapter;

    LinearLayoutManager layoutManager = null;
    private List<AddressInfoRes> mList=new ArrayList<>();
//        if (mType == TYPE_LINEAR) {

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_address);
    }

    @Override
    protected void initView() {
        mPresenter = new AddressInfoPresenter(this);
        setToolbarCenterTitle("我的地址");
        getTvToolbarRight().setText("添加");
        swipeToLoadLayout.setRefreshing(true);
        layoutManager = new LinearLayoutManager(this);
        userAddressRecyclerview.setLayoutManager(layoutManager);
        swipeToLoadLayout.setOnRefreshListener(this);

        getTvToolbarRight().setOnClickListener(this);

    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.ADD_ADDRESS, BaseConstants.CHECK_LOGIN);
    }

    @Override
    public void success(List<AddressInfoRes> list) {
        mList.clear();
        mList.addAll(list);
        swipeToLoadLayout.setRefreshing(false);
        mAdapter=new UserAddressAdapter(list,this);
        userAddressRecyclerview.setAdapter(mAdapter);
        mAdapter.setRemoveListener(this);
        mAdapter.setEditorListener(this);
    }

    @Override
    public void deleteSuccess(String str) {
        ToastUtil.show("删除成功");
        swipeToLoadLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        mPresenter.getAddressList(this, getLoadLayout());
    }

    @Override
    public void remove(int position) {
//        MaterialDialogUtils.showRemoveDialog("是否删除","是否删除",this);
        mPresenter.deleteUserAddressInfo(mList.get(position).getId(),this,getLoadLayout());
    }

    @Override
    public void editor(int position) {

    }
}
