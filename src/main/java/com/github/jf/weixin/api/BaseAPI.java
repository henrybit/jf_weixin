package com.github.jf.weixin.api;

import com.github.jf.weixin.config.ApiConfig;
import com.github.jf.weixin.enums.ResultType;
import com.github.jf.weixin.entity.response.BaseResponse;
import com.github.jf.weixin.util.BeanUtil;
import com.github.jf.weixin.util.CollectionUtil;
import com.github.jf.weixin.util.NetWorkCenter;

import java.io.File;
import java.util.List;

/**
 * API基类，提供一些通用方法<br>
 * 包含自动刷新token、通用get post请求等
 *<table border="1" cellspacing="0" cellpadding="4">
 *<tbody>
 *	<tr><th style="width:150px">接口名称</th><th>未认证订阅号</th><th>微信认证订阅号</th><th>未认证服务号</th><th>微信认证服务号</th></tr>
 *	<tr><td> 基础支持-获取access_token</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 基础支持-获取微信服务器IP地址</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 接收消息-验证消息真实性、接收普通消息、接收事件推送、接收语音识别结果</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 发送消息-被动回复消息</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 发送消息-客服接口</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 发送消息-群发接口</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 发送消息-模板消息接口（发送业务通知）</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-用户分组管理</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-设置用户备注名</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-获取用户基本信息</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-获取用户列表</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-获取用户地理位置</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 用户管理-网页授权获取用户openid/用户基本信息</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 推广支持-生成带参数二维码</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 推广支持-长链接转短链接</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 界面丰富-自定义菜单</td><td></td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 素材管理-素材管理接口</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 智能接口-语义理解接口</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 多客服-获取多客服消息记录、客服管理</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 微信支付接口</td><td></td><td></td><td></td><td> 需申请</td></tr>
 *	<tr><td> 微信小店接口</td><td></td><td></td><td></td><td> 需申请</td></tr>
 *	<tr><td> 微信卡券接口</td><td></td><td> 需申请</td><td></td><td> 需申请</td></tr>
 *	<tr><td> 微信设备功能接口</td><td></td><td></td><td></td><td> 需申请</td></tr>
 *	<tr><td> 微信JS-SDK-基础接口</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-分享接口</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-图像接口</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-音频接口</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-智能接口（网页语音识别）</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-设备信息</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-地理位置</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-界面操作</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-微信扫一扫</td><td> 有</td><td> 有</td><td> 有</td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-微信小店</td><td></td><td></td><td></td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-微信卡券</td><td></td><td> 有</td><td></td><td> 有</td></tr>
 *	<tr><td> 微信JS-SDK-微信支付</td><td></td><td></td><td></td><td> 有</td></tr>
 *</tbody>
 *</table>
 * @author peiyu,henrybit
 * @since 1.2
 * @version 2.0
 */
public abstract class BaseAPI {
	
	public static final String BASE_API_URL = "https://api.weixin.qq.com/";

    protected final ApiConfig config;

    /**
     * 构造方法，设置apiConfig
     *
     * @param config 微信API配置对象
     */
    protected BaseAPI(ApiConfig config) {
        this.config = config;
    }


    /**
     * 通用post请求
     *
     * @param url  地址，其中token用ACCESS_TOKEN代替
     * @param json 参数，json格式
     * @return 请求结果
     */
    protected BaseResponse executePost(String url, String json) {
        return executePost(url, json, null);
    }

    /**
     * 通用post请求
     *
     * @param url  地址，其中token用ACCESS_TOKEN代替
     * @param json 参数，json格式
     * @param file 上传的文件
     * @return 请求结果
     */
    protected BaseResponse executePost(String url, String json, File file) {
        BaseResponse response;
        BeanUtil.requireNonNull(url, "url is null");
        List<File> files = null;
        if (null != file) {
            files = CollectionUtil.newArrayList(file);
        }
        //需要传token
        String postUrl = url.replace("ACCESS_TOKEN", config.getAccessToken());
        response = NetWorkCenter.post(postUrl, json, files);
        return response;
    }


    /**
     * 通用get请求
     *
     * @param url 地址，其中token用ACCESS_TOKEN代替
     * @return 请求结果
     */
    protected BaseResponse executeGet(String url) {
        BaseResponse response;
        BeanUtil.requireNonNull(url, "url is null");
        //需要传token
        String getUrl = url.replace("ACCESS_TOKEN", config.getAccessToken());
        response = NetWorkCenter.get(getUrl);
        return response;
    }

    /**
     * 判断本次请求是否成功
     *
     * @param errCode 错误码
     * @return 是否成功
     */
    protected boolean isSuccess(String errCode) {
        return ResultType.SUCCESS.getCode().toString().equals(errCode);
    }
}
