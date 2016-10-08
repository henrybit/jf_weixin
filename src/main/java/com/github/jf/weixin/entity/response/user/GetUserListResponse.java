package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Openid;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.io.Serializable;

/**
 * 获取用户列表返回报文<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:320px">参数</th><th>说明</th></tr>
 *     <tr><td> total</td><td> 关注该公众账号的总用户数</td></tr>
 *     <tr><td> count</td><td> 拉取的OPENID个数，最大值为10000</td></tr>
 *     <tr><td> data</td><td> 列表数据，OPENID的列表</td></tr>
 *     <tr><td> next_openid</td><td> 拉取列表的最后一个用户的OPENID</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserListResponse extends BaseResponse {

    @JSONField(name="total")
    private long total;
    @JSONField(name="count")
    private int count;
    @JSONField(name="data")
    private Openid data;
    @JSONField(name="next_openid")
    private String nextOpenid;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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
