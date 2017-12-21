package com.zhongzi.taomanjia.view.activity.user;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.user.BankcardRes;
import com.zhongzi.taomanjia.presenter.iView.IBankcardView;
import com.zhongzi.taomanjia.presenter.user.BankcardPresenter;
import com.zhongzi.taomanjia.utils.TextViewUtils;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 我的银行卡
 */

public class UserBankcardActivity extends ToolbarBaseActivity implements View.OnClickListener ,IBankcardView{

    @BindView(R.id.bankcard_bankno)
    TextView bankcardBankno;
    @BindView(R.id.bankcard_useraccount)
    TextView bankcardUseraccount;
    @BindView(R.id.bankcard_bankname)
    TextView bankcardBankname;
    @BindView(R.id.bankcard_usertypestr)
    TextView bankcardUsertypestr;
    @BindView(R.id.bankcard_userstatusstr)
    TextView bankcardUserstatusstr;

    /*    @BindView(R.id.bank_card_tablayout)
        TabLayout bankCardTablayout;
        @BindView(R.id.bank_card_viewpager)
        ViewPager bankCardViewpager;
        UserBankCardAdapter adapter;
        FragmentManager fm;*/
    private BankcardPresenter mPresenter;
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.fragment_bankcard);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的银行卡");
        setToolbarRightTv("添加");
        getTvToolbarRight().setOnClickListener(this);
//        fm=getSupportFragmentManager();
//        adapter=new UserBankCardAdapter(fm);
//        bankCardViewpager.setAdapter(adapter);
//        bankCardTablayout.setupWithViewPager(bankCardViewpager);
//        bankCardTablayout.setTabMode(TabLayout.MODE_FIXED);
        mPresenter=new BankcardPresenter(this);
        mPresenter.getMyBankInfo();
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.BINDIN_GBANKCARD, BaseConstants.CHECK_LOGIN);
    }

    @Override
    public void succes(BankcardRes bankcardRes) {
        bankcardBankno.setText(TextViewUtils.setAppointWordColor("开户银行：",bankcardRes.getBankNo(), Color.GRAY));
        bankcardUseraccount.setText(TextViewUtils.setAppointWordColor("银行卡号：",bankcardRes.getBankAccountName(), Color.GRAY));
        bankcardBankname.setText(TextViewUtils.setAppointWordColor("开户姓名：",bankcardRes.getBankName(), Color.GRAY));
        bankcardUsertypestr.setText(TextViewUtils.setAppointWordColor("绑定类型：","现金账户", Color.GRAY));
        bankcardUserstatusstr.setText(TextViewUtils.setAppointWordColor("审核状态：",bankcardRes.getStatus(), Color.RED));
    }
}
