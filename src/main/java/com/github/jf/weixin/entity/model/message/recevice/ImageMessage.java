package com.github.jf.weixin.entity.model.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的图片消息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         {@code
 *          <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1348831860</CreateTime>
            <MsgType><![CDATA[image]]></MsgType>
            <PicUrl><![CDATA[this is a url]]></PicUrl>
            <MediaId><![CDATA[media_id]]></MediaId>
            <MsgId>1234567890123456</MsgId>
            </xml>
            }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ImageMessage extends BaseRecevice{
    @XmlField(name="PicUrl")
    protected String picUrl;
    @XmlField(name="MediaId")
    protected String mediaId;
    @XmlField(name="MsgId")
    protected String msgId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
