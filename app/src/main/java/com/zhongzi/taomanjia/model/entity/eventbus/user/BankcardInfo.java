package com.zhongzi.taomanjia.model.entity.eventbus.user;

import com.zhongzi.taomanjia.utils.exception.NullException;

/**
 * Created by Administrator on 2017/12/8.
 * 银行卡信息
 */

public class BankcardInfo {

    private String bankinfo;//开户行信息
    private String cardnumber;//银行卡号
    private String cardusername;//开户人名

    public BankcardInfo(String bankinfo, String cardnumber, String cardusername) {
        this.bankinfo = bankinfo;
        this.cardnumber = cardnumber;
        this.cardusername = cardusername;
    }

    public String getBankinfo() {
        if (this.bankinfo==null||bankinfo.isEmpty()){
            throw new NullException("开户行地址不能为空");
        }
        return bankinfo;
    }

    public void setBankinfo(String bankinfo) {
        this.bankinfo = bankinfo;
    }

    public String getCardnumber() {
        if (this.cardnumber==null||cardnumber.isEmpty()){
            throw new NullException("银行卡号不能为空");
        }
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardusername() {
        if (this.cardusername==null||cardusername.isEmpty()){
            throw new NullException("持卡人姓名不能为空");
        }
        return cardusername;
    }

    public void setCardusername(String cardusername) {
        this.cardusername = cardusername;
    }
}
