package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

import java.util.Date;

/**
 * 基本数据分析实体<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class BaseDataCube extends BaseModel {

    @JSONField(name="ref_date",format="yyyy-MM-dd")
    private Date refDate;

    public Date getRefDate() {
        return refDate;
    }

    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }
}
