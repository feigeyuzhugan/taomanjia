package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/11/28.
 * 个人中心的九宫格数据
 */

public class UserCenterRes {
    private String name;
    private int id;//图片的id
//    private int type;//跳到那个activity

    public UserCenterRes(String name, int id) {
        this.name = name;
        this.id = id;
//        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }

    @Override
    public String toString() {
        return "UserCenterRes{" +
                "name='" + name + '\'' +
                ", id=" + id +
//                ", type=" + type +
                '}';
    }
}
