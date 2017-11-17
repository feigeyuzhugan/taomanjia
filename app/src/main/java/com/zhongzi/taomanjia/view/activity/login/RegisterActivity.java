package com.zhongzi.taomanjia.view.activity.login;

import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCheckPhoneNumEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCommitEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegNextEvent;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.presenter.RegisterPresenter;
import com.zhongzi.taomanjia.presenter.iView.IRegView;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.fragment.register.RegCheckPhoneNumFragment;
import com.zhongzi.taomanjia.view.fragment.register.RegCommitFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/11/16.
 * 注册界面
 */

public class RegisterActivity extends ToolbarBaseActivity implements IRegView{

    @BindView(R.id.reg_phonenum_check)
    TextView regPhonenumCheck;
    @BindView(R.id.reg_bg)
    LinearLayout regCommit;
    private RegCheckPhoneNumFragment phonenumFragemnt;
    private BaseFragment mCurrentFragment;
    private RegisterPresenter mRegisterPresenter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("注册");
        mRegisterPresenter=new RegisterPresenter(this);
    }

    @Override
    protected void obtainData() {
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        if (phonenumFragemnt == null) {
            phonenumFragemnt = RegCheckPhoneNumFragment.newInstance();
        }
        if (!phonenumFragemnt.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.reg_content, phonenumFragemnt).commit();
            mCurrentFragment = phonenumFragemnt;
            mCurrentFragment.setUserVisibleHint(true);
        }
    }

    @Override
    protected void initEvent() {
        EventBusUtil.register(this);
    }

    private void addOrShow(FragmentTransaction transaction, BaseFragment fragment) {
        if (fragment == mCurrentFragment) return;
        if (!fragment.isAdded()) {
            transaction.hide(mCurrentFragment).add(R.id.reg_content, fragment).commit();
        } else {
            transaction.hide(mCurrentFragment).show(fragment).commit();
        }

        //不与ViewPager嵌套的话，需要显式调用setUserVisibleHint
        mCurrentFragment.setUserVisibleHint(false);
        mCurrentFragment = fragment;
        mCurrentFragment.setUserVisibleHint(true);
    }

    //EventBus的事件接收，从事件中获取最新的收藏数量并更新界面展示
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleEvent(RegNextEvent event) {
        mRegisterPresenter.checkCode(event.getCode());
    }
    //发送验证码
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void hasdleEvent(RegCheckPhoneNumEvent event){
        mRegisterPresenter.postPhoneNum(event.getPhoneNum());
    }

    //确认注册
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void hasdleEvent(RegCommitEvent event){
        mRegisterPresenter.registerUser(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }

    @Override
    public void regSuccess(RegUserRes regUserRes) {
        LogUtil.e(regUserRes);
    }

    @Override
    public void next() {
        regPhonenumCheck.setEnabled(false);
        regCommit.setBackgroundDrawable(getResources().getDrawable(R.drawable.forgetpassword_b2));
        addOrShow(getSupportFragmentManager().beginTransaction(), RegCommitFragment.newInstance());
    }
}
