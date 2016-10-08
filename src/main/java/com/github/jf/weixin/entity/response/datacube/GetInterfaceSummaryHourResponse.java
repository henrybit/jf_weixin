package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.InterfaceSummaryHour;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 接口分析分时数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetInterfaceSummaryHourResponse extends BaseResponse {
    @JSONField(name="list")
    private List<InterfaceSummaryHour> list;

    public List<InterfaceSummaryHour> getList() {
        return list;
    }

    public void setList(List<InterfaceSummaryHour> list) {
        this.list = list;
    }
}
