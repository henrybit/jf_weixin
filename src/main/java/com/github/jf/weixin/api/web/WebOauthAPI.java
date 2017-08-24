package com.github.jf.weixin.api.web;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.WebAPIAddress;
import com.github.jf.weixin.enums.OauthScope;
import com.github.jf.weixin.entity.response.OauthGetTokenResponse;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.user.GetUserInfoResponse;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * 网页授权相关API
 * @author henrybit
 * @version 1.0
 */
public class WebOauthAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(WebOauthAPI.class);

    public WebOauthAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 生成回调url，这个结果要求用户在微信中打开，即可获得token，并指向redirectUrl
     * @param redirectUrl 用户自己设置的回调地址
     * @param scope       授权作用域
     *                    应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
     *                    snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @param state       用户自带参数 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return 回调url，用户在微信中打开即可开始授权
     */
    public String getOauthPageUrl(String redirectUrl, OauthScope scope, String state) {
        BeanUtil.requireNonNull(redirectUrl, "redirectUrl is null");
        BeanUtil.requireNonNull(scope, "scope is null");
        String userState = StringUtil.isBlank(state) ? "STATE" : state;
        String url = null;
        try {
            url = URLEncoder.encode(redirectUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.error("异常", e);
        }
        String pageOauthurl = WebAPIAddress.GET_CODE_API.replace("APPID",this.config.getAppid()).
                replace("REDIRECT_URI",url).replace("SCOPE",scope.toString()).replace("STATE",userState);
        return pageOauthurl;
    }

    /**
     * 用户同意授权后在回调url中会得到code，调用此方法用code换token以及openid，所以如果仅仅是授权openid，到这步就结束了
     *
     * @param code 授权后得到的code
     * @return token对象
     */
    public OauthGetTokenResponse getToken(String code) {
        BeanUtil.requireNonNull(code, "code is null");
        OauthGetTokenResponse response = null;
        String url = WebAPIAddress.CODE_TO_ACCESS_TOKEN_API.replace("APPID",this.config.getAppid()).replace("APPSECRET",this.config.getSecret()).replace("CODE",code);
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, OauthGetTokenResponse.class);
        return response;
    }

    /**
     * 刷新token
     *
     * @param refreshToken token对象中会包含refreshToken字段，通过这个字段再次刷新token
     * @return 全新的token对象
     */
    public OauthGetTokenResponse refreshToken(String refreshToken) {
        BeanUtil.requireNonNull(refreshToken, "refreshToken is null");
        OauthGetTokenResponse response = null;
        String url = WebAPIAddress.REFRESH_ACCESS_TOKEN_API.replace("APPID",this.config.getAppid()).replace("REFRESH_TOKEN",refreshToken);
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, OauthGetTokenResponse.class);
        return response;
    }

    /**
     * 获取用户详细信息
     *
     * @param token  token
     * @param openid 用户openid
     * @return 用户信息对象
     */
    public GetUserInfoResponse getUserInfo(String token, String openid) {
        BeanUtil.requireNonNull(token, "token is null");
        BeanUtil.requireNonNull(openid, "openid is null");
        GetUserInfoResponse response = null;
        String url = WebAPIAddress.GET_USER_INFO_API.replace("ACCESS_TOKEN", token).replace("OPENID",openid);
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserInfoResponse.class);
        return response;
    }

    /**
     * 校验token是否合法有效
     *
     * @param token  token
     * @param openid 用户openid
     * @return 是否合法有效
     */
    public boolean validToken(String token, String openid) {
        BeanUtil.requireNonNull(token, "token is null");
        BeanUtil.requireNonNull(openid, "openid is null");
        String url = WebAPIAddress.VALID_ACCESS_TOKEN_API.replace("ACCESS_TOKEN",token).replace("OPENID",openid);
        BaseResponse r = executeGet(url);
        return isSuccess(r.getErrcode());
    }
}
