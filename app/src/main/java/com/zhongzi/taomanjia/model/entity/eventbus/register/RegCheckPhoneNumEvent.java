package com.zhongzi.taomanjia.model.entity.eventbus.register;

/**
 * Created by Administrator on 2017/11/16.
 * 注册验证码时的事件
 */

public class RegCheckPhoneNumEvent {
    private String phoneNum;//电话号码

    public RegCheckPhoneNumEvent(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
