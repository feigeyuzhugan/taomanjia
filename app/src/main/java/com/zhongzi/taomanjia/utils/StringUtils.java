package com.zhongzi.taomanjia.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/11/17.
 * 一些字符串的工具类
 */

public class StringUtils  {

    /**
     * 手机号码的格式验证
     * @param
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
        Matcher m = p.matcher(mobiles);
        return m.find();
    }
}
