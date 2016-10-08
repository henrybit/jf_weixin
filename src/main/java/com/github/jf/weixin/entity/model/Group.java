package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 分组信息<br>
 *  @author henrybit
 *  @since 2.0
 *  @version 2.0
 */
public class Group extends BaseModel {
    @JSONField(name="id")
    private Integer id;
    @JSONField(name="name")
    private String name;
    @JSONField(name="count")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
