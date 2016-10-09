package com.github.jf.weixin.entity.model.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;
import com.github.jf.weixin.entity.model.other.NewsInfo;
import com.github.jf.weixin.enums.MenuType;
import com.github.jf.weixin.exception.WeixinException;

import java.util.List;

/**
 * 菜单按钮对象
 *
 * @author peiyu
 */
public class MenuButton extends BaseModel {

    /**
     * 菜单类别
     */
    @JSONField(name="type")
    private MenuType type;

    /**
     * 菜单上显示的文字
     */
    @JSONField(name="name")
    private String name;

    /**
     * 菜单key，当MenuType值为CLICK时用于区别菜单
     */
    @JSONField(name="key")
    private String key;

    /**
     * 菜单跳转的URL，当MenuType值为VIEW时用
     */
    @JSONField(name="url")
    private String url;

    /**
     * 菜单显示的永久素材的MaterialID,当MenuType值为media_id和view_limited时必需
     */
    @JSONField(name = "media_id")
    private String mediaId;

    /**
     * 二级菜单列表，每个一级菜单下最多5个
     */
    @JSONField(name = "sub_button")
    private List<MenuButton> subButton;

    @JSONField(name="value")
    private String value;

    @JSONField(name="news_info")
    private List<NewsInfo> newsInfos;

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public List<MenuButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<MenuButton> subButton) throws Exception{
        if (subButton!=null && subButton.size() > 5) {
            throw new WeixinException("子菜单最多只有5个");
        }
        this.subButton = subButton;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<NewsInfo> getNewsInfos() {
        return newsInfos;
    }

    public void setNewsInfos(List<NewsInfo> newsInfos) {
        this.newsInfos = newsInfos;
    }

    public MenuButton() {
    }

    public MenuButton(String name, String key, MenuType type) {
        this.name = name;
        this.key = key;
        this.type = type;
    }

    public MenuButton(String name, String key, MenuType type, List<MenuButton> buttons) {
        this(name, key, type);
        this.subButton = buttons;
    }

    public MenuButton(String name, String key, MenuType type, String url) {
        this(name, key, type);
        this.url = url;
    }

    public MenuButton(String name, String key, MenuType type, String url, List<MenuButton> buttons) {
        this(name, key, type, url);
        this.subButton = buttons;
    }


    public MenuButton(String name, String key, String mediaId, MenuType type) {
        this(name, key, type);
        this.mediaId = mediaId;
    }

    public MenuButton(String name, String key, String mediaid, MenuType type, List<MenuButton> buttons) {
        this(name, key, mediaid, type);
        this.subButton = buttons;
    }
}
