package com.github.jf.weixin.entity.response.customerservice;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.CustomAccount;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 获取客服账号报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetCustomAccountsResponse extends BaseResponse {

    @JSONField(name="kf_list")
    private List<CustomAccount> customAccountList;

    public List<CustomAccount> getCustomAccountList() {
        return customAccountList;
    }

    public void setCustomAccountList(List<CustomAccount> customAccountList) {
        this.customAccountList = customAccountList;
    }
}
