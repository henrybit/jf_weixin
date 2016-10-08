package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserShareHour;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文分享转发每日数据<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserShareHourResponse extends BaseResponse {
    @JSONField(name="list")
    private List<UserShareHour> list;

    public List<UserShareHour> getList() {
        return list;
    }

    public void setList(List<UserShareHour> list) {
        this.list = list;
    }
}
