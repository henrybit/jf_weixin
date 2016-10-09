package com.github.jf.weixin.company.message;

import com.github.jf.weixin.util.JSONUtil;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class QYArticle {

    private String title;
    private String description;
    private String url;
    private String picurl;

    public QYArticle(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.picurl = picUrl;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String toXml() {
        return JSONUtil.toJson(this);
    }
}
