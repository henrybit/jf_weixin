package com.github.jf.weixin.entity.response.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Group;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 创建分组返回报文<br>
 * <pre>
 * {"group": {"id": 107,"name": "test"}}
 * </pre>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateGroupResponse extends BaseResponse {
	@JSONField(name="group")
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	
}
