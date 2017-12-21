package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/12/7.
 * 单个页面中的数据
 */

public class ProductTypeItemRes {
    private String name;//名称
    private String id;//分类id
    private int dataType;//用来判断来数据是头，还是具体的小分类
    private String mCategotyMobilePic;//图片路径

    public ProductTypeItemRes(String name, String id, int dataType, String mCategotyMobilePic) {
        this.name = name;
        this.id = id;
        this.dataType = dataType;
        this.mCategotyMobilePic = mCategotyMobilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getmCategotyMobilePic() {
        return mCategotyMobilePic;
    }

    public void setmCategotyMobilePic(String mCategotyMobilePic) {
        this.mCategotyMobilePic = mCategotyMobilePic;
    }

    @Override
    public String toString() {
        return "ProductTypeItemRes{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", dataType=" + dataType +
                ", mCategotyMobilePic='" + mCategotyMobilePic + '\'' +
                '}';
    }
}
