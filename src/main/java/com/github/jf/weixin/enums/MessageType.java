package com.github.jf.weixin.enums;

/**
 * 消息类型
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public enum MessageType {
    /**
     * 文本
     */
    TEXT("text"),
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 语音
     */
    VOICE("voice"),

    /**
     * 视频
     */
    VIDEO("video"),

    /**
     * 音乐
     */
    MUSIC("music"),

    /**
     * 图文消息（点击跳转到外链）
     */
    NEWS("news"),

    /**
     * 图文消息（点击跳转到图文消息页面）
     */
    MPNEWS("mpnews"),

    /**
     * 卡券
     */
    WXCARD("wxcard")
    ;

    private String value;
    MessageType(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }
}
