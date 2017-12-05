package com.zhongzi.taomanjia.model.entity.res.address;

/**
 * Created by Administrator on 2017/12/1.
 * 地区
 */

public class AddressDistrictRes {

    /**
     * DistrictID : 15571
     * DistrictName : 东城区
     */

    private String DistrictID;
    private String DistrictName;

    public String getDistrictID() {
        return DistrictID;
    }

    public void setDistrictID(String DistrictID) {
        this.DistrictID = DistrictID;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    @Override
    public String toString() {
        return "AddressDistrictRes{" +
                "DistrictID='" + DistrictID + '\'' +
                ", DistrictName='" + DistrictName + '\'' +
                '}';
    }
}
