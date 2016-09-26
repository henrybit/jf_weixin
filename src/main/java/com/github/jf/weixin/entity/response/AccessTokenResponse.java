package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取AccessToken的返回结果<br>
 * <ul>
 *     <label>范例</label>
 *     <li>
 *         成功<br>
 *         {@code
 *         {"access_token":"ACCESS_TOKEN","expires_in":7200}
 *         }
 *     </li>
 *     <li>
 *         失败<br>
 *         {@code
 *         {"errcode":40013,"errmsg":"invalid appid"}
 *         }
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class AccessTokenResponse extends BaseResponse{
    @JSONField(name="access_token")
    private String accessToken;
    @JSONField(name="expires_in")
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
