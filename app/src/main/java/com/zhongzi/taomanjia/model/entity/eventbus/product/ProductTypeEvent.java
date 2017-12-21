package com.zhongzi.taomanjia.model.entity.eventbus.product;

/**
 * Created by Administrator on 2017/12/8.
 * 分类列表
 */

public class ProductTypeEvent {
    private String title;
    private String id;

    public ProductTypeEvent(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductTypeEvent{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
