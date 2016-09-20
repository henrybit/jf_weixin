package com.github.jf.weixin;

import com.github.jf.weixin.api.material.MediaAPI;
import com.github.jf.weixin.config.ApiConfig;

/**
 * 测试素材管理相关API
 * @author qiph
 * @version 2.0
 */
public class TestMaterialAPI {
	
	public static void main(String[] args) throws Exception {
		String appId = "wxbe7e674c6bfd9b1b";
		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
		ApiConfig apiConfig = new ApiConfig(appId, secret);
		
		//1.测试临时素材上传
		uploadTempMedia(apiConfig);
		
	}
	
	private static void uploadTempMedia(ApiConfig apiConfig) {
		MediaAPI mediaApi = new MediaAPI(apiConfig);
	}
}
