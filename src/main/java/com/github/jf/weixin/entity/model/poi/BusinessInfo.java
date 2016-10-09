package com.github.jf.weixin.entity.model.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 门店信息<br>
 * @author henrybit
 * @version 2.0
 * @since 2.0
 */
public class BusinessInfo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -180061699142928384L;
	
	@JSONField(name="base_info")
    protected PoiInfo poiInfo;

    public PoiInfo getPoiInfo() {
        return poiInfo;
    }

    public void setPoiInfo(PoiInfo poiInfo) {
        this.poiInfo = poiInfo;
    }
}
