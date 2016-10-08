package com.github.jf.weixin.entity.response.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 带参二维码<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> ticket</td><td> 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。</td></tr>
 *     <tr><td> expire_seconds</td><td> 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。</td></tr>
 *     <tr><td> url</td><td> 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class QrcodeResponse extends BaseResponse {
    @JSONField(name="ticket")
    private String ticket;
    @JSONField(name="expire_seconds")
    private Integer expireSeconds;
    @JSONField(name="url")
    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
