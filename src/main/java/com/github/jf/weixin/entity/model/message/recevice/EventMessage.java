package com.github.jf.weixin.entity.model.message.recevice;

import com.github.jf.weixin.annotation.XmlField;
import com.github.jf.weixin.entity.model.other.ScanCodeInfo;
import com.github.jf.weixin.entity.model.other.SendLocationInfo;
import com.github.jf.weixin.entity.model.other.SendPicsInfo;

/**
 * 接收到的事件<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         关注/取消关注事件<br>
 *         {@code
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[subscribe]]></Event>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         扫描带参数二维码事件-1. 用户未关注时，进行关注后的事件推送<br>
 *         {@code
            <xml><ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[subscribe]]></Event>
            <EventKey><![CDATA[qrscene_123123]]></EventKey>
            <Ticket><![CDATA[TICKET]]></Ticket>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         扫描带参数二维码事件-2. 用户已关注时的事件推送<br>
 *         {@code
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[SCAN]]></Event>
            <EventKey><![CDATA[SCENE_VALUE]]></EventKey>
            <Ticket><![CDATA[TICKET]]></Ticket>
            </xml>
 *         }
 *     </li>
 *     <li>
 *          上报地理位置事件<br>
 *          {@code
 *          <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[fromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[LOCATION]]></Event>
            <Latitude>23.137466</Latitude>
            <Longitude>113.352425</Longitude>
            <Precision>119.385040</Precision>
            </xml>
 *          }
 *     </li>
 *     <li>
 *         点击菜单拉取消息时的事件推送<br>
 *         {@code
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[CLICK]]></Event>
            <EventKey><![CDATA[EVENTKEY]]></EventKey>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         点击菜单跳转链接时的事件推送<br>
 *         {@code
            <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[VIEW]]></Event>
            <EventKey><![CDATA[www.qq.com]]></EventKey>
            <MenuId>MENUID</MenuId>
            </xml>
 *         }
 *     </li>
 *     <li>
 *     	   点击菜单扫码push<br>
 *       {@code
 *       <xml><ToUserName><![CDATA[gh_b68014892909]]></ToUserName>
		<FromUserName><![CDATA[oMt1sxK_DNo7CesbmoYs4tNW2rOI]]></FromUserName>
		<CreateTime>1474890608</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
		<Event><![CDATA[scancode_push]]></Event>
		<EventKey><![CDATA[A003]]></EventKey>
		<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>
		<ScanResult><![CDATA[http://weixin.qq.com/r/0e-UzCrEh3f4rW6v97rD]]></ScanResult>
		</ScanCodeInfo>
		</xml>
 *       }
 *     </li>
 *     <li>
 *     	 点击扫码等待<br>
 *       {@code
 *       <xml><ToUserName><![CDATA[gh_b68014892909]]></ToUserName>
		<FromUserName><![CDATA[oMt1sxK_DNo7CesbmoYs4tNW2rOI]]></FromUserName>
		<CreateTime>1474890615</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
		<Event><![CDATA[scancode_waitmsg]]></Event>
		<EventKey><![CDATA[A004]]></EventKey>
		<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>
		<ScanResult><![CDATA[http://weixin.qq.com/r/0e-UzCrEh3f4rW6v97rD]]></ScanResult>
		</ScanCodeInfo>
		</xml>
 *       }
 *     </li>
 *     <li>
 *         弹出系统拍照发图的事件推送<br>
 *         {@code
 *         <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
            <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
            <CreateTime>1408090651</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[pic_sysphoto]]></Event>
            <EventKey><![CDATA[6]]></EventKey>
            <SendPicsInfo><Count>1</Count>
            <PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum>
            </item>
            </PicList>
            </SendPicsInfo>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         弹出拍照或者相册发图的事件推送<br>
 *         {@code
 *         <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
            <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
            <CreateTime>1408090816</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[pic_photo_or_album]]></Event>
            <EventKey><![CDATA[6]]></EventKey>
            <SendPicsInfo><Count>1</Count>
            <PicList><item><PicMd5Sum><![CDATA[5a75aaca956d97be686719218f275c6b]]></PicMd5Sum>
            </item>
            </PicList>
            </SendPicsInfo>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         弹出微信相册发图器的事件推送<br>
 *         {@code
 *         <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
            <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
            <CreateTime>1408090816</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[pic_weixin]]></Event>
            <EventKey><![CDATA[6]]></EventKey>
            <SendPicsInfo><Count>1</Count>
            <PicList><item><PicMd5Sum><![CDATA[5a75aaca956d97be686719218f275c6b]]></PicMd5Sum>
            </item>
            </PicList>
            </SendPicsInfo>
            </xml>
 *         }
 *     </li>
 *     <li>
 *         弹出地理位置选择器的事件推送<br>
 *         {@code
 *         <xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>
            <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>
            <CreateTime>1408091189</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[location_select]]></Event>
            <EventKey><![CDATA[6]]></EventKey>
            <SendLocationInfo><Location_X><![CDATA[23]]></Location_X>
            <Location_Y><![CDATA[113]]></Location_Y>
            <Scale><![CDATA[15]]></Scale>
            <Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>
            <Poiname><![CDATA[]]></Poiname>
            </SendLocationInfo>
            </xml>
 *         }
 *     </li>
 *     <li>
 *     		门店审核事件推送<br>
 *     		{@code
 *     		<xml>
			<ToUserName><![CDATA[toUser]]></ToUserName>
			<FromUserName><![CDATA[fromUser]]></FromUserName>
			<CreateTime>1408622107</CreateTime>
			<MsgType><![CDATA[event]]></MsgType>
			<Event><![CDATA[poi_check_notify]]></Event>
			<UniqId><![CDATA[123adb]]></UniqId>
			<PoiId><![CDATA[123123]]></PoiId>
			<Result><![CDATA[fail]]></Result>
			<msg><![CDATA[xxxxxx]]></msg>
			</xml>
 *     		}
 *     </li>
 *     <li>
 *       买单事件推送<br>
         微信买单完成时，微信会把这个事件推送到开发者填写的URL。 推送XML数据包示例：
        {@code
         <xml>
         <ToUserName><![CDATA[gh_e2243xxxxxxx]]></ToUserName>
         <FromUserName><![CDATA[oo2VNuOUuZGMxxxxxxxx]]></FromUserName>
         <CreateTime>1442390947</CreateTime>
         <MsgType><![CDATA[event]]></MsgType>
         <Event><![CDATA[user_pay_from_pay_cell]]></Event>
         <CardId><![CDATA[po2VNuCuRo-8sxxxxxxxxxxx]]></CardId>
         <UserCardCode><![CDATA[38050000000]]></UserCardCode>
         <TransId><![CDATA[10022403432015000000000]]></TransId>
         <LocationId>291710000</LocationId>
         <Fee><![CDATA[10000]]></Fee>
         <OriginalFee><![CDATA[10000]]> </OriginalFee>
         </xml>
        }
 *     </li>
 *     <li>
 *      微小店铺-订单付款通知<br>
 *     {@code
 *       <xml>
         <ToUserName><![CDATA[weixin_media1]]></ToUserName>
         <FromUserName><![CDATA[oDF3iYyVlek46AyTBbMRVV8VZVlI]]></FromUserName>
         <CreateTime>1398144192</CreateTime>
         <MsgType><![CDATA[event]]></MsgType>
         <Event><![CDATA[merchant_order]]></Event>
         <OrderId><![CDATA[test_order_id]]></OrderId>
         <OrderStatus>2</OrderStatus>
         <ProductId><![CDATA[test_product_id]]></ProductId>
         <SkuInfo><![CDATA[10001:1000012;10002:100021]]></SkuInfo>
         </xml>
        }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class EventMessage extends BaseRecevice{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1068730539729292563L;
	/**事件类型*/
	@XmlField(name="Event")
    protected String event;
	/**事件子类型*/
    @XmlField(name="EventKey")
    protected String eventKey;
    /**菜单ID*/
    @XmlField(name="MenuId")
    protected String menuId;
    /**Ticket*/
    @XmlField(name="Ticket")
    protected String ticket;
    /**纬度*/
    @XmlField(name="Latitude")
    protected String latitude;
    /**经度*/
    @XmlField(name="Longitude")
    protected String longitude;
    /**准确度*/
    @XmlField(name="Precision")
    protected String precision;
    /**扫码结果*/
    @XmlField(name="ScanCodeInfo")
    protected ScanCodeInfo scanCodeInfo;
    /**发送的图片集合*/
    @XmlField(name="SendPicsInfo")
    protected SendPicsInfo sendPicsInfo;
    /**发送的定位信息*/
    @XmlField(name="SendLocationInfo")
    protected SendLocationInfo sendLocationInfo;
    
    /**商户自己内部ID，即字段中的sid*/
    @XmlField(name="UniqId")
    protected String uniqId;
    /**微信的门店ID，微信内门店唯一标示ID*/
    @XmlField(name="PoiId")
    protected String poiId;
    /**审核结果，成功succ 或失败fail*/
    @XmlField(name="Result")
    protected String result;
    /**成功的通知信息，或审核失败的驳回理由*/
    @XmlField(name="msg")
    protected String msg;

    /**微信卡券ID*/
    @XmlField(name="CardId")
    protected String cardId;
    /**微信卡券code码*/
    @XmlField(name="UserCardCode")
    protected String userCardCode;
    /**交易订单号*/
    @XmlField(name="TransId")
    protected String transId;
    /**门店ID*/
    @XmlField(name="LocationId")
    protected String locationId;
    /**门店名-通过卡券商户助手和买单核销时才会出现*/
    @XmlField(name="LocationName")
    protected String locationName;
    /**实付金额:单位分*/
    @XmlField(name="Fee")
    protected String fee;
    /**应付金额:单位分*/
    @XmlField(name="OriginalFee")
    protected String originalFee;
    
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
    
    public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }

	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	public String getPoiId() {
		return poiId;
	}

	public void setPoiId(String poiId) {
		this.poiId = poiId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserCardCode() {
        return userCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        this.userCardCode = userCardCode;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getOriginalFee() {
        return originalFee;
    }

    public void setOriginalFee(String originalFee) {
        this.originalFee = originalFee;
    }
}
