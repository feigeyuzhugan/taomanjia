package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */

public interface IBannerView extends IBaseView {
    void getBannerInfoSuccess(List<BannerInfoRes> list);

//    void getBannerFail(int status, String desc, int type);
}
