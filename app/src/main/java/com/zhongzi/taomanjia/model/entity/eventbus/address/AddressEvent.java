package com.zhongzi.taomanjia.model.entity.eventbus.address;

/**
 * Created by Administrator on 2017/12/1.
 *  地址中用到的event
 *
 *  type中的值的意义
 *  地址列表中的
 *  1，默认----地址列表中的
 *  2，编辑----
 *  3，删除
 *  -----------------
 */

public class AddressEvent  {
    private int type;
    private int position;

    public AddressEvent(int type, int position) {
        this.type = type;
        this.position = position;
    }

    public AddressEvent(int type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
