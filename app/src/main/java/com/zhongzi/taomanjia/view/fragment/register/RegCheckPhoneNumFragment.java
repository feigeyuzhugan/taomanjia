package com.zhongzi.taomanjia.view.fragment.register;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCheckPhoneNumEvent;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegNextEvent;
import com.zhongzi.taomanjia.utils.CountdownUtil;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/16.
 * 验证手机号
 */

public class RegCheckPhoneNumFragment extends BaseFragment implements CountdownUtil.ICountDown{

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
        regCheckPhonenum.addTextChangedListener(new CheckTextWatcher());
        regCheckCode.addTextChangedListener(new NextTextWatcher());

    }

    @OnClick(R.id.reg_next)
    public void onNextClicked() {
        code=regCheckCode.getText().toString().trim();
        CountdownUtil.getInstance().cancelAll();
        EventBusUtil.postEvent(new RegNextEvent(code));
    }

    @OnClick(R.id.reg_check_btn)
    public void onCheckClicked() {
        setEnabledFail();
        phoneNum = regCheckPhonenum.getText().toString().trim();
        CountdownUtil.getInstance().newTimer(120000,1000,this,"秒");
        EventBusUtil.postEvent(new RegCheckPhoneNumEvent(phoneNum));
    }

    @Override
    public void onTick(long millisUntilFinished) {
        regCheckBtn.setText(millisUntilFinished/1000+"秒");
    }

    @Override
    public void onFinish() {
        setEnabledOk();
    }

    private void setEnabledOk(){
        regCheckBtn.setEnabled(true);
        regCheckBtn.setText("获取验证码");
        regCheckBtn.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.countdown_bg_blue));
    }
    private void setEnabledFail(){
        regCheckBtn.setEnabled(false);
        regCheckBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.countdown_bg_gray));
    }

    private class CheckTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            CountdownUtil.getInstance().cancelAll();
            setEnabledFail();
        }
        @Override
        public void afterTextChanged(Editable s) {
            if (s.length()==11){
                setEnabledOk();
            }else {
                setEnabledFail();
            }
        }
    }

    /**
     * 下一页的那个控件
     */
    private class NextTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void afterTextChanged(Editable s) {
            if (s.length()==6){
                LogUtil.e( "afterTextChanged: " );
                regNext.setEnabled(true);
                regNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.countdown_bg_blue));
            }else {
                regNext.setEnabled(false);
                regNext.setBackgroundDrawable(getResources().getDrawable(R.drawable.countdown_bg_gray));
            }
        }
    }
}
