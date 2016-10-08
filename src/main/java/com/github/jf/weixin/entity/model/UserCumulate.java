package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseDataCube;

/**
 * 累计用户数据<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> ref_date</td><td> 数据的日期</td></tr>
 *     <tr><td> user_source</td><td> 用户的渠道，数值代表的含义如下：<p>0代表其他合计 1代表公众号搜索 17代表名片分享 30代表扫描二维码 43代表图文页右上角菜单 51代表支付后关注（在支付完成页）57代表图文页内公众号名称 75代表公众号文章广告 78代表朋友圈广告</p></td></tr>
 *     <tr><td> new_user</td><td> 新增的用户数量</td></tr>
 *     <tr><td> cancel_user</td><td> 取消关注的用户数量，new_user减去cancel_user即为净增用户数量</td></tr>
 *     <tr><td> cumulate_user</td><td> 总用户量</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UserCumulate extends BaseDataCube {

    @JSONField(name="cumulate_user")
    private Integer cumulateUser;

    public Integer getCumulateUser() {
        return cumulateUser;
    }

    public void setCumulateUser(Integer cumulateUser) {
        this.cumulateUser = cumulateUser;
    }
}
