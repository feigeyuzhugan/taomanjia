package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 * 分类
 */

public interface IProductTypeView extends IBaseView{
    void success(List<String> list);
    void error();
}
