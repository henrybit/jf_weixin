package com.github.jf.weixin.api.message;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.api.customservice.CustomerServiceAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.Industry;
import com.github.jf.weixin.entity.TemplateMsg;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.entity.response.AddTemplateResponse;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.message.SendTemplateResponse;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 模版消息API<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 * @deprecated 已在MessageAPI实现(除添加模板)
 */
@Deprecated
public class TemplateMsgAPI extends BaseAPI {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceAPI.class);

    public TemplateMsgAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 设置行业
     *
     * @param industry 行业参数
     * @return 操作结果
     */
    public ResultType setIndustry(Industry industry) {
        LOG.debug("设置行业......");
        BeanUtil.requireNonNull(industry, "行业对象为空");
        String url = APIAddress.TEMPLATE_SET_INDUSTRY_API;
        BaseResponse response = executePost(url, industry.toJsonString());
        return ResultType.get(response.getErrcode());
    }

    /**
     * 添加模版
     *
     * @param shortTemplateId 模版短id
     * @return 操作结果
     */
    public AddTemplateResponse addTemplate(String shortTemplateId) {
        LOG.debug("获取模版id......");
        BeanUtil.requireNonNull(shortTemplateId, "短模版id必填");
        String url = APIAddress.TEMPLATE_ADD_API;
        Map<String, String> params = new HashMap<String, String>();
        params.put("template_id_short", shortTemplateId);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        AddTemplateResponse result = JSONUtil.parse(resultJson, AddTemplateResponse.class);
        return result;
    }

    /**
     * 发送模版消息
     *
     * @param msg 消息
     * @return 发送结果
     */
    public SendTemplateResponse send(TemplateMsg msg) {

        LOG.debug("获取模版id......");
        BeanUtil.requireNonNull(msg.getTouser(), "openid is null");
        BeanUtil.requireNonNull(msg.getTemplateId(), "template_id is null");
        BeanUtil.requireNonNull(msg.getData(), "data is null");
        BeanUtil.requireNonNull(msg.getTopcolor(), "top color is null");
        BeanUtil.requireNonNull(msg.getUrl(), "url is null");
        String url = APIAddress.TEMPLATE_SEND_MESSAGE_API;
        BaseResponse r = executePost(url, msg.toJsonString());
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        SendTemplateResponse result = JSONUtil.parse(resultJson, SendTemplateResponse.class);
        return result;
    }


}
