package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.util.MessageBuilder;

/**
 * @author peiyu
 */
public class VoiceMsg extends BaseRecevice {

    private String mediaId;

    public VoiceMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", ReceviceType.VOICE);
        mb.append("<Voice>\n");
        mb.addData("MediaId", mediaId);
        mb.append("</Voice>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }

}
