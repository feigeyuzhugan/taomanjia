package com.zhongzi.taomanjia.model.entity.eventbus.address;

/**
 * Created by Administrator on 2017/12/1.
 */

public class AddressEvent  {
    private int type;

    public AddressEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
