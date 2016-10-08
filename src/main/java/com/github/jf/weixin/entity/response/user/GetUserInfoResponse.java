package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 *获取用户基本信息（包括UnionID机制）报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserInfoResponse extends BaseResponse {
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
