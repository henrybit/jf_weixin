package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自动回复-关键字规则<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class KeywordsRule {
    @JSONField(name="type")
    protected String type;
    @JSONField(name="match_mode")
    protected String matchMode;
    @JSONField(name="content")
    protected String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
