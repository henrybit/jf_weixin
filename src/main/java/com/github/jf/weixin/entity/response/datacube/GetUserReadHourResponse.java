package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.datacube.UserReadHour;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文统计分时数据返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserReadHourResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UserReadHour> list;

    public List<UserReadHour> getList() {
        return list;
    }

    public void setList(List<UserReadHour> list) {
        this.list = list;
    }
}
