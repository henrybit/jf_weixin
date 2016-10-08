package com.github.jf.weixin.entity.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 行业数据返回实体<br>
 * <ul>
 *     <li>first_class-行业编号</li>
 *     <li>second_class-行业子编号</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class Industry extends BaseModel {
    @JSONField(name="first_class")
    protected String firstClass;
    @JSONField(name="second_class")
    protected String secondClass;

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }
}
