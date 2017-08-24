package com.github.jf.weixin.api.material;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jf.weixin.entity.response.material.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.Article;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.enums.MaterialType;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.NetWorkCenter;
import com.github.jf.weixin.util.StringUtil;


/**
 * 永久素材管理相关<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MaterialAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(MaterialAPI.class);

    public MaterialAPI(ApiConfig config) {
        super(config);
    }

    public MaterialAPI(String accessToken) {
        super(accessToken);
    }

    /**
     * 上传永久素材<br>
     * 只支持Image/Voice/Video/thumb这四种，News的请访问专门的方法uploadMaterialNews
     * @param file 素材本地路径指向
     * @param materialtype 素材类型
     * @return UploadMaterialResponse
     */
    public UploadMaterialResponse uploadMaterialFile(File file, MaterialType materialtype) {
    	if (materialtype == MaterialType.NEWS)
    		return null;
    	UploadMaterialResponse response;
    	String url = APIAddress.UPLOAD_MATERIAL_OTHER_API;
        BaseResponse r;
        final Map<String, String> param = new HashMap<String, String>();
        param.put("type", materialtype.toString());
        if (materialtype == MaterialType.VIDEO) {
        	param.put("title", System.currentTimeMillis()+"");
            param.put("introduction", file.getName());
        }
        r = executePost(url, JSONUtil.toJson(param), file);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, UploadMaterialResponse.class);
        return response;
    }
    
    /**
     * 上传永久图片素材文件。图片素材上限为5000，其他类型为1000
     * @param file 素材文件
     * @return UploadMaterialResponse-上传结果
     */
    public UploadMaterialResponse uploadImageMaterialFile(File file){
        return uploadMaterialFile(file, MaterialType.IMAGE);
    }
    
    /**
     * 上传永久音频素材文件
     * @param file 素材文件
     * @return UploadMaterialResponse-上传结果
     */
    public UploadMaterialResponse uploadVoiceMaterialFile(File file) {
    	return uploadMaterialFile(file, MaterialType.VOICE);
    }
    
    /**
     * 上传永久视频素材<br>
     * @param file 素材文件
     * @return UploadMaterialResponse-上传结果
     */
    public UploadMaterialResponse uploadVideoMaterialFile(File file) {
    	return uploadMaterialFile(file, MaterialType.VIDEO);
    }
    
    /**
     * 上传永久缩略图素材<br>
     * @param file 素材文件
     * @return UploadMaterialResponse-上传结果
     */
    public UploadMaterialResponse uploadThumbMaterialFile(File file) {
    	return uploadMaterialFile(file, MaterialType.THUMB);
    }

    /**
     * 上传永久视频素材文件。
     * @param file 素材文件
     * @param title 素材标题
     * @param introduction 素材描述信息
     * @return 上传结果
     */
    public UploadMaterialResponse uploadVideoMaterialFile(File file, String title, String introduction){
        UploadMaterialResponse response;
        String url = APIAddress.UPLOAD_MATERIAL_OTHER_API;
        BaseResponse r;
        final Map<String, String> param = new HashMap<String, String>();
        param.put("title", title);
        param.put("introduction", introduction);
        r = executePost(url, JSONUtil.toJson(param), file);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, UploadMaterialResponse.class);
        return response;
    }

    /**
     * 上传图文消息素材中视频素材<br>
     * 此处media_id需通过基础支持中的上传下载多媒体文件来得到<br>
     * <pre>
     * POST范例:
     * {"media_id": "rF4UdIMfYK3efUfyoddYRMU50zMiRmmt_l0kszupYh_SzrcW5Gaheq05p_lHuOTQ","title": "TITLE","description": "Description"}
     * </pre>
     * @param mediaId 素材ID
     * @param title 素材恩荣
     * @param description 素材描述
     * @return UploadVideoResponse-上传结果返回
     */
    public UploadVideoResponse uploadVideo(String mediaId, String title, String description) {
        String url = APIAddress.UPLOAD_MATERIAL_VIDEO_API;
        HashMap<String, Object> params = new HashMap<String, Object>();
        try {
            params.put("media_id", mediaId);
            params.put("title", title);
            params.put("description", description);
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return (UploadVideoResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传图文消息素材
     * @param articles 图文消息列表
     * @return 上传结果
     */
    public UploadMaterialResponse uploadMaterialNews(List<Article> articles){
        UploadMaterialResponse response;
        String url = APIAddress.UPLOAD_MATERIAL_NEWS_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("articles", articles);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, UploadMaterialResponse.class);
        return response;
    }

    /**
     * 下载永久素材
     * @param mediaId 素材ID
     * @param type 素材类型
     * @return 下载结果
     */
    public GetMaterialResponse getMaterial(String mediaId, MaterialType type){
        GetMaterialResponse response = new GetMaterialResponse();
        String url = APIAddress.GET_MATERIAL_API; 
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(NetWorkCenter.CONNECT_TIMEOUT).setConnectTimeout(NetWorkCenter.CONNECT_TIMEOUT).setSocketTimeout(NetWorkCenter.CONNECT_TIMEOUT).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpPost request = new HttpPost(url);
        StringEntity mediaEntity = new StringEntity("{\"media_id\":\"" + mediaId + "\"}", ContentType.APPLICATION_JSON);
        request.setEntity(mediaEntity);

        CloseableHttpResponse httpResponse = null;
        try{
            httpResponse = client.execute(request);
            if(HttpStatus.SC_OK == httpResponse.getStatusLine().getStatusCode()){
                HttpEntity entity;
                String resultJson;
                switch (type){
                    case NEWS:
                        entity = httpResponse.getEntity();
                        resultJson = EntityUtils.toString(entity, Charset.forName("UTF-8"));
                        response = JSONUtil.parse(resultJson, GetMaterialResponse.class);
                        LOG.debug("-----------------请求成功-----------------");
                        LOG.debug("响应结果:");
                        LOG.debug(resultJson);
                        if (StringUtil.isBlank(response.getErrcode())) {
                            response.setErrcode("0");
                            response.setErrmsg(resultJson);
                        }
                        break;
                    case VIDEO:
                        entity = httpResponse.getEntity();
                        resultJson = EntityUtils.toString(entity, Charset.forName("UTF-8"));
                        LOG.debug("-----------------请求成功-----------------");
                        LOG.debug("响应结果:");
                        LOG.debug(resultJson);
                        response = JSONUtil.parse(resultJson, GetMaterialResponse.class);
                        if (StringUtil.isBlank(response.getErrcode())) {
                            response.setErrcode("0");
                            response.setErrmsg(resultJson);
                            // 通过down_url下载文件。文件放置在content中。通过writeTo方法获取
                            downloadVideo(response);
                        }
                        break;
                    default:
                        Header length = httpResponse.getHeaders("Content-Length")[0];
                        InputStream inputStream = httpResponse.getEntity().getContent();
                        response.setContent(inputStream, Integer.valueOf(length.getValue()));
                        break;
                }
            }else{
                response.setErrcode(String.valueOf(httpResponse.getStatusLine().getStatusCode()));
                response.setErrmsg("请求失败");
            }
        } catch (IOException e) {
            LOG.error("IO流异常", e);
        } catch (Exception e) {
            LOG.error("其他异常", e);
        }

        return response;
    }


    /**
     * 更新一个指定的图文素材<br>
     * @param mediaId 素材ID
     * @param article 素材更新内容
     * @return ResultType-更新结果
     */
    public ResultType updateMaterial(String mediaId, Article article) {
        return updateMaterial(mediaId, article, 0);
    }

    /**
     * 更新一个指定的图文素材<br>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
     *     <tr><td> media_id</td><td> 是</td><td> 要修改的图文消息的id</td></tr>
     *     <tr><td> index</td><td> 是</td><td> 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0</td></tr>
     *     <tr><td> title</td><td> 是</td><td> 标题</td></tr>
     *     <tr><td> thumb_media_id</td><td> 是</td><td> 图文消息的封面图片素材id（必须是永久mediaID）</td></tr>
     *     <tr><td> author</td><td> 是</td><td> 作者</td></tr>
     *     <tr><td> digest</td><td> 是</td><td> 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空</td></tr>
     *     <tr><td> show_cover_pic</td><td> 是</td><td> 是否显示封面，0为false，即不显示，1为true，即显示</td></tr>
     *     <tr><td> content</td><td> 是</td><td> 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS</td></tr>
     *     <tr><td> content_source_url</td><td> 是</td><td> 图文消息的原文地址，即点击“阅读原文”后的URL</td></tr>
     * </tbody></table>
     * @param mediaId 媒体编号
     * @param article 更新内容
     * @param index 序列位置
     * @return ResultType-更新结果
     */
    public ResultType updateMaterial(String mediaId, Article article, int index) {
        String url = APIAddress.UPDATE_MATERIAL_NEWS_API;
        HashMap<String, Object> params = new HashMap<String, Object>();
        try {
            params.put("media_id", mediaId);
            params.put("articles", article);
            params.put("index", index);
            BaseResponse baseResponse = executePost(url, JSONUtil.toJson(params));
            return ResultType.get(baseResponse.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     * 获取已创建永久素材的数量
     * @return 永久素材数量结果
     */
    public GetMaterialTotalCountResponse countMaterial(){
        GetMaterialTotalCountResponse response = null;
        String url = APIAddress.GET_MATERIAL_COUNT_API;
        BaseResponse r = executeGet(url);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetMaterialTotalCountResponse.class);
        return response;
    }

    /**
     * 获取素材列表
     * @param type 素材类型
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return 素材列表结果
     */
    public GetMaterialListResponse batchGetMaterial(MaterialType type, int offset, int count){
        if(offset < 0) offset = 0;
        if(count > 20) count = 20;
        if(count < 1) count = 1;

        GetMaterialListResponse response = null;
        String url = APIAddress.GET_MATERIAL_LIST_API;
        final Map<String, Object> params = new HashMap<String, Object>(4, 1);
        params.put("type", type.toString());
        params.put("offset", offset);
        params.put("count", count);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetMaterialListResponse.class);

        return response;
    }

    /**
     * 删除一个永久素材
     * @param mediaId 素材ID
     * @return 删除结果
     */
    public ResultType deleteMaterial(String mediaId) {
        String url = APIAddress.DELETE_MATERIAL_API;
        final Map<String, String> param = new HashMap<String, String>();
        param.put("media_id", mediaId);
        BaseResponse response = executePost(url, JSONUtil.toJson(param));
        return ResultType.get(response.getErrcode());
    }

    private void downloadVideo(GetMaterialResponse response){
        String url = response.getDownUrl();
        LOG.debug("Download url: " + url);
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(NetWorkCenter.CONNECT_TIMEOUT).setConnectTimeout(NetWorkCenter.CONNECT_TIMEOUT).setSocketTimeout(NetWorkCenter.CONNECT_TIMEOUT).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet get = new HttpGet(url);
        try {
            CloseableHttpResponse r = client.execute(get);
            if (HttpStatus.SC_OK == r.getStatusLine().getStatusCode()) {
                InputStream inputStream = r.getEntity().getContent();
                Header[] headers = r.getHeaders("Content-disposition");
                Header length = r.getHeaders("Content-Length")[0];
                response.setContent(inputStream, Integer.valueOf(length.getValue()));
                response.setFileName(headers[0].getElements()[0].getParameterByName("filename").getValue());
            }
        } catch (IOException e){
            LOG.error("IO异常处理", e);
        } catch (Exception e) {
            LOG.error("其他异常", e);
        }
    }
}
