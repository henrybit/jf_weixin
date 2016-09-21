package com.github.jf.weixin.entity.message.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 视频消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class VideoMessage extends BaseReqMsg{
	@JSONField(name="media_id")
    protected String mediaId;
	@JSONField(name="thumb_media_id")
    protected String thumbMediaId;
	@JSONField(name="title")
    protected String title;
	@JSONField(name="description")
    protected String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("media_id",this.mediaId);
        jsonMap.put("thumb_media_id",this.thumbMediaId);
        jsonMap.put("title",this.title);
        jsonMap.put("description",this.description);
        return JSONUtil.toJson(jsonMap);
    }
}
