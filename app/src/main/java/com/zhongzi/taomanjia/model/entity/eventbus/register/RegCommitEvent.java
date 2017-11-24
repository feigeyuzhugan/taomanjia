package com.zhongzi.taomanjia.model.entity.eventbus.register;

import android.support.annotation.NonNull;

import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;

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
    private boolean tag;//判断内部是否有为空的
    public RegCommitEvent(@NonNull String userName, @NonNull  String name,@NonNull  String newPwd,@NonNull  String checkPwd,@NonNull  String introducer) {
        this.userName = userName;
        this.name = name;
        this.newPwd = newPwd;
        this.checkPwd = checkPwd;
        Introducer = introducer;
    }

    public String getUserName() {
        if (userName==null||userName.isEmpty()){
//            ToastUtil.show("用户名不能为空");
//            tag=true;
            throw new NullException("用户名不能为空");
        }
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getName() {
        if (name==null||name.isEmpty()){
//            ToastUtil.show("真实用户名不能为空");
//            tag=true;
            throw new NullException("真实用户名不能为空");
        }
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getNewPwd() {
        if (newPwd==null||newPwd.isEmpty()){
//            ToastUtil.show("密码不能为空");
            throw new NullException("密码不能为空");
        }
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getCheckPwd() {
        if (checkPwd==null||checkPwd.isEmpty()){
//            ToastUtil.show("密码不能为空");
            throw new NullException("密码不能为空");
//            return null;
        }
        if (!checkPwd.equals(newPwd)){
//            ToastUtil.show("两次密码不一致");
            throw new NullException("密码不能为空");
//            return null;
        }
        return checkPwd;
    }

    public void setCheckPwd(@NonNull String checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getIntroducer() {
        if (Introducer==null||Introducer.isEmpty()){
//            ToastUtil.show("密码不能为空");
            throw new NullException("分享人不能为空");
//            return null;
        }
        return Introducer;
    }

    public void setIntroducer(String introducer) {
        Introducer = introducer;
    }
}
