package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.ProductTypeItemRes;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 * 小分类
 */

public interface IProductItemView extends IBaseView{
//    void success(List<String> list);
    void  child1BeanList(List<ProductTypeItemRes> productTypeItemRes);
}
