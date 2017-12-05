package com.zhongzi.taomanjia.model.net;

import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpArrayResult;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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

    //上传头像http://hyu3451540001.my3w.com/public/api/uploadImage
    @Multipart
    @POST(UrlConstants.UPLOADIMAGE)
    Observable<HttpResult<String>> uploadImage( @Part MultipartBody.Part file,@Part("userid") RequestBody userId);

    //获取用户信息
    @FormUrlEncoded
    @POST(UrlConstants.GETUSERINFO)
    Observable<HttpResult<UserProfileRes>> getUserProfile(@Field("username") String username);

    //地址相关的
    //省
//    @FormUrlEncoded
    @POST(UrlConstants.GETALLPROVINCE)
    Observable<HttpArrayResult<AddressProvinceRes>> getAllProvince();
    //市
    @FormUrlEncoded
    @POST(UrlConstants.GETALLCITYWITHPROVINCEID)
    Observable<HttpArrayResult<AddressCityRes>> getAllCityWithProvinceId(@Field("provinceId") String provinceId);
    //区
    @FormUrlEncoded
    @POST(UrlConstants.GETALLDISTRICTWITHCITYID)
    Observable<HttpArrayResult<AddressDistrictRes>> getAllDistrictWithCityId(@Field("cityId") String cityId);
    //新增地址
    @FormUrlEncoded
    @POST(UrlConstants.ADDUSERADDRESSINFO)
    Observable<HttpResult<String>> addUserAddressInfo(@FieldMap Map<String ,String> flatmap);

    //获取地址列表
    @FormUrlEncoded
    @POST(UrlConstants.GETUSERADDRESSLISTINFO)
    Observable<HttpArrayResult<AddressInfoRes>> getUserAddressListInfo(@Field("userid") String userId);

    //删除地址
    @FormUrlEncoded
    @POST(UrlConstants.DELETEUSERADDRESSINFO)
    Observable<HttpResult<String>> deleteUserAddressInfo(@Field("userid") String userId,@Field("id") String id);

}
