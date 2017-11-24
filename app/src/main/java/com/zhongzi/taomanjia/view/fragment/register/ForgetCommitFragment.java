package com.zhongzi.taomanjia.view.fragment.register;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/20.
 * 忘记密码
 */

public class ForgetCommitFragment extends BaseFragment {
    @BindView(R.id.forget_pwd)
    EditText forgetPwd;
    @BindView(R.id.forget_check_pwd)
    EditText forgetCheckPwd;
    @BindView(R.id.forget_commit)
    Button forgetCommit;

    public static ForgetCommitFragment newInstance() {
        Bundle args = new Bundle();

        ForgetCommitFragment fragment = new ForgetCommitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_forget_commit;
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

    @OnClick(R.id.forget_commit)
    public void onViewClicked() {
    }
}
