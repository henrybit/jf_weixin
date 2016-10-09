package com.github.jf.weixin.api.material;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.model.Article;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.material.DownloadMediaResponse;
import com.github.jf.weixin.entity.response.material.UploadImgResponse;
import com.github.jf.weixin.entity.response.material.UploadMediaResponse;
import com.github.jf.weixin.enums.MediaType;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.NetWorkCenter;
import com.github.jf.weixin.util.StreamUtil;

/**
 * 临时素材管理<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MediaAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(MediaAPI.class);

    public MediaAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 上传临时资源，会在微信服务器上保存3天，之后会被删除<br>
     * <ul>
     *     <label>支持资源类型:</label>
     *     <li>有图片（image）</li>
     *     <li>语音（voice）</li>
     *     <li>视频（video）</li>
     *     <li>缩略图（thumb）</li>
     * </ul>
     * @param type 资源类型
     * @param file 需要上传的文件
     * @return UploadMediaResponse-响应对象
     */
    public UploadMediaResponse uploadMedia(MediaType type, File file) {
        UploadMediaResponse response;
        String url = APIAddress.UPLOAD_TEMP_MEDIA_API.replace("TYPE", type.toString());
        BaseResponse r = executePost(url, null, file);
        response = JSONUtil.parse(r.getErrmsg(), UploadMediaResponse.class);
        return response;
    }

    /**
     * 上传群发文章素材。
     *
     * @param articles 上传的文章信息
     * @return 响应对象
     */
    public UploadMediaResponse uploadNews(List<Article> articles){
        UploadMediaResponse response;
        String url = APIAddress.MASS_UPLOAD_MESSAGE_IMAGE_NEWS_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("articles", articles);
        BaseResponse r = executePost(url, JSONUtil.toJson(params));
        response = JSONUtil.parse(r.getErrmsg(), UploadMediaResponse.class);
        return response;
    }

    /**
     * 上传群发消息图片素材 or 上传卡券相关的图片 or 上传门店图片<br>
     * @param file 素材文件
     * @return UploadImgResponse
     */
    public UploadImgResponse uploadImg(File file){
        UploadImgResponse response;
        String url = APIAddress.MASS_UPLOAD_MESSAGE_IMAGE_API;
        BaseResponse r = executePost(url, null, file);
        response = JSONUtil.parse(r.getErrmsg(), UploadImgResponse.class);
        return response;
    }

    /**
     * 下载资源，实现的很不好，反正能用了。搞的晕了，之后会优化
     *
     * @param mediaId 微信提供的资源唯一标识
     * @return 响应对象
     */
    public DownloadMediaResponse downloadMedia(String mediaId) {
        DownloadMediaResponse response = new DownloadMediaResponse();
        String url = APIAddress.GET_TEMP_MEDIA_API.replace("ACCESS_TOKEN", this.config.getAccessToken()).replace("MEDIA_ID", mediaId);
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(NetWorkCenter.CONNECT_TIMEOUT).setConnectTimeout(NetWorkCenter.CONNECT_TIMEOUT).setSocketTimeout(NetWorkCenter.CONNECT_TIMEOUT).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet get = new HttpGet(url);
        try {
            CloseableHttpResponse r = client.execute(get);
            if (HttpStatus.SC_OK == r.getStatusLine().getStatusCode()) {
                InputStream inputStream = r.getEntity().getContent();
                Header[] headers = r.getHeaders("Content-disposition");
                if (null != headers && 0 != headers.length) {
                    Header length = r.getHeaders("Content-Length")[0];
                    response.setContent(inputStream, Integer.valueOf(length.getValue()));
                    response.setFileName(headers[0].getElements()[0].getParameterByName("filename").getValue());
                } else {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    StreamUtil.copy(inputStream, out);
                    String json = out.toString();
                    response = JSONUtil.parse(json, DownloadMediaResponse.class);
                }
            }
        } catch (IOException e) {
            LOG.error("IO处理异常", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                LOG.error("异常", e);
            }
        }
        return response;
    }

}
