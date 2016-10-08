package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.UserInfo;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 批量获取用户基本信息报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetUserInfoBatchResponse extends BaseResponse {
    @JSONField(name="user_info_list")
    private List<UserInfo> userInfoList;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
