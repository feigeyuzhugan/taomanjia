package com.zhongzi.taomanjia.presenter.user;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zhongzi.taomanjia.R;
import com.zhongzi.taomanjia.app.constants.BaseConstants;
import com.zhongzi.taomanjia.app.constants.UrlConstants;
import com.zhongzi.taomanjia.model.entity.UserInfoSP;
import com.zhongzi.taomanjia.presenter.base.BasePresenter;
import com.zhongzi.taomanjia.presenter.iView.IUserCodeView;
import com.zhongzi.taomanjia.utils.FileUtil;
import com.zhongzi.taomanjia.utils.QRCodeUtil;

import java.io.File;

/**
 * Created by Administrator on 2017/12/8.
 */

public class UserCodePresenter extends BasePresenter<IUserCodeView> {

    private String url;
    private File file;
    private String strFile;

    public UserCodePresenter(IUserCodeView iUserCodeView) {
        super(iUserCodeView);
    }

    public void generateQRCode(Context context) {
        url = "参数粗糙吵吵吵" + UserInfoSP.getInstance().getUserName();
        Bitmap bitmap = QRCodeUtil.generateBitmap(url, 200, 200);
        mIView.decodeSuccess(bitmap);
    }

}
