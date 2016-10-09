package com.github.jf.weixin.entity.response.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.poi.BusinessInfo;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 门店查询结果报文<br>
 * <p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><strong>json 数据示例</strong></span></p>
 * <div data-tag="backcolor" style="margin-bottom: 14px; padding: 10px 16px; background-color: rgb(253, 234, 218);"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">{</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; "errcode":0,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; "errmsg":"ok",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; "business ":{</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; "base_info":{</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"sid":"001",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"business_name":"麦当劳",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"branch_name":"艺苑路店",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"province":"广东省",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"city":"广州市",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"address":"海珠区艺苑路11 号",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"telephone":"020-12345678",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"categories":["美食,小吃快餐"],</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"offset_type":1,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"longitude":115.32375,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"latitude":25.097486,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"photo_list":[{"photo_url":"https:// XXX.com"} ， {"photo_url":"https://XXX.com"}],</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"recommend":"麦辣鸡腿堡套餐，麦乐鸡，全家桶",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"special":"免费wifi，外卖服务",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"introduction":"麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上大</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp;约拥有3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、水果等快餐食品",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"open_time":"8:00-20:00",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"avg_price":35</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"available_state":3</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"update_status":0</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; }</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; }</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp;}</span></p></div>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class GetPoiResponse extends BaseResponse {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1891832332159691007L;
	@JSONField(name="business")
    protected BusinessInfo businessInfo;
	public BusinessInfo getBusinessInfo() {
		return businessInfo;
	}
	public void setBusinessInfo(BusinessInfo businessInfo) {
		this.businessInfo = businessInfo;
	}
	
}
