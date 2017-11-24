package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewStubCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.UserPrestener;
import com.zhongzi.taomanjia.presenter.iView.IUserView;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
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

public class UserFragment extends BaseFragment implements IUserView, View.OnClickListener {

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
    @BindView(R.id.user_login_ok)
    ViewStub userLoginOk;
    @BindView(R.id.user_login_fail)
    ViewStub userLoginFail;

    //未登录状态下
    private ImageView user_no_login_setting;//设置
    private ImageView user_no_login_photo;//照片
    //未登录状态下

    //登录状态下
    private ImageView user_login_setting;//设置
    private SimpleDraweeView user_login_photo;//照片
    private TextView user_login_uname;//登录时的用户名

    private TextView user_login_red_envelope;//红包
    private TextView user_login_pension_benefits;//养老积分
    private TextView user_login_recommend_earnings;//分享收益
    private TextView user_login_score;//盛世金元
    //登录状态下

    private boolean fail;
    private boolean ok;

    private UserPrestener mUserPrestener;

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
        mUserPrestener = new UserPrestener(this);
        userLoginOk.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ok=true;
                LogUtil.e("个人中心，userLoginOk"+stub.getInflatedId()+"---"+inflated.getId()+"=="+ok);
            }
        });

        userLoginFail.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                fail=true;
                LogUtil.e("个人中心，userLoginFail"+stub.getInflatedId()+"---"+inflated.getId()+"=="+fail);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mUserPrestener.loginging(mActivity);
        mUserPrestener.getUserInfo(mActivity);
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
                break;
            case R.id.user_delivered:
                break;
            case R.id.user_received:
                break;
            case R.id.user_evaluated:
                break;
            case R.id.user_return:
                break;
        }
    }

    @Override
    public void noLogin() {

    }

    @Override
    public void login() {
    }

    /**
     *登录时
     */
    private void loginInit(){
        if (!ok){
            userLoginOk.inflate();
            userLoginFail.setVisibility(View.GONE);
        }
    }

    /**
     *未登录时
     */
    private void noLoginInit(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_no_login:
                UiUtils.startActivity(mActivity, LoginActivity.class);
                break;
            case R.id.user_no_login_setting:
                UiUtils.startActivity(mActivity, SettingActivity.class);
                break;
            case R.id.user_login_red_envelope_ll://红包
                break;
            case R.id.user_login_pension_benefits_ll:
                break;
            case R.id.user_login_recommend_earnings_ll:
                break;
            case R.id.user_login_score_ll://
                break;
            case R.id.user_login_setting://设置
                UiUtils.startActivity(mActivity, SettingActivity.class);
                break;
            case R.id.user_login_photo://照片
                break;
        }
    }

}