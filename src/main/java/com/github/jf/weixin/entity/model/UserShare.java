package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseDataCube;

/**
 * 图文分享转发数据<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class UserShare extends BaseDataCube {

    @JSONField(name="share_scene")
    private Integer shareScene;
    @JSONField(name="share_count")
    private Integer shareCount;
    @JSONField(name="share_user")
    private Integer shareUser;

    public Integer getShareScene() {
        return shareScene;
    }

    public void setShareScene(Integer shareScene) {
        this.shareScene = shareScene;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getShareUser() {
        return shareUser;
    }

    public void setShareUser(Integer shareUser) {
        this.shareUser = shareUser;
    }
}
