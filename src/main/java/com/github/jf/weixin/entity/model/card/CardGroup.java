package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 团购券<br>
 * <table border="1" cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 100px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(24)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">GROUPON</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">团购券类型。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">base_info</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">基本的卡券数据</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，见下表，所有卡券类型通用。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">deal_detail</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(<span style="font-family: 微软雅黑, 'Microsoft YaHei';">3072</span>)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">双人套餐\n -进口红酒一支。\n孜然牛肉一份。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">团购券专用，团购详情。</span></td></tr></tbody></table>
 * <p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; color: rgb(51, 51, 51); font-family: 'Microsoft Yahei', 宋体, Tahoma, Arial; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);"><strong>JSON示例</strong></p>
 * <pre style="font-stretch: normal; font-size: 12px; font-family: 'MicroSoft YaHei', 'Courier New', 'Andale Mono', monospace; padding: 5px 10px; border: 1px solid rgb(204, 204, 204); color: rgb(51, 51, 51); line-height: 20px; white-space: pre-wrap; word-wrap: break-word; border-radius: 3px; margin-left: 10px;">
 *     {
         &nbsp;"card":&nbsp;{
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"card_type":&nbsp;"GROUPON",
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"groupon":&nbsp;{
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"base_info":&nbsp;{
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"advanced_info":&nbsp;{
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"deal_detail":&nbsp;"示例"
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
         &nbsp;}
         }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardGroup extends BaseModel{
    @JSONField(name="base_info")
    protected CardBaseInfo cardBaseInfo;
    @JSONField(name="advanced_info")
    protected CardAdvancedInfo cardAdvancedInfo;
    @JSONField(name="deal_detail")
    protected String dealDetail;

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

    public String getDealDetail() {
        return dealDetail;
    }

    public void setDealDetail(String dealDetail) {
        this.dealDetail = dealDetail;
    }
}
