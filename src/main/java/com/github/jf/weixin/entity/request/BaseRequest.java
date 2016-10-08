package com.github.jf.weixin.entity.request;

import com.github.jf.weixin.util.JSONUtil;

/**
 * 请求发送内容的基础类
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public abstract class BaseRequest {
    /**
     * Json格式数据
     * @return
     */
    public String toJson() {
        return JSONUtil.toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
