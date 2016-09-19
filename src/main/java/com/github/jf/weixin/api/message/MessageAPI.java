package com.github.jf.weixin.api.message;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.entity.message.recevice.*;
import com.github.jf.weixin.entity.message.request.OldArticle;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.entity.response.GetSendMessageResponse;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信-消息管理相关API
 * <table style="border:1px solid" border="1">
 *     <tr>
 *         <th>接口</th><th>接口地址</th><th>接口说明</th>
 *     </tr>
 *     <tr>
 *         <td>接收消息-接收普通消息</td><td>-</td><td>当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上；详情<a href="https://mp.weixin.qq.com/wiki/17/f298879f8fb29ab98b2f2971d42552fd.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>接收消息-接收事件推送</td><td>-</td><td>在微信用户和公众号产生交互的过程中，用户的某些操作会使得微信服务器通过事件推送的形式通知到开发者在开发者中心处设置的服务器地址，从而开发者可以获取到该信息。其中，某些事件推送在发生后，是允许开发者回复用户的，某些则不允许，详细说明请见本页末尾的微信推送消息与事件说明；详情<a href="https://mp.weixin.qq.com/wiki/7/9f89d962eba4c5924ed95b513ba69d9b.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>发送消息-被动回复消息</td><td>-</td><td>当用户发送消息给公众号时（或某些特定的用户操作引发的事件推送时），会产生一个POST请求，开发者可以在响应包（Get）中返回特定XML结构，来对该消息进行响应（现支持回复文本、图片、图文、语音、视频、音乐）。严格来说，发送被动响应消息其实并不是一种接口，而是对微信服务器发过来消息的一次回复；详情<a href="https://mp.weixin.qq.com/wiki/1/6239b44c206cab9145b1d52c67e6c551.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>发送消息-被动回复的加解密</td><td>-</td><td>公众号消息加解密是公众平台为了进一步加强公众号安全保障，提供的新机制。开发者需注意，公众账号主动调用API的情况将不受影响。只有被动回复用户的消息时，才需要进行消息加解密；详情<a href="https://mp.weixin.qq.com/wiki/14/70e73cedf9fd958d2e23264ba9333ad2.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>发送消息-客服消息</td><td>https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN</td><td>当用户和公众号产生特定动作的交互时（具体动作列表请见下方说明），微信将会把消息数据推送给开发者，开发者可以在一段时间内（目前修改为48小时）调用客服接口，通过POST一个JSON数据包来发送消息给普通用户。此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务；详情<a href="https://mp.weixin.qq.com/wiki/11/c88c270ae8935291626538f9c64bd123.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>发送消息-群发接口</td>
 *         <td>
 *             <ul>
 *                 <li>上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN</li>
 *                 <li>上传图文消息素材【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN</li>
 *                 <li>根据分组进行群发【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN</li>
 *                 <li>根据OpenID列表群发【订阅号不可用，服务号认证后可用】：https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN</li>
 *                 <li>删除群发【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN</li>
 *                 <li>预览接口【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN</li>
 *                 <li>查询群发消息发送状态【订阅号与服务号认证后均可用】：https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN</li>
 *             </ul>
 *         </td>
 *         <td>在公众平台网站上，为订阅号提供了每天一条的群发权限，为服务号提供每月（自然月）4条的群发权限。而对于某些具备开发能力的公众号运营者，可以通过高级群发接口，实现更灵活的群发能力；详情<a href="https://mp.weixin.qq.com/wiki/15/40b6865b893947b764e2de8e4a1fb55f.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>发送消息-模板消息接口</td>
 *         <td>
 *             <ul>
 *                 <li>设置所属行业：https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN</li>
 *                 <li>获取设置的行业信息：https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN</li>
 *                 <li>获得模板ID：https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN</li>
 *                 <li>获取模板列表：https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN</li>
 *                 <li>删除模板：https://api,weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN</li>
 *                 <li>发送模板消息：https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN</li>
 *                 <li>事件推送：在模版消息发送任务完成后，微信服务器会将是否送达成功作为通知，发送到开发者中心中填写的服务器配置地址中。</li>
 *             </ul>
 *         </td>
 *         <td>模板消息仅用于公众号向用户发送重要的服务通知，只能用于符合其要求的服务场景中，如信用卡刷卡通知，商品购买成功通知等。不支持广告等营销类消息以及其它所有可能对用户造成骚扰的消息。具体模板消息运营规则请读模板消息运营规范；详情<a href="https://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>模板消息运营规范</td><td.>-</td.><td>模板消息用来帮助公众号进行业务通知，是开发者在模板内容中设定参数（参数必须以“{ {”开头，且以“.DATA} }”结尾），并在调用时为这些参数赋值并发送的消息。模板消息的定位是用户触发后的通知消息，不允许在用户没做任何操作或未经用户同意接收的前提下，主动下发消息给用户。目前在特殊情况下允许主动下发的消息只有故障类和灾害警示警告类通知，除此之外都要经过用户同意或用户有触发行为才能下发模板消息。公众号只能在模板库中按照自己的行业来选择模板。如果模板库中暂时没有你想要的模板，则请你仔细阅读以下内容后，在满足要求的情况下，可以为你所在的行业贡献新模板，帮助充实模板库;详情<a href="https://mp.weixin.qq.com/wiki/18/8ecd0dfc9acafb2ed86ac3ae8f7c69aa.html">点击</a></td>
 *     </tr>
 *     <tr>
 *         <td>获取公众号自动回复配置</td><td>https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN</td><td>开发者可以通过该接口，获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复；详情<a href="https://mp.weixin.qq.com/wiki/8/806878e1fc2b9e9aa618ae33896b04c4.html">点击</a></td>
 *     </tr>
 * </table>
 * <ul>
 * </ul>
 * @author peiyu, Nottyjay, henrybit
 * @since 1.3
 * @version 2.0
 */
