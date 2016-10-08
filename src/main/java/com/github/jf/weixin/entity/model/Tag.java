package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

/**
 * 标签对象<br>
 * <table border="1">
 * <tbody class="tbody">
 *     <tr class="firstRow thead"><td class="table_cell" width="471" valign="top" style="word-break: break-all;"><strong>参数</strong></td><td class="table_cell" width="471" valign="top" style="word-break: break-all;"><strong>说明</strong></td></tr><tr><td class="table_cell" width="471" valign="top" style="word-break: break-all;">id</td><td class="table_cell" width="471" valign="top" style="word-break: break-all;">标签id，由微信分配</td></tr>
 *     <tr><td class="table_cell" width="471" valign="top" style="word-break: break-all;">name</td><td class="table_cell" width="471" valign="top" style="word-break: break-all;">标签名，UTF8编码</td></tr>
 *     <tr><td class="table_cell" width="471" valign="top" style="word-break: break-all;">count</td><td class="table_cell" width="471" valign="top" style="word-break: break-all;">此标签下粉丝数</td></tr>
 * </tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class Tag extends BaseModel {
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
