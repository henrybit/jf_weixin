package com.github.jf.weixin.entity.request.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 请求的用户查询信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UserInfoRequest extends BaseRequest {
    @JSONField(name="openid")
    private String openid;
    @JSONField(name="lang")
    private String lang="zh_CN";
    public UserInfoRequest(){

    }
    public UserInfoRequest(String openid){
        this.openid=openid;
    }
    public UserInfoRequest(String openid, String lang){
        this.openid=openid;
        this.lang=lang;
    }
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
