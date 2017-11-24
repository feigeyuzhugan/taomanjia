package com.zhongzi.taomanjia.view.fragment.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCommitEvent;
import com.zhongzi.taomanjia.utils.EventBusUtil;
import com.zhongzi.taomanjia.view.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/11/16.
 * 确认注册
 */

public class RegCommitFragment extends BaseFragment {

    @BindView(R.id.reg_commit_name)
    EditText regCommitName;
    @BindView(R.id.reg_commit_realname)
    EditText regCommitRealname;
    @BindView(R.id.reg_commit_pwd)
    EditText regCommitPwd;
    @BindView(R.id.reg_commit_pwd_again)
    EditText regCommitPwdAgain;
    @BindView(R.id.reg_commit_share_people)
    EditText regCommitSharePeople;
    @BindView(R.id.reg_commit_ok)
    Button regCommitOk;
    private RegCommitEvent mRegCommitEvent;

    public static RegCommitFragment newInstance() {
        Bundle args = new Bundle();
        RegCommitFragment fragment = new RegCommitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setContentLayout() {
        return R.layout.fragment_reg_commit;
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

    @OnClick(R.id.reg_commit_ok)
    public void onViewClicked() {
        String userName=regCommitName.getText().toString().trim();
        String name=regCommitRealname.getText().toString().trim();
        String newPwd=regCommitPwd.getText().toString().trim();
        String checkPwd=regCommitPwdAgain.getText().toString().trim();
        String Introducer=regCommitSharePeople.getText().toString().trim();
        mRegCommitEvent=new RegCommitEvent(userName,name,newPwd,checkPwd,Introducer);
        EventBusUtil.postEvent(mRegCommitEvent);
    }
}
