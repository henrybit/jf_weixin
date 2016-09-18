package com.github.jf.fastweixin.api.customservice;

import com.github.jf.fastweixin.api.BaseAPI;
import com.github.jf.fastweixin.entity.CustomAccount;
import com.github.jf.fastweixin.enums.ResultType;
import com.github.jf.fastweixin.response.GetCustomAccountsResponse;
import com.github.jf.fastweixin.exception.WeixinException;
import com.github.jf.fastweixin.entity.message.*;
import com.github.jf.fastweixin.util.BeanUtil;
import com.github.jf.fastweixin.config.ApiConfig;
import com.github.jf.fastweixin.response.BaseResponse;
import com.github.jf.fastweixin.util.JSONUtil;
import com.github.jf.fastweixin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息-客服相关API
 *
 * @author peiyu,henrybit
 * @since 1.2
 * @version 2.0
 */
public class CustomerServiceAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceAPI.class);

    public CustomerServiceAPI(ApiConfig config) {
        super(config);
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
        String url = BASE_API_URL + "customservice/kfaccount/add?access_token=#";
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
        String url = BASE_API_URL + "customservice/kfaccount/update?access_token=#";
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
        String url = BASE_API_URL + "customservice/kfaccount/del?access_token=#&kf_account=" + accountName;
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
        String url = BASE_API_URL + "customservice/kfaccount/uploadheadimg?access_token=#&kf_account=" + accountName;
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
        String url = BASE_API_URL + "cgi-bin/customservice/getkflist?access_token=#";
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.toBean(resultJson, GetCustomAccountsResponse.class);
        return response;
    }
}