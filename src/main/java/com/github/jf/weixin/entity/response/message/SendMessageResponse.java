package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 根据OpenId集合发送群消息的Response<br>
 * {@code
 * {"errcode":0,"errmsg":"send job submission success","msg_id":34182,"msg_data_id": 206227730}
 * }
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SendMessageResponse extends BaseResponse {
    @JSONField(name="msg_id")
    protected long msgId;
    @JSONField(name="msg_data_id")
    protected long msgDataId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public long getMsgDataId() {
        return msgDataId;
    }

    public void setMsgDataId(long msgDataId) {
        this.msgDataId = msgDataId;
    }
}
