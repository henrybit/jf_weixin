package com.github.jf.weixin.api.user;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.entity.response.user.*;
import com.github.jf.weixin.exception.WeixinException;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.util.CollectionUtil;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标签相关API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>创建标签(create):https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN</li>
 *     <li>获取已经创建的标签(getAllTags):https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN</li>
 *     <li>编辑标签(updateTag):https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN</li>
 *     <li>删除标签(deleteTag):https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN</li>
 *     <li>获取标签下粉丝列表(getUsersByTagId):https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN</li>
 *     <li>批量为用户打标签(batchTagsToUser):https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN</li>
 *     <li>批量为用户取消标签(batchUnTagsToUser):https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN</li>
 *     <li>获取用户身上的标签列表(getUserTags):https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TagAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(TagAPI.class);

    /**
     * 构造方法，设置apiConfig
     *
     * @param config 微信API配置对象
     */
    public TagAPI(ApiConfig config) {
        super(config);
    }

    public TagAPI(String accessToken) {
        super(accessToken);
    }

    /**
     * 创建标签<br>
     * <pre>一个公众号，最多可以创建100个标签</pre>
     * @param tagName 标签名称
     * @return CreateTagResponse-创建的标签结果
     */
    public CreateTagResponse create(String tagName) {
        BeanUtil.requireNonNull(tagName, "tagName is null");
        CreateTagResponse response;
        LOG.debug("创建标签.....");
        String url = APIAddress.CREATE_TAG_API;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> tag = new HashMap<String, Object>();
        tag.put("name", tagName);
        param.put("tag", tag);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, CreateTagResponse.class);
        return response;
    }

    /**
     * 获取已经创建的标签<br>
     * @return GetAllTagsResponse-已经创建的标签列表
     */
    public GetAllTagsResponse getAllTags() {
        GetAllTagsResponse response;
        LOG.debug("获取已经创建的标签.....");
        String url = APIAddress.GET_TAG_LIST_API;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetAllTagsResponse.class);
        return response;
    }

    /**
     * 编辑标签<br>
     * @param tagId 标签ID
     * @param newTagName 新的标签名称
     * @return 编辑结果
     */
    public ResultType updateTag(Integer tagId, String newTagName) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        BeanUtil.requireNonNull(newTagName, "newTagName is null");
        LOG.debug("编辑标签.....");
        String url = APIAddress.UPDATE_TAG_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", tagId);
        param.put("name", newTagName);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 删除标签<br>
     * @param tagId 需要删除的标签ID
     * @return 删除结果
     */
    public ResultType deleteTag(Integer tagId) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        LOG.debug("删除标签.....");
        String url = APIAddress.DELETE_TAG_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", tagId);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取标签下粉丝<br>
     * @param tagId 标签ID
     * @param nextOpenid 下一个用户的openid,第一次不用填
     * @return 本批用户列表
     */
    public GetFansListResponse getUsersByTagId(Integer tagId, String nextOpenid) {
        BeanUtil.requireNonNull(tagId, "tagId is null");
        GetFansListResponse response;
        LOG.debug("开始获取标签下粉丝.....");
        String url = APIAddress.GET_TAG_FANS_LIST_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tagid", tagId);
        param.put("next_openid", null == nextOpenid ? "" : nextOpenid);
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetFansListResponse.class);
        return response;
    }

    /**
     * 批量为用户打上标签<br>
     * 标签功能目前支持公众号为用户打上最多三个标签。
     * @param openidList 用户openid列表
     * @param tagId 标签ID
     * @return 结果
     */
    public ResultType batchTagsToUser(List<String> openidList, Integer tagId) throws Exception{
        BeanUtil.requireNonNull(tagId, "tagId is null");
        if(CollectionUtil.isEmpty(openidList)) {
            throw new WeixinException("openId列表为空");
        }
        LOG.debug("批量为用户打上标签.....");
        String url = APIAddress.BATCH_TAGGIN_USER_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid_list", openidList);
        param.put("tagid", tagId);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 批量为用户取消标签<br>
     * @param openidList 用户openid列表
     * @param tagId 标签ID
     * @return 结果
     */
    public ResultType batchUnTagsToUser(List<String> openidList, Integer tagId) throws Exception{
        BeanUtil.requireNonNull(tagId, "tagId is null");
        if(CollectionUtil.isEmpty(openidList)) {
            throw new WeixinException("openId列表为空");
        }
        LOG.debug("批量为用户取消标签.....");
        String url = APIAddress.BATCH_UNTAGGIN_USER_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid_list", openidList);
        param.put("tagid", tagId);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取用户身上的标签列表<br>
     * @param openid
     * @return GetUserTagsResponse-用户标签集合
     */
    public GetUserTagsResponse getUserTags(String openid) throws Exception{
        if (StringUtil.isBlank(openid))
            throw new WeixinException("openid不能为空");
        String url = APIAddress.GET_USER_TAGS_API;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("openid", openid);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return (GetUserTagsResponse)response;
    }
}
