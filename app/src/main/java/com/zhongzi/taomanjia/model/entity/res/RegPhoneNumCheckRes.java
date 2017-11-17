package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/11/17.
 * 发送手机号获取请求码
 */
public class RegPhoneNumCheckRes {

    /**
     * phone : 18019747776
     * code : 703737
     * use_type : 0
     * create_time : 2017-11-17 14:19:52
     */

    private String phone;
    private int code;
    private int use_type;
    private String create_time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getUse_type() {
        return use_type;
    }

    public void setUse_type(int use_type) {
        this.use_type = use_type;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "RegPhoneNumCheckRes{" +
                "phone='" + phone + '\'' +
                ", code=" + code +
                ", use_type=" + use_type +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
