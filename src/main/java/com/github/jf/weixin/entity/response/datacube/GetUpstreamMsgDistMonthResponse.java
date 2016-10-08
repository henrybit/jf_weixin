package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UpstreamMsgDistMonth;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息发送分布月数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgDistMonthResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsgDistMonth> list;

    public List<UpstreamMsgDistMonth> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistMonth> list) {
        this.list = list;
    }
}
