package com.zhongzi.taomanjia.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * Created by Administrator on 2017/7/27.
 * 针对textview控件提供的一些方法
 */

public class TextViewUtils {

    /**
     * 设置指定位置字的颜色,text是指传入的内容，from从那个位置开始更改，to到那个字，将指定的字改成color颜色
     * @param text
     * @param from
     * @param to
     * @param color
     * @return
     */
  public static SpannableStringBuilder setAppointWordColor(String text,int from,int to,int color){
      SpannableStringBuilder style=new SpannableStringBuilder(text);
      style.setSpan(new ForegroundColorSpan(color),from,to, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
      return style;
  }

    /**
     *
     * @param beforeText
     * @param changeText
     * @param lasttext
     * @param color
     * @return
     */
    public static SpannableStringBuilder setAppointWordColor(String beforeText,String changeText,String lasttext,int color){
        StringBuffer buffer=new StringBuffer();
        buffer.append(beforeText).append(changeText).append(lasttext);
        int from=beforeText.length();
        int to=from+changeText.length();
        return setAppointWordColor(buffer.toString(),from,to,color);
    }

    /**
     * @param beforeText
     * @param changeText
     * @param color
     * @return
     */
    public static SpannableStringBuilder setAppointWordColor(String beforeText,String changeText,int color){
        return setAppointWordColor(beforeText,changeText,"",color);
    }
}
