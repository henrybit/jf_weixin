package com.github.jf.weixin.entity.response.poi;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.poi.BusinessInfo;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 查询门店列表返回报文<br>
 * <table class="table" width="951"><tbody class="tbody"><tr class="firstRow thead"><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><strong>参数</strong></span></td><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><strong>说明</strong></span></td></tr><tr><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">access_token</span></td><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">调用接口凭证</span></td></tr><tr><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">buffer</span></td><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">json数据</span></td></tr><tr><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">total_count</span></td><td class="table_cell" width="325" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">门店总数量</span></td></tr></tbody></table>
 * @author henrybit
 * @version 2.0
 * @since 2.0
 */
public class GetPoiListResponse extends BaseResponse{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8446346065046212179L;
	@JSONField(name="business_list")
	protected List<BusinessInfo> businessList;
	@JSONField(name="total_count")
	protected String totalCount;
	public List<BusinessInfo> getBusinessList() {
		return businessList;
	}
	public void setBusinessList(List<BusinessInfo> businessList) {
		this.businessList = businessList;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
