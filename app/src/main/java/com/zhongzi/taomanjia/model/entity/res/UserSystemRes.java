package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/12/8.
 * 系统消息
 */

public class UserSystemRes {


    /**
     * FORMID : b04c3063-5f26-42c0-85e8-87108bc6bb2c
     * MESSAGE : 【新品上架】鸿井堂即食阿胶糕。最纯正原产地直发，真空包装，承诺给您最好的阿胶。晶莹剔透，色如琥珀，胶香浓郁，真材实料。吃到的不只有美味，还有健康>>
     * REGISTRATIONID :
     * TYPE : All
     * KEYS : 23530
     * CTEATTIME : 2017/7/4 19:16:05
     * RESULT : True
     * PRESETTIME : 2017-07-05 10:00:00
     * STATUS : 1
     * SENDTIME : 2017/7/5 10:01:46
     */

    private String FORMID;
    private String MESSAGE;
    private String REGISTRATIONID;
    private String TYPE;
    private String KEYS;
    private String CTEATTIME;
    private String RESULT;
    private String PRESETTIME;
    private String STATUS;
    private String SENDTIME;

    public String getFORMID() {
        return FORMID;
    }

    public void setFORMID(String FORMID) {
        this.FORMID = FORMID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getREGISTRATIONID() {
        return REGISTRATIONID;
    }

    public void setREGISTRATIONID(String REGISTRATIONID) {
        this.REGISTRATIONID = REGISTRATIONID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getKEYS() {
        return KEYS;
    }

    public void setKEYS(String KEYS) {
        this.KEYS = KEYS;
    }

    public String getCTEATTIME() {
        return CTEATTIME;
    }

    public void setCTEATTIME(String CTEATTIME) {
        this.CTEATTIME = CTEATTIME;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getPRESETTIME() {
        return PRESETTIME;
    }

    public void setPRESETTIME(String PRESETTIME) {
        this.PRESETTIME = PRESETTIME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSENDTIME() {
        return SENDTIME;
    }

    public void setSENDTIME(String SENDTIME) {
        this.SENDTIME = SENDTIME;
    }

    @Override
    public String toString() {
        return "UserSystemRes{" +
                "FORMID='" + FORMID + '\'' +
                ", MESSAGE='" + MESSAGE + '\'' +
                ", REGISTRATIONID='" + REGISTRATIONID + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", KEYS='" + KEYS + '\'' +
                ", CTEATTIME='" + CTEATTIME + '\'' +
                ", RESULT='" + RESULT + '\'' +
                ", PRESETTIME='" + PRESETTIME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", SENDTIME='" + SENDTIME + '\'' +
                '}';
    }
}
