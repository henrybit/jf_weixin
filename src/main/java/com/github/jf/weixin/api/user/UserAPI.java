package com.github.jf.weixin.api.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jf.weixin.entity.response.user.GetUserListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.request.user.UserInfoRequest;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.user.CreateGroupResponse;
import com.github.jf.weixin.entity.response.user.GetGroupsResponse;
import com.github.jf.weixin.entity.response.user.GetUserInfoBatchResponse;
import com.github.jf.weixin.entity.response.user.GetUserInfoResponse;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.exception.WeixinException;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.CollectionUtil;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.StringUtil;

/**
 * 用户管理相关API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>创建分组(createGroup):https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN</li>
 *     <li>查询所有分组(getGroups):https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN</li>
 *     <li>查询用户所在分组(getGroupIdByOpenid):https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN</li>
 *     <li>修改分组名(updateGroup):https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN</li>
 *     <li>移动用户分组(moveGroupUser):https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN</li>
 *     <li>批量移动用户分组(moveGroupUser):https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=ACCESS_TOKEN</li>
 *     <li>删除分组(deleteGroup):https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=ACCESS_TOKEN</li>
 *     <li>设置备注名(setUserRemark):https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN</li>
 *     <li>获取用户基本信息-包括UnionID机制(getUserInfo):https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN</li>
 *     <li>批量获取用户基本信息(getUserInfoBatch):https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN</li>
 *     <li>获取用户列表(getUserList):https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UserAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);

    public UserAPI(ApiConfig config) {
        super(config);
    }

    public UserAPI(String accessToken) {
        super(accessToken);
    }

    /**
     * 获取关注者列表<br>
     * @param nextOpenid 下一个用户的ID(第一个拉取的OPENID，不填默认从头开始拉取)
     * @return GetUserListResponse-关注者列表对象
     */
    public GetUserListResponse getUserList(String nextOpenid) {
        GetUserListResponse response;
        LOG.debug("获取关注者列表.....");
        String url = APIAddress.GET_USER_LIST_API;
        if (StringUtil.isNotBlank(nextOpenid)) {
            url += "&next_openid=" + nextOpenid;
        }
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserListResponse.class);
        return response;
    }

    /**
     * 设置关注者备注<br>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
     *     <tr><td> access_token</td><td> 调用接口凭证</td></tr>
     *     <tr><td> openid</td><td> 用户标识</td></tr>
     *     <tr><td> remark</td><td> 新的备注名，长度必须小于30字符</td></tr>
     * </tbody></table>
     * @param openid 关注者ID
     * @param remark 备注内容
     * @return ResultType-调用结果
     */
    public ResultType setUserRemark(String openid, String remark) {
        BeanUtil.requireNonNull(openid, "openid is null");
        LOG.debug("设置关注者备注.....");
        String url = APIAddress.UPDATE_USER_REMARK_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("openid", openid);
        param.put("remark", remark);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 创建分组<br>
     * <pre>
     *  一个公众账号，最多支持创建100个分组。
     * </pre>
     * @param name 分组名称
     * @return 返回对象，包含分组的ID和名称信息
     */
    public CreateGroupResponse createGroup(String name) {
        CreateGroupResponse response;
        BeanUtil.requireNonNull(name, "name is null");
        LOG.debug("创建分组.....");
        String url = APIAddress.CREATE_GROUP_API;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> group = new HashMap<String, Object>();
        group.put("name", name);
        param.put("group", group);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, CreateGroupResponse.class);
        return response;
    }

    /**
     * 获取所有分组信息<br>
     * @return 所有分组信息列表对象
     */
    public GetGroupsResponse getGroups() {
        GetGroupsResponse response;
        LOG.debug("获取所有分组信息.....");
        String url = APIAddress.QUERY_GROUP_LIST_API;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetGroupsResponse.class);
        return response;
    }

    /**
     * 通过关注者ID获取所在分组信息<br>
     * @param openid 关注者ID
     * @return String-所在分组信息
     */
    public String getGroupIdByOpenid(String openid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        LOG.debug("通过关注者ID获取所在分组信息.....");
        String result = null;
        String url = APIAddress.QUERY_USER_GROUP_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("openid", openid);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        if (isSuccess(r.getErrcode())) {
            result = JSONUtil.toMap(r.getErrmsg()).get("groupid").toString();
        }
        return result;
    }

    /**
     * 修改分组信息<br>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
     *     <tr><td> access_token</td><td> 调用接口凭证</td></tr>
     *     <tr><td> id</td><td> 分组id，由微信分配</td></tr>
     *     <tr><td> name</td><td> 分组名字（30个字符以内）</td></tr>
     * </tbody></table>
     * @param groupid 分组ID
     * @param name    新名称
     * @return 调用结果
     */
    public ResultType updateGroup(Integer groupid, String name) {
        BeanUtil.requireNonNull(groupid, "groupid is null");
        BeanUtil.requireNonNull(name, "name is null");
        LOG.debug("修改分组信息.....");
        String url = APIAddress.UPDATE_GROUP_NAME_API;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> group = new HashMap<String, Object>();
        group.put("id", groupid);
        group.put("name", name);
        param.put("group", group);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 移动关注者所在分组<br>
     * @param openid    关注者ID
     * @param toGroupid 新分组ID
     * @return 调用结果
     */
    public ResultType moveGroupUser(String openid, String toGroupid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        BeanUtil.requireNonNull(toGroupid, "toGroupid is null");
        LOG.debug("移动关注者所在分组.....");
        //String url = BASE_API_URL + "cgi-bin/groups/members/update?access_token=#";
        String url = APIAddress.UPDATE_GROUP_USER_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid", openid);
        param.put("to_groupid", toGroupid);

        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 移动关注者所在分组<br>
     * @param openids    关注者ID
     * @param toGroupid 新分组ID
     * @return 调用结果
     */
    public ResultType moveGroupUser(String[] openids, String toGroupid) {
        BeanUtil.requireNonNull(openids, "openid is null");
        BeanUtil.requireNonNull(toGroupid, "toGroupid is null");
        LOG.debug("移动关注者所在分组.....");
        String url = APIAddress.BATCH_MOVE_GROUP_USER_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid_list", openids);
        param.put("to_groupid", toGroupid);

        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取关注者信息<br>
     * @param openid 关注者ID
     * @return 关注者信息对象
     */
    public GetUserInfoResponse getUserInfo(String openid) {
        BeanUtil.requireNonNull(openid, "openid is null");
        GetUserInfoResponse response;
        LOG.debug("获取关注者信息.....");
        String url = APIAddress.GET_USER_INFO_API;
        try {
            BaseResponse r = executeGet(url);
            String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
            response = JSONUtil.parse(resultJson, GetUserInfoResponse.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *批量获取关注者信息<br>
     * @param userInfoList 关注者ID列表
     * @return 关注者信息对象列表
     */
    public GetUserInfoBatchResponse getUserInfoBatch(List<UserInfoRequest> userInfoList){
        String url = APIAddress.BATCH_GET_USER_INFO_API;
        Map<String, List<UserInfoRequest>> param = new HashMap<String, List<UserInfoRequest>>();
        try {
            param.put("user_list", userInfoList);
            BaseResponse r = executePost(url, JSONUtil.toJson(param));
            String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
            GetUserInfoBatchResponse getUserInfoListResponse = JSONUtil.parse(resultJson, GetUserInfoBatchResponse.class);
            return getUserInfoListResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除分组<br>
     * @param groupId 分组ID
     * @return 删除结果
     */
    public ResultType deleteGroup(Integer groupId){
        BeanUtil.requireNonNull(groupId, "groupId is null");
        LOG.debug("删除分组.....");
        //String url = BASE_API_URL + "cgi-bin/groups/delete?access_token=#";
        String url = APIAddress.DELETE_GROUP_API;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Integer> groups = new HashMap<String, Integer>();
        groups.put("id", groupId);
        param.put("group", groups);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }
}