package com.zhongzi.taomanjia.model.entity.res.address;

/**
 * Created by Administrator on 2017/12/4.
 */

public class AddressInfoRes {

    /**
     * id : 10366
     * consignee : 测试
     * province : 116
     * city : 1148
     * detail : 上海市宝山区江场西路XX号
     * postCode : null
     * tel : null
     * phone : 18019747778
     * createTime : 2017-12-01 12:02:45
     * editTime : null
     * userId : 22597
     * email : null
     * Borough : null
     * district : 15571
     * consigneeAddress : 北京市北京市东城区上海市宝山区江场西路XX号
     * addressDetailP1 : null
     * addressDetailP2 : null
     * subDistrictId : 0
     * isDefault : 0
     */

    private String id;
    private String consignee;
    private String province;
    private String city;
    private String detail;
    private Object postCode;
    private Object tel;
    private String phone;
    private String createTime;
    private Object editTime;
    private String userId;
    private Object email;
    private Object Borough;
    private String district;
    private String consigneeAddress;
    private Object addressDetailP1;
    private Object addressDetailP2;
    private String subDistrictId;
    private String isDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getPostCode() {
        return postCode;
    }

    public void setPostCode(Object postCode) {
        this.postCode = postCode;
    }

    public Object getTel() {
        return tel;
    }

    public void setTel(Object tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getEditTime() {
        return editTime;
    }

    public void setEditTime(Object editTime) {
        this.editTime = editTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getBorough() {
        return Borough;
    }

    public void setBorough(Object Borough) {
        this.Borough = Borough;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public Object getAddressDetailP1() {
        return addressDetailP1;
    }

    public void setAddressDetailP1(Object addressDetailP1) {
        this.addressDetailP1 = addressDetailP1;
    }

    public Object getAddressDetailP2() {
        return addressDetailP2;
    }

    public void setAddressDetailP2(Object addressDetailP2) {
        this.addressDetailP2 = addressDetailP2;
    }

    public String getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "AddressInfoRes{" +
                "id='" + id + '\'' +
                ", consignee='" + consignee + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detail='" + detail + '\'' +
                ", postCode=" + postCode +
                ", tel=" + tel +
                ", phone='" + phone + '\'' +
                ", createTime='" + createTime + '\'' +
                ", editTime=" + editTime +
                ", userId='" + userId + '\'' +
                ", email=" + email +
                ", Borough=" + Borough +
                ", district='" + district + '\'' +
                ", consigneeAddress='" + consigneeAddress + '\'' +
                ", addressDetailP1=" + addressDetailP1 +
                ", addressDetailP2=" + addressDetailP2 +
                ", subDistrictId='" + subDistrictId + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
