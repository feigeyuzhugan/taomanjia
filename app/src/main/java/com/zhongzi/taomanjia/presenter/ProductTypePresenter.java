package com.zhongzi.taomanjia.presenter;

import com.zhongzi.taomanjia.model.ProductTypeModel;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IProductTypeView;
import com.zhongzi.taomanjia.utils.log.LogUtil;
import com.zhongzi.taomanjia.view.widget.loadlayout.LoadLayout;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 * 大分类
 */

public class ProductTypePresenter extends BasePresenter<IProductTypeView> {
    private ProductTypeModel mProductTypeModel;

    public ProductTypePresenter(IProductTypeView iBaseView){
        super(iBaseView);
        mProductTypeModel=ProductTypeModel.getInstance();
    }

    /**
     *
     */
    public void getProudctCategroyInfo(){
//        loadLayout.setLayoutState(State.LOADING);
        mProductTypeModel.getProudctCategroyInfo(new HttpArrayObserver<ProductTypeRes>() {
            @Override
            public void onNext(String title, List<ProductTypeRes> list) {
//                loadLayout.setLayoutState(State.SUCCESS);
                mProductTypeModel.setProductTypeResList(list);
                mIView.success(mProductTypeModel.getProducetName());
            }

            @Override
            public void onError(int errType, String errMessage) {
//                loadLayout.setLayoutState(State.FAILED);
                mIView.error();
            }
        },mIView.getLifeSubject());
    }

}
