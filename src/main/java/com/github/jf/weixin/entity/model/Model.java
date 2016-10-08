package com.github.jf.weixin.entity.model;

import java.io.Serializable;

/**
 * 模型接口，所有需要传输的对象都需要实现，提供转json和xml的方法<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public interface Model extends Serializable {

    /**
     * 将model转成json字符串<br>
     * @return json字符串
     */
    String toJsonString();
}
