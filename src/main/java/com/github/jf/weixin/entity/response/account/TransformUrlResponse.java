package com.github.jf.weixin.entity.response.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 转换URL返回报文<br>
 * <pre>
 * 范例:{"errcode":0,"errmsg":"ok","short_url":"http:\/\/w.url.cn\/s\/AvCo6Ih"}
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TransformUrlResponse extends BaseResponse {
    @JSONField(name="short_url")
    protected String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
