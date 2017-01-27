package com.github.jf.weixin.entity.request.message;

import com.github.jf.weixin.annotation.XmlField;
import com.github.jf.weixin.util.XMLUtil;

/**
 * 转发至客服<br>
 * @author henrybit
 * @version 1.0
 */
public class TransferCustomerServiceMessage {
	@XmlField(name="ToUserName")
	protected String toUserName;
	@XmlField(name="FromUserName")
	protected String fromUserName;
	@XmlField(name="CreateTime")
	protected long createTime;
	@XmlField(name="MsgType")
	protected String msgType;
	@XmlField(name="TransInfo")
	protected TransInfo transInfo;
	
	public static class TransInfo {
		@XmlField(name="KfAccount")
		protected String kfAccount;
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

	public TransInfo getTransInfo() {
		return transInfo;
	}

	public void setTransInfo(TransInfo transInfo) {
		this.transInfo = transInfo;
	}
	
	public static void main(String[] args) {
		String xml = "<xml><ToUserName><![CDATA[touser]]></ToUserName><FromUserName><![CDATA[fromuser]]></FromUserName><CreateTime>1399197672</CreateTime><MsgType><![CDATA[transfer_customer_service]]></MsgType><TransInfo><KfAccount><![CDATA[test1@test]]></KfAccount></TransInfo></xml>";
		TransferCustomerServiceMessage t = new TransferCustomerServiceMessage();
		t = XMLUtil.parse(TransferCustomerServiceMessage.class, xml);
		t.transInfo = null;
		String newXml = XMLUtil.toXml(t);
		System.out.println(newXml);
	}
}
