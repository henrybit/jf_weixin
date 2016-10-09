package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.datacube.UpstreamMsg;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 消息发送概况数据返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUpstreamMsgResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UpstreamMsg> list;

    public List<UpstreamMsg> getList() {
        return list;
    }

    public void setList(List<UpstreamMsg> list) {
        this.list = list;
    }
}
