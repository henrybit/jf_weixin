package com.github.jf.fastweixin.response;

import com.github.jf.fastweixin.entity.UserShareHour;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserShareHourResponse extends BaseResponse {

    private List<UserShareHour> list;

    public List<UserShareHour> getList() {
        return list;
    }

    public void setList(List<UserShareHour> list) {
        this.list = list;
    }
}
