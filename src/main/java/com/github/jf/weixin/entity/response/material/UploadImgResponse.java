package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 上传图片返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UploadImgResponse extends BaseResponse {
    @JSONField(name="url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
