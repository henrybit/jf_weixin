package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取模板列表返回对象<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:120px">参数</th><th>说明</th></tr>
 *     <tr><td> template_id</td><td> 模板ID</td></tr>
 *     <tr><td> title</td><td> 模板标题</td></tr>
 *     <tr><td> primary_industry</td><td> 模板所属行业的一级行业</td></tr>
 *     <tr><td> deputy_industry</td><td> 模板所属行业的二级行业</td></tr>
 *     <tr><td> content</td><td> 模板内容</td></tr>
 *     <tr><td> example</td><td> 模板示例</td></tr>
 * </tbody>
 * </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetTemplateListResponse extends BaseResponse {

    @JSONField(name="template_list")
    protected List<Template> templateList;

    public List<Template> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }

    public static class Template {
        @JSONField(name="template_id")
        protected String templateId;
        @JSONField(name="title")
        protected String title;
        @JSONField(name="primary_industry")
        protected String primaryIndustry;
        @JSONField(name="deputy_industry")
        protected String deputyIndustry;
        @JSONField(name="content")
        protected String content;
        @JSONField(name="example")
        protected String example;

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrimaryIndustry() {
            return primaryIndustry;
        }

        public void setPrimaryIndustry(String primaryIndustry) {
            this.primaryIndustry = primaryIndustry;
        }

        public String getDeputyIndustry() {
            return deputyIndustry;
        }

        public void setDeputyIndustry(String deputyIndustry) {
            this.deputyIndustry = deputyIndustry;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }
    }
}
