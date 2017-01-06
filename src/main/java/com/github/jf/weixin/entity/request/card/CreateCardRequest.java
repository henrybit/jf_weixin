package com.github.jf.weixin.entity.request.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.card.CardInfo;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 创建卡券请求报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateCardRequest extends BaseRequest{

    @JSONField(name="card")
    protected CardInfo cardInfo;

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }
}
