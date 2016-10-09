package com.github.jf.weixin.entity.model.poi;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

import java.util.List;

/**
 * 门店信息(包含基本信息-必须的,扩展信息-非必须)<br>
 * <p><strong style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; white-space: normal;">门店基础信息字段（重要）</strong></p>
 * <table cellspacing="0" cellpadding="0"><tbody><tr class="firstRow thead"><td width="132" valign="top" style="border-width: 1px; border-color: windowtext; padding: 0px 7px; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center"><strong><span style=";font-family:'微软雅黑',sans-serif;color:white">字段</span></strong></p></td><td width="338" valign="top" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left-style: none; padding: 0px 7px; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center"><strong><span style="font-family:'微软雅黑',sans-serif;color:white">说明</span></strong></p></td><td width="98" valign="top" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left-style: none; padding: 0px 7px; word-break: break-all; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center;line-height:150%"><span style="font-family:'微软雅黑',sans-serif;color:white">是否必填</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-size: 16px; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">sid</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">business_name</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-size: 16px; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、地址、分店名等信息，错误示例：北京国美）</span></p><p><span style="font-size: 16px; color: rgb(34, 34, 34); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; background: white;">不能为空，15个汉字或30个英文字符内</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">branch_name</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><span style="font-family: 微软雅黑, sans-serif;"></span><span style="font-size: 14px; font-family: 微软雅黑, sans-serif;">分店名称（不应包含地区信息，不应与门店名有重复，错误示例：北京王府井店）</span><br> <span style="font-size: 14px; font-family: 微软雅黑, sans-serif; color: rgb(34, 34, 34); background: white;">10<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 14px;">个字</span>以内</span><span style="font-family: 微软雅黑, sans-serif; color: rgb(34, 34, 34); background: white;"></span></span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">province</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif"></span></p><p><span style=";font-family:'微软雅黑',sans-serif">门店所在的省份（直辖市填城市名,如：北京<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 16px;">市）</span></span></p><p><span style="color: rgb(34, 34, 34); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 16px; background: white;">10个字</span><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 16px;"><span style="font-size: 14px; font-family: 微软雅黑, sans-serif; color: rgb(34, 34, 34); background: white;"></span>以内</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">city</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif"></span></p><p><span style=";font-family:'微软雅黑',sans-serif">门店所在的城市</span></p><p><span style="font-size: 16px; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><span style="font-size: 16px; color: rgb(34, 34, 34); background: white;">10个字</span>以内</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">district</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif"></span></p><p><span style=";font-family:'微软雅黑',sans-serif">门店所在地区</span></p><p><span style="font-size: 16px; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;"><span style="font-size: 16px; color: rgb(34, 34, 34); background: white;">10个字</span>以内</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">address</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">门店所在的详细街道地址（不要填写省市信息）</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 11px;">（东莞等没有“区”行政区划的城市，该字段可不必填写。其余城市必填。）</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">telephone</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">门店的电话（纯数字，区号、分机号均由“-”隔开）</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">categories</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">门店的类型（不同级分类用“,”隔开，如：美食，川菜，火锅。详细分类参见附件：微信门店类目表）</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">offset_type</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">坐标类型，1 为火星坐标（目前只能选1）</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">longitude</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">门店所在地理位置的经度</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">latitude</span></p></td><td width="338" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）</span></p></td><td width="98" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style=";font-family:'微软雅黑',sans-serif">是</span></p></td></tr><tr><td class="table_cell" width="323" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">available_state</span></td><td class="table_cell" width="327" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">门店是否可用状态。1 表示系统错误、2 表示审核中、3 审核通过、4 审核驳回。当该字段为1、2、4 状态时，poi_id 为空</span></td></tr><tr><td class="table_cell" width="323" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">update_status</span></td><td class="table_cell" width="327" valign="top" style="word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">扩展字段是否正在更新中。1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段<strong>没有在更新中或更新已生效</strong>，可以再次更新</span></td></tr></tbody></table>
 * <p><strong style="white-space: normal; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">门店服务信息字段</strong></p>
 * <table cellspacing="0" cellpadding="0"><tbody><tr class="firstRow thead"><td width="132" valign="top" style="border-width: 1px; border-color: windowtext; padding: 0px 7px; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center"><strong><span style=";font-family:'微软雅黑',sans-serif;color:white">字段</span></strong></p></td><td width="358" valign="top" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left-style: none; padding: 0px 7px; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center"><strong><span style="font-family:'微软雅黑',sans-serif;color:white">说明</span></strong></p></td><td width="79" valign="top" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-top-color: windowtext; border-right-color: windowtext; border-bottom-color: windowtext; border-left-style: none; padding: 0px 7px; background: rgb(96, 96, 96);" class="table_cell"><p style="text-align:center;line-height:150%"><span style="font-family:'微软雅黑',sans-serif;color:white">是否必填</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">photo_list</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">图片列表，url 形式，可以有多张图片，尺寸为</span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">640*340px。必须为上一接口生成的url。<span style="font-family: 微软雅黑, sans-serif; color: rgb(34, 34, 34); background: white;">图片内容不允许与门店不相关，不允许为二维码、员工合照（或模特肖像）、营业执照、无门店正门的街景、地图截图、公交地铁站牌、菜单截图等</span></span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">recommend</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;"></span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容</span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">200字以内</span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">special</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">特色服务，如免费wifi，免费停车，送货上门等商户能提供的特色功能或服务</span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">introduction</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;"></span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">商户简介，主要介绍商户信息等</span></p><p><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 16px;">300字以内</span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">open_time</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">营业时间，24 小时制表示，用“-”连接，如</span></p><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">8:00-20:00</span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr><tr><td width="132" valign="top" style="border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-right-color: windowtext; border-bottom-color: windowtext; border-left-color: windowtext; border-top-style: none; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">avg_price</span></p></td><td width="358" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">人均价格，大于0 的整数</span></p></td><td width="79" valign="top" style="border-top-style: none; border-left-style: none; border-bottom-width: 1px; border-bottom-color: windowtext; border-right-width: 1px; border-right-color: windowtext; padding: 0px 7px; word-break: break-all;" class="table_cell"><p><span style="font-family: 微软雅黑, sans-serif; font-size: 16px;">否</span></p></td></tr></tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class PoiInfo extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7479918148877882348L;
	@JSONField(name="sid")
    protected String sid;
    @JSONField(name="business_name")
    protected String businessName;
    @JSONField(name="branch_name")
    protected String branchName;
    @JSONField(name="province")
    protected String province;
    @JSONField(name="city")
    protected String city;
    @JSONField(name="district")
    protected String district;
    @JSONField(name="address")
    protected String address;
    @JSONField(name="telephone")
    protected String telephone;
    @JSONField(name="categories")
    protected List<String> categories;
    @JSONField(name="offset_type")
    protected int offsetType;
    @JSONField(name="longitude")
    protected double longitude;
    @JSONField(name="latitude")
    protected double latitude;
    @JSONField(name="photo_list")
    protected List<PoiPhotoInfo> photoList;
    @JSONField(name="recommend")
    protected String recommend;
    @JSONField(name="special")
    protected String special;
    @JSONField(name="introduction")
    protected String introduction;
    @JSONField(name="open_time")
    protected String openTime;
    @JSONField(name="avg_price")
    protected double avgPrice;
    @JSONField(name="available_state")
    protected int availableState;
    @JSONField(name="update_status")
    protected int updateStatus;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(int offsetType) {
        this.offsetType = offsetType;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<PoiPhotoInfo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PoiPhotoInfo> photoList) {
        this.photoList = photoList;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

	public int getAvailableState() {
		return availableState;
	}

	public void setAvailableState(int availableState) {
		this.availableState = availableState;
	}

	public int getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(int updateStatus) {
		this.updateStatus = updateStatus;
	}
    
    
}
