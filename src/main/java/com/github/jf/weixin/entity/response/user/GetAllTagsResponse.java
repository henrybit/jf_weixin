package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Tag;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取所有标签返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetAllTagsResponse extends BaseResponse {
    @JSONField(name="tags")
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
