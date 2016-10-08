package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UpstreamMsgDist;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息发送分布数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgDistResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsgDist> list;

    public List<UpstreamMsgDist> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDist> list) {
        this.list = list;
    }
}
