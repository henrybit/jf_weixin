package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserCumulate;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取累计用户数据返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserCumulateResponse extends BaseResponse {

    @JSONField(name="list")
    private List<UserCumulate> list;

    public List<UserCumulate> getList() {
        return list;
    }

    public void setList(List<UserCumulate> list) {
        this.list = list;
    }
}
