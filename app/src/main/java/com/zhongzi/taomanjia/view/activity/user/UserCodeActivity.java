package com.zhongzi.taomanjia.view.activity.user;

import android.view.View;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

/**
 * Created by Administrator on 2017/11/29.
 * 我的二维码
 *
 */

public class UserCodeActivity extends ToolbarBaseActivity implements View.OnClickListener{
    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_user_code);
    }

    @Override
    protected void initView() {
        setToolbarCenterTitle("我的二维码");
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
