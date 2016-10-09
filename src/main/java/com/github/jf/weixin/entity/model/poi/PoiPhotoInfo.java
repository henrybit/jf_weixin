package com.github.jf.weixin.entity.model.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 门店的图片信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class PoiPhotoInfo extends BaseModel{
    @JSONField(name="photo_url")
    protected String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
