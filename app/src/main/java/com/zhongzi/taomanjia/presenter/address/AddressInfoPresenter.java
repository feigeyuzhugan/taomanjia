package com.zhongzi.taomanjia.presenter.address;

import android.content.Context;

import com.zhongzi.taomanjia.model.AddressModel;
import com.zhongzi.taomanjia.model.LoginModel;
import com.zhongzi.taomanjia.model.entity.res.address.AddressInfoRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddAddressView;
import com.zhongzi.taomanjia.presenter.iView.IAddressInfoView;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.loadlayout.LoadLayout;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4.
 */

public class AddressInfoPresenter extends BasePresenter<IAddressInfoView>{
    private static final String TAG = AddAddressPresenter.class.getSimpleName();
    private AddressModel mAddressModel;
    private LoginModel mLoginModel;

//    private Map<String ,String> map=new HashMap<>();
    public AddressInfoPresenter(IAddressInfoView iAddAddressView) {
        super(iAddAddressView);
        mAddressModel = AddressModel.getInstance();
        mLoginModel=LoginModel.getInstance();
    }

    /**
     * 获取地址列表
     * @param context
     * @param loadLayout
     */
    public void getAddressList(Context context,final LoadLayout loadLayout){
        String userid=mLoginModel.getUserId(context);
        mAddressModel.getUserAddressListInfo(userid, new HttpArrayObserver<AddressInfoRes>() {
            @Override
            public void onNext(String title, List<AddressInfoRes> t) {
                if (t==null||t.isEmpty()){
                    loadLayout.setLayoutState(State.NO_DATA);
                    return;
                }
                mIView.success(t);
            }

            @Override
            public void onError(int errType, String errMessage) {
                loadLayout.setLayoutState(State.FAILED);
            }
        },mIView.getLifeSubject());
    }

    public void deleteUserAddressInfo(String id, Context context,final LoadLayout loadLayout){
        String userid=mLoginModel.getUserId(context);
        mAddressModel.deleteUserAddressInfo(userid,id, new HttpObserver<String>() {
            @Override
            public void onNext(String title, String t) {
                if (t==null||t.isEmpty()){
                    loadLayout.setLayoutState(State.NO_DATA);
                    return;
                }

            }

            @Override
            public void onError(int errType, String errMessage) {
                loadLayout.setLayoutState(State.FAILED);
            }
        },mIView.getLifeSubject());
    }

}