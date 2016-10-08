package com.github.jf.weixin.entity.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.jf.weixin.entity.model.BaseModel;
import com.github.jf.weixin.exception.WeixinException;

import java.util.List;

/**
 * 菜单对象，包含所有菜单按钮
 *
 * @author peiyu
 */
public class Menu extends BaseModel {

    /**
     * 一级菜单列表，最多3个
     */
    @JSONField(name="button")
    private List<MenuButton> buttons;

    /**
     * 菜单匹配规则
     *
     * @since 1.3.7
     */
    @JSONField(name="matchrule")
    private Matchrule matchrule;

    /**
     * 菜单ID，查询时会返回，删除个性化菜单时会用到
     *
     * @since 1.3.7
     */
    @JSONField(name = "menuid")
    private String menuId;

    public List<MenuButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<MenuButton> buttons) {
        if (null == buttons || buttons.size() > 3) {
            throw new WeixinException("主菜单最多3个");
        }
        this.buttons = buttons;
    }

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
