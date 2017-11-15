package com.zhongzi.taomanjia.model.entity.res;

/**
 * Created by Administrator on 2017/11/14.
 * 广告位的binder的数据的实体数据
 */

public class BannerInfoRes {

    /**
     * Id : 174378
     * PlateInfoId : 850
     * Title : 美妆彩妆
     * SortNum : 0
     * ProductId : 0
     * Path : http://files.china-xftz.com//advertisement/20171009/0bb721af-7b21-4a20-a0dd-acb51b44c91d.png
     * Price : 0
     * CreateTime : 2017-10-13 13:03:29
     * LinkUrl : #
     * Background_Color : null
     */

    private String Id;
    private String PlateInfoId;
    private String Title;
    private String SortNum;
    private String ProductId;
    private String Path;
    private String Price;
    private String CreateTime;
    private String LinkUrl;
    private Object Background_Color;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPlateInfoId() {
        return PlateInfoId;
    }

    public void setPlateInfoId(String PlateInfoId) {
        this.PlateInfoId = PlateInfoId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSortNum() {
        return SortNum;
    }

    public void setSortNum(String SortNum) {
        this.SortNum = SortNum;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(String LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    public Object getBackground_Color() {
        return Background_Color;
    }

    public void setBackground_Color(Object Background_Color) {
        this.Background_Color = Background_Color;
    }

    @Override
    public String toString() {
        return "BannerInfoRes{" +
                "Id='" + Id + '\'' +
                ", PlateInfoId='" + PlateInfoId + '\'' +
                ", Title='" + Title + '\'' +
                ", SortNum='" + SortNum + '\'' +
                ", ProductId='" + ProductId + '\'' +
                ", Path='" + Path + '\'' +
                ", Price='" + Price + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", LinkUrl='" + LinkUrl + '\'' +
                ", Background_Color=" + Background_Color +
                '}';
    }
}
