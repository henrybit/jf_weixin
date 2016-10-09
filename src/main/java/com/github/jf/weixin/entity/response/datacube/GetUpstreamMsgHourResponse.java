package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.datacube.UpstreamMsgHour;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息分送分时数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgHourResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsgHour> list;

    public List<UpstreamMsgHour> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgHour> list) {
        this.list = list;
    }
}
