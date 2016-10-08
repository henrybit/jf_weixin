package com.github.jf.weixin.entity.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 卡券扩展字段cardExt说明<br>
 * <table style="border:1px solid" border="1">
    <tbody>
    <tr><th style="width:10px">字段</th><th>是否必填</th><th>说明</th></tr>
    <tr><td> code</td><td> 否</td><td> 指定的卡券code码，只能被领一次。<font color="red">use_custom_code字段为true的卡券必须填写，非自定义code不必填写</font>。</td></tr>
    <tr><td> openid</td><td> 否</td><td> 指定领取者的openid，只有该用户能领取。<font color="red">bind_openid字段为true的卡券必须填写，bind_openid字段为false不必填写</font>。</td></tr>
    <tr><td> timestamp</td><td> 是</td><td> 时间戳，商户生成从1970年1月1日00:00:00至今的秒数,即<font color="red">当前的时间</font>,且最终需要转换为字符串形式;由商户生成后传入,<font color="red">不同添加请求的时间戳须动态生成，若重复将会导致领取失败！</font>。</td></tr>
    <tr><td> nonce_str</td><td> 否</td><td> 随机字符串，由开发者设置传入，加强签名的安全性。随机字符串，不长于32位。推荐使用大小写字母和数字，<font color="red">不同添加请求的nonce须动态生成，若重复将会导致领取失败！</font>。</td></tr>
    <tr><td> signature</td><td> 是</td><td> 签名，商户将接口列表中的参数按照指定方式进行签名,签名方式使用SHA1,具体签名方案参见下文;由商户按照规范签名后传入。</td></tr>
    <tr><td> outer_id</td><td> 否</td><td> 领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。用户领取卡券后触发的事件推送中会带上此自定义场景值，不参与签名。</td></tr>
    </tbody>
    </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardExt {
	@JSONField(name="code")
    protected String code;
	@JSONField(name="openid")
    protected String openid;
	@JSONField(name="timestamp")
    protected String timestamp;
	@JSONField(name="nonce_str")
    protected String nonceStr;
	@JSONField(name="signature")
    protected String signature;
	@JSONField(name="outer_id")
    protected String outerId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public CardExt(String code, String openid, String timestamp, String signature) {
    	this.code = code;
    	this.openid = openid;
    	this.timestamp = timestamp;
    	this.signature = signature;
    }
    
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("code",this.code);
        jsonMap.put("openid",this.openid);
        jsonMap.put("timestamp",this.timestamp);
        jsonMap.put("signature",this.signature);
        jsonMap.put("nonce_str",this.nonceStr);
        jsonMap.put("outerId",this.outerId);
        return JSONUtil.toJson(jsonMap);
    }
}
