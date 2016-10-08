package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 上传视频响应Body<br>
 * <pre>
 * 返回结果:
 * {"type":"video","media_id":"IhdaAQXuvJtGzwwc0abfXnzeezfO0NgPK6AQYShD8RQYMTtfzbLdBIQkQziv2XJc","created_at":1398848981}
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UploadVideoResponse extends BaseResponse{
    @JSONField(name="type")
    protected String type;
    @JSONField(name="media_id")
    protected String mediaId;
    @JSONField(name="created_at")
    protected long createdAt;

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
