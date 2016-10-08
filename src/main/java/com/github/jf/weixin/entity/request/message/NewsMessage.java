package com.github.jf.weixin.entity.request.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.util.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 图文消息（点击跳转到外链）<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class NewsMessage extends BaseRequestMessage {
	@JSONField(name="articles")
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
    public static Article createArticle(String title, String picUrl, String url, String desciption) {
        return new Article(title, desciption, picUrl, url);
    }

    /**
     * 添加一个文章实体到NewsMessage对象中<br>
     * @param article 文章实体（通过createArticle方法创建）
     * @return int-返回该文章对应的位置信息
     */
    public int addArticle(Article article) {
        if (article == null) return -1;
        if (articles != null) {
            int size = articles.size();
            articles.add(article);
            return size;
        } else {
        	articles = new ArrayList<Article>();
        	articles.add(article);
            return 0;
        }
    }

    /**
     * 客服消息-图文消息中-文章实体<br>
     * @author peiyu
     * @since 1.3
     * @version 2.0
     */
    public static class Article {
    	@JSONField(name="title")
        private String title;
    	@JSONField(name="description")
        private String description;
    	@JSONField(name="picurl")
        private String picUrl;
    	@JSONField(name="url")
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

        public String toJson() {
            HashMap<String, Object> jsonMap = new HashMap<String, Object>();
            jsonMap.put("title", this.title);
            jsonMap.put("description", this.description);
            jsonMap.put("url", this.url);
            jsonMap.put("picurl", this.picUrl);
            return JSONUtil.toJson(jsonMap);
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("articles",this.articles);
        return JSONUtil.toJson(jsonMap);
    }

    public static void main(String[] args) {
        List<Article> articles = new ArrayList<Article>();
        for (int i=0; i<10; i++) {
            String title = i+"";
            String description = "说明";
            String picUrl = "http://www.baidu.com/1.png";
            String url = "http://www.baidu.com";
            Article article = new Article(title, description, picUrl, url);
            articles.add(article);
        }
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("articles",articles);
        String result = JSONUtil.toJson(jsonMap);

        System.out.println(result);
    }
}
