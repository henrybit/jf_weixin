package com.github.jf.weixin.entity.model.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;

import java.util.List;

/**
 * 卡券基本信息<br>
 * <table border="1" cellspacing="0" cellpadding="4" align="left" width="700px"><tbody><tr class="firstRow thead"><th style="width: 60px;" class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">logo_url</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">strin</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">g(128)</span></p></td><td class="table_cell"><a href="http://mmbiz.qpic.cn/" rel="nofollow" target="_blank" style="color: rgb(54, 103, 153); text-decoration: underline; font-family: 微软雅黑, 'Microsoft YaHei';"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">http://mmbiz.qpic.cn/</span></a></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券的商户logo，建议像素为300*300。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">code_type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string(16)</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">CODE_TYPE_TEXT</span></td><td class="table_cell"><p><span style="font-family:微软雅黑, Microsoft YaHei">码型：</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">"CODE_TYPE_TEXT"文<span style="font-family: 微软雅黑, 'Microsoft YaHei';">本</span>；</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">"CODE_TYPE_BARCODE"一维码&nbsp;</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">"CODE_TYPE_QRCODE"二维码</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">"CODE_TYPE_ONLY_QRCODE",二维码无code显示；</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">"CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE，</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">不显示code和条形码类型</span></p></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">brand_name</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（36）</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">海底捞</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">商户名字,字数上限为12个汉字。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">title</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（27）</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">双人套餐100元兑换券</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">color</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（16）</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">Color010</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">券颜色。按色彩规范标注填写Color010-Color100。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">notice</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（48）</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">请出示二维码</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券使用提醒，字数上限为16个汉字。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">description</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">strin</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">g</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">（3072）</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">不可与其他优惠同享</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券使用说明，字数上限为1024个汉字。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">sku</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">商品信息。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">quantity</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">100000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券库存的数量，上限为100000000。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">date_info</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">JSON结构</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">见上述示例。</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">使用日期，有效期的信息。</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">type</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string</span></td><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">DATE_TYPE_FIX</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">_TIME_RANGE&nbsp;</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">表示固定日期区间，DATE_TYPE_</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">FIX_TERM</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">表示固定时长</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">（自领取后按天算。</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">使用时间的类型，旧文档采用的1和2依然生效。</span></td></tr><tr><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">begin_time</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">stamp</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">unsigned int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">14300000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间,UTC+8，单位为秒）</span></td></tr><tr><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">end_time</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">stamp</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">unsigned int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">15300000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">表示结束时间<span style="font-family: 微软雅黑, 'Microsoft YaHei'; color: rgb(0, 0, 0);">，<span style="font-family: 微软雅黑, 'Microsoft YaHei';"></span><span label="强调" style="font-family: 微软雅黑, 'Microsoft YaHei'; font-size: 16px; font-style: italic; font-weight: bold; line-height: 18px;"><span style="font-size: 16px; font-style: italic; font-weight: bold; line-height: 18px; font-family: 微软雅黑, 'Microsoft YaHei';">建议设置为截止日期的23:59:59过期</span>。</span></span>（<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">东八区时间,UTC+8，单位为秒</span>）</span></td></tr><tr><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">fixed_term</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">15</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。</span></td></tr><tr><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">fixed_begin</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">_term</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">0</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）</span></td></tr><tr><td class="table_cell"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">end_time</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">s</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">tamp</span></p></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">unsigned int</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">15300000</span></td><td class="table_cell"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间<span style="font-family: 微软雅黑, 'Microsoft YaHei'; color: rgb(0, 0, 0);">，<span style="font-family: 微软雅黑, 'Microsoft YaHei'; font-size: 16px; font-style: italic; font-weight: bold; line-height: 18px;">建议设置为截止日期的23:59:59过期</span>。</span>（<span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">东八区时间,UTC+8，单位为秒</span>），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期</span></td></tr></tbody></table>
 *
 * <p style="line-height: 1.5; word-wrap: break-word; margin-left: 10px; margin-right: 10px; color: rgb(51, 51, 51); font-family: 'Microsoft Yahei', 宋体, Tahoma, Arial; font-size: 14px; white-space: normal; text-align: left; background-color: rgb(255, 255, 255);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';"><strong style="color: rgb(51, 51, 51); font-family: 微软雅黑, 'Microsoft YaHei'; font-size: 14px; line-height: 21px; white-space: normal; background-color: rgb(255, 255, 255);">&nbsp;base_info（卡券基础信息）字段-非必填字段</strong></span></p>
 * <table border="1" cellspacing="0" cellpadding="4" align="left"><tbody><tr class="firstRow thead"><th style="width: 60px; border-color: rgb(221, 221, 221);" class="table_cell" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">参数名</span></th><th class="table_cell" style="border-color: rgb(221, 221, 221);" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">必填</span></th><th class="table_cell" style="border-color: rgb(221, 221, 221);" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">类型</span></th><th class="table_cell" style="border-color: rgb(221, 221, 221);" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">示例值</span></th><th class="table_cell" style="border-color: rgb(221, 221, 221);" align="left" valign="top"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">描述</span></th></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">use_custom_code</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">true</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是否自定义Code码</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">。填写true或false，默认为false。</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">通常自有优惠码系统的开发者选择</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">自定义Code码，并在卡券投放时带入</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">Code码，详情见</span><a href="#2.2.2" target="_self" textvalue="是否自定义Code码"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是否自定义Code码</span></a><span style="font-family: 微软雅黑, 'Microsoft YaHei';">。</span></p></td></tr><tr><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">get_custom_code_mode</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">否</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">string(32)</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="color: rgb(34, 34, 34); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 14px; line-height: 22.4px;">GET_CUSTOM_COD</span></p><p><span style="color: rgb(34, 34, 34); font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 14px; line-height: 22.4px;">E_MODE_DEPOSIT</span></p></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family:微软雅黑, Microsoft YaHei"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">填入</span></span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="color: rgb(34, 34, 34); font-size: 14px; line-height: 22.4px; font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">GET_CUSTOM_CODE_MODE_DEPOSIT</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">表示该卡券为预存code模式卡券，</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">须导入超过库存数目的自定义code后方可投放，</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">填入该字段后，quantity字段须为0,须导入code</span></p><p style="margin-top: 0px; margin-bottom: 0px; padding: 0px; white-space: normal;"><span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">后再增加库存</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bind_openid</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">true</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">是否指定用户领取，填写true或false</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">。默认为false。通常指定特殊用户群体</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">投放卡券或防止刷券时选择指定用户领取。</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">service_phone</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（24）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">40012234</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">客服电话。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">location_id_list</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">array</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">1234，2312</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">门店位置poiid。</span><a href="http://mp.weixin.qq.com/wiki?t=resource/res_main&amp;id=mp1444378120&amp;token=&amp;lang=zh_CN" target="_blank"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">调用</span><span style="font-family: 微软雅黑, 'Microsoft YaHei';">POI门店管理接</span></a></p><p><a href="http://mp.weixin.qq.com/wiki?t=resource/res_main&amp;id=mp1444378120&amp;token=&amp;lang=zh_CN" target="_blank"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">口</span></a><span style="font-family: 微软雅黑, 'Microsoft YaHei';">获取门店位置poiid。具备线下门店</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">的商户为必填。</span></p></td></tr><tr><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">use_all_locations</span></p></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">true</span></td><td class="table_cell" colspan="1" rowspan="1" style="border-left-color: rgb(221, 221, 221); border-top-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">设置本卡券支持全部门店，与location_id_list互斥</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">source</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（36）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">大众点评</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">第三方来源名，例如同程旅游、大众点评。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">custom_url_name</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（15）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">立即使用</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">自定义跳转外链的入口名字</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">。详情见</span><a href="#2.2.5" target="_self" textvalue="活用自定义入口"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">活用自定义入口</span></a></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">center_title</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（18）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">立即使用</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券顶部居中的按钮，仅在卡券状</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">态正常(可以核销)时显示</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">center_sub_title</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（24）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">立即享受优惠</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">显示在入口下方的提示语</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，仅在卡券状态正常(可以核销)时显示。</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">center_url</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（128）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">www.qq.com</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">顶部居中的url</span></p><p><span style="font-family: 微软雅黑, 'Microsoft YaHei';">，仅在卡券状态正常(可以核销)时显示。</span></p></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">custom_url</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（128）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">www.qq.com</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">自定义跳转的URL。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">custom_url_sub_title</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（18）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">更多惊喜</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">显示在入口右侧的提示语。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">promotion_url_name</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（15）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">产品介绍</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">营销场景的自定义入口名称。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">promotion_url</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（128）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221); word-break: break-all;"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">www.qq.com</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">入口跳转外链的地址链接。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">promotion_url_sub_title</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">string（18）</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卖场大优惠。</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">显示在营销入口右侧的提示语。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">get_limit</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">int</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">1</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">每人可领券的数量限制,不填写默认为50。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">can_share</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">false</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券领取页面是否可分享。</span></td></tr><tr><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">can_give_friend</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">否</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">bool</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">false</span></td><td class="table_cell" style="border-color: rgb(221, 221, 221);"><span style="font-family: 微软雅黑, 'Microsoft YaHei';">卡券是否可转赠。</span></td></tr></tbody></table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardBaseInfo extends BaseModel{
    /******必填字段********/
    @JSONField(name="logo_url")
    protected String logoUrl;
    @JSONField(name="code_type")
    protected String codeType;
    @JSONField(name="brand_name")
    protected String brandName;
    @JSONField(name="title")
    protected String title;
    @JSONField(name="color")
    protected String color;
    @JSONField(name="notice")
    protected String notice;
    @JSONField(name="description")
    protected String description;
    @JSONField(name="sku")
    protected Sku sku;
    @JSONField(name="date_info")
    protected DateInfo dateInfo;
    @JSONField(name="fixed_term")
    protected int fixedTerm;
    @JSONField(name="fixed_begin_term")
    protected int fixedBeginTerm;
    @JSONField(name="end_timestamp")
    protected long endTimestamp;

    /******非必填字段********/
    @JSONField(name="get_limit")
    protected int getLimit;
    @JSONField(name="use_custom_code")
    protected boolean useCustomCode;
    @JSONField(name="get_custom_code_mode")
    protected String getCustomCodeMode;
    @JSONField(name="bind_openid")
    protected boolean bindOpenid;
    @JSONField(name="service_phone")
    protected String servicePhone;
    @JSONField(name="can_share")
    protected boolean canShare;
    @JSONField(name="can_give_friend")
    protected boolean canGiveFriend;
    @JSONField(name="location_id_list")
    protected List<Integer> locationIdList;
    @JSONField(name="use_all_locations")
    protected boolean useAllLocations;
    @JSONField(name="center_title")
    protected String centerTitle;
    @JSONField(name="center_sub_title")
    protected String centerSubTitle;
    @JSONField(name="center_url")
    protected String centerUrl;
    @JSONField(name="custom_url_name")
    protected String customUrlName;
    @JSONField(name="custom_url")
    protected String customUrl;
    @JSONField(name="custom_url_sub_title")
    protected String customUrlSubTitle;
    @JSONField(name="promotion_url_name")
    protected String promotionUrlName;
    @JSONField(name="promotion_url")
    protected String promotionUrl;
    @JSONField(name="promotion_url_sub_title")
    protected String promotionUrlSubTitle;
    @JSONField(name="source")
    protected String source;


    public static class Sku {
        @JSONField(name="quantity")
        protected int quantity;

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public static class DateInfo {
        @JSONField(name="type")
        protected String type;
        @JSONField(name="begin_timestamp")
        protected long beginTimestamp;
        @JSONField(name="fixed_term")
        protected int fixedTerm;
        @JSONField(name="fixed_begin_term")
        protected int fixedBeginTerm;
        @JSONField(name="end_timestamp")
        protected long endTimestamp;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getBeginTimestamp() {
            return beginTimestamp;
        }

        public void setBeginTimestamp(long beginTimestamp) {
            this.beginTimestamp = beginTimestamp;
        }

        public long getEndTimestamp() {
            return endTimestamp;
        }

        public void setEndTimestamp(long endTimestamp) {
            this.endTimestamp = endTimestamp;
        }

        public int getFixedTerm() {
            return fixedTerm;
        }

        public void setFixedTerm(int fixedTerm) {
            this.fixedTerm = fixedTerm;
        }

        public int getFixedBeginTerm() {
            return fixedBeginTerm;
        }

        public void setFixedBeginTerm(int fixedBeginTerm) {
            this.fixedBeginTerm = fixedBeginTerm;
        }
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public DateInfo getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }

    public int getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(int fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public int getFixedBeginTerm() {
        return fixedBeginTerm;
    }

    public void setFixedBeginTerm(int fixedBeginTerm) {
        this.fixedBeginTerm = fixedBeginTerm;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public int getGetLimit() {
        return getLimit;
    }

    public void setGetLimit(int getLimit) {
        this.getLimit = getLimit;
    }

    public boolean isUseCustomCode() {
        return useCustomCode;
    }

    public void setUseCustomCode(boolean useCustomCode) {
        this.useCustomCode = useCustomCode;
    }

    public String getGetCustomCodeMode() {
        return getCustomCodeMode;
    }

    public void setGetCustomCodeMode(String getCustomCodeMode) {
        this.getCustomCodeMode = getCustomCodeMode;
    }

    public boolean isBindOpenid() {
        return bindOpenid;
    }

    public void setBindOpenid(boolean bindOpenid) {
        this.bindOpenid = bindOpenid;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public boolean isCanShare() {
        return canShare;
    }

    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    public boolean isCanGiveFriend() {
        return canGiveFriend;
    }

    public void setCanGiveFriend(boolean canGiveFriend) {
        this.canGiveFriend = canGiveFriend;
    }

    public List<Integer> getLocationIdList() {
        return locationIdList;
    }

    public void setLocationIdList(List<Integer> locationIdList) {
        this.locationIdList = locationIdList;
    }

    public boolean isUseAllLocations() {
        return useAllLocations;
    }

    public void setUseAllLocations(boolean useAllLocations) {
        this.useAllLocations = useAllLocations;
    }

    public String getCenterTitle() {
        return centerTitle;
    }

    public void setCenterTitle(String centerTitle) {
        this.centerTitle = centerTitle;
    }

    public String getCenterSubTitle() {
        return centerSubTitle;
    }

    public void setCenterSubTitle(String centerSubTitle) {
        this.centerSubTitle = centerSubTitle;
    }

    public String getCenterUrl() {
        return centerUrl;
    }

    public void setCenterUrl(String centerUrl) {
        this.centerUrl = centerUrl;
    }

    public String getCustomUrlName() {
        return customUrlName;
    }

    public void setCustomUrlName(String customUrlName) {
        this.customUrlName = customUrlName;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public String getCustomUrlSubTitle() {
        return customUrlSubTitle;
    }

    public void setCustomUrlSubTitle(String customUrlSubTitle) {
        this.customUrlSubTitle = customUrlSubTitle;
    }

    public String getPromotionUrlName() {
        return promotionUrlName;
    }

    public void setPromotionUrlName(String promotionUrlName) {
        this.promotionUrlName = promotionUrlName;
    }

    public String getPromotionUrl() {
        return promotionUrl;
    }

    public void setPromotionUrl(String promotionUrl) {
        this.promotionUrl = promotionUrl;
    }

    public String getPromotionUrlSubTitle() {
        return promotionUrlSubTitle;
    }

    public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
        this.promotionUrlSubTitle = promotionUrlSubTitle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
