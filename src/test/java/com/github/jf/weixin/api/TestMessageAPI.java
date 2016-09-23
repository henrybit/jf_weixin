package com.github.jf.weixin.api;

import com.github.jf.weixin.api.message.MessageAPI;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.CardExt;
import com.github.jf.weixin.entity.message.request.CustomerServiceMessage;
import com.github.jf.weixin.entity.message.request.NewsMessage;
import com.github.jf.weixin.entity.message.request.NewsMessage.Article;
import com.github.jf.weixin.enums.MessageType;
import com.github.jf.weixin.enums.ResultType;

/**
 * 测试消息相关API
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TestMessageAPI {

	public static void main(String[] args) throws Exception{
		String appId = "wxbe7e674c6bfd9b1b";
		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
		ApiConfig apiConfig = new ApiConfig(appId, secret);
		
		//1.测试文本消息
		//TestTextMessage(apiConfig);
		//2.测试图片消息
		//TestImageMessage(apiConfig);
		//3.测试音频消息
		//TestVoiceMessage(apiConfig);
		//4.测试视频消息
		//TestVideoMessage(apiConfig);
		//5.测试音乐消息
		//TestMusicMessage(apiConfig);
		//6.测试图文消息（点击跳转到外链）
		//TestNewsMessage(apiConfig);
		//7.测试图文消息（点击跳转到图文消息页面）
		//TestMPNewsMessage(apiConfig);
		//8.测试卡券消息 TODO
		//TestWXcardMessage(apiConfig);
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
	
	private static void TestVoiceMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String mediaId = "fTmwBxyAvzCRiDoIrC_JJDXeiKRJLrltGfUvypxV6j0";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.VOICE);
		customerServiceMessage.setMediaId(mediaId);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestVideoMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String mediaId = "fTmwBxyAvzCRiDoIrC_JJJrtBcOaHr_FaoGfFthKe-Y";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.VIDEO);
		customerServiceMessage.setMediaId(mediaId);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestMusicMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String title = "独角戏";
		String description = "许茹芸演唱";
		String musicurl = "http://122.228.237.103/d1.baidupcs.com/file/27c206b3a13ffb421d4f7b0b543099e4?bkt=p3-140027c206b3a13ffb421d4f7b0b543099e47f3a7c090000004462c3&xcode=23f4c376799cf407bcd34fc81f3cfbe560191aa1b7c020ba0b2977702d3e6764&fid=922786032-250528-126575667773465&time=1474529538&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-WvWaFGDCH%2FKIjfrpAHv%2BBj3Ic4w%3D&to=lc&fm=Nin,B,T,t&sta_dx=4481731&sta_cs=110&sta_ft=mp3&sta_ct=0&sta_mt=0&fm2=Ningbo,B,T,t&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=140027c206b3a13ffb421d4f7b0b543099e47f3a7c090000004462c3&sl=76742735&expires=8h&rt=sh&r=271648752&mlogid=6161113937532629325&vuk=922786032&vbdid=3924422051&fin=%E7%8B%AC%E8%A7%92%E6%88%8F%20-%20%E8%AE%B8%E8%8C%B9%E8%8A%B8.mp3&fn=%E7%8B%AC%E8%A7%92%E6%88%8F%20-%20%E8%AE%B8%E8%8C%B9%E8%8A%B8.mp3&slt=pm&uta=0&rtype=1&iv=0&isw=0&dp-logid=6161113937532629325&dp-callid=0.1.1&csl=332&csign=YEPC4S5vBFmOBgnmIbYkziZfO3k%3D&wshc_tag=0&wsts_tag=57e38902&wsid_tag=7d4dfe9a&wsiphost=ipdbm";
		String hqmusicurl = "http://nbct01.baidupcs.com/file/8713ada06dc105f1f3f67d52761d5cf2?bkt=p3-14008713ada06dc105f1f3f67d52761d5cf2ffa0c93b000000870202&fid=922786032-250528-1068637605437108&time=1474529573&sign=FDTAXGERLBH-DCb740ccc5511e5e8fedcff06b081203-Jak%2BwAomaRplzqojFVL0p5YjdDI%3D&to=nbhb&fm=Nin,B,T,t&sta_dx=8847874&sta_cs=58&sta_ft=mp3&sta_ct=0&sta_mt=0&fm2=Ningbo,B,T,t&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=14008713ada06dc105f1f3f67d52761d5cf2ffa0c93b000000870202&sl=76742735&expires=8h&rt=pr&r=803304806&mlogid=6161123544318280626&vuk=922786032&vbdid=3924422051&fin=%E7%8B%AC%E8%A7%92%E6%88%8F%20-%20%E8%AE%B8%E8%8C%B9%E8%8A%B8-hq.mp3&fn=%E7%8B%AC%E8%A7%92%E6%88%8F%20-%20%E8%AE%B8%E8%8C%B9%E8%8A%B8-hq.mp3&slt=pm&uta=0&rtype=1&iv=0&isw=0&dp-logid=6161123544318280626&dp-callid=0.1.1&csl=332&csign=YEPC4S5vBFmOBgnmIbYkziZfO3k%3D";
		String thumb_media_id = "fTmwBxyAvzCRiDoIrC_JJN44WM1VV88HbTnytYQ2ZKg";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.MUSIC);
		customerServiceMessage.setTitle(title);
		customerServiceMessage.setDescription(description);
		customerServiceMessage.setMusicUrl(musicurl);
		customerServiceMessage.setHqMusicUrl(hqmusicurl);
		customerServiceMessage.setThumbMediaId(thumb_media_id);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestNewsMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.NEWS);
		String title = "图文消息-内链外跳";
		String picUrl = "http://img5.imgtn.bdimg.com/it/u=3586233367,3171193232&fm=11&gp=0.jpg";
		String url = "http://www.sina.com";
		String desciption = "我是一个门户资讯网";
		Article article = NewsMessage.createArticle(title, picUrl, url, desciption);
		customerServiceMessage.addArticle(article);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestMPNewsMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		String mediaId = "fTmwBxyAvzCRiDoIrC_JJA5rYP3_XuMyNiOw0TxUgwU";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.MPNEWS);
		customerServiceMessage.setMediaId(mediaId);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
	
	private static void TestWXcardMessage(ApiConfig apiConfig) throws Exception {
		MessageAPI messageApi = new MessageAPI(apiConfig);
		String toUser = "oMt1sxK_DNo7CesbmoYs4tNW2rOI";
		CustomerServiceMessage customerServiceMessage = new CustomerServiceMessage(toUser, MessageType.WXCARD);
		String cardId = "123dsdajkasd231jhksad";
		String code = "", openid = "oMt1sxK_DNo7CesbmoYs4tNW2rOI", timestamp = "1402057159", signature = "017bb17407c8e0058a66d72dcc61632b70f511ad";
		CardExt cardExt = new CardExt(code, openid, timestamp, signature);
		customerServiceMessage.setCardInfo(cardId, cardExt);
		ResultType resultType = messageApi.sendCustomerServiceMessage(customerServiceMessage);
		System.out.println(resultType.getDescription());
	}
}
