package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.InterfaceSummary;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 接口分析数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetInterfaceSummaryResponse extends BaseResponse {
    @JSONField(name="list")
    private List<InterfaceSummary> list;

    public List<InterfaceSummary> getList() {
        return list;
    }

    public void setList(List<InterfaceSummary> list) {
        this.list = list;
    }
}
