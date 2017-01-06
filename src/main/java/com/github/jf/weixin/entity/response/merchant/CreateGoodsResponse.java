package com.github.jf.weixin.entity.response.merchant;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.response.BaseResponse;

/**
 * 创建商品返回报文<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CreateGoodsResponse extends BaseResponse{
    /**商品ID*/
    @JSONField(name="product_id")
    protected String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
