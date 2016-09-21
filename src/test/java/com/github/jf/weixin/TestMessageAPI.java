package com.github.jf.weixin;

import com.github.jf.weixin.api.message.MessageAPI;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.message.request.CustomerServiceMessage;
import com.github.jf.weixin.enums.MessageType;
import com.github.jf.weixin.enums.ResultType;

public class TestMessageAPI {

	public static void main(String[] args) throws Exception{
		String appId = "wxbe7e674c6bfd9b1b";
		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
		ApiConfig apiConfig = new ApiConfig(appId, secret);
		
		//1.测试文本消息
		//TestTextMessage(apiConfig);
		//2.测试图片消息
		TestImageMessage(apiConfig);
	}
	
	private static void TestTextMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String content = "测试公众号文本消息";
		content = "Hello World";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.TEXT);
		customerServiceMessage.setContent(content);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestImageMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String mediaId = "fTmwBxyAvzCRiDoIrC_JJFXUJ8p3KTbVkRKSSqUncEw";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.IMAGE);
		customerServiceMessage.setMediaId(mediaId);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
}
