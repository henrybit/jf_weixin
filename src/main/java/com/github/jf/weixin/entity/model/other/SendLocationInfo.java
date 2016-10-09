package com.github.jf.weixin.entity.model.other;

import com.github.jf.weixin.annotation.XmlField;

/**
 * 发送定位信息<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center"><tbody>
 *    <tr><th style="width:180px">参数</th><th style="width:470px">描述</th></tr>
 *    <tr><td> SendLocationInfo</td><td> 发送的位置信息</td></tr>
 *    <tr><td> Location_X</td><td> X坐标信息</td></tr>
 *    <tr><td> Location_Y</td><td> Y坐标信息</td></tr>
 *    <tr><td> Scale</td><td> 精度，可理解为精度或者比例尺、越精细的话 scale越高</td></tr>
 *    <tr><td> Label</td><td> 地理位置的字符串信息</td></tr>
 *    <tr><td> Poiname</td><td> 朋友圈POI的名字，可能为空</td></tr>
 * </tbody></table>
 * <pre>
 *     范例:
 * {@code
 * <SendLocationInfo><Location_X><![CDATA[23]]></Location_X>
 * <Location_Y><![CDATA[113]]></Location_Y>
 * <Scale><![CDATA[15]]></Scale>
 * <Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>
 * <Poiname><![CDATA[]]></Poiname>
 * </SendLocationInfo>
 * }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SendLocationInfo {
    @XmlField(name="Location_X")
    protected String locationX;
    @XmlField(name="Location_Y")
    protected String locationY;
    @XmlField(name="Scale")
    protected String scale;
    @XmlField(name="Label")
    protected String label;
    @XmlField(name="Poiname")
    protected String poiname;

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
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

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }
}
