package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 二维码带参事件消息<br>
 * <ul>
 * <label>报文范例</label>
 * <li>
 * 1.用户未关注时，进行关注后的事件推送<br>
 * {@code
  	<xml><ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[FromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[subscribe]]></Event>
	<EventKey><![CDATA[qrscene_123123]]></EventKey>
	<Ticket><![CDATA[TICKET]]></Ticket>
	</xml>
	}
	</li>
	<li>
	2. 用户已关注时的事件推送<br>
	{@code 
	<xml>
	<ToUserName><![CDATA[toUser]]></ToUserName>
	<FromUserName><![CDATA[FromUser]]></FromUserName>
	<CreateTime>123456789</CreateTime>
	<MsgType><![CDATA[event]]></MsgType>
	<Event><![CDATA[SCAN]]></Event>
	<EventKey><![CDATA[SCENE_VALUE]]></EventKey>
	<Ticket><![CDATA[TICKET]]></Ticket>
	</xml>
	}
	</li>
	</ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class QrcodeMessage extends BaseRecevice{
	@XmlField(name="Event")
	protected String event;
	@XmlField(name="EventKey")
	protected String eventKey;
	@XmlField(name="Ticket")
	protected String ticket;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
