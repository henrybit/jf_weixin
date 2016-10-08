package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取用户身上标签列表返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserTagsResponse extends BaseResponse{
    @JSONField(name="tagid_list")
    protected List<Integer> tagidList;

    public List<Integer> getTagidList() {
        return tagidList;
    }

    public void setTagidList(List<Integer> tagidList) {
        this.tagidList = tagidList;
    }
}
