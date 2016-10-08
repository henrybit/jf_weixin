package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 客服账号<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 *  <tbody>
 *      <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
 *      <tr><td> access_token</td><td> 是</td><td> 调用接口凭证</td></tr>
 *      <tr><td> kf_account</td><td> 是</td><td> 完整客服账号，格式为：账号前缀@公众号微信号</td></tr>
 *      <tr><td> kf_nick</td><td> 是</td><td> 客服昵称</td></tr>
 *      <tr><td> kf_id</td><td> 是</td><td> 客服工号</td></tr>
 *      <tr><td> nickname</td><td> 是</td><td> 客服昵称，最长6个汉字或12个英文字符</td></tr>
 *      <tr><td> password</td><td> 否</td><td> 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，若不使用多客服功能，则不必设置密码</td></tr>
 *      <tr><td> media</td><td> 是</td><td> 该参数仅在设置客服头像时出现，是form-data中媒体文件标识，有filename、filelength、content-type等信息</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CustomAccount extends BaseModel {

    @JSONField(name="kf_account")
    private String accountName;
    @JSONField(name="kf_nick")
    private String nickName;
    @JSONField(name="password")
    private String password;
    @JSONField(name="kf_id")
    private String id;
    @JSONField(name="kf_headimgurl")
    private String headImg;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
