package com.zhongzi.taomanjia.view.activity.login;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.ForgetPresenter;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;
import com.zhongzi.taomanjia.view.fragment.register.ForgetCheckPhoneNumFragment;
import com.zhongzi.taomanjia.view.fragment.register.ForgetCommitFragment;
import com.zhongzi.taomanjia.view.fragment.register.RegCheckPhoneNumFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/16.
 */

public class ForgetActivity extends ToolbarBaseActivity {


    @BindView(R.id.forge_title_bg)
    LinearLayout forgeTitleBg;
    @BindView(R.id.forget_content)
    FrameLayout forgetContent;
    private BaseFragment mCurrentFragment;
    private ForgetCommitFragment mForgetCommitFragment;
    private ForgetCheckPhoneNumFragment mForgetCheckPhoneNumFragment;
    private ForgetPresenter mForgetPresenter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_forget_pwd);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("忘记密码");
        mForgetPresenter=new ForgetPresenter();
    }

    @Override
    protected void obtainData() {
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        if (mForgetCheckPhoneNumFragment == null) {
            mForgetCheckPhoneNumFragment = ForgetCheckPhoneNumFragment.newInstance();
        }
        if (!mForgetCheckPhoneNumFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.forget_content, mForgetCheckPhoneNumFragment).commit();
            mCurrentFragment = mForgetCheckPhoneNumFragment;
            mCurrentFragment.setUserVisibleHint(true);
        }
    }

    private void addOrShow(FragmentTransaction transaction, BaseFragment fragment) {
        if (fragment == mCurrentFragment) return;
        if (!fragment.isAdded()) {
            transaction.hide(mCurrentFragment).add(R.id.forget_content, fragment).commit();
        } else {
            transaction.hide(mCurrentFragment).show(fragment).commit();
        }

        //不与ViewPager嵌套的话，需要显式调用setUserVisibleHint
        mCurrentFragment.setUserVisibleHint(false);
        mCurrentFragment = fragment;
        mCurrentFragment.setUserVisibleHint(true);
    }

    @Override
    protected void initEvent() {

    }

}
