package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.other.NewsInfo;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.HashMap;
import java.util.List;

/**
 * 自动回复<br>
 * 范例<br>
 * <pre>{
 "is_add_friend_reply_open": 1,
 "is_autoreply_open": 1,
 "add_friend_autoreply_info": {
 "type": "text",
 "content": "Thanks for your attention!"
 },
 "message_default_autoreply_info": {
 "type": "text",
 "content": "Hello, this is autoreply!"
 },
 "keyword_autoreply_info": {
 "list": [
 {
 "rule_name": "autoreply-news",
 "create_time": 1423028166,
 "reply_mode": "reply_all",
 "keyword_list_info": [
 {
 "type": "text",
 "match_mode": "contain",
 "content": "news测试"//此处content即为关键词内容
 }
 ],
 "reply_list_info": [
 {
 "type": "news",
 "news_info": {
 "list": [
 {
 "title": "it's news",
 "author": "jim",
 "digest": "it's digest",
 "show_cover": 1,
 "cover_url": "<a href="http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0" class="external free" rel="nofollow" target="_blank">http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0</a>",
 "content_url": "<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=203929886&amp;idx=1&amp;sn=628f964cf0c6d84c026881b6959aea8b#rd" class="external free" rel="nofollow" target="_blank">http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=203929886&amp;idx=1&amp;sn=628f964cf0c6d84c026881b6959aea8b#rd</a>",
 "source_url": "<a href="http://www.url.com" class="external free" rel="nofollow" target="_blank">http://www.url.com</a>"
 }
 ]
 }
 },
 {
 "type": "news",
 "content":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o",
 "news_info": {
 "list": [
 {
 "title": "MULTI_NEWS",
 "author": "JIMZHENG",
 "digest": "text",
 "show_cover": 0,
 "cover_url": "<a href="http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0" class="external free" rel="nofollow" target="_blank">http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0</a>",
 "content_url": "<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=204013432&amp;idx=1&amp;sn=80ce6d9abcb832237bf86c87e50fda15#rd" class="external free" rel="nofollow" target="_blank">http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=204013432&amp;idx=1&amp;sn=80ce6d9abcb832237bf86c87e50fda15#rd</a>",
 "source_url": ""
 },
 {
 "title": "MULTI_NEWS4",
 "author": "JIMZHENG",
 "digest": "MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT",
 "show_cover": 1,
 "cover_url": "<a href="http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0" class="external free" rel="nofollow" target="_blank">http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0</a>",
 "content_url": "<a href="http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=204013432&amp;idx=5&amp;sn=b4ef73a915e7c2265e437096582774af#rd" class="external free" rel="nofollow" target="_blank">http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&amp;mid=204013432&amp;idx=5&amp;sn=b4ef73a915e7c2265e437096582774af#rd</a>",
 "source_url": ""
 }
 ]
 }
 }
 ]
 },
 {
 "rule_name": "autoreply-voice",
 "create_time": 1423027971,
 "reply_mode": "random_one",
 "keyword_list_info": [
 {
 "type": "text",
 "match_mode": "contain",
 "content": "voice测试"
 }
 ],
 "reply_list_info": [
 {
 "type": "voice",
 "content": "NESsxgHEvAcg3egJTtYj4uG1PTL6iPhratdWKDLAXYErhN6oEEfMdVyblWtBY5vp"
 }
 ]
 },
 {
 "rule_name": "autoreply-text",
 "create_time": 1423027926,
 "reply_mode": "random_one",
 "keyword_list_info": [
 {
 "type": "text",
 "match_mode": "contain",
 "content": "text测试"
 }
 ],
 "reply_list_info": [
 {
 "type": "text",
 "content": "hello!text!"
 }
 ]
 },
 {
 "rule_name": "autoreply-video",
 "create_time": 1423027801,
 "reply_mode": "random_one",
 "keyword_list_info": [
 {
 "type": "text",
 "match_mode": "equal",
 "content": "video测试"
 }
 ],
 "reply_list_info": [
 {
 "type": "video",
 "content": "<a href="http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&amp;sha=0&amp;save=1" class="external free" rel="nofollow" target="_blank">http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&amp;sha=0&amp;save=1</a>"
 }
 ]
 }
 ]
 }
 }
 </pre>
 *
 * <p><b>参数说明</b></p>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> is_add_friend_reply_open</td><td> 关注后自动回复是否开启，0代表未开启，1代表开启</td></tr>
 *     <tr><td> is_autoreply_open</td><td> 消息自动回复是否开启，0代表未开启，1代表开启</td></tr>
 *     <tr><td> add_friend_autoreply_info</td><td> 关注后自动回复的信息</td></tr>
 *     <tr><td> type</td><td> 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news）</td></tr>
 *     <tr><td> content</td><td> 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID</td></tr>
 *     <tr><td> message_default_autoreply_info</td><td> 消息自动回复的信息</td></tr>
 *     <tr><td> keyword_autoreply_info</td><td> 关键词自动回复的信息</td></tr>
 *     <tr><td> rule_name</td><td> 规则名称</td></tr>
 *     <tr><td> create_time</td><td> 创建时间</td></tr>
 *     <tr><td> reply_mode</td><td> 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条</td></tr>
 *     <tr><td> keyword_list_info</td><td> 匹配的关键词列表</td></tr>
 *     <tr><td> match_mode</td><td> 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同</td></tr>
 *     <tr><td> news_info</td><td> 图文消息的信息</td></tr>
 *     <tr><td> title</td><td> 图文消息的标题</td></tr>
 *     <tr><td> digest</td><td> 摘要</td></tr>
 *     <tr><td> author</td><td> 作者</td></tr>
 *     <tr><td> show_cover</td><td> 是否显示封面，0为不显示，1为显示</td></tr>
 *     <tr><td> cover_url</td><td> 封面图片的URL</td></tr>
 *     <tr><td> content_url</td><td> 正文的URL</td></tr>
 *     <tr><td> source_url</td><td> 原文的URL，若置空则无查看原文入口</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetAutoReplyResponse extends BaseResponse{

    @JSONField(name="is_add_friend_reply_open")
    protected int isAddFriendReplyOpen;
    @JSONField(name="is_autoreply_open")
    protected int isAutoreplyOpen;
    @JSONField(name="add_friend_autoreply_info")
    protected AutoReplyInfo addFriendAutoreplyInfo;
    @JSONField(name="message_default_autoreply_info")
    protected AutoReplyInfo messageDefaultAutoreplyInfo;
    @JSONField(name="keyword_autoreply_info")
    protected AutoReplyInfo keywordAutoreplyInfo;


    public int getIsAddFriendReplyOpen() {
        return isAddFriendReplyOpen;
    }

    public void setIsAddFriendReplyOpen(int isAddFriendReplyOpen) {
        this.isAddFriendReplyOpen = isAddFriendReplyOpen;
    }

    public int getIsAutoreplyOpen() {
        return isAutoreplyOpen;
    }

    public void setIsAutoreplyOpen(int isAutoreplyOpen) {
        this.isAutoreplyOpen = isAutoreplyOpen;
    }

    public AutoReplyInfo getAddFriendAutoreplyInfo() {
        return addFriendAutoreplyInfo;
    }

    public void setAddFriendAutoreplyInfo(AutoReplyInfo addFriendAutoreplyInfo) {
        this.addFriendAutoreplyInfo = addFriendAutoreplyInfo;
    }

    public AutoReplyInfo getMessageDefaultAutoreplyInfo() {
        return messageDefaultAutoreplyInfo;
    }

    public void setMessageDefaultAutoreplyInfo(AutoReplyInfo messageDefaultAutoreplyInfo) {
        this.messageDefaultAutoreplyInfo = messageDefaultAutoreplyInfo;
    }

    public AutoReplyInfo getKeywordAutoreplyInfo() {
        return keywordAutoreplyInfo;
    }

    public void setKeywordAutoreplyInfo(AutoReplyInfo keywordAutoreplyInfo) {
        this.keywordAutoreplyInfo = keywordAutoreplyInfo;
    }

    public static class AutoReplyInfo {
        @JSONField(name="type")
        protected String type;
        @JSONField(name="content")
        protected String content;
        @JSONField(name="list")
        protected List list;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List getList() {
            return list;
        }

        public void setList(List list) {
            this.list = list;
        }
    }

    public static class ReplyRule {
        @JSONField(name="rule_name")
        protected String ruleName;
        @JSONField(name="create_time")
        protected long createTime;
        @JSONField(name="reply_mode")
        protected String replyMode;
        @JSONField(name="keyword_list_info")
        protected List<KeywordsRule> keywordListInfo;
        @JSONField(name="reply_list_info")
        protected List<NewsInfo> replyListInfo;

        public String getRuleName() {
            return ruleName;
        }

        public void setRuleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getReplyMode() {
            return replyMode;
        }

        public void setReplyMode(String replyMode) {
            this.replyMode = replyMode;
        }

        public List<KeywordsRule> getKeywordListInfo() {
            return keywordListInfo;
        }

        public void setKeywordListInfo(List<KeywordsRule> keywordListInfo) {
            this.keywordListInfo = keywordListInfo;
        }

        public List<NewsInfo> getReplyListInfo() {
            return replyListInfo;
        }

        public void setReplyListInfo(List<NewsInfo> replyListInfo) {
            this.replyListInfo = replyListInfo;
        }
    }

}
