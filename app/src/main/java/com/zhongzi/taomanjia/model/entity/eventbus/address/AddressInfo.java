package com.zhongzi.taomanjia.model.entity.eventbus.address;

import com.zhongzi.taomanjia.utils.exception.NullException;

/**
 * Created by Administrator on 2017/12/4.
 * 就是添加地址的头字段
 */

public class AddressInfo {

    private String name;//姓名
    private String province;//省ID
    private String ctiy;//市id
    private String district;//区id

    private String detail;//详细地址
    private String phone;//手机号
    private String flag;//默认

    public AddressInfo(String name, String province, String ctiy, String district, String detail, String phone, String flag) {
        this.name = name;
        this.province = province;
        this.ctiy = ctiy;
        this.district = district;
        this.detail = detail;
        this.phone = phone;
        this.flag = flag;
    }

    public String getName() {
        if (name.isEmpty()){
            throw new NullException("用户名不能为空");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        if (province.isEmpty()){
            throw new NullException("省市区不能为空");
        }
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCtiy() {
        if (ctiy.isEmpty()){
            throw new NullException("省市区不能为空");
        }
        return ctiy;
    }

    public void setCtiy(String ctiy) {
        this.ctiy = ctiy;
    }

    public String getDistrict() {
        if (district.isEmpty()){
            throw new NullException("省市区不能为空");
        }
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        if (detail.isEmpty()){
            throw new NullException("详细地址不能为空");
        }
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhone() {
        if (phone.isEmpty()){
            throw new NullException("手机号不能为空");
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
