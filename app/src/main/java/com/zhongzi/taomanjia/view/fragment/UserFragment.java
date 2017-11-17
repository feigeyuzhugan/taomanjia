package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.SettingActivity;
import com.zhongzi.taomanjia.view.activity.login.LoginActivity;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/23.
 */

public class UserFragment extends BaseFragment {

    @BindView(R.id.user_login_ok)
    ViewStub userLoginOk;
    @BindView(R.id.user_login_fail)
    ViewStub userLoginFail;
    @BindView(R.id.user_pending_payment)
    TextView userPendingPayment;
    @BindView(R.id.user_delivered)
    TextView userDelivered;
    @BindView(R.id.user_received)
    TextView userReceived;
    @BindView(R.id.user_evaluated)
    TextView userEvaluated;
    @BindView(R.id.user_return)
    TextView userReturn;
    @BindView(R.id.user_recyclerview)
    RecyclerView userRecyclerview;


    public static UserFragment newInstance() {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView() {
        userLoginFail.inflate();
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }


    @OnClick({R.id.user_pending_payment, R.id.user_delivered, R.id.user_received, R.id.user_evaluated, R.id.user_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_pending_payment:
                UiUtils.startActivity(mActivity, SettingActivity.class);
                break;
            case R.id.user_delivered:
                UiUtils.startActivity(mActivity, LoginActivity.class);
                break;
            case R.id.user_received:
                break;
            case R.id.user_evaluated:
                break;
            case R.id.user_return:
                break;
        }
    }
}
