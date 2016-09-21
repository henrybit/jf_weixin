package com.github.jf.weixin.entity.message.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 文本消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TextMessage extends BaseReqMsg{
	@JSONField(name="content")
    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("content",this.content);
        return JSONUtil.toJson(jsonMap);
    }
}
