package com.github.jf.weixin.api.datacube;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.entity.response.*;
import com.github.jf.weixin.entity.response.datacube.*;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.config.ApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据分析API<br>
 * <ul>
 *     <label>接口列表</label>
 *     <li>用户分析数据接口-获取用户增减数据(getUserSummary):https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN</li>
 *     <li>用户分析数据接口-获取累计用户数据(getUserCumulate):https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文群发每日数据(getArticleSummary):https://api.weixin.qq.com/datacube/getarticlesummary?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文群发总数据(getArticleTotal):https://api.weixin.qq.com/datacube/getarticletotal?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文统计数据(getUserRead):https://api.weixin.qq.com/datacube/getuserread?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文统计分时数据(getUserReadHour):https://api.weixin.qq.com/datacube/getuserreadhour?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文分享转发数据(getUserShare):	https://api.weixin.qq.com/datacube/getusershare?access_token=ACCESS_TOKEN</li>
 *     <li>图文分析数据接口-获取图文分享转发分时数据(getUserShareHour):https://api.weixin.qq.com/datacube/getusersharehour?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送概况数据(getUpstreamMsg):https://api.weixin.qq.com/datacube/getupstreammsg?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息分送分时数据(getUpstreamMsgHour):https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送周数据(getUpstreamMsgWeek):https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送月数据(getUpstreamMsgMonth):https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送分布数据(getUpstreamMsgDist):https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送分布周数据(getUpstreamMsgDistWeek):https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=ACCESS_TOKEN</li>
 *     <li>消息分析数据接口-获取消息发送分布月数据(getUpstreamMsgDistMonth):https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=ACCESS_TOKEN</li>
 *     <li>接口分析数据接口-获取接口分析数据(getInterfaceSummary):https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=ACCESS_TOKEN</li>
 *     <li>接口分析数据接口-获取接口分析分时数据(getInterfaceSummaryHour):https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=ACCESS_TOKEN</li>
 * </ul>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class DataCubeAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(DataCubeAPI.class);

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public DataCubeAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 获取用户增减数据，最大跨度为7天<br>
     * <pre>1、接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
     * 2、请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
     * </pre>
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 用户增减数据
     */
    public GetUserSummaryResponse getUserSummary(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUserSummaryResponse response = null;
        String url = APIAddress.USER_ANALYSE_SUMMARY_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserSummaryResponse.class);
        return response;
    }

    /**
     * 获取累计用户数据，最大跨度为7天
     * <pre>1、接口侧的公众号数据的数据库中仅存储了2014年12月1日之后的数据，将查询不到在此之前的日期，即使有查到，也是不可信的脏数据；
     * 2、请开发者在调用接口获取数据后，将数据保存在自身数据库中，即加快下次用户的访问速度，也降低了微信侧接口调用的不必要损耗。
     * </pre>
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 用户增减数据
     */
    public GetUserCumulateResponse getUserCumulate(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUserCumulateResponse response = null;
        String url = APIAddress.USER_ANALYSE_CUMULATE_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserCumulateResponse.class);
        return response;
    }

    /**
     * 获取图文群发每日数据<br>
     * @param day 查询日期
     * @return 图文群发每日数据
     */
    public GetArticleSummaryResponse getArticleSummary(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetArticleSummaryResponse response = null;
        String url = APIAddress.ARTICLE__SUMMARY_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetArticleSummaryResponse.class);
        return response;
    }

    /**
     * 获取图文群发总数据<br>
     * @param day 查询日期
     * @return 图文群发总数据
     */
    public GetArticleTotalResponse getArticleTotal(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetArticleTotalResponse response = null;
        String url = APIAddress.ARTICLE_TOTAL_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetArticleTotalResponse.class);
        return response;
    }

    /**
     * 获取图文统计数据，最大跨度为3天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 图文统计数据
     */
    public GetUserReadResponse getUserRead(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUserReadResponse response = null;
        String url = APIAddress.ARTICLE_USER_READ_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserReadResponse.class);
        return response;
    }

    /**
     * 获取图文统计分时数据<br>
     *
     * @param day 查询日期
     * @return 图文统计分时数据
     */
    public GetUserReadHourResponse getUserReadHour(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetUserReadHourResponse response = null;
        String url = APIAddress.ARTICLE_USER_READ_HOUR_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserReadHourResponse.class);
        return response;
    }

    /**
     * 获取图文分享转发数据，最大跨度为7天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 图文分享转发数据
     */
    public GetUserShareResponse getUserShare(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUserShareResponse response = null;
        String url = APIAddress.ARTICLE_USER_SHARE_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserShareResponse.class);
        return response;
    }

    /**
     * 获取图文分享转发分时数据<br>
     *
     * @param day 查询日期
     * @return 图文分享转发分时数据
     */
    public GetUserShareHourResponse getUserShareHour(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetUserShareHourResponse response = null;
        String url = APIAddress.ARTICLE_USER_SHARE_HOUR_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUserShareHourResponse.class);
        return response;
    }

    /**
     * 获取消息发送概况数据，最大跨度为7天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送概况数据
     */
    public GetUpstreamMsgResponse getUpstreamMsg(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgResponse.class);
        return response;
    }

    /**
     * 获取消息分送分时数据<br>
     *
     * @param day 查询日期
     * @return 消息分送分时数据
     */
    public GetUpstreamMsgHourResponse getUpstreamMsgHour(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetUpstreamMsgHourResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_HOUR_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgHourResponse.class);
        return response;
    }

    /**
     * 获取消息发送周数据，最大跨度为30天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送周数据
     */
    public GetUpstreamMsgWeekResponse getUpstreamMsgWeek(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgWeekResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_WEEK_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgWeekResponse.class);
        return response;
    }

    /**
     * 获取消息发送月数据，最大跨度为30天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送月数据
     */
    public GetUpstreamMsgMonthResponse getUpstreamMsgMonth(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgMonthResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_MONTH_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgMonthResponse.class);
        return response;
    }

    /**
     * 获取消息发送分布数据，最大跨度为15天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送分布数据
     */
    public GetUpstreamMsgDistResponse getUpstreamMsgDist(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgDistResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_DIST_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgDistResponse.class);
        return response;
    }

    /**
     * 获取消息发送分布周数据，最大跨度为30天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送分布周数据
     */
    public GetUpstreamMsgDistWeekResponse getUpstreamMsgDistWeek(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgDistWeekResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_DIST_WEEK_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgDistWeekResponse.class);
        return response;
    }

    /**
     * 获取消息发送分布月数据，最大跨度为30天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 消息发送分布月数据
     */
    public GetUpstreamMsgDistMonthResponse getUpstreamMsgDistMonth(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetUpstreamMsgDistMonthResponse response = null;
        String url = APIAddress.UPSTREAM_MSG_DIST_MONTH_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetUpstreamMsgDistMonthResponse.class);
        return response;
    }

    /**
     * 获取接口分析数据，最大跨度为30天<br>
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 接口分析数据
     */
    public GetInterfaceSummaryResponse getInterfaceSummary(Date beginDate, Date endDate) {
        BeanUtil.requireNonNull(beginDate, "beginDate is null");
        BeanUtil.requireNonNull(endDate, "endDate is null");
        GetInterfaceSummaryResponse response = null;
        String url = APIAddress.INTERFACESUMMARY_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(beginDate));
        param.put("end_date", DATE_FORMAT.format(endDate));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetInterfaceSummaryResponse.class);
        return response;
    }

    /**
     * 获取接口分析分时数据<br>
     *
     * @param day 查询日期
     * @return 接口分析分时数据
     */
    public GetInterfaceSummaryHourResponse getInterfaceSummaryHour(Date day) {
        BeanUtil.requireNonNull(day, "day is null");
        GetInterfaceSummaryHourResponse response = null;
        String url = APIAddress.INTERFACESUMMARY_HOUR_API;
        Map<String, String> param = new HashMap<String, String>();
        param.put("begin_date", DATE_FORMAT.format(day));
        param.put("end_date", DATE_FORMAT.format(day));
        String json = JSONUtil.toJson(param);
        BaseResponse r = executePost(url, json);
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, GetInterfaceSummaryHourResponse.class);
        return response;
    }
}
