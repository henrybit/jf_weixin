package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Openid;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetFansListResponse extends BaseResponse{
    @JSONField(name="count")
    protected int count;
    @JSONField(name="data")
    protected Openid data;
    @JSONField(name="next_openid")
    protected String nextOpenid;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Openid getData() {
        return data;
    }

    public void setData(Openid data) {
        this.data = data;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }
}
