package com.github.jf.weixin;

import com.github.jf.weixin.api.material.MaterialAPI;
import com.github.jf.weixin.api.material.MediaAPI;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.UploadMaterialResponse;
import com.github.jf.weixin.entity.response.UploadMediaResponse;
import com.github.jf.weixin.enums.MediaType;

import java.io.File;

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
		//uploadTempMedia(apiConfig);

		//2.测试上传永久素材
		uploadMaterial(apiConfig);
	}
	
	private static void uploadTempMedia(ApiConfig apiConfig) {
		MediaAPI mediaApi = new MediaAPI(apiConfig);
		File imageFile = new File("/Users/henrybit/Pictures/164.pic_hd.jpg");
		UploadMediaResponse uploadMediaResponse = mediaApi.uploadMedia(MediaType.IMAGE, imageFile);
		System.out.println("media_id:"+uploadMediaResponse.getMediaId());
	}

	private static void uploadMaterial(ApiConfig apiConfig) {
		MaterialAPI materialAPI = new MaterialAPI(apiConfig);
		File imageFile = new File("/Users/henrybit/Pictures/164.pic_hd.jpg");
		UploadMaterialResponse uploadMaterialResponse = materialAPI.uploadMaterialFile(imageFile);
		System.out.println(uploadMaterialResponse.getMediaId());
	}
}
