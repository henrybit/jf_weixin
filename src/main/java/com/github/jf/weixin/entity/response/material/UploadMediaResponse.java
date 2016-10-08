package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

import java.util.Date;

/**
 * 上传临时素材响应结果<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UploadMediaResponse extends BaseResponse {

    @JSONField(name="type")
    private String type;
    @JSONField(name = "media_id")
    private String mediaId;
    @JSONField(name = "created_at")
    private long createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
