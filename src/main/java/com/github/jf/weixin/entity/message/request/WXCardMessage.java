package com.github.jf.weixin.entity.message.request;

import com.github.jf.weixin.entity.CardExt;

import java.util.HashMap;

/**
 * 卡券消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class WXCardMessage {
    //卡ID
    protected String cardId;
    //卡券扩展字段
    protected CardExt cardExt;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public CardExt getCardExt() {
        return cardExt;
    }

    public void setCardExt(CardExt cardExt) {
        this.cardExt = cardExt;
    }
}
