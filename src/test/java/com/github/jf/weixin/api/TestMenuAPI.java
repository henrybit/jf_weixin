package com.github.jf.weixin.api;

import java.util.ArrayList;
import java.util.List;

import com.github.jf.weixin.api.menu.MenuAPI;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.menu.Menu;
import com.github.jf.weixin.entity.menu.MenuButton;
import com.github.jf.weixin.enums.MenuType;

/**
 * 测试微信号自定义菜单功能<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TestMenuAPI {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String appId = "wxbe7e674c6bfd9b1b";
		String secret = "2e27fa91a9b2b573d17faeb88d1cae9f";
		ApiConfig apiConfig = new ApiConfig(appId, secret);
		
		//测试自定义菜单创建
		//createMenu(apiConfig);
		//获取所有菜单
		testGetAllMenu(apiConfig);

	}
	
	private static void createMenu(ApiConfig apiConfig) throws Exception{
		MenuAPI menuApi = new MenuAPI(apiConfig);
		Menu menu = new Menu();
		List<MenuButton> buttons = new ArrayList<MenuButton>();
		
		//单纯点击
		MenuButton subBtn1 = new MenuButton();
		subBtn1.setKey("A001");
		subBtn1.setName("点击菜单1");
		subBtn1.setType(MenuType.CLICK);
		
		//点击跳转
		MenuButton subBtn2 = new MenuButton();
		subBtn2.setKey("A002");
		subBtn2.setName("点击跳单2");
		subBtn2.setType(MenuType.VIEW);
		subBtn2.setUrl("http://www.baidu.com");

		List<MenuButton> sonBtnList = new ArrayList<MenuButton>();
		for (int i=0; i<2; i++) {
			MenuButton subsubB = new MenuButton();
			subsubB.setKey("A002"+i);
			subsubB.setName("子菜单菜单"+i);
			subsubB.setType(MenuType.VIEW);
			subsubB.setUrl("http://www.sina.com");
			sonBtnList.add(subsubB);
		}
		subBtn2.setSubButton(sonBtnList);
		
		//扫码push
		MenuButton subBtn3 = new MenuButton();
		subBtn3.setKey("A003");
		subBtn3.setName("打开扫一扫");
		subBtn3.setType(MenuType.SCANCODE_PUSH);
		
		
		//扫码等待
		MenuButton subBtn4 = new MenuButton();
		subBtn4.setKey("A004");
		subBtn4.setName("扫码等待");
		subBtn4.setType(MenuType.SCANCODE_WAITMSG);
		
		//弹出系统拍照发图pic_sysphoto
		MenuButton subBtn5 = new MenuButton();
		subBtn5.setKey("A005");
		subBtn5.setName("拍照");
		subBtn5.setType(MenuType.PIC_SYSPHOTO);
		
		//pic_photo_or_album：弹出拍照或者相册发图用户点击按钮后
		MenuButton subBtn6 = new MenuButton();
		subBtn6.setKey("A006");
		subBtn6.setName("拍照或相册");
		subBtn6.setType(MenuType.PIC_PHOTO_OR_ALBUM);
		
		//pic_weixin：弹出微信相册发图器
		MenuButton subBtn7 = new MenuButton();
		subBtn7.setKey("A007");
		subBtn7.setName("微信相册发图器");
		subBtn7.setType(MenuType.PIC_WEIXIN);
		
		//location_select：弹出地理位置选择器
		MenuButton subBtn8 = new MenuButton();
		subBtn8.setKey("A008");
		subBtn8.setName("定位选择器");
		subBtn8.setType(MenuType.LOCATION_SELECT);
		
		//media_id：下发消息（除文本消息）用户点击media_id类型按钮
		MenuButton subBtn9 = new MenuButton();
		subBtn9.setKey("A009");
		subBtn9.setName("下发消息");
		subBtn9.setType(MenuType.MEDIA_ID);
		subBtn9.setMediaId("");
		
		//view_limited：跳转图文消息URL用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL
		MenuButton subBtn10 = new MenuButton();
		subBtn10.setKey("A010");
		subBtn10.setName("跳转图文消息");
		subBtn10.setType(MenuType.VIEW_LIMITED);
		subBtn10.setMediaId("");
		
		buttons.add(subBtn1);
		buttons.add(subBtn2);
		//buttons.add(subBtn3);
		//buttons.add(subBtn4);
		//buttons.add(subBtn5);
		//buttons.add(subBtn6);
		//buttons.add(subBtn7);
		//buttons.add(subBtn8);
//		buttons.add(subBtn9);
//		buttons.add(subBtn10);
		
		
		menu.setButtons(buttons);
		menuApi.createMenu(menu);
	}


	private static void testGetAllMenu(ApiConfig apiConfig) throws Exception{
		MenuAPI menuAPI = new MenuAPI(apiConfig);
		menuAPI.getAllMenu();
	}
}
