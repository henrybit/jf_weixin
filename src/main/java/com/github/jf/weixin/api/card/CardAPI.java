package com.github.jf.weixin.api.card;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.request.card.CreateCardRequest;
import com.github.jf.weixin.entity.request.card.SettingPaycellRequest;
import com.github.jf.weixin.entity.request.card.SettingSelfConsumeCellRequest;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.card.CreateCardResponse;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信卡券API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>创建卡券:https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN</li>
 *     <li>设置买单接口:https://api.weixin.qq.com/card/paycell/set?access_token=ACCESS_TOKEN</li>
 *     <li>设置自助核销接口:https://api.weixin.qq.com/card/selfconsumecell/set?access_token=ACCESS_TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CardAPI extends BaseAPI{

    private final static Logger LOG = LoggerFactory.getLogger(CardAPI.class);

    public CardAPI(ApiConfig apiConfig) {
        super(apiConfig);
    }


    /**
     * 创建卡券<br>
     * @param request 卡券数据
     * @return CreateCardResponse-返回报文
     */
    public CreateCardResponse createCard(CreateCardRequest request) {
        String url = APIAddress.WX_CARD_CREATE_API;
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(request));
            return (CreateCardResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置买单接口<br>
     * 创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持微信买单功能。值得开发者注意的是，设置买单的card_id必须已经配置了门店，否则会报错。
     * @param request 设置参数
     * @return ResultType-请求结果
     */
    public ResultType settingPayCell(SettingPaycellRequest request) {
        String url = APIAddress.WX_PAY_CELL_API;
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(request));
            return ResultType.get(response.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     *设置自助核销接口<br>
     * 创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持自助核销功能。值得开发者注意的是，设置自助核销的card_id必须已经配置了门店，否则会报错。
     * @param request 设置参数
     * @return ResultType-请求结果
     */
    public ResultType settingSelfConsumeCell(SettingSelfConsumeCellRequest request) {
        String url = APIAddress.WX_SELF_CONSUME_API;
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(request));
            return ResultType.get(response.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }
}
