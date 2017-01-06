package com.github.jf.weixin.entity.response.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.poi.PoiCategory;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取门店类目返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetPoiCategoryResponse extends BaseResponse {
    @JSONField(name="categorys")
    protected List<PoiCategory> poiCategoryList;
    @JSONField(name="category_list")
    protected List<String> poiCategorys;

    public List<PoiCategory> getPoiCategoryList() {
        return poiCategoryList;
    }

    public void setPoiCategoryList(List<PoiCategory> poiCategoryList) {
        this.poiCategoryList = poiCategoryList;
    }

    public List<String> getPoiCategorys() {
        return poiCategorys;
    }

    public void setPoiCategorys(List<String> poiCategorys) {
        this.poiCategorys = poiCategorys;
    }
}
