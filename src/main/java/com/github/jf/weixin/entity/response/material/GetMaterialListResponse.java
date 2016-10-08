package com.github.jf.weixin.entity.response.material;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.Article;
import com.github.jf.weixin.entity.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *  获取永久素材列表返回报文<br>
 *  @author henrybit
 *  @since 2.0
 *  @version 2.0
 */
public class GetMaterialListResponse extends BaseResponse {

    private static final Logger LOG = LoggerFactory.getLogger(GetMaterialListResponse.class);

    @JSONField(name="total_count")
    private int totalCount;// 该类型素材总数
    @JSONField(name="item_count")
    private int itemCount;// 本次获取的数量
    @JSONField(name="item")
    private List<ItemInfo> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<ItemInfo> getItems() {
        return items;
    }

    public void setItems(List<ItemInfo> items) {
        this.items = items;
    }

    public static class ItemInfo {
        @JSONField(name="media_id")
        protected String mediaId;
        @JSONField(name="update_time")
        protected long updateTime;
        @JSONField(name="content")
        protected ItemContent content;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public ItemContent getContent() {
            return content;
        }

        public void setContent(ItemContent content) {
            this.content = content;
        }
    }

    public static class ItemContent {
        @JSONField(name="news_item")
        protected List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }
}
