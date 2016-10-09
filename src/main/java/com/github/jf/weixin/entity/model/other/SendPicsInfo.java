package com.github.jf.weixin.entity.model.other;

import com.github.jf.weixin.annotation.XmlField;

import java.util.List;

/**
 * 发送的图片信息<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class SendPicsInfo {
    @XmlField(name="Count")
    private int count;
    @XmlField(name="PicList")
    private Picture picture;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public static class Picture {
        @XmlField(name="item")
        protected List<Item> item;

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }
    }

    public static class Item {
        @XmlField(name="PicMd5Sum")
        private String picMd5Sum;

        public String getPicMd5Sum() {
            return picMd5Sum;
        }

        public void setPicMd5Sum(String picMd5Sum) {
            this.picMd5Sum = picMd5Sum;
        }
    }
}
