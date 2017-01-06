package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.github.jf.weixin.entity.model.BaseModel;

import java.util.List;

/**
 * 卡券高级属性<br>
 * <table cellspacing="0" cellpadding="2" align="left"><tbody><tr class="firstRow thead"><th style="width: 150px; border-color: rgb(221, 221, 221);" class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">字段</span></th><th class="table_cell" align="left" valign="top" style="border-color: rgb(221, 221, 221);"><p><span style="font-weight: bold; text-align: center; background-color: rgb(247, 247, 247);">是</span>否</p><p>必填</p></th><th class="table_cell" align="left" valign="top" style="border-color: rgb(221, 221, 221);">类型</th><th style="width: 500px; border-color: rgb(221, 221, 221);" class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">说明</span></th></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">advanced_info</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family:微软雅黑, Microsoft YaHei">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">创建优惠券特有的高级字段</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">use_condition</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family:微软雅黑, Microsoft YaHei">使用门槛（条件）字段，若不填写使用条件则在券面拼写<br>：无最低消费限制，全场通用，不限品类；并在使用说明显示：<br>可与其他优惠共享</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">accept_category</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（512）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">指定可用的商品类目，仅用于代金券类型</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，填入后将在券面拼写适用于xxx</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">reject_category</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family:微软雅黑, Microsoft YaHei">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（<span style="font-family: 微软雅黑, 'Microsoft YaHei';">512</span>）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">指定不可用的商品类目，仅用于代金券类型</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，填入后将在券面拼写不适用于xxxx</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">least_cost</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">满减门槛字段，可用于兑换券和代金券</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，填入后将在全面拼写消费满xx元可用。</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">object_use_for</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（<span style="font-family: 微软雅黑, 'Microsoft YaHei';">512</span>）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">购买xx可用类型门槛，仅用于兑换</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，填入后自动拼写购买xxx可用。</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">can_use_with_other_discount</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">不可以与其他类型共享门槛</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，填写false时系统将在使用须知里</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">拼写“不可与其他优惠共享”，</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">填写true时系统将在使用须知里</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">拼写“可与其他优惠共享”，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">默认为true</span><br></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">abstract</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family:微软雅黑, Microsoft YaHei">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">封面摘要结构体名称</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">abstract</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"></span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（24</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">封面摘要简介。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">icon_url_list</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（128</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">封面图片列表，仅支持填入一</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">个封面图片链接，</span><a href="#2.3.1" target="_self" textvalue="上传图片接口"><span style="color: rgb(54, 103, 153); text-decoration: underline; font-family: 微软雅黑, 'Microsoft YaHei';">上传图片接口</span></a></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">上传获取图片获得链接，填写</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">非CDN链接会报错，并在此填入。</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">建议图片尺寸像素850*350</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">text_image_list</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">图文列表，显示在详情内页</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，优惠券券开发者须至少传入</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">一组图文列表</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">image_url</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（128</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">图片链接，必须调用</span><a href="#2.3.1" target="_self" textvalue="上传图片接口"><span style="color: rgb(54, 103, 153); text-decoration: underline; font-family: 微软雅黑, 'Microsoft YaHei';">上传图片接口</span></a></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">上传图片获得链接，并在此填入，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否则报错</span></p></td></tr><tr><td class="table_cell" align="left" valign="top" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">text</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（512</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">图文描述</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">business_service</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">arry</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">商家服务类型：</span><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">BIZ_SERVICE_DELIVER 外卖服务；</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">BIZ_SERVICE_FREE_PARK 停车位；</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">BIZ_SERVICE_WITH_PET 可带宠物；</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">BIZ_SERVICE_FREE_WIFI 免费wifi，</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">可多选</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">time_limit</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">使用时段限制，包含以下字段</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">type</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（24</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">）</span></span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">限制类型枚举值：支持填入</span><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">MONDAY 周一&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">TUESDAY 周二&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">WEDNESDAY 周三</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">&nbsp;THURSDAY 周四&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">FRIDAY 周五&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">SATURDAY 周六&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">SUNDAY 周日&nbsp;</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">此处只控制显示，</span></p><p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; text-align: left;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">不控制实际使用逻辑，不填默认不显示</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">begin_hour</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">当前type类型下的起始时间（小时）</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，如当前结构体内填写了MONDAY，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">此处填写了10，则此处表示周一 10:00可用</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">begin_minute</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">当前type类型下的起始时间（分钟）</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，如当前结构体内填写了MONDAY，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">begin_hour填写10，此处填写了59，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">则此处表示周一 10:59可用</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">end_hour</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">当前type类型下的结束时间（小时）</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，如当前结构体内填写了MONDAY，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">此处填写了20，</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">则此处表示周一 10:00-20:00可用</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">end_minute</span></td><td class="table_cell" colspan="1" rowspan="1" valign="null" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">当前type类型下的结束时间（分钟）</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，如当前结构体内填写了MONDAY，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">begin_hour填写10，此处填写了59，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">则此处表示周一 10:59-00:59可用</span></p></td></tr></tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardAdvancedInfo extends BaseModel{

    @JSONField(name="use_condition")
    protected UseCondition useCondition;
    @JSONField(name="abstract")
    protected AbstractInfo abstractInfo;
    @JSONField(name="text_image_list")
    protected List<TextImage> textImageList;
    @JSONField(name="business_service")
    protected List<String> businessServiceList;
    @JSONField(name="time_limit")
    protected List<TimeLimit> timeLimitList;

    public static class UseCondition {
        @JSONField(name="accept_category")
        protected String acceptCategory;
        @JSONField(name="reject_category")
        protected String rejectCategory;
        @JSONField(name="least_cost")
        protected int leastCost;
        @JSONField(name="object_use_for")
        protected String objectUseFor;
        @JSONField(name="can_use_with_other_discount")
        protected boolean canUseWithOtherDiscount;

        public String getAcceptCategory() {
            return acceptCategory;
        }

        public void setAcceptCategory(String acceptCategory) {
            this.acceptCategory = acceptCategory;
        }

        public String getRejectCategory() {
            return rejectCategory;
        }

        public void setRejectCategory(String rejectCategory) {
            this.rejectCategory = rejectCategory;
        }

        public int getLeastCost() {
            return leastCost;
        }

        public void setLeastCost(int leastCost) {
            this.leastCost = leastCost;
        }

        public String getObjectUseFor() {
            return objectUseFor;
        }

        public void setObjectUseFor(String objectUseFor) {
            this.objectUseFor = objectUseFor;
        }

        public boolean isCanUseWithOtherDiscount() {
            return canUseWithOtherDiscount;
        }

        public void setCanUseWithOtherDiscount(boolean canUseWithOtherDiscount) {
            this.canUseWithOtherDiscount = canUseWithOtherDiscount;
        }
    }

    public static class AbstractInfo {
        @JSONField(name="abstract")
        protected String abstractName;
        @JSONField(name="icon_url_list")
        protected List<String> iconUrlList;

        public String getAbstractName() {
            return abstractName;
        }

        public void setAbstractName(String abstractName) {
            this.abstractName = abstractName;
        }

        public List<String> getIconUrlList() {
            return iconUrlList;
        }

        public void setIconUrlList(List<String> iconUrlList) {
            this.iconUrlList = iconUrlList;
        }
    }


    public static class TextImage {
        @JSONField(name="image_url")
        protected String imageUrl;
        @JSONField(name="text")
        protected String text;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class TimeLimit {
        @JSONField(name="type")
        protected String type;
        @JSONField(name="begin_hour")
        protected int beginHour;
        @JSONField(name="begin_minute")
        protected int beginMinute;
        @JSONField(name="end_hour")
        protected int endHour;
        @JSONField(name="end_minute")
        protected int endMinute;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getBeginHour() {
            return beginHour;
        }

        public void setBeginHour(int beginHour) {
            this.beginHour = beginHour;
        }

        public int getBeginMinute() {
            return beginMinute;
        }

        public void setBeginMinute(int beginMinute) {
            this.beginMinute = beginMinute;
        }

        public int getEndHour() {
            return endHour;
        }

        public void setEndHour(int endHour) {
            this.endHour = endHour;
        }

        public int getEndMinute() {
            return endMinute;
        }

        public void setEndMinute(int endMinute) {
            this.endMinute = endMinute;
        }
    }


    public UseCondition getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(UseCondition useCondition) {
        this.useCondition = useCondition;
    }

    public AbstractInfo getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(AbstractInfo abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public List<TextImage> getTextImageList() {
        return textImageList;
    }

    public void setTextImageList(List<TextImage> textImageList) {
        this.textImageList = textImageList;
    }

    public List<String> getBusinessServiceList() {
        return businessServiceList;
    }

    public void setBusinessServiceList(List<String> businessServiceList) {
        this.businessServiceList = businessServiceList;
    }

    public List<TimeLimit> getTimeLimitList() {
        return timeLimitList;
    }

    public void setTimeLimitList(List<TimeLimit> timeLimitList) {
        this.timeLimitList = timeLimitList;
    }
}
