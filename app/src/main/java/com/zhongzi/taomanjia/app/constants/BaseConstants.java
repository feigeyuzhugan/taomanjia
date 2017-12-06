package com.zhongzi.taomanjia.app.constants;

/**
 * Created by Administrator on 2017/11/14.
 * 常量类
 */

public interface BaseConstants {
    /*------------------------------------------ app文件存储模块  ------------------------------------------*/
    String APP_IMAGE = "image";               //应用图片存储目录名
    String APP_TMP = "temp";                  //应用临时文件目录名

    /*------------------------------------------ preference存储模块  -------------------------------------*/

    String APP_SHARE = "app_share";                         // 默认preference名字
    String APP_SHARE_USER = "app_user_share";               //用户sharePreference
    String APP_LOGIN_USER = "app_login_user";               //用户登录信息sharePreference

    //跳转的
    int ACTIVITY_ID=1;//用到activity跳转
    int NOT_ACTIVITYID=2;//不用到activity跳转
    boolean CHECK_LOGIN=false;//不需要判断是否登录
    int NOT_DATA=3;//加载成功，但没有数据
    //跳转的

    /*对应的界面参数*/
    int SETTING_ACTIVITY=1001;//设置界面
    int LOGIN_ACTIVITY=1002;//登录界面

    int TO_ALL_ORDERS=1003;//全部订单
    int MY_COLLECTION=1004;//我的收藏MY COLLECTION
    int MY_SPENDING=1005;//我的消费My spending
    int MY_ADDRESS=1006;//我的地址 myaddress

    int MY_PROFILE=1007;//我的资料MyProfile
    int MY_BANKCARD=1008;//我的银行卡 Mybankcard
    int SECURITY_CENTER=1009;//安全中心 Securitycenter
    int SHARE_THE_USER=1010;//我分享的用户 sharetheuser

    int MY_TWO_CODE=1011;//我的二维码 Mytwocode
    int APP_DOWNLOAD_CODE=1012;//App下载二维码 Appdownloadcode
    int SYSTEM_NOTIFICATION=1013;//系统通知 systemnotification
    int CONTACTCUS_TOME_RSERVICE=1014;//联系客服 ContactCustomerService

    int LEADER_SYSTEM=1015;//领袖系统 Leadersystem
//    int TOALLORDERS=1003;//我的地址 my address
    int ABOUT_US=1016;//关于我们
    int SUGGESTION=1017;//意见反馈
    int BINDIN_GBANKCARD=1018;//绑定银行卡

    int MONEY_CASH=1019;//现金账户
    int MONEY_PENSION=1020;//养老
    int MONEY_RED_ENVELOPES=1021;//红包
    int MONEY_SHARED=1022;//分享收益
    int MONEY_SPIRIT=1023;//盛世金元
    int MONEY_RULE=1024;//养老，红包等的规则

    int ADD_ADDRESS=1025;//新增地址
    int EDITOR_ADDRESS=1026;//新增地址




    /*对应的界面参数*/

    int PERMISSION_CAMERA=2001;//照相权限
//    int SETTINGACTIVITY=1001;
    int REQUEST_PICK_IMAGE=3001;//选择照片时的返回值
    int REQUEST_SELECT_CAMERA=3002;//照相返回
    int REQUEST_PICTURE_CUT=3003;//裁剪
    //---------------------------event相关的参数
    int UPLOADPHOTOS=4001;//上传照片

    //地址中用到的参数500X
    int ADDRESS_DEFAULT=5000;//默认
    int ADDRESS_EDITOR=5001;//编辑
    int ADDRESS_REMOVE=5002;//删除
    int DIALOG_REMOVE=5003;//dialog中的删除
    int ADDRESS_ADD_TO_USER=5004;//从添加地址到地址列表

}
