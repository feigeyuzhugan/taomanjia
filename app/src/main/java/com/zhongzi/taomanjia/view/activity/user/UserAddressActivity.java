package com.zhongzi.taomanjia.view.activity.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.address.AddressInfoEvent;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.presenter.address.AddressInfoPresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddressInfoView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.MaterialDialogUtils;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.adapter.UserAddressAdapter;
import com.zhongzi.taomanjia.view.widget.loadlayout.OnLoadListener;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.OnRefreshListener;
import com.zhongzi.taomanjia.view.widget.recyclerview.lib.SwipeToLoadLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/11/29.
 * 我的地址
 */

public class UserAddressActivity extends ToolbarBaseActivity implements View.OnClickListener, IAddressInfoView, OnRefreshListener,OnLoadListener {
    @BindView(R.id.swipe_target)
    RecyclerView userAddressRecyclerview;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    private AddressInfoPresenter mPresenter;
    private UserAddressAdapter mAdapter;

    LinearLayoutManager layoutManager = null;
    private List<AddressInfoRes> mList=new ArrayList<>();
    private AddressInfoRes event;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_address);
    }

    @Override
    protected void initView() {
        mPresenter = new AddressInfoPresenter(this);
        setToolbarCenterTitle("我的地址");
        getTvToolbarRight().setText("添加");
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setRefreshing(true);
        layoutManager = new LinearLayoutManager(this);
        userAddressRecyclerview.setLayoutManager(layoutManager);
        getTvToolbarRight().setOnClickListener(this);
        getLoadLayout().setOnLoadListener(this);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
    }

    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.ADD_ADDRESS, BaseConstants.CHECK_NOT_LOGIN);
        finish();
    }

    @Override
    public void success(List<AddressInfoRes> list) {
        mList.clear();
        mList.addAll(list);
        getLoadLayout().setLayoutState(State.SUCCESS);
        swipeToLoadLayout.setRefreshing(false);
        mAdapter=new UserAddressAdapter(list,this);
        userAddressRecyclerview.setAdapter(mAdapter);
//        mAdapter.setListener(this);
    }

    @Override
    public void deleteSuccess(String str) {
        swipeToLoadLayout.setRefreshing(true);
    }

    @Override
    public void isDefault() {
        swipeToLoadLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        mPresenter.getAddressList( getLoadLayout());
    }

    public void remove(int position) {
        mPresenter.deleteUserAddressInfo(mList.get(position).getId(),getLoadLayout());
    }

    /**
     * 编辑
     * @param position
     */
    public void editor(int position) {
        event=mList.get(position);
        UiUtils.startActivity(this,BaseConstants.EDITOR_ADDRESS,BaseConstants.CHECK_NOT_LOGIN);
        finish();
    }

    public void isDefault(int position) {
        mPresenter.updateUserDefaultAddress(mList.get(position).getId(),getLoadLayout());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AddressEvent event){
        switch (event.getType()){
            case BaseConstants.ADDRESS_DEFAULT:
                isDefault(event.getPosition());
                break;
            case BaseConstants.ADDRESS_EDITOR://编辑
                editor(event.getPosition());
                break;
            case BaseConstants.ADDRESS_REMOVE:
                MaterialDialogUtils.showRemoveDialog("是否删除","是否删除",this);
                break;
            case BaseConstants.DIALOG_REMOVE:
                remove(event.getPosition());
                break;
            case BaseConstants.ADDRESS_ADD_TO_USER:
                swipeToLoadLayout.setRefreshing(true);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (event==null)return;
        EventBusUtil.postEvent(new AddressInfoEvent(event.getConsignee(),event.getProvince(),
                event.getCity(),event.getDistrict(),event.getDetail(),event.getPhone(),event.getIsDefault(),event.getId()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }

    @Override
    public void onLoad() {
        mPresenter.getAddressList( getLoadLayout());
    }
}
