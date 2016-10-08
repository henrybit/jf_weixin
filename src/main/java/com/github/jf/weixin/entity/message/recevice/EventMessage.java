package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.annotation.XmlField;
import com.github.jf.weixin.entity.other.ScanCodeInfo;
import com.github.jf.weixin.entity.other.SendLocationInfo;
import com.github.jf.weixin.entity.other.SendPicsInfo;

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
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class EventMessage extends BaseRecevice{
    @XmlField(name="Event")
    protected String event;
    @XmlField(name="EventKey")
    protected String eventKey;
    @XmlField(name="MenuId")
    protected String menuId;
    @XmlField(name="Ticket")
    protected String ticket;
    @XmlField(name="Latitude")
    protected String latitude;
    @XmlField(name="Longitude")
    protected String longitude;
    @XmlField(name="Precision")
    protected String precision;
    @XmlField(name="ScanCodeInfo")
    protected ScanCodeInfo scanCodeInfo;
    @XmlField(name="SendPicsInfo")
    protected SendPicsInfo sendPicsInfo;
    @XmlField(name="SendLocationInfo")
    protected SendLocationInfo sendLocationInfo;

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
}
