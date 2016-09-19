package com.github.jf.weixin.entity.message.request;

/**
 * 音频消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class VoiceMessage {
    protected String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
