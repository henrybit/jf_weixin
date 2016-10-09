package com.github.jf.weixin.entity.model.other;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 图文菜单按钮<br>
 *
 *    "title": "MULTI_NEWS",
 *    "author": "JIMZHENG",
 *    "digest": "text",
 *    "show_cover": 0,
 *    "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0",
 *    "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd",
 *    "source_url": ""
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class NewsInfo {
    @JSONField(name="title")
    protected String title;
    @JSONField(name="author")
    protected String author;
    @JSONField(name="digest")
    protected String digest;
    @JSONField(name="show_cover")
    protected int showCover;
    @JSONField(name="cover_url")
    protected String coverUrl;
    @JSONField(name="content_url")
    protected String contentUrl;
    @JSONField(name="source_url")
    protected String sourceUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public int getShowCover() {
        return showCover;
    }

    public void setShowCover(int showCover) {
        this.showCover = showCover;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
