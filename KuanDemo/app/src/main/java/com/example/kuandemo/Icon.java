package com.example.kuandemo;

import android.media.Image;

import org.w3c.dom.Text;

/**
 * 项目名称:KuanDemo
 * 创建人:Lstaras
 * 创建时间: ${DATA} 21:19
 */

//创建存储数据的实体类

public class Icon {

    private int imageId;

    private String name;

    public Icon(int imageId,String name){
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
