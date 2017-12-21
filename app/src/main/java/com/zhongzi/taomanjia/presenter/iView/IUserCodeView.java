package com.zhongzi.taomanjia.presenter.iView;

import android.graphics.Bitmap;

import com.zhongzi.taomanjia.presenter.base.IBaseView;

/**
 * Created by Administrator on 2017/12/8.
 * 注册二维码
 */

public interface IUserCodeView extends IBaseView{
//    void decodeSuccess(String uri);//生成二维码成功
    void decodeSuccess(Bitmap bitmap);//生成二维码成功
}
