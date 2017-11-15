package com.zhongzi.taomanjia.model.entity;

import java.io.File;

/**
 * Created by Administrator on 2017/11/14.
 */

public class FileEntity {
    private String name;
    private File file;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
