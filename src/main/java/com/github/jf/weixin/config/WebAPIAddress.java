package com.github.jf.weixin.config;

/**
 * 网页授权相关API
 * Created by henrybit on 2017/3/16.
 * @version 2.0
 */
public class WebAPIAddress {
    public static final String BASE_API_URL = "https://open.weixin.qq.com/";

    /**网页授权-start*/
    //网页获取Code
    public static final String GET_CODE_API = BASE_API_URL+"connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    //网页Code转化为AccessToken
    public static final String CODE_TO_ACCESS_TOKEN_API = APIAddress.BASE_API_URL+"sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
    //刷新AccessToken
    public static final String REFRESH_ACCESS_TOKEN_API = APIAddress.BASE_API_URL+"sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    //获取用户基本信息（openId+accessToken）
    public static final String GET_USER_INFO_API = APIAddress.BASE_API_URL+"sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    //检验AccessToken是否有效
    public static final String VALID_ACCESS_TOKEN_API = APIAddress.BASE_API_URL+"sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
    /**网页授权-end*/
}
