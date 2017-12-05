package com.zhongzi.taomanjia.model.entity.eventbus.user;

import android.net.Uri;

/**
 * Created by Administrator on 2017/11/28.
 */

public class ToUserCenterEvent {
    private int type;
    private Uri uri;
    private int position;

    public ToUserCenterEvent(int type, Uri uri,int position) {
        this.type = type;
        this.uri = uri;
        this.position=position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ToUserCenterEvent{" +
                "type=" + type +
                ", uri=" + uri +
                ", position=" + position +
                '}';
    }
}
