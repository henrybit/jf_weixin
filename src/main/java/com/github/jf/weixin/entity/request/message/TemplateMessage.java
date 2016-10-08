package com.github.jf.weixin.entity.request.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

/**
 * 模板消息请求参数<br>
 * <pre>
 * 范例
 * {
    "touser":"OPENID",
    "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
    "url":"http://weixin.qq.com/download",
    "data":{
        "first": {
        "value":"恭喜你购买成功！",
        "color":"#173177"
        },
        "keynote1":{
        "value":"巧克力",
        "color":"#173177"
        },
        "keynote2": {
        "value":"39.8元",
        "color":"#173177"
        },
        "keynote3": {
        "value":"2014年9月22日",
        "color":"#173177"
        },
        "remark":{
        "value":"欢迎再次购买！",
        "color":"#173177"
        }
    }
    }
 * </pre>
 * data字段采用HashMap<String, Object>封装多个关键字内容
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TemplateMessage extends BaseRequestMessage {
    @JSONField(name="template_id")
    protected String templateId;
    @JSONField(name="url")
    protected String url;
    @JSONField(name="data")
    protected Object data;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toJson() {
        return JSONUtil.toJson(this);
    }
}
