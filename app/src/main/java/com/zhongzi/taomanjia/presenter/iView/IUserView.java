package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.presenter.base.IBaseView;

/**
 * Created by Administrator on 2017/11/16.
 * 个人中心
 */

public interface IUserView extends IBaseView{
    void noLogin();//没有登录；
    void login();//登录了
}
