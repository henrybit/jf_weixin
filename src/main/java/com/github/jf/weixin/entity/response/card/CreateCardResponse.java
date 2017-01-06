package com.github.jf.weixin.entity.response.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 创建卡券返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateCardResponse extends BaseResponse{

    @JSONField(name="card_id")
    protected String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
