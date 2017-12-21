package com.zhongzi.taomanjia.model.entity.res.user;

/**
 * Created by Administrator on 2017/12/8.
 * 银行卡信息
 */
public class BankcardRes {

    /**
     * Id : 313
     * UserAccount : 测试
     * BankId : 0
     * BankNo : 上海XXXX银行XX支行
     * BankAccountName : 320055558888888874
     * UserType : 1
     * Userstatus : 1
     * BankName : 张三
     * CreateTime : 2017-12-08 14:47:32
     * ApprovalTime : null
     * ApprovalName : null
     * status : 未审核
     */

    private String Id;
    private String UserAccount;
    private String BankId;
    private String BankNo;
    private String BankAccountName;
    private String UserType;
    private String Userstatus;
    private String BankName;
    private String CreateTime;
    private Object ApprovalTime;
    private Object ApprovalName;
    private String status;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getBankId() {
        return BankId;
    }

    public void setBankId(String BankId) {
        this.BankId = BankId;
    }

    public String getBankNo() {
        return BankNo;
    }

    public void setBankNo(String BankNo) {
        this.BankNo = BankNo;
    }

    public String getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(String BankAccountName) {
        this.BankAccountName = BankAccountName;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getUserstatus() {
        return Userstatus;
    }

    public void setUserstatus(String Userstatus) {
        this.Userstatus = Userstatus;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public Object getApprovalTime() {
        return ApprovalTime;
    }

    public void setApprovalTime(Object ApprovalTime) {
        this.ApprovalTime = ApprovalTime;
    }

    public Object getApprovalName() {
        return ApprovalName;
    }

    public void setApprovalName(Object ApprovalName) {
        this.ApprovalName = ApprovalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
