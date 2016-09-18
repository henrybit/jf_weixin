package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.ArticleSummary;

import java.util.List;

/**
 * @author peiyu
 */
public class GetArticleSummaryResponse extends BaseResponse {

    private List<ArticleSummary> list;

    public List<ArticleSummary> getList() {
        return list;
    }

    public void setList(List<ArticleSummary> list) {
        this.list = list;
    }
}
