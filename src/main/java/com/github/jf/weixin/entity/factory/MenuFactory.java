package com.github.jf.weixin.entity.factory;

import com.github.jf.weixin.entity.menu.Menu;
import com.github.jf.weixin.entity.menu.MenuButton;
import com.github.jf.weixin.enums.MenuType;

import java.util.List;

/**
 * 自定义菜单创建工厂<br>
 * <pre>
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * </pre>
 * <ul>
 *     <label>支持多种自定义菜单创建</label>
 *     <li>
 *         <h3>1、click：点击推事件</h3>
 *         用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event	的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，开发者可以通过自定义的key值与用户进行交互；
        </li>
        <li>
           <h3>2、view：跳转URL</h3>
            用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
        </li>
        <li>
            <h3>3、scancode_push：扫码推事件</h3>
            用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
        </li>
        <li>
            <h3>4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框</h3>
            用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
        </li>
        <li>
            <h3>5、pic_sysphoto：弹出系统拍照发图</h3>
            用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
        </li>
        <li>
            <h3>6、pic_photo_or_album：弹出拍照或者相册发图</h3>
            用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
        </li>
        <li>
            <h3>7、pic_weixin：弹出微信相册发图器</h3>
            用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
        </li>
        <li>
            <h3>8、location_select：弹出地理位置选择器</h3>
            用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
        </li>
        <li>
            <h3>9、media_id：下发消息（除文本消息）</h3>
            用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材id对应的素材下发给用户，永久素材类型可以是图片、音频、视频、图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
        </li>
        <li>
            <h3>10、view_limited：跳转图文消息URL</h3>
            用户点击view_limited类型按钮后，微信客户端将打开开发者在按钮中填写的永久素材id对应的图文消息URL，永久素材类型只支持图文消息。请注意：永久素材id必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
 *     </li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class MenuFactory {

    /**
     * 创建自定义菜单<br>
     * @param buttons 菜单目录列表
     * @return Menu
     */
    public static Menu createMenu(List<MenuButton> buttons) {
        Menu menu = new Menu();
        menu.setButtons(buttons);
        return menu;
    }

    /**
     * 创建自定义菜单项<br>
     * <ul>
     *     <li>VIEW菜单时,将启用第四个数组参数,数组[0]是URL</li>
     *     <li>MEDIA_ID或VIEW_LIMITED菜单时,将启用第四个数组参数,数组[0]是Menu_id</li>
     * </ul>
     * @param name 菜单名
     * @param key 菜单编号
     * @param menuType 菜单类型
     * @param array 其他描述信息
     * @return MenuButton-自定义菜单项
     */
    public static MenuButton createMenuButton(String name, String key, MenuType menuType, String... array) {
        switch (menuType) {
            case CLICK:
                return new MenuButton(name, key, menuType);
            case VIEW:
                return new MenuButton(name, key, menuType, array[0]);
            case SCANCODE_PUSH:
                return new MenuButton(name, key, menuType);
            case SCANCODE_WAITMSG:
                return new MenuButton(name, key, menuType);
            case PIC_SYSPHOTO:
                return new MenuButton(name, key, menuType);
            case PIC_PHOTO_OR_ALBUM:
                return new MenuButton(name, key, menuType);
            case PIC_WEIXIN:
                return new MenuButton(name, key, menuType);
            case LOCATION_SELECT:
                return new MenuButton(name, key, menuType);
            case MEDIA_ID:
                return new MenuButton(name, key, array[0], menuType);
            case VIEW_LIMITED:
                return new MenuButton(name, key, array[0], menuType);
        }
        return null;
    }

}
