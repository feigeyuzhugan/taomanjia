package com.zhongzi.taomanjia.model.entity.res.address;

/**
 * Created by Administrator on 2017/12/1.
 * 省
 */

public class AddressProvinceRes {

    /**
     * ProvinceID : 116
     * ProvinceName : 北京市
     */

    private String ProvinceID;
    private String ProvinceName;

    public String getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(String ProvinceID) {
        this.ProvinceID = ProvinceID;
    }

    public String getProvinceName() {
        return ProvinceName;
    }

    public void setProvinceName(String ProvinceName) {
        this.ProvinceName = ProvinceName;
    }

    @Override
    public String toString() {
        return "AddressProvinceRes{" +
                "ProvinceID='" + ProvinceID + '\'' +
                ", ProvinceName='" + ProvinceName + '\'' +
                '}';
    }
}
