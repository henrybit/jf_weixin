package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.ArticleSummary;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文群发每日数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetArticleSummaryResponse extends BaseResponse {
    @JSONField(name="list")
    private List<ArticleSummary> list;

    public List<ArticleSummary> getList() {
        return list;
    }

    public void setList(List<ArticleSummary> list) {
        this.list = list;
    }
}
