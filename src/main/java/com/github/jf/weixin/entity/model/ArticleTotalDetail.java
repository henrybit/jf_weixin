package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

import java.util.Date;

/**
 * 文章的累积总量明细<br>
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
 * 每天对应的数值为该文章到该日为止的总量（而不是当日的量）
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class ArticleTotalDetail extends BaseModel {

    @JSONField(name="stat_date", format="yyyy-MM-dd")
    private Date statDate;
    @JSONField(name="target_user")
    private Integer targetUser;
    @JSONField(name="int_page_read_user")
    private Integer intPageReadUser;
    @JSONField(name="int_page_read_count")
    private Integer intPageReadCount;
    @JSONField(name="ori_page_read_user")
    private Integer oriPageReadUser;
    @JSONField(name="ori_page_read_count")
    private Integer oriPageReadCount;
    @JSONField(name="share_user")
    private Integer shareUser;
    @JSONField(name="share_count")
    private Integer shareCount;
    @JSONField(name="add_to_fav_user")
    private Integer addToFavUser;
    @JSONField(name="add_to_fav_count")
    private Integer addToFavCount;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Integer getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(Integer targetUser) {
        this.targetUser = targetUser;
    }

    public Integer getIntPageReadUser() {
        return intPageReadUser;
    }

    public void setIntPageReadUser(Integer intPageReadUser) {
        this.intPageReadUser = intPageReadUser;
    }

    public Integer getIntPageReadCount() {
        return intPageReadCount;
    }

    public void setIntPageReadCount(Integer intPageReadCount) {
        this.intPageReadCount = intPageReadCount;
    }

    public Integer getOriPageReadUser() {
        return oriPageReadUser;
    }

    public void setOriPageReadUser(Integer oriPageReadUser) {
        this.oriPageReadUser = oriPageReadUser;
    }

    public Integer getOriPageReadCount() {
        return oriPageReadCount;
    }

    public void setOriPageReadCount(Integer oriPageReadCount) {
        this.oriPageReadCount = oriPageReadCount;
    }

    public Integer getShareUser() {
        return shareUser;
    }

    public void setShareUser(Integer shareUser) {
        this.shareUser = shareUser;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getAddToFavUser() {
        return addToFavUser;
    }

    public void setAddToFavUser(Integer addToFavUser) {
        this.addToFavUser = addToFavUser;
    }

    public Integer getAddToFavCount() {
        return addToFavCount;
    }

    public void setAddToFavCount(Integer addToFavCount) {
        this.addToFavCount = addToFavCount;
    }
}
