package com.zhongzi.taomanjia.view.activity.bankcard;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.user.BankcardInfo;
import com.zhongzi.taomanjia.presenter.iView.IAddBankcardView;
import com.zhongzi.taomanjia.presenter.user.AddBankcardPresenter;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/29.
 * 绑定银行卡
 */

public class BindingBankcardActivity extends ToolbarBaseActivity implements IAddBankcardView {


    @BindView(R.id.binding_bankname_et)
    EditText bindingBanknameEt;
    @BindView(R.id.binding_bankno_et)
    EditText bindingBanknoEt;
    @BindView(R.id.binding_bank_username_et)
    EditText bindingBankUsernameEt;
    private String namkinfo;//开户行
    private String cardnumber;//银行卡号
    private String cardusername;//持卡人
    private AddBankcardPresenter mPresenter;


    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_bankcard_binding);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("绑定银行卡");
        mPresenter=new AddBankcardPresenter(this);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void success(String str) {

    }

    @OnClick(R.id.binding_bankcard_commit)
    public void onViewClicked() {
        namkinfo=bindingBanknameEt.getText().toString().trim();
        cardnumber=bindingBanknoEt.getText().toString().trim();
        cardusername=bindingBankUsernameEt.getText().toString().trim();
        mPresenter.addMyBankInfo(new BankcardInfo(namkinfo,cardnumber,cardusername));
    }
}
