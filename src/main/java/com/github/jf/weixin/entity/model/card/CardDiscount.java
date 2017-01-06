package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 折扣券<br>
 * <table border="1" cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 100px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(24)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">DISCOUNT</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">折扣券类型。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">base_info</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">Json结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">基本的卡券数据</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，见下表，所有卡券通用。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">discount</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">30</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">折扣券专用，表示打折额度（百分比）。填30就是七折。</span></td></tr></tbody></table>
 * <p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; color: rgb(51, 51, 51); font-family: 'Microsoft Yahei', 宋体, Tahoma, Arial; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);"><strong>JSON示例</strong></p>
 * <pre style="font-stretch: normal; font-size: 12px; font-family: 'MicroSoft YaHei', 'Courier New', 'Andale Mono', monospace; padding: 5px 10px; border: 1px solid rgb(204, 204, 204); color: rgb(51, 51, 51); line-height: 20px; white-space: pre-wrap; word-wrap: break-word; border-radius: 3px; margin-left: 10px;">
 *  {
     &nbsp;"card":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"card_type":&nbsp;"DISCOUNT",
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"discount":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"base_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"advanced_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"discount":&nbsp;30
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
     &nbsp;&nbsp;&nbsp;}
     }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardDiscount extends BaseModel{
    @JSONField(name="base_info")
    protected CardBaseInfo cardBaseInfo;
    @JSONField(name="advanced_info")
    protected CardAdvancedInfo cardAdvancedInfo;
    @JSONField(name="discount")
    protected int discount;

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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
