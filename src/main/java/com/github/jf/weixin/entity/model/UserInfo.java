package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息实体<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> subscribe</td><td> 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）。</td></tr>
 *     <tr><td> openid</td><td> 用户的标识，对当前公众号唯一</td></tr>
 *     <tr><td> nickname</td><td> 用户的昵称</td></tr>
 *     <tr><td> sex</td><td> 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知</td></tr>
 *     <tr><td> city</td><td> 用户所在城市</td></tr>
 *     <tr><td> country</td><td> 用户所在国家</td></tr>
 *     <tr><td> province</td><td> 用户所在省份</td></tr>
 *     <tr><td> language</td><td> 用户的语言，简体中文为zh_CN</td></tr>
 *     <tr><td> headimgurl</td><td> 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。</td></tr>
 *     <tr><td> subscribe_time</td><td> 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间</td></tr>
 *     <tr><td> unionid</td><td> 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：<a href="https://open.weixin.qq.com/cgi-bin/frame?t=resource/res_main_tmpl&amp;lang=zh_CN&amp;target=res/app_wx_login" class="external text" rel="nofollow" target="_blank">获取用户个人信息（UnionID机制）</a></td></tr>
 *     <tr><td> remark</td><td> 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注</td></tr>
 *     <tr><td> groupid</td><td> 用户所在的分组ID</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UserInfo extends BaseModel{
    @JSONField(name="subscribe")
    private Integer subscribe;
    @JSONField(name="openid")
    private String openid;
    @JSONField(name="nickname")
    private String nickname;
    @JSONField(name="sex")
    private Integer sex;
    @JSONField(name="language")
    private String language;
    @JSONField(name="city")
    private String city;
    @JSONField(name="province")
    private String province;
    @JSONField(name="country")
    private String country;
    @JSONField(name="headimgurl")
    private String headimgurl;
    @JSONField(name="subscribe_time")
    private Long subscribeTime;
    @JSONField(name="unionid")
    private String unionid;
    @JSONField(name="remark")
    private String remark;
    @JSONField(name="groupid")
    private Integer groupid;

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }
}
