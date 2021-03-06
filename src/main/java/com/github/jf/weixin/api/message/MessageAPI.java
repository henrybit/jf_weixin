package com.github.jf.weixin.api.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.jf.weixin.entity.request.message.*;
import com.github.jf.weixin.entity.response.*;
import com.github.jf.weixin.entity.response.message.*;
import com.github.jf.weixin.exception.WeixinException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.JSONUtil;

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


    public MessageAPI(ApiConfig config) {
        super(config);
    }
    
    public MessageAPI(String accessToken) {
    	super(accessToken);
    }

    /**
     * 发送客服消息<br>
     * 支持消息类型：文本消息/图片消息(bmp/png/jpeg/jpg/gif)/语音消息-AMR格式/视频消息-MP4/音乐消息/图文消息（点击跳转到外链）/图文消息（点击跳转到图文消息页面）/卡券
     * @param customerServiceMessage 客服消息
     * @return ResultType-返回状态码
     */
    public ResultType sendCustomerServiceMessage(CustomerServiceMessage customerServiceMessage) {
        LOG.debug("发送客服消息......");
        String url = APIAddress.CUSTOMER_SERVICE_MESSAGE_API;
        BaseResponse response = executePost(url, customerServiceMessage.toJson());
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return ResultType.get(response.getErrcode());
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
    public SendMessageResponse sendMessageToUser(BaseRequestMessage message, boolean isToAll, String groupId, String[] openIds){
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("群发消息......");
        String url = APIAddress.MASS_GROUP_MESSAGE_SEND_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("is_to_all", isToAll);
        if(!isToAll){
            BeanUtil.requireNonNull(groupId, "groupId is null");
            filterMap.put("group_id", groupId);
        }
        params.put("filter", filterMap);
        if(message instanceof MPNewsMessage){
            params.put("msgtype", "mpnews");
            MPNewsMessage msg = (MPNewsMessage)message;
            Map<String, Object> mpNews = new HashMap<String, Object>();
            mpNews.put("media_id", msg.getMediaId());
            params.put("mpnews", mpNews);
        }else if(message instanceof TextMessage){
            params.put("msgtype", "text");
            TextMessage msg = (TextMessage)message;
            Map<String ,Object> text = new HashMap<String, Object>();
            text.put("content", msg.getContent());
            params.put("text", text);
        }else if(message instanceof VoiceMessage){
            params.put("msgtype", "voice");
            VoiceMessage msg = (VoiceMessage)message;
            Map<String, Object> voice = new HashMap<String ,Object>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        }else if(message instanceof ImageMessage){
            params.put("msgtype", "image");
            ImageMessage msg = (ImageMessage)message;
            Map<String, Object> image = new HashMap<String, Object>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        }else if(message instanceof VideoMessage){
            // TODO 此处方法特别
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return JSONUtil.parse(resultJson, SendMessageResponse.class);
    }

    /**
     * 群发消息给用户。<br>
     * 本方法调用需要账户为微信已认证账户
     * @param message 消息主体
     * @param isToAll 是否发送给全部用户。false时需要填写tagId，true时可忽略tagId树形
     * @param tagId 标签ID
     * @return 群发结果
     */
    public SendMessageResponse sendMessageToUser(BaseRequestMessage message, boolean isToAll, Integer tagId){
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("群发消息......");
        //String url = BASE_API_URL + "cgi-bin/message/mass/sendall?access_token=#";
        String url = APIAddress.MASS_GROUP_MESSAGE_SEND_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("is_to_all", isToAll);
        if(!isToAll){
            BeanUtil.requireNonNull(tagId, "tagId is null");
            filterMap.put("tag_id", tagId);
        }
        params.put("filter", filterMap);
        if(message instanceof MPNewsMessage){
            params.put("msgtype", "mpnews");
            MPNewsMessage msg = (MPNewsMessage)message;
            Map<String, Object> mpNews = new HashMap<String, Object>();
            mpNews.put("media_id", msg.getMediaId());
            params.put("mpnews", mpNews);
        }else if(message instanceof TextMessage){
            params.put("msgtype", "text");
            TextMessage msg = (TextMessage)message;
            Map<String ,Object> text = new HashMap<String, Object>();
            text.put("content", msg.getContent());
            params.put("text", text);
        }else if(message instanceof VoiceMessage){
            params.put("msgtype", "voice");
            VoiceMessage msg = (VoiceMessage)message;
            Map<String, Object> voice = new HashMap<String ,Object>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        }else if(message instanceof ImageMessage){
            params.put("msgtype", "image");
            ImageMessage msg = (ImageMessage)message;
            Map<String, Object> image = new HashMap<String, Object>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        }else if(message instanceof VideoMessage){
            // TODO 此处方法特别
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
        return JSONUtil.parse(resultJson, SendMessageResponse.class);
    }

    /**
     * 发布客服消息
     *
     * @param openid  关注者ID
     * @param message 消息对象，支持各种消息类型
     * @return 调用结果
     * @deprecated - V2.0以后版本将删除
     */
    public ResultType sendCustomMessage(String openid, BaseRequestMessage message) {
        BeanUtil.requireNonNull(openid, "openid is null");
        BeanUtil.requireNonNull(message, "message is null");
        LOG.debug("发布客服消息......");
        String url = APIAddress.CUSTOMER_SERVICE_MESSAGE_API;
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("touser", openid);
        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;
            params.put("msgtype", "text");
            Map<String, String> text = new HashMap<String, String>();
            text.put("content", msg.getContent());
            params.put("text", text);
        } else if (message instanceof ImageMessage) {
            ImageMessage msg = (ImageMessage) message;
            params.put("msgtype", "image");
            Map<String, String> image = new HashMap<String, String>();
            image.put("media_id", msg.getMediaId());
            params.put("image", image);
        } else if (message instanceof VoiceMessage) {
            VoiceMessage msg = (VoiceMessage) message;
            params.put("msgtype", "voice");
            Map<String, String> voice = new HashMap<String, String>();
            voice.put("media_id", msg.getMediaId());
            params.put("voice", voice);
        } else if (message instanceof VideoMessage) {
            VideoMessage msg = (VideoMessage) message;
            params.put("msgtype", "video");
            Map<String, String> video = new HashMap<String, String>();
            video.put("media_id", msg.getMediaId());
            video.put("thumb_media_id", msg.getMediaId());
            video.put("title", msg.getTitle());
            video.put("description", msg.getDescription());
            params.put("video", video);
        } else if (message instanceof MusicMessage) {
            MusicMessage msg = (MusicMessage) message;
            params.put("msgtype", "music");
            Map<String, String> music = new HashMap<String, String>();
            music.put("thumb_media_id", msg.getThumbMediaId());
            music.put("title", msg.getTitle());
            music.put("description", msg.getDescription());
            music.put("musicurl", msg.getMusicUrl());
            music.put("hqmusicurl", msg.getHqmusicUrl());
            params.put("music", music);
        } else if (message instanceof NewsMessage) {
            NewsMessage msg = (NewsMessage) message;
            params.put("msgtype", "news");
            Map<String, Object> news = new HashMap<String, Object>();
            List<Object> articles = new ArrayList<Object>();
            List<NewsMessage.Article> list = msg.getArticles();
            for (NewsMessage.Article article : list) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("title", article.getTitle());
                map.put("description", article.getDescription());
                map.put("url", article.getUrl());
                map.put("picurl", article.getPicUrl());
                articles.add(map);
            }
            news.put("articles", articles);
            params.put("news", news);
        } else if (message instanceof MPNewsMessage) {
            MPNewsMessage msg = (MPNewsMessage) message;
            params.put("msgtype", "mpnews");
            Map<String, String> news = new HashMap<String, String>();
            news.put("media_id", msg.getMediaId());
            params.put("mpnews", news);
        }
        BaseResponse response = executePost(url, JSONUtil.toJson(params));
        return ResultType.get(response.getErrcode());
    }

    /**
     * 根据OpenID列表群发<br>
     * <pre style="color:red;">
     *     请注意：在返回成功时，意味着群发任务提交成功，并不意味着此时群发已经结束，所以，仍有可能在后续的发送过程中出现异常情况导致用户未收到消息，如消息有时会进行审核、服务器不稳定等。此外，群发任务一般需要较长的时间才能全部发送完毕，请耐心等待。
     *     范例:{"errcode":0,"errmsg":"send job submission success","msg_id":34182,"msg_data_id": 206227730}
     * </pre>
     *<table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     *     <tbody>
     *         <tr><th style="width:240px">参数</th><th>说明</th></tr>
     *         <tr><td> type</td><td> 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），次数为news，即图文消息</td></tr>
     *         <tr><td> errcode</td><td> 错误码</td></tr>
     *         <tr><td> errmsg</td><td> 错误信息</td></tr>
     *         <tr><td> msg_id</td><td> 消息发送任务的ID</td></tr>
     *         <tr><td> msg_data_id</td><td> 消息的数据ID，，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。</td></tr>
     *         </tbody>
     *</table>
     * @param reqMsg 请求参数
     * @param openIds openId列表
     */
    public SendMessageResponse sendByOpenId(BaseRequestMessage reqMsg, String[] openIds) {
        String url = APIAddress.MASS_OPENID_MESSAGE_SEND_API;
        reqMsg.setToUser(openIds);
        try {
            BaseResponse response = executePost(url, reqMsg.toJson());
            String resultJson = isSuccess(response.getErrcode()) ? response.getErrmsg() : response.toJsonString();
            return JSONUtil.parse(resultJson, SendMessageResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除群发【订阅号与服务号认证后均可用】<br>
     * <p>请注意：</p>
     * <pre>1、只有已经发送成功的消息才能删除
     * 2、删除消息是将消息的图文详情页失效，已经收到的用户，还是能在其本地看到消息卡片。
     * 3、删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     * 4、如果多次群发发送的是一个图文消息，那么删除其中一次群发，就会删除掉这个图文消息也，导致所有群发都失效
     * </pre>
     * @param msgId 消息ID
     * @return ResultType-请求状态码
     */
    public ResultType deleteMassMessage(long msgId) {
        String url = APIAddress.MASS_DELETE_MESSAGE_API;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("msg_id",msgId);
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return ResultType.get(response.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     * 预览接口【订阅号与服务号认证后均可用】<br>
     * <pre>
     *     开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版。为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次），请勿滥用。
     * </pre>
     * @return PreviewMassMessageResponse-预览结果
     */
    public PreviewMassMessageResponse previewMassMessage(BaseRequestMessage reqMsg) {
        String url = APIAddress.MASS_PREVIEW_MESSAGE_API;
        try {
            BaseResponse response = executePost(url, reqMsg.toJson());
            return (PreviewMassMessageResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】<br>
     * @param msgId
     * @return
     */
    public GetMessageStatusResponse getMessageStatus(long msgId) {
        String url = APIAddress.MASS_QUERY_MESSAGE_API;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("msg_id",msgId);
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return (GetMessageStatusResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 设置行业可在MP中完成，每月可修改行业1次，账号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业<br>
     * <pre>只允许2个参数</pre>
     * <p>POST数据如下:</p>
     * <pre>{
     * "industry_id1":"1",
     * "industry_id2":"4"
     * }</pre>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     *     <tbody>
     *         <tr><th style="width:120px">参数</th><th style="width:120px">是否必须</th><th>说明</th></tr>
     *         <tr><td> industry_id1</td><td> 是</td><td> 公众号模板消息所属行业编号</td></tr>
     *         <tr><td> industry_id2</td><td> 是</td><td> 公众号模板消息所属行业编号</td></tr>
     *     </tbody>
     * </table>
     * @param industryList 行业所属编号集合
     * @return ResultType-调用结果
     */
    public ResultType setIndustrySetting(List<String> industryList) {
        String url = APIAddress.TEMPLATE_SET_INDUSTRY_API;
        Map<String, Object> params = new HashMap<String, Object>();
        try {
            if (industryList.size() > 2)
                throw new WeixinException("参数过多");
            for (int i=0; i<industryList.size(); i++) {
                params.put("industry_id"+(i+1), industryList.get(i));
            }
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return ResultType.get(response.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }


    /**
     * 获取设置的行业信息<br>
     * 获取失败将返回null<br>
     * <pre>
     * 返回response范例:
     * {"primary_industry":{"first_class":"运输与仓储","second_class":"快递"},"secondary_industry":{"first_class":"IT科技","second_class":"互联网|电子商务"}}
     * </pre>
     * @return GetIndustrySettingResponse-行业设置返回数据
     */
    public GetIndustrySettingResponse getIndustrySetting() {
        String url = APIAddress.TEMPLATE_GET_INDUSTRY_API;
        try {
            BaseResponse response = executePost(url, null);
            return (GetIndustrySettingResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得模板ID<br>
     * <pre>
     * 返回response范例:
     *  {"errcode":0,"errmsg":"ok","template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"}
     * </pre>
     * @param templateIdShort
     * @return GetTemplateIdResponse-获取模板ID结果
     */
    public GetTemplateIdResponse getTemplateID(String templateIdShort) {
        String url = APIAddress.TEMPLATE_GET_TEMPLATE_ID_API;
        Map<String, Object> params = new HashMap<String, Object>();
        try {
            params.put("template_id_short", templateIdShort);
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return (GetTemplateIdResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取模板列表<br>
     * <pre>
     * 返回response范例:
     * {
     * "template_list": [{
     * "template_id": "iPk5sOIt5X_flOVKn5GrTFpncEYTojx6ddbt8WYoV5s",
     * "title": "领取奖金提醒",
     * "primary_industry": "IT科技",
     * "deputy_industry": "互联网|电子商务",
     * "content": "{ {result.DATA} }\n\n领奖金额:{ {withdrawMoney.DATA} }\n领奖  时间:{ {withdrawTime.DATA} }\n银行信息:{ {cardInfo.DATA} }\n到账时间:  { {arrivedTime.DATA} }\n{ {remark.DATA} }",
     * "example": "您已提交领奖申请\n\n领奖金额：xxxx元\n领奖时间：2013-10-10 12:22:22\n银行信息：xx银行(尾号xxxx)\n到账时间：预计xxxxxxx\n\n预计将于xxxx到达您的银行卡"
     * }]
     * }
     * </pre>
     * @return GetTemplateListResponse-模板列表
     */
    public GetTemplateListResponse getTemplateList() {
        String url = APIAddress.TEMPLATE_GET_TEMPLATE_LIST_API;
        try {
            BaseResponse response = executePost(url, null);
            return (GetTemplateListResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除模板<br>
     * @param templateId 公众帐号下模板消息ID
     * @return ResultType-删除结果
     */
    public ResultType deleteTemplate(String templateId) {
        String url = APIAddress.TEMPLATE_DELETE_TEMPLATE_API;
        Map<String, Object> params = new HashMap<String, Object>();
        try {
            params.put("template_id", templateId);
            BaseResponse response = executePost(url, JSONUtil.toJson(params));
            return ResultType.get(response.getErrcode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultType.SYSTEM_UNKNOW;
    }

    /**
     * 发送模板消息<br>
     * <a href="https://mp.weixin.qq.com/wiki/18/8ecd0dfc9acafb2ed86ac3ae8f7c69aa.html">模板规范</a>
     * <pre>
     *  1、所有服务号都可以在功能-&gt;添加功能插件处看到申请模板消息功能的入口，但只有认证后的服务号才可以申请模板消息的使用权限并获得该权限；
     *  2、需要选择公众账号服务所处的2个行业，每月可更改1次所选行业；
     *  3、在所选择行业的模板库中选用已有的模板进行调用；
     *  4、每个账号可以同时使用25个模板。
     *  5、当前每个账号的模板消息的日调用上限为10万次，单个模板没有特殊限制。【2014年11月18日将接口调用频率从默认的日1万次提升为日10万次，可在MP登录后的开发者中心查看】。当账号粉丝数超过10W/100W/1000W时，模板消息的日调用上限会相应提升，以公众号MP后台开发者中心页面中标明的数字为准。
     *  </pre>
     *  <p>关于接口文档，请注意：</p>
     * <pre>
     * 1、模板消息调用时主要需要模板ID和模板中各参数的赋值内容；
     * 2、模板中参数内容必须以".DATA"结尾，否则视为保留字；
     * 3、模板保留符号"{{ }}"。
     * </pre>
     * @param templateMessage 模板消息
     * @return SendTemplateResponse-发送结果
     */
    public SendTemplateResponse sendTemplateMessage(TemplateMessage templateMessage) {
        String url = APIAddress.TEMPLATE_SEND_MESSAGE_API;
        try {
            BaseResponse response = executePost(url, JSONUtil.toJson(templateMessage));
            return (SendTemplateResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取自动回复配置信息<br>
     * 开发者可以通过该接口，获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复
     * <pre>
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自动回复配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2、本接口仅能获取公众号在公众平台官网的自动回复功能中设置的自动回复规则，若公众号自行开发实现自动回复，或通过第三方平台开发者来实现，则无法获取。
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5、本接口中返回的图片/语音/视频未临时素材（临时素材每次获取都不同，3天内有效，通过素材管理-获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理-获取永久素材接口来获取这些素材）。
     * </pre>
     * @return GetAutoReplyResponse-自动回复配置
     */
    public GetAutoReplyResponse getAutoReply() {
        String url = APIAddress.GET_CURRENT_AUTOREPLY_API;
        try {
            BaseResponse response = executePost(url, null);
            return (GetAutoReplyResponse)response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Object a = new Object();
        map.put("first", a);
        map.put("remark", a);
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setData(map);
        templateMessage.setTemplateId("1111");
        templateMessage.setUrl("http://www.baidu.com");
        System.out.println(JSONUtil.toJson(templateMessage));
    }
}
