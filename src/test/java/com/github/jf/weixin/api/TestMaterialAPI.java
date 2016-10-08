package com.github.jf.weixin.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.github.jf.weixin.api.material.MaterialAPI;
import com.github.jf.weixin.api.material.MediaAPI;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.Article;
import com.github.jf.weixin.entity.response.material.UploadMaterialResponse;
import com.github.jf.weixin.entity.response.material.UploadMediaResponse;
import com.github.jf.weixin.enums.MediaType;

/**
 * 测试素材管理相关API
 * @author henrybit
 * @version 2.0
 */
public class TestMaterialAPI {
	
	public static void main(String[] args) throws Exception {
		//个人账号
		String appId = "wxbe7e674c6bfd9b1b";
		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
		
		//yoker dev
		appId = "wxb6d996ad76a14636";
		secret = "83494396862e752fa7498c1b8b23bde6";
		
		ApiConfig apiConfig = new ApiConfig(appId, secret);
		System.out.println(apiConfig.getAccessToken());
		//1.测试临时素材上传
		//uploadTempMedia(apiConfig);

		//2.测试上传永久素材
		//uploadMaterial(apiConfig);
	}
	
	private static void uploadTempMedia(ApiConfig apiConfig) {
		MediaAPI mediaApi = new MediaAPI(apiConfig);
		File imageFile = new File("/Users/henrybit/Pictures/164.pic_hd.jpg");
		UploadMediaResponse uploadMediaResponse = mediaApi.uploadMedia(MediaType.IMAGE, imageFile);
		System.out.println("media_id:"+uploadMediaResponse.getMediaId());
		
		
	}

	private static void uploadMaterial(ApiConfig apiConfig) {
		MaterialAPI materialAPI = new MaterialAPI(apiConfig);
		UploadMaterialResponse uploadMaterialResponse = null;
		
//		File imageFile = new File("/Users/henrybit/Pictures/164.pic_hd.jpg");
//		uploadMaterialResponse = materialAPI.uploadImageMaterialFile(imageFile);
//		System.out.println(uploadMaterialResponse.getMediaId());
//		
//		File voiceFile = new File("C:\\Users\\qiph\\Desktop\\New Recording.amr");
//		uploadMaterialResponse = materialAPI.uploadVoiceMaterialFile(voiceFile);
//		System.out.println(uploadMaterialResponse.getMediaId());
		
//		File thumbFile = new File("C:\\Users\\qiph\\Desktop\\1.jpg");
//		uploadMaterialResponse = materialAPI.uploadThumbMaterialFile(thumbFile);
//		System.out.println(uploadMaterialResponse.getMediaId());
		
		List<Article> articles = new ArrayList<Article>();
		String thumbMediaId = "fTmwBxyAvzCRiDoIrC_JJN44WM1VV88HbTnytYQ2ZKg";
		String author = "建发小优"; 
		String title = "图文消息测试1";
		String contentSourceUrl = "http://www.baidu.com";
		String content = "<html><header><title>好好好</title></header><body>建发商城欢迎你</body></html>";
		String digest = "建发商城要开始推广啦";
		Integer showConverPic = 1;
		Article article1 = new Article(thumbMediaId, author, title, contentSourceUrl, content, digest, showConverPic);
		articles.add(article1);
		uploadMaterialResponse = materialAPI.uploadMaterialNews(articles);
		System.out.println(uploadMaterialResponse.getMediaId());
	}
}
