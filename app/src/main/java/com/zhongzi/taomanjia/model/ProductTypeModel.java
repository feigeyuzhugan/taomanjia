package com.zhongzi.taomanjia.model;

import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeItemRes;
import com.zhongzi.taomanjia.model.entity.res.ProductTypeRes;
import com.zhongzi.taomanjia.model.entity.res.address.AddressProvinceRes;
import com.zhongzi.taomanjia.model.net.HttpArrayObserver;
import com.zhongzi.taomanjia.model.net.LifeCycleEvent;
import com.zhongzi.taomanjia.model.net.RetrofitUtil;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Administrator on 2017/12/6.
 * 分类
 */

public class ProductTypeModel {
    public static ProductTypeModel getInstance() {
        return ProductTypeModel.SingletonHolder.instance;
    }
    //所有的数据
    private List<ProductTypeRes> mProductTypeResList=new ArrayList<>();
    //分类名数据
    private List<String> titleList=new ArrayList<>();
    private List<ProductTypeRes.Child1Bean> mChild1BeanList=new ArrayList<>();
    private int pagerPosition;//大分类的序列号

    private List<ProductTypeItemRes> mProductTypeItemResList=new ArrayList<>();//例如：食品饮料界面的所有信息---一个界面
    private ProductTypeItemRes mProductTypeItem;//
    private ProductTypeRes.Child1Bean mChild1Bean;//
    private ProductTypeRes.Child1Bean.Child2Bean mChild2Bean;//
    public int getPagerPosition() {
        return pagerPosition;
    }

    public void setPagerPosition(int pagerPosition) {
        this.pagerPosition = pagerPosition;
    }



    private static class SingletonHolder {
        private static final ProductTypeModel instance = new ProductTypeModel();
    }

    private ProductTypeModel() {
    }

    /**
     * 获取所有的分类信息
     * @param observer
     * @param lifecycleSubject
     */
    public void getProudctCategroyInfo(HttpArrayObserver<ProductTypeRes> observer, PublishSubject<LifeCycleEvent> lifecycleSubject){
        Observable observable= RetrofitUtil.getApiService().getProudctCategroyInfo();
        RetrofitUtil.composeToSubscribe(observable,observer,lifecycleSubject);
    }

    /**
     *
     * @param productTypeResList
     */
    public void setProductTypeResList(List<ProductTypeRes> productTypeResList) {
        this.mProductTypeResList = productTypeResList;
    }

    public List<ProductTypeRes> getProductTypeResList() {
        return mProductTypeResList;
    }

    /**
     * 根据position获取对应的一个ProductTypeRes数据
     * @return
     */
    public ProductTypeRes getProductTypeRes(){
        return mProductTypeResList.get(getPagerPosition());
    }

    /**
     * 多少分类
     * @return
     */
    private int producetSize(){
        return mProductTypeResList.size();
    }

    //获取所有的分类
    public List<String> getProducetName(){
        int size=producetSize();
        titleList.clear();
        for (int i=0;i<size;i++){
            titleList.add(getProductTypeResList().get(i).getName());
        }
        return titleList;
    }

    //在下面一层
    /**
     * 获取大类下面的小的分类的集合
     * @return
     */
    public List<ProductTypeRes.Child1Bean> getChild1BeanList() {
        return getProductTypeRes().getChild_1();
    }

    /**
     * 获取小分类的分类名
     * @param position
     * @return
     */
    public String getChild1BeanName(int position){
        return getChild1BeanList().get(position).getGroupName();
    }

    /**
     * 获取Child2Bean数据集合
     * @param position
     * @return
     */
    public List<ProductTypeRes.Child1Bean.Child2Bean> getChild2BeanList(int position){
        return getChild1BeanList().get(position).getChild_2();
    }

    /**
     * 例如----食品饮料下有多少小的分类
     * @return
     */
    private int getProductItemSize() {
        return getChild1BeanList().size();
    }


    /**
     *
     * @return
     */
    public List<ProductTypeItemRes> getProductTypeItemResList(){
        int size=getProductItemSize();
        int sizeBean2=0;
        mProductTypeItemResList.clear();
        for (int i=0;i<size;i++){
            mChild1Bean=getChild1BeanList().get(i);
            mProductTypeItem=new ProductTypeItemRes(mChild1Bean.getGroupName(),null, BaseConstants.PRODUCT_DATA_HEADER,null);
            mProductTypeItemResList.add(mProductTypeItem);
            sizeBean2=mChild1Bean.getChild_2().size();
            for (int j=0;j<sizeBean2;j++){
                mChild2Bean=mChild1Bean.getChild_2().get(j);
                mProductTypeItem=new ProductTypeItemRes(mChild2Bean.getName(),mChild2Bean.getId(), BaseConstants.PRODUCT_DATA_ITEM,mChild2Bean.getCategotyMobilePic());
                mProductTypeItemResList.add(mProductTypeItem);
            }
        }
        return mProductTypeItemResList;
    }
}
