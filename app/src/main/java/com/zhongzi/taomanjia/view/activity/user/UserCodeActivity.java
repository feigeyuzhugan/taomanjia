package com.zhongzi.taomanjia.view.activity.user;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.iView.IUserCodeView;
import com.zhongzi.taomanjia.presenter.user.UserCodePresenter;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/29.
 * 我的二维码
 */

public class UserCodeActivity extends ToolbarBaseActivity implements View.OnClickListener,IUserCodeView {
    @BindView(R.id.share_code_img)
    ImageView shareCodeImg;

    private UserCodePresenter mPresenter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_code);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的二维码");
        getTvToolbarRight().setText("分享");
        getTvToolbarRight().setOnClickListener(this);
        mPresenter=new UserCodePresenter(this);
        mPresenter.generateQRCode(this);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onClick(View v) {
        ToastUtil.show("分享");
    }


    @Override
    public void decodeSuccess(Bitmap bitmap) {
        shareCodeImg.setImageBitmap(bitmap);
    }
}
