package com.github.jf.weixin.entity.message.request;

import java.util.List;

/**
 * 图文消息（点击跳转到外链）<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class NewsMessage {
    protected List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    /**
     * 创建一个Article实体<br>
     * @param title 文章标题
     * @param picUrl 文章图片地址
     * @param url 文章链接地址
     * @param desciption 文章描述
     * @return Article
     */
    protected Article createArticle(String title, String picUrl, String url, String desciption) {
        return new Article(title, picUrl, url, desciption);
    }

    /**
     * 客服消息-图文消息中-文章实体<br>
     * @author peiyu
     * @since 1.3
     * @version 2.0
     */
    public class Article {

        private String title;
        private String description;
        private String picUrl;
        private String url;

        public Article() {

        }

        public Article(String title) {
            this.title = title;
        }

        public Article(String title, String url) {
            this.title = title;
            this.url = url;
        }

        public Article(String title, String description, String picUrl, String url) {
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

//        public String toXml() {
//            MessageBuilder mb = new MessageBuilder();
//            mb.addData("Title", title);
//            mb.addData("Description", description);
//            mb.addData("PicUrl", picUrl);
//            mb.addData("Url", url);
//            mb.surroundWith("item");
//            return mb.toString();
//        }

    }
}
