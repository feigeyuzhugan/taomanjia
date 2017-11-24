package com.zhongzi.taomanjia.app.constants;

/**
 * Created by Administrator on 2017/11/14.
 * 网络的URL路径
 */

public interface UrlConstants {
    //    String HOST_SITE_HTTPS = "https://api.douban.com/";
    String HOST_SITE_HTTP = "http://hyu3451540001.my3w.com/public/api/";

    String GETPRODUCTLIST = "getProductList";//获取商品列表

    //    String GET_COMMING_MOVIE = "v2/movie/coming_soon";
    String GETINDEXTOPBANNERINFO = "getIndexTopBannerInfo";
    //发送手机号获取验证码
    String POSTMOBILEVERIFICATIONCODE = "postMobileVerificationCode";
    //注册新用户
    String POSTADDREGISTERUSERINFO = "addregisterUserInfo";
    //用户登录
    String POSTLOGINUSERINFO="postLoginUserInfo";
    //用户中心获取用户信息
   String POSTUSERCENTERINFO="userCenterInfo";
}
