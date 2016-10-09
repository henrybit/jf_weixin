package com.github.jf.weixin.entity.model.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的消息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         {@code
 *          <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>1348831860</CreateTime>
            <MsgType><![CDATA[text]]></MsgType>
            <Content><![CDATA[this is a test]]></Content>
            <MsgId>1234567890123456</MsgId>
            </xml>
 *         }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TextMessage extends BaseRecevice{
    @XmlField(name="Content")
    protected String content;
    @XmlField(name="MsgId")
    protected String msgId;

    public TextMessage() {

    }
    public TextMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
