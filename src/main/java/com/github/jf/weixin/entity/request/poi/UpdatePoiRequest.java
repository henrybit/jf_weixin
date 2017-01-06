package com.github.jf.weixin.entity.request.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.poi.BusinessInfo;
import com.github.jf.weixin.entity.model.poi.PoiInfo;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 更新
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UpdatePoiRequest extends BaseRequest {
    @JSONField(name="business")
    protected BusinessInfo businessInfo;

    public BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(BusinessInfo businessInfo) {
        this.businessInfo = businessInfo;
    }
}
