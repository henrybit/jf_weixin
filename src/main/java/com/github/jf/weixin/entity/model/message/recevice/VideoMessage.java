package com.github.jf.weixin.entity.model.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的视频消息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         视频消息<br>
 *         {@code
            <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1357290913</CreateTime>
            <MsgType><![CDATA[video]]></MsgType>
            <MediaId><![CDATA[media_id]]></MediaId>
            <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
            <MsgId>1234567890123456</MsgId>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         小视频消息<br>
 *         {@code
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1357290913</CreateTime>
            <MsgType><![CDATA[shortvideo]]></MsgType>
            <MediaId><![CDATA[media_id]]></MediaId>
            <ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>
            <MsgId>1234567890123456</MsgId>
            </xml>
 *         }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class VideoMessage extends BaseRecevice{
    @XmlField(name="MediaId")
    protected String mediaId;
    @XmlField(name="ThumbMediaId")
    protected String thumbMediaId;
    @XmlField(name="MsgId")
    protected String msgId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
