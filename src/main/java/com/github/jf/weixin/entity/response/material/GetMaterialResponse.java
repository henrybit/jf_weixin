package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Article;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.util.StreamUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * 获取永久素材返回报文<br>
 *  @author henrybit
 *  @since 2.0
 *  @version 2.0
 */
public class GetMaterialResponse extends BaseResponse {

    private static final Logger LOG = LoggerFactory.getLogger(GetMaterialResponse.class);

    // 当素材是图文素材的时候
    @JSONField(name="news_item")
    private List<Article> news;

    // 当素材是视频素材的时候
    @JSONField(name="title")
    private String title;
    @JSONField(name="description")
    private String description;
    @JSONField(name="down_url")
    private String downUrl;

    @JSONField(name="content")
    private byte[] content;
    @JSONField(name="fileName")
    private String fileName;

    public List<Article> getNews() {
        return news;
    }

    public void setNews(List<Article> news) {
        this.news = news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(InputStream content, int length){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            StreamUtil.copy(content, byteArrayOutputStream);
            byte[] temp = byteArrayOutputStream.toByteArray();
            if (temp.length > length) {
                this.content = new byte[length];
                for (int i = 0; i < length; i++) {
                    this.content[i] = temp[i];
                }
            } else {
                this.content = temp;
            }
        } catch (IOException e) {
            LOG.error("异常", e);
        }

    }

    /**
     * 如果成功，则可以靠这个方法将数据输出
     *
     * @param out 调用者给的输出流
     * @throws IOException 写流出现异常
     */
    public void writeTo(OutputStream out) throws IOException{
        out.write(this.content);
        out.flush();
        out.close();
    }
}
