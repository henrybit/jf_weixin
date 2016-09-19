package com.github.jf.weixin.entity.message.request;

/**
 * 请求发送内容的基础类
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public abstract class BaseReq {
    /**
     * Json格式数据
     * @return
     */
    public abstract String toJson();

    @Override
    public String toString() {
        return toJson();
    }
}
