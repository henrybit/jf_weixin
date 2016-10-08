package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 获取模板ID返回结果<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetTemplateIdResponse extends BaseResponse {
    @JSONField(name="template_id")
    protected String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
