package com.github.jf.weixin.entity.request.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 设置买单接口请求报文<br>
 * <table border="1" cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 350px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">字段名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">说明</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_id</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券ID。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">is_open</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是否开启买单功能，填true/false</span></td></tr></tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SettingPaycellRequest extends BaseRequest{

    @JSONField(name="card_id")
    protected String cardId;
    @JSONField(name="is_open")
    protected boolean isOpen;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
