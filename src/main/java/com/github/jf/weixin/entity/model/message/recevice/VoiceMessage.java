package com.github.jf.weixin.entity.model.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的语音消息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>未开通语音识别服务:<br>
 *         {@code
*           <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1357290913</CreateTime>
            <MsgType><![CDATA[voice]]></MsgType>
            <MediaId><![CDATA[media_id]]></MediaId>
            <Format><![CDATA[Format]]></Format>
            <MsgId>1234567890123456</MsgId>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         开通语音识别服务:(多了Recognition)<br>
 *         {@code
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1357290913</CreateTime>
            <MsgType><![CDATA[voice]]></MsgType>
            <MediaId><![CDATA[media_id]]></MediaId>
            <Format><![CDATA[Format]]></Format>
            <Recognition><![CDATA[腾讯微信团队]]></Recognition>
            <MsgId>1234567890123456</MsgId>
            </xml>
 *         }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class VoiceMessage extends BaseRecevice{
    @XmlField(name="MediaId")
    protected String mediaId;
    @XmlField(name="Format")
    protected String format;
    @XmlField(name="MsgId")
    protected String msgId;
    @XmlField(name="Recognition")
    protected String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
