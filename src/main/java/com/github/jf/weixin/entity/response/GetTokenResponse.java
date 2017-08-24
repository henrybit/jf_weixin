package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 网页授权使用的返回报文
 * @author henrybit
 * @version 1.0
 */
public class GetTokenResponse extends BaseResponse {

    @JSONField(name = "access_token")
    private String  accessToken;
    @JSONField(name = "expires_in")
    private Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
