package com.github.jf.weixin.entity.message.request;

/**
 * 音乐消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MusicMessage {
    //消息的标题
    protected String title;
    //描述
    protected String description;
    //音乐URL地址
    protected String musicUrl;
    //高清音乐URL地址
    protected String hqmusicUrl;
    //媒体ID
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
}
