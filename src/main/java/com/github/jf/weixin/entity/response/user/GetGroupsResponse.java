package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Group;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.List;

/**
 * 查询所有分组返回报文<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
 * <tbody>
 *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
 *     <tr><td> groups</td><td> 公众平台分组信息列表</td></tr>
 *     <tr><td> id</td><td> 分组id，由微信分配</td></tr>
 *     <tr><td> name</td><td> 分组名字，UTF8编码</td></tr>
 *     <tr><td> count</td><td> 分组内用户数量</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 *
 */
public class GetGroupsResponse extends BaseResponse {

    @JSONField(name="groups")
    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
