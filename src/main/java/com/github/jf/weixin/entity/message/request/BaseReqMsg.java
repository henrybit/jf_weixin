package com.github.jf.weixin.entity.message.request;

import com.github.jf.weixin.enums.MessageType;

/**
 * 发送消息内容的基类
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public abstract class BaseReqMsg extends BaseReq{
    //接收消息的普通用户openid
    protected String toUser;
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
    protected MessageType msgType;
}
