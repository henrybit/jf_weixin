package com.github.jf.weixin.api.customservice;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.entity.model.CustomAccount;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.entity.response.customerservice.GetCustomAccountsResponse;
import com.github.jf.weixin.exception.WeixinException;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息-客服相关API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>1.1 添加客服帐号:https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN</li>
 *     <li>1.2 修改客服帐号:https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN</li>
 *     <li>1.3 删除客服帐号:https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN</li>
 *     <li>1.4 设置客服帐号的头像:http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT</li>
 *     <li>1.5 获取所有客服账号:https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CustomerServiceAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceAPI.class);

    public CustomerServiceAPI(ApiConfig config) {
        super(config);
    }

    public CustomerServiceAPI(String accessToken) {
        super(accessToken);
    }

    /**
     * 添加客服帐号
     *
     * @param customAccount 客服对象
     * @return 添加结果
     */
    public ResultType addCustomAccount(CustomAccount customAccount) {
        LOG.debug("添加客服帐号.....");
        BeanUtil.requireNonNull(customAccount.getAccountName(), "帐号必填");
        BeanUtil.requireNonNull(customAccount.getNickName(), "昵称必填");
        String url = APIAddress.ADD_CUSTOMER_SERVER_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("kf_account", customAccount.getAccountName());
        params.put("nickname", customAccount.getNickName());
        if (StringUtil.isNotBlank(customAccount.getPassword())) {
            params.put("password", customAccount.getPassword());
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 修改客服帐号信息
     *
     * @param customAccount 客服帐号信息
     * @return 修改结果
     */
    public ResultType updateCustomAccount(CustomAccount customAccount) {
        LOG.debug("修改客服帐号信息......");
        BeanUtil.requireNonNull(customAccount.getAccountName(), "帐号必填");
        BeanUtil.requireNonNull(customAccount.getNickName(), "昵称必填");
        String url = APIAddress.UPDATE_CUSTOMER_SERVER_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("kf_account", customAccount.getAccountName());
        params.put("nickname", customAccount.getNickName());
        if (StringUtil.isNotBlank(customAccount.getPassword())) {
            params.put("password", customAccount.getPassword());
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 删除客服帐号
     * @param accountName 客服帐号名
     * @return 删除结果
     */
    public ResultType deleteCustomAccount(String accountName) {
        LOG.debug("删除客服帐号信息......");
        //String url = BASE_API_URL + "customservice/kfaccount/del?access_token=#&kf_account=" + accountName;
        String url = APIAddress.DELETE_CUSTOMER_SERVER_API;
        //TODO
        BaseResponse response = executePost(url, null);
        return ResultType.get(response.getErrcode());
    }

    /**
     * 设置客服帐号头像
     *
     * @param accountName 客服帐号名
     * @param file        头像文件
     * @return 设置结果
     */
    public ResultType uploadHeadImg(String accountName, File file) {
        LOG.debug("设置客服帐号头像.....");
        BeanUtil.requireNonNull(accountName, "帐号必填");
        BeanUtil.requireNonNull(file, "文件为空");

        String fileName = file.getName().toLowerCase();
        if (!fileName.endsWith("jpg")) {
            throw new WeixinException("头像必须是jpg格式");
        }
        String url = APIAddress.UPDATE_CUSTOMER_HEADER_API.replace("KFACCOUNT", accountName);
        BaseResponse response = executePost(url, null, file);
        return ResultType.get(response.getErrcode());
    }

    /**
     * 获取所有客服帐号信息
     * @return 所有客服帐号信息对象
     */
    public GetCustomAccountsResponse getCustomAccountList() {
        LOG.debug("获取所有客服帐号信息....");
        GetCustomAccountsResponse response;
        //String url = BASE_API_URL + "cgi-bin/customservice/getkflist?access_token=#";
        String url = APIAddress.GET_CUSTOMER_SERVER_LIST_API;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetCustomAccountsResponse.class);
        return response;
    }
}
