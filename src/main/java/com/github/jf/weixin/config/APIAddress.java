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
	/**获取微信服务器IP地址*/
	public static final String IP_LIST_API = BASE_API_URL+"cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
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
	/**新增模板*/
	public static final String TEMPLATE_ADD_API = BASE_API_URL+"cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
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
	/**上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】*/
	public static final String MASS_UPLOAD_MESSAGE_IMAGE_API = BASE_API_URL+"cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	/**上传图文消息素材【订阅号与服务号认证后均可用】*/
	public static final String MASS_UPLOAD_MESSAGE_IMAGE_NEWS_API = BASE_API_URL+"cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
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
	/**上传视频素材*/
	public static final String UPLOAD_MATERIAL_VIDEO_API = BASE_API_URL+"cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN";
	/**获取素材总数*/
	public static final String GET_MATERIAL_COUNT_API = BASE_API_URL+"cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	/**获取素材列表*/
	public static final String GET_MATERIAL_LIST_API = BASE_API_URL+"cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
	/**---------------素材管理接口API end-----------------**/

	
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

	/**创建标签*/
	public static final String CREATE_TAG_API = BASE_API_URL+"cgi-bin/tags/create?access_token=ACCESS_TOKEN";
	/**获取公众号已创建的标签*/
	public static final String GET_TAG_LIST_API = BASE_API_URL+"cgi-bin/tags/get?access_token=ACCESS_TOKEN";
	/**编辑标签*/
	public static final String UPDATE_TAG_API = BASE_API_URL+"cgi-bin/tags/update?access_token=ACCESS_TOKEN";
	/**删除标签*/
	public static final String DELETE_TAG_API = BASE_API_URL+"cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
	/**获取标签下粉丝列表*/
	public static final String GET_TAG_FANS_LIST_API = BASE_API_URL+"cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
	/**批量为用户打标签*/
	public static final String BATCH_TAGGIN_USER_API = BASE_API_URL+"cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
	/**批量为用户取消标签*/
	public static final String BATCH_UNTAGGIN_USER_API = BASE_API_URL+"cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
	/**获取用户身上的标签列表*/
	public static final String GET_USER_TAGS_API = BASE_API_URL+"cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
	/**---------------用户管理接口API end-----------------**/


	/**---------------账号管理接口API start-----------------**/
	/**生成带参数的二维码*/
	public static final String ACCOUNT_CREATE_QRCODE_API = BASE_API_URL+"cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	/**长链接转短链接*/
	public static final String SHORT_URL_TRANSFORM_API = BASE_API_URL+"cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	/**---------------账号管理接口API end-----------------**/


	/**---------------数据统计接口API start-----------------**/
	/**用户分析数据接口-获取用户增减数据*/
	public static final String USER_ANALYSE_SUMMARY_API = BASE_API_URL+"datacube/getusersummary?access_token=ACCESS_TOKEN";
	/**用户分析数据接口-获取累计用户数据*/
	public static final String USER_ANALYSE_CUMULATE_API = BASE_API_URL+"datacube/getusercumulate?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文群发每日数据*/
	public static final String ARTICLE__SUMMARY_API = BASE_API_URL+"datacube/getarticlesummary?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文群发总数据*/
	public static final String ARTICLE_TOTAL_API = BASE_API_URL+"datacube/getarticletotal?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文统计数据*/
	public static final String ARTICLE_USER_READ_API = BASE_API_URL+"datacube/getuserread?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文统计分时数据*/
	public static final String ARTICLE_USER_READ_HOUR_API = BASE_API_URL+"datacube/getuserreadhour?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文分享转发数据*/
	public static final String ARTICLE_USER_SHARE_API = BASE_API_URL+"datacube/getusershare?access_token=ACCESS_TOKEN";
	/**图文分析数据接口-获取图文分享转发分时数据*/
	public static final String ARTICLE_USER_SHARE_HOUR_API = BASE_API_URL+"datacube/getusersharehour?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送概况数据*/
	public static final String UPSTREAM_MSG_API = BASE_API_URL+"datacube/getupstreammsg?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息分送分时数据*/
	public static final String UPSTREAM_MSG_HOUR_API = BASE_API_URL+"datacube/getupstreammsghour?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送周数据*/
	public static final String UPSTREAM_MSG_WEEK_API = BASE_API_URL+"datacube/getupstreammsgweek?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送月数据*/
	public static final String UPSTREAM_MSG_MONTH_API = BASE_API_URL+"datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送分布数据*/
	public static final String UPSTREAM_MSG_DIST_API = BASE_API_URL+"datacube/getupstreammsgdist?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送分布周数据*/
	public static final String UPSTREAM_MSG_DIST_WEEK_API = BASE_API_URL+"datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN";
	/**消息分析数据接口-获取消息发送分布月数据*/
	public static final String UPSTREAM_MSG_DIST_MONTH_API = BASE_API_URL+"datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN";
	/**接口分析数据接口-获取接口分析数据*/
	public static final String INTERFACESUMMARY_API = BASE_API_URL+"datacube/getinterfacesummary?access_token=ACCESS_TOKEN";
	/**接口分析数据接口-获取接口分析分时数据*/
	public static final String INTERFACESUMMARY_HOUR_API = BASE_API_URL+"datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN";
	/**---------------数据统计接口API end-----------------**/


	/**---------------微信卡券接口API start-----------------**/
	/**创建卡券*/
	public static final String WX_CARD_CREATE_API = BASE_API_URL+"card/create?access_token=ACCESS_TOKEN";
	/**设置买单接口*/
	public static final String WX_PAY_CELL_API = BASE_API_URL+"card/paycell/set?access_token=ACCESS_TOKEN";
	/**设置自助核销接口*/
	public static final String WX_SELF_CONSUME_API = BASE_API_URL+"card/selfconsumecell/set?access_token=ACCESS_TOKEN";
	/**---------------微信卡券接口API end-----------------**/


	/**---------------微信门店接口API start-----------------**/
	/***拥有已认证的服务号可申请开通门店管理功能 && 认证的订阅号拥有卡券、WI-FI、摇一摇、广告主等功能后会自动开通门店管理功能*/
	/**创建门店*/
	public static final String CREATE_POI_API = BASE_API_URL+"cgi-bin/poi/addpoi?access_token=ACCESS_TOKEN";
	/**查询门店信息*/
	public static final String GET_POI_INFO_API = BASE_API_URL+"cgi-bin/poi/getpoi?access_token=ACCESS_TOKEN";
	/**查询门店列表*/
	public static final String GET_POI_LIST_API = BASE_API_URL+"cgi-bin/poi/getpoilist?access_token=ACCESS_TOKEN";
	/**修改门店服务信息*/
	public static final String UPDATE_POI_INFO_API = BASE_API_URL+"cgi-bin/poi/updatepoi?access_token=ACCESS_TOKEN";
	/**删除门店*/
	public static final String DELETE_POI_API = BASE_API_URL+"cgi-bin/poi/delpoi?access_token=ACCESS_TOKEN";
	/**门店类目*/
	public static final String GET_POI_CATEGORY_API = BASE_API_URL+"cgi-bin/poi/getwxcategory?access_token=ACCESS_TOKEN";
	/**---------------微信门店接口API end-----------------**/



	/**---------------微信小店接口API start-----------------**/
	/**新增一个商品接口*/
	public static final String GOODS_ADD_API = BASE_API_URL+"merchant/create?access_token=ACCESS_TOKEN";
	/**删除一个商品*/
	public static final String GOODS_DELETE_API = BASE_API_URL+"merchant/del?access_token=ACCESS_TOKEN";
	/**---------------微信小店接口API end-----------------**/

}
