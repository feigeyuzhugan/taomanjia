package com.zhongzi.taomanjia.view.activity.user;

import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * app下载二维码
 */

public class UserDownloadActivity extends ToolbarBaseActivity implements View.OnClickListener{

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_download);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("app下载二维码");
//        getTvToolbarRight().setBackgroundDrawable(getResources().getDrawable(R.drawable.share));
        getTvToolbarRight().setText("分享");
        getTvToolbarRight().setOnClickListener(this);
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
}
