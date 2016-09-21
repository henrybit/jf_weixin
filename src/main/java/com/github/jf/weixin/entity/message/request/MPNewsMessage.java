package com.github.jf.weixin.entity.message.request;

import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 图文消息（点击跳转到图文消息页面）<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MPNewsMessage extends BaseReqMsg{
    protected String mediaId;

    public String getMedia_id() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("media_id",this.mediaId);
        return JSONUtil.toJson(jsonMap);
    }
}
