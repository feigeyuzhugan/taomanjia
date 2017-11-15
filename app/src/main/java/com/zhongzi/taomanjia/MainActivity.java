package com.zhongzi.taomanjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhongzi.taomanjia.model.BannerInfoModel;
import com.zhongzi.taomanjia.model.entity.res.BannerInfoRes;
import com.zhongzi.taomanjia.model.net.HttpObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.presenter.BannerPresenter;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iPresenter.IBannerPresenter;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity implements IBannerPresenter{

    private BannerPresenter bannerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new Bann
        bannerPresenter=new BannerPresenter(this);
        bannerPresenter.getBannerInfo();
    }

    @Override
    public void getBannerInfoSuccess(List<BannerInfoRes> list) {
        Log.e( "getBannerInfoSuccess: ", list.get(0).toString());
    }

    @Override
    public PublishSubject<LifeCycleEvent> getLifeSubject() {
        return PublishSubject.create();
    }
}
