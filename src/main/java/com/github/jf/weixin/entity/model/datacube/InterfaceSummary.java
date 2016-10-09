package com.github.jf.weixin.entity.model.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.datacube.BaseDataCube;

/**
 * 接口分析数据<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> ref_date</td><td> 数据的日期</td></tr>
 *     <tr><td> ref_hour</td><td> 数据的小时</td></tr>
 *     <tr><td> callback_count</td><td> 通过服务器配置地址获得消息后，被动回复用户消息的次数</td></tr>
 *     <tr><td> fail_count</td><td> 上述动作的失败次数</td></tr>
 *     <tr><td> total_time_cost</td><td> 总耗时，除以callback_count即为平均耗时</td></tr>
 *     <tr><td> max_time_cost</td><td> 最大耗时</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class InterfaceSummary extends BaseDataCube {

    @JSONField(name="callback_count")
    private Integer callbackCount;
    @JSONField(name="fail_count")
    private Integer failCount;
    @JSONField(name="total_time_cost")
    private Integer totalTimeCost;
    @JSONField(name="max_time_cost")
    private Integer maxTimeCost;

    public Integer getCallbackCount() {
        return callbackCount;
    }

    public void setCallbackCount(Integer callbackCount) {
        this.callbackCount = callbackCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getTotalTimeCost() {
        return totalTimeCost;
    }

    public void setTotalTimeCost(Integer totalTimeCost) {
        this.totalTimeCost = totalTimeCost;
    }

    public Integer getMaxTimeCost() {
        return maxTimeCost;
    }

    public void setMaxTimeCost(Integer maxTimeCost) {
        this.maxTimeCost = maxTimeCost;
    }
}
