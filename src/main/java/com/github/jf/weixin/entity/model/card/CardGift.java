package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 兑换券<br>
 * <table border="1" cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 100px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(24)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">GIFT</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">兑换券类型。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">base_info</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">Json结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">基本的卡券数据</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，所有卡券通用。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">gift</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(3072)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">可兑换音乐木盒一个。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">兑换券专用，填写兑换内容的名称。</span></td></tr></tbody></table>
 * <p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; color: rgb(51, 51, 51); font-family: 'Microsoft Yahei', 宋体, Tahoma, Arial; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);"><strong>JSON示例</strong></p>
 * <pre style="font-stretch: normal; font-size: 12px; font-family: 'MicroSoft YaHei', 'Courier New', 'Andale Mono', monospace; padding: 5px 10px; border: 1px solid rgb(204, 204, 204); color: rgb(51, 51, 51); line-height: 20px; white-space: pre-wrap; word-wrap: break-word; border-radius: 3px; margin-left: 10px;">
 *  {
     "card":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;"card_type":&nbsp;"GIFT",
     &nbsp;&nbsp;&nbsp;&nbsp;"gift":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"base_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"advanced_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"gift":"可兑换音乐木盒一个"
     &nbsp;&nbsp;&nbsp;&nbsp;}
     &nbsp;&nbsp;}
     }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardGift extends BaseModel{
    @JSONField(name="base_info")
    protected CardBaseInfo cardBaseInfo;
    @JSONField(name="advanced_info")
    protected CardAdvancedInfo cardAdvancedInfo;
    @JSONField(name="gift")
    protected String gift;

    public CardBaseInfo getCardBaseInfo() {
        return cardBaseInfo;
    }

    public void setCardBaseInfo(CardBaseInfo cardBaseInfo) {
        this.cardBaseInfo = cardBaseInfo;
    }

    public CardAdvancedInfo getCardAdvancedInfo() {
        return cardAdvancedInfo;
    }

    public void setCardAdvancedInfo(CardAdvancedInfo cardAdvancedInfo) {
        this.cardAdvancedInfo = cardAdvancedInfo;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
