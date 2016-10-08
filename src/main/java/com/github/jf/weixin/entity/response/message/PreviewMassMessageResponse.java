package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 预览<br>
 * <pre>
 *     范例
 *     {@code
 *      {"errcode":0,"errmsg":"preview success","msg_id":34182}
 *     }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class PreviewMassMessageResponse extends BaseResponse {
    @JSONField(name="msg_id")
    protected long msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
