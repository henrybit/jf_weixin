package com.github.jf.weixin.entity.request.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.poi.PoiInfo;
import com.github.jf.weixin.entity.request.BaseRequest;

/**
 * 创建门店请求参数<br>
 * <p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><strong>json 数据示例</strong></span></p>
 * <div data-tag="backcolor" style="margin-bottom: 14px; padding: 10px 16px; background-color: rgb(253, 234, 218);"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">{"business":{</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp;"base_info":{</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"sid":"33788392",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"business_name":"15个汉字或30个英文字符内",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"branch_name":"不超过10个字，不能含有括号和特殊字符",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"province":"不超过10个字",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"city":"不超过30个字",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"district":"不超过10个字",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"address":"门店所在的详细街道地址（不要填写省市信息）：不超过80个字",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"telephone":"<span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">不超53个字符（不可以出现文字）</span>",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"categories":["美食,小吃快餐"],&nbsp;</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"offset_type":1,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"longitude":115.32375,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"latitude":25.097486,</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"photo_list":[{"photo_url":"https:// </span><span style="font-family:微软雅黑, sans-serif"><span style="font-size: 16px;">不超过20张</span></span><span style="font-family:微软雅黑, Microsoft YaHei"><span style="font-size: 16px;">.c</span>om"}，{"photo_url":"https://XXX.com"}],</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"recommend":"<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; background-color: rgb(253, 234, 218);">不超过200字。</span>麦辣鸡腿堡套餐，麦乐鸡，全家桶",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"special":"不超过200字。免费wifi，外卖服务",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"introduction":"<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; background-color: rgb(253, 234, 218);">不超过300字。</span>麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;大约拥有3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、 水果等</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;快餐食品",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"open_time":"8:00-20:00",</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"avg_price":35</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;}</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">&nbsp; &nbsp; }</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">}</span></p></div>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreatePoiRequest extends BaseRequest {

    @JSONField(name="base_info")
    protected PoiInfo poiInfo;

    public PoiInfo getPoiInfo() {
        return poiInfo;
    }

    public void setPoiInfo(PoiInfo poiInfo) {
        this.poiInfo = poiInfo;
    }
}
