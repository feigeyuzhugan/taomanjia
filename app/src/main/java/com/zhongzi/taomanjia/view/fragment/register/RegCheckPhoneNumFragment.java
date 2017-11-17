package com.zhongzi.taomanjia.view.fragment.register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCheckPhoneNumEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegNextEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/16.
 * 验证手机号
 */

public class RegCheckPhoneNumFragment extends BaseFragment {

    @BindView(R.id.reg_next)
    Button regNext;
    @BindView(R.id.reg_check_phonenum)
    EditText regCheckPhonenum;
    @BindView(R.id.reg_check_btn)
    Button regCheckBtn;
    @BindView(R.id.reg_check_code)
    EditText regCheckCode;
    private String phoneNum;
    private String code;

    public static RegCheckPhoneNumFragment newInstance() {
        Bundle args = new Bundle();
        RegCheckPhoneNumFragment fragment = new RegCheckPhoneNumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_reg_check_phonenum;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void obtainData() {
    }

    @Override
    protected void initEvent() {
    }

    @OnClick(R.id.reg_next)
    public void onNextClicked() {
        code=regCheckCode.getText().toString().trim();
        EventBusUtil.postEvent(new RegNextEvent(code));
    }


    @OnClick(R.id.reg_check_btn)
    public void onCheckClicked() {
        phoneNum = regCheckPhonenum.getText().toString().trim();
        EventBusUtil.postEvent(new RegCheckPhoneNumEvent(phoneNum));
    }

}
