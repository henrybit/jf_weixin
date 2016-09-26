package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的Link消息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *      {@code
 *      <xml>
        <ToUserName><![CDATA[toUser]]></ToUserName>
        <FromUserName><![CDATA[fromUser]]></FromUserName>
        <CreateTime>1351776360</CreateTime>
        <MsgType><![CDATA[link]]></MsgType>
        <Title><![CDATA[公众平台官网链接]]></Title>
        <Description><![CDATA[公众平台官网链接]]></Description>
        <Url><![CDATA[url]]></Url>
        <MsgId>1234567890123456</MsgId>
        </xml>
 *      }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class LinkMessage extends BaseRecevice{
    @XmlField(name="Title")
    protected String title;
    @XmlField(name="Description")
    protected String description;
    @XmlField(name="Url")
    protected String url;
    @XmlField(name="MsgId")
    protected String msgId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
