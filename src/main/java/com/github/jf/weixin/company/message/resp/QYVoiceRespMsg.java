package com.github.jf.weixin.company.message.resp;

import com.github.jf.weixin.entity.model.message.recevice.ReceviceType;
import com.github.jf.weixin.util.MessageBuilder;

/**
 *  微信企业号被动响应语音消息
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class QYVoiceRespMsg extends QYBaseRespMsg {

    private String mediaId;

    public QYVoiceRespMsg() {
    }

    public QYVoiceRespMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toXml(){
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", ReceviceType.VOICE);
        mb.append("<Voice>\n");
        mb.addData("MediaId", mediaId);
        mb.append("</Voice>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }
}
