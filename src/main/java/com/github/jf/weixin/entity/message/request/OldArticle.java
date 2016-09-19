package com.github.jf.weixin.entity.message.request;

import com.github.jf.weixin.util.MessageBuilder;

/**
 * 客服消息-图文消息中-文章实体<br>
 * @author peiyu
 * @since 1.3
 * @version 2.0
 */
public class OldArticle {

    private String title;
    private String description;
    private String picUrl;
    private String url;

    public OldArticle() {

    }

    public OldArticle(String title) {
        this.title = title;
    }

    public OldArticle(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public OldArticle(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toXml() {
        MessageBuilder mb = new MessageBuilder();
        mb.addData("Title", title);
        mb.addData("Description", description);
        mb.addData("PicUrl", picUrl);
        mb.addData("Url", url);
        mb.surroundWith("item");
        return mb.toString();
    }

}
