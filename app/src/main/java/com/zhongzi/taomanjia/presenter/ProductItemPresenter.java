package com.zhongzi.taomanjia.presenter;

import com.zhongzi.taomanjia.model.ProductTypeModel;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IProductItemView;
import com.zhongzi.taomanjia.view.widget.loadlayout.LoadLayout;
import com.zhongzi.taomanjia.view.widget.loadlayout.State;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 * 小分类-----分类页中的
 */

public class ProductItemPresenter extends BasePresenter<IProductItemView> {
    private ProductTypeModel mProductTypeModel;

    public ProductItemPresenter(IProductItemView iBaseView){
        super(iBaseView);
        mProductTypeModel=ProductTypeModel.getInstance();
    }

    /**
     *  第几页的数据
     */
    public void getProudctCategroyInfo(int position){
        mProductTypeModel.setPagerPosition(position);
        mIView.child1BeanList(mProductTypeModel.getProductTypeItemResList());
    }

}
