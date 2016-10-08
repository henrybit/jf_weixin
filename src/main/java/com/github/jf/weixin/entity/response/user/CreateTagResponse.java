package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Tag;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 创建标签返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateTagResponse extends BaseResponse {
    @JSONField(name="tag")
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
