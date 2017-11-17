package com.zhongzi.taomanjia.model.entity.eventbus.register;

import com.zhongzi.taomanjia.utils.ToastUtil;

/**
 * Created by Administrator on 2017/11/17.
 * 注册新用户
 */

public class RegCommitEvent {

    private String userName;//用户名
    private String name;//真实姓名
    private String newPwd;//密码
    private String checkPwd;//确认密码
    private String Introducer;//推荐人

    public RegCommitEvent(String userName,  String name, String newPwd, String checkPwd, String introducer) {
        this.userName = userName;
        this.name = name;
        this.newPwd = newPwd;
        this.checkPwd = checkPwd;
        Introducer = introducer;
    }

    public String getUserName() {
        if (userName==null){
            ToastUtil.show("用户名不能为空");
            return null;
        }
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        if (name==null){
            ToastUtil.show("真实用户名不能为空");
            return null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPwd() {
        if (newPwd==null){
            ToastUtil.show("密码不能为空");
            return null;
        }
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getCheckPwd() {
        if (checkPwd==null){
            ToastUtil.show("密码不能为空");
            return null;
        }
        if (!checkPwd.equals(newPwd)){
            ToastUtil.show("两次密码不一致");
            return null;
        }
        return checkPwd;
    }

    public void setCheckPwd(String checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getIntroducer() {
        if (Introducer==null){
            ToastUtil.show("密码不能为空");
            return null;
        }
        return Introducer;
    }

    public void setIntroducer(String introducer) {
        Introducer = introducer;
    }
}
