package com.github.jf.weixin.entity.message.recevice;

import com.github.jf.weixin.entity.message.MessageType;

/**
 * 接收到的消息类型<br>
 * <ul>
 *     <li>音乐：MUSIC</li>
 *     <li>新闻：NEWS</li>
 * </ul>
 * @author peiyu, henrybit
 * @since 1.3
 * @version 2.0
 */
public class ReceviceType extends MessageType{

    /**普通消息 start*/
    //链接消息
    public static final String LINK = "link";
    //地理位置消息
    public static final String LOCATION = "location";
    //小视频消息
    public static final String SHORT_VIDEO = "shortvideo";
    /**普通消息 end*/

    /**事件推送 start*/
    //关注/取消关注事件、扫描带参数二维码事件、上报地理位置事件、自定义菜单事件
    public static final String EVENT = "event";
    /**事件推送 end*/

    /**被动回复用户消息 start*/
    //音乐
    public static final String MUSIC = "music";
    //新闻
    public static final String NEWS = "news";
    /**被动回复用户消息 end*/

    public static final String KF = "transfer_customer_service";

}
