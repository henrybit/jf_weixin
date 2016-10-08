package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 用户的OpenId信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class Openid implements Serializable {

    @JSONField(name="openid")
    private String[] openid;

    public String[] getOpenid() {
        return openid;
    }

    public void setOpenid(String[] openid) {
        this.openid = openid;
    }
}
