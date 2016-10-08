package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 发送模版消息响应<br>
 * <pre>
 * 范例:
 *  {"errcode":0,"errmsg":"ok","msgid":200228332}
 * </pre>
 * @author henrybit
 * @version 2.0
 * @since 2.0
 */
public class SendTemplateResponse extends BaseResponse {

    /**
     * 消息id
     */
    @JSONField(name = "msgid")
    private String msgid;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}
