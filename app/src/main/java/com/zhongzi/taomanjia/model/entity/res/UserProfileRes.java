package com.zhongzi.taomanjia.model.entity.res;

import com.zhongzi.taomanjia.utils.log.LogUtil;

/**
 * Created by Administrator on 2017/12/1.
 * 用户的数据信息
 */

public class UserProfileRes {


    /**
     * id : 22597
     * userName : 测试
     * sex : 2
     * birthday : null
     * blog : null
     * photo : /newshoptest/20171129/7bb07af5c5eaf0bf5b45f130bf7c2d4a.jpg
     * intro : null
     * registTime : 2017-11-23 10:52:49
     * editTime : null
     * email : null
     * isEmailConfirm : 0
     * verificationCode : null
     * password : F59094271D8D48D1B6261C9E96B2DE57510295FB
     * lastTime : 2017-12-01 11:08:12
     * userStatus : 1
     * year : 0
     * month : 0
     * day : 0
     * websit : null
     * uid : null
     * realName : 测试
     * Phone : 13697404321
     * unitCode : null
     * maritalstatus : 0
     * identityCardNo : null
     * verificationCodeSendTime : null
     * referrerPhone : 123456789
     * userType : 0
     * DoersType : 0
     * LinkUrl : null
     * QrCode : null
     * CompanyName : null
     * BaseCourseId : 0
     * BasePeriodsId : 0
     * weiXinOpenId : null
     * referrer : null
     * ProvinceID : 0
     * CityID : 0
     * DistrictID : 0
     * AreaId : 0
     * Participate : null
     * CertificateTypeId : 0
     * RegistFrom : weixin
     * BankNo : null
     * BankAccountName : null
     * Onepassword : null
     * Twopassword : null
     * ContactAddress : null
     */

    private String id;
    private String userName;
    private String sex;
    private Object birthday;
    private Object blog;
    private String photo;
    private Object intro;
    private String registTime;
    private Object editTime;
    private Object email;
    private String isEmailConfirm;
    private Object verificationCode;
    private String password;
    private String lastTime;
    private String userStatus;
    private String year;
    private String month;
    private String day;
    private Object websit;
    private Object uid;
    private String realName;
    private String Phone;
    private Object unitCode;
    private String maritalstatus;
    private Object identityCardNo;
    private Object verificationCodeSendTime;
    private String referrerPhone;
    private String userType;
    private String DoersType;
    private Object LinkUrl;
    private Object QrCode;
    private Object CompanyName;
    private String BaseCourseId;
    private String BasePeriodsId;
    private Object weiXinOpenId;
    private Object referrer;
    private String ProvinceID;
    private String CityID;
    private String DistrictID;
    private String AreaId;
    private Object Participate;
    private String CertificateTypeId;
    private String RegistFrom;
    private Object BankNo;
    private Object BankAccountName;
    private Object Onepassword;
    private Object Twopassword;
    private Object ContactAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        LogUtil.e(sex);
        int tag=Integer.parseInt(sex);
        if (tag==0){
            return "女";
        }else if (tag==1){
            return "男";
        }else if (tag==2){
            return "保密";
        }else {
            return "其他";
        }
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getBlog() {
        return blog;
    }

    public void setBlog(Object blog) {
        this.blog = blog;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Object getIntro() {
        return intro;
    }

    public void setIntro(Object intro) {
        this.intro = intro;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public Object getEditTime() {
        return editTime;
    }

    public void setEditTime(Object editTime) {
        this.editTime = editTime;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getIsEmailConfirm() {
        return isEmailConfirm;
    }

    public void setIsEmailConfirm(String isEmailConfirm) {
        this.isEmailConfirm = isEmailConfirm;
    }

    public Object getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Object verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Object getWebsit() {
        return websit;
    }

    public void setWebsit(Object websit) {
        this.websit = websit;
    }

    public Object getUid() {
        return uid;
    }

    public void setUid(Object uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Object getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Object unitCode) {
        this.unitCode = unitCode;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public Object getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(Object identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public Object getVerificationCodeSendTime() {
        return verificationCodeSendTime;
    }

    public void setVerificationCodeSendTime(Object verificationCodeSendTime) {
        this.verificationCodeSendTime = verificationCodeSendTime;
    }

    public String getReferrerPhone() {
        return referrerPhone;
    }

    public void setReferrerPhone(String referrerPhone) {
        this.referrerPhone = referrerPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDoersType() {
        return DoersType;
    }

    public void setDoersType(String DoersType) {
        this.DoersType = DoersType;
    }

    public Object getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(Object LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    public Object getQrCode() {
        return QrCode;
    }

    public void setQrCode(Object QrCode) {
        this.QrCode = QrCode;
    }

    public Object getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(Object CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getBaseCourseId() {
        return BaseCourseId;
    }

    public void setBaseCourseId(String BaseCourseId) {
        this.BaseCourseId = BaseCourseId;
    }

    public String getBasePeriodsId() {
        return BasePeriodsId;
    }

    public void setBasePeriodsId(String BasePeriodsId) {
        this.BasePeriodsId = BasePeriodsId;
    }

    public Object getWeiXinOpenId() {
        return weiXinOpenId;
    }

    public void setWeiXinOpenId(Object weiXinOpenId) {
        this.weiXinOpenId = weiXinOpenId;
    }

    public Object getReferrer() {
        return referrer;
    }

    public void setReferrer(Object referrer) {
        this.referrer = referrer;
    }

    public String getProvinceID() {
        return ProvinceID;
    }

    public void setProvinceID(String ProvinceID) {
        this.ProvinceID = ProvinceID;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String CityID) {
        this.CityID = CityID;
    }

    public String getDistrictID() {
        return DistrictID;
    }

    public void setDistrictID(String DistrictID) {
        this.DistrictID = DistrictID;
    }

    public String getAreaId() {
        return AreaId;
    }

    public void setAreaId(String AreaId) {
        this.AreaId = AreaId;
    }

    public Object getParticipate() {
        return Participate;
    }

    public void setParticipate(Object Participate) {
        this.Participate = Participate;
    }

    public String getCertificateTypeId() {
        return CertificateTypeId;
    }

    public void setCertificateTypeId(String CertificateTypeId) {
        this.CertificateTypeId = CertificateTypeId;
    }

    public String getRegistFrom() {
        return RegistFrom;
    }

    public void setRegistFrom(String RegistFrom) {
        this.RegistFrom = RegistFrom;
    }

    public Object getBankNo() {
        return BankNo;
    }

    public void setBankNo(Object BankNo) {
        this.BankNo = BankNo;
    }

    public Object getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(Object BankAccountName) {
        this.BankAccountName = BankAccountName;
    }

    public Object getOnepassword() {
        return Onepassword;
    }

    public void setOnepassword(Object Onepassword) {
        this.Onepassword = Onepassword;
    }

    public Object getTwopassword() {
        return Twopassword;
    }

    public void setTwopassword(Object Twopassword) {
        this.Twopassword = Twopassword;
    }

    public Object getContactAddress() {
        return ContactAddress;
    }

    public void setContactAddress(Object ContactAddress) {
        this.ContactAddress = ContactAddress;
    }
}
