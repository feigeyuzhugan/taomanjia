package com.zhongzi.taomanjia.model.net;

import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.entity.res.LoginRes;
import com.zhongzi.taomanjia.model.entity.res.OrderInfoRes;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.entity.res.UserInfoRes;
import com.zhongzi.taomanjia.model.entity.res.UserProfileRes;
import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressCityRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressDistrictRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpArrayResult;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.base.HttpResult;
import com.zhongzi.taomanjia.model.entity.res.user.BankcardRes;

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

    //系统消息
    @FormUrlEncoded
    @POST(UrlConstants.GETSYSTEMMESSAGE)
    Observable<HttpArrayResult<UserSystemRes>> getSystemMessage(@Field("type") String type);

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

    //默认地址
    @FormUrlEncoded
    @POST(UrlConstants.UPDATEUSERDEFAULTADDRESS)
    Observable<HttpResult<String>> updateUserDefaultAddress(@Field("userid") String userId,@Field("addressid") String addressid);
    //修改
    @FormUrlEncoded
    @POST(UrlConstants.EDITUSERADDRESSINFO)
    Observable<HttpResult<String>> editUserAddressInfo(@FieldMap Map<String ,String> flatmap);
    //分类
    @POST(UrlConstants.GETPROUDCTCATEGROYINFO)
    Observable<HttpArrayResult<ProductTypeRes>> getProudctCategroyInfo();

    //添加银行卡
    @FormUrlEncoded
    @POST(UrlConstants.ADDMYBANKINFO)
    Observable<HttpResult<String>> addMyBankInfo(@FieldMap Map<String ,String> flatmap);

    //我的银行卡
    @FormUrlEncoded
    @POST(UrlConstants.GETMYBANKINFO)
    Observable<HttpResult<BankcardRes>> getMyBankInfo(@Field("username") String username);

    //订单信息
    //全部订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList(@Field("userid") String userid);
    //待付款订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST_1)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList_1(@Field("userid") String userid);
    //待发货订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST_2)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList_2(@Field("userid") String userid);
    //待收货订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST_3)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList_3(@Field("userid") String userid);
    //待评价订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST_4)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList_4(@Field("userid") String userid);
    //退货、退款订单
    @FormUrlEncoded
    @POST(UrlConstants.GETMYORDERLIST_5)
    Observable<HttpArrayResult<OrderInfoRes>> getMyOrderList_5(@Field("userid") String userid);



}
