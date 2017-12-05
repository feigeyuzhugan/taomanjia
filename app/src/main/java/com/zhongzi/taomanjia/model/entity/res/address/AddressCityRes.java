package com.zhongzi.taomanjia.model.entity.res.address;

/**
 * Created by Administrator on 2017/12/1.
 * 城市
 */

public class AddressCityRes {

    /**
     * CityID : 1148
     * CityName : 北京市
     */

    private String CityID;
    private String CityName;

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String CityID) {
        this.CityID = CityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    @Override
    public String toString() {
        return "AddressCityRes{" +
                "CityID='" + CityID + '\'' +
                ", CityName='" + CityName + '\'' +
                '}';
    }
}
