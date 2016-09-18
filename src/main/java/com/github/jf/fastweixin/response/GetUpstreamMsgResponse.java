package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.UpstreamMsg;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUpstreamMsgResponse extends BaseResponse {

    private List<UpstreamMsg> list;

    public List<UpstreamMsg> getList() {
        return list;
    }

    public void setList(List<UpstreamMsg> list) {
        this.list = list;
    }
}
