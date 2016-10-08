package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserSummary;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取用户增减数返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserSummaryResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UserSummary> list;

    public List<UserSummary> getList() {
        return list;
    }

    public void setList(List<UserSummary> list) {
        this.list = list;
    }
}
