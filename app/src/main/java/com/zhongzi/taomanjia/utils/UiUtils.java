package com.zhongzi.taomanjia.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.activity.SettingActivity;
import com.zhongzi.taomanjia.view.activity.address.AddAddressActivity;
import com.zhongzi.taomanjia.view.activity.address.EditorAddressActivity;
import com.zhongzi.taomanjia.view.activity.bankcard.BindingBankcardActivity;
import com.zhongzi.taomanjia.view.activity.login.LoginActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneyCashActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneyPensionActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneyRedEnvelopesActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneyRuleActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneySharedActivity;
import com.zhongzi.taomanjia.view.activity.money.MoneySpiritActivity;
import com.zhongzi.taomanjia.view.activity.order.OrderAllActivity;
import com.zhongzi.taomanjia.view.activity.setting.AboutUsActivity;
import com.zhongzi.taomanjia.view.activity.setting.SuggestionActivity;
import com.zhongzi.taomanjia.view.activity.user.UserAddressActivity;
import com.zhongzi.taomanjia.view.activity.user.UserBankcardActivity;
import com.zhongzi.taomanjia.view.activity.user.UserCodeActivity;
import com.zhongzi.taomanjia.view.activity.user.UserCollectionActivity;
import com.zhongzi.taomanjia.view.activity.user.UserContactActivity;
import com.zhongzi.taomanjia.view.activity.user.UserDownloadActivity;
import com.zhongzi.taomanjia.view.activity.user.UserProfileActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSecuritycenterActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSharedActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSpendingActivity;
import com.zhongzi.taomanjia.view.activity.user.UserSystemActivity;

/**
 * Created by Administrator on 2017/6/19.
 */

public class UiUtils {

    /**
     * 跳转界面
     *
     * @param activity
     * @param homeActivityClass
     */
    public static void startActivity(Activity activity, Class homeActivityClass) {
        Intent intent = new Intent(activity.getApplicationContext(), homeActivityClass);
        activity.startActivity(intent);
    }
    /**
     * 跳转界面2
     *
     * @param
     */
    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }

    /**
     * 打电话
     * @param activity
     */
    public static void callPhone(Activity activity) {
        Intent intent=new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + "400-8200789");
        intent.setData(data);
        activity.startActivity(intent);
    }

    /**
     * 针对性的跳转
     * @param activity
     * @param type
     * @param islogin
     */
    public static void startActivity(Activity activity, int type,boolean islogin) {
        type=checkLogin(islogin,type);
        switch (type){
            case BaseConstants.SETTING_ACTIVITY://设置
                UiUtils.startActivity(activity, SettingActivity.class);
                break;
            case BaseConstants.LOGIN_ACTIVITY://登录
                UiUtils.startActivity(activity, LoginActivity.class);
                break;
            case BaseConstants.TO_ALL_ORDERS:
                UiUtils.startActivity(activity, OrderAllActivity.class);
                break;
            case BaseConstants.MY_COLLECTION://收藏
                UiUtils.startActivity(activity, UserCollectionActivity.class);
                break;
            case BaseConstants.MY_SPENDING://消费
                UiUtils.startActivity(activity, UserSpendingActivity.class);
                break;
            case BaseConstants.MY_ADDRESS://地址
                UiUtils.startActivity(activity, UserAddressActivity.class);
                break;
            case BaseConstants.MY_PROFILE://资料
                UiUtils.startActivity(activity, UserProfileActivity.class);
                break;
            case BaseConstants.MY_BANKCARD://银行
                UiUtils.startActivity(activity, UserBankcardActivity.class);
                break;
            case BaseConstants.SECURITY_CENTER://安全中心
                UiUtils.startActivity(activity, UserSecuritycenterActivity.class);
                break;
            case BaseConstants.SHARE_THE_USER://分享用户
                LogUtil.e("分享用户");
                UiUtils.startActivity(activity, UserSharedActivity.class);
                break;
            case BaseConstants.MY_TWO_CODE://分享二维码
                UiUtils.startActivity(activity, UserCodeActivity.class);
                break;
            case BaseConstants.APP_DOWNLOAD_CODE://下载二维码
                UiUtils.startActivity(activity, UserDownloadActivity.class);
                break;
            case BaseConstants.SYSTEM_NOTIFICATION://系统通知
                UiUtils.startActivity(activity, UserSystemActivity.class);
                break;
            case BaseConstants.CONTACTCUS_TOME_RSERVICE://联系客户
                UiUtils.startActivity(activity, UserContactActivity.class);
                break;
            case BaseConstants.ABOUT_US://关于我们
                UiUtils.startActivity(activity, AboutUsActivity.class);
                break;
            case BaseConstants.SUGGESTION://意见反馈
                UiUtils.startActivity(activity, SuggestionActivity.class);
                break;
            case BaseConstants.BINDIN_GBANKCARD://绑定银行卡
                UiUtils.startActivity(activity, BindingBankcardActivity.class);
                break;
            case BaseConstants.MONEY_CASH://现金账户
                UiUtils.startActivity(activity, MoneyCashActivity.class);
                break;
            case BaseConstants.MONEY_PENSION://养老
                UiUtils.startActivity(activity, MoneyPensionActivity.class);
                break;
            case BaseConstants.MONEY_RED_ENVELOPES://红包
                UiUtils.startActivity(activity, MoneyRedEnvelopesActivity.class);
                break;
            case BaseConstants.MONEY_SHARED://分享收益
                UiUtils.startActivity(activity, MoneySharedActivity.class);
                break;
            case BaseConstants.MONEY_SPIRIT://盛世金元
                UiUtils.startActivity(activity, MoneySpiritActivity.class);
                break;
            case BaseConstants.MONEY_RULE://盛世金元,分享等的规则
                UiUtils.startActivity(activity, MoneyRuleActivity.class);
                break;
            case BaseConstants.ADD_ADDRESS://新增地址
                UiUtils.startActivity(activity, AddAddressActivity.class);
                break;
            case BaseConstants.EDITOR_ADDRESS://修改地址
                UiUtils.startActivity(activity, EditorAddressActivity.class);
                break;
        }
    }
    /**
     * 检查是否登录
     */
    private static int checkLogin(boolean isNotLogin,int type){
        if (isNotLogin){
            return BaseConstants.LOGIN_ACTIVITY;
        }
        return type;
    }
}
