package com.github.jf.weixin.api.poi;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.poi.PoiInfo;
import com.github.jf.weixin.entity.request.poi.CreatePoiRequest;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信门店API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>创建门店:http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=TOKEN</li>
 *     <li>查询门店信息:http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=TOKEN</li>
 *     <li>查询门店列表:https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=TOKEN</li>
 *     <li>修改门店服务信息:https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=TOKEN</li>
 *     <li>删除门店:https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=TOKEN</li>
 *     <li>门店类目表:http://api.weixin.qq.com/cgi-bin/poi/getwxcategory?access_token=TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class PoiAPI extends BaseAPI{
    private static final Logger LOG = LoggerFactory.getLogger(PoiAPI.class);

    /**
     * 构造方法，设置apiConfig<br>
     * @param config 微信API配置对象
     */
    public PoiAPI(ApiConfig config) {
        super(config);
    }


    /**
     * 创建门店信息<br>
     * @param request 门店信息JSON参数对象
     * @return ResultType-创建结果
     */
    public ResultType createPoi(CreatePoiRequest request) {
        String url = APIAddress.CREATE_POI_API;
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("business", request);
            BaseResponse r = executePost(url, JSONUtil.toJson(param));
            return ResultType.get(r.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }
}
