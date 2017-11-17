package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/11/17.
 * 注册用户成功返回的数据
 */

public class RegUserRes {

    /**
     * userName : 测试
     * sex : 2
     * password : F59094271D8D48D1B6261C9E96B2DE57510295FB
     * userStatus : 1
     * realName : 测试
     * Phone : 13697404967
     * referrerPhone : 123456789
     * RegistFrom : weixin
     * registTime : 2017-11-17 18:27:18
     */

    private String userName;
    private int sex;
    private String password;
    private int userStatus;
    private String realName;
    private String Phone;
    private String referrerPhone;
    private String RegistFrom;
    private String registTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
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

    public String getReferrerPhone() {
        return referrerPhone;
    }

    public void setReferrerPhone(String referrerPhone) {
        this.referrerPhone = referrerPhone;
    }

    public String getRegistFrom() {
        return RegistFrom;
    }

    public void setRegistFrom(String RegistFrom) {
        this.RegistFrom = RegistFrom;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "RegUserRes{" +
                "userName='" + userName + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", userStatus=" + userStatus +
                ", realName='" + realName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", referrerPhone='" + referrerPhone + '\'' +
                ", RegistFrom='" + RegistFrom + '\'' +
                ", registTime='" + registTime + '\'' +
                '}';
    }
}
