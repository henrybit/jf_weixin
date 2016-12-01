package com.github.jf.weixin.api;

import com.github.jf.weixin.api.account.UrlAPI;
import com.github.jf.weixin.entity.response.account.TransformUrlResponse;

public class TestOrcodeAPI {

	public static void main(String[] args) throws Exception{
//		String appId = "wxbe7e674c6bfd9b1b";
//		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
//		ApiConfig apiConfig = new ApiConfig(appId, secret);
		
//		QrcodeAPI api = new QrcodeAPI(apiConfig);
//		String sceneId = "123456";
//		int expireSeconds = 2592000;
//		QrcodeResponse response = api.createQrcode(QrcodeType.QR_SCENE, sceneId, expireSeconds);
//		System.out.println(response.getUrl());
//		System.out.println("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+response.getTicket());
		
		String token = "NjdbNcMO4H7acRET8gYYLcDNG7PtTUsLA_E9mQ_cW80Uh-gzItBscm7SXwpW46OKAa5d1PBoxLgWGO4b8whEbAld-atfCnDyahQaN94zagh5EzFvAhvvH2wohA_iOPL0CJLiCIAKRT";
		String longUrl = "http://uat-mid.yokeclubtest.cn/sc-support-admin/sys/user!main.action";
		UrlAPI urlApi = new UrlAPI(token);
		TransformUrlResponse t = urlApi.transformUrl(longUrl);
		System.out.println(t.getShortUrl());
	}

}
