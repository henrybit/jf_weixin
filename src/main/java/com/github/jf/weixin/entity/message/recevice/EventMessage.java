package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

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
 *         <xml>
            <ToUserName><![CDATA[toUser]]></ToUserName>
            <FromUserName><![CDATA[FromUser]]></FromUserName>
            <CreateTime>123456789</CreateTime>
            <MsgType><![CDATA[event]]></MsgType>
            <Event><![CDATA[VIEW]]></Event>
            <EventKey><![CDATA[www.qq.com]]></EventKey>
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
    @XmlField(name="Ticket")
    protected String ticket;
    @XmlField(name="Latitude")
    protected String latitude;
    @XmlField(name="Longitude")
    protected String longitude;
    @XmlField(name="Precision")
    protected String precision;

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
}