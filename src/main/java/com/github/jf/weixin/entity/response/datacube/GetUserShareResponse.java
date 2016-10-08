package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserShare;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文分享转发数据返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserShareResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UserShare> list;

    public List<UserShare> getList() {
        return list;
    }

    public void setList(List<UserShare> list) {
        this.list = list;
    }
}
