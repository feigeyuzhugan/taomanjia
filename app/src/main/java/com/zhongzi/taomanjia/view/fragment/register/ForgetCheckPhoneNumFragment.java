package com.zhongzi.taomanjia.view.fragment.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/20.
 * 忘记密码界面的验证手机
 */

public class ForgetCheckPhoneNumFragment extends BaseFragment {

    @BindView(R.id.forget_check_phonenum)
    EditText forgetCheckPhonenum;
    @BindView(R.id.forget_check_code)
    EditText forgetCheckCode;
    @BindView(R.id.forget_check_btn)
    Button forgetCheckBtn;
    @BindView(R.id.forget_next)
    Button forgetNext;

    public static ForgetCheckPhoneNumFragment newInstance() {
        Bundle args = new Bundle();
        ForgetCheckPhoneNumFragment fragment = new ForgetCheckPhoneNumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_forget_check;
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


    @OnClick({R.id.forget_check_btn, R.id.forget_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_check_btn:
                break;
            case R.id.forget_next:
                break;
        }
    }
}
