package com.github.jf.weixin.config;

/**
 * 微信公众号API接口地址<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class APIAddress {
	public static final String BASE_API_URL = "https://api.weixin.qq.com/";
	
	/**---------------OAUTH API start-----------------**/
	/**获取Access_token*/
	public static final String TOKEN_API = BASE_API_URL+"cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/**---------------OAUTH API end-----------------**/
	
	/**---------------自定义菜单API start-----------------**/
	/**自定义菜单创建接口*/
	public static final String MENU_CREATE_API = BASE_API_URL+"cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**自定义菜单查询接口*/
	public static final String MENU_QUERY_API = BASE_API_URL+"cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    /**自定义菜单删除接口*/
	public static final String MENU_DELETE_API = BASE_API_URL+"cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    /**个性化菜单接口*/
	public static final String MENU_CUSTOM_API = BASE_API_URL+"cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    /**删除个性化菜单*/
	public static final String MENU_CUSTOM_DELETE_API = BASE_API_URL+"cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    /**测试个性化菜单匹配结果*/
	public static final String MENU_CUSTOM_TEST_API = BASE_API_URL+"cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
    /**获取自定义菜单配置接口*/
	public static final String MENU_GET_CURRENT_SELFMENU_API = BASE_API_URL+"cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
	/**---------------自定义菜单API end-----------------**/
	
	/**---------------消息相关接口API start-----------------**/
	/**发送客服消息*/
	public static final String CUSTOMER_SERVICE_MESSAGE_API = BASE_API_URL+"cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】*/
	public static final String MASS_UPLOAD_MESSAGE_IMAGE_API = BASE_API_URL+"cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
    /**上传图文消息素材【订阅号与服务号认证后均可用】*/
	public static final String MASS_UPLOAD_MESSAGE_IMAGE_NEWS_API = BASE_API_URL+"cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
    /**根据分组进行群发【订阅号与服务号认证后均可用】*/
	public static final String MASS_GROUP_MESSAGE_SEND_API = BASE_API_URL+"cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
    /**根据OpenID列表群发【订阅号不可用，服务号认证后可用】*/
	public static final String MASS_OPENID_MESSAGE_SEND_API = BASE_API_URL+"cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";
    /**删除群发【订阅号与服务号认证后均可用】*/
	public static final String MASS_DELETE_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
    /**预览接口【订阅号与服务号认证后均可用】*/
	public static final String MASS_PREVIEW_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN";
    /**查询群发消息发送状态【订阅号与服务号认证后均可用】*/
	public static final String MASS_QUERY_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
    /**设置所属行业*/
	public static final String TEMPLATE_SET_INDUSTRY_API = BASE_API_URL+"cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    /**获取设置的行业信息*/
	public static final String TEMPLATE_GET_INDUSTRY_API = BASE_API_URL+"cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    /**获得模板ID*/
	public static final String TEMPLATE_GET_TEMPLATE_ID_API = BASE_API_URL+"cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    /**获取模板列表*/
	public static final String TEMPLATE_GET_TEMPLATE_LIST_API = BASE_API_URL+"cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
    /**删除一个模板*/
	public static final String TEMPLATE_DELETE_TEMPLATE_API = BASE_API_URL+"cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
    /**发送模板消息*/
	public static final String TEMPLATE_SEND_MESSAGE_API = BASE_API_URL+"cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**获取公众号自动回复配置*/
	public static final String GET_CURRENT_AUTOREPLY_API = BASE_API_URL+"cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN";
	/**添加客服帐号*/
	public static final String ADD_CUSTOMER_SERVER_API = BASE_API_URL+"customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	/**修改客服帐号*/
	public static final String UPDATE_CUSTOMER_SERVER_API = BASE_API_URL+"customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	/**删除客服帐号*/
	public static final String DELETE_CUSTOMER_SERVER_API = BASE_API_URL+"customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	/**设置客服帐号的头像*/
	public static final String UPDATE_CUSTOMER_HEADER_API = BASE_API_URL+"customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	/**获取所有客服账号*/
	public static final String GET_CUSTOMER_SERVER_LIST_API = BASE_API_URL+"cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
    /**---------------消息相关接口API end-----------------**/
	
	/**---------------素材管理接口API start-----------------**/
	/**新增临时素材*/
	public static final String UPLOAD_TEMP_MEDIA_API = BASE_API_URL+"cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	/**获取临时素材*/
	public static final String GET_TEMP_MEDIA_API = BASE_API_URL+"cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	/**新增永久图文素材*/
	public static final String UPLOAD_MATERIAL_NEWS_API = BASE_API_URL+"cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	/**新增其他类型永久素材*/
	public static final String UPLOAD_MATERIAL_OTHER_API = BASE_API_URL+"cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
	/**获取永久素材*/
	public static final String GET_MATERIAL_API = BASE_API_URL+"cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	/**删除永久素材*/
	public static final String DELETE_MATERIAL_API = BASE_API_URL+"cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	/**修改永久图文素材*/
	public static final String UPDATE_MATERIAL_NEWS_API = BASE_API_URL+"cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	/**获取素材总数*/
	public static final String GET_MATERIAL_COUNT_API = BASE_API_URL+"cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	/**获取素材列表*/
	public static final String GET_MATERIAL_LIST_API = BASE_API_URL+"cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	/**---------------素材管理接口API end-----------------**/
	
	/**---------------账号管理接口API start-----------------**/
	/**生成带参数的二维码*/
	public static final String ACCOUNT_CREATE_QRCODE_API = BASE_API_URL+"cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	/**长链接转短链接*/
	public static final String SHORT_URL_TRANSFORM_API = BASE_API_URL+"cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	/**---------------账号管理接口API end-----------------**/
	
	/**---------------用户管理接口API start-----------------**/
	/**创建分组*/
	public static final String CREATE_GROUP_API = BASE_API_URL+"cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	/**查询所有分组*/
	public static final String QUERY_GROUP_LIST_API = BASE_API_URL+"cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	/**查询用户所在分组*/
	public static final String QUERY_USER_GROUP_API = BASE_API_URL+"cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	/**修改分组名*/
	public static final String UPDATE_GROUP_NAME_API = BASE_API_URL+"cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	/**移动用户分组*/
	public static final String UPDATE_GROUP_USER_API = BASE_API_URL+"cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
	/**批量移动用户分组*/
	public static final String BATCH_MOVE_GROUP_USER_API = BASE_API_URL+"cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN";
	/**删除分组*/
	public static final String DELETE_GROUP_API = BASE_API_URL+"cgi-bin/groups/delete?access_token=ACCESS_TOKEN";
	/**设置备注名*/
	public static final String UPDATE_USER_REMARK_API = BASE_API_URL+"cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	/**获取用户基本信息（包括UnionID机制）*/
	public static final String GET_USER_INFO_API = BASE_API_URL+"cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	/**批量获取用户基本信息*/
	public static final String BATCH_GET_USER_INFO_API = BASE_API_URL+"cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	/**获取用户列表*/
	public static final String GET_USER_LIST_API = BASE_API_URL+"cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID"; 
	/**---------------用户管理接口API end-----------------**/
}
