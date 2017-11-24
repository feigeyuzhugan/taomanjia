package com.zhongzi.taomanjia.model.entity.eventbus.forget;

/**
 * Created by Administrator on 2017/11/23.
 * 用于从个人中心跳转的到某个界面的event
 * 1，设置界面
 */
public class UserCenterToEvent {

    private int type;

    public UserCenterToEvent(int type) {
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
        return "UserCenterToEvent{" +
                "type=" + type +
                '}';
    }
}
