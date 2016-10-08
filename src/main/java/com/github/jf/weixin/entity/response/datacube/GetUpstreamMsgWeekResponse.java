package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UpstreamMsgWeek;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息发送周数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgWeekResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsgWeek> list;

    public List<UpstreamMsgWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgWeek> list) {
        this.list = list;
    }
}
