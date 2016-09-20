package com.github.jf.weixin.entity.message.request;

import com.github.jf.weixin.enums.MessageType;
import com.github.jf.weixin.util.JSONUtil;

import java.util.HashMap;

/**
 * 发送客服消息请求内容<br>
 *     <h2>消息Body说明</h2>
 * <table style="border:1px solid" border="1">
 *   <tbody>
 *    <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
 *    <tr><td> access_token</td><td> 是</td><td> 调用接口凭证</td></tr>
 *    <tr><td> touser</td><td> 是</td><td> 普通用户openid</td></tr>
 *    <tr><td> msgtype</td><td> 是</td><td> 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard</td></tr>
 *    <tr><td> content</td><td> 是</td><td> 文本消息内容</td></tr>
 *    <tr><td> media_id</td><td> 是</td><td> 发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID</td></tr>
 *    <tr><td> thumb_media_id</td><td> 是</td><td> 缩略图的媒体ID</td></tr>
 *    <tr><td> title</td><td> 否</td><td> 图文消息/视频消息/音乐消息的标题</td></tr>
 *    <tr><td> description</td><td> 否</td><td> 图文消息/视频消息/音乐消息的描述</td></tr>
 *    <tr><td> musicurl</td><td> 是</td><td> 音乐链接</td></tr>
 *    <tr><td> hqmusicurl</td><td> 是</td><td> 高品质音乐链接，wifi环境优先使用该链接播放音乐</td></tr>
 *    <tr><td> url</td><td> 否</td><td> 图文消息被点击后跳转的链接</td></tr>
 *    <tr><td> picurl</td><td> 否</td><td> 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80</td></tr>
 *   </tbody>
 * </table>
 *     <h2>消息类型说明</h2>
 * <table style="border:1px solid" border="1">
 *     <tr><th>消息类型</th><th>请求参数</th></tr>
 *     <tr><td>文本消息</td><td>{ "touser":"OPENID","msgtype":"text","text":{"content":"Hello World"}}</td></tr>
 *     <tr><td>图片消息</td><td>{"touser":"OPENID","msgtype":"image","image":{"media_id":"MEDIA_ID"}}</td></tr>
 *     <tr><td>语音消息</td><td>{"touser":"OPENID","msgtype":"voice","voice":{"media_id":"MEDIA_ID"}}</td></tr>
 *     <tr><td>视频消息</td><td>{"touser":"OPENID","msgtype":"video","video":{"media_id":"MEDIA_ID","thumb_media_id":"MEDIA_ID","title":"TITLE","description":"DESCRIPTION"}}</td></tr>
 *     <tr><td>音乐消息</td><td>{"touser":"OPENID","msgtype":"music","music":{"title":"MUSIC_TITLE","description":"MUSIC_DESCRIPTION","musicurl":"MUSIC_URL","hqmusicurl":"HQ_MUSIC_URL","thumb_media_id":"THUMB_MEDIA_ID"}}</td></tr>
 *     <tr><td>图文消息（点击跳转到外链） 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应。</td><td>{"touser":"OPENID","msgtype":"news","news":{"articles": [{"title":"Happy Day","description":"Is Really A Happy Day","url":"URL","picurl":"PIC_URL"},{"title":"Happy Day","description":"Is Really A Happy Day","url":"URL","picurl":"PIC_URL"}]}}</td></tr>
 *     <tr><td>图文消息（点击跳转到图文消息页面） 图文消息条数限制在8条以内，注意，如果图文数超过8，则将会无响应。</td><td>{"touser":"OPENID","msgtype":"mpnews","mpnews":{"media_id":"MEDIA_ID"}}</td></tr>
 *     <tr><td>卡券</td><td>{"touser":"OPENID","msgtype":"wxcard","wxcard":{"card_id":"123dsdajkasd231jhksad","card_ext": "{\"code\":\"\",\"openid\":\"\",\"timestamp\":\"1402057159\",\"signature\":\"017bb17407c8e0058a66d72dcc61632b70f511ad\"}"},}</td></tr>
 *     <tr><td>特殊：增加指定客服信息</td><td>{"touser":"OPENID","msgtype":"text","text":{"content":"Hello World"},"customservice":{"kf_account": "test1@kftest"}}</td></tr>
 *  </table>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class CustomerServiceMessage extends BaseReqMsg{
    //接收消息的普通用户openid
    protected String toUser;
    //消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
    protected MessageType msgType;
    //消息内容对象
    protected Object msgBody;

    /**
     * 客服消息<br>
     * @param toUser 接收方
     * @param msgType 消息类型
     */
    public CustomerServiceMessage(String toUser, MessageType msgType) {
        this(msgType);
        this.toUser = toUser;
    }

    /**
     * 客服消息<br>
     * @param msgType 消息类型
     */
    public CustomerServiceMessage(MessageType msgType) {
        switch (msgType) {
            case IMAGE:
                msgBody = new ImageMessage();
                break;
            case TEXT:
                msgBody = new TextMessage();
                break;
            case MUSIC:
                msgBody = new MusicMessage();
                break;
            case NEWS:
                msgBody = new NewsMessage();
                break;
            case VIDEO:
                msgBody = new VideoMessage();
                break;
            case VOICE:
                msgBody = new VoiceMessage();
                break;
            case MPNEWS:
                msgBody = new MPNewsMessage();
                break;
            case WXCARD:
                msgBody = new WXCardMessage();
                break;
        }
    }

    @Override
    public String toJson() {
        HashMap<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("touser",this.toUser);
        jsonMap.put("msgtype",this.msgType.toString());
        switch (msgType) {
            case IMAGE:
                jsonMap.put("image",msgBody.toString());
                break;
            case TEXT:
                jsonMap.put("text",msgBody.toString());
                break;
            case MUSIC:
                jsonMap.put("music",msgBody.toString());
                break;
            case NEWS:
                jsonMap.put("news",msgBody.toString());
                break;
            case MPNEWS:
                jsonMap.put("mpnews",msgBody.toString());
                break;
            case VIDEO:
                jsonMap.put("video",msgBody.toString());
                break;
            case VOICE:
                jsonMap.put("voice",msgBody.toString());
                break;
            case WXCARD:
                jsonMap.put("wxcard",msgBody.toString());
                break;
        }
        return JSONUtil.toJson(jsonMap);
    }
}
