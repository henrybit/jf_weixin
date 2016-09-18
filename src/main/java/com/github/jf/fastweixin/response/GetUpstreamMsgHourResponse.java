package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.UpstreamMsgHour;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUpstreamMsgHourResponse extends BaseResponse {

    private List<UpstreamMsgHour> list;

    public List<UpstreamMsgHour> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgHour> list) {
        this.list = list;
    }
}