public class MessageAPI extends BaseAPI {

    /** private static start **/
    private static final Logger LOG = LoggerFactory.getLogger(MessageAPI.class);
    /** private static end **/

    /** protected static start **/
    /**发送客服消息*/
    protected static final String CUSTOMER_SERVICE_MESSAGE_API = BASE_API_URL+"cgi-bin/message/custom/send?access_token=#";
    /**上传图文消息内的图片获取URL【订阅号与服务号认证后均可用】*/
    protected static final String MASS_UPLOAD_MESSAGE_IMAGE_API = BASE_API_URL+"cgi-bin/media/uploadimg?access_token=#";
    /**上传图文消息素材【订阅号与服务号认证后均可用】*/
    protected static final String MASS_UPLOAD_MESSAGE_IMAGE_NEWS_API = BASE_API_URL+"cgi-bin/media/uploadnews?access_token=#";
    /**根据分组进行群发【订阅号与服务号认证后均可用】*/
    protected static final String MASS_GROUP_MESSAGE_SEND_API = BASE_API_URL+"cgi-bin/message/mass/sendall?access_token=#";
    /**根据OpenID列表群发【订阅号不可用，服务号认证后可用】*/
    protected static final String MASS_OPENID_MESSAGE_SEND_API = BASE_API_URL+"cgi-bin/message/mass/send?access_token=#";
    /**删除群发【订阅号与服务号认证后均可用】*/
    protected static final String MASS_DELETE_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/delete?access_token=#";
    /**预览接口【订阅号与服务号认证后均可用】*/
    protected static final String MASS_PREVIEW_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/preview?access_token=#";
    /**查询群发消息发送状态【订阅号与服务号认证后均可用】*/
    protected static final String MASS_QUERY_MESSAGE_API = BASE_API_URL+"cgi-bin/message/mass/get?access_token=#";
    /**设置所属行业*/
    protected static final String TEMPLATE_SET_INDUSTRY_API = BASE_API_URL+"cgi-bin/template/api_set_industry?access_token=#";
    /**获取设置的行业信息*/
    protected static final String TEMPLATE_GET_INDUSTRY_API = BASE_API_URL+"cgi-bin/template/get_industry?access_token=#";
    /**获得模板ID*/
    protected static final String TEMPLATE_GET_TEMPLATE_ID_API = BASE_API_URL+"cgi-bin/template/api_add_template?access_token=#";
    /**获取模板列表*/
    protected static final String TEMPLATE_GET_TEMPLATE_LIST_API = BASE_API_URL+"cgi-bin/template/get_all_private_template?access_token=#";
    /**删除一个模板*/
    protected static final String TEMPLATE_DELETE_TEMPLATE_API = BASE_API_URL+"cgi-bin/template/del_private_template?access_token=#";
    /**发送模板消息*/
    protected static final String TEMPLATE_SEND_MESSAGE_API = BASE_API_URL+"cgi-bin/message/template/send?access_token=#";
    /**获取公众号自动回复配置*/
    protected static final String GET_CURRENT_AUTOREPLY_API = BASE_API_URL+"cgi-bin/get_current_autoreply_info?access_token=#";

