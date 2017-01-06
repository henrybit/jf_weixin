package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 微信卡券信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardInfo extends BaseModel {
    @JSONField(name="card_type")
    protected String cardType;
    @JSONField(name="groupon")
    protected CardGroup cardGroup;
    @JSONField(name="cash")
    protected CardCash cardCash;
    @JSONField(name="discount")
    protected CardDiscount cardDiscount;
    @JSONField(name="gift")
    protected CardGift cardGift;
    @JSONField(name="general_coupon")
    protected CardGeneralCoupon cardGeneralCoupon;


    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public CardGroup getCardGroup() {
        return cardGroup;
    }

    public void setCardGroup(CardGroup cardGroup) {
        this.cardGroup = cardGroup;
    }

    public CardCash getCardCash() {
        return cardCash;
    }

    public void setCardCash(CardCash cardCash) {
        this.cardCash = cardCash;
    }

    public CardDiscount getCardDiscount() {
        return cardDiscount;
    }

    public void setCardDiscount(CardDiscount cardDiscount) {
        this.cardDiscount = cardDiscount;
    }

    public CardGift getCardGift() {
        return cardGift;
    }

    public void setCardGift(CardGift cardGift) {
        this.cardGift = cardGift;
    }

    public CardGeneralCoupon getCardGeneralCoupon() {
        return cardGeneralCoupon;
    }

    public void setCardGeneralCoupon(CardGeneralCoupon cardGeneralCoupon) {
        this.cardGeneralCoupon = cardGeneralCoupon;
    }
}
