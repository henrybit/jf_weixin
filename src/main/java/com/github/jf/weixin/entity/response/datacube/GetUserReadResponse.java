package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserRead;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文统计数据返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserReadResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UserRead> list;

    public List<UserRead> getList() {
        return list;
    }

    public void setList(List<UserRead> list) {
        this.list = list;
    }
}
