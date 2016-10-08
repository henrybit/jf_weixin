package com.github.jf.weixin.entity.response.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Industry;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 获取行业设置的返回值<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 *    <tbody>
 *       <tr><th style="width:120px">参数</th><th>说明</th></tr>
 *       <tr><td> primary_industry</td><td> 帐号设置的主营行业</td></tr>
 *       <tr><td> secondary_industry</td><td> 帐号设置的副营行业</td></tr>
 *    </tbody>
 * </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetIndustrySettingResponse extends BaseResponse {
    @JSONField(name="primary_industry")
    protected Industry primaryIndustry;
    @JSONField(name="secondary_industry")
    protected Industry secondaryIndustry;

    public Industry getPrimaryIndustry() {
        return primaryIndustry;
    }

    public void setPrimaryIndustry(Industry primaryIndustry) {
        this.primaryIndustry = primaryIndustry;
    }

    public Industry getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(Industry secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }
}
