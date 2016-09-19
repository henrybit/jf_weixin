package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.CustomAccount;

import java.util.List;

/**
 * @author peiyu
 */
public class GetCustomAccountsResponse extends BaseResponse {

    @JSONField(name = "kf_list")
    private List<CustomAccount> customAccountList;

    public List<CustomAccount> getCustomAccountList() {
        return customAccountList;
    }

    public void setCustomAccountList(List<CustomAccount> customAccountList) {
        this.customAccountList = customAccountList;
    }
}
