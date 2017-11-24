package com.zhongzi.taomanjia.model.net;

import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpArrayResult;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/11/14.
 * retrofitd 的接口
 */

public interface ApiService {

    @GET(UrlConstants.GETINDEXTOPBANNERINFO)
    Observable<HttpArrayResult<BannerInfoRes>> getBannerInfoRes();//获取banner广告位的接口

    //注册验证码
    @FormUrlEncoded
    @POST(UrlConstants.POSTMOBILEVERIFICATIONCODE)
    Observable<HttpResult<RegPhoneNumCheckRes>> postRegPhoneNumCheckRes(@Field("mobile") String mobile, @Field("type") String type);

    //注册账户
    @FormUrlEncoded
    @POST(UrlConstants.POSTADDREGISTERUSERINFO)
    Observable<HttpResult<RegUserRes>> postRegUserRes(@FieldMap Map<String,String> flatmap);

    //登录用户
    @FormUrlEncoded
    @POST(UrlConstants.POSTLOGINUSERINFO)
    Observable<HttpResult<LoginRes>> postLoginRes(@Field("userName") String userName, @Field("pwd") String pwd );

    //个人用户中心数据
    @FormUrlEncoded
    @POST(UrlConstants.POSTUSERCENTERINFO)
    Observable<HttpResult<UserInfoRes>> postUserInfo(@Field("userid") String userId);
}
