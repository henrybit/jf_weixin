package com.github.jf.weixin.entity.request.message;

import java.util.HashMap;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

/**
 * 图片消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ImageMessage extends BaseRequestMessage {
	@JSONField(name="media_id")
    protected String mediaId;

    public String getMediaId() {
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
