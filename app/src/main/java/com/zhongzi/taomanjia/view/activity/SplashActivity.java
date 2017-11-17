package com.zhongzi.taomanjia.view.activity;

import android.widget.ImageView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.presenter.SplashPrestenter;
import com.zhongzi.taomanjia.presenter.iView.ISplashView;
import com.zhongzi.taomanjia.utils.UiUtils;
import com.zhongzi.taomanjia.view.activity.base.BaseActivity;

/**
 * Created by Administrator on 2017/11/15.
 * 引导页
 */

public class SplashActivity extends BaseActivity implements ISplashView {

    ImageView imageView;
    private SplashPrestenter prestenter;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initView() {
        hideBar(true);
        imageView= (ImageView) findViewById(R.id.slash_img);
        prestenter=new SplashPrestenter(this);
        prestenter.setAnim(imageView);
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void startAnim() {
        UiUtils.startActivity(this,MainActivity.class);
        finish();
    }
}
