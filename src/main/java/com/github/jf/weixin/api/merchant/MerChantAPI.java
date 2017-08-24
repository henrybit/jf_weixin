package com.github.jf.weixin.api.merchant;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.request.merchant.CreateGoodsRequest;
import com.github.jf.weixin.entity.request.merchant.DeleteGoodsRequest;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.merchant.CreateGoodsResponse;
import com.github.jf.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信小店API接口<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>1.1 增加商品:https://api.weixin.qq.com/merchant/create?access_token=ACCESS_TOKEN</li>
 *     <li>1.2 删除商品:https://api.weixin.qq.com/merchant/del?access_token=ACCESS_TOKEN</li>
 *     <li>1.3 修改商品:https://api.weixin.qq.com/merchant/update?access_token=ACCESS_TOKEN</li>
 *     <li>1.4 查询商品:https://api.weixin.qq.com/merchant/get?access_token=ACCESS_TOKEN </li>
 *     <li>1.5 获取指定状态的所有商品:https://api.weixin.qq.com/merchant/getbystatus?access_token=ACCESS_TOKEN</li>
 *     <li>1.6 商品上下架:https://api.weixin.qq.com/merchant/modproductstatus?access_token=ACCESS_TOKEN </li>
 *     <li>1.7 获取指定分类的所有子分类:https://api.weixin.qq.com/merchant/category/getsub?access_token=ACCESS_TOKEN</li>
 *     <li>1.8 获取指定子分类的所有SKU:https://api.weixin.qq.com/merchant/category/getsku?access_token=ACCESS_TOKEN</li>
 *     <li>1.9 获取指定分类的所有属性:https://api.weixin.qq.com/merchant/category/getproperty?access_token=ACCESS_TOKEN</li>
 *     <li>2.1 增加库存:https://api.weixin.qq.com/merchant/stock/add?access_token=ACCESS_TOKEN</li>
 *     <li>2.2 减少库存:https://api.weixin.qq.com/merchant/stock/reduce?access_token=ACCESS_TOKEN</li>
 *     <li>3.1 增加邮费模板:https://api.weixin.qq.com/merchant/express/add?access_token=ACCESS_TOKEN</li>
 *     <li>3.2 删除邮费模板:https://api.weixin.qq.com/merchant/express/del?access_token=ACCESS_TOKEN</li>
 *     <li>3.3 修改邮费模板:https://api.weixin.qq.com/merchant/express/update?access_token=ACCESS_TOKEN</li>
 *     <li>3.4 获取指定ID的邮费模板:https://api.weixin.qq.com/merchant/express/getbyid?access_token=ACCESS_TOKEN</li>
 *     <li>3.5 获取所有邮费模板:https://api.weixin.qq.com/merchant/express/getall?access_token=ACCESS_TOKEN</li>
 *     <li>4.1 增加分组:https://api.weixin.qq.com/merchant/group/add?access_token=ACCESS_TOKEN</li>
 *     <li>4.2 删除分组:https://api.weixin.qq.com/merchant/group/del?access_token=ACCESS_TOKEN</li>
 *     <li>4.3 修改分组属性:https://api.weixin.qq.com/merchant/group/propertymod?access_token=ACCESS_TOKEN</li>
 *     <li>4.4 修改分组商品:https://api.weixin.qq.com/merchant/group/productmod?access_token=ACCESS_TOKEN</li>
 *     <li>4.5 获取所有分组:https://api.weixin.qq.com/merchant/group/getall?access_token=ACCESS_TOKEN</li>
 *     <li>4.6 根据分组ID获取分组信息:https://api.weixin.qq.com/merchant/group/getbyid?access_token=ACCESS_TOKEN</li>
 *     <li>5.1 增加货架:https://api.weixin.qq.com/merchant/shelf/add?access_token=ACCESS_TOKEN</li>
 *     <li>5.2 删除货架:https://api.weixin.qq.com/merchant/shelf/del?access_token=ACCESS_TOKEN</li>
 *     <li>5.3 修改货架:https://api.weixin.qq.com/merchant/shelf/mod?access_token=ACCESS_TOKEN</li>
 *     <li>5.4 获取所有货架:https://api.weixin.qq.com/merchant/shelf/getall?access_token=ACCESS_TOKEN</li>
 *     <li>5.5 根据货架ID获取货架信息:https://api.weixin.qq.com/merchant/shelf/getbyid?access_token=ACCESS_TOKEN</li>
 *     <li>6.2 根据订单ID获取订单详情:https://api.weixin.qq.com/merchant/order/getbyid?access_token=ACCESS_TOKEN</li>
 *     <li>6.3 根据订单状态/创建时间获取订单详情:https://api.weixin.qq.com/merchant/order/getbyfilter?access_token=ACCESS_TOKEN</li>
 *     <li>6.4 设置订单发货信息:https://api.weixin.qq.com/merchant/order/setdelivery?access_token=ACCESS_TOKEN</li>
 *     <li>6.5 关闭订单:https://api.weixin.qq.com/merchant/order/close?access_token=ACCESS_TOKEN</li>
 *     <li>7.1 上传图片:https://api.weixin.qq.com/merchant/common/upload_img?access_token=ACCESS_TOKEN&filename=test.png</li>
 * </ul>
 * TODO
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MerChantAPI extends BaseAPI{

    private final static Logger LOG = LoggerFactory.getLogger(MerChantAPI.class);

    public MerChantAPI(ApiConfig apiConfig) {
        super(apiConfig);
    }

    public MerChantAPI(String accessToken) {
        super(accessToken);
    }


    /**
     * 新增一个商品
     * @param request
     * @return response
     */
    public CreateGoodsResponse createGoods(CreateGoodsRequest request) {
        String url = APIAddress.GOODS_ADD_API;
        BaseResponse response = executePost(url, request.toJson());
        if (response == null)
            return null;
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return JSONUtil.parse(resultJson, CreateGoodsResponse.class);
    }

    public void deleteGoods(DeleteGoodsRequest request) {

    }

}
