package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseDataCube;

/**
 * 消息发送概况数据<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> ref_date</td><td> 数据的日期，需在begin_date和end_date之间</td></tr>
 *     <tr><td> ref_hour</td><td> 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时</td></tr>
 *     <tr><td> msg_type</td><td> 消息类型，代表含义如下：<p>1代表文字 2代表图片 3代表语音 4代表视频 6代表第三方应用消息（链接消息）</p></td></tr>
 *     <tr><td> msg_user</td><td> 上行发送了（向公众号发送了）消息的用户数</td></tr>
 *     <tr><td> msg_count</td><td> 上行发送了消息的消息总数</td></tr>
 *     <tr><td> count_interval</td><td> 当日发送消息量分布的区间，0代表 “0”，1代表“1-5”，2代表“6-10”，3代表“10次以上”</td></tr>
 *     <tr><td> int_page_read_count</td><td> 图文页的阅读次数</td></tr>
 *     <tr><td> ori_page_read_user</td><td> 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UpstreamMsg extends BaseDataCube {

    @JSONField(name="msg_type")
    private Integer msgType;
    @JSONField(name="msg_user")
    private Integer msgUser;
    @JSONField(name="msg_count")
    private Integer msgCount;

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getMsgUser() {
        return msgUser;
    }

    public void setMsgUser(Integer msgUser) {
        this.msgUser = msgUser;
    }

    public Integer getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }
}
