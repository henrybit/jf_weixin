package com.github.jf.weixin.entity.message.recevice;
/**
 * 提交至微信的图文消息素材
 * ====================================================================
 * 上海聚攒软件开发有限公司
 * --------------------------------------------------------------------
 * @author Nottyjay
 * @version 1.0.beta
 * ====================================================================
 */
public class MpNewsMsg extends BaseRecevice {

    private String mediaId;

    public MpNewsMsg() {
    }

    public MpNewsMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
