package com.zhongzi.taomanjia.app.constants;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.model.entity.res.UserCenterRes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心中的数据
 */

public class UserCenterConstans {
    private static List<UserCenterRes> list=new ArrayList<>();
    private static String[] texts = {
            // 九宫格图片下方文字的设置
            "全部订单", "我的收藏", "我的消费", "我的地址", "我的资料", "我的银行卡", "安全中心",
            "我分享的用户", "我的二维码","App下载二维码", "系统通知", "联系客服"};//, "领袖系统"
    private static Integer[] images = {R.drawable.user_gv_0, R.drawable.user_gv_1, R.drawable.user_gv_2, R.drawable.user_gv_3, R.drawable.user_gv_4, R.drawable.user_gv_5,
            R.drawable.user_gv_6, R.drawable.user_gv_7, R.drawable.user_gv_8,
            R.drawable.user_gv_9, R.drawable.user_gv_10, R.drawable.user_gv_11};//, R.drawable.user_gv_12

    /**
     * 返回的是个人中心的数据
     * @return
     */
    public static List<UserCenterRes> getUserCenterList(){
        for (int i=0;i<texts.length;i++){
            list.add(new UserCenterRes(texts[i],images[i]));
        }
        return list;
    }
}
