package com.github.jf.weixin.company.message;

import com.github.jf.weixin.entity.model.Article;

/**
 *  
 *  ====================================================================
 *  上海聚攒软件开发有限公司
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class QYMpArticle extends Article {

    public QYMpArticle(String thumbMediaId, String author, String title, String contentSourceUrl, String content, String digest, Integer showConverPic) {
        super(thumbMediaId, author, title, contentSourceUrl, content, digest, showConverPic);
    }

}
