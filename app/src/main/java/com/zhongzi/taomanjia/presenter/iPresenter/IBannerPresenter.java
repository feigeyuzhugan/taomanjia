package com.zhongzi.taomanjia.presenter.iPresenter;

import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */

public interface IBannerPresenter extends IBaseView {
    void getBannerInfoSuccess(List<BannerInfoRes> list);
//    void getMovieSuccess(List<MovieRes> list, int type);

//    void getBannerFail(int status, String desc, int type);
}
