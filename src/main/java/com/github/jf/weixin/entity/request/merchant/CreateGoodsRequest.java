package com.github.jf.weixin.entity.request.merchant;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.request.BaseRequest;

import java.util.List;

/**
 * {"product_base":{"category_id":["537074298"],"property":[{"id":"1075741879","vid":"1079749967"},{"id":"1075754127","vid":"1079795198"},{"id":"1075777334","vid":"1079837440"}],"name":"testaddproduct","sku_info":[{"id":"1075741873","vid":["1079742386","1079742363"]}],"main_img":"http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjD3ulEKogfsiaua49pvLfUS8Ym0GSYjViaLic0FD3vN0V8PILcibEGb2fPfEOmw/0","img":["http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjD3ulEKogfsiaua49pvLfUS8Ym0GSYjViaLic0FD3vN0V8PILcibEGb2fPfEOmw/0"],"detail":[{"text":"test first"},{"img":"http://mmbiz.qpic.cn/mmbiz/4whpV1VZl2iccsvYbHvnphkyGtnvjD3ul1UcLcwxrFdwTKYhH9Q5YZoCfX4Ncx655ZK6ibnlibCCErbKQtReySaVA/0"},{"text":"test again"}],"buy_limit":10},"sku_list":[{"sku_id":"1075741873:1079742386","price":30,"icon_url":"http://mmbiz.qpic.cn/mmbiz/4whpV1VZl28bJj62XgfHPibY3ORKicN1oJ4CcoIr4BMbfA8LqyyjzOZzqrOGz3f5KWq1QGP3fo6TOTSYD3TBQjuw/0","product_code":"testing","ori_price":9000000,"quantity":800},{"sku_id":"1075741873:1079742363","price":30,"icon_url":"http://mmbiz.qpic.cn/mmbiz/4whpV1VZl28bJj62XgfHPibY3ORKicN1oJ4CcoIr4BMbfA8LqyyjzOZzqrOGz3f5KWq1QGP3fo6TOTSYD3TBQjuw/0","product_code":"testingtesting","ori_price":9000000,"quantity":800}],"attrext":{"location":{"country":"中国","province":"广东省","city":"广州市","address":"T.I.T创意园"},"isPostFree":0,"isHasReceipt":1,"isUnderGuaranty":0,"isSupportReplace":0},"delivery_info":{"delivery_type":0,"template_id":0,"express":[{"id":10000027,"price":100},{"id":10000028,"price":100},{"id":10000029,"price":100}]}}
 * 微信小店——创建商品请求报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateGoodsRequest extends BaseRequest{
    @JSONField(name="product_base")
    protected GoodsBase productBase; //商品基本信息
    @JSONField(name="sku_list")
    protected List<SkuInfo> skuInfos; //sku信息列表(可为多个)，每个sku信息串即为一个确定的商品，比如白色的37码的鞋子
    @JSONField(name="attrext")
    protected AttrText attrText; //商品其他属性
    @JSONField(name="delivery_info")
    protected DeliveryInfo deliveryInfo;

    class GoodsBase {
        @JSONField(name="category_id")
        public List<String> categoryIds; //商品分类id
        @JSONField(name="property")
        public List<GoodsProperty> goodsProperties; //商品属性列表
        @JSONField(name="name")
        public String name; //商品名称
        @JSONField(name="sku_info")
        public List<BaseSkuInfo> skuInfos; //商品sku定义
        @JSONField(name="main_img")
        public String mainImg; //商品主图(图片需调用图片上传接口获得图片Url填写至此，否则无法添加商品。图片分辨率推荐尺寸为640×600)
        @JSONField(name="img")
        public List<String> imgs; //商品图片列表(图片需调用图片上传接口获得图片Url填写至此，否则无法添加商品。图片分辨率推荐尺寸为640×600)
        @JSONField(name="detail")
        public List<Object> details; //商品详情列表，显示在客户端的商品详情页内(Object:DetailImg/DetailText)
        @JSONField(name="buy_limit")
        public long buyLimit; //用户商品限购数量
    }

    class GoodsProperty {
        @JSONField(name="id")
        public String id; //属性id
        @JSONField(name="vid")
        public String vid; //属性值id
    }

    class BaseSkuInfo {
        @JSONField(name="id")
        public String id; //sku属性(SKU列表中id, 支持自定义SKU，格式为"$xxx"，xxx即为显示在客户端中的字符串)
        @JSONField(name="vid")
        public List<String> vids; //sku值(SKU列表中vid, 如需自定义SKU，格式为"$xxx"，xxx即为显示在客户端中的字符串)
    }

    class DetailText {
        @JSONField(name="text")
        public String text; //文字描述
    }

    class DetailImg {
        @JSONField(name="img")
        public String img; //图片(图片需调用图片上传接口获得图片Url填写至此，否则无法添加商品)
    }

    class SkuInfo {
        @JSONField(name="sku_id")
        public String skuId; //sku信息, 参照上述sku_table的定义; 格式 : "id1:vid1;id2:vid2" 规则 : id_info的组合个数必须与sku_table个数一致(若商品无sku信息, 即商品为统一规格，则此处赋值为空字符串即可)
        @JSONField(name="price")
        public long price; //sku微信价(单位 : 分, 微信价必须比原价小, 否则添加商品失败)
        @JSONField(name="icon_url")
        public String iconUrl; //sku iconurl(图片需调用图片上传接口获得图片Url)
        @JSONField(name="product_code")
        public String productCode; //商家商品编码
        @JSONField(name="ori_price")
        public long oriPrice; //sku原价(单位 : 分)
        @JSONField(name="quantity")
        public long quantity; //sku库存
    }

    class AttrLocation {
        @JSONField(name="country")
        public String country; //国家(详见《地区列表》说明)
        @JSONField(name="province")
        public String province; //省份(详见《地区列表》说明)
        @JSONField(name="city")
        public String city; //城市(详见《地区列表》说明)
        @JSONField(name="address")
        public String address; //地址
    }

    class AttrText {
        @JSONField(name="location")
        public AttrLocation location; //商品所在地地址
        @JSONField(name="isPostFree")
        public long isPostFree; //是否包邮(0-否, 1-是), 如果包邮delivery_info字段可省略
        @JSONField(name="isHasReceipt")
        public long isHasReceipt; //是否提供发票(0-否, 1-是)
        @JSONField(name="isUnderGuaranty")
        public long isUnderGuaranty; //是否保修(0-否, 1-是)
        @JSONField(name="isSupportReplace")
        public long isSupportReplace; //是否支持退换货(0-否, 1-是)
    }

    class DeliveryInfo {
        @JSONField(name="delivery_type")
        public long deliveryType; //运费类型(0-使用下面express字段的默认模板, 1-使用template_id代表的邮费模板, 详见邮费模板相关API)
        @JSONField(name="template_id")
        public long templateId; //邮费模板ID
        @JSONField(name="express")
        public List<DeliveryInfoExpress> expressList; //快递信息集合
    }

    class DeliveryInfoExpress {
        @JSONField(name="id")
        public long id; //快递ID
        @JSONField(name="price")
        public long price; //价格
    }
}
