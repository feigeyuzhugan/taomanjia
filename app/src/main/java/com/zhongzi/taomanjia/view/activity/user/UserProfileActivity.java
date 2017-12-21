package com.zhongzi.taomanjia.view.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.presenter.iView.IUserProfileView;
import com.zhongzi.taomanjia.presenter.user.UserProfilePresenter;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 我的资料
 */

public class UserProfileActivity extends ToolbarBaseActivity implements View.OnClickListener ,IUserProfileView{
    @BindView(R.id.profile_username)
    TextView profileUsername;
    @BindView(R.id.profile_sex)
    TextView profileSex;
    @BindView(R.id.profile_phone)
    TextView profilePhone;
    @BindView(R.id.profile_email)
    TextView profileEmail;
    @BindView(R.id.profile_realname)
    TextView profileRealname;
    @BindView(R.id.profile_idnumber)
    TextView profileIdnumber;
    @BindView(R.id.profile_referrer_name)
    TextView profileReferrerName;

    private UserProfilePresenter mPresenter;
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_profile);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的资料");
        getTvToolbarRight().setText("修改");
        mPresenter=new UserProfilePresenter(this);
        getTvToolbarRight().setOnClickListener(this);
        mPresenter.getProfileData();
    }

    @Override
    protected void obtainData() {
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        UiUtils.startActivity(this, BaseConstants.USER_PROFILE_MODIFY, BaseConstants.CHECK_NOT_LOGIN);
    }

    @Override
    public void success(UserProfileRes profileRes) {
        profileUsername.setText("*账  号： "+profileRes.getUserName());
        profileSex.setText("*性  别： "+profileRes.getSex());
        profilePhone.setText("*手 机 号： "+profileRes.getPhone());
        profileEmail.setText("邮  箱： "+profileRes.getEmail());
        profileRealname.setText("真实姓名： "+profileRes.getRealName());
        profileIdnumber.setText("证 件 号： "+profileRes.getSex());
        profileReferrerName.setText("分 享 人： "+profileRes.getReferrerPhone());
    }
}
