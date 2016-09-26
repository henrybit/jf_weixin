package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 接收到的定位信息<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *      {@code
 *      <xml>
        <ToUserName><![CDATA[toUser]]></ToUserName>
        <FromUserName><![CDATA[fromUser]]></FromUserName>
        <CreateTime>1351776360</CreateTime>
        <MsgType><![CDATA[location]]></MsgType>
        <Location_X>23.134521</Location_X>
        <Location_Y>113.358803</Location_Y>
        <Scale>20</Scale>
        <Label><![CDATA[位置信息]]></Label>
        <MsgId>1234567890123456</MsgId>
        </xml>
 *      }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class LocationMessage extends BaseRecevice{
    @XmlField(name="Location_X")
    protected String locationx;
    @XmlField(name="Location_Y")
    protected String locationy;
    @XmlField(name="Scale")
    protected String scale;
    @XmlField(name="Label")
    protected String label;
    @XmlField(name="MsgId")
    protected String msgId;

    public String getLocationx() {
        return locationx;
    }

    public void setLocationx(String locationx) {
        this.locationx = locationx;
    }

    public String getLocationy() {
        return locationy;
    }

    public void setLocationy(String locationy) {
        this.locationy = locationy;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
