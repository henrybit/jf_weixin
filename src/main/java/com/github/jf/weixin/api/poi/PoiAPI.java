package com.github.jf.weixin.api.poi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jf.weixin.entity.model.poi.PoiCategory;
import com.github.jf.weixin.entity.request.poi.UpdatePoiRequest;
import com.github.jf.weixin.entity.response.poi.GetPoiCategoryResponse;
import com.github.jf.weixin.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.request.poi.CreatePoiRequest;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.poi.GetPoiListResponse;
import com.github.jf.weixin.entity.response.poi.GetPoiResponse;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.JSONUtil;

/**
 * 微信门店API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>创建门店:http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=ACCESS_TOKEN</li>
 *     <li>查询门店信息:http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=ACCESS_TOKEN</li>
 *     <li>查询门店列表:https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=ACCESS_TOKEN</li>
 *     <li>修改门店服务信息:https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=ACCESS_TOKEN</li>
 *     <li>删除门店:https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=ACCESS_TOKEN</li>
 *     <li>门店类目表:http://api.weixin.qq.com/cgi-bin/poi/getwxcategory?access_token=ACCESS_TOKEN</li>
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

    public PoiAPI(String accessToken) {
        super(accessToken);
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
    
    /**
     * 获取门店信息<br>
     * @param poiId 门店ID
     * @return GetPoiResponse-门店信息
     */
    public GetPoiResponse getPoi(String poiId) {
    	String url = APIAddress.GET_POI_INFO_API;
    	try {
    		Map<String, Object> param = new HashMap<String, Object>();
            param.put("poi_id", poiId);
            BaseResponse r = executePost(url, JSONUtil.toJson(param));
            return (GetPoiResponse)r;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    /**
     * 获取门店列表<br>
     * @param begin 开始位置
     * @param limit 一次查询数量
     * @return GetPoiListResponse-返回报文
     */
    public GetPoiListResponse getPoiList(int begin, int limit) {
    	String url = APIAddress.GET_POI_LIST_API;
    	try {
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("begin", begin);
    		param.put("limit", limit);
    		BaseResponse r = executePost(url, JSONUtil.toJson(param));
            return (GetPoiListResponse)r;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }

    /**
     * 更新门店信息<br>
     * @param request 更新内容
     * @return ResultType-更新结果
     */
    public ResultType updatePoi(UpdatePoiRequest request) {
        String url = APIAddress.UPDATE_POI_INFO_API;
        try {
            if (request == null) return ResultType.REQUEST_PARAM_NULL;
            BaseResponse r = executePost(url, JSONUtil.toJson(request));
            return ResultType.get(r.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     * 删除门店信息<br>
     * @param poiId 门店ID
     * @return ResultType-删除结果
     */
    public ResultType deletePoi(String poiId) {
        String url = APIAddress.DELETE_POI_API;
        try {
            if (StringUtil.isBlank(poiId)) return ResultType.REQUEST_PARAM_NULL;
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("poi_id", poiId);
            BaseResponse r = executePost(url, JSONUtil.toJson(param));
            return ResultType.get(r.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     * 门店类目表<br>
     * @return GetPoiCategoryResponse-门店类目返回报文
     */
    public GetPoiCategoryResponse getPoiCategory() {
        String url = APIAddress.GET_POI_CATEGORY_API;
        try {
            BaseResponse r = executePost(url, null);
            GetPoiCategoryResponse response = (GetPoiCategoryResponse)r;
            List<String> list = response.getPoiCategorys();
            List<PoiCategory> poiCategoryList = new ArrayList<PoiCategory>();
            for (int i=0; list!=null&&i<list.size(); i++) {
                String category = list.get(i);
                String[] array = category.split(",");

                if (array != null) {
                    PoiCategory poiCategory = new PoiCategory(array);
                    poiCategoryList.add(poiCategory);
                }
            }
            response.setPoiCategoryList(poiCategoryList);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
