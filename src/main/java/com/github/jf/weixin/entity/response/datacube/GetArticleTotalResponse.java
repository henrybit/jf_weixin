package com.github.jf.weixin.entity.response.datacube;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.ArticleTotal;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 图文群发总数据报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetArticleTotalResponse extends BaseResponse {
    @JSONField(name="list")
    private List<ArticleTotal> list;

    public List<ArticleTotal> getList() {
        return list;
    }

    public void setList(List<ArticleTotal> list) {
        this.list = list;
    }
}
