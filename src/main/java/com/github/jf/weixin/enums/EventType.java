package com.github.jf.weixin.enums;

/**
 * 事件类型<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public enum EventType {
	/**
	 * 关注
	 */
	SUBSCRIBE("subscribe"),
	
	/**
	 * 取消关注
	 */
	UNSUBSCRIBE("unsubscribe"),
	
	/**
	 * 点击菜单
	 */
	CLICK("CLICK"),
	
	/**
	 * 试图菜单
	 */
	VIEW("VIEW"),
	
	/**
	 * 定位事件
	 */
	LOCATION("LOCATION"),
	
	/**
	 * 扫码事件
	 */
	SCAN("SCAN"),
	
	/**
	 * 扫码推送事件
	 */
	SCANCODEPUSH("scancode_push"),
	
	/**
	 * 扫码等待事件
	 */
	SCANCODEWAITMSG("scancode_waitmsg"),
	
	/**
	 * 选择系统照片
	 */
	PICSYSPHOTO("pic_sysphoto"),
	
	/**
	 * 系统照片或拍照
	 */
	PICPHOTOORALBUM("pic_photo_or_album"),
	
	/**
	 * pic_weixin
	 */
	PICWEIXIN("pic_weixin"),
	
	/**
	 * 门店审核事件推送
	 */
	POI_CHECK_NOTIFY("poi_check_notify"),
	
	/**
	 * location_select
	 */
	LOCATIONSELECT("location_select"),
	
	/**
	 * TEMPLATESENDJOBFINISH
	 */
	TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH"),
	
	/**
	 * MASSSENDJOBFINISH
	 */
	MASSSENDJOBFINISH("MASSSENDJOBFINISH"),

	/**
	 * 买单事件推送(微信卡券买单功能-方便消费者买单时,直接输入消费金额,自动使用领到的优惠抵扣,并拉起微信支付快速完成付款)
	 */
	USER_PAY_FROM_PAY_CELL("user_pay_from_pay_cell");
	
	String value;
	EventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
    
//    public static final String SUBSCRIBE = "subscribe";
//    public static final String UNSUBSCRIBE = "unsubscribe";
    //public static final String CLICK = "CLICK";
//    public static final String VIEW = "VIEW";
//    public static final String LOCATION = "LOCATION";
//    public static final String SCAN = "SCAN";
//    public static final String SCANCODEPUSH = "scancode_push";
//    public static final String SCANCODEWAITMSG = "scancode_waitmsg";
//    public static final String PICSYSPHOTO = "pic_sysphoto";
//    public static final String PICPHOTOORALBUM = "pic_photo_or_album";
//    public static final String PICWEIXIN = "pic_weixin";
//    public static final String POI_CHECK_NOTIFY = "poi_check_notify";
//    public static final String LOCATIONSELECT = "location_select";
//    public static final String TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
//    public static final String MASSSENDJOBFINISH = "MASSSENDJOBFINISH";
//
//    private EventType() {
//    }

}
