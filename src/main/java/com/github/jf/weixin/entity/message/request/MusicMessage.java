package com.github.jf.weixin.entity.message.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 音乐消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MusicMessage extends BaseReqMsg{
    //消息的标题
	@JSONField(name="title")
    protected String title;
    //描述
	@JSONField(name="description")
    protected String description;
    //音乐URL地址
	@JSONField(name="musicurl")
    protected String musicUrl;
    //高清音乐URL地址
	@JSONField(name="hqmusicurl")
    protected String hqmusicUrl;
    //媒体ID
	@JSONField(name="thumb_media_id")
    protected String thumbMediaId;

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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqmusicUrl() {
        return hqmusicUrl;
    }

    public void setHqmusicUrl(String hqmusicUrl) {
        this.hqmusicUrl = hqmusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("title",this.title);
        jsonMap.put("description",this.description);
        jsonMap.put("musicurl",this.musicUrl);
        jsonMap.put("hqmusicurl",this.hqmusicUrl);
        jsonMap.put("thumb_media_id",this.thumbMediaId);
        return JSONUtil.toJson(jsonMap);
    }
}
