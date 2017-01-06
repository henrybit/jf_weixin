package com.github.jf.weixin.entity.model.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 门店类目信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class PoiCategory extends BaseModel {
    @JSONField(name="category")
    protected String category;
    @JSONField(name="son_category")
    protected String sonCategory;
    @JSONField(name="gson_category")
    protected String gsonCategory;

    public PoiCategory() {
    }

    public PoiCategory(String[] array) {
        if (array == null) return;
        switch (array.length) {
            case 3:
                this.category = array[0];
                this.sonCategory = array[1];
                this.gsonCategory = array[2];
                break;
            case 2:
                this.category = array[0];
                this.sonCategory = array[1];
                break;
            case 1:
                this.category = array[0];
                break;
        }
    }

    public PoiCategory(String c1, String c2, String c3) {
        this.category = c1;
        this.sonCategory = c2;
        this.gsonCategory = c3;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSonCategory() {
        return sonCategory;
    }

    public void setSonCategory(String sonCategory) {
        this.sonCategory = sonCategory;
    }

    public String getGsonCategory() {
        return gsonCategory;
    }

    public void setGsonCategory(String gsonCategory) {
        this.gsonCategory = gsonCategory;
    }
}
