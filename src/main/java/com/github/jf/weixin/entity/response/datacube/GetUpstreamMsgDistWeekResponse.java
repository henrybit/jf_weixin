package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.datacube.UpstreamMsgDistWeek;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息发送分布周数据<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgDistWeekResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsgDistWeek> list;

    public List<UpstreamMsgDistWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistWeek> list) {
        this.list = list;
    }
}
