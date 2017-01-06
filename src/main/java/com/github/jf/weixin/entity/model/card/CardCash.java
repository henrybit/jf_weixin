package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 代金券<br>
 * <table border="1" cellspacing="0" cellpadding="2" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 100px;" class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">card_type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(24)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">CASH</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">代金券类型。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">base_info</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">基本的卡券数据，见下表，所有卡券通用。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">least_cost</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">10000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">reduce_cost</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">10000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">代金券专用，表示减免金额。（单位为分）</span></td></tr></tbody></table>
 * <p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; color: rgb(51, 51, 51); font-family: 'Microsoft Yahei', 宋体, Tahoma, Arial; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);"><strong>JSON示例</strong></p>
 * <pre style="font-stretch: normal; font-size: 12px; font-family: 'MicroSoft YaHei', 'Courier New', 'Andale Mono', monospace; padding: 5px 10px; border: 1px solid rgb(204, 204, 204); color: rgb(51, 51, 51); line-height: 20px; white-space: pre-wrap; word-wrap: break-word; border-radius: 3px; margin-left: 10px;">
 *  {
     &nbsp;"card":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"card_type":&nbsp;"CASH",
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"cash":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"base_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"advanced_info":&nbsp;{
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;················
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"least_cost":&nbsp;1000,
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"reduce_cost":&nbsp;100,
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
     &nbsp;}
     }
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardCash extends BaseModel{
    @JSONField(name="base_info")
    protected CardBaseInfo cardBaseInfo;
    @JSONField(name="advanced_info")
    protected CardAdvancedInfo cardAdvancedInfo;
    /**代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。*/
    @JSONField(name="least_cost")
    protected int leastCost;
    /**代金券专用，表示减免金额。（单位为分）*/
    @JSONField(name="reduce_cost")
    protected int reduceCost;

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

    public int getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(int leastCost) {
        this.leastCost = leastCost;
    }

    public int getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(int reduceCost) {
        this.reduceCost = reduceCost;
    }
}
