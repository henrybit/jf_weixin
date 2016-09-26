package com.github.jf.weixin.api.authorize;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.request.AccessTokenRequest;
import com.github.jf.weixin.entity.response.AccessTokenResponse;
import com.github.jf.weixin.entity.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Token获取API<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class TokenAPI extends BaseAPI{

    /** private static start **/
    private static final Logger LOG = LoggerFactory.getLogger(TokenAPI.class);
    /** private static end **/

    public TokenAPI(ApiConfig config) {
        super(config);
    }


    /**
     * 获取accessToken信息<br>
     * 当获取失败时,返回null.
     * @param accessTokenRequest
     * @return AccessTokenResponse
     */
    public AccessTokenResponse getAccessToken(AccessTokenRequest accessTokenRequest) {
        LOG.debug("获取AccessToken......");
        try {
            String url = APIAddress.TOKEN_API.replace("APPID", accessTokenRequest.getAppid()).replace("APPSECRET", accessTokenRequest.getSecret());
            AccessTokenResponse response = (AccessTokenResponse) executePost(url, null);
            return response;
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

}
