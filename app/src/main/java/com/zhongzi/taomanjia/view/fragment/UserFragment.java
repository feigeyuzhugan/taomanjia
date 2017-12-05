package com.zhongzi.taomanjia.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.app.constants.UserCenterConstans;
import com.zhongzi.taomanjia.model.entity.eventbus.forget.UserCenterToEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.user.ToUserCenterEvent;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.presenter.UserPrestener;
import com.zhongzi.taomanjia.presenter.iView.IUserView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.PermissionUtil;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.SettingActivity;
import com.zhongzi.taomanjia.view.activity.login.LoginActivity;
import com.zhongzi.taomanjia.view.activity.order.OrderAllActivity;
import com.zhongzi.taomanjia.view.activity.user.UserAddressActivity;
import com.zhongzi.taomanjia.view.activity.user.UserBankcardActivity;
import com.zhongzi.taomanjia.view.activity.user.UserCodeActivity;
import com.zhongzi.taomanjia.view.activity.user.UserCollectionActivity;
import com.zhongzi.taomanjia.view.activity.user.UserContactActivity;
import com.zhongzi.taomanjia.view.activity.user.UserDownloadActivity;
import com.zhongzi.taomanjia.view.activity.user.UserProfileActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSecuritycenterActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSharedActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSpendingActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSystemActivity;
import com.zhongzi.taomanjia.view.adapter.UserCenterAdapter;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//import static com.zhongzi.taomanjia.R.id.user_login_fail_inflate;

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
    GridView userRecyclerview;
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

    private LinearLayout user_login_red_envelope_ll;//红包
    private LinearLayout user_login_pension_benefits_ll;//养老
     private LinearLayout user_login_recommend_earnings_ll;//分享
    private LinearLayout user_login_score_ll;//盛世

    //登录状态下

    private boolean fail;//失败的layout是否展开
    private boolean ok;//成功的layout是否展开

    private UserPrestener mUserPrestener;
    private View failView;
    private View okView;
    private UserInfoRes.UserinfoBean mUserinfoBean;

    private UserCenterAdapter mUserCenterAdapter;
    private boolean isNotLogin=true;//是否登录的标记,没有登录为true

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
        mUserPrestener = new UserPrestener(this,getLoadLayout());
        userLoginOk.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ok=true;
            }
        });
        userLoginFail.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                fail=true;
            }
        });
        setRecycleview();
    }

    private void setRecycleview() {
//        GridLayoutManager grid=new GridLayoutManager(mActivity,4);
//        userRecyclerview.setLayoutManager(grid);
        mUserCenterAdapter=new UserCenterAdapter(UserCenterConstans.getUserCenterList(),mActivity );
        userRecyclerview.setAdapter(mUserCenterAdapter);
        userRecyclerview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBusUtil.postEvent(new ToUserCenterEvent(BaseConstants.ACTIVITY_ID,null,BaseConstants.TO_ALL_ORDERS+position));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
//        mUserPrestener.loginging(mActivity);
//        getLoadLayout().setLayoutState(State.LOADING);
        mUserPrestener.getUserInfo(mActivity);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
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
        isNotLogin=true;
        noLoginInit();
    }

    @Override
    public void login() {
        isNotLogin=false;
        loginInit();
    }

    @Override
    public void uploadePhoto(String path) {
        user_login_photo.setImageURI(UrlConstants.HOST_ZHONGZI_HTTPS+path);
    }

    @Override
    public void getUserInfo(UserInfoRes userInfoRes) {
        mUserinfoBean=userInfoRes.getUserinfo();
        user_login_photo.setImageURI(UrlConstants.HOST_ZHONGZI_HTTPS+mUserinfoBean.getPhoto());
        user_login_uname.setText(mUserinfoBean.getRealName());
    }

    /**
     *登录时
     */
    private void loginInit(){
        if (!ok){
            userLoginOk.inflate();
            okView=findViewById(R.id.user_login_ok_inflate);
        }
        if (fail){
            failView.setVisibility(View.GONE);
            okView.setVisibility(View.VISIBLE);
        }

        user_login_setting= (ImageView) findViewById(R.id.user_login_setting);
        user_login_photo= (SimpleDraweeView) findViewById(R.id.user_login_photo);
        user_login_uname= (TextView) findViewById(R.id.user_login_uname);
        //四大收益
        user_login_red_envelope= (TextView) findViewById(R.id.user_login_red_envelope);//红包
        user_login_pension_benefits= (TextView) findViewById(R.id.user_login_pension_benefits);//养老
        user_login_recommend_earnings= (TextView) findViewById(R.id.user_login_recommend_earnings);//分享
        user_login_score= (TextView) findViewById(R.id.user_login_score);//盛世

        user_login_red_envelope_ll= (LinearLayout) findViewById(R.id.user_login_red_envelope_ll);//红包
        user_login_pension_benefits_ll= (LinearLayout) findViewById(R.id.user_login_pension_benefits_ll);
        user_login_recommend_earnings_ll= (LinearLayout) findViewById(R.id.user_login_recommend_earnings_ll);
        user_login_score_ll= (LinearLayout) findViewById(R.id.user_login_score_ll);

        user_login_setting.setOnClickListener(this);
        user_login_photo.setOnClickListener(this);

        user_login_red_envelope_ll.setOnClickListener(this);
        user_login_pension_benefits_ll.setOnClickListener(this);
        user_login_recommend_earnings_ll.setOnClickListener(this);
        user_login_score_ll.setOnClickListener(this);
    }

    /**
     *未登录时
     */
    private void noLoginInit(){
        if (!fail){
            userLoginFail.inflate();
            failView=findViewById(R.id.user_login_fail_inflate);
        }
        if (ok){
            okView.setVisibility(View.GONE);
            failView.setVisibility(View.VISIBLE);
        }
        user_no_login_setting= (ImageView) findViewById(R.id.user_no_login_setting);
        user_no_login_photo= (ImageView) findViewById(R.id.user_no_login);
        user_no_login_setting.setOnClickListener(this);
        user_no_login_photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_no_login:
                UiUtils.startActivity(mActivity, BaseConstants.LOGIN_ACTIVITY,isNotLogin);
                break;
            case R.id.user_no_login_setting:
                UiUtils.startActivity(mActivity, BaseConstants.SETTING_ACTIVITY,isNotLogin);
                break;
            case R.id.user_login_red_envelope_ll://红包
                UiUtils.startActivity(mActivity, BaseConstants.MONEY_RED_ENVELOPES,BaseConstants.CHECK_LOGIN);
                ToastUtil.show("红包");
                break;
            case R.id.user_login_pension_benefits_ll:
                UiUtils.startActivity(mActivity, BaseConstants.MONEY_PENSION,BaseConstants.CHECK_LOGIN);
                ToastUtil.show("养老");
                break;
            case R.id.user_login_recommend_earnings_ll:
                UiUtils.startActivity(mActivity, BaseConstants.MONEY_SHARED,BaseConstants.CHECK_LOGIN);
                ToastUtil.show("分享");
                break;
            case R.id.user_login_score_ll://
                UiUtils.startActivity(mActivity, BaseConstants.MONEY_SPIRIT,BaseConstants.CHECK_LOGIN);
                ToastUtil.show("盛世金元");
                break;
            case R.id.user_login_setting://设置
                UiUtils.startActivity(mActivity, BaseConstants.SETTING_ACTIVITY,isNotLogin);
                break;
            case R.id.user_login_photo://照片
                EventBusUtil.postEvent(new UserCenterToEvent(BaseConstants.PERMISSION_CAMERA));
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ToUserCenterEvent event){
        LogUtil.e("---"+event.getType()+"==="+event.getUri());
        switch (event.getType()){
            case BaseConstants.UPLOADPHOTOS:
                mUserPrestener.upLoadPhoto(mActivity,event.getUri()+"");
                break;
            case BaseConstants.ACTIVITY_ID:
                UiUtils.startActivity(mActivity,event.getPosition(),isNotLogin);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }
}