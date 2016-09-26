package com.github.jf.weixin.entity.request;

/**
 * AccessToken请求参数<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
    <tbody><tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
    <tr><td> grant_type</td><td> 是</td><td> 获取access_token填写client_credential</td></tr>
    <tr><td> appid</td><td> 是</td><td> 第三方用户唯一凭证</td></tr>
    <tr><td> secret</td><td> 是</td><td> 第三方用户唯一凭证密钥，即appsecret</td></tr>
    </tbody>
   </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class AccessTokenRequest {
    private String grantType;
    private String appid;
    private String secret;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
