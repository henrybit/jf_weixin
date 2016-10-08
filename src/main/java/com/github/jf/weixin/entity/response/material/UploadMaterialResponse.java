package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 上传永久素材响应结果<br>
 *  @author henrybit
 *  @since 2.0
 *  @version 2.0
 */
public class UploadMaterialResponse extends BaseResponse {

    @JSONField(name="media_id")
    private String mediaId;
    @JSONField(name="url")
    protected String url;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
