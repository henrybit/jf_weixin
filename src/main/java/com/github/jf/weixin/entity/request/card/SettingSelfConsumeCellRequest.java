package com.github.jf.weixin.entity.request.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 设置自助核销接口请求报文<br>
 * <table cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 350px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">字段名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">说明</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_id</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券ID。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">is_open</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是否开启自助核销功能，填true/false，默认为false</span></td></tr><tr><td class="table_cell" colspan="1" rowspan="1"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">need_verify_cod</span></p></td><td class="table_cell" colspan="1" rowspan="1"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">用户核销时是否需要输入验证码，<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">填true/false，</span>默认为false</span></td></tr><tr><td class="table_cell" colspan="1" rowspan="1"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">need_remark_amount</span></p></td><td class="table_cell" colspan="1" rowspan="1"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">用户核销时是否需要备注核销金额，<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">填true/false，</span><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">默认为false</span></span></td></tr></tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SettingSelfConsumeCellRequest extends BaseRequest{
    @JSONField(name="card_id")
    protected String cardId;
    @JSONField(name="is_open")
    protected boolean isOpen;
    @JSONField(name="need_verify_cod")
    protected boolean needVerifyCod;
    @JSONField(name="need_remark_amount")
    protected boolean needRemarkAmount;

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

    public boolean isNeedVerifyCod() {
        return needVerifyCod;
    }

    public void setNeedVerifyCod(boolean needVerifyCod) {
        this.needVerifyCod = needVerifyCod;
    }

    public boolean isNeedRemarkAmount() {
        return needRemarkAmount;
    }

    public void setNeedRemarkAmount(boolean needRemarkAmount) {
        this.needRemarkAmount = needRemarkAmount;
    }
}
