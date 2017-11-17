package com.zhongzi.taomanjia.model.entity.eventbus.register;

/**
 * Created by Administrator on 2017/11/17.
 * 点击下一页
 */

public class RegNextEvent {
    private String code;

    public RegNextEvent(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
