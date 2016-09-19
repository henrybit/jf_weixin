package com.github.jf.weixin.util;

/**
 * 用于XML数据封装<br>
 * @author peiyu,henrybit
 * @since 1.3
 */
public class MessageBuilder {

    private StringBuilder builder;

    public MessageBuilder() {
        builder = new StringBuilder();
    }

    public MessageBuilder(int capacity) {
        builder = new StringBuilder(capacity);
    }

    public MessageBuilder(String str) {
        builder = new StringBuilder(str);
    }

    public void append(String str) {
        builder.append(str);
    }

    public void insert(String str) {
        builder.insert(0, str);
    }

    public void surroundWith(String tag) {
        StringBuilder sb = new StringBuilder(builder.capacity() + tag.length()
                * 2 + 5);
        sb.append("<").append(tag).append(">\n").append(builder).append("</")
                .append(tag).append(">\n");
        builder = sb;
    }

    /**
     * 添加Xml中数据项，无CDATA[]
     * @param tagName 字段名
     * @param text 字段内容
     */
    public void addTag(String tagName, String text) {
        if (text == null) {
            return;
        }
        builder.append("<").append(tagName).append(">").append(text)
                .append("</").append(tagName).append(">\n");
    }

    /**
     * 添加XML中数据项，字段内容通过CDATA[]封装
     * @param tagName 字段名
     * @param data 字段内容
     */
    public void addData(String tagName, String data) {
        if (data == null) {
            return;
        }
        builder.append("<").append(tagName).append("><![CDATA[").append(data)
                .append("]]></").append(tagName).append(">\n");
    }

    @Override
    public String toString() {
        return builder.toString();
    }

}
