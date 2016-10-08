package com.github.jf.weixin.api.account;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jf.weixin.api.BaseAPI;
import com.github.jf.weixin.config.APIAddress;
import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.entity.response.account.QrcodeResponse;
import com.github.jf.weixin.enums.QrcodeType;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.JSONUtil;
import com.github.jf.weixin.util.StringUtil;

/**
 * 账号管理-二维码相关API<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class QrcodeAPI extends BaseAPI {

    private static final Logger LOG = LoggerFactory.getLogger(QrcodeAPI.class);

    public QrcodeAPI(ApiConfig config) {
        super(config);
    }

    /**
     * 创建二维码<br>
     * <pre>
     * 1、临时二维码，是有过期时间的，<b>最长可以设置为在二维码生成后的30天（即2592000秒）后过期</b>，但能够生成较多数量。临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景
     * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
     * </pre>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
     *     <tr><td> expire_seconds</td><td> 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。</td></tr>
     *     <tr><td> action_name</td><td> 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值</td></tr>
     *     <tr><td> action_info</td><td> 二维码详细信息</td></tr>
     *     <tr><td> scene_id</td><td> 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）</td></tr>
     *     <tr><td> scene_str</td><td> 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段</td></tr>
     * </tbody></table>
     * @param actionName    二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @return 二维码对象
     */
    public QrcodeResponse createQrcode(QrcodeType actionName, String sceneId, Integer expireSeconds) {
        return createQrcode(actionName, sceneId, null, expireSeconds);
    }

    /**
     * 创建二维码<br>
     * <pre>
     * 1、临时二维码，是有过期时间的，<b>最长可以设置为在二维码生成后的30天（即2592000秒）后过期</b>，但能够生成较多数量。临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景
     * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。
     * </pre>
     * <table border="1" cellspacing="0" cellpadding="4" align="center" width="640px">
     * <tbody>
     *     <tr><th style="width:240px">参数</th><th>说明</th></tr>
     *     <tr><td> expire_seconds</td><td> 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。</td></tr>
     *     <tr><td> action_name</td><td> 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久,QR_LIMIT_STR_SCENE为永久的字符串参数值</td></tr>
     *     <tr><td> action_info</td><td> 二维码详细信息</td></tr>
     *     <tr><td> scene_id</td><td> 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）</td></tr>
     *     <tr><td> scene_str</td><td> 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段</td></tr>
     * </tbody></table>
     * @param actionName    二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param sceneStr      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，仅永久二维码支持此字段
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @return 二维码对象
     */
    public QrcodeResponse createQrcode(QrcodeType actionName, String sceneId, String sceneStr, Integer expireSeconds) {
        BeanUtil.requireNonNull(actionName, "actionName is null");
        BeanUtil.requireNonNull(sceneId, "actionInfo is null");

        LOG.debug("创建二维码信息.....");

        QrcodeResponse response = null;
        String url = APIAddress.ACCOUNT_CREATE_QRCODE_API;

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("action_name", actionName);
        Map<String, Object> actionInfo = new HashMap<String, Object>();
        Map<String, Object> scene = new HashMap<String, Object>();
        if (StringUtil.isNotBlank(sceneId))
            scene.put("scene_id", sceneId);
        if (StringUtil.isNotBlank(sceneStr))
            scene.put("scene_str", sceneStr);
        actionInfo.put("scene", scene);
        param.put("action_info", actionInfo);
        if (BeanUtil.nonNull(expireSeconds) && 0 != expireSeconds) {
            param.put("expire_seconds", expireSeconds);
        }
        BaseResponse r = executePost(url, JSONUtil.toJson(param));
        String resultJson = isSuccess(r.getErrcode()) ? r.getErrmsg() : r.toJsonString();
        response = JSONUtil.parse(resultJson, QrcodeResponse.class);
        return response;
    }
}
