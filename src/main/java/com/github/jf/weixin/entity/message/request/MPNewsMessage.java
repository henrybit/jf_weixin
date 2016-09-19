package com.github.jf.weixin.entity.message.request;

/**
 * 图文消息（点击跳转到图文消息页面）<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MPNewsMessage {
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
