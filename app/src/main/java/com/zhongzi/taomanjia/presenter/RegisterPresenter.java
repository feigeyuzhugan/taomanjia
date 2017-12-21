package com.zhongzi.taomanjia.presenter;

import android.util.Log;

import com.zhongzi.taomanjia.model.RegisterModel;
import com.zhongzi.taomanjia.model.entity.eventbus.register.RegCommitEvent;
import com.zhongzi.taomanjia.model.entity.res.RegPhoneNumCheckRes;
import com.zhongzi.taomanjia.model.entity.res.RegUserRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IRegView;
import com.zhongzi.taomanjia.utils.StringUtils;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;
import com.zhongzi.taomanjia.utils.log.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/17.
 * 注册界面的Presenter
 */

public class RegisterPresenter extends BasePresenter<IRegView> {

    private RegisterModel mRegisterModel;
    private RegPhoneNumCheckRes mRegPhoneNumCheckRes;//手机号返回的值

    public RegisterPresenter (IRegView regPresenter){
        super(regPresenter);
        mRegisterModel=RegisterModel.getInstance();
    }

    /**
     * 发送短信
     * @param phoneNum
     */
    public void postPhoneNum(String phoneNum){
        if (!StringUtils.isMobileNO(phoneNum)){
            ToastUtil.show("手机号格式不正确");
            return;
        }
        mRegisterModel.postPhoneNum(phoneNum,"register", new HttpObserver<RegPhoneNumCheckRes>() {
            @Override
            public void onNext(String title, RegPhoneNumCheckRes regPhoneNumCheckRes) {
                mRegPhoneNumCheckRes=regPhoneNumCheckRes;
            }
            @Override
            public void onError(int errType, String errMessage) {
                LogUtil.e("手机号：",errMessage);
            }
        },mIView.getLifeSubject());
    }

    /**
     * 验证手机号是否正确
     * @param code
     */
    public void checkCode(String code){
        if (mRegPhoneNumCheckRes==null){
            ToastUtil.show("请输入手机号");
            return;
        }
       int code1=Integer.parseInt(code);
        if (code1==mRegPhoneNumCheckRes.getCode()){
            mIView.next();
        }else {
            ToastUtil.show("验证码不正确");
        }
    }

    /**
     * 注册用户
     * @param regcommitevent
     */
    public void registerUser(RegCommitEvent regcommitevent){
        if (regcommitevent!=null){
            try {
                Map<String,String> map=new HashMap<>();
                String userName=regcommitevent.getUserName();
                String mobile=mRegPhoneNumCheckRes.getPhone();
                String name=regcommitevent.getName();
                String newPwd=regcommitevent.getNewPwd();
                String checkPwd=regcommitevent.getCheckPwd();
                String Introducer=regcommitevent.getIntroducer();
                map.put("userName",userName);
                map.put("mobile",mobile);
                map.put("name",name);
                map.put("newPwd",newPwd);
                map.put("checkPwd",checkPwd);
                map.put("Introducer",Introducer);
                mRegisterModel.postRegisterUser(map, new HttpObserver<RegUserRes>() {
                    @Override
                    public void onNext(String title, RegUserRes regUserRes) {
                        mIView.regSuccess(title);
                    }
                    @Override
                    public void onError(int errType, String errMessage) {
                        LogUtil.e(errMessage);
                    }
                },mIView.getLifeSubject());
            }catch (NullException e){
                ToastUtil.show(e.getMessage());
            }
        }else {
            ToastUtil.show("用户信息不能为空...");
        }
    }
}
