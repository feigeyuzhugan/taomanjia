package com.zhongzi.taomanjia.presenter.user;

import com.zhongzi.taomanjia.model.BankcardModel;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.model.entity.eventbus.user.BankcardInfo;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IAddBankcardView;
import com.zhongzi.taomanjia.utils.ToastUtil;
import com.zhongzi.taomanjia.utils.exception.NullException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/8.
 * 添加银行卡
 */

public class AddBankcardPresenter extends BasePresenter<IAddBankcardView>{

    private static final String TAG = AddBankcardPresenter.class.getSimpleName();
    private BankcardModel mBankcardModel;
    private String name;
    private Map<String ,String> map;

    public AddBankcardPresenter(IAddBankcardView iAddBankcardView) {
        super(iAddBankcardView);
        mBankcardModel = BankcardModel.getInstance();
        name=UserInfoSP.getInstance().getUserName();
    }

    public void addMyBankInfo(BankcardInfo info){
        if (getBankcardMap(info)) return;
        mBankcardModel.addMyBankInfo(map, new HttpObserver<String>() {
            @Override
            public void onNext(String title, String s) {
                mIView.success(s);
            }

            @Override
            public void onError(int errType, String errMessage) {

            }
        },mIView.getLifeSubject());
    }

    /**
     * 将添加银行卡的信息，转变成一个map
     * @param info
     * @return
     */
    private boolean getBankcardMap(BankcardInfo info) {
        map=new HashMap<>();
        try {
            map.put("username", name);
            map.put("bankinfo", info.getBankinfo());
            map.put("cardnumber", info.getCardnumber());
            map.put("cardusername", info.getCardusername());
            return false;
        }catch (NullException e){
            ToastUtil.show(e.getMessage());
            return true;
        }
    }



}
