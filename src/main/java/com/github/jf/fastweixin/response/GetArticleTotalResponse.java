package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.ArticleTotal;

import java.util.List;

/**
 * @author peiyu
 */
public class GetArticleTotalResponse extends BaseResponse {

    private List<ArticleTotal> list;

    public List<ArticleTotal> getList() {
        return list;
    }

    public void setList(List<ArticleTotal> list) {
        this.list = list;
    }
}
