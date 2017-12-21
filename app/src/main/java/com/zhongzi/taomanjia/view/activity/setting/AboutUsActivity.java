package com.zhongzi.taomanjia.view.activity.setting;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.view.activity.base.ToolbarBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/16.
 * 关于我们，该界面是webview
 */

public class AboutUsActivity extends ToolbarBaseActivity {

    @BindView(R.id.setting_about_us)
    TextView settingAboutUs;

    @Override
    protected void setContentLayout() {
        setContentView(R.layout.activity_setting_about_us);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void obtainData() {
        getToolbar().setTitle("关于我们");

        settingAboutUs.setText(Html.fromHtml(" <p style=\"line-height: 2em;\"><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">&nbsp; 淘满家商城</span><span style=\"font-size: 14px; font-family: 宋体, SimSun;\">（www.taomanjia.cn)隶属于上海烜赫电子商务有限公司旗下“互联网+”电子商务平台，是通过互联网及移动互联网等各种新颖、高效的网络售卖方式， 面向全国消费者提供数码家电、服装鞋帽、食品饮料、家饰家纺、居家生活等二十大类时尚百货精品交易与服务。致力于为消费者提供更专业、更便捷、更丰富、更诚信的网上购物体验！<br/>&nbsp; 淘满家是淘满家<span style=\"font-family: 宋体, SimSun; line-height: 32px;\">商城</span>手机客户端购物APP，是针对手机用户开发的客户端软件，致力于为手机用户提供更健康、舒适和安全的购物体验。</span></p><p style=\"line-height: 2em; text-align: center;\"><span style=\"font-family: 宋体, SimSun; font-size: 14px;\">&nbsp;淘满家<span style=\"font-size: 14px; font-family: 宋体, SimSun; line-height: 32px;\">商城</span></span></p>\n"));
    }

    @Override
    protected void initEvent() {
    }

}
