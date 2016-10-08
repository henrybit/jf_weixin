package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 添加模版响应<br>
 * @deprecated 找不到该接口
 */
@Deprecated
public class AddTemplateResponse extends BaseResponse {
    /**
     * 模版id
     */
    @JSONField(name = "template_id")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
