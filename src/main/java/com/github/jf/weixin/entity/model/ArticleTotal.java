package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * 图文群发总数据<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> ref_date</td><td> 数据的日期，需在begin_date和end_date之间</td></tr>
 *     <tr><td> ref_hour</td><td> 数据的小时，包括从000到2300，分别代表的是[000,100)到[2300,2400)，即每日的第1小时和最后1小时</td></tr>
 *     <tr><td> stat_date</td><td> 统计的日期，在getarticletotal接口中，ref_date指的是文章群发出日期， 而stat_date是数据统计日期</td></tr>
 *     <tr><td> msgid</td><td> 请注意：这里的msgid实际上是由msgid（图文消息id，这也就是群发接口调用后返回的msg_data_id）和index（消息次序索引）组成， 例如12003_3， 其中12003是msgid，即一次群发的消息的id； 3为index，假设该次群发的图文消息共5个文章（因为可能为多图文），3表示5个中的第3个</td></tr>
 *     <tr><td> title</td><td> 图文消息的标题</td></tr>
 *     <tr><td> int_page_read_user</td><td> 图文页（点击群发图文卡片进入的页面）的阅读人数</td></tr>
 *     <tr><td> int_page_read_count</td><td> 图文页的阅读次数</td></tr>
 *     <tr><td> ori_page_read_user</td><td> 原文页（点击图文页“阅读原文”进入的页面）的阅读人数，无原文页时此处数据为0</td></tr>
 *     <tr><td> ori_page_read_count</td><td> 原文页的阅读次数</td></tr>
 *     <tr><td> share_scene</td><td> 分享的场景<p>1代表好友转发 2代表朋友圈 3代表腾讯微博 255代表其他</p></td></tr>
 *     <tr><td> share_user</td><td> 分享的人数</td></tr>
 *     <tr><td> share_count</td><td> 分享的次数</td></tr>
 *     <tr><td> add_to_fav_user</td><td> 收藏的人数</td></tr>
 *     <tr><td> add_to_fav_count</td><td> 收藏的次数</td></tr>
 *     <tr><td> target_user</td><td> 送达人数，一般约等于总粉丝数（需排除黑名单或其他异常情况下无法收到消息的粉丝）</td></tr>
 *     <tr><td> user_source</td><td> 在获取图文阅读分时数据时才有该字段，代表用户从哪里进入来阅读该图文。0:会话;1.好友;2.朋友圈;3.腾讯微博;4.历史消息页;5.其他</td></tr>
 *</tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ArticleTotal extends BaseDataCube {

    @JSONField(name="msgid")
    private String msgid;
    @JSONField(name="title")
    private String title;
    @JSONField(name="details")
    private List<ArticleTotalDetail> details;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ArticleTotalDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ArticleTotalDetail> details) {
        this.details = details;
    }
}
