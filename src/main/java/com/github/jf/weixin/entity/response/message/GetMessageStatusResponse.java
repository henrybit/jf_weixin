package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 查询消息发送状态<br>
 * <pre>
 *     范例:{@code{"msg_id":201053012,"msg_status":"SEND_SUCCESS"}}
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetMessageStatusResponse extends BaseResponse {
    @JSONField(name="msg_id")
    protected long msgId;
    @JSONField(name="msg_status")
    protected String msgStatus;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }
}
