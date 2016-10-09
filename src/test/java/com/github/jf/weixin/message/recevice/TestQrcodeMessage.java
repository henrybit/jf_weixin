package com.github.jf.weixin.message.recevice;

import com.github.jf.weixin.entity.model.message.recevice.EventMessage;
import com.github.jf.weixin.util.XMLUtil;

/**
 * 测试带参二维码消息解析测试<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TestQrcodeMessage {

	public static void main(String[] args) {
		String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[SCAN]]></Event><EventKey><![CDATA[SCENE_VALUE]]></EventKey><Ticket><![CDATA[TICKET]]></Ticket></xml>";
		xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event><EventKey><![CDATA[qrscene_123123]]></EventKey><Ticket><![CDATA[TICKET]]></Ticket></xml>";
		EventMessage t = XMLUtil.parse(EventMessage.class, xml);
		System.out.println(t.getFromUserName());
		System.out.println(t.getToUserName());
		System.out.println(t.getCreateTime());
		System.out.println(t.getMsgType());
		System.out.println(t.getEvent());
		System.out.println(t.getEventKey());
		System.out.println(t.getTicket());
	}

}