    /** protected static end **/

    public MessageAPI(ApiConfig config) {
        super(config);
    }

    public void sendCustomerServiceMessage() {
        LOG.debug("发送客服消息......");
        String url = BASE_API_URL + CUSTOMER_SERVICE_MESSAGE_API;
        Map<String, Object> params = new HashMap<String, Object>();

        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        //return JSONUtil.toBean(resultJson, GetSendMessageResponse.class);
    }

    /**
     * 群发消息给用户。
     * 本方法调用需要账户为微信已认证账户
     * @param message 消息主体
     * @param isToAll 是否发送给全部用户。false时需要填写groupId，true时可忽略groupId树形
     * @param groupId 群组ID
     * @param openIds 群发用户
     * @return 群发结果
     * @deprecated 微信不再建议使用群组概念,用标签代替
     */
    @Deprecated
    public GetSendMessageResponse sendMessageToUser(BaseMsg message, boolean isToAll, String groupId, String[] openIds){
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("群发消息......");
        //String url = BASE_API_URL + "cgi-bin/message/mass/sendall?access_token=#";
        String url = MASS_GROUP_MESSAGE_SEND_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("is_to_all", isToAll);
        if(!isToAll){
            BeanUtil.requireNonNull(groupId, "groupId is null");
            filterMap.put("group_id", groupId);
        }
        params.put("filter", filterMap);
        if(message instanceof MpNewsMsg){
            params.put("msgtype", "mpnews");
            MpNewsMsg msg = (MpNewsMsg)message;
            Map<String, Object> mpNews = new HashMap<String, Object>();
            mpNews.put("media_id", msg.getMediaId());
            params.put("mpnews", mpNews);
        }else if(message instanceof TextMsg){
            params.put("msgtype", "text");
            TextMsg msg = (TextMsg)message;
            Map<String ,Object> text = new HashMap<String, Object>();
            text.put("content", msg.getContent());
            params.put("text", text);
        }else if(message instanceof VoiceMsg){
            params.put("msgtype", "voice");
            VoiceMsg msg = (VoiceMsg)message;
            Map<String, Object> voice = new HashMap<String ,Object>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        }else if(message instanceof ImageMsg){
            params.put("msgtype", "image");
            ImageMsg msg = (ImageMsg)message;
            Map<String, Object> image = new HashMap<String, Object>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        }else if(message instanceof VideoMsg){
            // TODO 此处方法特别
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return JSONUtil.toBean(resultJson, GetSendMessageResponse.class);
    }

    /**
     * 群发消息给用户。
     * 本方法调用需要账户为微信已认证账户
     * @param message 消息主体
     * @param isToAll 是否发送给全部用户。false时需要填写tagId，true时可忽略tagId树形
     * @param tagId 标签ID
     * @return 群发结果
     */
    public GetSendMessageResponse sendMessageToUser(BaseMsg message, boolean isToAll, Integer tagId){
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("群发消息......");
        //String url = BASE_API_URL + "cgi-bin/message/mass/sendall?access_token=#";
        String url = MASS_GROUP_MESSAGE_SEND_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("is_to_all", isToAll);
        if(!isToAll){
            BeanUtil.requireNonNull(tagId, "tagId is null");
            filterMap.put("tag_id", tagId);
        }
        params.put("filter", filterMap);
        if(message instanceof MpNewsMsg){
            params.put("msgtype", "mpnews");
            MpNewsMsg msg = (MpNewsMsg)message;
            Map<String, Object> mpNews = new HashMap<String, Object>();
            mpNews.put("media_id", msg.getMediaId());
            params.put("mpnews", mpNews);
        }else if(message instanceof TextMsg){
            params.put("msgtype", "text");
            TextMsg msg = (TextMsg)message;
            Map<String ,Object> text = new HashMap<String, Object>();
            text.put("content", msg.getContent());
            params.put("text", text);
        }else if(message instanceof VoiceMsg){
            params.put("msgtype", "voice");
            VoiceMsg msg = (VoiceMsg)message;
            Map<String, Object> voice = new HashMap<String ,Object>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        }else if(message instanceof ImageMsg){
            params.put("msgtype", "image");
            ImageMsg msg = (ImageMsg)message;
            Map<String, Object> image = new HashMap<String, Object>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        }else if(message instanceof VideoMsg){
            // TODO 此处方法特别
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return JSONUtil.toBean(resultJson, GetSendMessageResponse.class);
    }

    /**
     * 发布客服消息
     *
     * @param openid  关注者ID
     * @param message 消息对象，支持各种消息类型
     * @return 调用结果
     */
    public ResultType sendCustomMessage(String openid, BaseMsg message) {
        BeanUtil.requireNonNull(openid, "openid is null");
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("发布客服消息......");
        String url = CUSTOMER_SERVICE_MESSAGE_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openid);
        if (message instanceof TextMsg) {
            TextMsg msg = (TextMsg) message;
            params.put("msgtype", "text");
            Map<String, String> text = new HashMap<String, String>();
            text.put("content", msg.getContent());
            params.put("text", text);
        } else if (message instanceof ImageMsg) {
            ImageMsg msg = (ImageMsg) message;
            params.put("msgtype", "image");
            Map<String, String> image = new HashMap<String, String>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        } else if (message instanceof VoiceMsg) {
            VoiceMsg msg = (VoiceMsg) message;
            params.put("msgtype", "voice");
            Map<String, String> voice = new HashMap<String, String>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        } else if (message instanceof VideoMsg) {
            VideoMsg msg = (VideoMsg) message;
            params.put("msgtype", "video");
            Map<String, String> video = new HashMap<String, String>();
            video.put("media_id", msg.getMediaId());
            video.put("thumb_media_id", msg.getMediaId());
            video.put("title", msg.getTitle());
            video.put("description", msg.getDescription());
            params.put("video", video);
        } else if (message instanceof MusicMsg) {
            MusicMsg msg = (MusicMsg) message;
            params.put("msgtype", "music");
            Map<String, String> music = new HashMap<String, String>();
            music.put("thumb_media_id", msg.getThumbMediaId());
            music.put("title", msg.getTitle());
            music.put("description", msg.getDescription());
            music.put("musicurl", msg.getMusicUrl());
            music.put("hqmusicurl", msg.getHqMusicUrl());
            params.put("music", music);
        } else if (message instanceof NewsMsg) {
            NewsMsg msg = (NewsMsg) message;
            params.put("msgtype", "news");
            Map<String, Object> news = new HashMap<String, Object>();
            List<Object> articles = new ArrayList<Object>();
            List<OldArticle> list = msg.getArticles();
            for (OldArticle article : list) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("title", article.getTitle());
                map.put("description", article.getDescription());
                map.put("url", article.getUrl());
                map.put("picurl", article.getPicUrl());
                articles.add(map);
            }
            news.put("articles", articles);
            params.put("news", news);
        } else if (message instanceof MpNewsMsg) {
            MpNewsMsg msg = (MpNewsMsg) message;
            params.put("msgtype", "mpnews");
            Map<String, String> news = new HashMap<String, String>();
            news.put("media_id", msg.getMediaId());
            params.put("mpnews", news);
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }
}