package com.github.jf.weixin.enums;

/**
 * @author jileilei
 */
public enum MaterialType {

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
     * 图文消息
     */
    NEWS("news"),
    
    /**
     * 缩略图
     */
    THUMB("thumb");
	
    String value;

    MaterialType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
