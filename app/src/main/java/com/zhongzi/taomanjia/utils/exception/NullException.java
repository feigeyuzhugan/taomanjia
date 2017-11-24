package com.zhongzi.taomanjia.utils.exception;

/**
 * Created by Administrator on 2017/11/20.
 * 自定义异常中的参数不能为null的异常
 */
public class NullException extends RuntimeException {
    static final long serialVersionUID = -3387516993124229948L;
    public NullException(){
    }
    public NullException(String msg){
        super(msg);
    }

}
