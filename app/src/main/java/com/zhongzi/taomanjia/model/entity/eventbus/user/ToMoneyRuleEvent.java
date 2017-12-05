package com.zhongzi.taomanjia.model.entity.eventbus.user;

/**
 * Created by Administrator on 2017/11/30.
 * 到分享，盛世等的规则
 */

public class ToMoneyRuleEvent {
    private int type;

    public ToMoneyRuleEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ToMoneyRuleEvent{" +
                "type=" + type +
                '}';
    }
}
