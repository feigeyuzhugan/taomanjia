package com.zhongzi.taomanjia.model.entity.res.base;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 *
 */

public class HttpArrayResult<T> {

    private boolean code;//请求的码
    private String message;//请求结果的描述
    private List<T> info;//返回的数据内容，类型不确定，使用泛型T表示

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getInfo() {
        return info;
    }

    public void setInfo(List<T> info) {
        this.info = info;
    }
}
