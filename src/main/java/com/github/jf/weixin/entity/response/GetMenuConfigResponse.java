package com.github.jf.weixin.entity.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取自定义菜单配置-返回结果<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetMenuConfigResponse extends BaseResponse{
	@JSONField(name="is_menu_open")
	protected int isMenuOpen;
}
