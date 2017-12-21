package com.zhongzi.taomanjia.presenter.iView;

import com.zhongzi.taomanjia.model.entity.res.UserSystemRes;
import com.zhongzi.taomanjia.presenter.base.IBaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 * 系统消息
 */

public interface IUserSystemView extends IBaseView{
    void success(List<UserSystemRes> list);
}
