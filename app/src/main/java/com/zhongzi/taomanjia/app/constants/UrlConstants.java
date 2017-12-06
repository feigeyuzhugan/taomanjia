package com.zhongzi.taomanjia.app.constants;

/**
 * Created by Administrator on 2017/11/14.
 * 网络的URL路径
 */

public interface UrlConstants {
    //    String HOST_SITE_HTTPS = "https://api.douban.com/";
    String  HOST_ZHONGZI_HTTPS="http://files.china-xftz.com/";
    String HOST_SITE_HTTP = "http://hyu3451540001.my3w.com/public/api/";

    String GETPRODUCTLIST = "getProductList";//获取商品列表

    //    String GET_COMMING_MOVIE = "v2/movie/coming_soon";
    String GETINDEXTOPBANNERINFO = "getIndexTopBannerInfo";
    //发送手机号获取验证码
    String POSTMOBILEVERIFICATIONCODE = "postMobileVerificationCode";
    //注册新用户
    String POSTADDREGISTERUSERINFO = "addregisterUserInfo";
    //用户登录
    String POSTLOGINUSERINFO = "postLoginUserInfo";
    //用户中心获取用户信息
    String POSTUSERCENTERINFO = "userCenterInfo";
    //上传头像
    String UPLOADIMAGE = "uploadImage";
    //获取用户信息
    String GETUSERINFO="getUserInfo";
    //修改用户基本资料
    String UPDATEUSERINFO="updateUserInfo";

    //地址
    //新增地址
    String ADDUSERADDRESSINFO="addUserAddressInfo";
    //修改用户地址信息
    String EDITUSERADDRESSINFO="editUserAddressInfo";
    //获取用户地址列表信息
    String GETUSERADDRESSLISTINFO="getUserAddressListInfo";
    //修改用户默认地址信息
    String UPDATEUSERDEFAULTADDRESS="updateUserDefaultAddress";
    //删除用户地址信息
    String DELETEUSERADDRESSINFO="deleteUserAddressInfo";
    //获取全部省信息
    String GETALLPROVINCE="getAllProvince";
    //根据省ID 获取全部城市信息
    String GETALLCITYWITHPROVINCEID="getAllCityWithProvinceId";
    //根据城市ID 获取全部地区信息
    String GETALLDISTRICTWITHCITYID="getAllDistrictWithCityId";

    //商品分类名

}
