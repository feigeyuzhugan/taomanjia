package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;
import com.zhongzi.taomanjia.view.adapter.UserBankCardAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 我的银行卡
 */

public class UserBankcardActivity extends ToolbarBaseActivity implements View.OnClickListener{

    @BindView(R.id.bank_card_tablayout)
    TabLayout bankCardTablayout;
    @BindView(R.id.bank_card_viewpager)
    ViewPager bankCardViewpager;
    UserBankCardAdapter adapter;
    FragmentManager fm;
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_bankcard);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的银行卡");
        setToolbarRightTv("添加");
        getTvToolbarRight().setOnClickListener(this);
        fm=getSupportFragmentManager();
        adapter=new UserBankCardAdapter(fm);
        bankCardViewpager.setAdapter(adapter);
        bankCardTablayout.setupWithViewPager(bankCardViewpager);
        bankCardTablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.BINDIN_GBANKCARD,BaseConstants.CHECK_LOGIN);
    }
}
