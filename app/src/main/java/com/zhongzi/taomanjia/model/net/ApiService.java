package com.zhongzi.taomanjia.model.net;

import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.entity.res.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/11/14.
 * retrofitd 的接口
 */

public interface ApiService {

    @GET(UrlConstants.GETINDEXTOPBANNERINFO)
    Observable<HttpResult<BannerInfoRes>> getBannerInfoRes();//获取banner广告位的接口
}
