package com.github.jf.weixin.api.account;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.account.TransformUrlResponse;
import com.github.jf.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 微信URL的相关API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>长链接转短链接接口:https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UrlAPI extends BaseAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UrlAPI.class);

    public UrlAPI(ApiConfig config) {
        super(config);
    }


    /**
     * 长链接转短链接<br>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
     *     <tr><td> access_token</td><td> 是</td><td> 调用接口凭证</td></tr>
     *     <tr><td> long_url</td><td> 是</td><td> 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url</td></tr>
     * </tbody></table>
     * @param longUrl
     * @return TransformUrlResponse-转换结果
     */
    public TransformUrlResponse transformUrl(String longUrl) {
        return transformUrl(longUrl, "long2short");
    }

    /**
     * 长链接转短链接<br>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
     *     <tr><td> access_token</td><td> 是</td><td> 调用接口凭证</td></tr>
     *     <tr><td> action</td><td> 是</td><td> 此处填long2short，代表长链接转短链接</td></tr>
     *     <tr><td> long_url</td><td> 是</td><td> 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url</td></tr>
     * </tbody></table>
     * @param longUrl 长链接地址
     * @param action 转换动作
     * @return TransformUrlResponse-转换结果
     */
    public TransformUrlResponse transformUrl(String longUrl, String action) {
        String url = APIAddress.SHORT_URL_TRANSFORM_API;
        HashMap<String, Object> params = new HashMap<String, Object>();
        try {
            params.put("long_url", longUrl);
            params.put("action", action);
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return (TransformUrlResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
