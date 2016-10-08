package com.github.jf.weixin.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
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
 * 系统API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>微信服务器IP地址列表:https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN</li>
 *     <li></li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SystemAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(SystemAPI.class);

    public SystemAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 获取微信服务器IP地址列表<br>
     * @return List-IP地址列表
     */
    public List<String> getCallbackIP() {
        LOG.debug("获取微信服务器IP地址......");
        List<String> result = null;
        String url= APIAddress.IP_LIST_API;
        BaseResponse r = executeGet(url);
        if (isSuccess(r.getErrcode())) {
            JSONArray array = JSON.parseObject(r.getErrmsg()).getJSONArray("ip_list");
            result = CollectionUtil.newArrayList(array.size());
            for (Object obj : array) result.add(obj.toString());
        }
        return result;
    }

    /**
     * 将一条长链接转成短链接
     * @deprecated 使用UrlAPI
     * @param longUrl 长链接
     * @return String-对应的短链接
     */
    @Deprecated
    public String getShortUrl(String longUrl) {
        String result = "";
        LOG.debug("获取短URL.......");
        if (checkUrl(longUrl)) {
            String url = APIAddress.SHORT_URL_TRANSFORM_API;
            Map<String, String> params = new HashMap<String, String>();
            params.put("action", "long2short");
            params.put("long_url", longUrl);
            BaseResponse r = executePost(url, JSONUtil.toJson(params));
            if (isSuccess(r.getErrcode())) {
                result = JSONUtil.toMap(r.getErrmsg()).get("short_url").toString();
            }
        }
        return result;
    }

    /**
     * 检查URL是否支持
     *
     * @param url 需要检查的URL
     * @return boolean-是否支持
     */
    private boolean checkUrl(String url) {
        return StringUtil.isNotBlank(url) && (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("weixin://wxpay"));
    }
}
