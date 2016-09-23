package com.github.jf.weixin.entity.message.recevice;

import java.io.Serializable;

import com.github.jf.weixin.annotation.XmlField;
import com.github.jf.weixin.util.MessageBuilder;

/**
 * 消息基类<br>
 * <label>封装公共字段</label>
 * <table border="1" cellspacing="0" cellpadding="4" align="center">
 *  <tbody>
 *  <tr><th style="width:180px">参数</th><th style="width:470px">描述</th></tr>
 *  <tr><td> ToUserName</td><td> <b>开发者</b>微信号</td></tr>
 *  <tr><td> FromUserName</td><td> 发送方帐号（一个OpenID）</td></tr>
 *  <tr><td> CreateTime</td><td> 消息创建时间 （整型）</td></tr>
 *  <tr><td> MsgType</td><td> text,image,video,voice,music,news</td></tr>
 *  </tbody>
 *  </table>
 * @author peiyu, henrybit
 * @since 1.3
 * @version 2.0
 */
public class BaseRecevice implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2383746865161395761L;
	//开发者微信号
	@XmlField(name="ToUserName")
	protected String toUserName;
    //发送方账号
	@XmlField(name="FromUserName")
	protected String fromUserName;
    //创建时间
	@XmlField(name="CreateTime")
	protected long createTime;
    //消息类型
	@XmlField(name="MsgType")
	protected String msgType;

    public BaseRecevice() {
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String toXml() {
        // 159 = 106 + 28(ToUserName) + 15(FromUserName) + 10(CreateTime)
        MessageBuilder builder = new MessageBuilder(159);
        builder.addData("ToUserName", getToUserName());
        builder.addData("FromUserName", getFromUserName());
        builder.addTag("CreateTime", String.valueOf(System.currentTimeMillis())
                .substring(0, 10));
        return builder.toString();
    }

    @Override
    public String toString() {
        return toXml();
    }
}
