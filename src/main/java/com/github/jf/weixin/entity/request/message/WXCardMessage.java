package com.github.jf.weixin.entity.request.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.card.CardExt;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 卡券消息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class WXCardMessage extends BaseRequestMessage {
    //卡ID
	@JSONField(name="card_id")
    protected String cardId;
    //卡券扩展字段
	@JSONField(name="card_ext")
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

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("card_id",this.cardId);
        jsonMap.put("card_ext",this.cardExt.toJson());
        return JSONUtil.toJson(jsonMap);
    }
}
