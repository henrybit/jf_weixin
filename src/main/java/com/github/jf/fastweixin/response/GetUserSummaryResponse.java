package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.UserSummary;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserSummaryResponse extends BaseResponse {

    private List<UserSummary> list;

    public List<UserSummary> getList() {
        return list;
    }

    public void setList(List<UserSummary> list) {
        this.list = list;
    }
}
