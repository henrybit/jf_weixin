package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.util.MessageBuilder;

/**
 * 接收的文本消息<br>
 * 范例:
 * <pre>
 * {@code
 * <xml>
 *   <ToUserName><![CDATA[toUser]]></ToUserName>
 *   <FromUserName><![CDATA[fromUser]]></FromUserName>
 *   <CreateTime>1348831860</CreateTime>
 *   <MsgType><![ CDATA[text]]></MsgType>
 *   <Content><![CDATA[this is a test]]></Content>
 *   <MsgId>1234567890123456</MsgId>
 * </xml>
 * }
 * </pre>
 * <table border="1" cellspacing="0" cellpadding="4" align="center">
 *  <tbody>
 *  <tr><th style="width:180px">参数</th><th style="width:470px">描述</th></tr>
 *  <tr><td> ToUserName</td><td> <b>开发者</b>微信号</td></tr>
 *  <tr><td> FromUserName</td><td> 发送方帐号（一个OpenID）</td></tr>
 *  <tr><td> CreateTime</td><td> 消息创建时间 （整型）</td></tr>
 *  <tr><td> MsgType</td><td> text</td></tr>
 *  <tr><td> Content</td><td> 文本消息内容</td></tr>
 *  <tr><td> MsgId</td><td> 消息id，64位整型</td></tr>
 *  </tbody>
 *  </table>
 * @author peiyu, henrybit
 * @since 1.3
 * @version 2.0
 */
public final class TextMsg extends BaseRecevice {

    //消息ID
    private String msgId;
    //消息内容
    private StringBuilder contentBuilder;

    public TextMsg() {
        this.msgId = "0";
        contentBuilder = new StringBuilder();
    }

    public TextMsg(String content) {
        this.msgId = "0";
        setContent(content);
    }

    public TextMsg(String msgId, String content) {
        this.msgId = msgId;
        setContent(content);
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return contentBuilder.toString();
    }

    public void setContent(String content) {
        contentBuilder = new StringBuilder(content);
    }

    public TextMsg add(String text) {
        contentBuilder.append(text);
        return this;
    }

    public TextMsg addln() {
        return add("\n");
    }

    public TextMsg addln(String text) {
        contentBuilder.append(text);
        return addln();
    }

    public TextMsg addLink(String text, String url) {
        contentBuilder.append("<a href=\"").append(url).append("\">")
                .append(text).append("</a>");
        return this;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("Content", contentBuilder.toString().trim());
        mb.addData("MsgType", ReceviceType.TEXT);
        mb.addTag("MsgId", msgId);
        mb.surroundWith("xml");
        return mb.toString();
    }

}
